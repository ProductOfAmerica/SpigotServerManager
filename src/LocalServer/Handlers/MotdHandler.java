package LocalServer.Handlers;

import LocalServer.Utils.HTTPHandler;
import LocalServer.Utils.IHTTPGetBody;
import LocalServer.Utils.UnsupportedMimeException;
import SpigotServerManager.Utils.PropertiesFiler;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Map;

import static fi.iki.elonen.NanoHTTPD.IHTTPSession;
import static fi.iki.elonen.NanoHTTPD.Response;
import static fi.iki.elonen.NanoHTTPD.Response.Status;
import static fi.iki.elonen.router.RouterNanoHTTPD.UriResource;

/**
 * Created by Lee on 3/16/2017.
 */
public class MotdHandler extends HTTPHandler {
    private final String MOTD = "motd";

    @Override
    public Response post(UriResource uriResource, Map<String, String> urlParams, IHTTPSession session) {
        try {
            String body = new IHTTPGetBody().getBody(session);
            String motd = ((JSONObject) new JSONParser().parse(body)).get(MOTD).toString();

            PropertiesFiler propertiesFiler = new PropertiesFiler(getInstance());
            propertiesFiler.setProperty(MOTD, motd);

            setStatus(Status.OK);
            getLogger().info(String.format("Successfully changed the MOTD to: \"%s\"", motd));
            getLogger().info("Restart your server for changed to take effect.");
        } catch (ParseException | UnsupportedMimeException | IOException e) {
            e.printStackTrace();
            setStatus(Status.NOT_ACCEPTABLE);
        }

        return super.post(uriResource, urlParams, session);
    }
}