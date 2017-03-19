package EmbeddedServer;

import EmbeddedServer.Handler.Handlers.*;
import SpigotServerManager.Utils.Logger.SSMLogger;
import fi.iki.elonen.router.RouterNanoHTTPD;

import java.io.IOException;

public class LocalServer extends RouterNanoHTTPD {
    private final String username, password;

    /**
     * Create the server instance
     */
    public LocalServer(int port, String username, String password) {
        super(port);
        this.username = username;
        this.password = password;
    }

    public LocalServer startServer() {
        try {
            addMappings();
            start(5000, false);
            SSMLogger.log("Running on http://localhost:" + getListeningPort() + "/");
        } catch (IOException var3) {
            SSMLogger.logSevere("Couldn't start server");
        }
        return this;
    }

    public void stopServer() {
        SSMLogger.logWarning("You will not be able to connect to SSM any longer.");
        stop();
    }

    /**
     * Add the routes Every route is an absolute path Parameters starts with ":"
     * Handler class should implement @UriResponder interface
     */
    @Override
    public void addMappings() {
        super.addMappings(); // Add default routes
        removeRoute("/"); // Remove the default route for "/"
        removeRoute("/index.html"); // Remove the default route for "/index.html"
        addRoute("/", HomePageHandler.class);           // Add default route
        addRoute("/index.html", HomePageHandler.class); // Add default route
        addRoute(UserHandler.ROUTE, UserHandler.class); // Add route: GET /user
        addRoute(MOTDHandler.ROUTE, MOTDHandler.class); // Add route: PUSH /motd
        addRoute(MsgHandler.ROUTE1, MsgHandler.class);  // Add route: PUSH /msg
        addRoute(MsgHandler.ROUTE2, MsgHandler.class);  // Add route: PUSH /say
        addRoute(StopHandler.ROUTE, StopHandler.class); // Add route: DELETE /stop
        addRoute(StopHandler.ROUTE2, StopHandler.class);// Add route: DELETE /restart
    }
}