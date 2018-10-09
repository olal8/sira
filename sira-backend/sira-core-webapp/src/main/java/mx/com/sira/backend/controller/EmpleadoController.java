package mx.com.sira.backend.controller;

import mx.com.sira.backend.domain.Empleado;
import mx.com.sira.backend.excepciones.EmpleadoException;
import mx.com.sira.backend.mensajes.Mensajes;
import mx.com.sira.backend.service.EmpleadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gerry on 26/09/18.
 */
@RestController
public class EmpleadoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmpleadoController.class);
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private Mensajes mensajes;

    @RequestMapping(value = "/empleado/", method = RequestMethod.GET)
    public ResponseEntity<List<Empleado>> listarEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        try {
            empleados = empleadoService.getEmpleados();
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Empleado>>(empleados, HttpStatus.OK);
    }

    @RequestMapping(value = "/empleado/{id}", method = RequestMethod.GET)
    public ResponseEntity<Empleado> obtenerEmpleado(@PathVariable("id") long id) throws EmpleadoException {
        Empleado empleado = null;
        empleado = empleadoService.getEmpleado(id);
        return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
    }

    @RequestMapping(value = "/empleado/", method = RequestMethod.POST)
    public ResponseEntity<List<Empleado>> crearEmpleado(@RequestBody Empleado empleado) throws EmpleadoException {
        List<Empleado> listaEmpleados = new ArrayList<>();
        empleadoService.guardarEmpleado(empleado);
        listaEmpleados = empleadoService.getEmpleados();
        return new ResponseEntity<>(listaEmpleados, HttpStatus.OK);
    }

    @RequestMapping(value = "/empleado/{id}", method = RequestMethod.PUT)
    public ResponseEntity<List<Empleado>> actualizarEmpleado(@PathVariable("id") long id, @RequestBody Empleado empleado) throws EmpleadoException {
        List<Empleado> empleados = new ArrayList<>();
        try {
            Empleado empleadoActual = empleadoService.getEmpleado(id);

            empleadoActual.setCalle(empleado.getCalle());
            empleadoActual.setColonia(empleado.getColonia());
            empleadoActual.setCp(empleado.getCp());
            empleadoActual.setFechaNacimiento(empleado.getFechaNacimiento());
            empleadoActual.setNumExterior(empleado.getNumExterior());
            empleadoActual.setNumInterior(empleado.getNumInterior());
            empleadoActual.setTelefono(empleado.getTelefono());
            empleadoService.modificarEmpleado(empleadoActual);
            empleados = empleadoService.getEmpleados();
        } catch (EntityNotFoundException en) {
            throw new EmpleadoException(en.getMessage());
        } catch (Exception ex) {
            throw new EmpleadoException(ex.getMessage());
        }
        return new ResponseEntity<List<Empleado>>(empleados, HttpStatus.OK);
    }

    @RequestMapping(value = "/empleado/delete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<List<Empleado>> eliminarEmpleado(@PathVariable("id") long id, @RequestBody Empleado empleado) throws EmpleadoException {
        List<Empleado> empleados = new ArrayList<>();
        try {
            Empleado empleadoActual = empleadoService.getEmpleado(id);
            empleadoActual.setEstatus(false);
            empleadoService.modificarEmpleado(empleadoActual);
            empleados = empleadoService.getEmpleados();
        } catch (EntityNotFoundException en) {
            throw new EmpleadoException(en.getMessage());
        } catch (Exception ex) {
            throw new EmpleadoException(ex.getMessage());
        }
        return new ResponseEntity<List<Empleado>>(empleados, HttpStatus.OK);
    }
}
