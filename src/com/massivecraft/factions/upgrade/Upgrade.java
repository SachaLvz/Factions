package com.massivecraft.factions.upgrade;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Upgrade {

    private Faction faction;
    private String upgradeName;
    private int maxLevel;
    private int level;

    public Upgrade(Faction faction, String upgradeName, UpgradeType upgradeType, int level) {
        this.faction = faction;
        this.upgradeName = upgradeName;
        this.maxLevel = maxLevel;
        this.level = level;
    }

    public boolean canUpgrade(){
        if(level > maxLevel)
            return false;
        
        return true;
    }
}
