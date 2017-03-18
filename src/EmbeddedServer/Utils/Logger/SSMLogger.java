package EmbeddedServer.Utils.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by Lee on 3/17/2017.
 */
public class SSMLogger {
    private static final String PREFIX = ChatColor.AQUA + "[SSM] ";
    private static boolean debug = true;

    /**
     * Broadcasters Ex: "[SSM] message goes here"
     */
    public static void broadcastMessage(ChatColor color, String message) {
        broadcastMsg(color, message);
    }

    public static void broadcastMessage(String message) {
        broadcastMsg(ChatColor.WHITE, message);
    }


    /**
     * Player messengers Ex: "[SSM] message goes here"
     */
    public static void sendPlayerMessage(ChatColor color, Player player, String message) {
        sendPlayerMsg(color, player, message);
    }

    public static void sendPlayerMessage(ChatColor color, String playerName, String message) {
        sendPlayerMsg(color, Bukkit.getServer().getPlayer(playerName), message);
    }


    /**
     * Loggers
     */
    public static void logSevere(String msg) { // Ex: "[SSM] SEVERE: severe test"
        sendConsoleMessage(LogLevel.SEVERE, msg);
    }

    public static void logError(String msg) { // Ex: "[SSM] ERROR: error test"
        sendConsoleMessage(LogLevel.ERROR, msg);
    }

    public static void logWarning(String msg) { // Ex: "[SSM] WARNING: warning test"
        sendConsoleMessage(LogLevel.WARNING, msg);
    }

    public static void logOk(String msg) { // Ex: "[SSM] OK: ok test"
        sendConsoleMessage(LogLevel.OK, msg);
    }

    public static void log(String msg) { // Ex: "[SSM] log test"
        sendConsoleMessage(LogLevel.PLAIN, msg);
    }


    /**
     * Private accessors
     */
    private static void sendConsoleMessage(LogLevel level, String msg) {
        Bukkit.getConsoleSender().sendMessage(PREFIX + level.getChatColor() + level.getPrefix() + ChatColor.GRAY + msg);
    }

    private static void broadcastMsg(ChatColor color, String message) {
        Bukkit.broadcastMessage(PREFIX + color + message); //Ex: "[SSM] message goes here"
    }

    private static void sendPlayerMsg(ChatColor color, Player player, String message) {
        if (debug && player != null)
            player.sendMessage(PREFIX + color + message);
    }

    /**
     * Setter
     */
    public static void setDebugging(boolean debug) {
        SSMLogger.debug = debug;
    }
}
