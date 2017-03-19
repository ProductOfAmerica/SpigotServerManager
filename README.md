# SpigotServerManager
SpigotServerManager (SSM) is a Spigot plugin for Minecraft servers which manages your server via HTTP requests.
___

### Commands:
| Command        |  Description                           | Permission           | Default |
| -------------- | :------------------------------------: |:--------------------:| -------:|
| /ssm           |  Displays the version of SSM running.  | ssm.version          |**true** |
| /ssm info      |  Displays info about the SSM server.   | ssm.info             |**false**|
| /ssm enable    |  Enables the SSM server.               | ssm.enabled          |**false**|
| /ssm disable   |  Disables the SSM server.              | ssm.disabled         |**false**|
| *              |  Access to all commands above.         | ssm.*                |**false**|

### Permissions:
```yaml
- ssm.*
- smm.version
- ssm.info
- ssm.enable
- ssm.disable
```