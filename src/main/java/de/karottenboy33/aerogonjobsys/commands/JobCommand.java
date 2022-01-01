package de.karottenboy33.aerogonjobsys.commands;

import de.karottenboy33.aerogonjobsys.mysql.JobManager;
import de.karottenboy33.aerogonjobsys.utils.JOBNAME;
import de.karottenboy33.aerogonjobsys.utils.inv.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (JobManager.getJob(player.getUniqueId()) == 0){
                ChooseJobGUI.createMainInventory(player);
                player.openInventory(ChooseJobGUI.inventory);
            }
            if (JobManager.getJob(player.getUniqueId()) == JOBNAME.HOLZFÄLLER){
                LumperGUI.createMainInventory(player);
                player.openInventory(LumperGUI.inventory);
            }
            if (JobManager.getJob(player.getUniqueId()) == JOBNAME.FISCHER){
                FisherGUI.createMainInventory(player);
                player.openInventory(FisherGUI.inventory);
            }
            if (JobManager.getJob(player.getUniqueId()) == JOBNAME.JÄGER){
                JägerGUI.createMainInventory(player);
                player.openInventory(JägerGUI.inventory);
            }
            if (JobManager.getJob(player.getUniqueId()) == JOBNAME.MINER){
                MinerGUI.createMainInventory(player);
                player.openInventory(MinerGUI.inventory);
            }
        }
        return false;
    }


}