package net.bank.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.bank.commands.CMD_CreateInvest;
import net.bank.commands.CMD_Eco;
import net.bank.commands.CMD_GiveMoney;
import net.bank.commands.CMD_Invest;
import net.bank.commands.CMD_Investmentlist;
import net.bank.commands.CMD_Pay;
import net.bank.data.Data;
import net.bank.investment.InvestmentMain;
import net.bank.listener.InteractListener;
import net.bank.listener.InventoryListener;
import net.bank.listener.JoinListener;

public class Main extends JavaPlugin {
	
	private static Main plugin;
	
	@SuppressWarnings("deprecation")
	public void onEnable() {
		plugin = this;
		
		Data.log("§cBank System wurde gestartet!");
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new JoinListener(), this);
		pm.registerEvents(new InteractListener(), this);
		pm.registerEvents(new InventoryListener(), this);
		
		this.getCommand("eco").setExecutor(new CMD_Eco());
		this.getCommand("givemoney").setExecutor(new CMD_GiveMoney());
		this.getCommand("pay").setExecutor(new CMD_Pay());
		this.getCommand("createinvestment").setExecutor(new CMD_CreateInvest());
		this.getCommand("investmentlist").setExecutor(new CMD_Investmentlist());
		this.getCommand("invest").setExecutor(new CMD_Invest());
		
		this.getConfig().addDefault("settings.bank.zinsen", 1.01);
		this.getConfig().addDefault("settings.bank.zeitzinsen", 60);
		this.getConfig().options().copyDefaults(true);
		Main.getMain().saveConfig();
		
		InvestmentMain.payInvestors();
		
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(getMain(), new Runnable() {
			
			@Override
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()) {
					
					if(getConfig().getDouble("bank.user." + p.getDisplayName() + ".money") == 0) {
						
					} else {
						double newvalue = getConfig().getDouble("bank.user." + p.getDisplayName() + ".money")*1.01;
						double gerundet = Math.round(newvalue * 10) / 10;
						
						getConfig().set("bank.user." + p.getDisplayName() + ".money", gerundet);
						Main.getMain().saveConfig();
						
						p.sendMessage(Data.prefix + "Du hast Zinsen erhalten! Glückwunsch!");
					}
					
				}
				
			}
		}, 20*this.getConfig().getLong("settings.bank.zeitzinsen"), 20* this.getConfig().getLong("settings.bank.zeitzinsen"));
		
		
		

	}
	
	public static Main getMain() {
		return plugin;
	}

}
