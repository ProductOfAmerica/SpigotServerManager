package SpigotServerManager.Commands;

import SpigotServerManager.Utils.Commands;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Lee on 3/7/2017.
 */
public class CommandSSM extends Commands {
    public CommandSSM(JavaPlugin ctx) {
        super(ctx);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            for (String s : args)
                ssm.getLogger().info(s);


            Player player = (Player) sender;

            // Create a new ItemStack (type: diamond)
            ItemStack diamond = new ItemStack(Material.DIAMOND);

            // Create a new ItemStack (type: brick)
            ItemStack bricks = new ItemStack(Material.BRICK);

            // Set the amount of the ItemStack
            bricks.setAmount(20);

            // Give the player our items (comma-seperated list of all ItemStack)
            player.getInventory().addItem(bricks, diamond);
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}