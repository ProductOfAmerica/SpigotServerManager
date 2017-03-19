<h1 align="center"> SpigotServerManager <img src="https://image.flaticon.com/icons/png/32/273/273565.png" style="vertical-align: middle;"></h1>
SpigotServerManager (SSM) is a Spigot plugin for Minecraft servers which manages your server via HTTP requests.

### Commands:
<table align="center">
<thead>
<tr>
<th>Command</th>
<th align="center">Description</th>
<th>Permission</th>
<th align="center">Default</th>
</tr>
</thead>
<tbody>
<tr>
<td></td>
<td align="center">Access to all commands below.</td>
<td><em>ssm.*</em></td>
<td align="center">false</td>
</tr>
<tr>
<td>/ssm</td>
<td align="center">Displays the version of the SSM running.</td>
<td><em>ssm.version</em></td>
<td align="center"><strong>true</strong></td>
</tr>
<tr>
<td>/ssm info</td>
<td align="center">Displays info about the SSM.</td>
<td><em>ssm.info</em></td>
<td align="center">false</td>
</tr>
<tr>
<td>/ssm enable</td>
<td align="center">Enables the SSM server. Default URL: <strong><a href="http://localhost:6969/">http://localhost:6969/</a></strong></td>
<td><em>ssm.enabled</em></td>
<td align="center">false</td>
</tr>
<tr>
<td>/ssm disable</td>
<td align="center">Disables the SSM server.</td>
<td><em>ssm.disabled</em></td>
<td align="center">false</td>
</tr></tbody></table>

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