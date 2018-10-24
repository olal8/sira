package mx.com.sira.backend.service;

import mx.com.sira.backend.domain.Horario;
import mx.com.sira.backend.excepciones.HorarioException;

import java.util.List;

/**
 * Created by gerry on 10/24/18.
 */
public interface HorarioService {
    Horario getHorario(Long id) throws HorarioException;

    List<Horario> getHorarios() throws HorarioException;

    void guardarHorario(Horario horario) throws HorarioException;

    void modificarHorario(Horario horario) throws HorarioException;
}
