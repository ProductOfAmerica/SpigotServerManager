package SpigotServerManager.Config;

/**
 * The enum represents the name of the setting, and the object
 * in its parameter is the default setting value.
 */
public enum ConfigSettings {
    port(6969),
    debug(true),
    username("admin"),
    password("404qYZn30R");

    private final Object setting;

    ConfigSettings(Object setting) {
        this.setting = setting;
    }

    public Object getSetting() {
        return setting;
    }
}