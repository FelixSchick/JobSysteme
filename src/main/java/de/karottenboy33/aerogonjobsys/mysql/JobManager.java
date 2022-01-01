package de.karottenboy33.aerogonjobsys.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public class JobManager {
    public static boolean userPlayedBefore(UUID uuid) {
        ResultSet set = MySQL.getInstance().executeQuery("SELECT * FROM `job` WHERE `uuid` = ?", new HashMap<Integer, String>(){
            {
                put(1, String.valueOf(uuid));
            }
        });
        try {
            if(set.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void createUser(UUID uuid) {
        if(!userPlayedBefore(uuid)) {
            ResultSet set = MySQL.getInstance().executeQuery("INSERT INTO `job` (`uuid`, `job`, `points`, `xp`) VALUES (?,?,?,?)", new HashMap<Integer, String>(){
                {
                    put(1, String.valueOf(uuid));
                    put(2, String.valueOf(0));
                    put(3, String.valueOf(0));
                    put(4, String.valueOf(0));
                }
            });
        }
    }

    public static int getJob(UUID uuid){
        ResultSet set = MySQL.getInstance().executeQuery("SELECT * FROM `job` WHERE uuid=?", new HashMap<Integer, String>(){
            {
                put(1, uuid.toString());
            }
        });
        try {
            while (set.next()){
                return set.getInt("job");
            }
            return 0;
        } catch (SQLException e){
            e.getErrorCode();
            return 0;
        }
    }
    public static int getPoints(UUID uuid){
        ResultSet set = MySQL.getInstance().executeQuery("SELECT * FROM `job` WHERE uuid=?", new HashMap<Integer, String>(){
            {
                put(1, uuid.toString());
            }
        });
        try {
            while (set.next()){
                return set.getInt("points");
            }
            return 0;
        } catch (SQLException e){
            e.getErrorCode();
            return 0;
        }
    }
    public static int getXP(UUID uuid){
        ResultSet set = MySQL.getInstance().executeQuery("SELECT * FROM `job` WHERE uuid=?", new HashMap<Integer, String>(){
            {
                put(1, uuid.toString());
            }
        });
        try {
            while (set.next()){
                return set.getInt("xp");
            }
            return 0;
        } catch (SQLException e){
            e.getErrorCode();
            return 0;
        }
    }


    public static void setJob(UUID uuid, int amount){
        ResultSet set = MySQL.getInstance().executeQuery("UPDATE `job` SET `job`=? WHERE uuid=?", new HashMap<Integer, String>(){
            {
                if (amount > 0){
                    put(1, String.valueOf(amount));
                    put(2, uuid.toString());
                }
            }
        });
    }
    public static void setPoints(UUID uuid, int amount){
        ResultSet set = MySQL.getInstance().executeQuery("UPDATE `job` SET `points`=? WHERE uuid=?", new HashMap<Integer, String>(){
            {
                put(1, String.valueOf(amount));
                put(2, uuid.toString());
            }
        });
    }
    public static void setXP(UUID uuid, int amount){
        ResultSet set = MySQL.getInstance().executeQuery("UPDATE `job` SET `xp`=? WHERE uuid=?", new HashMap<Integer, String>(){
            {
                put(1, String.valueOf(amount));
                put(2, uuid.toString());
            }
        });
    }


    public static void addPoints(UUID uuid, int amount){
        int have = getPoints(uuid);

        ResultSet set = MySQL.getInstance().executeQuery("UPDATE `job` SET `points`=? WHERE uuid=?", new HashMap<Integer, String>(){
            {
                put(1, String.valueOf(have + amount));
                put(2, uuid.toString());
            }
        });
    }
    public static void addXP(UUID uuid, int amount){
        int have = getXP(uuid);

        ResultSet set = MySQL.getInstance().executeQuery("UPDATE `job` SET `xp`=? WHERE uuid=?", new HashMap<Integer, String>(){
            {
                put(1, String.valueOf(have + amount));
                put(2, uuid.toString());
            }
        });
    }

}
