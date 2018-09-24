package mx.com.sira.front.clientes.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.com.sira.front.dto.UsuarioDto;

@FeignClient(name="usuario",url = "http://localhost:8080")
public interface UsuarioService {

	 @RequestMapping(method = RequestMethod.GET, value = "/usuario/")
	    List<UsuarioDto> getUsuarios();
}
