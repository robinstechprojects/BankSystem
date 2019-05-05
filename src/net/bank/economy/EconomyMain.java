package net.bank.economy;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import net.bank.main.Main;

public class EconomyMain {
	
	FileConfiguration config = Main.getMain().getConfig();
	
	public void setupEconomy(Player p) {
		
		config.set("bank.user." + p.getDisplayName() + ".money", 0);
		
		Main.getMain().saveConfig();
		
	}
	
	public void giveMoney(Player p, int amount) {
		
		int newvalue = config.getInt("bank.user." + p.getDisplayName() + ".money") + amount;
		
		config.set("bank.user." + p.getDisplayName() + ".money", newvalue);
		Main.getMain().saveConfig();
		
	}
	
	public void payMoney(Player from, Player to, int amount) {
		
		if(config.getDouble("bank.user." + from.getDisplayName() + ".money") > amount) {
			
			double fromnewvalue = config.getDouble("bank.user." + from.getDisplayName() + ".money") - amount;
			double tonewvalue = config.getDouble("bank.user." + to.getDisplayName() + ".money") + amount;
			
			config.set("bank.user." + from.getDisplayName() + ".money", fromnewvalue);
			config.set("bank.user." + to.getDisplayName() + ".money", tonewvalue);
			
		}
		
	}

}
