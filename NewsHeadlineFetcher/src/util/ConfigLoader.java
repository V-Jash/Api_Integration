package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    public String getApi() {
        Properties props = new Properties();
        try {

            props.load(new FileInputStream("resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return props.getProperty("api.key");

    }
}
