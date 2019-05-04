package net.bank.main;

import org.bukkit.plugin.java.JavaPlugin;

import net.bank.data.Data;

public class Main extends JavaPlugin {
	
	private static Main plugin;
	
	public void onEnable() {
		plugin = this;
		
		Data.log("§cBank System wurde gestartet!");
		
	}
	
	public static Main getMain() {
		return plugin;
	}

}
