package SpigotServerManager.Utils;

import SpigotServerManager.SpigotServerManager;

/**
 * This class is intended to be extended, for easy access to the getInstance method.
 */
public abstract class SSMInstance {
    protected SpigotServerManager ssm = SpigotServerManager.getInstance();
}