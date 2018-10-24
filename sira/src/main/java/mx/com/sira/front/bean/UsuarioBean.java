package mx.com.sira.front.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mx.com.sira.front.util.MsgBeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.sira.front.clientes.feign.UsuarioService;
import mx.com.sira.front.dto.UsuarioDto;

@Named
@ViewScoped
public class UsuarioBean {
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioBean.class);
    @Resource
    private UsuarioService usuarioService;
    private List<UsuarioDto> usuarios;
    private UsuarioDto usuarioSeleccionado;
    private UsuarioDto nuevoUsuario;

    @PostConstruct
    public void init() {
        usuarios = usuarioService.getUsuarios();
    }

    public void initGuardar() {
        LOG.info("mostrando formulario para el guardado de empleados");
        setNuevoUsuario(new UsuarioDto());
        LOG.info("datos del formulario {}", nuevoUsuario);
        MsgBeanUtil.ejecutaAccion("PF('dlgUsuario').show()");
    }

    public void initModificar() {
        LOG.info("El usuario a modificar es {}", usuarioSeleccionado);
    }

    public List<UsuarioDto> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioDto> usuarios) {
        this.usuarios = usuarios;
    }

    public UsuarioDto getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(UsuarioDto usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public UsuarioDto getNuevoUsuario() {
        return nuevoUsuario;
    }

    public void setNuevoUsuario(UsuarioDto nuevoUsuario) {
        this.nuevoUsuario = nuevoUsuario;
    }
}
