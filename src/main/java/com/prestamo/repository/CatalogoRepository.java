package com.prestamo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prestamo.entity.Catalogo;

public interface CatalogoRepository extends JpaRepository<Catalogo, Integer> {
	
	public abstract List<Catalogo> findAll();

}
