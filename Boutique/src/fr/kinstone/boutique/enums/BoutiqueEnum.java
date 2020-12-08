package fr.kinstone.boutique.enums;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum BoutiqueEnum {

    // GRADE

    ARISTOCRATE("Aristocrate", BoutiqueType.GRADES, 500, "group set Aristocrate", Material.WOOD_SWORD),
    HERMES("Hermes", BoutiqueType.GRADES, 1000, "group set Hermes", Material.STONE_SWORD),
    ARES("Ares", BoutiqueType.GRADES, 1500, "group set Ares", Material.IRON_SWORD),
    ADES("Ades", BoutiqueType.GRADES, 2500, "group set Ades", Material.GOLD_SWORD),
    ZEUS("Zeus", BoutiqueType.GRADES, 3500, "group set Zeus", Material.DIAMOND_SWORD),

    // KITS

    ENCHANTEUR("Enchanteur", BoutiqueType.KITS, 500, "add essentials.kits.enchanteur", Material.ENCHANTMENT_TABLE),
    POTION("Potion", BoutiqueType.KITS, 500, "add essentials.kits.potion", Material.POTION),
    CONSTRUCTION("Construction", BoutiqueType.KITS, 500, "add essentials.kits.construction", Material.WORKBENCH),
    ALCHIMISTE("Alchimiste", BoutiqueType.KITS, 700, "add essentials.kits.alchimiste", Material.BREWING_STAND),
    PILLAGE("Pillage", BoutiqueType.KITS, 700, "add essentials.kits.pillage", Material.TNT),
    EXPLORATEUR("Explorateur", BoutiqueType.KITS, 1000, "add essentials.kits.explorateur", Material.MAP),
    OBSI("Obsi", BoutiqueType.KITS, 1200, "add essentials.kits.obsidienne", Material.OBSIDIAN),
    PVP("Pvp", BoutiqueType.KITS, 2000, "add essentials.kits.pvp", Material.DIAMOND_SWORD),

    // KEYS

 //   ZEUS("Zeus", BoutiqueType.KEY, 2000, ""),
    ARISTOTE("Aristote", BoutiqueType.KEYS, 500, "", Material.NAME_TAG),
    PERICLES("Pericles", BoutiqueType.KEYS, 1500, "", Material.NAME_TAG),
    PLATON("Platon", BoutiqueType.KEYS, 8000, "", Material.NAME_TAG),

    COCHON("Cochon", BoutiqueType.SPAWNERS, 250, "", Material.MOB_SPAWNER),
    VACHE("Vache", BoutiqueType.SPAWNERS, 250, "", Material.MOB_SPAWNER),
    POULET("Poulet", BoutiqueType.SPAWNERS, 250, "", Material.MOB_SPAWNER),
    SQUELETTE("Squelette", BoutiqueType.SPAWNERS, 300, "", Material.MOB_SPAWNER),
    ZOMBIE("Zombie", BoutiqueType.SPAWNERS, 300, "", Material.MOB_SPAWNER),
    ARAIGNEE("Araignee", BoutiqueType.SPAWNERS, 350, "", Material.MOB_SPAWNER),
    BLAZE("Blaze", BoutiqueType.SPAWNERS, 400, "", Material.MOB_SPAWNER),
    PIGZOMBIE("PigZombie", BoutiqueType.SPAWNERS, 400, "", Material.MOB_SPAWNER),
    ENDERMAN("Enderman", BoutiqueType.SPAWNERS, 800, "", Material.MOB_SPAWNER),
    GOLEM("Golem", BoutiqueType.SPAWNERS, 900, "", Material.MOB_SPAWNER),

    // BOOSTS

    POWER("Power", BoutiqueType.BOOSTS, 500, "", Material.NETHER_STAR),
    METIERSX2("Metier x2", BoutiqueType.BOOSTS, 250, "", Material.GOLD_HOE),
    METIERSX3("Metier x3", BoutiqueType.BOOSTS, 380, "", Material.GOLD_HOE),
    METIERSX4("Metier x4", BoutiqueType.BOOSTS, 500, "", Material.GOLD_HOE),
    XPX2("Xp x2", BoutiqueType.BOOSTS, 300, "", Material.EXP_BOTTLE),
    XPX3("Xp x3", BoutiqueType.BOOSTS, 600, "", Material.EXP_BOTTLE),
    XPX4("Xp x4", BoutiqueType.BOOSTS, 1100, "", Material.EXP_BOTTLE),

    // ATOUTS

    HASTE("Haste", BoutiqueType.ATOUTS, 750, "", Material.WOOD_PICKAXE),
    HASTE2("Haste II", BoutiqueType.ATOUTS, 1000, "", Material.WOOD_PICKAXE),
    SPEED2("Speed II", BoutiqueType.ATOUTS, 1300, "", Material.SUGAR),
    FIRERESISTANCE("Fire Resistance", BoutiqueType.ATOUTS, 1300, "", Material.MAGMA_CREAM),
    JUMPBOOST("JumpBoost", BoutiqueType.ATOUTS, 1000, "", Material.RABBIT_FOOT),
    FORCE("Force I", BoutiqueType.ATOUTS, 1300, "", Material.POTION),

    // PERMISSIONS

    REPAIR("/repair", BoutiqueType.PERMISSIONS, 300, "", Material.PAPER),
    BACK("/back", BoutiqueType.PERMISSIONS, 500, "", Material.PAPER),
    CRAFT("/craft", BoutiqueType.PERMISSIONS, 500, "", Material.PAPER),
    FEED("/feed", BoutiqueType.PERMISSIONS, 500, "", Material.PAPER),
    ENDERCHEST("/enderchest", BoutiqueType.PERMISSIONS, 500, "", Material.PAPER),
    HAT("/hat", BoutiqueType.PERMISSIONS, 750, "", Material.PAPER),
    NEAR("/near", BoutiqueType.PERMISSIONS, 1000, "", Material.PAPER),
    REPAIRALL("/repairall", BoutiqueType.PERMISSIONS, 1500, "", Material.PAPER);

    private String name;
    private BoutiqueType boutiqueType;
    private double price;
    private String command;
    private Material material;
    private String[] lore;

    BoutiqueEnum(String name, BoutiqueType boutiqueType, double price, String command, Material material){
      this.name = name;
      this.boutiqueType = boutiqueType;
      this.price = price;
      this.command = command;
      this.material = material;
    }

    BoutiqueEnum(String name, BoutiqueType boutiqueType, double price, String command, Material material, String[] lore){
        this.name = name;
        this.boutiqueType = boutiqueType;
        this.price = price;
        this.command = command;
        this.material = material;
        this.lore = lore;
    }



}
