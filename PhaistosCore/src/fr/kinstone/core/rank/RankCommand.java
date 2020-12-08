package fr.kinstone.core.rank;

import fr.kinstone.core.utils.command.Command;
import fr.kinstone.core.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class RankCommand {

    @Command(name="rankup", permission = "")
    public void onRankupCommand(CommandArgs args){

        Player player = args.getPlayer();

        if(args.getArgs().length > 0){

            player.sendMessage("§c/rankup");
            return;

        }
    }

    @Command(name = "grades", permission = "")
    public void onGradesCmd(CommandArgs args){

        Player player = args.getPlayer();

        if(args.getArgs().length > 1){

            player.sendMessage("§c/rankup");
            return;

        }

        RankInventory.getRankInventory().open(player);
    }

}
