package com.prestamo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.DataCatalogo;
import com.prestamo.service.DataCatalogoService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/consultaDataController")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class DataCatalogoConsultaController {
	
	@Autowired
	private DataCatalogoService dataCatalogoService;
	
	@GetMapping("/consultaComplejoDataCatalogo")
	public List<DataCatalogo> listaConsulta(
			@RequestParam String descripcion, 
			@RequestParam int idCatalogo, 
			@RequestParam int estado){
		List<DataCatalogo> lstSalida  =dataCatalogoService.listaConsultaCompleja("%"+descripcion+"%", idCatalogo, estado);
		return lstSalida;
	}
	
}
