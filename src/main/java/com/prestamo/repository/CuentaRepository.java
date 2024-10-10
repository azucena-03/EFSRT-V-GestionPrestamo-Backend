package com.prestamo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prestamo.entity.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

	@Query("Select c from Cuenta c where c.numero =  ?1 ")
	public abstract List<Cuenta> listaCuentaPorNumeroIgual(String numero);
	@Query("Select c from Cuenta c where c.numero like ?1 ")
	public abstract List<Cuenta> listaCuentaPorNumeroLike(String numero);
	@Query("Select c from Cuenta c where c.numero = ?1 and c.idCuenta !=  ?2 ")
	public abstract List<Cuenta> listaCuentaPorNumeroIgualActualiza(String numero, int idEjemplo);
	
	@Query("select c from Cuenta c where "
			+ " c.numero like ?1 and "
			+ " (?2 = -1 or c.entidadFinanciera.idEntidadFinanciera = ?2) and"
			+ " c.estado = ?3 and "
			+ " (?4 = -1 or c.tipoMoneda.idDataCatalogo = ?4) and"
			+ " (?5 = -1 or c.entidadFinanciera.tipoEntidad.idDataCatalogo = ?5)")
	public abstract List<Cuenta> listaConsultaCompleja(String numero, int idEntidadFinanciera,int estado,int idTipoMoneda, int idTipoFinanciera);
}

