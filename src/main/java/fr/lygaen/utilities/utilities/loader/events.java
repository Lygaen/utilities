package fr.lygaen.utilities.utilities.loader;

import fr.lygaen.utilities.utilities.Utilities;
import fr.lygaen.utilities.utilities.events.onjoin;
import org.bukkit.Bukkit;

public class events {

    static Utilities plugin = Utilities.plugin();

    public static void load() {
        Bukkit.getPluginManager().registerEvents(new onjoin(), plugin);
    }
    
}