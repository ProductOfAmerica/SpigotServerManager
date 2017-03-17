package Main.Commands;

import Main.Utils.Commands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Lee on 3/7/2017.
 */
public class CommandEnable extends Commands {
    public CommandEnable(JavaPlugin ctx) {
        super(ctx);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        ssm.getLogger().info("Enabled");
        ssm.getPluginLoader().enablePlugin(ssm);
        for (String s2 : strings)
            ssm.getLogger().info(s);
        return true;
    }
}
