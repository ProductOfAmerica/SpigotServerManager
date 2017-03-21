package SpigotServerManager.Utils;

import SpigotServerManager.SpigotServerManager;
import SpigotServerManager.Utils.Logger.SSMLogger;

/**
 * This class is intended to be extended for easy access to the SpigotServerManager instance
 */
public abstract class SSMInstance extends SSMLogger {
    protected static SpigotServerManager ssm = SpigotServerManager.getInstance();
}