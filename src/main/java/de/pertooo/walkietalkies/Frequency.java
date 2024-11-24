package de.pertooo.walkietalkies;

import org.bukkit.entity.Player;

import java.util.List;

public class Frequency {
    private String frequency;
    private String password;
    private boolean isEncrypted;
    private List<Player> playersOnFrequency;

    public Frequency(String frequency, String password) {
        this.frequency = frequency;
        this.password = password;
        this.isEncrypted = password == "" ? false : true;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEncrypted() {
        return isEncrypted;
    }

    public List<Player> getPlayersOnFrequency() {
        return playersOnFrequency;
    }

    public boolean addPlayerToFrequency(Player player) {
        return this.playersOnFrequency.add(player);
    }

    public boolean removePlayerFromFrequency(Player player) {
        return this.playersOnFrequency.remove(player);
    }

    public boolean isPlayerOnFrequency(Player player) {
        return this.playersOnFrequency.contains(player);
    }
}
