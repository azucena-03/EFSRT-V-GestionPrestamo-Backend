package com.prestamo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamo.entity.MontoPrestamo;
import com.prestamo.repository.MontoPrestamoRepository;



@Service
public class MontoPrestamoServiceImp implements MontoPrestamoService {

	@Autowired
	MontoPrestamoRepository repository;
	
	@Override
	public MontoPrestamo insertaActualizaMonto(MontoPrestamo obj) {
		return repository.save(obj);
	}
	
	@Override
	public List<MontoPrestamo> listaMontoPrestamo(){
		return repository.findAll();
	}
	
	@Override
	public void eliminaMontoPrestamo(int idMonto) {
		repository.deleteById(idMonto);
		
	}

	@Override
	public List<MontoPrestamo> obtenerMontoPrestamosPorPrimerDigitoCapital(String capitalDigits) {
		return repository.obtenerMontoPrestamosPorPrimerDigitoCapital(capitalDigits);
	}

	@Override
	public List<MontoPrestamo> listaconsultaComplejoMonto(int capital, int estado, BigDecimal monto, int idDias) {
		// TODO Auto-generated method stub
		return repository.listaconsultaComplejoMonto(capital, estado, monto, idDias);
	}
	
	
}
