package de.karottenboy33.aerogonjobsys;

import de.karottenboy33.aerogonjobsys.commands.GetJobItems;
import de.karottenboy33.aerogonjobsys.commands.JobAdminCommand;
import de.karottenboy33.aerogonjobsys.commands.JobCommand;
import de.karottenboy33.aerogonjobsys.enchants.CustomEnchants;
import de.karottenboy33.aerogonjobsys.events.InventoryClickEvent;
import de.karottenboy33.aerogonjobsys.events.PlayerJoinEvent;
import de.karottenboy33.aerogonjobsys.events.TelepathyEvents;
import de.karottenboy33.aerogonjobsys.mysql.MySQLCreate;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class AerogonJobSys extends JavaPlugin {
    public static File mysqlf;
    public static FileConfiguration mysql;
    public static Plugin plugin;
    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        createFiles();
        MySQLCreate.connect();
        MySQLCreate.createsTable();
        getCommand("getJobItems").setExecutor(new GetJobItems());
        getCommand("job").setExecutor(new JobCommand());
        getCommand("AdminJob").setExecutor(new JobAdminCommand());
        Bukkit.getPluginManager().registerEvents(new InventoryClickEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new TelepathyEvents(), this);
        CustomEnchants.register();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void createFiles() {
        mysqlf = new File(getDataFolder(), "mysql.yml");
        if (!mysqlf.exists()) {
            mysqlf.getParentFile().mkdirs();
            saveResource("mysql.yml", false);
        }
        mysql = new YamlConfiguration();
        try {
            mysql.load(mysqlf);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
