package de.karottenboy33.aerogonjobsys.utils;

import de.karottenboy33.aerogonjobsys.enchants.CustomEnchants;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ToolManager {
    public void addTool(Player player, int JobID){
        if (JobID == 0){
            return;
        }
        if (JobID == JOBNAME.HOLZFÄLLER){
            ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
            item.addUnsafeEnchantment(CustomEnchants.TELEPATHY, 1);
            item.addUnsafeEnchantment(Enchantment.DIG_SPEED, 100);
            ItemMeta meta = item.getItemMeta();
            List<String> lore = new ArrayList<String>();
            lore.add("§7Telepathy I");
            if (meta.hasLore()){
                for (String i : meta.getLore()){
                    lore.add(i);
                }
            }
            meta.setLore(lore);
            item.setItemMeta(meta);
            player.getInventory().addItem(item);
        }
        if (JobID == JOBNAME.FISCHER){

        }
        if (JobID == JOBNAME.JÄGER){

        }
        if (JobID == JOBNAME.MINER){

        }
    }
}
