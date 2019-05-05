package net.bank.economy;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.bank.main.Main;


public class EconomyInventory {
	
	FileConfiguration config = Main.getMain().getConfig();
	
	public void setupKonto(Player p) {
		
		config.set("bank.user." + p.getDisplayName() + ".money", 0);
		Main.getMain().saveConfig();
		
	}
	
	public void setupGastInventory(Player p) {
		
		Inventory inv = Bukkit.createInventory(null, 1*9, "§cBankautomat");
		
		ItemStack createKontoIS = new ItemStack(Material.APPLE);
		ItemMeta createKontoMT = createKontoIS.getItemMeta();
		createKontoMT.setDisplayName("§b§lKONTO ERSTELLEN");
		createKontoIS.setItemMeta(createKontoMT);
		
		inv.setItem(4, createKontoIS);
		
		p.openInventory(inv);
		
	}
	
	public void setupUserInventory(Player p) {
		
		Inventory inv = Bukkit.createInventory(null, 1*9, "§cBankautomat");
		
		ItemStack getBalanceIS = new ItemStack(Material.BOOK);
		ItemMeta getBalanceMT = getBalanceIS.getItemMeta();
		getBalanceMT.setDisplayName("§b§lKONTOAUSZUG");
		getBalanceIS.setItemMeta(getBalanceMT);
		
		inv.setItem(4, getBalanceIS);
		
		
	}

}
