package fr.kinstone.core;

import com.earth2me.essentials.Essentials;
import fr.kinstone.core.module.ModuleManager;
import fr.kinstone.core.utils.command.CommandFramework;
import fr.kinstone.core.utils.json.JsonFramework;
import fr.kinstone.core.warp.WarpCommand;
import fr.kinstone.core.warp.WarpListener;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Getter
    static Main instance;

    @Getter
    private CommandFramework commandFramework;

    @Getter
    private JsonFramework jsonFramework;

    @Getter
    private Essentials essentials;

    @Getter
    private ModuleManager moduleManager;

    @Override
    public void onEnable() {

        instance = this;
        getDataFolder().mkdir();
        commandFramework = new CommandFramework(this);
        essentials = (Essentials) Bukkit.getPluginManager().getPlugin("Essentials");

        moduleManager = new ModuleManager();
        moduleManager.enableAllModules();

        getServer().getPluginManager().registerEvents(new WarpListener(), this);

        jsonFramework = new JsonFramework(this);

    }

    @Override
    public void onDisable() {
        moduleManager.disableAllModules();
    }
}
