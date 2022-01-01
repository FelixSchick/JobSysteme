package de.karottenboy33.aerogonjobsys.events;

import de.karottenboy33.aerogonjobsys.enchants.CustomEnchants;
import org.bukkit.GameMode;
import org.bukkit.block.Container;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

public class TelepathyEvents implements Listener {
    @EventHandler
    public void onBlockBreake(BlockBreakEvent event){
        if (event.getPlayer().getInventory().getItemInMainHand() != null){
            if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta()){
                if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.TELEPATHY)){
                    if (event.getPlayer().getGameMode() != GameMode.CREATIVE){
                        if (event.getPlayer().getInventory().firstEmpty() != -1){
                            if (!(event.getBlock().getState() instanceof Container)){
                                event.setDropItems(false);
                                Collection< ItemStack > drops= event.getBlock().getDrops(event.getPlayer().getItemOnCursor());
                                if (!drops.isEmpty()){
                                    event.getPlayer().getInventory().addItem(drops.iterator().next());
                                }
                                if (event.getPlayer().getInventory().getItemInMainHand().getEnchantmentLevel(CustomEnchants.TELEPATHY) == 1){
                                    event.getPlayer().getInventory().getItemInMainHand().setDurability((short) (event.getPlayer().getInventory().getItemInMainHand().getDurability() - 10));
                                }
                                if (event.getPlayer().getInventory().getItemInMainHand().getEnchantmentLevel(CustomEnchants.TELEPATHY) == 2){
                                    event.getPlayer().getInventory().getItemInMainHand().setDurability((short) (event.getPlayer().getInventory().getItemInMainHand().getDurability() - 5));
                                }
                                if (event.getPlayer().getInventory().getItemInMainHand().getEnchantmentLevel(CustomEnchants.TELEPATHY) == 3){
                                    event.getPlayer().getInventory().getItemInMainHand().setDurability((short) (event.getPlayer().getInventory().getItemInMainHand().getDurability() - 2));
                                }
                                if (event.getPlayer().getInventory().getItemInMainHand().getEnchantmentLevel(CustomEnchants.TELEPATHY) == 4){
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
