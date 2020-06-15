package fr.lygaen.utilities.utilities.loader;

import fr.lygaen.utilities.utilities.Utilities;
import fr.lygaen.utilities.utilities.broadcast.BroadcastCommand;
import fr.lygaen.utilities.utilities.gamemode.GamemodeCommand;
import fr.lygaen.utilities.utilities.movements.MovementsCommand;
import org.bukkit.command.CommandExecutor;

public class commands {

    static Utilities plugin = Utilities.plugin();

    public static void load() {
        CommandExecutor broadcast = new BroadcastCommand();
        plugin.getCommand("broadcast").setExecutor(broadcast);
        CommandExecutor gamemode = new GamemodeCommand();
        plugin.getCommand("gmc").setExecutor(gamemode);
        plugin.getCommand("gms").setExecutor(gamemode);
        plugin.getCommand("gmsp").setExecutor(gamemode);
        plugin.getCommand("gma").setExecutor(gamemode);
        CommandExecutor movements = new MovementsCommand();
        plugin.getCommand("fly").setExecutor(movements);
    }
}
