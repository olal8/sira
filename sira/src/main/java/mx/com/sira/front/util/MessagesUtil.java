package mx.com.sira.front.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by gerry on 09/10/18.
 */
@Configuration
@PropertySource("mensajesFront.properties")
public class MessagesUtil {
    @Autowired
    Environment enviroment;

    public String getMensaje(String nombreError) {
        return enviroment.getProperty(nombreError);
    }
}