package fr.lygaen.utilities.utilities.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Gamemode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                String command_name = command.getName().toLowerCase();
                switch (command_name) {
                    case "gmc":
                        player.setGameMode(GameMode.CREATIVE);
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Now in Creative !");
                        break;
                    case "gms":
                        player.setGameMode(GameMode.SURVIVAL);
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Now in Survival !");
                        break;
                    case "gmsp":
                        player.setGameMode(GameMode.SPECTATOR);
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Now in Spectator !");
                        break;
                    case "gma":
                        player.setGameMode(GameMode.ADVENTURE);
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Now in Adventure !");
                        break;
                }
            } else {
                sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You need to be a player to do this Command !");
            }
        } else {
            Player player = Bukkit.getPlayerExact(args[0]);
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " This Player doesn't exist !");
                return true;
            }

            String command_name = command.getName().toLowerCase();
            switch (command_name) {
                case "gmc":
                    if (!(Objects.requireNonNull(player).hasPermission("utilities.gamemode.creative.others"))) {
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You don't have the Permission !");
                        return true;
                    }
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Now in Creative !");
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Made " + player.getDisplayName() + " in Creative Gamemode !");
                    break;
                case "gms":
                    if (!(Objects.requireNonNull(player).hasPermission("utilities.gamemode.survival.others"))) {
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You don't have the Permission !");
                        return true;
                    }
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Now in Survival !");
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Made " + player.getDisplayName() + " in Survival Gamemode !");
                    break;
                case "gmsp":
                    if (!(Objects.requireNonNull(player).hasPermission("utilities.gamemode.spectator.others"))) {
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You don't have the Permission !");
                        return true;
                    }
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Now in Spectator !");
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Made " + player.getDisplayName() + " in Spectator Gamemode !");
                    break;
                case "gma":
                    if (!(Objects.requireNonNull(player).hasPermission("utilities.gamemode.adventure.others"))) {
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You don't have the Permission !");
                        return true;
                    }
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Now in Adventure !");
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Made " + player.getDisplayName() + " in Adventure Gamemode !");
                    break;
            }
        }
        return true;
    }
}
