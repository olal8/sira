package mx.com.sira.backend.mensajes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by gerry on 26/09/18.
 */
@Configuration
@PropertySource("errores.properties")
public class Mensajes {
    @Autowired
    Environment enviroment;

    public String getMensaje(String nombreError) {
        return enviroment.getProperty(nombreError);
    }
}
