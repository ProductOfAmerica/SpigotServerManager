package EmbeddedServer.Handler.Handlers;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.router.RouterNanoHTTPD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class HomePageHandler extends RouterNanoHTTPD.DefaultHandler {
    public HomePageHandler() {
    }

    public String getText() {
        try {
            return new BufferedReader(new InputStreamReader(getClass().
                    getResourceAsStream("/EmbeddedServer/HTML/index.html")))
                    .lines().collect(Collectors.joining("\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "<html><body><h2>Spigot Server Manager is working!" +
                "However, you should not be seeing this. Please report this.</h3></body></html>";
    }

    public String getMimeType() {
        return "text/html";
    }

    public NanoHTTPD.Response.IStatus getStatus() {
        return NanoHTTPD.Response.Status.OK;
    }
}