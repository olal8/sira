package mx.com.sira.backend.excepciones;

/**
 * Created by gerry on 10/24/18.
 */
public class HorarioException extends Exception {
    public HorarioException(String mensaje) {
        super(mensaje);
    }

    public HorarioException(String mensaje, Throwable ex) {
        super(mensaje, ex);
    }
}
