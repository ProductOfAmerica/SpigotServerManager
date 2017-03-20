package SpigotServerManager.CommandHandler.Commands;

import SpigotServerManager.Utils.HTTPServerInstance;
import org.bukkit.command.CommandSender;

/**
 * Created by Lee on 3/19/2017.
 */
public class SsmEnable extends CommandSsm {
    private static final String ENABLE = "enable";

    @Override
    public String commandArgs() {
        return ENABLE;
    }

    @Override
    public String permissionArgs() {
        return ENABLE;
    }

    @Override
    public void execute(CommandSender sender) {
        HTTPServerInstance.startServer(sender);
    }
}