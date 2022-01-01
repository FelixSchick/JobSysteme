package de.karottenboy33.aerogonjobsys.utils.inv;

import at.paxfu.aerogonmaster.AerogonMaster;
import de.karottenboy33.aerogonjobsys.utils.itemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class FisherGUI {
    public static Inventory inventory;
    public static int slot = 0;
    public static void createMainInventory(Player player) {
        inventory = Bukkit.createInventory(player, 3 * 9, "§7» §bFisher Job");
        for (int i = 0; i < 3*9; i++){
            inventory.setItem(i, new itemBuilder(Material.BLACK_STAINED_GLASS_PANE).displayname(" ").build());
        }
        inventory.setItem(12, new itemBuilder(Material.LEGACY_RAW_FISH).displayname("§7» §bBait").build());
        inventory.setItem(13, new itemBuilder(Material.COBWEB).displayname("§7» §bFishing net").build());
        inventory.setItem(11, new itemBuilder(Material.DIAMOND).displayname("§7» §bLuck of the sea").build());
        inventory.setItem(10, new itemBuilder(Material.FISHING_ROD).displayname("§7» §blure").build());
        inventory.setItem(14, new itemBuilder(Material.GOLD_INGOT).displayname("§7» §6Auto Sell").build());
        inventory.setItem(26, new itemBuilder(Material.FISHING_ROD).displayname("§7» §bKauf dein Job Item").build());
    }


} 