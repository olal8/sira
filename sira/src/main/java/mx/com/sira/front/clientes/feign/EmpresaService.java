package mx.com.sira.front.clientes.feign;

import mx.com.sira.front.dto.EmpresaDto;
import mx.com.sira.front.util.FeignApiServiceConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by gerry on 10/30/18.
 */
@FeignClient(name = "empresa", url = "${cliente.feign.url}", configuration = FeignApiServiceConfig.class)
public interface EmpresaService {
    @RequestMapping(method = RequestMethod.GET, value = "/empresa/")
    List<EmpresaDto> getEmpresas();
}
