package mx.com.sira.backend.service.impl;

import mx.com.sira.backend.domain.Empresa;
import mx.com.sira.backend.excepciones.EmpresaException;
import mx.com.sira.backend.mensajes.Mensajes;
import mx.com.sira.backend.persistence.EmpresaRepository;
import mx.com.sira.backend.service.EmpresaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by gerry on 10/28/18.
 */
@Service
@Scope("prototype")
public class EmpresaServiceEmpl implements EmpresaService {
    private static final Logger LOG = LoggerFactory.getLogger(EmpresaServiceEmpl.class);
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private Mensajes mensajes;

    @Override
    public List<Empresa> getEmpresas() throws EmpresaException {
        List<Empresa> empresas = new ArrayList<>();
        try {
            empresas = empresaRepository.findAll();
        } catch (Exception ex) {
            LOG.error("Ocurrio un error al consultar los datos {}", ex);
            throw new EmpresaException(mensajes.getMensaje("empresa.error1"), ex);
        }
        return empresas;
    }

    @Override
    public Empresa getEmpresa(long idEmpresa) throws EmpresaException {
        Empresa empresa = null;
        try {
            empresa = empresaRepository.findById(idEmpresa).get();
        } catch (Exception ex) {
            LOG.error("Error al obtener la empresa con la clave {}", idEmpresa);
            throw new EmpresaException(mensajes.getMensaje("empresa.error2"), ex);
        }
        return empresa;
    }

    @Transactional(rollbackFor = {Exception.class, EmpresaException.class})
    @Override
    public void guardarEmpresa(Empresa empresa) throws EmpresaException {
        try {
            empresa.setFechaRegistro(new Date());
            empresaRepository.save(empresa);
        } catch (Exception ex) {
            LOG.error("Error al guardar la empresa", ex);
            throw new EmpresaException(mensajes.getMensaje("empresa.error3"), ex);
        }
    }

    @Transactional(rollbackFor = {Exception.class, EmpresaException.class})
    @Override
    public void modificarEmpresa(Empresa empresa) throws EmpresaException {
        try {
            empresaRepository.save(empresa);
        } catch (Exception ex) {
            LOG.error("Error al modificar los datos de la empresa", ex);
            throw new EmpresaException(mensajes.getMensaje("empresa.error4"));
        }
    }
}
