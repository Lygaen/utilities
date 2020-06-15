package fr.lygaen.utilities.utilities.others;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class replacer {
    public static String placeholder(String message) {
        message = ChatColor.translateAlternateColorCodes('&', message);
        try {
            message = message.replace("%max_players%", Integer.toString(Bukkit.getServer().getMaxPlayers()));
        } catch (NullPointerException e) {/*Empty catch Block*/}
        try {
            message = message.replace("%online_players%", Integer.toString(Bukkit.getServer().getMaxPlayers()));
        } catch (NullPointerException e) {/*Empty catch Block*/}
        try {
            message = message.replace("%server_name%", Bukkit.getName());
        } catch (NullPointerException e) {/*Empty catch Block*/}
        try {
            message = message.replace("%server_motd%", Bukkit.getMotd());
        } catch (NullPointerException e) {/*Empty catch Block*/}

        return message;
    }

    public static String placeholder(String message, Player player) {
        message = ChatColor.translateAlternateColorCodes('&', message);
        try {
            message = message.replace("%player%", player.getDisplayName());
        } catch (NullPointerException e) {/*Empty catch Block*/}
        try {
            message = message.replace("%player_exact%", player.getName());
        } catch (NullPointerException e) {/*Empty catch Block*/}
        try {
            message = message.replace("%x%", Integer.toString((int) player.getLocation().getX()));
        } catch (NullPointerException e) {/*Empty catch Block*/}
        try {
            message = message.replace("%y%", Integer.toString((int) player.getLocation().getY()));
        } catch (NullPointerException e) {/*Empty catch Block*/}
        try {
            message = message.replace("%z%", Integer.toString((int) player.getLocation().getZ()));
        } catch (NullPointerException e) {/*Empty catch Block*/}
        try {
            message = message.replace("%max_players%", Integer.toString(Bukkit.getServer().getMaxPlayers()));
        } catch (NullPointerException e) {/*Empty catch Block*/}
        try {
            message = message.replace("%online_players%", Integer.toString(Bukkit.getServer().getOnlinePlayers().size()));
        } catch (NullPointerException e) {/*Empty catch Block*/}
        try {
            message = message.replace("%server_name%", Bukkit.getName());
        } catch (NullPointerException e) {/*Empty catch Block*/}
        try {
            message = message.replace("%server_motd%", Bukkit.getMotd());
        } catch (NullPointerException e) {/*Empty catch Block*/}

        return message;
    }

}
