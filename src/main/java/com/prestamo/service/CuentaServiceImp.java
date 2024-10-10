package com.prestamo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamo.entity.Cuenta;

import com.prestamo.repository.CuentaRepository;

@Service
public class CuentaServiceImp implements CuentaService{

	@Autowired
	private CuentaRepository repository;
	
	@Override
	public Cuenta insertaActualizaCuenta(Cuenta obj) {

		return  repository.save(obj);
	}

	@Override
	public List<Cuenta> listaCuenta() {
	
		return repository.findAll();
	}

	@Override
	public List<Cuenta> listaCuentaPorNumeroIgual(String descripcion) {
		
		return repository.listaCuentaPorNumeroIgual(descripcion);
	}

	@Override
	public List<Cuenta> listaCuentaPorNumeroLike(String numero) {
		// TODO Auto-generated method stub
		return repository.listaCuentaPorNumeroLike(numero);
	}

	@Override
	public void eliminaCuenta(int idCuenta) {
		repository.deleteById(idCuenta);
		
	}

	@Override
	public List<Cuenta> listaCuentaPorNumeroIgualActualiza(String numero, int idCuenta) {
		return repository.listaCuentaPorNumeroIgualActualiza(numero, idCuenta);
	}

	@Override
	public List<Cuenta> listaConsultaCompleja(String numero, int idEntidadFinanciera, int estado, int idTipoMoneda,int idTipoFinanciera) {
		// TODO Auto-generated method stub
		return repository.listaConsultaCompleja(numero, idEntidadFinanciera, estado,idTipoMoneda, idTipoFinanciera);
	}

	

}
