package mx.com.sira.backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.sira.backend.domain.Usuario;
import mx.com.sira.backend.service.UsuarioService;

@RestController
public class UsuarioController {
	private static final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/usuario/", method = RequestMethod.GET)
	public ResponseEntity<?> listaUsuarios() {
		LOG.info("imprimiendo bean servicio {}", usuarioService.hashCode());
		List<Usuario> usuarios = usuarioService.getUsuarios();
		if (usuarios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
}