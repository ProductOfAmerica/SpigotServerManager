package SpigotServerManager.CommandHandler.Commands;

import org.bukkit.command.CommandSender;

/**
 * Created by Lee on 3/19/2017.
 */
public class SsmInfo extends CommandSsm {
    private static final String INFO = "info";

    @Override
    public String commandArgs() {
        return INFO;
    }

    @Override
    public String permissionArgs() {
        return INFO;
    }

    @Override
    public void execute(CommandSender sender) {
        sendSenderMessage(sender, "Stats about the running SSM..."); //TODO FIX
    }
}