package SpigotServerManager.EventHandler;

import SpigotServerManager.Utils.Plugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Lee on 3/7/2017.
 */
public class PlayerEvents extends Plugin implements Listener {
    public PlayerEvents(JavaPlugin ssm) {
        super(ssm);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.isOp()) {
            player.sendMessage(ssm.isEnabled()
                    ? ChatColor.GREEN + "SpigotServerManager is running on http://localhost:9090"
                    : ChatColor.RED + "SpigotServerManager is not running.");
        }
    }
}