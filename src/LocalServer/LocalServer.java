package LocalServer;

import LocalServer.Handlers.MotdHandler;
import LocalServer.Handlers.UserHandler;
import Main.SpigotServerManager;
import fi.iki.elonen.router.RouterNanoHTTPD;

import java.io.IOException;

public class LocalServer extends RouterNanoHTTPD {
    private static final int PORT = 9090;
    private static boolean isLocalTest = false; //REMOVE

    public static void main(String[] args) throws IOException { //REMOVE
        isLocalTest = true;
        LocalServer server = new LocalServer();
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
    public LocalServer() {
        super(PORT);

        if (!isLocalTest) //REMOVE
            SpigotServerManager.getInstance().getLogger().info("Running on http://localhost:" + PORT + "/");
        else //REMOVE
            System.out.println("Running on http://localhost:" + PORT + "/"); //REMOVE
        addMappings();
    }

    public LocalServer startServer() {
        try {
            start(5000, false);
        } catch (IOException var3) {
            System.err.println("Couldn\'t start server:\n" + var3);
            System.exit(-1);
        }
        return this;
    }

    public void stopServer() {
        stop();
    }

    /**
     * Add the routes Every route is an absolute path Parameters starts with ":"
     * Handler class should implement @UriResponder interface If the handler not
     * implement UriResponder interface - toString() is used
     */
    @Override
    public void addMappings() {
        super.addMappings();
        addRoute("/users", UserHandler.class);
        addRoute("/motd", MotdHandler.class);
//        addRoute("/user/help", GeneralHandler.class);
//        addRoute("/user/:id", UserHandler.class);
//        addRoute("/general/:param1/:param2", GeneralHandler.class);
//        addRoute("/photos/:customer_id/:photo_id", null);
//        addRoute("/test", String.class);
//        addRoute("/stream", StreamUrl.class);
    }
}