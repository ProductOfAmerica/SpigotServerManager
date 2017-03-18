package EmbeddedServer;

import EmbeddedServer.Handlers.MOTDHandler;
import EmbeddedServer.Handlers.MsgHandler;
import EmbeddedServer.Handlers.StopHandler;
import EmbeddedServer.Handlers.UserHandler;
import EmbeddedServer.Utils.Logger.SSMLogger;
import fi.iki.elonen.router.RouterNanoHTTPD;

import java.io.IOException;

public class LocalServer extends RouterNanoHTTPD {
    private static boolean isLocalTest = false; //REMOVE

    public static void main(String[] args) throws IOException { //REMOVE
        isLocalTest = true;
        LocalServer server = new LocalServer(9090);
        try {
            server.start(5000, false);
        } catch (IOException var3) {
            System.err.println("Couldn\'t start server:\n" + var3);
            System.exit(-1);
        }
    }

    /**
     * Create the server instance
     */
    public LocalServer(int port) {
        super(port);
    }

    public LocalServer startServer() {
        try {
            addMappings();
            start(5000, false);
            if (!isLocalTest) //REMOVE
                SSMLogger.log("Running on http://localhost:" + getListeningPort() + "/");
            else //REMOVE
                System.out.println("Running on http://localhost:" + getListeningPort() + "/"); //REMOVE
        } catch (IOException var3) {
            if (!isLocalTest) //REMOVE
                SSMLogger.logSevere("Couldn't start server");
            else //REMOVE
                System.out.println("Couldn't start server"); //REMOVE
        }
        return this;
    }

    public void stopServer() {
        if (!isLocalTest) //REMOVE
            SSMLogger.logWarning("You will not be able to connect to your server any longer.");
        stop();
    }

    /**
     * Add the routes Every route is an absolute path Parameters starts with ":"
     * Handler class should implement @UriResponder interface If the handler not
     * implement UriResponder interface - toString() is used
     */
    @Override
    public void addMappings() {
        super.addMappings(); // Add default mappings
        addRoute(UserHandler.ROUTE, UserHandler.class); // GET /user
        addRoute(MOTDHandler.ROUTE, MOTDHandler.class); // PUSH /motd
        addRoute(MsgHandler.ROUTE1, MsgHandler.class);  // PUSH /msg
        addRoute(MsgHandler.ROUTE2, MsgHandler.class);  // PUSH /say
        addRoute(StopHandler.ROUTE, StopHandler.class); // DELETE /stop
    }
}