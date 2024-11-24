package de.pertooo.walkietalkies.events;

import de.pertooo.walkietalkies.WalkieTalkies;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class EVENT_chatMessages implements Listener {
    WalkieTalkies instance = WalkieTalkies.getInstance();

    @EventHandler
    public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent asyncPlayerChatEvent) {
        Player sender = asyncPlayerChatEvent.getPlayer();
        String message = asyncPlayerChatEvent.getMessage();

        if (!instance.playersOnFrequencies.containsKey(sender))
            for (Player player : Bukkit.getOnlinePlayers())
                player.sendMessage("§7" + sender.getName() + " » " + message);

        String hz = instance.playersOnFrequencies.get(sender);
        List<Player> players = instance.activeFrequencies.get(hz).getPlayersOnFrequency();

        for (Player player : players)
            player.sendMessage("§7" + sender.getName() + "§c@" + hz + " §7» " + message);
    }
}
