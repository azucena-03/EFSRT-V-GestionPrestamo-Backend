package com.prestamo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.SolicitudPrestamo;
import com.prestamo.service.SolicitudPrestamoService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/solicitudPrestamo")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class SolicitudPrestamoController {
	
	@Autowired SolicitudPrestamoService service;
	
	
	@GetMapping
	public ResponseEntity<List<SolicitudPrestamo>> Lista(){
		List<SolicitudPrestamo> lstCuenta = service.listaSolicitudPrestamo();
		return ResponseEntity.ok(lstCuenta);
	}
	
	
	@PostMapping
	public ResponseEntity<?> registra(@RequestBody SolicitudPrestamo objSolicitud){
		HashMap<String, Object> salida = new HashMap<>();
		objSolicitud.setFechaRegistro(new Date());
		objSolicitud.setFechaActualizacion(new Date());
		objSolicitud.setEstado(AppSettings.ACTIVO);
		
		SolicitudPrestamo objSalida = service.insertaActualizaSolicitudPrestamo(objSolicitud);
		if(objSalida==null) {
			salida.put("mensaje", "Error en el registro");
		
		}else {
			salida.put("mensaje", "Registro de cuenta con el ID>>>"
		+ objSolicitud.getIdSolicitud());
		
		}
		return ResponseEntity.ok(salida);
	}
	
	 @GetMapping("/prestamosPorPrestamista/{idPrestamista}")
	    public ResponseEntity<List<SolicitudPrestamo>> obtenerPrestamosPorPrestamista(@PathVariable int idPrestamista) {
	        List<SolicitudPrestamo> prestamos = service.findPrestamosByPrestamista(idPrestamista);
	        if (prestamos.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna 204 si no hay préstamos
	        }
	        return new ResponseEntity<>(prestamos, HttpStatus.OK); // Retorna 200 con la lista de préstamos
	    }
	
}
