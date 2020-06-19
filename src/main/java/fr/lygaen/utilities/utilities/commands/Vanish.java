package fr.lygaen.utilities.utilities.commands;

import fr.lygaen.utilities.utilities.Utilities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.Objects;

public class Vanish implements Listener, CommandExecutor {

    private final ArrayList<Player> vanished = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p;
        if(args.length == 0) {p = (Player) sender;}
        else {p = Bukkit.getPlayerExact(args[0]); Objects.requireNonNull(p).sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + p.getDisplayName() + " is now vanished !");}
        if (!vanished.contains(p)) {

            for (Player pl : Bukkit.getOnlinePlayers()) {
                if (!pl.hasPermission("utilities.vanish.see")) {
                    pl.hidePlayer(Utilities.plugin(), p);
                } else {
                    Player sender_ = (Player) sender;
                    if (pl != p) {
                        if (pl != sender_) {
                            pl.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + p.getDisplayName() + " is now vanished !");
                        }
                    }
                }
            }
            vanished.add(p);
            p.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " You are now vanished !");
        } else {
            for(Player pl : Bukkit.getOnlinePlayers()){
                pl.showPlayer(Utilities.plugin(), p);
            }
            vanished.remove(p);
            p.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " You are not vanished anymore");
        }
        return true;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        for (Player p : vanished) {
            e.getPlayer().hidePlayer(Utilities.plugin(), p);
        }
    }

    @EventHandler
    public void onPLayerLeave(PlayerQuitEvent e) {
        vanished.remove(e.getPlayer());
    }

}
