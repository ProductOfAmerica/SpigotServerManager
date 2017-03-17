package LocalServer.Utils;

import fi.iki.elonen.NanoHTTPD;

import java.io.IOException;

/**
 * Created by Lee on 3/16/2017.
 */
public class IHTTPGetBody {
    public String getBody(NanoHTTPD.IHTTPSession session) throws UnsupportedMimeException, IOException {
        if (session.getHeaders().get("content-type").equals("application/json")) {
            String body = "";
            while (session.getInputStream().available() > 0) {
                body += ((char) session.getInputStream().read());
            }
            return body;
        } else {
            throw new UnsupportedMimeException();
        }
    }
}