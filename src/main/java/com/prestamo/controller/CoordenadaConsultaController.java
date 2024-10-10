package com.prestamo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.Coordenada;
import com.prestamo.service.CoordenadaService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/consultaCoordenada")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class CoordenadaConsultaController {

	@Autowired
	private CoordenadaService coordenadaService;
	
	@GetMapping("/consultaCoordenada")
	public List<Coordenada> listaConsultaCoordenada(
			@RequestParam BigDecimal latitud,
			@RequestParam BigDecimal longitud,
			@RequestParam int estado) {
		List<Coordenada> lstSalida = coordenadaService.listaConsultaCoordenada(latitud, longitud, estado);
		return lstSalida;
	}
 }
