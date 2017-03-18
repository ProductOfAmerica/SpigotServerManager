package SpigotServerManager.Config;

import EmbeddedServer.Utils.Logger.SSMLogger;
import SpigotServerManager.Utils.SSMInstance;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lee on 3/7/2017.
 */
public class InitializeConfig extends SSMInstance {
    public InitializeConfig() {
        deleteUnusedConfig();
        addDefaults();
    }

    private void addDefaults() {
        ssm.getConfig().addDefaults(new HashMap<String, Object>() {{
            for (Settings settings : Settings.values()) {
                put(settings.name(), settings.getSetting());
            }
        }});
        ssm.getConfig().options().copyDefaults(true);
        ssm.saveConfig();
    }

    /**
     * Removes all unused settings from the config.yml file.
     * I've added this feature for future versions, if I remove a config
     * value, the config.yml file will tidy up as well.
     */
    private void deleteUnusedConfig() {
        Map<String, Object> configValues = ssm.getConfig().getValues(true);
        for (Map.Entry<String, Object> entry : configValues.entrySet()) {
            try {
                Settings.valueOf(entry.getKey());
            } catch (IllegalArgumentException e) {
                SSMLogger.logWarning("Removing (\"" + entry.getKey() + "\": \""
                        + entry.getValue() + "\") from the config file.");
                ssm.getConfig().set(entry.getKey(), null);
            }
        }
    }
}