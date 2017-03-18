package SpigotServerManager.Config;

public enum Settings {
    port(6969),
    debug(true),
    username("admin"),
    password("404qYZn30R");

    private final Object setting;

    Settings(Object setting) {
        this.setting = setting;
    }

    public Object getSetting() {
        return setting;
    }
}