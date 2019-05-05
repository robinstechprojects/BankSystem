package net.bank.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import net.bank.data.Data;
import net.bank.economy.EconomyMain;
import net.bank.investment.InvestmentMain;
import net.bank.main.Main;

public class CMD_CreateInvest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		FileConfiguration config = Main.getMain().getConfig();
		EconomyMain economyMain = new EconomyMain();
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("bank.invest.createinvestment")) {
				
				if(args.length == 3) {
					
					String title = args[0];
					int betrag = Integer.valueOf(args[1]);
					int laufzeit = Integer.valueOf(args[2]);
					
					config.set("bank.investment." + title + ".owner", p.getDisplayName());
					config.set("bank.investment." + title + ".betrag", betrag);
					config.set("bank.investment." + title + ".laufzeit", laufzeit);
					config.set("bank.investment." + title + ".hasStarted", false);
					
					Main.getMain().saveConfig();
					
					
					
					p.sendMessage(Data.prefix + "Du hast das Investment §c" + title + "§r mit einer Zinssumme von §b" + "" + "$§r erstellt! Laufzeit: §a" + laufzeit + " Tage" + " §rBetrag: §b" + betrag);
					
					InvestmentMain.investmentname.add(title);
					InvestmentMain.investor.add(p.getDisplayName());
					InvestmentMain.betrag.add(betrag);
					InvestmentMain.laufzeit.add(laufzeit);
					
					p.sendMessage(InvestmentMain.betrag.toString());
					
				}
				
			}
			
		}
		
		return false;
	}
	

}
