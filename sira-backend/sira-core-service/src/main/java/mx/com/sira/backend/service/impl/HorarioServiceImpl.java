package mx.com.sira.backend.service.impl;

import mx.com.sira.backend.domain.Horario;
import mx.com.sira.backend.excepciones.HorarioException;
import mx.com.sira.backend.mensajes.Mensajes;
import mx.com.sira.backend.persistence.HorarioRepository;
import mx.com.sira.backend.service.HorarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gerry on 10/24/18.
 */
@Service
public class HorarioServiceImpl implements HorarioService {
    private static final Logger LOG = LoggerFactory.getLogger(HorarioServiceImpl.class);
    @Autowired
    private HorarioRepository horarioRepository;
    @Autowired
    private Mensajes mensajes;

    @Transactional(readOnly = true)
    @Override
    public Horario getHorario(Long id) throws HorarioException {
        Horario horario = null;
        try {
            horario = horarioRepository.findById(id).get();
        } catch (Exception ex) {
            LOG.error("Error al obtener el horario con id {} ", id);
            throw new EntityNotFoundException(mensajes.getMensaje("horario.error1"));
        }
        return horario;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Horario> getHorarios() throws HorarioException {
        List<Horario> horarios = new ArrayList<>();
        try {
            horarios = horarioRepository.getHorarios();
        } catch (Exception ex) {
            LOG.error("No se recupero el listado de horarios", ex);
            throw new HorarioException(mensajes.getMensaje("horario.error2"));
        }
        return horarios;
    }

    @Transactional(rollbackFor = {Exception.class, HorarioException.class})
    @Override
    public void guardarHorario(Horario horario) throws HorarioException {
        try {
            horarioRepository.save(horario);
        } catch (Exception ex) {
            LOG.error("Error al guardar los datos del horario", ex);
            throw new HorarioException(mensajes.getMensaje("horario.error3"));
        }
    }

    @Transactional(rollbackFor = {Exception.class, HorarioException.class})
    @Override
    public void modificarHorario(Horario horario) throws HorarioException {
        try {
            horarioRepository.save(horario);
        } catch (Exception ex) {
            LOG.error("Error al modificar los datos del horario", ex);
            throw new HorarioException(mensajes.getMensaje("horario.error4"));
        }
    }
}
