package mx.com.sira.backend.service;

import mx.com.sira.backend.domain.Empleado;
import mx.com.sira.backend.excepciones.EmpleadoException;

import java.util.List;

/**
 * Created by gerry on 26/09/18.
 */
public interface EmpleadoService {
    List<Empleado> getEmpleados()throws EmpleadoException;

    Empleado getEmpleado(long idEmpleado)throws EmpleadoException;

    void guardarEmpleado(Empleado empleado) throws EmpleadoException ;

    void modificarEmpleado(Empleado empleado)throws EmpleadoException;
}
