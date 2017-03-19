package SpigotServerManager.Command;

enum CommandPermission {
    info,
    enable,
    disable;

    private static final String CMD = "ssm";

    final String permission() {
        return CMD + "." + name();
    }
}