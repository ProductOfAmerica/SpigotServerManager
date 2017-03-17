package Main.Utils;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Lee on 3/7/2017.
 */
public abstract class Commands extends Plugin implements CommandExecutor{
    public Commands(JavaPlugin ctx) {
        super(ctx);
    }
}
