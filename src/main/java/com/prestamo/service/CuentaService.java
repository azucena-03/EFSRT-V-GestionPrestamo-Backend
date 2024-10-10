package com.prestamo.service;

import java.util.List;

import com.prestamo.entity.Cuenta;

public interface CuentaService {
	
	
	public abstract List<Cuenta> listaCuentaPorNumeroIgual(String descripcion);
	public abstract List<Cuenta> listaCuentaPorNumeroIgualActualiza(String numero, int idCuenta);
	
	public abstract Cuenta insertaActualizaCuenta(Cuenta obj);
	public abstract List<Cuenta> listaCuentaPorNumeroLike(String numero);
	public abstract void eliminaCuenta(int idCuenta);
	public abstract List<Cuenta> listaCuenta();
	
	public abstract List<Cuenta> listaConsultaCompleja(String numero, int idEntidadFinanciera,int estado,int idTipoMoneda,int idTipoFinanciera);
	
}
