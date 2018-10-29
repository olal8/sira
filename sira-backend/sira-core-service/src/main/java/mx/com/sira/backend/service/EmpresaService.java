package mx.com.sira.backend.service;

import mx.com.sira.backend.domain.Empresa;
import mx.com.sira.backend.excepciones.EmpresaException;

import java.util.List;

/**
 * Created by gerry on 10/28/18.
 */
public interface EmpresaService {
    List<Empresa> getEmpresas() throws EmpresaException;

    Empresa getEmpresa(long idEmpresa) throws EmpresaException;

    void guardarEmpresa(Empresa empresa) throws EmpresaException;

    void modificarEmpresa(Empresa empresa) throws EmpresaException;
}
