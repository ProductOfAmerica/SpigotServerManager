package SpigotServerManager.Command.Commands;

import EmbeddedServer.Utils.Logger.SSMLogger;
import SpigotServerManager.Command.Command;
import org.bukkit.command.CommandSender;

/**
 * Created by Lee on 3/7/2017.
 */
public class CommandEnable extends Command {
    public CommandEnable() {
    }

    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        SSMLogger.log("Enabled");
        ssm.getPluginLoader().enablePlugin(ssm);
        for (String s2 : strings)
            SSMLogger.log(s);
        return true;
    }
}
