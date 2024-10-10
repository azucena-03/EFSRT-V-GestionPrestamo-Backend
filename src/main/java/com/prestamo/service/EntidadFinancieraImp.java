package com.prestamo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamo.entity.EntidadFinanciera;
import com.prestamo.repository.EntidadFinancieraRepository;


@Service
public class EntidadFinancieraImp implements EntidadFinancieraService {

	@Autowired 
	private EntidadFinancieraRepository repository;
	
	@Override
	public EntidadFinanciera inserteActualizaEntidadFinanciera(EntidadFinanciera obj) {
		return repository.save(obj);
	
	}

	@Override
	public List<EntidadFinanciera> listaEntidadFinanciera() {
		return repository.findAll();
	}

	@Override
	public List<EntidadFinanciera> listaEntidadFinancieraPorNombre(String nombre) {
		return repository.listaEntidadFinancieraPorNombre(nombre);
	}

	@Override
	public List<EntidadFinanciera> listaEntidadFinancieraPorNombreIgualActualiza(String nombre,
			int idEntidadFinanciera) {
		// TODO Auto-generated method stub
		return repository.listaEntidadFinancieraPorNombreIgualActualiza(nombre, idEntidadFinanciera);
	}

	@Override
	public List<EntidadFinanciera> listaEntidadFinancieraPorNombreLike(String nombre) {
		// TODO Auto-generated method stub
		return repository.listaEntidadFinancieraPorDescripcionLike(nombre);
	}

	@Override
	public void eliminaEntidadFinanciera(int idEntidadFinanciera) {
		// TODO Auto-generated method stub
		repository.deleteById(idEntidadFinanciera);
		
	}

	@Override
	public List<EntidadFinanciera> listaConsultaComplejaEntidadFinanciera(String nombre, String gerente, int tipoEntidad,
			int estado) {
		// TODO Auto-generated method stub
		return repository.listaConsultaComplejaEntidadFinanciera(nombre, gerente, tipoEntidad, estado);
	}
	
}
