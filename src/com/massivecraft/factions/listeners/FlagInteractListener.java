package com.massivecraft.factions.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class FlagInteractListener implements Listener {

    @EventHandler
    public void onInteractWithFlag(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if(player == null) return;

    }

}
