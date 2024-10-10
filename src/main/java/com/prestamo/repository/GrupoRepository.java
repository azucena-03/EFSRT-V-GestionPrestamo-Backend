package com.prestamo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.prestamo.entity.Grupo;


  public interface GrupoRepository extends JpaRepository<Grupo, Integer> {
		
	    @Query("select e from Grupo e where e.descripcion = ?1")
	    public abstract List<Grupo> listaGrupoPorDescripcion(String descripcion);

		@Query("select e from Grupo e where e.descripcion like ?1")
		public abstract List<Grupo> listaGrupoPorDescripcionLike(String descripcion);
		
		@Query("select e from Grupo e where e.descripcion = ?1 and e.idGrupo != ?2 ")
		public abstract List<Grupo> listaGrupoPorDescripcionIgualActualiza(String descripcion, int idEjemplo);
		
		
		@Query("select g from Grupo g where "
		            + " g.descripcion like ?1 and "
		            + " (?2 = -1 or g.usuarioLider.idUsuario = ?2) and"
		            + " g.estado = ?3")
		public abstract List<Grupo> listaConsultaCompleja(String descripcion, int idUsuarioLider, int estado);	

		
}
