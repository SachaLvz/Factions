package fr.kinstone.core.warp;

import com.earth2me.essentials.User;
import com.earth2me.essentials.Warps;
import fr.kinstone.core.Main;
import fr.kinstone.core.utils.ItemBuilder;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class WarpInventory implements InventoryProvider {

    @Getter
    static SmartInventory inventory = SmartInventory.builder()
            .id("")
            .provider(new WarpInventory())
            .size(3, 9)
            .title("Liste des warps")
            .build();


    @Override
    public void init(Player player, InventoryContents inventoryContents) {

        inventoryContents.fillBorders(ClickableItem.empty(new ItemBuilder(Material.STAINED_GLASS_PANE).setName(" ").toItemStack()));

        Warps warps = Main.getInstance().getEssentials().getWarps();


        for(String warp : Main.getInstance().getEssentials().getWarps().getList())
        inventoryContents.add(ClickableItem.of(new ItemBuilder(Material.BED).setName("§eWarp: §6" + warp).setLore("", "§7Clique ici pour te §etéléporter !").toItemStack(), e -> {
                    player.performCommand("warp " + warp);
                    player.closeInventory();
        }));

    }

    @Override
    public void update(Player player, InventoryContents inventoryContents) {

    }
}
