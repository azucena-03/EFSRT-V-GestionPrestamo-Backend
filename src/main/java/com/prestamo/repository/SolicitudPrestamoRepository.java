package com.prestamo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prestamo.entity.SolicitudPrestamo;

public interface SolicitudPrestamoRepository extends JpaRepository<SolicitudPrestamo, Integer>{
	
	@Query("select s from SolicitudPrestamo s")
	public abstract List<SolicitudPrestamo> listaSolicitudPrestamo();
	
	@Query("select s from SolicitudPrestamo s where s.fechaInicioPrestamo >= ?1 and s.fechaInicioPrestamo <= ?2")
	public abstract List<SolicitudPrestamo> listaSolicitudPorFechas(Date fechaInicio, Date fechaFin);
	
	@Query("SELECT sp FROM SolicitudPrestamo sp WHERE sp.usuarioActualiza.idUsuario = ?1")
	public abstract List<SolicitudPrestamo> findPrestamosByPrestamista(int idPrestamista);

	
}
