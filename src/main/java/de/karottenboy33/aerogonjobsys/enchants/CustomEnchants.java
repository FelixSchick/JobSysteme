package de.karottenboy33.aerogonjobsys.enchants;

import at.paxfu.aerogonmaster.AerogonMaster;
import org.bukkit.enchantments.Enchantment;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CustomEnchants {
    public static final Enchantment TELEPATHY = new EntchantmentWrapper("telepeathy", "Telepeathy", 4);
    public static final Enchantment AUTOCLOLLECT = new EntchantmentWrapper("autocollect", "Autocollect", 5);

    public static void register(){
        boolean registered = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(CustomEnchants.TELEPATHY);

        if (!registered){
            registerEnchantments(TELEPATHY);
            registerEnchantments(AUTOCLOLLECT);
        }
    }

    public static void registerEnchantments(Enchantment enchantment){
        boolean registered = true;
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(enchantment);
        }catch (Exception e){
            registered = false;
            e.printStackTrace();
        }
        if (registered){
            System.out.println(AerogonMaster.PREFIX + " §7Das enchantment §b"+enchantment.getKey().getNamespace()+ " §7wurde geladen");

        }
    }
}
