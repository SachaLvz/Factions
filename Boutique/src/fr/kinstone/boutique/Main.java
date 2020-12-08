package fr.kinstone.boutique;

import fr.kinstone.boutique.commands.BoutiqueCommand;
import fr.kinstone.boutique.commands.BoutiqueGivePointCommand;
import fr.kinstone.boutique.listeners.PlayerListeners;
import fr.kinstone.boutique.manager.BoutiqueManager;
import fr.kinstone.boutique.profile.ProfileManager;
import fr.kinstone.boutique.scoreboard.ScoreBoardListeners;
import fr.kinstone.boutique.utils.command.CommandFramework;
import fr.kinstone.boutique.utils.json.JsonFramework;
import fr.kinstone.boutique.utils.json.JsonPersist;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Getter
    static Main instance;

    @Getter
    CommandFramework commandFramework;

    @Getter
    JsonFramework jsonFramework;

    @Getter
    BoutiqueManager boutiqueManager;

    @Override
    public void onEnable() {

        instance = this;
        getDataFolder().mkdir();

        jsonFramework = new JsonFramework(this);
        jsonFramework.addPersist(new ProfileManager());

        jsonFramework.loadAllData();

        getServer().getPluginManager().registerEvents(new PlayerListeners(), this);
        getServer().getPluginManager().registerEvents(new ScoreBoardListeners(), this);

        commandFramework = new CommandFramework(this);
        commandFramework.registerCommands(new BoutiqueCommand());
        commandFramework.registerCommands(new BoutiqueGivePointCommand());

        boutiqueManager = new BoutiqueManager();





    }

    @Override
    public void onDisable() {

        jsonFramework.saveAllData(true);

    }
}
