package net.bank.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.bank.commands.CMD_Eco;
import net.bank.commands.CMD_GiveMoney;
import net.bank.data.Data;
import net.bank.listener.JoinListener;

public class Main extends JavaPlugin {
	
	private static Main plugin;
	
	public void onEnable() {
		plugin = this;
		
		Data.log("§cBank System wurde gestartet!");
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new JoinListener(), this);
		
		this.getCommand("eco").setExecutor(new CMD_Eco());
		this.getCommand("givemoney").setExecutor(new CMD_GiveMoney());
		
		
	}
	
	public static Main getMain() {
		return plugin;
	}

}
