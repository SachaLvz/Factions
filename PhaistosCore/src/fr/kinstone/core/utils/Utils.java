package fr.kinstone.core.utils;

import com.earth2me.essentials.Kit;
import fr.kinstone.core.Main;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Utils {

    public static ArrayList<String> getKits(Player player){
        ArrayList<String> list = new ArrayList<String>();
        for(String kitName: Main.getInstance().getEssentials().getSettings().getKits().getKeys(false)){

            if(player.hasPermission("essentials.kits." + kitName) || player.hasPermission("essentials.kits.*")){
                list.add(kitName);
            }

        }
        return list;
    }

    public static boolean haveKits(String kitName, Player player){

        if(player.hasPermission("essentials.kits." + kitName) || player.hasPermission("essentials.kits.*")){
                return true;
            }
        return false;
    }

}
