package EmbeddedServer.Handler.Handlers;

import EmbeddedServer.Handler.HTTPHandler;
import org.bukkit.entity.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

import static fi.iki.elonen.NanoHTTPD.*;
import static fi.iki.elonen.NanoHTTPD.Response.Status;
import static fi.iki.elonen.router.RouterNanoHTTPD.UriResource;

@SuppressWarnings("unchecked")
public class UserHandler extends HTTPHandler {
    public static final String ROUTE = "/user";

    @Override
    public Response get(UriResource uriResource, Map<String, String> urlParams, IHTTPSession session) {
        JSONObject parentJsonObj = new JSONObject();
        JSONArray players = new JSONArray();

        for (Player p : getInstance().getServer().getOnlinePlayers()) {
            LinkedHashMap<String, String> playerInfoObjects = new LinkedHashMap<>();

            // Add player's info to the JSON object
            //TODO FIX: add more to the player info later??
            playerInfoObjects.put("name", p.getName());
            playerInfoObjects.put("custom_name", p.getCustomName());
            playerInfoObjects.put("display_name", p.getDisplayName());
            playerInfoObjects.put("player_list_name", p.getPlayerListName());
            playerInfoObjects.put("host_address", p.getAddress().getAddress().getHostAddress());

            players.add(playerInfoObjects); // Add the objects into the player array
        }

        parentJsonObj.put("OnlinePlayers", players); // Add the player array into the outer JSON object

        setText(parentJsonObj.toJSONString()); // Set body content

        setStatus(Status.OK); // Set status to OK

        return newFixedLengthResponse(getStatus(), getMimeType(), getStrToByte().getInput(), getStrToByte().getSize());
    }
}