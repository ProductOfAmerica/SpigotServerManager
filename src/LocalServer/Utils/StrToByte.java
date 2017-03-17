package LocalServer.Utils;

import java.io.ByteArrayInputStream;

public class StrToByte {
    private ByteArrayInputStream input;
    private int size;

    public StrToByte(String text) {
        input = new ByteArrayInputStream(text.getBytes());
        size = text.getBytes().length;
    }

    public ByteArrayInputStream getInput() {
        return input;
    }

    public int getSize() {
        return size;
    }
}