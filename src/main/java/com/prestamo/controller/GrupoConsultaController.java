package com.prestamo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.Grupo;
import com.prestamo.service.GrupoService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/consultaGrupo")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class GrupoConsultaController {

	
	@Autowired
	private GrupoService grupoService;
	
	@GetMapping("/consultaComplejoGrupo")
	public List<Grupo> listaConsulta(
			@RequestParam String descripcion, 
			@RequestParam int idUsuarioLider, 
			@RequestParam int estado){
		List<Grupo> lstSalida  =grupoService.listaConsultaCompleja("%"+descripcion+"%", idUsuarioLider, estado);
		return lstSalida;
	}
}
