package fr.lygaen.utilities.utilities.others;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class replacer {
    public static String placeholder(String message) {
        message = ChatColor.translateAlternateColorCodes('&', message);
        try {
            message = message.replace("%max_players%", Integer.toString(Bukkit.getServer().getMaxPlayers()));
        } catch (NullPointerException e) { //Empty catch Block
            }
        try {
            message = message.replace("%online_players%", Integer.toString(Bukkit.getServer().getMaxPlayers()));
        } catch (NullPointerException e) { //Empty catch Block
        }

        return message;
    }

    public static String placeholder(String message, Player player) {
        message = ChatColor.translateAlternateColorCodes('&', message);
        try {
            message = message.replace("%player%", player.getDisplayName());
        } catch (NullPointerException e) { //Empty catch Block
        }
        try {
            message = message.replace("%max_players%", Integer.toString(Bukkit.getServer().getMaxPlayers()));
        } catch (NullPointerException e) { //Empty catch Block
        }
        try {
            message = message.replace("%online_players%", Integer.toString(Bukkit.getServer().getMaxPlayers()));
        } catch (NullPointerException e) { //Empty catch Block
        }

        return message;
    }

}
