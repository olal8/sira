package mx.com.sira.backend.service.impl;

import mx.com.sira.backend.domain.Giro;
import mx.com.sira.backend.persistence.GiroRepository;
import mx.com.sira.backend.service.GiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gerry on 11/21/18.
 */
@Service
@Scope("prototype")
public class GiroServiceImpl implements GiroService {
    @Autowired
    private GiroRepository giroRepository;

    @Override
    public List<Giro> listadoGiros() {
        return giroRepository.findAll();
    }
}
