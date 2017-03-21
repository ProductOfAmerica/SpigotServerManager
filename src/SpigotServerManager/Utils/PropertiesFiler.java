package SpigotServerManager.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Created by Lee on 3/16/2017.
 */
public class PropertiesFiler extends SSMInstance {
    private Path path;

    public PropertiesFiler() {
        path = Paths.get(ssm.getDataFolder().getParentFile().getAbsolutePath())
                .getParent().resolve("server.properties");
    }

    /**
     * Sets/creates a property value in the server.properties file.
     * @param property The name of the property you wish to set.
     * @param value    The value of the property you are modifying.
     */
    public void setProperty(String property, String value) {
        try {
            FileInputStream in = new FileInputStream(path.toFile());
            Properties props = new Properties();
            props.load(in);
            in.close();

            FileOutputStream out = new FileOutputStream(path.toFile());
            props.setProperty(property, value);
            props.store(out, "Minecraft server properties - Edited by SpigotServerManager");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}