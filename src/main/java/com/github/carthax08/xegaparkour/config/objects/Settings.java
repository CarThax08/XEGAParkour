package com.github.carthax08.xegaparkour.config.objects;

import com.clubobsidian.wrappy.inject.Node;

public class Settings {
    @Node("consolePrefix")
    private String consolePrefix;

    @Node("messagePrefix")
    private String messagePrefix;

    @Node("verbose")
    private boolean verbose;
    @Node("aliases")
    private String[] aliases;

    public String getConsolePrefix() {
        return consolePrefix;
    }

    public String getMessagePrefix() {
        return messagePrefix;
    }

    public boolean isVerbose() {
        return verbose;
    }

    public String[] getAliases() {
        return aliases;
    }
}
