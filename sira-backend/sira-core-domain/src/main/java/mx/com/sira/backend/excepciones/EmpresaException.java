package mx.com.sira.backend.excepciones;

/**
 * Created by gerry on 10/28/18.
 */
public class EmpresaException extends Exception {
    public EmpresaException(String mensaje) {
        super(mensaje);
    }

    public EmpresaException(String mensaje, Throwable ex) {
        super(mensaje, ex);
    }
}
