package com.prestamo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.EntidadFinanciera;

import com.prestamo.service.CuentaFinancieraService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/cuentaFinanciera")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class CuentaFinancieraController {
	
	@Autowired
	private CuentaFinancieraService entidadService;
	
	@GetMapping("/listaFinanciera")
	@ResponseBody
	public List<EntidadFinanciera> lista() {
		return entidadService.ListaEntidadFinanciera();
	}

}
