package net.bank.listener;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import net.bank.economy.EconomyInventory;
import net.bank.main.Main;

public class InteractListener implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		FileConfiguration config = Main.getMain().getConfig();
		EconomyInventory economyInventory = new EconomyInventory();
		
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			
			if(e.getClickedBlock().getType() == Material.BLUE_WOOL) {
				
				if(config.getBoolean("players." + p.getDisplayName() + ".hasKonto")) {
					
				} else {
					economyInventory.setupGastInventory(p);
				}
				
			}
			
		}
		
	}

}
