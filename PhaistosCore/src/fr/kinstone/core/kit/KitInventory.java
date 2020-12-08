package fr.kinstone.core.kit;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.Kit;
import com.earth2me.essentials.Kits;
import com.earth2me.essentials.User;
import fr.kinstone.core.Main;
import fr.kinstone.core.utils.ItemBuilder;
import fr.kinstone.core.utils.Utils;
import fr.kinstone.core.warp.WarpInventory;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class KitInventory implements InventoryProvider {

    @Getter
    static SmartInventory kitInventory = SmartInventory.builder()
            .id("")
            .provider(new KitInventory())
            .size(4, 9)
            .title("Liste des kits")
            .build();


    @SneakyThrows
    @Override
    public void init(Player player, InventoryContents inventoryContents) {

        inventoryContents.fillBorders(ClickableItem.empty(new ItemBuilder(Material.STAINED_GLASS_PANE).setName(" ").toItemStack()));

        User user = Main.getInstance().getEssentials().getUser(player.getName());
        String[] listKits = Main.getInstance().getEssentials().getKits().listKits(Main.getInstance().getEssentials(), null).split(" ");


        for(String str : listKits){

            Bukkit.broadcastMessage(str + " : " + Utils.haveKits(str, player));

            inventoryContents.add(ClickableItem.of(new ItemBuilder( Material.STAINED_GLASS_PANE , 1, Utils.haveKits(str, player) ? (short) 5 : (short)14).setName("§eKit: §6" + str).setLore("", "§7Clique ici pour te §etéléporter !").toItemStack(), e -> {
                player.closeInventory();
            }));


        }
        
    }

    @Override
    public void update(Player player, InventoryContents inventoryContents) {

    }
}
