package mx.com.sira.front.bean;

import mx.com.sira.front.clientes.feign.EmpleadoService;
import mx.com.sira.front.dto.EmpleadoDto;
import mx.com.sira.front.util.MsgBeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

/**
 * Created by gerry on 06/10/18.
 */
@Named
@ViewScoped
public class EmpleadoBean {
    private static final Logger LOG = LoggerFactory.getLogger(EmpleadoBean.class);
    @Resource
    private EmpleadoService empleadoService;
    private List<EmpleadoDto> empleados;
    private EmpleadoDto empleadoSeleccionado;
    private EmpleadoDto nuevoEmpleado;

    @PostConstruct
    public void init() {
        empleados = empleadoService.getEmpleados();
        setNuevoEmpleado(new EmpleadoDto());
    }

    public void guardar() {
        LOG.info("Guardando los datos del empleado {}", nuevoEmpleado);
        empleados = empleadoService.guardar(nuevoEmpleado);
        LOG.info("lista de empleados recuperados {}", empleados);
        MsgBeanUtil.ejecutaAccion("PF('dlgNuevoEmpleado').hide()");
    }

    public void initGuardar() {
        LOG.info("mostrando formulario para el guardado de empleados");
        setNuevoEmpleado(new EmpleadoDto());
        LOG.info("datos del formulario {}", nuevoEmpleado);
        MsgBeanUtil.ejecutaAccion("PF('dlgNuevoEmpleado').show()");
    }

    public void cancelar() {
        LOG.info("cancelando guardado de empleados");
        setNuevoEmpleado(new EmpleadoDto());
        LOG.info("datos del formulario {}", nuevoEmpleado);
        MsgBeanUtil.ejecutaAccion("PF('dlgNuevoEmpleado').hide()");
    }

    public List<EmpleadoDto> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<EmpleadoDto> empleados) {
        this.empleados = empleados;
    }

    public EmpleadoDto getEmpleadoSeleccionado() {
        return empleadoSeleccionado;
    }

    public void setEmpleadoSeleccionado(EmpleadoDto empleadoSeleccionado) {
        this.empleadoSeleccionado = empleadoSeleccionado;
    }

    public EmpleadoDto getNuevoEmpleado() {
        return nuevoEmpleado;
    }

    public void setNuevoEmpleado(EmpleadoDto nuevoEmpleado) {
        this.nuevoEmpleado = nuevoEmpleado;
    }
}
