package fr.xen0xys.newuhchost.commands;

import fr.xen0xys.newuhchost.guis.HostGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NewUhcHostCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            player.openInventory(new HostGUI(player).getInventory());
        }
        return false;
    }
}
