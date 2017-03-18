package SpigotServerManager.Command.Commands;

import EmbeddedServer.Utils.Logger.SSMLogger;
import SpigotServerManager.Command.Command;
import org.bukkit.command.CommandSender;

/**
 * Created by Lee on 3/7/2017.
 */
public class CommandSSM extends Command {
    public CommandSSM() {
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        for (String s : args)
            SSMLogger.log(s);



        return true;
    }
}