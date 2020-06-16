package fr.lygaen.utilities.utilities;

import fr.lygaen.utilities.utilities.loader.commands;
import fr.lygaen.utilities.utilities.loader.events;
import org.bukkit.ChatColor;
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
        getLogger().info(ChatColor.GREEN + "Plugin Utilities Enabled");
    }


    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED + "Plugin Utilities Disabled");
    }

    public static Utilities plugin() {
        return instance;
    }

}
