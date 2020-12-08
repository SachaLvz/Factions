package fr.kinstone.core.module;

import fr.kinstone.core.rank.RankManager;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    private List<Module> moduleList;

    public ModuleManager(){

        moduleList = new ArrayList<>();

    }

    public void enableAllModules(){

        moduleList.add(new RankManager());

        for(Module module : moduleList){
            module.moduleEnable();
        }

        Bukkit.broadcastMessage("§c" + moduleList.size() + "§e module(s) chargé(s)");

    }

    public void disableAllModules(){

        for(Module module : moduleList){
            module.moduleDisable();
        }

    }



}
