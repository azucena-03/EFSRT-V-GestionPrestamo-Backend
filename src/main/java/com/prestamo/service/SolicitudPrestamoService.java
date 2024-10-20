package com.prestamo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.prestamo.entity.SolicitudPrestamo;

public interface SolicitudPrestamoService {
	
	public abstract List<SolicitudPrestamo> listaSolicitudPrestamo();
	public abstract SolicitudPrestamo insertaActualizaSolicitudPrestamo(SolicitudPrestamo obj);
	public abstract void eliminaPrestamo(int idPrestamo);
	public abstract List<SolicitudPrestamo> listaSolicitudPorFechas(Date fechaInicio, Date fechaFin);
	Optional<SolicitudPrestamo> buscaPorId(int idSolicitud);
	public abstract List<SolicitudPrestamo> findPrestamosByPrestamista(int idPrestamista);

}
