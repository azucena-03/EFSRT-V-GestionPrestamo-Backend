package com.prestamo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamo.entity.Grupo;
import com.prestamo.repository.GrupoRepository;

@Service
public class GrupoServiceImpl implements GrupoService {

	@Autowired 
	private GrupoRepository repository;
	
	@Override
	public Grupo inserteActualizaGrupo(Grupo obj) {
		return repository.save(obj);
	}

	@Override
	public List<Grupo> listaGrupo() {
    	return repository.findAll();
	}

	@Override
	public List<Grupo> listaGrupoPorDescripcionIgual(String descripcion) {
		return repository.listaGrupoPorDescripcion(descripcion);
	}

	@Override
	public List<Grupo> listaGrupoPorDescripcionIgualActualiza(String descripcion, int idGrupo) {
		return repository.listaGrupoPorDescripcionIgualActualiza(descripcion, idGrupo);
	}

	@Override
	public List<Grupo> listaGrupoPorDescripcionLike(String nombre) {
		return repository.listaGrupoPorDescripcionLike(nombre);
	}

	@Override
	public void eliminaGrupo(int idGrupo) {
		repository.deleteById(idGrupo);
		
	}
	
	//-----------------
		@Override
		public List<Grupo> listaConsultaCompleja(String descripcion, int idUsuarioLider, int estado) {
	       return repository.listaConsultaCompleja(descripcion, idUsuarioLider, estado);
		}


}
