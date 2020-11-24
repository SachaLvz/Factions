package fr.kinstone.boutique.listeners;

import fr.kinstone.boutique.profile.Profile;
import fr.kinstone.boutique.profile.ProfileManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListeners implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

          Player player = event.getPlayer();

          if(ProfileManager.getInstance().getProfile(player.getName()) == null){

              ProfileManager.getInstance().getProfiles().put(player.getName(), new Profile(player.getName()));

          }

    }

}
