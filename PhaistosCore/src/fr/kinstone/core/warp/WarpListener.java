package fr.kinstone.core.warp;

import fr.kinstone.core.kit.KitInventory;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class WarpListener implements Listener {

    @EventHandler
    public void onWarpCommand(PlayerCommandPreprocessEvent event){

        if(event.getMessage().equalsIgnoreCase("/warp")){

            WarpInventory.getInventory().open(event.getPlayer());
            event.setCancelled(true);

        } else if(event.getMessage().equalsIgnoreCase("/kits")){

            KitInventory.getKitInventory().open(event.getPlayer());
            event.setCancelled(true);

        }

    }

}
