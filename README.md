<h1 align="center"> SpigotServerManager <img src="https://image.flaticon.com/icons/png/32/273/273565.png" style="vertical-align: middle;"></h1>
SpigotServerManager (SSM) is a Spigot plugin for Minecraft servers which manages your server via HTTP requests.

### Commands:
| Command        |  Description                                                     | Permission           | Default  |
| -------------- | :--------------------------------------------------------------: | -------------------- | :------: |
|                |  Access to all commands below.                                   | _ssm.*_              |   false  |
| /ssm           |  Displays the version of the SSM running.                        | _ssm.version_        | **true** |
| /ssm info      |  Displays info about the SSM.                                    | _ssm.info_           |   false  |
| /ssm enable    |  Enables the SSM server. Default URL: **http://localhost:6969/** | _ssm.enabled_        |   false  |
| /ssm disable   |  Disables the SSM server.                                        | _ssm.disabled_       |   false  |

### Inheritance list:
```yaml
- ssm.*
    - smm.version
    - ssm.info
    - ssm.enable
    - ssm.disable
    
- ssm.version

- ssm.info
    - ssm.version
    
- ssm.enable
    - ssm.info
    
- ssm.disable
    - ssm.info
```

### Instructions:
Linux Users:  
&nbsp;&nbsp;&nbsp;&nbsp;Check that you have this line in /etc/hosts:  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;127.0.0.1       localhost


Ensure that you aren't allowing access to the port you've configured. The default port is ```6969```.  
If you change the port in the config.yml file, you **MUST DENY** users to that port. Otherwise, **they will have FULL access to your server**.  
&nbsp;&nbsp;If you're using ufw (ubuntu's default firewall) you must enter ```sudo ufw deny :portNumberHere:```. Example: ```sudo ufw deny 6969```.
&nbsp;&nbsp;I'm unsure how to do this from a Windows computer. Someone's help on that would be great.

1. Download plugin .jar file.
2. Place this .jar file in your ```plugins``` folder.
3. Run/reload your server.
4. Edit the config.yml file at ```plugins/SpigotServerManager/config.yml```.
5. Restart/reload your server for the settings to take effect.
6. Test that your server is working by going to ```http://localhost:yourport#here/```.
7. You should see this:  
![Whoops...looks like this moved](https://github.com/ProductOfAmerica/SpigotServerManager/tree/master/.github/landing_page.png)

#### Config.yml explained:
SSM runs a local HTTP-server using Java. Because of this, we need to specify a port number for the HTTP-server to run on.
To ensure that you are the proper user attempting to make changes to this HTTP-server, I have included a username and
password that you should change. This will be your only way to access the server.

username: This will be the username you will use to log in to your SSM. There is only one.
password: This will be the password you will use to log in to your SSM. There is only one.
port: The port you wish your server to run on. Port number must not be a port currently in use. I advise you to use a port number between 1024 and 65536. Check commonly used ports here: http://www.portchecktool.com/ports.php
debug: Value "true" or "false". If enabled, you will be prompted with error messages. This is useful is something is broken.