package com.prestamo.service;

import java.util.List;

import com.prestamo.entity.DataCatalogo;



public interface DataCatalogoService {

	public abstract List<DataCatalogo> listaDataCatalogo(int idTipo);
	public abstract List<DataCatalogo> listaDataCatalogoPorDescripcionIgualActualiza(String descripcion, int idDataCatalogo);
	public abstract List<DataCatalogo> listaDataCatalogoPorDescripcionIgual(String descripcion);
	
	
	
	public abstract DataCatalogo insertaActualizaDataCatalogo(DataCatalogo obj);
	public abstract List<DataCatalogo> listaDataCatalogoPorDescripcionLike(String descripcion);
	public abstract void eliminaDataCatalogo(int idDataCatalogo);
	public abstract List<DataCatalogo> listaDataCatalogo();
	
	public abstract List<DataCatalogo> listaConsultaCompleja(String descripcion,int idCatalogo, int estado);
	

}
