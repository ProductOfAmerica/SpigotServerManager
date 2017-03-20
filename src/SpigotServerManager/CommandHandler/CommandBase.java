package SpigotServerManager.CommandHandler;

import SpigotServerManager.Utils.SSMInstance;
import org.bukkit.command.CommandSender;

/**
 * Created by Lee on 3/19/2017.
 */
public abstract class CommandBase extends SSMInstance implements CommandType {
    public abstract void execute(CommandSender sender); // To be executed if the command is successful

    String getPermissionsNeeded() {
        return permissionBase() + "." + permissionArgs(); // Contacts the base and all arguments together
    }
}