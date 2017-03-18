package SpigotServerManager.EventHandlers;

import EmbeddedServer.Utils.Logger.SSMLogger;
import SpigotServerManager.Utils.SSMInstance;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


/**
 * Created by Lee on 3/7/2017.
 */
public class PlayerEvents extends SSMInstance implements Listener {

    /**
     * TODO this class will be updated later...
     */

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (player.isOp()) {
            SSMLogger.sendPlayerMessage(ChatColor.WHITE, player, "hi");
        }
    }
}