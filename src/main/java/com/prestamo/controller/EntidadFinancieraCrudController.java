package com.prestamo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.EntidadFinanciera;
import com.prestamo.service.EntidadFinancieraService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/crudFinaciera")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class EntidadFinancieraCrudController {

	@Autowired
	private EntidadFinancieraService entidadFinancieraService;
	
	
	@GetMapping("/listaEntidadFinancieraPorNombreLike/{var}")
	@ResponseBody
	public ResponseEntity<?> listaEntidadFinancieraPorNombreLike(@PathVariable("var") String nombre){
		List<EntidadFinanciera> lstSalida = null;
		if (nombre.equals("todos")) {
			lstSalida =entidadFinancieraService.listaEntidadFinanciera();
		}else {
			lstSalida =entidadFinancieraService.listaEntidadFinancieraPorNombreLike(nombre +  "%");
		}
		return ResponseEntity.ok(lstSalida);
	}
	
	@PostMapping("/registraEntidadFinanciera")
	@ResponseBody
	public ResponseEntity<?> insertaEntidadFinanciera(@RequestBody EntidadFinanciera obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setIdEntidadFinanciera(0);
			obj.setFechaActualizacion(new Date());
			obj.setFechaRegistro(new Date());
			obj.setEstado(AppSettings.ACTIVO);
			
			EntidadFinanciera objSalida = entidadFinancieraService.inserteActualizaEntidadFinanciera(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_REG_EXITOSO + " EntidadFinanciera de ID ==> " + obj.getIdEntidadFinanciera() + ".");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	@PutMapping("/actualizaEntidadFinanciera")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaEntidadFinanciera(@RequestBody EntidadFinanciera obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			
			obj.setFechaActualizacion(new Date());

			EntidadFinanciera objSalida = entidadFinancieraService.inserteActualizaEntidadFinanciera(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO + " Ejemplo de ID ==> " + obj.getIdEntidadFinanciera() + ".");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	
	@DeleteMapping("/eliminaEntidadFinanciera/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaEntidadFinanciera(@PathVariable("id") int idEntidadFinanciera) {
		Map<String, Object> salida = new HashMap<>();
		try {
			entidadFinancieraService.eliminaEntidadFinanciera(idEntidadFinanciera);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO + " Entidad de ID ==> " + idEntidadFinanciera + "." );
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/validaDescripcionActualiza")
	public String validaDescripcion(@RequestParam(name = "descripcion")String nombre,
									@RequestParam(name = "idEjemplo")int idEntidadFinanciera) {
		 List<EntidadFinanciera> lstSalida = entidadFinancieraService.listaEntidadFinancieraPorNombreIgualActualiza(nombre, idEntidadFinanciera);
		 if (lstSalida.isEmpty()) {
			 return "{\"valid\":true}";
		 }else {
			 return "{\"valid\":false}";
		 }
			
	}
}
