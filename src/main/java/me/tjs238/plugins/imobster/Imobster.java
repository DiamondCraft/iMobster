package me.tjs238.plugins.imobster;

import java.util.logging.Logger;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Imobster extends JavaPlugin implements Listener {
    private Logger log;
    private PluginDescriptionFile description;
    private String prefix;
    private String version;
    public static Economy economy = null;
    
    @Override
    public void onDisable() {
        // TODO: Place any custom disable code here.
    }

    @Override
    public void onEnable() {
        log = Logger.getLogger("Minecraft");
        description = getDescription();
        version = description.getVersion();
        prefix = "["+description.getName()+"] ";
        log("Loading iMobster "+version);
        getServer().getPluginManager().registerEvents(this, this);
        setupEconomy();
        if (economy == null) {
            log("Please install Vault and/or an Economy Service");
            Bukkit.getPluginManager().disablePlugin(this);
        }
        log("Found "+economy.getName()+" as economy provider");
    }
    
    private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }
    
    public void log(String message){
        log.info(prefix+message);
    }
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (!(event.getEntity().getKiller() instanceof Player)) {
            return;
        }
        Player player = event.getEntity().getKiller();
        if (event.getEntity() instanceof Blaze) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing a Blaze!");
        } else if (event.getEntity() instanceof Ocelot) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing an Ocelot");
        } else if (event.getEntity() instanceof CaveSpider) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing a CaveSpider");
        } else if (event.getEntity() instanceof Chicken) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing a Chicken");
        } else if (event.getEntity() instanceof Cow) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing a Cow");
        } else if (event.getEntity() instanceof Creeper) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing a Creeper");
        } else if (event.getEntity() instanceof EnderDragon) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing an EnderDragon");
        } else if (event.getEntity() instanceof Enderman) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing an Enderman");
        } else if (event.getEntity() instanceof Ghast) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing a Ghast");
        } else if (event.getEntity() instanceof Giant) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing a Giant");
        } else if (event.getEntity() instanceof IronGolem) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing an IronGolem");
        } else if (event.getEntity() instanceof MagmaCube) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing a MagmaCube");
        } else if (event.getEntity() instanceof MushroomCow) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing a Mushroom Cow");
        } else if (event.getEntity() instanceof Pig) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing a Pig");
        } else if (event.getEntity() instanceof PigZombie) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing a PigZombie");
        } else if (event.getEntity() instanceof Sheep) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing a Sheep");
        } else if (event.getEntity() instanceof Silverfish) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing a Silverfish");
        } else if (event.getEntity() instanceof Skeleton) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing a Skeleton");
        } else if (event.getEntity() instanceof Slime) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing a Slime");
        } else if (event.getEntity() instanceof Snowman) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing a Snowman");
        } else if (event.getEntity() instanceof Spider) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing a Spider");
        } else if (event.getEntity() instanceof Squid) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing a Squid");
        } else if (event.getEntity() instanceof Villager) {
            economy.depositPlayer(player.getPlayerListName(), 100);
            player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing a Villager");
        } else if (event.getEntity() instanceof Wolf) {
            Wolf w = (Wolf) event.getEntity();
            if(w.isTamed()) {
                economy.depositPlayer(player.getPlayerListName(), 5);
                player.sendMessage(ChatColor.GRAY+"You have recived $5 for killing a Tamed Wolf");
            } else {
                economy.depositPlayer(player.getPlayerListName(), 100);
                player.sendMessage(ChatColor.GRAY+"You have recived $100 for killing a ");
            }
        }
    }
}

