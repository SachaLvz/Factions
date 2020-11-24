package fr.kinstone.boutique.gui;

import fr.minuskube.inv.InventoryManager;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.SmartInvsPlugin;
import fr.minuskube.inv.opener.InventoryOpener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class BoutiqueGuiOpener implements InventoryOpener {


    @Override
    public Inventory open(SmartInventory smartInventory, Player player) {

        InventoryManager manager = SmartInvsPlugin.manager();
        Inventory handle = Bukkit.createInventory(player, smartInventory.getRows() * smartInventory.getColumns(), smartInventory.getTitle());

        fill(handle, manager.getContents(player).get());

        return handle;
    }

    @Override
    public boolean supports(InventoryType inventoryType) {
        return false;
    }
}
