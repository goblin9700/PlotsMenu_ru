package me.tekoh.plotsmenu;

import java.util.ArrayList;
import me.tekoh.plotsmenu.Commands.plotsmenu;
import me.tekoh.plotsmenu.Commands.plotsmenuadmin;
import me.tekoh.plotsmenu.Listeners.InventoryClick;
import me.tekoh.plotsmenu.Listeners.PlayerInteract;
import me.tekoh.plotsmenu.Listeners.PlayerJoin;
import me.tekoh.plotsmenu.Listeners.PlayerTalk;
import me.tekoh.plotsmenu.Menus.Menu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {
   public String prefix = this.getConfig().getString("messages.prefix").replaceAll("&", "§");
   public String nopermission;
   public String itemname;
   public int version;
   public String nottravellingother;
   public String nottravellingown;
   public String cancel;
   public String notremoving;
   public String notadding;
   public String maincolour;
   public String secondarycolour;
   public String inventoryname;
   public String claimauto;
   public String claimcurrent;
   public String addaplayer;
   public String removeaplayer;
   public String gotoyourplot;
   public String deleteyourplot;
   public String travelother;
   public String closemenu;
   public String spacername;
   public String invalidargument;
   public ArrayList AddFriend;
   public ArrayList RemoveFriend;
   public ArrayList PlotHome;
   public ArrayList TravelPlot;
   public Menu menu;

   public Core() {
      this.nopermission = this.getConfig().getString("messages.nopermission").replaceAll("%prefix%", this.prefix).replaceAll("&", "§");
      this.itemname = this.getConfig().getString("settings.itemname").replaceAll("&", "§");
      this.version = this.getConfig().getInt("settings.version");
      this.nottravellingother = this.getConfig().getString("messages.nottravellingother").replaceAll("%prefix%", this.prefix).replaceAll("&", "§");
      this.nottravellingown = this.getConfig().getString("messages.nottravellingown").replaceAll("%prefix%", this.prefix).replaceAll("&", "§");
      this.cancel = this.getConfig().getString("messages.cancel").replaceAll("%prefix%", this.prefix).replaceAll("&", "§");
      this.notremoving = this.getConfig().getString("messages.notremoving").replaceAll("%prefix%", this.prefix).replaceAll("&", "§");
      this.notadding = this.getConfig().getString("messages.notadding").replaceAll("%prefix%", this.prefix).replaceAll("&", "§");
      this.maincolour = this.getConfig().getString("messages.maincolour");
      this.secondarycolour = this.getConfig().getString("messages.secondarycolour");
      this.inventoryname = this.getConfig().getString("settings.inventoryname").replaceAll("&", "§");
      this.claimauto = this.getConfig().getString("messages.claimauto").replaceAll("&", "§");
      this.claimcurrent = this.getConfig().getString("messages.claimcurrent").replaceAll("&", "§");
      this.addaplayer = this.getConfig().getString("messages.addaplayer").replaceAll("&", "§");
      this.removeaplayer = this.getConfig().getString("messages.removeaplayer").replaceAll("&", "§");
      this.gotoyourplot = this.getConfig().getString("messages.gotoyourplot").replaceAll("&", "§");
      this.deleteyourplot = this.getConfig().getString("messages.deleteyourplot").replaceAll("&", "§");
      this.travelother = this.getConfig().getString("messages.travelother").replaceAll("&", "§");
      this.closemenu = this.getConfig().getString("messages.closemenu").replaceAll("&", "§");
      this.spacername = this.getConfig().getString("messages.spacer").replaceAll("&", "§");
      this.invalidargument = this.getConfig().getString("messages.invalidargs").replaceAll("&", "§").replaceAll("%prefix%", this.prefix);
      this.AddFriend = new ArrayList();
      this.RemoveFriend = new ArrayList();
      this.PlotHome = new ArrayList();
      this.TravelPlot = new ArrayList();
   }

   public void onEnable() {
      this.menu = new Menu(this);
      this.saveDefaultConfig();
      this.reloadConfig();
      this.getCommand("aplotsmenu").setExecutor(new plotsmenuadmin(this));
      this.getCommand("plotsmenu").setExecutor(new plotsmenu(this));
      registerEvents(this, new Listener[]{new PlayerTalk(this), new PlayerInteract(this), new PlayerJoin(this), new InventoryClick(this)});
      Bukkit.getServer().getConsoleSender().sendMessage("§" + this.maincolour + "PlotsMenu has successfully initialized!");
   }

   public void onDisable() {
   }

   private static void registerEvents(Plugin plugin, Listener... listeners) {
      for(Listener listener : listeners) {
         Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
      }

   }

   public ItemStack tool() {
      ItemStack compass = new ItemStack(Material.COMPASS, 1);
      ItemMeta compassmeta = compass.getItemMeta();
      compassmeta.setDisplayName(this.itemname);
      compass.setItemMeta(compassmeta);
      return compass;
   }

   public void openMenu(Player player) {
      this.menu.show(player);
   }
}
