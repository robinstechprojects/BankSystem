package net.bank.listener;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

import net.bank.data.Data;
import net.bank.economy.EconomyInventory;
import net.bank.main.Main;

public class InventoryListener implements Listener {
	
	@EventHandler
	public void onInteract(InventoryClickEvent e) {
		
		InventoryView iv = e.getView();
		Player p = (Player) e.getWhoClicked();
		EconomyInventory economyInventory = new EconomyInventory();
		FileConfiguration config = Main.getMain().getConfig();
		
		try {
			if(iv.getTitle().equalsIgnoreCase("§cBankautomat")) {
				
				e.setCancelled(true);
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lKONTO ERSTELLEN")) {
					economyInventory.setupKonto(p);
					p.sendMessage(Data.prefix + "Herzlichen Glückwunsch! Du hast ein Konto bei der §cCore§r-§lX§r Bank erstellt!");
					config.set("players." + p.getDisplayName() + ".hasKonto", true);
					p.closeInventory();
				}
				
			}
		} catch(Exception e1) {
			
		}
		
		
		
	}

}
