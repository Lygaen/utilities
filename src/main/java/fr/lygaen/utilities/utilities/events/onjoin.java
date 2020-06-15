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

import static fr.lygaen.utilities.utilities.others.replacer.placeholder;


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
        message = placeholder(message, player);
        event.setJoinMessage(message);
        if(!config.getBoolean("join_event.title_message.enabled")) {return;}
        String title = config.getString("join_event.title_message.title");
        title = placeholder(title, player);
        String subtitle = config.getString("join_event.title_message.subtitle");
        subtitle = placeholder(subtitle, player);
        int fadein = config.getInt("join_event.title_message.fadein");
        int stay = config.getInt("join_event.title_message.stay");
        int fadeout = config.getInt("join_event.title_message.fadeout");
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
        message = placeholder(message, player);
        event.setQuitMessage(message);
    }

}
