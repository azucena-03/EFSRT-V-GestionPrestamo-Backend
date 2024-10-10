package com.prestamo.service;

import java.math.BigDecimal;
import java.util.List;

import com.prestamo.entity.Coordenada;
import com.prestamo.entity.Usuario;

public interface CoordenadaService {

	public abstract List<Usuario> listaPrestamistariosTotales();

	public abstract List<Coordenada> listaPorPrestatarioIgual(Usuario idPrestatario);
	public abstract List<Coordenada> listaPorPrestatarioIgualActualiza(Usuario idPrestatario, int idCoordenada);
	
	public abstract Coordenada insertaActualizaCoordenada(Coordenada obj);
	public abstract List<Coordenada> listaCoordenada();
	public abstract List<Coordenada> listaPorPrestatarioLike(String nombreCompleto);
	public abstract void eliminaCoordenada(int idCoordenada);
	
	public abstract List<Coordenada> listaConsultaCoordenada(BigDecimal latitud, BigDecimal longitud, int estado);
}
