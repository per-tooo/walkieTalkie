package de.pertooo.walkietalkies;

import de.pertooo.walkietalkies.commands.CMD_walkieTalkie;
import de.pertooo.walkietalkies.events.EVENT_chatMessages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class WalkieTalkies extends JavaPlugin {
    private static WalkieTalkies instance;
    public static WalkieTalkies getInstance() {
        return instance;
    }

    public HashMap<String, Frequency> activeFrequencies = new HashMap<>();
    public HashMap<Player, String> playersOnFrequencies = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {}

    private void registerCommands() {
        getCommand("walkieTalkie").setExecutor(new CMD_walkieTalkie());
    }
    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new EVENT_chatMessages(), this);
    }
}
