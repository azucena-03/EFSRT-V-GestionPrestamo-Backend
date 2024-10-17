package com.prestamo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.Usuario;
import com.prestamo.service.UsuarioService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/usuario")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	
	@GetMapping
	public List<Usuario> listaUsuario(){
		List<Usuario> lstSalida = usuarioService.listaJefePrestamistaTotales();
		return lstSalida;
	}
	
	

}
