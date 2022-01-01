package de.karottenboy33.aerogonjobsys.utils.inv;

import de.karottenboy33.aerogonjobsys.enchants.CustomEnchants;
import de.karottenboy33.aerogonjobsys.mysql.JobManager;
import de.karottenboy33.aerogonjobsys.utils.JOBNAME;
import de.karottenboy33.aerogonjobsys.utils.itemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class BuyJobItem {
    public static Inventory inventory;

    public static void createMainInventory(Player player) {
        inventory = Bukkit.createInventory(player, 3 * 9, "§7» §bKauf dein Job Item");
        for (int i = 0; i < 3*9; i++){
            inventory.setItem(i, new itemBuilder(Material.BLACK_STAINED_GLASS_PANE).displayname(" ").build());
        }
        if (JobManager.getJob(player.getUniqueId())== JOBNAME.HOLZFÄLLER){
            ItemStack item = new ItemStack(Material.NETHERITE_AXE);
            item.addUnsafeEnchantment(CustomEnchants.TELEPATHY, 1);
            ItemMeta meta = item.getItemMeta();
            List<String> lore = new ArrayList<String>();
            lore.add("§7Telepathy I");
            lore.add("§7Holzfäller Tool");
            if (meta.hasLore()){
                for (String i : meta.getLore()){
                    lore.add(i);
                }
            }
            meta.setLore(lore);
            item.setItemMeta(meta);
            inventory.setItem(13, item);
        }
        if (JobManager.getJob(player.getUniqueId())== JOBNAME.FISCHER){
            ItemStack item = new ItemStack(Material.FISHING_ROD);
            item.addUnsafeEnchantment(Enchantment.LUCK, 1);
            ItemMeta meta = item.getItemMeta();
            List<String> lore = new ArrayList<String>();
            lore.clear();
            meta.setLore(lore);
            item.setItemMeta(meta);
            inventory.setItem(13, item);
        }
        if (JobManager.getJob(player.getUniqueId())== JOBNAME.JÄGER){
            ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
            item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
            ItemMeta meta = item.getItemMeta();
            List<String> lore = new ArrayList<String>();
            lore.clear();
            meta.setLore(lore);
            item.setItemMeta(meta);
            inventory.setItem(13, item);
        }
        if (JobManager.getJob(player.getUniqueId())== JOBNAME.MINER){
            ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);
            item.addUnsafeEnchantment(Enchantment.DIG_SPEED, 1);
            item.addUnsafeEnchantment(Enchantment.MENDING, 1);
            ItemMeta meta = item.getItemMeta();
            List<String> lore = new ArrayList<String>();
            lore.clear();

            meta.setLore(lore);
            item.setItemMeta(meta);
            inventory.setItem(13, item);
        }
    }


} 