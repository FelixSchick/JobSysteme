package de.karottenboy33.aerogonjobsys.events;

import de.karottenboy33.aerogonjobsys.enchants.CustomEnchants;
import de.karottenboy33.aerogonjobsys.mysql.JobManager;
import de.karottenboy33.aerogonjobsys.utils.JOBNAME;
import de.karottenboy33.aerogonjobsys.utils.inv.*;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class InventoryClickEvent implements Listener {
    @EventHandler
    public void InventoryClickEvent(org.bukkit.event.inventory.InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle() == "§7» §bChoose your Job"){
            event.setCancelled(true);
            if (event.getCurrentItem().getType() == Material.IRON_AXE){
                JobManager.setJob(event.getWhoClicked().getUniqueId(), JOBNAME.HOLZFÄLLER);
                event.getWhoClicked().closeInventory();
                LumperGUI.createMainInventory((Player) event.getWhoClicked());
                event.getWhoClicked().openInventory(LumperGUI.inventory);

            }
            if (event.getCurrentItem().getType() == Material.FISHING_ROD){
                JobManager.setJob(event.getWhoClicked().getUniqueId(), JOBNAME.FISCHER);
                event.getWhoClicked().closeInventory();
                FisherGUI.createMainInventory((Player) event.getWhoClicked());
                event.getWhoClicked().openInventory(FisherGUI.inventory);

            }
            if (event.getCurrentItem().getType() == Material.IRON_SWORD){
                JobManager.setJob(event.getWhoClicked().getUniqueId(), JOBNAME.JÄGER);
                event.getWhoClicked().closeInventory();
                JägerGUI.createMainInventory((Player) event.getWhoClicked());
                event.getWhoClicked().openInventory(JägerGUI.inventory);
            }
            if (event.getCurrentItem().getType() == Material.IRON_PICKAXE){
                JobManager.setJob(event.getWhoClicked().getUniqueId(), JOBNAME.MINER);
                event.getWhoClicked().closeInventory();
                MinerGUI.createMainInventory((Player) event.getWhoClicked());
                event.getWhoClicked().openInventory(MinerGUI.inventory);
            }
        }
        if (event.getView().getTitle() == "§7» §bFisher Job") {
            event.setCancelled(true);
            if (event.getCurrentItem().getType() == Material.FISHING_ROD && event.getClickedInventory().getItem(26).getType() == Material.FISHING_ROD){
                BuyJobItem.createMainInventory((Player) event.getWhoClicked());
                event.getWhoClicked().openInventory(BuyJobItem.inventory);
            }
        }
        if (event.getView().getTitle() == "§7» §bMiner Job") {
            event.setCancelled(true);
            if (event.getCurrentItem().getType() == Material.FISHING_ROD && event.getClickedInventory().getItem(26).getType() == Material.FISHING_ROD){
                BuyJobItem.createMainInventory((Player) event.getWhoClicked());
                event.getWhoClicked().openInventory(BuyJobItem.inventory);
            }
        }
        if (event.getView().getTitle() == "§7» §bJäger Job") {
            event.setCancelled(true);
            if (event.getCurrentItem().getType() == Material.FISHING_ROD && event.getClickedInventory().getItem(26).getType() == Material.FISHING_ROD){
                BuyJobItem.createMainInventory((Player) event.getWhoClicked());
                event.getWhoClicked().openInventory(BuyJobItem.inventory);
            }
        }
        if (event.getView().getTitle() == "§7» §bHolzfäller Job") {
            event.setCancelled(true);
            if (event.getCurrentItem().getType() == Material.NETHERITE_AXE && event.getClickedInventory().getItem(26).getType() == Material.NETHERITE_AXE){
                BuyJobItem.createMainInventory((Player) event.getWhoClicked());
                event.getWhoClicked().openInventory(BuyJobItem.inventory);
            }
            if (event.getCurrentItem().getType() == Material.FEATHER){
                if (JobManager.getPoints(player.getUniqueId()) >= 1){
                    if (player.getInventory().getItemInMainHand().getItemMeta().getLore().get(2) == "§7Holzfäller Tool"){
                        int lvl = player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.DIG_SPEED);
                        if (lvl < 10){
                            player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.DIG_SPEED, lvl + 1);
                        }
                    }
                }
            }
        }
        return;
    }

}