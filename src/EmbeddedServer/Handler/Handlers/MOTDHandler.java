package EmbeddedServer.Handler.Handlers;

import EmbeddedServer.Handler.HTTPHandler;
import EmbeddedServer.Utils.UnsupportedMimeException;
import SpigotServerManager.Utils.Logger.SSMLogger;
import SpigotServerManager.Utils.PropertiesFiler;
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
public class MOTDHandler extends HTTPHandler {
    public static final String ROUTE = "/motd";
    private static final String MOTD = "motd";

    @Override
    public Response post(UriResource uriResource, Map<String, String> urlParams, IHTTPSession session) {
        try {
            String motd = getBody(session).get(MOTD).toString();

            PropertiesFiler propertiesFiler = new PropertiesFiler();
            propertiesFiler.setProperty(MOTD, motd);

            setStatus(Status.OK);
            SSMLogger.logOk(String.format("Successfully changed the MOTD to: \"%s\". " +
                    "Restart your server for changed to take effect.", motd));
        } catch (ParseException | UnsupportedMimeException | IOException e) {
            logBadRequest(session, e);
        }

        return super.post(uriResource, urlParams, session);
    }
}