package fr.kinstone.boutique.scoreboard;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.IEssentials;
import com.earth2me.essentials.User;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;
import com.massivecraft.factions.zcore.MPlugin;
import fr.kinstone.boutique.Main;
import fr.kinstone.boutique.profile.ProfileManager;
import net.milkbowl.vault.permission.plugins.Permission_PermissionsEx;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.util.*;

public class ScoreBoardListeners implements Listener {

    private final Map<String, FastBoard> boards = new HashMap<>();
    private FastBoard fastBoard;

    public ScoreBoardListeners(){

        Bukkit.getServer().getScheduler().runTaskTimer(Main.getInstance(), () -> {
            for (FastBoard board : boards.values()) {
                updater(board);
            }
        }, 0, 100);

    }

    @EventHandler
    public  void onPlayerJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();
         FastBoard fastBoard = new FastBoard(event.getPlayer());

        boards.put(player.getName(), fastBoard);
    }

    public void onPlayerQuit(PlayerQuitEvent event){

        Player player = event.getPlayer();

        FastBoard board = boards.remove(player.getName());

        if(board != null)
        board.delete();
    }

    public void updater(FastBoard fastBoard){

        Player player = fastBoard.getPlayer();

        String title = "&ePhaistos";

        PermissionUser user = PermissionsEx.getUser(player.getName());
        Essentials essentials = (Essentials) Bukkit.getPluginManager().getPlugin("Essentials");
        FPlayer fPlayer = FPlayers.i.get(player.getName());
        String rank = user.getGroups() == null ? "Aucun" : user.getGroupsNames()[0];

        List<String> scoreboard = new ArrayList<>();
        scoreboard.add("");
        scoreboard.add(ChatColor.translateAlternateColorCodes('&' , "&6Profil"));
        scoreboard.add(ChatColor.translateAlternateColorCodes('&' , "    &7Pseudo : &e" + player.getName()));
        scoreboard.add(ChatColor.translateAlternateColorCodes('&' , "    &7Grade : &e" + rank));
        scoreboard.add(ChatColor.translateAlternateColorCodes('&' , "    &7Argent : &e" + essentials.getUser(player.getName()).getMoney()));
        scoreboard.add(ChatColor.translateAlternateColorCodes('&' , "    &7BoutiqueCoins : &6" + ProfileManager.getInstance().getProfile(player.getName()).getPoints()));
        scoreboard.add(ChatColor.translateAlternateColorCodes('&' , "&6Faction"));
        scoreboard.add(ChatColor.translateAlternateColorCodes('&' , "    &7Nom : &6" + fPlayer.getFaction().getTag()));
        scoreboard.add(ChatColor.translateAlternateColorCodes('&' , "    &7Power : &e" + fPlayer.getPower() + "&7/&6" + fPlayer.getPowerMax()));
        scoreboard.add("");
        scoreboard.add(ChatColor.translateAlternateColorCodes('&' , "&6play.phaistos.fr"));

        fastBoard.updateTitle(ChatColor.translateAlternateColorCodes('&' , title));
        fastBoard.updateLines(scoreboard);


    }


}
