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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.MontoPrestamo;
import com.prestamo.service.MontoPrestamoService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/crudMontoPrestamo")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class MontoPrestamoCrudController {
	
	@Autowired
	private MontoPrestamoService prestamoService;
	
	@GetMapping("/listaMontoPrestamoPorCapital/{var}")
    @ResponseBody
    public ResponseEntity<?> listaMontoPrestamoPorCapital(@PathVariable("var") String capital) {
        List<MontoPrestamo> lstSalida = null;
        try {
            if (capital.equalsIgnoreCase("todos")) {
                lstSalida = prestamoService.listaMontoPrestamo();
            } else {
                lstSalida = prestamoService.obtenerMontoPrestamosPorPrimerDigitoCapital(capital);
            }
        } catch (NumberFormatException e) {
            /* en caso de que no se pueda convertir a entero :)*/
            lstSalida = null;
        }
        return ResponseEntity.ok(lstSalida);
    }
	
	 @PostMapping("/registraMontoPrestamo")
	 @ResponseBody
	 public ResponseEntity<?> insertaMontoPrestamo(@RequestBody MontoPrestamo obj) {
	        Map<String, Object> salida = new HashMap<>();
	        try {
	            obj.setIdMontoPrestamo(0);
	            obj.setFechaActualizacion(new Date());
	            obj.setFechaRegistro(new Date());
	            obj.setEstado(1); // Assuming 1 means active

	            MontoPrestamo objSalida = prestamoService.insertaActualizaMonto(obj);
	            if (objSalida == null) {
	                salida.put("mensaje", "Error al registrar  monto  préstamo");
	            } else {
	                salida.put("mensaje", "Registro exitoso  monto  préstamo con ID ==> " + objSalida.getIdMontoPrestamo() + ".");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            salida.put("mensaje", "Error al registrar  monto  préstamo");
	        }
	        return ResponseEntity.ok(salida);
	    }
	 
	   @PutMapping("/actualizaMontoPrestamo")
	   @ResponseBody
	   public ResponseEntity<Map<String, Object>> actualizaMontoPrestamo(@RequestBody MontoPrestamo obj) {
	        Map<String, Object> salida = new HashMap<>();
	        try {
	            obj.setFechaActualizacion(new Date());

	            MontoPrestamo objSalida = prestamoService.insertaActualizaMonto(obj);
	            if (objSalida == null) {
	                salida.put("mensaje", "Error al actualizar  monto  préstamo");
	            } else {
	                salida.put("mensaje", "Actualización exitosa  monto préstamo con ID ==> " + objSalida.getIdMontoPrestamo() + ".");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            salida.put("mensaje", "Error al actualizar  monto  préstamo");
	        }
	        return ResponseEntity.ok(salida);
	    }
	   
	   @DeleteMapping("/eliminaMontoPrestamo/{id}")
	   @ResponseBody
	    public ResponseEntity<Map<String, Object>> eliminaMontoPrestamo(@PathVariable("id") int idMontoPrestamo) {
	        Map<String, Object> salida = new HashMap<>();
	        try {
	        	prestamoService.eliminaMontoPrestamo(idMontoPrestamo);
	            salida.put("mensaje", "Eliminación exitosa  monto  préstamo con ID ==> " + idMontoPrestamo + ".");
	        } catch (Exception e) {
	            e.printStackTrace();
	            salida.put("mensaje", "Error al eliminar  monto  préstamo");
	        }
	        return ResponseEntity.ok(salida);
	    }
	 
}
