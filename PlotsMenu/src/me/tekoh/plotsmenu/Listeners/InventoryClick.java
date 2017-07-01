package me.tekoh.plotsmenu.Listeners;

import me.tekoh.plotsmenu.Core;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {
   public static Core plugin;

   public InventoryClick(Core instance) {
      plugin = instance;
   }

   @EventHandler
   public void onInvClick(InventoryClickEvent e) {
      Player p = (Player)e.getWhoClicked();

      try {
         if(e.getCurrentItem().getType() == Material.COMPASS) {
            if(!e.getCurrentItem().getItemMeta().getDisplayName().contains(plugin.itemname)) {
               return;
            }

            if(!plugin.getConfig().getString("settings.forcecompass").equalsIgnoreCase("true")) {
               return;
            }

            e.setCancelled(true);
         }

         if(e.getInventory().getName().contains("§aPlotsMenu")) {
            e.setCancelled(true);
            if(e.getCurrentItem() == null || !e.getCurrentItem().hasItemMeta()) {
               e.setCancelled(true);
               return;
            }

            if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§aПриват участка")) {
               e.setCancelled(true);
               Bukkit.getServer().dispatchCommand(e.getWhoClicked(), "plot auto");
               e.getWhoClicked().closeInventory();
               return;
            }

            if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eПеремещение на другой участок")) {
               e.setCancelled(true);
               plugin.TravelPlot.add(p);
               e.getWhoClicked().sendMessage("§" + plugin.maincolour + "Введите имя игрока или номер его участка.");
               e.getWhoClicked().sendMessage("§" + plugin.maincolour + "ДЛя отмены команды введите §" + plugin.secondarycolour + "/plotsmenu canceltravel");
               e.getWhoClicked().closeInventory();
               return;
            }

            if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§aДобавить игрока в Ваш участок")) {
               e.setCancelled(true);
               plugin.AddFriend.add(p);
               e.getWhoClicked().sendMessage("§" + plugin.maincolour + "Введите ник игрока которого хотите добавить в участок.");
               e.getWhoClicked().sendMessage("§" + plugin.maincolour + "Переместитесь на участок.");
               e.getWhoClicked().sendMessage("§" + plugin.maincolour + "Если Вы передумали добавлять игрока, введите §" + plugin.secondarycolour + "/plotsmenu canceladdfriend");
               e.getWhoClicked().closeInventory();
               return;
            }

            if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§cУдалить игрока из участка")) {
               e.setCancelled(true);
               e.getWhoClicked().closeInventory();
               e.getWhoClicked().sendMessage("§" + plugin.maincolour + "Введите ник игрока которого хотите удалить из участка");
               e.getWhoClicked().sendMessage("§" + plugin.maincolour + "Вы должны находиться на участке.");
               e.getWhoClicked().sendMessage("§" + plugin.maincolour + "Для отмены удаления игрока из участка, введите §" + plugin.secondarycolour + "/plotsmenu cancelremovefriend");
               plugin.RemoveFriend.add(p);
               return;
            }

            if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§cУдаление вашего участка")) {
               e.setCancelled(true);
               e.getWhoClicked().sendMessage("§" + plugin.maincolour + "Для выполнения этой команды Вы должны находиться на участке.");
               Bukkit.getServer().dispatchCommand(p, "plot delete");
               e.getWhoClicked().closeInventory();
               return;
            }

            if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§eПереместиться на Ваш участок")) {
               e.setCancelled(true);
               e.getWhoClicked().closeInventory();
               e.getWhoClicked().sendMessage("§" + plugin.maincolour + "Введите в чат номер или название вашего участка.");
               e.getWhoClicked().sendMessage("§" + plugin.maincolour + "Для отмены перемещения введите §" + plugin.secondarycolour + "/plotsmenu cancelplothome");
               plugin.PlotHome.add(p);
               return;
            }

            if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§8§oSpacer")) {
               e.setCancelled(true);
               return;
            }

            if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§aЗаприватить участок на котором Вы находитесь")) {
               e.setCancelled(true);
               e.getWhoClicked().closeInventory();
               Bukkit.getServer().dispatchCommand(p, "plotsquared claim");
               return;
            }

            if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§cЗакрыть меню")) {
               e.setCancelled(true);
               e.getWhoClicked().closeInventory();
               return;
            }
         }
      } catch (NullPointerException var4) {
         ;
      }

   }
}
