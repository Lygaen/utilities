package fr.lygaen.utilities.utilities.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Fly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String command_name = command.getName().toLowerCase();
        switch (command_name) {
            case "fly":
                if (args.length == 0) {
                    if (sender instanceof Player) {
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
                    if (!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " This Player doesn't exist !");
                        return true;
                    }
                    if (!(Objects.requireNonNull(target).hasPermission("utilities.movements.fly.others"))) {
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
                break;
            case "speed":
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        float speed;
                        try {
                            speed = Float.parseFloat(args[0]);
                        } catch (Exception e) {
                            sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You need to give a number !");
                            return true;
                        }
                        speed = speed * 10;
                        ((Player) sender).setFlySpeed(speed);
                        ((Player) sender).setWalkSpeed(speed);
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Set your speed to " + speed);
                    } else {
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You need to be a player to do this command !");
                    }
                    return true;
                } else if (args.length == 2) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    float speed;
                    if (!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " This Player doesn't exist !");
                        return true;
                    }
                    if (!(Objects.requireNonNull(target).hasPermission("utilities.movements.speed.others"))) {
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You don't have the Permission !");
                        return true;
                    }
                    try {
                        speed = Float.parseFloat(args[1]);
                    } catch (Exception e) {
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You need to give a number !");
                        return true;
                    }
                    speed = speed * 10;
                    ((Player) sender).setFlySpeed(speed);
                    ((Player) sender).setWalkSpeed(speed);
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Set the speed of " + target.getDisplayName() + " to " + speed);
                    target.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Set your speed to " + speed);
                } else {
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You need to give arguments ! ");
                    return true;
                }
                break;
            case "flyspeed":
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        float speed;
                        try {
                            speed = Float.parseFloat(args[0]);
                        } catch (Exception e) {
                            sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You need to give a number !");
                            return true;
                        }
                        speed = speed * 10;
                        ((Player) sender).setFlySpeed(speed);
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Set your speed to " + speed);
                    } else {
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You need to be a player to do this command !");
                    }
                    return true;
                } else if (args.length == 2) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    float speed;
                    if (!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " This Player doesn't exist !");
                        return true;
                    }
                    if (!(Objects.requireNonNull(target).hasPermission("utilities.movements.speed.others"))) {
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You don't have the Permission !");
                        return true;
                    }
                    try {
                        speed = Float.parseFloat(args[1]);
                    } catch (Exception e) {
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You need to give a number !");
                        return true;
                    }
                    speed = speed * 10;
                    ((Player) sender).setFlySpeed(speed);
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Set the speed of " + target.getDisplayName() + " to " + speed);
                    target.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Set your speed to " + speed);
                } else {
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You need to give arguments ! ");
                    return true;
                }
                break;
            case "walkspeed":
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        float speed;
                        try {
                            speed = Float.parseFloat(args[0]);
                        } catch (Exception e) {
                            sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You need to give a number !");
                            return true;
                        }
                        speed = speed * 10;
                        ((Player) sender).setWalkSpeed(speed);
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Set your speed to " + speed);
                    } else {
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You need to be a player to do this command !");
                    }
                    return true;
                } else if (args.length == 2) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    float speed;
                    if (!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " This Player doesn't exist !");
                        return true;
                    }
                    if (!(Objects.requireNonNull(target).hasPermission("utilities.movements.speed.others"))) {
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You don't have the Permission !");
                        return true;
                    }
                    try {
                        speed = Float.parseFloat(args[1]);
                    } catch (Exception e) {
                        sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You need to give a number !");
                        return true;
                    }
                    speed = speed * 10;
                    ((Player) sender).setWalkSpeed(speed);
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Set the speed of " + target.getDisplayName() + " to " + speed);
                    target.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RESET + " Set your speed to " + speed);
                } else {
                    sender.sendMessage(ChatColor.BLUE + "[UTILS]" + ChatColor.RED + " You need to give arguments ! ");
                    return true;
                }
                break;
        }
        return true;
    }
}
