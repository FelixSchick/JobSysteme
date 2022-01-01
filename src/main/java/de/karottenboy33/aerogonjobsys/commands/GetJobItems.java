package de.karottenboy33.aerogonjobsys.commands;

import de.karottenboy33.aerogonjobsys.enchants.CustomEnchants;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GetJobItems implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("job.admin")){
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
        }
        return false;
    }
}
