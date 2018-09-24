package mx.com.sira.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.sira.backend.domain.Usuario;
import mx.com.sira.backend.persistence.UsuarioRepository;
import mx.com.sira.backend.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario getUsuario() {
		Usuario usu = new Usuario();
		usu.setId(1);
		usu.setNombre("prueba");
		return usu;
	}

	@Override
	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios=new ArrayList<>();
	try {
		usuarios=usuarioRepository.findAll();
	}catch (Exception e) {
		// TODO: handle exception
	}
		return usuarios;
	}

}
