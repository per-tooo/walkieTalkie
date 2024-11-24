package de.pertooo.walkietalkies;

import de.pertooo.walkietalkies.commands.CMD_walkieTalkie;
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
        // Plugin startup logic
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands() {
        getCommand("walkieTalkie").setExecutor(new CMD_walkieTalkie());
    }
}
