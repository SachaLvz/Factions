package fr.kinstone.core.rank;

import lombok.Getter;
import org.bukkit.Material;

@Getter
public enum RankEnum {

    ARISTOCRATE("Aristocrate", 400000, "group set Aristocrate", Material.WOOD_SWORD, new String[]{"", "§8➤ §9Grade à vie", "", "§8• §6Accès à 3 homes", "§8• §6Accès au §9Kit Aristocrate §7(Délai de 12H)", "§8• §6Accès à la commande §a/craft", "§8• §6Accès à la commande §a/feed", "", "§8➤ §aPlus les avantages du grade précédent", "", "§8➤ §6Prix: §4500§4PB"}),
    HERMES("Hermes", 10000000, "group set Hermes", Material.STONE_SWORD, new String[]{"", ""}),
    ARES("Ares", 2500000, "group set Ares", Material.IRON_SWORD, new String[]{"", ""}),
    ADES("Ades",  45000000, "group set Ades", Material.GOLD_SWORD, new String[]{"", ""}),
    ZEUS("Zeus",  10000000, "group set Zeus", Material.DIAMOND_SWORD, new String[]{"", ""});

    private String name;
    private int price;
    private String command;
    private Material material;
    private String[] lore;

    RankEnum(String name, int price, String command, Material material, String[] lore){
        this.name = name;
        this.price = price;
        this.command = command;
        this.material = material;
        this.lore = lore;
    }
    
}
