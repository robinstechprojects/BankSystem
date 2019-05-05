package net.bank.listener;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

import net.bank.data.Data;
import net.bank.economy.EconomyInventory;
import net.bank.economy.EconomyMain;
import net.bank.investment.InvestmentInventory;
import net.bank.main.Main;

public class InventoryListener implements Listener {
	
	@EventHandler
	public void onInteract(InventoryClickEvent e) {
		
		InventoryView iv = e.getView();
		Player p = (Player) e.getWhoClicked();
		EconomyMain economyMain = new EconomyMain();
		EconomyInventory economyInventory = new EconomyInventory();
		InvestmentInventory investmentInventory = new InvestmentInventory();
		FileConfiguration config = Main.getMain().getConfig();
		
		try {
			if(iv.getTitle().equalsIgnoreCase("§cBankautomat")) {
				
				e.setCancelled(true);
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lKONTO ERSTELLEN")) {
					economyInventory.setupKonto(p);
					p.sendMessage(Data.prefix + "Herzlichen Glückwunsch! Du hast ein Konto bei der §cCore§r-§lX§r Bank erstellt!");
					config.set("players." + p.getDisplayName() + ".hasKonto", true);
					Main.getMain().saveConfig();
					p.closeInventory();
				} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lKONTOAUSZUG")) {
					
					economyInventory.sendKontoauszug(p);
					p.closeInventory();
					
				} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lINVESTIEREN")) {
					
					investmentInventory.setupInvestInventory(p);
					
				}
				
			}
			
			if(iv.getTitle().equalsIgnoreCase("§cCore§r-§lX§r §bInvestment")) {
				e.setCancelled(true);
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSmart Invest | 2% | §b5000$§r")) {
					economyMain.payMoney(p, Bukkit.getPlayer("15er"), 5000);
					
					p.sendMessage(Data.prefix + "Du hast §b5000$§r in den §aSmart Invest Fonds§r von §c15er§r investiert!");
					Bukkit.getPlayer("15er").sendMessage(Data.prefix + "§c" + p.getDisplayName() + "§r hat §b5000$§r in deinen Fonds investiert!");
				}
			}
		} catch(Exception e1) {
			
		}
		
		
		
	}

}
