package EmbeddedServer.Handlers;

import EmbeddedServer.Utils.Logger.SSMLogger;
import EmbeddedServer.Utils.UnsupportedMimeException;
import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoHTTPD.Response;
import fi.iki.elonen.router.RouterNanoHTTPD;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Map;

import static fi.iki.elonen.NanoHTTPD.Response.Status;

/**
 * Created by Lee on 3/17/2017.
 */
public class StopHandler extends HTTPHandler {
    public static final String ROUTE = "/stop";
    private final String SECONDS = "seconds";
    private final int DEFAULT_SECONDS = 60;

    @Override
    public Response get(RouterNanoHTTPD.UriResource uriResource, Map<String, String> urlParams, NanoHTTPD.IHTTPSession session) {
        if (session.getMethod().equals(NanoHTTPD.Method.DELETE)) { // ONLY accept DELETE method
            try {
                if (session.getInputStream().available() > 0) { // We have content in the body
                    String seconds = (getBody(session)).get(SECONDS).toString();
                    shutDownSequence(Integer.parseInt(seconds)); // Shut down in time specified in body
                } else {
                    shutDownSequence(DEFAULT_SECONDS); // Shut down in 60 seconds
                }

                setStatus(Status.OK); // Succeeds to shutdown
            } catch (ParseException | UnsupportedMimeException | IOException e) {
                SSMLogger.log(String.format("\"%s %s\": %s", session.getMethod(), session.getUri(), e.getMessage()));
                setStatus(Status.BAD_REQUEST);
            }
        }
        return super.get(uriResource, urlParams, session);
    }

    private void shutDownSequence(int count) {
        final int[] secs = {count};
        new BukkitRunnable() {
            @Override
            public void run() {
                if (secs[0] <= 0) {
                    SSMLogger.broadcastMessage(ChatColor.RED, "Server shutting down.");
                    getInstance().getServer().dispatchCommand(Bukkit.getConsoleSender(), "stop");
                    cancel(); //Cancels the shutDownSequence
                } else {
                    if (--secs[0] % 10 == 0 || secs[0] <= 5)
                        SSMLogger.broadcastMessage(ChatColor.RED, "Server shutting down in " + secs[0] + "...");
                }
            }
        }.runTaskTimer(getInstance(), 0L, 20L);
    }
}