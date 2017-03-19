package SpigotServerManager.Utils;

import EmbeddedServer.LocalServer;
import SpigotServerManager.Config.Settings;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * Created by Lee on 3/18/2017.
 */
public abstract class HTTPServerInstance extends SSMInstance {
    private static LocalServer localServer;
    private static boolean isRunning;

    public static void startServer() {
        if (!isRunning()) {
            localServer = new LocalServer(
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

    public static void stopServer() {
        if (isRunning()) {
            localServer.stopServer();

            ssm.getServer().getOnlinePlayers().forEach(player -> {
                if (player != null && player.hasPermission("ssm.info"))
                    sendPlayerDebugMessage(ChatColor.GOLD, player, "Disabling SSM. You can't connect to SSM anymore.");
            });
            isRunning = false;
        }
    }

    public static void startServer(CommandSender sender) {
        if (isRunning())
            sendSenderMessage(sender, "§cSSM is already running!! Access it at: " + getUrl());
        else
            startServer();
    }

    public static void stopServer(CommandSender sender) {
        if (!isRunning())
            sendSenderMessage(sender, "§cSSM is already stopped!!");
        else
            stopServer();
    }

    protected static boolean isRunning() {
        return isRunning;
    }

    protected static String getUrl() {
        return "http://localhost:" + localServer.getListeningPort();
    }
}
