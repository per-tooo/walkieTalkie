package de.pertooo.walkietalkies.commands;

import de.pertooo.walkietalkies.Frequency;
import de.pertooo.walkietalkies.WalkieTalkies;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_walkieTalkie implements CommandExecutor {
    WalkieTalkies instance = WalkieTalkies.getInstance();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player))
            return false;

        Player sender = (Player)commandSender;

        if (strings.length == 0)
            sender.sendMessage("help");             //! help menu

        if (strings[0] == "connect") {
            String hz = strings[1];
            String password = strings[2] != null ? strings[2] : "";

            // remove player from other frequencies
            if (instance.playersOnFrequencies.containsKey(sender)) {
                String _hz = instance.playersOnFrequencies.get(sender);
                instance.activeFrequencies.get(_hz).removePlayerFromFrequency(sender);
                instance.playersOnFrequencies.remove(sender);
            }

            // check if frequency exists & add player to frequency
            Frequency frequency;
            if (instance.activeFrequencies.containsKey(hz)) {
                frequency = instance.activeFrequencies.get(hz);
                frequency.addPlayerToFrequency(sender);
            } else {
                frequency = new Frequency(hz, password);
                frequency.addPlayerToFrequency(sender);
                instance.activeFrequencies.put(hz, frequency);
            }
            instance.playersOnFrequencies.put(sender, hz);
        }

        if (strings[0] == "disconnect") {
            if (instance.playersOnFrequencies.containsKey(sender)) {
                String hz = instance.playersOnFrequencies.get(sender);
                instance.activeFrequencies.get(hz).removePlayerFromFrequency(sender);
                instance.playersOnFrequencies.remove(sender);
            }
        }
        return false;
    }
}
