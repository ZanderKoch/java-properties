package beans;

import java.io.InputStream;
import java.util.Properties;
import javax.ejb.Stateless;

/**
 *
 * @author Zander Koch
 */
@Stateless
public class PropertiesBean {

    public String getProp(String key) {
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classloader.getResourceAsStream("config.properties");
            
            Properties properties = new Properties();
            properties.load(inputStream);
            
            return properties.getProperty(key);
        }
        catch(Exception e){
            return "no value is set";
        }
    }
}
