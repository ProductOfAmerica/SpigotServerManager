package SpigotServerManager;

import EmbeddedServer.LocalServer;
import SpigotServerManager.Command.Commands.CommandDisable;
import SpigotServerManager.Command.Commands.CommandEnable;
import SpigotServerManager.Command.Commands.CommandHandler;
import SpigotServerManager.Command.Commands.CommandSSM;
import SpigotServerManager.Config.InitializeConfig;
import SpigotServerManager.Config.Settings;
import SpigotServerManager.EventHandlers.PlayerEvents;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Lee on 3/7/2017.
 */
public class SpigotServerManager extends JavaPlugin implements CommandExecutor {
    private static SpigotServerManager instance;
    private LocalServer localServer;

    @Override
    public void onLoad() {
        instance = this; // NOTHING GOES BEFORE THIS

        new InitializeConfig(); // Initialize the Config.yml file
    }

    @Override
    public void onEnable() {
        localServer = new LocalServer(getConfig().getInt(Settings.port.name())).startServer(); //TODO Fix the port, accept port from config file.

        getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
        getCommand("ssm").setExecutor(new CommandSSM());
        getCommand("ssmdisable").setExecutor(new CommandDisable());
    }

    @Override
    public void onDisable() {
        localServer.stopServer();

        getCommand("ssmenable").setExecutor(new CommandEnable());
        getServer().getOnlinePlayers().forEach(player -> {
//            if(player.hasPermission("node.here"){
//
//            }

            if (player != null && player.isOp())
                player.sendMessage(ChatColor.RED + "Disabled SpigotServerManager.");
        });
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return new CommandHandler().executeCommand(sender, label, args);
    }

    /**
     * @return Returns an instance of this plugin.
     */
    public static SpigotServerManager getInstance() {
        return instance;
    }
}