package net.bank.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bank.investment.InvestmentMain;

public class CMD_Investmentlist implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
	
		InvestmentMain investmentMain = new InvestmentMain();
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			if(p.hasPermission("bank.investment.info")) {
				
				investmentMain.getInvestment(p);
				
			}
			
		}
		
		return false;
	}
	
	

}
