package com.prestamo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamo.entity.Coordenada;
import com.prestamo.entity.Usuario;
import com.prestamo.repository.CoordenadaRepository;

@Service
public class CoordenadaServiceImp implements CoordenadaService {

	@Autowired
	private CoordenadaRepository repository;
	
	@Override
	public List<Usuario> listaPrestamistariosTotales() {
		return repository.listaPrestamistariosTotales();
	}
	
	@Override
    public List<Coordenada> listaPorPrestatarioIgual(Usuario idPrestatario) {
        return repository.listaPorPrestatarioIgual(idPrestatario);
    }
	@Override
	public List<Coordenada> listaPorPrestatarioIgualActualiza(Usuario idPrestatario, int idCoordenada) {
		return repository.listaPorPrestatarioIgualActualiza(idPrestatario, idCoordenada);
	}

	@Override
	public Coordenada insertaActualizaCoordenada(Coordenada obj) {
		return repository.save(obj);
	}
	@Override
	public List<Coordenada> listaCoordenada() {
		return repository.findAll();
	}
	@Override
	public List<Coordenada> listaPorPrestatarioLike(String nombreCompleto) {
		return repository.listaPorPrestatarioLike(nombreCompleto);
	}
	@Override
	public void eliminaCoordenada(int idCoordenada) {
		repository.deleteById(idCoordenada);
	}

	@Override
	public List<Coordenada> listaConsultaCoordenada(BigDecimal latitud, BigDecimal longitud, int estado) {
		return repository.listaConsultaCoordenada(latitud, longitud, estado);
	}
}
