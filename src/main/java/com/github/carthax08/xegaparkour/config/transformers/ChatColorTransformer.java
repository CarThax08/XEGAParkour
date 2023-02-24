package com.github.carthax08.xegaparkour.config.transformers;

import com.clubobsidian.wrappy.transformer.NodeTransformer;
import org.bukkit.ChatColor;

public class ChatColorTransformer extends NodeTransformer<String>{

    public ChatColorTransformer(Class<String> clazz) {
        super(clazz);
    }

    @Override
    public String transform(String transform) {
        return ChatColor.translateAlternateColorCodes('&', transform);
    }
}
