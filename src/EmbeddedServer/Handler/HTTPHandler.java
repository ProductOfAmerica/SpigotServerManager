package EmbeddedServer.Handler;

import EmbeddedServer.Utils.StrToByte;
import EmbeddedServer.Utils.UnsupportedMimeException;
import SpigotServerManager.SpigotServerManager;
import SpigotServerManager.Utils.Logger.SSMLogger;
import fi.iki.elonen.NanoHTTPD;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import static fi.iki.elonen.NanoHTTPD.Response.IStatus;
import static fi.iki.elonen.NanoHTTPD.Response.Status;
import static fi.iki.elonen.router.RouterNanoHTTPD.DefaultHandler;

/**
 * Created by Lee on 3/15/2017.
 */
public abstract class HTTPHandler extends DefaultHandler {
    private static final String C_TYPE = "content-type";
    private static final String JSON = "application/json";
    private String json;
    private Status status = Status.NOT_FOUND;

    protected static SpigotServerManager getInstance() {
        return SpigotServerManager.getInstance();
    }

    @Override
    public String getText() {
        return json;
    }

    protected void setText(String json) {
        this.json = json;
    }

    @Override
    public String getMimeType() {
        return "application/json";
    }

    @Override
    public IStatus getStatus() {
        return status;
    }

    protected void setStatus(Status status) {
        this.status = status;
    }

    protected JSONObject getBody(NanoHTTPD.IHTTPSession session) throws UnsupportedMimeException, IOException, ParseException {
        String body = "";
        if (session.getInputStream().available() > 0
                && session.getHeaders().containsKey(C_TYPE) && session.getHeaders().get(C_TYPE).equals(JSON)) {
            while (session.getInputStream().available() > 0) {
                body += ((char) session.getInputStream().read());
            }
        } else {
            throw new UnsupportedMimeException();
        }

        return ((JSONObject) new JSONParser().parse(body));
    }

    protected StrToByte getStrToByte() {
        return new StrToByte(getText());
    }

    protected void logBadRequest(NanoHTTPD.IHTTPSession session, Exception e) {
        SSMLogger.logError(String.format("\"%s %s\": %s", session.getMethod(), session.getUri(), e.getMessage()));
        setStatus(NanoHTTPD.Response.Status.BAD_REQUEST);
    }
}
