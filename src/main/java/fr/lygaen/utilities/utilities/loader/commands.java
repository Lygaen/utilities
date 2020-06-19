package fr.lygaen.utilities.utilities.loader;

import fr.lygaen.utilities.utilities.Utilities;
import fr.lygaen.utilities.utilities.commands.Broadcast;
import fr.lygaen.utilities.utilities.commands.Fly;
import fr.lygaen.utilities.utilities.commands.Gamemode;
import fr.lygaen.utilities.utilities.commands.Vanish;
import org.bukkit.command.CommandExecutor;

import java.util.Objects;

public class commands {

    static Utilities plugin = Utilities.plugin();

    public static void load() {
        CommandExecutor broadcast = new Broadcast();
        Objects.requireNonNull(plugin.getCommand("broadcast")).setExecutor(broadcast);
        CommandExecutor gamemode = new Gamemode();
        Objects.requireNonNull(plugin.getCommand("gmc")).setExecutor(gamemode);
        Objects.requireNonNull(plugin.getCommand("gms")).setExecutor(gamemode);
        Objects.requireNonNull(plugin.getCommand("gmsp")).setExecutor(gamemode);
        Objects.requireNonNull(plugin.getCommand("gma")).setExecutor(gamemode);
        CommandExecutor fly = new Fly();
        Objects.requireNonNull(plugin.getCommand("fly")).setExecutor(fly);
        Objects.requireNonNull(plugin.getCommand("speed")).setExecutor(fly);
        Objects.requireNonNull(plugin.getCommand("flyspeed")).setExecutor(fly);
        Objects.requireNonNull(plugin.getCommand("walkspeed")).setExecutor(fly);
        CommandExecutor vanish = new Vanish();
        Objects.requireNonNull(plugin.getCommand("vanish")).setExecutor(fly);
    }
}
