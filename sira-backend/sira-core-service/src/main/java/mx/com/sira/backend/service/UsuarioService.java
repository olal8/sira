package mx.com.sira.backend.service;


import java.util.List;

import mx.com.sira.backend.domain.Usuario;

public interface UsuarioService {
	List<Usuario> getUsuarios();

	Usuario getUsuario();
}
