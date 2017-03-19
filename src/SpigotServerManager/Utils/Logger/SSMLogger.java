package SpigotServerManager.Utils.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Lee on 3/17/2017.
 */
public class SSMLogger {
    private static final String PREFIX = "§f[§bS§6S§cM§f] ";
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

    public static void sendPlayerDebugMessage(ChatColor color, Player player, String message) {
        if (debug)
            sendPlayerMsg(color, player, message);
    }

    public static void sendSenderMessage(CommandSender sender, String message) {
        sender.sendMessage(PREFIX + ChatColor.WHITE + message);
    }


    /**
     * Loggers
     */
    public static void logSevere(String msg) { // Ex: "[SSM] SEVERE: severe test"
        if (debug)
            sendConsoleMessage(LogLevel.SEVERE, msg);
    }

    public static void logError(String msg) { // Ex: "[SSM] ERROR: error test"
        if (debug)
            sendConsoleMessage(LogLevel.ERROR, msg);
    }

    public static void logWarning(String msg) { // Ex: "[SSM] WARNING: warning test"
        if (debug)
            sendConsoleMessage(LogLevel.WARNING, msg);
    }

    public static void logOk(String msg) { // Ex: "[SSM] OK: ok test"
        if (debug)
            sendConsoleMessage(LogLevel.OK, msg);
    }

    public static void log(String msg) { // Ex: "[SSM] log test"
        if (debug)
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
        if (player != null)
            player.sendMessage(PREFIX + color + message);
    }

    /**
     * Setter
     */
    public static void setDebugging(boolean shouldDebug) {
        debug = shouldDebug;
    }
}
