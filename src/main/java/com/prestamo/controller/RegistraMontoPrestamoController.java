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
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.MontoPrestamo;
import com.prestamo.service.MontoPrestamoService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/montoPrestamo")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class RegistraMontoPrestamoController {

	@Autowired
	private MontoPrestamoService prestamoService;
	
	@GetMapping
	public ResponseEntity<List<MontoPrestamo>> lista(){
		List<MontoPrestamo> lstSalida = prestamoService.listaMontoPrestamo();
		return ResponseEntity.ok(lstSalida);
	}
	
	@PostMapping
	public ResponseEntity<?> registra(@RequestBody MontoPrestamo objPrestamo){
		HashMap<String, Object> salida = new HashMap<>();
		objPrestamo.setFechaRegistro(new Date());
		objPrestamo.setFechaActualizacion(new Date());
		objPrestamo.setEstado(AppSettings.ACTIVO);
		
		MontoPrestamo objSalida = prestamoService.insertaActualizaMonto(objPrestamo);
		if (objSalida == null) {
			salida.put("mensaje", "Error en el registro");
		}else {
			salida.put("mensaje", "Registro de ejemplo con el ID >>> " + objPrestamo.getIdMontoPrestamo() + 
										" >>> DES >> "+ objPrestamo.getCapital());
		}
		return ResponseEntity.ok(salida);
	}
	
}