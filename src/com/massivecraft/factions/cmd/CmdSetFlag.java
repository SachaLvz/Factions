package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.Conf;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.util.SpiralTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class CmdSetFlag extends FCommand {

    public CmdSetFlag(){

        this.aliases.add("setflag");

        senderMustBePlayer = true;
        senderMustBeMember = false;
        senderMustBeOfficer = false;
        senderMustBeLeader = true;

    }

    @Override
    public void perform() {

        Faction faction = this.argAsFaction(0, myFaction);

        if
        (
                ! fme.hasAdminMode()
                        &&
                        Conf.homesMustBeInClaimedTerritory
                        &&
                        Board.getFactionAt(new FLocation(me)) != faction
        )
        {
            fme.msg("<b>Désolé, vous pouvez que mettre votre drapeau dans votre territoire.");
            return;
        }

       /* if(!myFaction.canPutFactionBlock(fme.getPlayer().getLocation())){

            fme.msg("<i> Impossible de mettre le block de faction !");
            return;

        }*/

        Location loc = fme.getPlayer().getLocation();

        new SpiralTask(new FLocation(loc), 10) {

            @Override
            public boolean work() {

                FLocation fLocation = new FLocation(loc.getWorld().getName(), this.getX(), this.getZ());

                if (Board.getFactionAt(fLocation) != null) {

                }

                if (!(Bukkit.getWorld(loc.getWorld().getName()).getBlockAt(this.getX(), loc.getBlockY(), this.getZ()).getType() == Material.AIR)) {
                    this.stop();
                }

                Bukkit.getWorld(loc.getWorld().getName()).getBlockAt(loc).setType(Material.STANDING_BANNER);
                faction.setFlagLocation(fme.getPlayer().getLocation());
                return true;
            }
        };


        faction.msg("%s<i> vient de définir votre block de faction ", fme.describeTo(myFaction, true));
      //  myFaction.setFactionFlag(fme.getPlayer().getLocation());

    }
}
