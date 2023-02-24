package com.github.carthax08.xegaparkour.levels.objects;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Level {

    private int yLevelReset;
    private List<Location> checkpoints;
    private Location startLocation;
    private Location endSign;
    private boolean lavaDamage;
    private boolean waterDamage;
    private HashMap<Effect, Integer> effects;
    private boolean hidden;
    private boolean announceCompletion;
    private String displayName;
    private double coinReward;
    private String permissionReward;
    public String configFileName;

    public Level(Player creatingPlayer, String name){
        yLevelReset = 0;
        checkpoints = new ArrayList<>();
        startLocation = creatingPlayer.getLocation();
        endSign = null;
        lavaDamage = false;
        waterDamage = false;
        effects = new HashMap<>();
        hidden = true;
        announceCompletion = true;
        displayName = name;
        coinReward = 0;
        permissionReward = "";

    }

}
