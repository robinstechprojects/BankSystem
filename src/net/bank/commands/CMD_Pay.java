package net.bank.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bank.data.Data;
import net.bank.economy.EconomyMain;

public class CMD_Pay implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		EconomyMain economyMain = new EconomyMain();
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(p.hasPermission("bank.pay")) {
				if(args.length == 2) {
					Player target = Bukkit.getPlayer(args[0]);
					int amount = Integer.valueOf(args[1]);
					
					economyMain.payMoney(p, target, amount);
					
					p.sendMessage(Data.prefix + "Du hast §c" + target.getDisplayName() + " §b" + amount + "$§r gesendet!");
					target.sendMessage(Data.prefix + "Du hast §b" + amount + "$§r von §c" + p.getDisplayName() + "§r bekommen!");
				}
			}
		}
		
		return false;
	}
	
	

}
