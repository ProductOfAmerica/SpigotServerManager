package EmbeddedServer.Utils;

/**
 * Created by Lee on 3/16/2017.
 */
public class UnsupportedMimeException extends Exception {
    public UnsupportedMimeException() {
        super("Unsupported MIME. Choose json or multipart/form-data");
    }
}
