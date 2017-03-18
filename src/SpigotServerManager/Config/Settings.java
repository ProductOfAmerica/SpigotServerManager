package SpigotServerManager.Config;

public enum Settings {
    port(6969),
    debug(true),
    username("admin"),
    password("404qYZn30R"),
    host("127.0.0.1");

    private final Object setting;

    Settings(Object setting) {
        this.setting = setting;
    }

    public Object getSetting() {
        return setting;
    }
}