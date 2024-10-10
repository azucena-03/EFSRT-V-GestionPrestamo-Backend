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

import com.prestamo.entity.Coordenada;
import com.prestamo.entity.Usuario;
import com.prestamo.service.CoordenadaService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/coordenada")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class CoordenadaRegistraController {

	@Autowired
	private CoordenadaService coordenadaService;
	
	@GetMapping
	public ResponseEntity<List<Coordenada>> lista() {
		List<Coordenada> lstSalida = coordenadaService.listaCoordenada();
		return ResponseEntity.ok(lstSalida);
	}
	
	@PostMapping
	public ResponseEntity<?> registra(@RequestBody Coordenada objCoordenada) {
		HashMap<String, Object> salida = new HashMap<>();
		objCoordenada.setFechaRegistro(new Date());
		objCoordenada.setFechaActualizacion(new Date());
		objCoordenada.setEstado(AppSettings.ACTIVO);
		
		Coordenada objSalida = coordenadaService.insertaActualizaCoordenada(objCoordenada);
		if (objSalida == null) {
			salida.put("mensaje", "Error en el registro");
		} else {
			salida.put("mensaje", "Registro de coordenada con el ID >>> " + objCoordenada.getIdCoordenada());
		}
		
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/validaPrestatarioRegistra")
    public String validaPrestatario(@RequestParam(name = "idPrestatario") Usuario idPrestatario) {
        List<Coordenada> lstSalida = coordenadaService.listaPorPrestatarioIgual(idPrestatario);
        if (lstSalida.isEmpty()) {
            return "{\"valid\":true}";
        } else {
            return "{\"valid\":false}";
        }
    }
	
	
}
