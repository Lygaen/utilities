package fr.lygaen.utilities.utilities;


import fr.lygaen.utilities.utilities.broadcast.BroadcastCommand;
import fr.lygaen.utilities.utilities.loader.commands;
import fr.lygaen.utilities.utilities.loader.events;
import fr.lygaen.utilities.utilities.movements.MovementsCommand;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Utilities extends JavaPlugin {

    private static Utilities instance;



    @Override
    public void onEnable() {
        //---GETTING PLUGIN---
        instance = this;

        //---YML---
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //---Events---
        events.load();

        //---COMMANDS---
        commands.load();

        //---LOGS---
        getLogger().info("Plugin Utilities Enabled");
    }


    public static Utilities plugin() {
        return instance;
    }

}
