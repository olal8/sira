package mx.com.sira.front.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import mx.com.sira.front.clientes.feign.UsuarioService;
import mx.com.sira.front.dto.UsuarioDto;

@Named
@ViewScoped
public class HelloWorld {
	private String firstName = "John";
	private String lastName = "Doe";
	@Resource
	private UsuarioService usuarioService;

	@PostConstruct
	public void init() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String showGreeting() {
		String nombre = "";
		List<UsuarioDto> usuarios = usuarioService.getUsuarios();
		nombre = usuarios.get(0).getNombre();
		return nombre;
	}
}
