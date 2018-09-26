package mx.com.sira.backend.controller;

import mx.com.sira.backend.domain.Empleado;
import mx.com.sira.backend.service.EmpleadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/empleado/", method = RequestMethod.GET)
    public ResponseEntity<?> listarEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        try {
            empleados = empleadoService.getEmpleados();
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Empleado>>(empleados, HttpStatus.OK);
    }
}
