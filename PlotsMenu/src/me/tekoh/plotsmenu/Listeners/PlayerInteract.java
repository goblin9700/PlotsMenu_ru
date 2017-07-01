package me.tekoh.plotsmenu.Listeners;

import me.tekoh.plotsmenu.Core;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract implements Listener {
   public static Core plugin;

   public PlayerInteract(Core instance) {
      plugin = instance;
   }

   @EventHandler
   public void onInteract(PlayerInteractEvent e) {
      try {
         if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(e.getItem() == null) {
               return;
            }

            if(!e.getItem().getType().equals(Material.COMPASS)) {
               return;
            }

            if(!e.getItem().getItemMeta().getDisplayName().contains(plugin.itemname)) {
               return;
            }

            plugin.getServer().getConsoleSender().sendMessage(plugin + plugin.prefix + " " + e.getPlayer().getName() + " has just opened the menu with a " + e.getAction());
            plugin.menu.show(e.getPlayer());
         }
      } catch (NullPointerException var3) {
         ;
      }

   }
}
