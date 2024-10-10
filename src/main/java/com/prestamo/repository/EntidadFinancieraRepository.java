package com.prestamo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prestamo.entity.EntidadFinanciera;

public interface EntidadFinancieraRepository extends JpaRepository<EntidadFinanciera, Integer>{
	
	@Query("select e from EntidadFinanciera e where e.nombre = ?1")
	  public abstract List<EntidadFinanciera> listaEntidadFinancieraPorNombre(String nombre);
	
	@Query("select e from EntidadFinanciera e where e.nombre like ?1")
	public abstract List<EntidadFinanciera> listaEntidadFinancieraPorDescripcionLike(String nombre);
	
	@Query("select e from EntidadFinanciera e where e.nombre = ?1 and e.idEntidadFinanciera != ?2 ")
	public abstract List<EntidadFinanciera> listaEntidadFinancieraPorNombreIgualActualiza(String nombre, int idEntidadFinanciera);
	
	@Query("select e from EntidadFinanciera e where "
			+ " e.nombre like ?1  and "
			+ " e.gerente like ?2 and"
			+ " (?3 = -1 or e.tipoEntidad.idDataCatalogo = ?3) and"
			+ " e.estado = ?4")
    public abstract List<EntidadFinanciera> listaConsultaComplejaEntidadFinanciera(String nombre, String gerente, int tipoEntidad, int estado);
}
