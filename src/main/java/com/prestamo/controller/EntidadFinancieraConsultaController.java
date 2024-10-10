package com.prestamo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.EntidadFinanciera;
import com.prestamo.service.EntidadFinancieraService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/consultaFinanciera")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class EntidadFinancieraConsultaController {

	@Autowired
	private EntidadFinancieraService entidadfinancieraservice;
	
	@GetMapping("/listaConsultaComplejaEntidadFinanciera")
	public List<EntidadFinanciera> listaConsulta(
			@RequestParam String nombre, 
			@RequestParam String gerente, 
			@RequestParam int tipoEntidad, 
			@RequestParam int estado){
		List<EntidadFinanciera> lstSalida  = entidadfinancieraservice.listaConsultaComplejaEntidadFinanciera("%"+nombre+"%", "%"+gerente+"%", tipoEntidad, estado);
		return lstSalida;
	}
}	

