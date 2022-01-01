package de.karottenboy33.aerogonjobsys.commands;

import de.karottenboy33.aerogonjobsys.mysql.JobManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobAdminCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("job.admin")){
                if (args.length >=1){
                    if (args[1].equals("set")){
                        if (args.length == 2){
                            if (args.length == 3){
                                if (args.length == 4){
                                    Player target = (Player) Bukkit.getPlayer(args[3]);
                                    if (args[4].equals("Points")){
                                        int numberInt = Integer.parseInt(args[4]);
                                        JobManager.setPoints(target.getUniqueId(), numberInt);
                                    }
                                    if (args[4].equals("XP")){
                                        int numberInt = Integer.parseInt(args[4]);
                                        JobManager.setXP(target.getUniqueId(), numberInt);
                                    }
                                }
                            }
                        }
                    }
                    if (args[1].equals("add")){
                        if (args.length == 2){
                            if (args.length == 3){
                                if (args.length == 4){
                                    Player target = (Player) Bukkit.getPlayer(args[3]);
                                    if (args[4].equals("Points")){
                                        int numberInt = Integer.parseInt(args[4]);
                                        JobManager.addPoints(target.getUniqueId(), numberInt);
                                    }
                                    if (args[4].equals("XP")){
                                        int numberInt = Integer.parseInt(args[4]);
                                        JobManager.addXP(target.getUniqueId(), numberInt);
                                    }
                                }
                            }
                        }
                    }
                    if (args[1].equals("reset")){
                        if (args.length == 2){
                            Player target = (Player) Bukkit.getPlayer(args[2]);
                            if (Bukkit.getOnlinePlayers().equals(args[2])){
                                JobManager.setJob(target.getUniqueId(), 0);
                                JobManager.setXP(target.getUniqueId(), 0);
                                JobManager.setPoints(target.getUniqueId(), 0);
                            } else if (JobManager.userPlayedBefore(target.getUniqueId())){
                                JobManager.setJob(target.getUniqueId(), 0);
                                JobManager.setXP(target.getUniqueId(), 0);
                                JobManager.setPoints(target.getUniqueId(), 0);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public List< String > onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        Player player = (Player) sender;
        if (player.hasPermission("job.admin")){
            if(args.length == 1) {
                List<String> complete = new ArrayList<>();
                complete.add("set");
                complete.add("add");
                complete.add("reset");
                return  complete;
            }  else if(args.length == 2) {
                return null;
            } else if(args.length == 3) {
                if (args[0].equals("reset")) return new ArrayList<>();
                List<String> complete = new ArrayList<>();
                complete.add("Points");
                complete.add("XP");
                return  complete;
            } else if (args.length == 4){
                return Collections.singletonList("<Value>");
            }
        }
        return new ArrayList<>();
    }
}