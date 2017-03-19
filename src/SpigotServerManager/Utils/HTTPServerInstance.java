package SpigotServerManager.Utils;

import EmbeddedServer.EmbeddedServer;
import SpigotServerManager.Config.Settings;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * Created by Lee on 3/18/2017.
 */
public abstract class HTTPServerInstance extends SSMInstance {
    private static EmbeddedServer embeddedServer;
    private static boolean isRunning;

    /**
     * Start the server
     */
    public static void startServer() {
        if (!isRunning()) {
            embeddedServer = new EmbeddedServer(
                    ssm.getConfig().getInt(Settings.port.name()),
                    ssm.getConfig().getString(Settings.username.name()),
                    ssm.getConfig().getString(Settings.password.name())
            ).startServer();

            ssm.getServer().getOnlinePlayers().forEach(player -> {
                if (player != null && player.hasPermission("ssm.info"))
                    sendPlayerDebugMessage(ChatColor.GOLD, player, "Enabling SSM. Access SSM at: " + getUrl());
            });
            isRunning = true;
        }
    }

    public static void startServer(CommandSender sender) {
        if (!isRunning())
            startServer();
        else
            sendSenderMessage(sender, "§cSSM is already running!! Access it at: " + getUrl());
    }


    /**
     * Stop the server
     */
    public static void stopServer() {
        if (isRunning()) {
            embeddedServer.stopServer();

            ssm.getServer().getOnlinePlayers().forEach(player -> {
                if (player != null && player.hasPermission("ssm.info"))
                    sendPlayerDebugMessage(ChatColor.GOLD, player, "Disabling SSM. You can't connect to SSM anymore.");
            });
            isRunning = false;
        }
    }

    public static void stopServer(CommandSender sender) {
        if (isRunning())
            stopServer();
        else
            sendSenderMessage(sender, "§cSSM is already stopped!!");
    }

    protected static boolean isRunning() {
        return isRunning;
    }

    protected static String getUrl() {
        return "http://localhost:" + embeddedServer.getListeningPort();
    }
}
