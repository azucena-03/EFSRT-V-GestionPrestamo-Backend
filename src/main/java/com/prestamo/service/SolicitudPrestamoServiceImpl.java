package com.prestamo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamo.entity.SolicitudPrestamo;
import com.prestamo.repository.SolicitudPrestamoRepository;

@Service
public class SolicitudPrestamoServiceImpl implements SolicitudPrestamoService{
	
	@Autowired
	private SolicitudPrestamoRepository solicitudPrestamoRepository;

	@Override
	public List<SolicitudPrestamo> listaSolicitudPrestamo() {
		return solicitudPrestamoRepository.findAll();
	}

	@Override
	public SolicitudPrestamo insertaActualizaSolicitudPrestamo(SolicitudPrestamo obj) {
		return solicitudPrestamoRepository.save(obj);
	}

	@Override
	public void eliminaPrestamo(int idPrestamo) {
		solicitudPrestamoRepository.deleteById(idPrestamo);
		
	}

	@Override
	public List<SolicitudPrestamo> listaSolicitudPorFechas(Date fechaInicio, Date fechaFin) {
		return solicitudPrestamoRepository.listaSolicitudPorFechas(fechaInicio, fechaFin);
	}

}
