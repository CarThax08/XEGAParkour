package com.github.carthax08.xegaparkour.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.github.carthax08.xegaparkour.levels.LevelManager;
import org.bukkit.entity.Player;

import java.util.Arrays;

@CommandAlias("parkour|%custom")
public class ParkourCommand extends BaseCommand {

    @Default
    @Description("Main command for XEGAParkour. Primarily for admin/dev use.")
    public static void parkourCommand(Player player, String[] args) {
        //TODO: Ask Yung on discord if there will be any commands not under the "level" subcommand.
    }

    @Subcommand("level")
    @CommandPermission("parkour.admin")
    public static void levelManagement(Player player, String[] args) {
        if (args.length == 0) {
            player.sendMessage("Invalid Argument Length. Please use /parkour level help for more information.");
            return;
        }
        switch (args[0]) {
            case "create":
                if (args.length != 2) {
                    player.sendMessage("Please provide a level name.");
                    return;
                }
                LevelManager.createLevel(args[1], player);
                break;
            case "delete":
                if (args.length != 2) {
                    player.sendMessage("Please provide a level name.");
                    return;
                }
                LevelManager.deleteLevel(args[1], player);
                break;
        }
    }
}
