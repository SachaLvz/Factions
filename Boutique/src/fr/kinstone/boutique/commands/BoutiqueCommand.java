package fr.kinstone.boutique.commands;

import fr.kinstone.boutique.gui.BoutiqueGui;
import fr.kinstone.boutique.utils.command.Command;
import fr.kinstone.boutique.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class BoutiqueCommand {

    @Command(name="boutique", permission = "default")
    public void onBoutiqueCommand(CommandArgs args){

        Player player = args.getPlayer();

        if(args.getArgs().length > 0){

            player.sendMessage("§c/boutique");
            return;

        }

        BoutiqueGui.getInventory().open(player);

    }

}
