package SpigotServerManager.Config;

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

    /**
     * Adds the default values to the config.yml file.
     * The default values are found in ConfigSettings.java
     */
    private void addDefaults() {
        ssm.getConfig().addDefaults(new HashMap<String, Object>() {{
            for (ConfigSettings configSettings : ConfigSettings.values()) {
                put(configSettings.name(), configSettings.getSetting());
            }
        }});
        ssm.getConfig().options().copyDefaults(true);
        ssm.saveConfig();
    }

    /**
     * Removes all unused settings from the config.yml file.
     * I've added this feature for the sake of future versions.
     * If I remove a config value in a future version, the old
     * config.yml file will tidy up as well.
     */
    private void deleteUnusedConfig() {
        Map<String, Object> configValues = ssm.getConfig().getValues(true);
        for (Map.Entry<String, Object> entry : configValues.entrySet()) {
            try {
                ConfigSettings.valueOf(entry.getKey());
            } catch (IllegalArgumentException e) {
                logWarning("Removing (\"" + entry.getKey() + "\": \""
                        + entry.getValue() + "\") from the config file.");
                ssm.getConfig().set(entry.getKey(), null);
            }
        }
    }
}