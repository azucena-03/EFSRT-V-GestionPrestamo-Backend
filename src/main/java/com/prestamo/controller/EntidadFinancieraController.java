package com.prestamo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.EntidadFinanciera;
import com.prestamo.service.EntidadFinancieraService;
import com.prestamo.util.AppSettings;


@RestController
@RequestMapping("/url/entidadFinanciera")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class EntidadFinancieraController {

	@Autowired
	private EntidadFinancieraService entidadfinancieraservice;
	
	@GetMapping
	public ResponseEntity<List<EntidadFinanciera>> lista(){
		List<EntidadFinanciera> lstSalida = entidadfinancieraservice.listaEntidadFinanciera();
		return ResponseEntity.ok(lstSalida);
	}
	
	@PostMapping
	public ResponseEntity<?> registra(@RequestBody EntidadFinanciera objEntidadFinanciera){
		HashMap<String, Object> salida = new HashMap<>();
		objEntidadFinanciera.setFechaRegistro(new Date());
		objEntidadFinanciera.setFechaActualizacion(new Date());
		objEntidadFinanciera.setEstado(AppSettings.ACTIVO);
		
		EntidadFinanciera objSalida = entidadfinancieraservice.inserteActualizaEntidadFinanciera(objEntidadFinanciera);
		if (objSalida == null) {
			salida.put("mensaje", "Error en el registro");
		}else {
			salida.put("mensaje", "Registro de ejemplo con el ID >>> " + objEntidadFinanciera.getIdEntidadFinanciera() + 
										" >>> DES >> "+ objEntidadFinanciera.getNombre());
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/validaDescripcionRegistra")
	public String validaDescripcion(@RequestParam(name = "nombre")String nombre) {
		 List<EntidadFinanciera> lstSalida =entidadfinancieraservice.listaEntidadFinancieraPorNombre(nombre);
		 if (lstSalida.isEmpty()) {
			 return "{\"valid\":true}";
		 }else {
			 return "{\"valid\":false}";
		 }
	}
}
