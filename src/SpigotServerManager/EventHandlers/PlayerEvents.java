package SpigotServerManager.EventHandlers;

import SpigotServerManager.Utils.HTTPServerInstance;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


/**
 * Created by Lee on 3/7/2017.
 */
public class PlayerEvents extends HTTPServerInstance implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (player.hasPermission("ssm.info")) {
            sendPlayerDebugMessage(isRunning() ? ChatColor.GREEN : ChatColor.RED, player,
                    String.format("The server is %s", isRunning() ? "running at " + getUrl() : "not running!"));
        }
    }
}