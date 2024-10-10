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

import com.prestamo.entity.Catalogo;
import com.prestamo.entity.DataCatalogo;
import com.prestamo.service.CatalogoService;
import com.prestamo.service.DataCatalogoService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/dataCatalogo")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class DataCatalogoController {
	@Autowired
	private DataCatalogoService catalogoService;
	
	@Autowired
	private CatalogoService catalogoService2;
	
	
	@GetMapping("/listaCatalogo")
	public List<Catalogo>listarCatalogo(){
		return catalogoService2.listaTodos();
	}
	
	@GetMapping
	public ResponseEntity<List<DataCatalogo>> lista(){
		List<DataCatalogo> listaCtg = catalogoService.listaDataCatalogo(0);
		return ResponseEntity.ok(listaCtg);
	}
	
	
	@PostMapping
	public ResponseEntity<?> registra(@RequestBody DataCatalogo objDataCata){
		HashMap<String, Object> salida = new HashMap<>();
		objDataCata.setFechaRegistro(new Date());
		objDataCata.setFechaActualizacion(new Date());
		
		DataCatalogo objSalida = catalogoService.insertaActualizaDataCatalogo(objDataCata);
		if(objSalida == null) {
			salida.put("mensaje", "Error al registrar");
			
		}else {
			salida.put("mensaje","Registro de data catalogo con id>>>" + objDataCata.getIdDataCatalogo() + ">>>DES>>>" + objDataCata.getDescripcion());
			
		}
		return ResponseEntity.ok(salida);
	
	}
	
	@GetMapping("/validaDescripcionRegistrada")
	public String validaDescripcion(@RequestParam(name = "descripcion")String descripcion) {
		 List<DataCatalogo> lstSalida =catalogoService.listaDataCatalogoPorDescripcionLike(descripcion);
		 if (lstSalida.isEmpty()) {
			 return "{\"valid\":true}";
		 }else {
			 return "{\"valid\":false}";
		 }
			
	} 
	
	

}
