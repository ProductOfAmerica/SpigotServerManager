package EmbeddedServer.Handler.Handlers;

import EmbeddedServer.Handler.HTTPHandler;
import EmbeddedServer.Utils.UnsupportedMimeException;
import SpigotServerManager.Utils.Logger.SSMLogger;
import fi.iki.elonen.NanoHTTPD.Response;
import fi.iki.elonen.router.RouterNanoHTTPD;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.util.Map;

import static fi.iki.elonen.NanoHTTPD.IHTTPSession;
import static fi.iki.elonen.NanoHTTPD.Method;

/**
 * Created by Lee on 3/17/2017.
 */
public class StopHandler extends HTTPHandler {
    public static final String ROUTE = "/stop";
    public static final String ROUTE2 = "/restart";
    private static final String SECONDS = "seconds";
    private static final String RESTART_PATH = "restartPath";
    private static final int DEFAULT_SECONDS = 60;

    @Override
    public Response get(RouterNanoHTTPD.UriResource uriResource, Map<String, String> urlParams, IHTTPSession session) {
        if (session.getMethod().equals(Method.DELETE)) { // ONLY accept DELETE method
            switch (session.getUri()) {
                case ROUTE:
                    shutDown(session, false); // Shut down the server
                    break;
                case ROUTE2:
                    shutDown(session, true); // Restart the server
                    break;
            }
        }
        return super.get(uriResource, urlParams, session);
    }

    private void shutDown(IHTTPSession session, boolean restart) {
        try {
            if (session.getInputStream().available() > 0) { // We have content in the body
                JSONObject body = getBody(session);

                if (body.containsKey(RESTART_PATH)) { // If we're going to restart using a file...
                    String restartPath = body.get(RESTART_PATH).toString();

                    if (body.containsKey(SECONDS)) {
                        restartSequence((long) body.get(SECONDS), restartPath); // Shut down and execute script
                    } else {
                        shutDownSequence(DEFAULT_SECONDS, restart); // Shut down in time specified in body
                    }

                } else {
                    shutDownSequence((long) body.get(SECONDS), restart); // Shut down in time specified in body
                }
            } else {
                shutDownSequence(DEFAULT_SECONDS, restart); // Shut down in 60 seconds
            }

            setStatus(Response.Status.OK); // Succeeds to shutdown

        } catch (ParseException | UnsupportedMimeException | IOException e) {
            logBadRequest(session, e);
        }
    }

    private void shutDownSequence(long seconds, boolean restart) {
        final long[] secs = {seconds};
        new BukkitRunnable() {
            @Override
            public void run() {
                if (secs[0] <= 0) {
                    SSMLogger.broadcastMessage(ChatColor.RED, "Server shutting down.");
                    getInstance().getServer().dispatchCommand(Bukkit.getConsoleSender(), restart ? "restart" : "stop");
                    cancel(); //Cancels the shutDownSequence
                } else {
                    if (secs[0] % 10 == 0 || secs[0] <= 5)
                        SSMLogger.broadcastMessage(ChatColor.RED, "Server shutting down in " + secs[0] + "...");
                    secs[0]--;
                }
            }
        }.runTaskTimer(getInstance(), 0L, 20L);
    }

    private void restartSequence(long seconds, String path) {

        throw new NotImplementedException(); //REMOVE
    }
}