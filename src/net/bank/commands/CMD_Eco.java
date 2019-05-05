package net.bank.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import net.bank.data.Data;
import net.bank.main.Main;

public class CMD_Eco implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("bank.information.money")) {
				
				FileConfiguration config = Main.getMain().getConfig();
				
				p.sendMessage(Data.prefix + "Dein Guthaben beträgt §c" + config.getInt("bank.user" + p.getDisplayName() + ".money") + "$§r!");
				
			}
			
		}
		
		return false;
	}
	
	

}
