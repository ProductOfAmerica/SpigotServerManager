package SpigotServerManager.CommandHandler.Commands;

import org.bukkit.command.CommandSender;

/**
 * Created by Lee on 3/19/2017.
 */
public class Ssm extends CommandSsm {
    private static final String VERSION = "version";

    @Override
    public String permissionArgs() {
        return VERSION;
    }

    @Override
    public void execute(CommandSender sender) {
        sendSenderMessage(sender, String.format("§7Version %s! %s]", //TODO FIX...make it check updater
                ssm.getDescription().getVersion(), ssm.isUpToDate() ? "§a[Latest" : "§cOutdated"));
    }
}