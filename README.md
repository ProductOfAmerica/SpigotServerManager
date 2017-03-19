# SpigotServerManager
SpigotServerManager (SSM) is a Spigot plugin for Minecraft servers which manages your server via HTTP requests.

### Commands:

# /ssm
Displays SSM version.

#### /ssm info
Displays

#### /ssm enable

#### /ssm disable

### Permissions
```yaml
- ssm.*
- smm.version
- ssm.info
- ssm.enable
- ssm.disable
```

| Command        | Permission           | Default |
| -------------- |:--------------------:| -------:|
| /ssm           | ssm.version          |**true** |
| /ssm info      | ssm.info             |**false**|
| /ssm enabled   | ssm.enabled          |**false**|
| /ssm disabled  | ssm.disabled         |**false**|
| *              | ssm.*                |**false**|