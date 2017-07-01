package me.tekoh.plotsmenu.Listeners;

import me.tekoh.plotsmenu.Core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerTalk implements Listener {
   public static Core plugin;

   public PlayerTalk(Core instance) {
      plugin = instance;
   }

   @EventHandler
   public void playerTalk(AsyncPlayerChatEvent e) {
      Player p = e.getPlayer();
      String word = e.getMessage();
      if(plugin.TravelPlot.contains(p)) {
         e.setCancelled(true);
         plugin.TravelPlot.remove(p);
         Bukkit.getServer().dispatchCommand(p, "plot visit " + word);
      }

      if(plugin.PlotHome.contains(p)) {
         e.setCancelled(true);
         plugin.PlotHome.remove(p);
         Bukkit.getServer().dispatchCommand(p, "plot home " + word);
      }

      if(plugin.AddFriend.contains(p)) {
         e.setCancelled(true);
         plugin.AddFriend.remove(p);
         Bukkit.getServer().dispatchCommand(p, "plot add " + word);
      }

      if(plugin.RemoveFriend.contains(p)) {
         e.setCancelled(true);
         plugin.RemoveFriend.remove(p);
         Bukkit.getServer().dispatchCommand(p, "plot remove " + word);
      }

   }
}
