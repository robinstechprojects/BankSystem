package net.bank.investment;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import net.bank.data.Data;
import net.bank.economy.EconomyMain;
import net.bank.main.Main;



public class InvestmentMain {
	
	static FileConfiguration config = Main.getMain().getConfig();
	static EconomyMain economyMain = new EconomyMain();
	
	public static ArrayList<String> investmentname = new ArrayList<String>();
	public static ArrayList<String> investor = new ArrayList<String>();
	public static ArrayList<Integer> betrag = new ArrayList<Integer>();
	public static ArrayList<Integer> zinssumme = new ArrayList<Integer>();
	public static ArrayList<Integer> laufzeit = new ArrayList<Integer>();
	
	public void getInvestment(Player p) {
		
		for(int i = 0; i<investmentname.size(); i++) {
			p.sendMessage(Data.prefix + "Kreditnummer " + i + "; Investor: " + investor.get(i) + "; Name: " + investmentname.get(i) + "; Betrag: " + betrag.get(i) + "; ");
		}
		
	}
	
	public static ArrayList<Object> getInvestList(int id) {
		ArrayList<Object> investments = new ArrayList<Object>();
		investments.add(investmentname.get(id));
		investments.add(investor.get(id));
		investments.add(betrag.get(id));
		investments.add(laufzeit.get(id));
		
		return investments;
		
	}
	
	@SuppressWarnings("deprecation")
	public static void payInvestors() {
		
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getMain(), new Runnable() {
			
			@Override
			public void run() {
				
				for(int i = 0; i<investmentname.size(); i++) {
					
					ArrayList<Object> daten = getInvestList(i);
					
					double zahlung = config.getDouble("bank.investment." + daten.get(0) + ".betrag") / config.getInt("bank.investment." + daten.get(0) + ".laufzeit");
					System.out.println("Zahlung: " + zahlung);
					
					String fromname = (String) daten.get(1);
					String toname = config.getString("bank.investment." + daten.get(0) + ".investor");
					
					economyMain.payMoney(Bukkit.getPlayer(fromname), Bukkit.getPlayer(toname), zahlung);
					
					double neuerbetrag = config.getInt("bank.investment." + daten.get(0) + ".restschuld") - zahlung;
					
					config.set("bank.investment." + daten.get(0) + ".restschuld", neuerbetrag);
					
					Bukkit.getPlayer(toname).sendMessage(Data.prefix + "Du hast §b" + zahlung + "§r aus der Investition §a" + daten.get(0) + "§r bekommen!");
					
				}
				
				
			}
		}, 20*60, 20*60);
		
	}

}
