package dzq.group.mark.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    public static String getValue(String fileName,String key) throws IOException {

        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        Properties prop = new Properties();
        prop.load(in);
        return prop.getProperty(key);

    }
}
