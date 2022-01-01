package de.karottenboy33.aerogonjobsys.utils.inv;

import at.paxfu.aerogonmaster.AerogonMaster;
import de.karottenboy33.aerogonjobsys.utils.itemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class LumperGUI {
    public static Inventory inventory;
    public static int slot = 0;
    public static void createMainInventory(Player player) {
        inventory = Bukkit.createInventory(player, 3 * 9, "§7» §bHolzfäller Job");
        for (int i = 0; i < 3*9; i++){
            inventory.setItem(i, new itemBuilder(Material.BLACK_STAINED_GLASS_PANE).displayname(" ").build());
        }
        inventory.setItem(10, new itemBuilder(Material.FEATHER).displayname("§7» Efficiency").build());
        inventory.setItem(11, new itemBuilder(Material.NETHERITE_AXE).displayname("§7» Timber").build());
        inventory.setItem(12, new itemBuilder(Material.OAK_WOOD).displayname("§7» Holzmine").build());
        inventory.setItem(13, new itemBuilder(Material.TNT).displayname("§7» Bomb-o-Holz").build());
        inventory.setItem(14, new itemBuilder(Material.GOLD_INGOT).displayname("§7» Autosell ").build());
        inventory.setItem(26, new itemBuilder(Material.NETHERITE_AXE).displayname("§7» §bKauf dein Job Item").build());
    }


} 