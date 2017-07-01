package me.tekoh.plotsmenu.Menus;

import me.tekoh.plotsmenu.Core;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class Menu {
   private Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)null, 36, "§aPlotsMenu");
   private Plugin plugin = Core.getPlugin(Core.class);

   public Menu(Plugin p) {
      ItemStack item1 = new ItemStack(Material.GRASS, 1);
      ItemMeta item1meta = item1.getItemMeta();
      item1meta.setDisplayName("§aПриват участка");
      item1.setItemMeta(item1meta);
      ItemStack item2 = new ItemStack(Material.STAINED_GLASS, 1, (short)5);
      ItemMeta item2meta = item2.getItemMeta();
      item2meta.setDisplayName("§aДобавить игрока в Ваш участок");
      item2.setItemMeta(item2meta);
      ItemStack item3 = new ItemStack(Material.DIRT, 1);
      ItemMeta item3meta = item3.getItemMeta();
      item3meta.setDisplayName("§cУдаление вашего участка");
      item3.setItemMeta(item3meta);
      ItemStack item4 = new ItemStack(Material.WOOD_DOOR, 1);
      ItemMeta item4meta = item4.getItemMeta();
      item4meta.setDisplayName("§eПереместиться на Ваш участок");
      item4.setItemMeta(item4meta);
      ItemStack item5 = new ItemStack(Material.GRASS, 2);
      ItemMeta item5meta = item5.getItemMeta();
      item5meta.setDisplayName("§aЗаприватить участок на котором Вы находитесь");
      item5.setItemMeta(item5meta);
      ItemStack item6 = new ItemStack(Material.DIRT, 2);
      ItemMeta item6meta = item6.getItemMeta();
      item6meta.setDisplayName("§cУдаление вашего участка");
      item6.setItemMeta(item6meta);
      ItemStack item7 = new ItemStack(Material.STAINED_GLASS, 2, (short)14);
      ItemMeta item7meta = item7.getItemMeta();
      item7meta.setDisplayName("§cУдалить игрока из участка");
      item7.setItemMeta(item7meta);
      ItemStack item8 = new ItemStack(Material.WOOD_DOOR, 1);
      ItemMeta item8meta = item8.getItemMeta();
      item8meta.setDisplayName("§eПереместиться на Ваш участок");
      item8.setItemMeta(item8meta);
      ItemStack item82 = new ItemStack(Material.WOOD_DOOR, 2);
      ItemMeta item82meta = item82.getItemMeta();
      item82meta.setDisplayName("§eПереместиться на Ваш участок");
      item82.setItemMeta(item82meta);
      ItemStack item9 = new ItemStack(Material.MINECART, 2);
      ItemMeta item9meta = item9.getItemMeta();
      item9meta.setDisplayName("§eПеремещение на другой участок");
      item9.setItemMeta(item9meta);
      ItemStack itemclose = new ItemStack(Material.BARRIER, 1);
      ItemMeta itemclosemeta = itemclose.getItemMeta();
      itemclosemeta.setDisplayName("§cЗакрыть меню");
      itemclose.setItemMeta(itemclosemeta);
      ItemStack spacer = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
      ItemMeta spacermeta = spacer.getItemMeta();
      spacermeta.setDisplayName("§8§oSpacer");
      spacer.setItemMeta(spacermeta);
      this.inv.setItem(0, spacer);
      this.inv.setItem(1, spacer);
      this.inv.setItem(2, spacer);
      this.inv.setItem(3, spacer);
      this.inv.setItem(4, spacer);
      this.inv.setItem(5, spacer);
      this.inv.setItem(6, spacer);
      this.inv.setItem(7, spacer);
      this.inv.setItem(8, spacer);
      this.inv.setItem(9, item1);
      this.inv.setItem(10, spacer);
      this.inv.setItem(11, item3);
      this.inv.setItem(12, spacer);
      this.inv.setItem(13, item2);
      this.inv.setItem(14, spacer);
      this.inv.setItem(15, item8);
      this.inv.setItem(16, spacer);
      this.inv.setItem(17, itemclose);
      this.inv.setItem(18, item5);
      this.inv.setItem(19, spacer);
      this.inv.setItem(20, item6);
      this.inv.setItem(21, spacer);
      this.inv.setItem(22, item7);
      this.inv.setItem(23, spacer);
      this.inv.setItem(24, item82);
      this.inv.setItem(25, spacer);
      this.inv.setItem(26, item9);
      this.inv.setItem(27, spacer);
      this.inv.setItem(28, spacer);
      this.inv.setItem(29, spacer);
      this.inv.setItem(30, spacer);
      this.inv.setItem(31, spacer);
      this.inv.setItem(32, spacer);
      this.inv.setItem(33, spacer);
      this.inv.setItem(34, spacer);
      this.inv.setItem(35, spacer);
   }

   public void show(Player p) {
      p.openInventory(this.inv);
   }
}
