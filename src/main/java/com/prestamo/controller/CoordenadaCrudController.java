package com.prestamo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.Coordenada;
import com.prestamo.entity.Usuario;
import com.prestamo.service.CoordenadaService;
import com.prestamo.util.AppSettings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/url/crudCoordenada")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class CoordenadaCrudController {

	@Autowired
	private CoordenadaService coordenadaService;
	
	@GetMapping("listaPorPrestatarioLike/{var}")
	public ResponseEntity<?> listaPorPrestatarioLike(@PathVariable("var") String nombreCompleto) {
		List<Coordenada> lstSalida = null;
		if (nombreCompleto.equals("todos")) {
			lstSalida = coordenadaService.listaCoordenada();
		} else {
			lstSalida = coordenadaService.listaPorPrestatarioLike("%" + nombreCompleto + "%");
		}
		return ResponseEntity.ok(lstSalida);
	}
	
	@PostMapping("/registraCoordenada")
	@ResponseBody
	public ResponseEntity<?> registraCoordenada(@RequestBody Coordenada obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setIdCoordenada(0);
			obj.setFechaActualizacion(new Date());
			obj.setFechaRegistro(new Date());
			obj.setEstado(AppSettings.ACTIVO);
			
			Coordenada objSalida = coordenadaService.insertaActualizaCoordenada(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_REG_EXITOSO + " Ejemplo de ID ==> " + obj.getIdCoordenada() + ".");
			}
		} catch(Exception e) {
			e.printStackTrace();
			salida.put("menaje", AppSettings.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/actualizaCoordenada")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaCoordenada(@RequestBody Coordenada obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setFechaActualizacion(new Date());

			Coordenada objSalida = coordenadaService.insertaActualizaCoordenada(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO + " Ejemplo de ID ==> " + obj.getIdCoordenada() + ".");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/eliminaCoordenada/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaCoordenada(@PathVariable("id") int idCoordenada) {
		Map<String, Object> salida = new HashMap<>();
		try {
			coordenadaService.eliminaCoordenada(idCoordenada);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO + " Ejemplo de ID ==> " + idCoordenada + "." );
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/validaPrestatarioActualiza")
	public String validaPrestatario(@RequestParam(name = "idPrestatario") Usuario idPrestatario,
									@RequestParam(name = "idCoordenada") int idCoordenada) {
        List<Coordenada> lstSalida = coordenadaService.listaPorPrestatarioIgualActualiza(idPrestatario, idCoordenada);
        if (lstSalida.isEmpty()) {
            return "{\"valid\":true}";
        } else {
            return "{\"valid\":false}";
        }
    }
	
}
