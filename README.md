<h1 align="center" style="vertical-align: middle;">
SpigotServerManager
  <img src="https://image.flaticon.com/icons/png/32/273/273565.png" style="vertical-align: middle;">
</h1>
SpigotServerManager (SSM) is a Spigot plugin for Minecraft servers which manages your server via HTTP requests.

### Commands:
| Command        |  Description                                                     | Permission           | Default  |
| -------------- | :--------------------------------------------------------------: | -------------------- | :------: |
|                |  Access to all commands below.                                   | _ssm.*_              |   false  |
| /ssm           |  Displays the version of the SSM running.                        | _ssm.version_        | **true** |
| /ssm info      |  Displays info about the SSM.                                    | _ssm.info_           |   false  |
| /ssm enable    |  Enables the SSM server. Default URL: **http://localhost:6969/** | _ssm.enabled_        |   false  |
| /ssm disable   |  Disables the SSM server.                                        | _ssm.disabled_       |   false  |

### Permission list:
```yaml
- ssm.*
- smm.version
- ssm.info
- ssm.enable
- ssm.disable
```