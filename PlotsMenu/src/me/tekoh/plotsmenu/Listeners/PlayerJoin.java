package me.tekoh.plotsmenu.Listeners;

import java.util.logging.Level;
import me.tekoh.plotsmenu.Core;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.PlayerInventory;

public class PlayerJoin implements Listener {
   public static Core plugin;

   public PlayerJoin(Core instance) {
      plugin = instance;
   }

   @EventHandler
   public void onPlayerJoin(PlayerJoinEvent e) {
      if(!plugin.getConfig().getString("settings.givecompass").equalsIgnoreCase("false")) {
         if(e.getPlayer().hasPermission("plotsmenu.compass")) {
            PlayerInventory pi = e.getPlayer().getInventory();
            plugin.getServer().getLogger().log(Level.ALL, "Giving " + e.getPlayer().getName() + " a tool.");
            pi.setItem(8, plugin.tool());
         }
      }
   }
}
