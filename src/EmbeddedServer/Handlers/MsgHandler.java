package EmbeddedServer.Handlers;

import EmbeddedServer.Utils.Logger.SSMLogger;
import org.bukkit.ChatColor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.Map;

import static fi.iki.elonen.NanoHTTPD.IHTTPSession;
import static fi.iki.elonen.NanoHTTPD.Response;
import static fi.iki.elonen.router.RouterNanoHTTPD.UriResource;

/**
 * Created by Lee on 3/17/2017.
 */
@SuppressWarnings("unchecked")
public class MsgHandler extends HTTPHandler {
    public static final String ROUTE1 = "/msg";
    public static final String ROUTE2 = "/say";
    private final String MESSAGE = "msg";
    private final String USERS = "users";

    @Override
    public Response post(UriResource uriResource, Map<String, String> urlParams, IHTTPSession session) {
        try {
            JSONObject json = getBody(session);
            String message = json.get(MESSAGE).toString();

            switch (session.getUri()) {
                case ROUTE1: // We got the /msg/:username route
                    JSONArray users = (JSONArray) new JSONParser().parse(json.get(USERS).toString());
                    users.stream().filter(o -> o.toString() != null).forEach(playerName ->
                            SSMLogger.sendPlayerMessage(ChatColor.WHITE, playerName.toString(), message));
                    break;
                case ROUTE2: // We got the /say route
                    getInstance().getServer().broadcastMessage(message);
                    break;
            }

            setStatus(Response.Status.OK); // Everything worked
        } catch (Exception e) {
            SSMLogger.logSevere(String.format("\"%s %s\": %s", session.getMethod(), session.getUri(), e.getMessage()));
            setStatus(Response.Status.BAD_REQUEST);
        }

        return super.post(uriResource, urlParams, session);
    }
}
