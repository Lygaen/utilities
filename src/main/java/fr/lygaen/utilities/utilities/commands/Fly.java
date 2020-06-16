package fr.lygaen.utilities.utilities.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    private float speed;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String command_name = command.getName().toLowerCase();
        if (command_name.equals("fly")) {
            if(args.length == 0) {
                if(sender instanceof Player) {
                    if (((Player) sender).getAllowFlight()) {
                        ((Player) sender).setAllowFlight(false);
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " You can't fly anymore !");
                    } else {
                        ((Player) sender).setAllowFlight(true);
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Now you can Fly !");
                    }
                } else {
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You need to be a player to do this command !");
                }
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target == null) {
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " This Player doesn't exist !");
                    return true;
                }
                if(!(target.hasPermission("utilities.movements.fly.others"))) {
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You don't have the Permission !");
                    return true;
                }
                if (target.getAllowFlight()) {
                    target.setAllowFlight(false);
                    target.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " You can't fly anymore !");
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Made " + target.getDisplayName() + " can't fly anymore !!");
                } else {
                    target.setAllowFlight(true);
                    target.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Now you can Fly !");
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Made " + target.getDisplayName() + " flying !");
                }
            }
        } else if(command_name.equals("speed")) {
            if(args.length == 1) {
                if(sender instanceof Player) {
                    try {
                        float speed = Float.parseFloat(args[0]);
                    } catch (Exception e) {
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You need to give a number !");
                        return true;
                    }
                    ((Player) sender).setFlySpeed(speed);
                    ((Player)sender).setWalkSpeed(speed);
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Set your speed to " + speed);
                    return true;
                } else {
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You need to be a player to do this command !");
                }
            } else if(args.length == 2){
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target == null) {
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " This Player doesn't exist !");
                    return true;
                }
                if(!(target.hasPermission("utilities.movements.speed.others"))) {
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You don't have the Permission !");
                    return true;
                }
                try {
                    float speed = Float.parseFloat(args[1]);
                } catch (Exception e) {
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You need to give a number !");
                    return true;
                }
                ((Player) sender).setFlySpeed(speed);
                ((Player)sender).setWalkSpeed(speed);
                sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Set the speed of " + target.getDisplayName() + " to " + speed);
                target.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Set your speed to " + speed);
            }
        }
        return true;
    }
}
