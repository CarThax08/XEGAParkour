package com.github.carthax08.xegaparkour;

import co.aikar.commands.PaperCommandManager;
import com.clubobsidian.wrappy.Configuration;
import com.clubobsidian.wrappy.transformer.NodeTransformer;
import com.github.carthax08.xegaparkour.commands.ParkourCommand;
import com.github.carthax08.xegaparkour.config.objects.Settings;
import com.github.carthax08.xegaparkour.config.transformers.ChatColorTransformer;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public final class PluginMain extends JavaPlugin {

    private Logger logger;
    private Configuration config;
    public static Settings mainSettings;
    private String consolePrefix;
    private static PluginMain instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        logger = getLogger();
        saveResource("config.conf", false);
        File file = new File(getDataFolder(), "config.conf");
        config = Configuration.load(file);
        List<NodeTransformer> transformers = new ArrayList<>();
        transformers.add(new ChatColorTransformer(String.class));
        mainSettings = new Settings();
        config.getConfigurationSection("settings").inject(mainSettings, transformers);
        consolePrefix = mainSettings.getConsolePrefix();
        boolean v = mainSettings.isVerbose();
        logger.info(consolePrefix + " Initializing plugin...");
        if(v){
            logger.info(consolePrefix + " NOTE: Plugin is running in verbose mode. Extra information will be logged to the console.");
            logger.info(consolePrefix + " As well, commands will send the user messages for debugging purposes.");
            logger.info(consolePrefix + " This is not recommended for production use. Disable verbose mode in the config to remove these messages.");
        }
        initCommands(v);
    }

    private void initCommands(boolean v) {
        logger.info(consolePrefix + " Initializing commands...");
        PaperCommandManager commandManager = new PaperCommandManager(this);

        if(v){
            logger.info(consolePrefix + " Enabling unstable API 'help' for ACF");
        }
        commandManager.enableUnstableAPI("help");
        if(v){
            logger.info(consolePrefix + " Adding custom aliases for /parkour");
        }
        commandManager.getCommandReplacements().addReplacement("custom", String.join("|", mainSettings.getAliases()));
        if(v){
            logger.info(consolePrefix + " Registering /parkour as a command");
        }
        commandManager.registerCommand(new ParkourCommand());
        logger.info(consolePrefix + " Commands initialized...");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static PluginMain getInstance(){
        return instance;
    }
}
