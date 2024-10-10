package com.prestamo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prestamo.entity.EntidadFinanciera;

public interface CuentaFinancieraRepository extends JpaRepository<EntidadFinanciera, Integer>{

	
	public abstract List<EntidadFinanciera> findByOrderByNombreAsc();
}
