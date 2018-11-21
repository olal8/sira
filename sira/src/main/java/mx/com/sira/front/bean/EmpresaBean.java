package mx.com.sira.front.bean;

import mx.com.sira.front.clientes.feign.EmpresaService;
import mx.com.sira.front.dto.EmpresaDto;
import mx.com.sira.front.util.MessagesUtil;
import mx.com.sira.front.util.MsgBeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

/**
 * Created by gerry on 10/30/18.
 */
@Named
@ViewScoped
public class EmpresaBean {
    private static final Logger LOG = LoggerFactory.getLogger(EmpresaBean.class);
    @Resource
    private EmpresaService empresaService;
    private List<EmpresaDto> empresas;
    private EmpresaDto empresaSeleccionada;
    private EmpresaDto nuevaEmpresa;

    @Resource
    private MessagesUtil messagesUtil;

    @PostConstruct
    public void init() {
        setEmpresas(empresaService.getEmpresas());
        setNuevaEmpresa(new EmpresaDto());
    }

    public void initMap() {
        LOG.info("Mostrar mapa");
        MsgBeanUtil.ejecutaAccion("PF('gmapDialog').show()");
        MsgBeanUtil.ejecutaAccion("initMap()");
    }

    public void initCrearEmpresa() {
        LOG.info("Mostrando formulario para la captura de una nueva empresa");
        setNuevaEmpresa(new EmpresaDto());
        LOG.info("datos del formulario {}", nuevaEmpresa);
        MsgBeanUtil.ejecutaAccion("PF('dlgNuevaEmpresa').show()");
    }

    public List<EmpresaDto> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<EmpresaDto> empresas) {
        this.empresas = empresas;
    }

    public EmpresaDto getEmpresaSeleccionada() {
        return empresaSeleccionada;
    }

    public void setEmpresaSeleccionada(EmpresaDto empresaSeleccionada) {
        this.empresaSeleccionada = empresaSeleccionada;
    }

    public EmpresaDto getNuevaEmpresa() {
        return nuevaEmpresa;
    }

    public void setNuevaEmpresa(EmpresaDto nuevaEmpresa) {
        this.nuevaEmpresa = nuevaEmpresa;
    }
}
