package fr.lygaen.utilities.utilities.events;

import fr.lygaen.utilities.utilities.Utilities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class onjoin implements Listener {

    Utilities plugin = JavaPlugin.getPlugin(Utilities.class);

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        FileConfiguration config = plugin.getConfig();
        if(!config.getBoolean("join_event.chat_message.enabled")) {
            return;
        }
        Player player = event.getPlayer();
        String message = config.getString("join_event.chat_message.message");
        try {
            message = message.replace("%player%", player.getDisplayName());
        } catch (NullPointerException e) {}
        message = ChatColor.translateAlternateColorCodes('&', message);
        event.setJoinMessage(message);
        if(!config.getBoolean("join_event.title_message.enabled")) {return;}
        String title = config.getString("join_event.title_message.title");
        title = ChatColor.translateAlternateColorCodes('&', title);
        try {
            title = title.replace("%player%", player.getDisplayName());
        } catch (NullPointerException e) {}
        String subtitle = config.getString("join_event.title_message.subtitle");
        subtitle = ChatColor.translateAlternateColorCodes('&', subtitle);
        try {
            subtitle = subtitle.replace("%player%", player.getDisplayName());
        } catch (NullPointerException e) {}
        Integer fadein = config.getInt("join_event.title_message.fadein");
        Integer stay = config.getInt("join_event.title_message.stay");
        Integer fadeout = config.getInt("join_event.title_message.fadeout");
        event.getPlayer().sendTitle(title, subtitle, fadein, stay, fadeout);
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        FileConfiguration config = plugin.getConfig();
        if(!config.getBoolean("leave_event.chat_message.enabled")) {
            return;
        }
        Player player = event.getPlayer();
        String message = config.getString("leave_event.chat_message.message");
        try {
            message = message.replace("%player%", player.getDisplayName());
        } catch (NullPointerException e) {}
        message = ChatColor.translateAlternateColorCodes('&', message);
        event.setQuitMessage(message);
    }

}
