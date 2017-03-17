package SpigotServerManager.Config;

import SpigotServerManager.Utils.Plugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

/**
 * Created by Lee on 3/7/2017.
 */
public class ConfigSetup extends Plugin {
    private final FileConfiguration config;

    public ConfigSetup(JavaPlugin ctx) {
        super(ctx);
        config = ctx.getConfig();
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public ConfigSetup setup() {
        config.addDefaults(new ConfigSettings().getMap());
        config.options().copyDefaults(true);
        return this;
    }

    public void saveConfig() {
        ssm.saveConfig();
    }

    public void set(String path, Object value) {
        config.set(path, value);
    }

    public void setAndSave(String path, Object value) {
        set(path, value);
        saveConfig();
    }

    public class ConfigSettings {
        private int port = 666;
        private String host = "127.0.0.1";

        HashMap<String, Object> getMap() {
            HashMap<String, Object> map = new HashMap<>();

            map.put("port", port);
            map.put("host", host);

            return map;
        }
    }
}
