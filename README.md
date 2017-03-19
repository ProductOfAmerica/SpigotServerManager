# SpigotServerManager
SpigotServerManager (SSM) is a Spigot plugin for Minecraft servers which manages your server via HTTP requests.

### Commands:
| Command        |  Description                                                     | Permission           | Default  |
| -------------- | :--------------------------------------------------------------: | -------------------- | :------: |
| /ssm           |  Displays the version of the SSM running.                        | ssm.version          | **true** |
| /ssm info      |  Displays info about the SSM.                                    | ssm.info             |   false  |
| /ssm enable    |  Enables the SSM server. Default URL: **http://localhost:6969/** | ssm.enabled          |   false  |
| /ssm disable   |  Disables the SSM server.                                        | ssm.disabled         |   false  |
| *              |  Access to all commands above.                                   | ssm.*                |   false  |

### Permission list:
```yaml
- ssm.*
- smm.version
- ssm.info
- ssm.enable
- ssm.disable
```