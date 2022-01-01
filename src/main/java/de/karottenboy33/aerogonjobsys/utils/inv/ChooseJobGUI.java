package de.karottenboy33.aerogonjobsys.utils.inv;

import de.karottenboy33.aerogonjobsys.utils.itemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ChooseJobGUI {
    public static Inventory inventory;
    public static int slot = 0;
    public static void createMainInventory(Player player) {
        inventory = Bukkit.createInventory(player, 3 * 9, "§7» §bChoose your Job");
        for (int i = 0; i < 3*9; i++){
            inventory.setItem(i, new itemBuilder(Material.BLACK_STAINED_GLASS_PANE).displayname(" ").build());
        }

        inventory.setItem(10, new itemBuilder(Material.IRON_AXE).displayname("§7» §bHolzfäller").build());
        inventory.setItem(12, new itemBuilder(Material.FISHING_ROD).displayname("§7» §bFischer").build());
        inventory.setItem(14, new itemBuilder(Material.IRON_SWORD).displayname("§7» §bJäger").build());
        inventory.setItem(16, new itemBuilder(Material.IRON_PICKAXE).displayname("§7» §bMiner").build());

    }


} 