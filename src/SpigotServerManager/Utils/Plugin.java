package SpigotServerManager.Utils;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Lee on 3/7/2017.
 */
public abstract class Plugin {
    protected JavaPlugin ssm;

    public Plugin(JavaPlugin ssm) {
        this.ssm = ssm;
    }
}