package com.prestamo.service;

import java.util.List;

import com.prestamo.entity.EntidadFinanciera;

public interface EntidadFinancieraService {	
	 
	 public abstract List<EntidadFinanciera> listaEntidadFinancieraPorNombre(String nombre);
	 public abstract List<EntidadFinanciera> listaEntidadFinancieraPorNombreIgualActualiza(String nombre, int idEntidadFinanciera);
	
	 public abstract EntidadFinanciera inserteActualizaEntidadFinanciera(EntidadFinanciera obj);
	 public abstract List<EntidadFinanciera> listaEntidadFinancieraPorNombreLike(String nombre);
	 public abstract void eliminaEntidadFinanciera(int idEntidadFinanciera);
	 public abstract List<EntidadFinanciera>listaEntidadFinanciera();
	 
	 
	 public abstract List<EntidadFinanciera> listaConsultaComplejaEntidadFinanciera(String nombre, String gerente, int tipoEntidad, int estado);
	 
}
