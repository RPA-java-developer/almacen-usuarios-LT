package com.registro.usuarios.controlador;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.registro.usuarios.servicio.UsuarioServicio;

@Controller
public class RegistroControlador {

	@Autowired
	private UsuarioServicio servicio;
	
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}
	
	@GetMapping("/")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("usuarios", servicio.listarUsuarios());
		return "index";
	}	
	
	@GetMapping("/otrolugar")
	public String irOtroLugar() {
		System.out.println("vamos a otro lugar");
		return "login";
	}	
	
	
	@GetMapping("/redirect")
	public void method(HttpServletResponse httpServletResponse) {
	    httpServletResponse.setHeader("Location", "http://localhost:3000/");
	    httpServletResponse.setStatus(302);
	}	
	
	
	
	
	
	
}
