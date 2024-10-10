package com.prestamo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.Cuenta;
import com.prestamo.service.CuentaService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/consultaCuenta")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class CuentaConsulta {
	@Autowired
	private CuentaService cuentaService;
	
	@GetMapping("/consultaComplejoCuenta")
	public List<Cuenta> listaConsulta(
			@RequestParam String numero, 
			@RequestParam int idEntidadFinanciera, 
			@RequestParam int estado,
			@RequestParam int idTipoMoneda,
			@RequestParam int idTipoFinanciera){
		List<Cuenta> lstSalida  =cuentaService.listaConsultaCompleja(numero+"%", idEntidadFinanciera,estado ,idTipoMoneda, idTipoFinanciera );
		return lstSalida;
	}
}
