package fr.kinstone.core.rank;

import fr.kinstone.core.utils.ItemBuilder;
import fr.kinstone.core.warp.WarpInventory;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class RankInventory implements InventoryProvider {

    @Getter
    static SmartInventory rankInventory = SmartInventory.builder()
            .id("")
            .provider(new RankInventory())
            .size(3, 9)
            .title("Grades disponible")
            .build();


    @Override
    public void init(Player player, InventoryContents inventoryContents) {

        inventoryContents.fillBorders(ClickableItem.empty(new ItemBuilder(Material.STAINED_GLASS_PANE).setName(" ").toItemStack()));

        for(RankEnum rankEnum : RankEnum.values()){
            inventoryContents.add(ClickableItem.of(new ItemBuilder(rankEnum.getMaterial()).setName("§eGrade: " + rankEnum.getName() + " §7- " + rankEnum.getPrice() + "$").setLore((rankEnum.getLore())).toItemStack(), e -> {
            }));
        }


    }

    @Override
    public void update(Player player, InventoryContents inventoryContents) {

    }
}
