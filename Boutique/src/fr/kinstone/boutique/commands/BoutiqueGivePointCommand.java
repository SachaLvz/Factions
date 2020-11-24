package fr.kinstone.boutique.commands;

import fr.kinstone.boutique.profile.Profile;
import fr.kinstone.boutique.profile.ProfileManager;
import fr.kinstone.boutique.utils.command.Command;
import fr.kinstone.boutique.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BoutiqueGivePointCommand {

    @Command(name = "boutique.givepoint")
    public void onGivePointCmd(CommandArgs args){

        Player player = args.getPlayer();

        if(args.getArgs().length > 2 || args.getArgs().length < 2){

            player.sendMessage("/boutique givepoint <player> <points>");
            return;

        }

        Player target = Bukkit.getPlayer(args.getArgs(0));

        if(target == null){

            player.sendMessage("§eLe joueur §c" + args.getArgs(0) + "§e est introuvable");
            return;

        }

        try {

            int givePoint = Integer.parseInt(args.getArgs(1));

            if(givePoint < 1){

                player.sendMessage("§cIl est impossible de donner 0 point");
                return;

            }

            Profile profile = ProfileManager.getInstance().getProfile(target.getName());

            if(profile == null){

                player.sendMessage("§cErreur !");
                return;

            }

            profile.setPoints(profile.getPoints() + givePoint);
            player.sendMessage("§eVous avez bien donné §c" + givePoint + "§e à §c" + target.getName());



        } catch (NumberFormatException e){

            player.sendMessage("§c" + args.getArgs(1) + "§e n'est pas un nombre !");

        }

    }

}
