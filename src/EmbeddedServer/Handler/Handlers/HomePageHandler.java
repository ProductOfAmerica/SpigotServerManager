package EmbeddedServer.Handler.Handlers;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.router.RouterNanoHTTPD;

public class HomePageHandler extends RouterNanoHTTPD.DefaultHandler {
    public HomePageHandler() {
    }

    public String getText() {
        return "<html><body><h2>Spigot Server Manager is working!</h3></body></html>";
    }

    public String getMimeType() {
        return "text/html";
    }

    public NanoHTTPD.Response.IStatus getStatus() {
        return NanoHTTPD.Response.Status.OK;
    }
}