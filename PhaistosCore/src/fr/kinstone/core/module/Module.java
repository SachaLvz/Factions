package fr.kinstone.core.module;

import fr.kinstone.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public abstract class Module {

    public void moduleEnable() {}
    public void moduleDisable() {}

    public void registerCommand(Object cmd){Main.getInstance().getCommandFramework().registerCommands(cmd);};
    public void registerListener(Listener listener){Bukkit.getServer().getPluginManager().registerEvents(listener, Main.getInstance());}

}
