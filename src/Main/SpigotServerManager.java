package Main;

import LocalServer.LocalServer;
import Main.Commands.CommandDisable;
import Main.Commands.CommandEnable;
import Main.Commands.CommandHandler;
import Main.Commands.CommandSSM;
import Main.Config.ConfigSetup;
import Main.EventHandler.PlayerEvents;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;
import java.util.logging.Level;

/**
 * Created by Lee on 3/7/2017.
 */
public class SpigotServerManager extends JavaPlugin implements CommandExecutor {
    private static SpigotServerManager instance;
    private ConfigSetup config;
    private LocalServer localServer;

    @Override
    public void onLoad() {
        instance = this;
        localServer = new LocalServer().startServer();

        config = new ConfigSetup(this).setup();
        config.saveConfig();
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerEvents(this), this);
        getCommand("ssm").setExecutor(new CommandSSM(this));
        getCommand("ssmdisable").setExecutor(new CommandDisable(this));
    }

    @Override
    public void onDisable() {
        localServer.stopServer();

        getCommand("ssmenable").setExecutor(new CommandEnable(this));
        Collection<? extends Player> wef = getServer().getOnlinePlayers();
        wef.forEach(player -> {
            if (player != null && player.isOp())
                player.sendMessage(ChatColor.RED + "Disabled SpigotServerManager.");
        });
        getServer().getLogger().log(Level.WARNING, "You will not be able to connect to your server any longer.");
        config.saveConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return new CommandHandler().executeCommand(sender, label, args);
    }

    public static SpigotServerManager getInstance() {
        return instance;
    }
}