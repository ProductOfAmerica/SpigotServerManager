package SpigotServerManager.Command.Commands;

import EmbeddedServer.Utils.Logger.SSMLogger;
import SpigotServerManager.Command.Command;
import org.bukkit.command.CommandSender;

/**
 * Created by Lee on 3/7/2017.
 */
public class CommandDisable extends Command {
    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        SSMLogger.log("Disabled");
        ssm.getPluginLoader().disablePlugin(ssm);
        for (String s2 : strings)
            SSMLogger.log(s2);
        return true;
    }
}
