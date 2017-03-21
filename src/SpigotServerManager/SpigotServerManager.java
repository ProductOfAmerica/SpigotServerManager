package SpigotServerManager;

import SpigotServerManager.CommandHandler.CommandHandler;
import SpigotServerManager.Config.InitializeConfig;
import SpigotServerManager.Config.ConfigSettings;
import SpigotServerManager.Utils.HTTPServerInstance;
import SpigotServerManager.Utils.Logger.SSMLogger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Lee on 3/7/2017.
 */
public class SpigotServerManager extends JavaPlugin implements CommandExecutor {
    private static SpigotServerManager instance;
    private boolean isUpToDate = true; //TODO fix this...add auto-updater

    @Override
    public void onEnable() {
        instance = this; // THIS MUST BE FIRST
        new InitializeConfig(); // Initializes the Config.yml file

        SSMLogger.setDebugging(getConfig().getBoolean(ConfigSettings.debug.name())); // Set if we should log to console or not
        HTTPServerInstance.startServer(); // Start the SSM
    }

    @Override
    public void onDisable() {
        HTTPServerInstance.stopServer(); // Stop SSM when shutting down
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return new CommandHandler().executeCommand(sender, command, args); // Handle the command
    }

    /**
     * @return Returns an instance of this plugin.
     */
    public static SpigotServerManager getInstance() {
        return instance;
    }

    /**
     * @return If this plugin is up to date or not.
     */
    public boolean isUpToDate() {
        return isUpToDate;
    }
}