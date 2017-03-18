package EmbeddedServer.Utils.Logger;

import org.bukkit.ChatColor;

/**
 * Created by Lee on 3/17/2017.
 */
public enum LogLevel {
    SEVERE(ChatColor.DARK_RED, "SEVERE: "),
    ERROR(ChatColor.RED, "ERROR: "),
    WARNING(ChatColor.YELLOW, "WARNING: "),
    OK(ChatColor.GREEN, "OK: "),
    PLAIN(ChatColor.GRAY, "");

    private ChatColor color;
    private String prefix;

    LogLevel(ChatColor color, String prefix) {
        this.color = color;
        this.prefix = prefix;
    }

    public ChatColor getChatColor() {
        return color;
    }

    public String getPrefix() {
        return prefix;
    }
}