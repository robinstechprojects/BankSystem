package net.bank.data;

import org.bukkit.Bukkit;

public class Data {
	
	public static String name = "Bank System";
	public static String prefix = "[§b" + name + "§r] ";
	
	public static void log(String msg) {
		Bukkit.getConsoleSender().sendMessage(prefix + msg);
	}
	
	

}
