package mx.com.sira.backend.service;

import mx.com.sira.backend.domain.Empleado;
import mx.com.sira.backend.excepciones.EmpleadoException;

import java.util.List;

/**
 * Created by gerry on 26/09/18.
 */
public interface EmpleadoService {
    List<Empleado> getEmpleados()throws EmpleadoException;

    Empleado getEmpleado(int idEmpleado);

    void guardarEmpleado(Empleado empleado);

    int modificarEmpleado(Empleado empleado);
}
