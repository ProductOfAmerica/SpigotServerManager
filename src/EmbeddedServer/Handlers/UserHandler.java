package EmbeddedServer.Handlers;

import EmbeddedServer.Utils.HTTPHandler;
import org.bukkit.entity.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

import static fi.iki.elonen.NanoHTTPD.*;
import static fi.iki.elonen.NanoHTTPD.Response.Status;
import static fi.iki.elonen.router.RouterNanoHTTPD.UriResource;

public class UserHandler extends HTTPHandler {
    public UserHandler() {
        setStatus(Status.OK);
    }

    @Override
    public Response get(UriResource uriResource, Map<String, String> urlParams, IHTTPSession session) {
        JSONObject obj = new JSONObject();
        JSONArray players = new JSONArray();

        for (Player p : getInstance().getServer().getOnlinePlayers()) {
            LinkedHashMap<String, String> m1 = new LinkedHashMap<>();

            m1.put("name", p.getName());
            m1.put("custom_name", p.getCustomName());
            m1.put("display_name", p.getDisplayName());
            m1.put("player_list_name", p.getPlayerListName());
            m1.put("host_address", p.getAddress().getAddress().getHostAddress());
            players.add(m1);
        }

        obj.put("OnlinePlayers", players);

        setText(obj.toJSONString());

        return newFixedLengthResponse(getStatus(), getMimeType(), getStrToByte().getInput(), getStrToByte().getSize());
    }
}