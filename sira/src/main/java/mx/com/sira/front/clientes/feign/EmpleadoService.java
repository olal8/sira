package mx.com.sira.front.clientes.feign;

import mx.com.sira.front.dto.EmpleadoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by gerry on 06/10/18.
 */
@FeignClient(name = "usuario", url = "${cliente.feign.url}")
public interface EmpleadoService {
    @RequestMapping(method = RequestMethod.GET, value = "/empleado/")
    List<EmpleadoDto> getEmpleados();

    @RequestMapping(method = RequestMethod.POST, value = "/empleado/")
    List<EmpleadoDto> guardar(@RequestBody EmpleadoDto empleado);

    @RequestMapping(method = RequestMethod.PUT, value = "/empleado/{id}")
    List<EmpleadoDto> actualizarEmpleado(@RequestBody EmpleadoDto empleadoDto);

    @RequestMapping(method = RequestMethod.PUT, value = "/empleado/delete/{id}")
    List<EmpleadoDto> eliminarEmpleado(@PathVariable("id")long id,@RequestBody EmpleadoDto empleadoDto);

}
