package com.prestamo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamo.entity.EntidadFinanciera;
import com.prestamo.repository.CuentaFinancieraRepository;

@Service
public class CuentaFinancieraImp implements CuentaFinancieraService {
	
	@Autowired
	private CuentaFinancieraRepository repository;
		
		
	@Override
	public List<EntidadFinanciera> ListaEntidadFinanciera() {
		return repository.findAll();
	}
	

}
