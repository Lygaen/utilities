package fr.lygaen.utilities.utilities.gamemode;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                String command_name = command.getName().toLowerCase();
                if (command_name.equals("gmc")) {
                    player.setGameMode(GameMode.CREATIVE);
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Now in Creative !");
                } else if (command_name.equals("gms")) {
                    player.setGameMode(GameMode.SURVIVAL);
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Now in Survival !");
                } else if (command_name.equals("gmsp")) {
                    player.setGameMode(GameMode.SPECTATOR);
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Now in Spectator !");
                } else if (command_name.equals("gma")) {
                    player.setGameMode(GameMode.ADVENTURE);
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Now in Adventure !");
                }
            } else {
                sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You need to be a player to do this Command !");
            }
        } else {
            Player player = Bukkit.getPlayerExact(args[0]);
            if (!(player instanceof Player)) {
                sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " This Player doesn't exist !");
                return true;
            }

            String command_name = command.getName().toLowerCase();
            if (command_name.equals("gmc")) {
                if(!(player.hasPermission("utilities.gamemode.creative.others"))) {
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You don't have the Permission !");
                    return true;
                }
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Now in Creative !");
                sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Made " + player.getDisplayName() + " in Creative Gamemode !");
            } else if (command_name.equals("gms")) {
                if(!(player.hasPermission("utilities.gamemode.survival.others"))) {
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You don't have the Permission !");
                    return true;
                }
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Now in Survival !");
                sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Made " + player.getDisplayName() + " in Survival Gamemode !");
            } else if (command_name.equals("gmsp")) {
                if(!(player.hasPermission("utilities.gamemode.spectator.others"))) {
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You don't have the Permission !");
                    return true;
                }
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Now in Spectator !");
                sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Made " + player.getDisplayName() + " in Spectator Gamemode !");
            } else if (command_name.equals("gma")) {
                if(!(player.hasPermission("utilities.gamemode.adventure.others"))) {
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You don't have the Permission !");
                    return true;
                }
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Now in Adventure !");
                sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Made " + player.getDisplayName() + " in Adventure Gamemode !");
            }
        }
        return true;
    }
}
