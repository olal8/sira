package mx.com.sira.backend.controller;

import mx.com.sira.backend.domain.Empresa;
import mx.com.sira.backend.domain.Giro;
import mx.com.sira.backend.excepciones.EmpresaException;
import mx.com.sira.backend.service.EmpresaService;
import mx.com.sira.backend.service.GiroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by gerry on 10/28/18.
 */
@RestController
public class EmpresaController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmpresaController.class);
    @Autowired
    private EmpresaService empresaService;
    @Autowired
    private GiroService giroService;

    @RequestMapping(value = "/empresa/", method = RequestMethod.GET)
    public ResponseEntity<List<Empresa>> obtenerEmpresas() {
        List<Empresa> empresas = new ArrayList<>();
        try {
            empresas = empresaService.getEmpresas();
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Empresa>>(empresas, HttpStatus.OK);
    }

    @RequestMapping(value = "/empresa/{id}", method = RequestMethod.GET)
    public ResponseEntity<Empresa> obtenerEmpresa(@PathVariable("id") long id) throws EmpresaException {
        Empresa empresa = null;
        empresa = empresaService.getEmpresa(id);
        return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
    }

    @RequestMapping(value = "/empresa/", method = RequestMethod.POST)
    public ResponseEntity<List<Empresa>> crearEmpresa(@RequestBody Empresa empresa) throws EmpresaException {
        List<Empresa> listaEmpresa = new ArrayList<>();
        empresaService.guardarEmpresa(empresa);
        listaEmpresa = empresaService.getEmpresas();
        return new ResponseEntity<List<Empresa>>(listaEmpresa, HttpStatus.OK);
    }

    @RequestMapping(value = "/empresa/{id}", method = RequestMethod.PUT)
    public ResponseEntity<List<Empresa>> modificarEmpresa(@PathVariable("id") long id, @RequestBody Empresa empresa) throws EmpresaException {
        List<Empresa> empresas = new ArrayList<>();
        Empresa empresaActual = empresaService.getEmpresa(id);
        empresaActual.setCoordenada_x(empresa.getCoordenada_x());
        empresaActual.setCoordenada_y(empresa.getCoordenada_y());
        empresas = empresaService.getEmpresas();
        return new ResponseEntity<List<Empresa>>(empresas, HttpStatus.OK);
    }

    @RequestMapping(value = "/giro/", method = RequestMethod.GET)
    public ResponseEntity<List<Giro>> obtenerGiros() {
        List<Giro> giros = new ArrayList<>();
        try {
            giros = giroService.listadoGiros();
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Giro>>(giros, HttpStatus.OK);
    }
}
