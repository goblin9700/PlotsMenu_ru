package me.tekoh.plotsmenu.Commands;

import me.tekoh.plotsmenu.Core;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class plotsmenuadmin implements CommandExecutor {
   public static Core plugin;

   public plotsmenuadmin(Core instance) {
      plugin = instance;
   }

   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
      if(!(sender instanceof Player)) {
         sender.sendMessage(plugin.prefix + " §cSorry, the console cannot use these commands!");
         return true;
      } else {
         Player p = (Player)sender;
         if(cmd.getName().equalsIgnoreCase("aplotsmenu")) {
            if(!p.hasPermission("plotsmenu.admin.commands")) {
               p.sendMessage(plugin.nopermission);
               return true;
            }

            if(args.length == 0) {
               p.sendMessage(" ");
               p.sendMessage("§" + plugin.maincolour + "/aplotsmenu give <player> §" + plugin.secondarycolour + "Use this to give a player the compass to open the menu");
               p.sendMessage(" ");
               p.sendMessage("§" + plugin.maincolour + "/aplotsmenu info §" + plugin.secondarycolour + "Use this to view the config messsages.");
               p.sendMessage(" ");
               return true;
            }

            if(args[0].equalsIgnoreCase("info")) {
               if(!p.hasPermission("plotsmenu.admin.info")) {
                  p.sendMessage(plugin.nopermission);
                  return true;
               }

               p.sendMessage("§" + plugin.maincolour + "Maincolour: §" + plugin.secondarycolour + plugin.maincolour);
               p.sendMessage("§" + plugin.maincolour + "Secondarycolour: §" + plugin.secondarycolour + plugin.secondarycolour);
               p.sendMessage("§" + plugin.maincolour + "Invalidargs: " + plugin.invalidargument);
               p.sendMessage("§" + plugin.maincolour + "Prefix: " + plugin.prefix);
               p.sendMessage("§" + plugin.maincolour + "Noperms: " + plugin.nopermission);
               p.sendMessage("§" + plugin.maincolour + "Nottravellingother: " + plugin.nottravellingother);
               p.sendMessage("§" + plugin.maincolour + "Nottravellingown: " + plugin.nottravellingown);
               p.sendMessage("§" + plugin.maincolour + "Cancel: " + plugin.cancel);
               p.sendMessage("§" + plugin.maincolour + "Notremoving: " + plugin.notremoving);
               p.sendMessage("§" + plugin.maincolour + "Notadding: " + plugin.notadding);
               p.sendMessage("§" + plugin.maincolour + "Claimauto: " + plugin.claimauto);
               p.sendMessage("§" + plugin.maincolour + "Claimcurrent: " + plugin.claimcurrent);
               p.sendMessage("§" + plugin.maincolour + "Addaplayer: " + plugin.addaplayer);
               p.sendMessage("§" + plugin.maincolour + "removeaplayer: " + plugin.removeaplayer);
               p.sendMessage("§" + plugin.maincolour + "Gotoyourplot: " + plugin.gotoyourplot);
               p.sendMessage("§" + plugin.maincolour + "Deleteyourplot: " + plugin.deleteyourplot);
               p.sendMessage("§" + plugin.maincolour + "Travelother: " + plugin.travelother);
               p.sendMessage("§" + plugin.maincolour + "Closemenu: " + plugin.closemenu);
               p.sendMessage("§" + plugin.maincolour + "Spacer: " + plugin.spacername);
               p.sendMessage("§" + plugin.maincolour + "Itemname: " + plugin.itemname);
               p.sendMessage("§" + plugin.maincolour + "Forcecompass: §" + plugin.secondarycolour + plugin.getConfig().get("settings.forcecompass"));
               p.sendMessage("§" + plugin.maincolour + "Givecompass: §" + plugin.secondarycolour + plugin.getConfig().get("settings.givecompass"));
               p.sendMessage("§" + plugin.maincolour + "Inventoryname: " + plugin.inventoryname);
               return true;
            }

            if(args[0].equalsIgnoreCase("give")) {
               if(!p.hasPermission("plotsmenu.admin.give")) {
                  p.sendMessage(plugin.nopermission);
                  return true;
               }

               if(args.length == 1) {
                  p.sendMessage(plugin.prefix + " §cPlease use §c/aplotsmenu give <player>§c!");
                  return true;
               }

               Player t = Bukkit.getServer().getPlayer(args[1]);
               if(t == null) {
                  p.sendMessage(plugin.prefix + " §c" + args[1] + " §ccouldn\'t be found!");
                  p.sendMessage(plugin.prefix + " §7Maybe they\'re offline?");
                  return true;
               }

               PlayerInventory tpi = t.getPlayer().getInventory();
               ItemStack compass2 = new ItemStack(Material.COMPASS, 1);
               ItemMeta compass2meta = compass2.getItemMeta();
               compass2meta.setDisplayName(plugin.itemname);
               compass2.setItemMeta(compass2meta);
               tpi.setItem(8, compass2);
               return true;
            }
         }

         return true;
      }
   }
}
