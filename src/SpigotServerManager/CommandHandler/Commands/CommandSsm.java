package SpigotServerManager.CommandHandler.Commands;

import SpigotServerManager.CommandHandler.CommandBase;
import org.bukkit.command.CommandSender;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Lee on 3/19/2017.
 * SEE CommandType INTERFACE FOR MORE INFORMATION!!
 */
public abstract class CommandSsm extends CommandBase {
    private static final String SSM = "ssm";

    @Override
    public String commandBase() {
        return SSM;
    }

    @Override
    public String commandArgs() {
        return null; // This MUST be null. Overriding classes will return otherwise if need be.
    }

    @Override
    public String permissionBase() {
        return SSM;
    }

    @Override
    public String permissionArgs() {
        return null; // This MUST be null. Overriding classes will return otherwise if need be.
    }

    @Override
    public void execute(CommandSender sender) {
        throw new NotImplementedException(); // Overriding classes will fix this if need be.
    }
}
