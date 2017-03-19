package SpigotServerManager.Command;

import SpigotServerManager.Utils.HTTPServerInstance;
import SpigotServerManager.Utils.SSMInstance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 * Created by Lee on 3/9/2017.
 */
public class CommandHandler extends SSMInstance {
    public boolean executeCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0 && args[0] != null) { // Contains more than one param. Ex: "/ssm anotherCommand"
            try {
                CommandPermission secondCommand = CommandPermission.valueOf(args[0]);
                switch (secondCommand) {
                    case info:
                        if (checkForPermissions(sender, secondCommand.permission()))
                            sendSenderMessage(sender, "Stats about the running SSM..."); //TODO FIX
                        return true;
                    case enable:
                        if (checkForPermissions(sender, secondCommand.permission()))
                            HTTPServerInstance.startServer(sender);
                        return true;
                    case disable:
                        if (checkForPermissions(sender, secondCommand.permission()))
                            HTTPServerInstance.stopServer(sender);
                        return true;
                }
            } catch (Exception ignored) {
                ignored.printStackTrace();
            }
            sendSenderMessage(sender, "§cIncorrect format. Usage:\n" + command.getUsage()); // Incorrect format entered

        } else { // User sent command "/ssm"
            sendSenderMessage(sender, String.format("§7Version %s! %s]",
                    ssm.getDescription().getVersion(), ssm.isUpToDate() ? "§a[Current" : "§cOutdated"));
        }

        return true; // Returning true disables spigot's automated error message.
    }

    private boolean checkForPermissions(CommandSender sender, String permission) {
        if (sender.hasPermission(permission))
            return true;

        sendSenderMessage(sender, "§cInsufficient permissions!");
        return false;
    }
}