package mx.com.sira.backend.service.impl;

import mx.com.sira.backend.domain.Empleado;
import mx.com.sira.backend.excepciones.EmpleadoException;
import mx.com.sira.backend.mensajes.Mensajes;
import mx.com.sira.backend.persistence.EmpleadoRepository;
import mx.com.sira.backend.service.EmpleadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gerry on 26/09/18.
 */
@Service
@Scope("prototype")
public class EmpleadoServiceImpl implements EmpleadoService {
    private Logger LOG= LoggerFactory.getLogger(EmpleadoServiceImpl.class);
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private Mensajes mensajes;

    @Override
    public List<Empleado> getEmpleados()throws EmpleadoException{
        List<Empleado> empleados=new ArrayList<>();
        try{
            empleados=empleadoRepository.findAll();
        }catch (Exception ex){
            LOG.error("Ocurrio un error al consultar los datos {}",ex);
           throw new EmpleadoException(mensajes.getMensaje("empleados.error1"),ex);
        }
        return empleados;
    }

    @Override
    public Empleado getEmpleado(int idEmpleado) {
        return null;
    }

    @Override
    public void guardarEmpleado(Empleado empleado) {

    }

    @Override
    public int modificarEmpleado(Empleado empleado) {
        return 0;
    }
}
