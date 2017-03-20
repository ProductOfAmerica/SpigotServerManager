package SpigotServerManager.CommandHandler.Commands;

import SpigotServerManager.Utils.HTTPServerInstance;
import org.bukkit.command.CommandSender;

/**
 * Created by Lee on 3/19/2017.
 */
public class SsmDisable extends CommandSsm {
    private static final String DISABLE = "disable";

    @Override
    public String commandArgs() {
        return DISABLE;
    }

    @Override
    public String permissionArgs() {
        return DISABLE;
    }

    @Override
    public void execute(CommandSender sender) {
        HTTPServerInstance.stopServer(sender);
    }
}