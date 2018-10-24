package mx.com.sira.backend.controller;

import mx.com.sira.backend.domain.Horario;
import mx.com.sira.backend.excepciones.HorarioException;
import mx.com.sira.backend.mensajes.Mensajes;
import mx.com.sira.backend.service.HorarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gerry on 10/24/18.
 */
@RestController
public class HorarioController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HorarioController.class);
    @Autowired
    private Mensajes mensajes;
    @Autowired
    private HorarioService horarioService;

    @RequestMapping(value = "/horario/", method = RequestMethod.GET)
    public ResponseEntity<List<Horario>> listarHorarios() {
        List<Horario> horarios = new ArrayList<>();
        try {
            horarios = horarioService.getHorarios();
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Horario>>(horarios, HttpStatus.OK);
    }

    @RequestMapping(value = "/horario/{id}", method = RequestMethod.GET)
    public ResponseEntity<Horario> obtenerHorario(@PathVariable("id") long id) throws HorarioException {
        Horario horario = horarioService.getHorario(id);
        return new ResponseEntity<Horario>(horario, HttpStatus.OK);
    }

    @RequestMapping(value = "/horario/", method = RequestMethod.POST)
    public ResponseEntity<List<Horario>> crearHorario(@RequestBody Horario horario) throws HorarioException {
        List<Horario> horarios = new ArrayList<>();
        horarioService.guardarHorario(horario);
        horarios = horarioService.getHorarios();
        return new ResponseEntity<List<Horario>>(horarios, HttpStatus.OK);
    }

    @RequestMapping(value = "/horario/{id}", method = RequestMethod.PUT)
    public ResponseEntity<List<Horario>> modificarHorario(@PathVariable("id") long id, @RequestBody Horario horarioModificado) throws HorarioException {
        List<Horario> horarios = new ArrayList<>();
        Horario horarioActual = horarioService.getHorario(id);
        horarioActual.setEstatus(horarioModificado.isEstatus());
        horarioActual.setDescripcion(horarioModificado.getDescripcion());
        horarioActual.setHoraEntrada(horarioModificado.getHoraEntrada());
        horarioActual.setHoraSalida(horarioModificado.getHoraSalida());
        horarioService.modificarHorario(horarioActual);
        horarios = horarioService.getHorarios();
        return new ResponseEntity<List<Horario>>(horarios, HttpStatus.OK);
    }
}
