package com.github.carthax08.xegaparkour.levels;

import com.github.carthax08.xegaparkour.PluginMain;
import com.github.carthax08.xegaparkour.levels.objects.Level;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class LevelManager {

    private static Map<String, Level> levels = new HashMap<>();
    public static void createLevel(String levelName, Player creatingPlayer) {
        levels.put(levelName, new Level(creatingPlayer, levelName));
        creatingPlayer.sendMessage(PluginMain.mainSettings.getMessagePrefix() + " Level " + levelName + " created!");
    }

    public static void deleteLevel(String levelName, Player deletingPlayer) {
        Level level = levels.get(levelName);
        if (level == null) {
            deletingPlayer.sendMessage(PluginMain.mainSettings.getMessagePrefix() + " Level " + levelName + " does not exist!");
            return;
        }
        levels.remove(levelName);
        File file = new File(PluginMain.getInstance().getDataFolder() + "levels/" + level.configFileName + ".yml");
        if(file.exists()) {
            if (!file.delete()) {
                deletingPlayer.sendMessage(PluginMain.mainSettings.getMessagePrefix() + " Level " + levelName + "'s config file could not be deleted! Please delete it manually.");
            }
        }
        deletingPlayer.sendMessage(PluginMain.mainSettings.getMessagePrefix() + " Level " + levelName + " deleted!");
    }
}
