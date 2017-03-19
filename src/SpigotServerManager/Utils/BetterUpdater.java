package SpigotServerManager.Utils;

import org.bukkit.plugin.java.JavaPlugin;

import java.net.URL;

/**
 * Created by Lee on 3/19/2017.
 */
public class BetterUpdater {
    private static URL url;

    public static boolean needsUpdate(JavaPlugin plugin, String urlToUpdateFolder) {
        return false;
    }

    public static void main(String[] args) {
        String url = "https://github.com/:owner/:repo/releases/latest";
    }
}
