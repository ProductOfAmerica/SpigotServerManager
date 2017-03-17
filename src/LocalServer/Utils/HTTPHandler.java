package LocalServer.Utils;

import Main.SpigotServerManager;

import java.util.logging.Logger;

import static fi.iki.elonen.NanoHTTPD.Response.IStatus;
import static fi.iki.elonen.NanoHTTPD.Response.Status;
import static fi.iki.elonen.router.RouterNanoHTTPD.DefaultHandler;

/**
 * Created by Lee on 3/15/2017.
 */
public class HTTPHandler extends DefaultHandler {
    private String json;
    private Status status = Status.NOT_IMPLEMENTED;

    @Override
    public String getText() {
        return json;
    }

    @Override
    public String getMimeType() {
        return "application/json";
    }

    @Override
    public IStatus getStatus() {
        return status;
    }

    protected static SpigotServerManager getInstance() {
        return SpigotServerManager.getInstance();
    }

    protected Logger getLogger(){
        return getInstance().getLogger();
    }

    protected void setText(String json) {
        this.json = json;
    }

    protected void setStatus(Status status) {
        this.status = status;
    }

    protected StrToByte getStrToByte() {
        return new StrToByte(getText());
    }
}
