package com.prestamo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.SolicitudPrestamo;
import com.prestamo.service.SolicitudPrestamoService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/crudPrestamo")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class SolicitudPrestamoCrudController {
	
	@Autowired
	private SolicitudPrestamoService prestamoService;
	
	@GetMapping
	public ResponseEntity<List<SolicitudPrestamo>> Lista(){
		List<SolicitudPrestamo> lstCuenta = prestamoService.listaSolicitudPrestamo();
		return ResponseEntity.ok(lstCuenta);
	}
	
	@GetMapping("/listaSolicitudPorFechas")
	@ResponseBody
	public ResponseEntity<?> listaSolicitudPorFechas(
			@RequestParam(name = "fechaInicio" , required = true , defaultValue = "")@DateTimeFormat(pattern = "yyyy-MM-dd")Date fechaInicio, 
			@RequestParam(name = "fechaFin" , required = true , defaultValue = "")@DateTimeFormat(pattern = "yyyy-MM-dd")Date fechaFin ){
		List<SolicitudPrestamo> lstSalida = prestamoService.listaSolicitudPorFechas(fechaInicio, fechaFin);
		return ResponseEntity.ok(lstSalida);
	}
	
	@DeleteMapping("/eliminaPrestamo/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaPrestamo(@PathVariable("id") int idPrestamo) {
		Map<String, Object> salida = new HashMap<>();
		try {
			prestamoService.eliminaPrestamo(idPrestamo);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/actualizaPrestamo")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaPrestamo(@RequestBody SolicitudPrestamo obj) {
	    Map<String, Object> salida = new HashMap<>();
	    try {		
	        Optional<SolicitudPrestamo> solicitudExistente = prestamoService.buscaPorId(obj.getIdSolicitud());

	        if (solicitudExistente.isPresent()) {
	            SolicitudPrestamo solicitudOriginal = solicitudExistente.get();
	            
	            solicitudOriginal.setEstadoSolicitud(obj.getEstadoSolicitud());
	            solicitudOriginal.setFechaActualizacion(new Date());
	            solicitudOriginal.setUsuarioActualiza(obj.getUsuarioActualiza());
	            
	            SolicitudPrestamo objSalida = prestamoService.insertaActualizaSolicitudPrestamo(solicitudOriginal);
	            if (objSalida == null) {
	                salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
	            } else {
	                salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO);
	            }
	        } else {
	            salida.put("mensaje", "Solicitud no encontrada");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
	    }
	    return ResponseEntity.ok(salida);
	}

}
