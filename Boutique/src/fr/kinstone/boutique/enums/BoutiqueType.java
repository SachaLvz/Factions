package fr.kinstone.boutique.enums;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@Getter
public enum BoutiqueType {

    GRADES(Material.DIAMOND_CHESTPLATE, "Grades"),
    KITS(Material.DIAMOND_PICKAXE, "Kits"),
    KEYS(Material.BLAZE_ROD,"Clés"),
    SPAWNERS(Material.MOB_SPAWNER, "Spawners"),
    BOOSTS(Material.NETHER_STAR, "Boost"),
    ATOUTS(Material.POTION, "Atouts"),
    PERMISSIONS(Material.PAPER, "Permissions");

    private Material material;
    private String name;

    BoutiqueType(Material material, String name){
        this.material = material;
        this.name = name;
    }

}
