package net.bank.listener;//////////////////
*

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ClickListener implements Listener {
	/**
	 * 
	 * Diese Klasse verwendet den Bukkit-Listener
	 */

	@EventHandler
    public void onBlockClick(PlayerInteractEvent event) { //Aufruf wenn ein Spieler einen Block clickt
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {//War Klick ein Rechtsklick?
            Player player = (Player) event.getPlayer();//event-Spieler in Variable speichern
            Material clicked = event.getClickedBlock().getType();//geklicktes Material in Variable speichern
            if(clicked == Material.BLUE_WOOL) {// Wenn geklickter Block blaue Wolle is
            	
            }
          


            event.setCancelled(true);
          
        }
    }
	
}
