package net.bank.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bank.data.Data;
import net.bank.economy.EconomyMain;

public class CMD_GiveMoney implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("bank.give.money")) {
				if(args.length == 1) {
					EconomyMain economyMain = new EconomyMain();
					int newvalue = Integer.valueOf(args[0]);
					economyMain.giveMoney(p, newvalue);
					
					p.sendMessage(Data.prefix + "Du hast dir �b" + newvalue + "$�r gegeben!");
				} else if(args.length == 2) {
					Player target = Bukkit.getPlayer(args[0]);
					int newvalue = Integer.valueOf(args[1]);
					EconomyMain economyMain = new EconomyMain();
					economyMain.giveMoney(target, newvalue);
					
					p.sendMessage(Data.prefix + "Du hast �c" + target.getDisplayName() + "�r �b" + newvalue + "$�r gegeben!");
					target.sendMessage(Data.prefix + "Du hast �b" + newvalue + "$�r von �c" + p.getDisplayName() + "�r bekommen!");
				}
			}
		}
		return false;
	}

}
