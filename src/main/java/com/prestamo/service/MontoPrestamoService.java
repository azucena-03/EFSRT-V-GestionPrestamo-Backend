package com.prestamo.service;

import java.math.BigDecimal;
import java.util.List;

import com.prestamo.entity.MontoPrestamo;



public interface MontoPrestamoService {

	public abstract MontoPrestamo insertaActualizaMonto(MontoPrestamo obj);
	public abstract List<MontoPrestamo> listaMontoPrestamo();
	public abstract void eliminaMontoPrestamo(int idMonto);
	public abstract List<MontoPrestamo> obtenerMontoPrestamosPorPrimerDigitoCapital(String capitalDigits);
	public abstract List<MontoPrestamo> listaconsultaComplejoMonto(int capital,  int estado, BigDecimal monto, int idDias);

}
