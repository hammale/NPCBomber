package me.hammale.bomber;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class bomber extends JavaPlugin {

	  Logger log = Logger.getLogger("Minecraft");
	  
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		log.info("[NPCBomber] " + pdfFile.getVersion() + " Disabled!");
	}

	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();		
		log.info("[NPCBomber] " + pdfFile.getVersion() + " Enabled!");
		
		PluginManager pm = getServer().getPluginManager();
	    Plugin test = pm.getPlugin("Citizens");
	    
	    if (test != null) {
	        log.info("[NPCBomber] Hooked into Citizens!");
	    } else {
	        log.severe("[NPCBomber] Citizens isn't loaded!");
	        pm.disablePlugin(this);
	    }
	}
	
	@Override
	  public boolean onCommand(final CommandSender sender, Command cmd, String commandLabel, String[] args){
			if(cmd.getName().equalsIgnoreCase("toggle")){
				if(sender instanceof Player){
					if(args.length == 0){
						return false;
					}
					if(args[0].equalsIgnoreCase("bomber")){
						Player p = (Player) sender;
						if(net.citizensnpcs.api.CitizensManager.validateSelected(p)){
							int id = getSelected(p);
						}else{
							sender.sendMessage(ChatColor.RED + "Please select an NPC");
						}
						return true;
					}
					return false;
				}
				return false;
			}
			return false;
		}

}
