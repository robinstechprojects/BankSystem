package net.bank.listener;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.bank.data.Data;
import net.bank.main.Main;

public class JoinListener implements Listener {
	
	FileConfiguration config = Main.getMain().getConfig();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		e.setJoinMessage(Data.prefix + "§7Der Spieler §c" + e.getPlayer().getDisplayName() + "§7 ist dem Server beigetreten.");
		
		config.addDefault("players." + e.getPlayer().getDisplayName() + ".hasKonto", false);
		
	}
	

}
