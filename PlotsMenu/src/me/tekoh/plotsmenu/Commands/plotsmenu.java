package me.tekoh.plotsmenu.Commands;

import me.tekoh.plotsmenu.Core;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class plotsmenu implements CommandExecutor {
   public static Core plugin;

   public plotsmenu(Core instance) {
      plugin = instance;
   }

   public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
      if(!(sender instanceof Player)) {
         sender.sendMessage(plugin.prefix + " §cSorry, the console cannot use these commands!");
         return true;
      } else {
         Player p = (Player)sender;
         if(cmd.getName().equalsIgnoreCase("plotsmenu")) {
            if(!p.hasPermission("plotsmenu.command.plotsmenu")) {
               p.sendMessage("§" + plugin.maincolour + "/plotsmenu info §" + plugin.secondarycolour + "Use this to view (not important) information about the Author/Creator! This is also the only command you have access to, poor you!");
               p.sendMessage(plugin.nopermission);
               return true;
            }

            if(args.length == 0) {
               p.sendMessage(" ");
               p.sendMessage("§" + plugin.maincolour + "/plotsmenu menu §" + plugin.secondarycolour + "Use this to open the menu manually!");
               p.sendMessage("§" + plugin.maincolour + "/plotsmenu news §" + plugin.secondarycolour + "Use this to view the latest news about the plugin!");
               p.sendMessage("§" + plugin.maincolour + "/plotsmenu info §" + plugin.secondarycolour + "Use this to view (not important) information about the Author/Creator!");
               p.sendMessage(" ");
               if(p.hasPermission("plotsmenu.admin.commands")) {
                  p.sendMessage("§" + plugin.maincolour + "Use §" + plugin.secondarycolour + "/aplotsmenu §" + plugin.secondarycolour + "to view admin commands.");
                  p.sendMessage(" ");
                  return true;
               }

               return true;
            }

            if(args[0].equalsIgnoreCase("debug")) {
               if(args.length == 2) {
                  if(args.length > 2) {
                     p.sendMessage(plugin.invalidargument);
                     return true;
                  }

                  if(args[1].equalsIgnoreCase("clear")) {
                     plugin.AddFriend.remove(p);
                     plugin.RemoveFriend.remove(p);
                     plugin.PlotHome.remove(p);
                     plugin.TravelPlot.remove(p);
                     return true;
                  }
               } else if(plugin.AddFriend.contains(p)) {
                  p.sendMessage("AddFriend");
               }

               if(plugin.RemoveFriend.contains(p)) {
                  p.sendMessage("RemoveFriend");
               }

               if(plugin.PlotHome.contains(p)) {
                  p.sendMessage("PlotHome");
               }

               if(plugin.TravelPlot.contains(p)) {
                  p.sendMessage("TravelPlot");
               }

               return true;
            }

            if(args[0].equalsIgnoreCase("info")) {
               p.sendMessage("§" + plugin.maincolour + "Author/Creator Spigot: §" + plugin.secondarycolour + "MaxTheMango");
               p.sendMessage("§" + plugin.maincolour + "Author/Creator Minecraft: §" + plugin.secondarycolour + "Tekoh");
               p.sendMessage("§" + plugin.maincolour + "Author/Creator Steam: §" + plugin.secondarycolour + "MrBean /id/Tekoh");
               return true;
            }

            if(args[0].equalsIgnoreCase("canceltravel")) {
               if(!plugin.TravelPlot.contains(p)) {
                  p.sendMessage(plugin.nottravellingother);
                  return true;
               }

               plugin.TravelPlot.remove(p);
               p.sendMessage(plugin.cancel);
               return true;
            }

            if(args[0].equalsIgnoreCase("cancelplothome")) {
               if(!plugin.PlotHome.contains(p)) {
                  p.sendMessage(plugin.nottravellingown);
                  return true;
               }

               plugin.PlotHome.remove(p);
               p.sendMessage(plugin.cancel);
               return true;
            }

            if(args[0].equalsIgnoreCase("cancelremovefriend")) {
               if(!plugin.RemoveFriend.contains(p)) {
                  p.sendMessage(plugin.notremoving);
                  return true;
               }

               plugin.RemoveFriend.remove(p);
               p.sendMessage(plugin.cancel);
               return true;
            }

            if(args[0].equalsIgnoreCase("canceladdfriend")) {
               if(!plugin.AddFriend.contains(p)) {
                  p.sendMessage(plugin.notadding);
                  return true;
               }

               plugin.AddFriend.remove(p);
               p.sendMessage(plugin.cancel);
               return true;
            }

            if(args[0].equalsIgnoreCase("news")) {
               if(!p.hasPermission("plotsmenu.command.news")) {
                  p.sendMessage(plugin.nopermission);
                  return true;
               }

               p.sendMessage(" ");
               p.sendMessage("§aNews:");
               p.sendMessage(" ");
               p.sendMessage("§cPattaLad & Reedo = 10/10 boys.");
               p.sendMessage(" ");
               return true;
            }

            if(!args[0].equalsIgnoreCase("menu")) {
               p.sendMessage(plugin.invalidargument);
               return true;
            }

            if(!p.hasPermission("plotsmenu.command.menu")) {
               p.sendMessage(plugin.nopermission);
               return true;
            }

            plugin.menu.show(p.getPlayer());
         }

         return true;
      }
   }
}
