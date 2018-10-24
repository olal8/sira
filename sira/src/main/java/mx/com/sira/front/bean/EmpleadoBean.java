package mx.com.sira.front.bean;

import mx.com.sira.front.clientes.feign.EmpleadoService;
import mx.com.sira.front.dto.EmpleadoDto;
import mx.com.sira.front.util.MessagesUtil;
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
    private EmpleadoDto empleadoEliminar;
    private EmpleadoDto empleadoModificado;
    @Resource
    private MessagesUtil messagesUtil;

    @PostConstruct
    public void init() {
        empleados = empleadoService.getEmpleados();
        setNuevoEmpleado(new EmpleadoDto());
        setEmpleadoModificado(new EmpleadoDto());
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

    public void cancelarModificacion() {
        LOG.info("Cancelando la modificacion del empleado");
        setEmpleadoModificado(new EmpleadoDto());
        MsgBeanUtil.ejecutaAccion("PF('dlgEmpleadoModificado').hide()");
    }

    public void initModificar() {
        LOG.info("Empleado seleccionado a modificar {}", empleadoSeleccionado);
        setEmpleadoModificado(empleadoSeleccionado);
        MsgBeanUtil.ejecutaAccion("PF('dlgEmpleadoModificado').show()");
    }

    public void modificar() {
        try {
            LOG.info("Empleado con nuevos datos {}", empleadoModificado);
            MsgBeanUtil.ejecutaAccion("PF('dlgEmpleadoModificado').hide()");
            empleadoService.actualizarEmpleado(getEmpleadoModificado().getIdEmpleado(),getEmpleadoModificado());
            MsgBeanUtil.info(messagesUtil.getMensaje("msg.empleado.modificado.exitoso"));
        } catch (Exception ex) {
            LOG.error("Error al modificar el empleado {}", ex);
        }
    }

    public void initEliminar() {
        LOG.info("Empleado seleccionado a eliminar {}", empleadoSeleccionado);
        setEmpleadoEliminar(empleadoSeleccionado);
        MsgBeanUtil.ejecutaAccion("PF('confirmEliminar').show()");
    }

    public void eliminar() {
        try {
            LOG.info("Empleado seleccionado a eliminar {}", getEmpleadoEliminar());
            empleadoService.eliminarEmpleado(getEmpleadoEliminar().getIdEmpleado(), getEmpleadoEliminar());
            setEmpleados(empleadoService.getEmpleados());
            MsgBeanUtil.ejecutaAccion("PF('confirmEliminar').hide()");
            MsgBeanUtil.info(messagesUtil.getMensaje("msg.empleado.eliminar.exitoso"));
        } catch (Exception ex) {
            MsgBeanUtil.ejecutaAccion("PF('confirmEliminar').hide()");
            LOG.error("Error al realizar la peticion para eliminar un empleado", ex.getCause());
            LOG.error("Error al realizar la peticion para eliminar un empleado", ex.getLocalizedMessage());
            MsgBeanUtil.fatal(ex.getMessage());

        }

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

    public EmpleadoDto getEmpleadoEliminar() {
        return empleadoEliminar;
    }

    public void setEmpleadoEliminar(EmpleadoDto empleadoEliminar) {
        this.empleadoEliminar = empleadoEliminar;
    }

    public EmpleadoDto getEmpleadoModificado() {
        return empleadoModificado;
    }

    public void setEmpleadoModificado(EmpleadoDto empleadoModificado) {
        this.empleadoModificado = empleadoModificado;
    }
}
