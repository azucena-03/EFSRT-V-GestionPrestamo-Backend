package com.prestamo.controller;

import java.math.BigDecimal;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.MontoPrestamo;
import com.prestamo.service.MontoPrestamoService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/consultaMontoPrestamo")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class ConsultaMontoPrestamoController {
	
	@Autowired
	private MontoPrestamoService montoService;
	
	@GetMapping("/consultaComplejoEjemplo")
	public List<MontoPrestamo> listaConsulta(
			@RequestParam int capital, 
			@RequestParam int estado, 
			@RequestParam BigDecimal monto, 
			@RequestParam int idDias){
		List<MontoPrestamo> lstSalida=montoService.listaMontoPrestamo();
		return lstSalida;
	}

}
