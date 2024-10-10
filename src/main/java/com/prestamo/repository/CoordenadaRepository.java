package com.prestamo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prestamo.entity.Coordenada;
import com.prestamo.entity.Usuario;

public interface CoordenadaRepository extends JpaRepository<Coordenada, Integer> {
	
	@Query("Select r from Usuario r, UsuarioHasRol u where r.idUsuario = u.usuario.idUsuario and u.rol.idRol = 4 order by r.apellidos desc ")
	public abstract List<Usuario> listaPrestamistariosTotales();
	
	@Query("Select c from Coordenada c where c.prestatario = ?1")
	public abstract List<Coordenada> listaPorPrestatarioIgual(Usuario idPrestatario);
	
	@Query("Select c from Coordenada c where concat(c.prestatario.nombres, ' ', c.prestatario.apellidos) like ?1")
	public abstract List<Coordenada> listaPorPrestatarioLike(String nombreCompleto);
	
	@Query("Select c from Coordenada c where c.prestatario = ?1 and c.idCoordenada != ?2")
	public abstract List<Coordenada> listaPorPrestatarioIgualActualiza(Usuario idPrestatario, int idCoordenada);

	@Query("Select c from Coordenada c where "
									+ " (?1 = -1 or c.latitud = ?1) and "
									+ " (?2 = -1 or c.longitud = ?2) and "
									+ " c.estado = ?3")
	public abstract List<Coordenada> listaConsultaCoordenada(BigDecimal latitud, BigDecimal longitud, int estado);
}
