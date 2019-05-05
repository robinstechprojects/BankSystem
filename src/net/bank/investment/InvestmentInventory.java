package net.bank.investment;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InvestmentInventory {
	
	public void setupInvestInventory(Player p) {
		
		Inventory inv = Bukkit.createInventory(null, 3*9, "§cCore§r-§lX§r §bInvestment");
		
		ItemStack investSafe = new ItemStack(Material.BAKED_POTATO);
		ItemMeta safeMeta = investSafe.getItemMeta();
		safeMeta.setDisplayName("§aSmart Invest | 2% | §b5000$§r");
		investSafe.setItemMeta(safeMeta);
		
		ItemStack investNormal = new ItemStack(Material.YELLOW_DYE);
		ItemMeta normalMeta = investNormal.getItemMeta();
		normalMeta.setDisplayName("§bMajor Invest | 4% | min. §b20000$§r");
		investNormal.setItemMeta(normalMeta);
		
		ItemStack investCritic = new ItemStack(Material.RED_NETHER_BRICKS);
		ItemMeta criticMeta = investCritic.getItemMeta();
		criticMeta.setDisplayName("§cCore§r-§lX§r Invest | 10% | min. §b150000$§r");
		investCritic.setItemMeta(criticMeta);
		
		inv.setItem(11, investSafe);
		inv.setItem(13, investNormal);
		inv.setItem(15, investCritic);
		
		p.openInventory(inv);
		
	}

}
