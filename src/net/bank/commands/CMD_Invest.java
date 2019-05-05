package net.bank.commands;

import java.util.ArrayList;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import net.bank.data.Data;
import net.bank.investment.InvestmentMain;
import net.bank.main.Main;

public class CMD_Invest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		FileConfiguration config = Main.getMain().getConfig();
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("bank.invest")) {
				
				if(args.length == 1) {
					
					int id = Integer.valueOf(args[0]);
					ArrayList<Object> daten = InvestmentMain.getInvestList(id);
					
					config.set("bank.investment." + daten.get(0) + ".hasStarted", true);
					config.set("bank.investment." + daten.get(0) + ".restschuld", daten.get(2));
					config.set("bank.investment." + daten.get(0) + ".investor", p.getDisplayName());
					
					
					
					p.sendMessage(Data.prefix + "Du hast in den Kredit §a" + daten.get(0) + "§r von §c" + daten.get(1) + "§r investiert!");
					
				}
				
			}
			
		}
		
		return false;
	}
	
	

}
