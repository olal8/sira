package mx.com.sira.backend.excepciones;

/**
 * Created by gerry on 26/09/18.
 */
public class EmpleadoException extends Exception {
    public EmpleadoException(String mensaje) {
        super(mensaje);
    }

    public EmpleadoException(String mensaje, Throwable ex) {
        super(mensaje, ex);
    }
}
