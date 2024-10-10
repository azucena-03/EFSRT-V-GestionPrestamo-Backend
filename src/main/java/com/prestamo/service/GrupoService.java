package com.prestamo.service;

import java.util.List;


import com.prestamo.entity.Grupo;

public interface GrupoService {
	
	//Para Validaciones
	 public abstract List<Grupo> listaGrupoPorDescripcionIgual(String descripcion);
	 public abstract List<Grupo> listaGrupoPorDescripcionIgualActualiza(String descripcion, int idGrupo);  
	 
	//Para el crud
	 public abstract Grupo inserteActualizaGrupo(Grupo obj);
	 public abstract List<Grupo> listaGrupoPorDescripcionLike(String nombre);
	 public abstract void eliminaGrupo(int idGrupo);
	 public abstract List<Grupo>listaGrupo();
	 
	//Para la consulta
		public abstract List<Grupo> listaConsultaCompleja(String descripcion, int idUsuarioLider, int estado);

}

