package fr.lygaen.utilities.utilities.broadcast;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static fr.lygaen.utilities.utilities.others.replacer.placeholder;

public class BroadcastCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String sentence = String.join(" ", args);
        sentence = placeholder(sentence);
        Bukkit.broadcastMessage(sentence);
        return true;
    }
}
