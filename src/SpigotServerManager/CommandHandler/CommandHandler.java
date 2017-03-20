package SpigotServerManager.CommandHandler;

import SpigotServerManager.CommandHandler.Commands.Ssm;
import SpigotServerManager.CommandHandler.Commands.SsmDisable;
import SpigotServerManager.CommandHandler.Commands.SsmEnable;
import SpigotServerManager.CommandHandler.Commands.SsmInfo;
import SpigotServerManager.Utils.SSMInstance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

/**
 * Created by Lee on 3/9/2017.
 */
public class CommandHandler extends SSMInstance {
    private static final HashSet<CommandBase> commands = new HashSet<>();

    static {
        Collections.addAll(commands,
                new Ssm(), new SsmInfo(), new SsmDisable(), new SsmEnable()
        );
    }

    public boolean executeCommand(CommandSender sender, Command command, String[] args) {
        Optional<CommandBase> cmdOptional = commands.stream().filter(cmd -> matchesCommand(cmd, command, args)).findFirst();

        if (cmdOptional.isPresent()) {
            CommandBase cmdSSM = cmdOptional.get();
            if (sender.hasPermission(cmdSSM.getPermissionsNeeded()))
                cmdSSM.execute(sender);
            else
                sendSenderMessage(sender, "§cInsufficient permissions!");
        } else {
            sendSenderMessage(sender, "§cIncorrect format. Usage:\n" + command.getUsage()); // Incorrect format entered
        }

        return true; // Always return true to disable Spigot's auto-generated text
    }

    private boolean matchesCommand(CommandBase commandBase, Command cmd, String[] args) {
        return args.length <= 0
                ? isBaseCommand(commandBase, cmd) // No command args. E.g. "/ssm"
                : commandBase.commandArgs() != null && commandBase.commandArgs().equals(String.join(" ", args));

    }

    private boolean isBaseCommand(CommandBase regCmd, Command command) {
        return regCmd.commandArgs() == null && regCmd.commandBase().equalsIgnoreCase(command.getName());
    }
}