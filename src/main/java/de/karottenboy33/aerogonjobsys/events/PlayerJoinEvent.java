package de.karottenboy33.aerogonjobsys.events;

import de.karottenboy33.aerogonjobsys.mysql.JobManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {
    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent event){
        Player player = event.getPlayer();

        JobManager.createUser(player.getUniqueId());
    }
}
