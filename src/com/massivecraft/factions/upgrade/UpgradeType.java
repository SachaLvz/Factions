package com.massivecraft.factions.upgrade;

public enum UpgradeType {

    CLAIM("Augmentation claims", new String[]{"Permet d'augmenter les claims", ""}, 10);

    private String name;
    private String[] description;
    private int maxLevel;


    UpgradeType(String name, String[] description, int maxLevel) {
        this.name = name;
        this.description = description;
        this.maxLevel = maxLevel;
    }
}
