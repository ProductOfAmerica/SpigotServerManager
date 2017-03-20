package SpigotServerManager.CommandHandler;

/**
 * Created by Lee on 3/19/2017.
 */
public interface CommandType {
    String commandBase(); // The base of a command. E.g. "cmd" in "/cmd arg1 arg2"

    String commandArgs(); // The argument of a command. E.g. "arg1" and "arg2" in "/cmd arg1 arg2".

    String permissionBase(); // The base of a permission. E.g. "perm" in "perm.value1.value2"

    String permissionArgs(); // The arguments of a permission. E.g. "value1" and "value2" in "perm.value1.value2"
}