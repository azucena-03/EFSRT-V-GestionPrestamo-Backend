package com.prestamo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.prestamo.entity.MontoPrestamo;

public interface MontoPrestamoRepository extends JpaRepository<MontoPrestamo, Integer>{
	
	@Query("SELECT m.capital FROM MontoPrestamo m WHERE m.dias.idDataCatalogo = :diasId")
	List<Integer> findCapitalsByDiasId(@Param("diasId") int diasId);

	@Query("SELECT m.monto FROM MontoPrestamo m WHERE m.dias.idDataCatalogo = :diasId AND m.capital = :capital")
	BigDecimal findMontoByDiasIdAndCapital(@Param("diasId") int diasId, @Param("capital") int capital);
	
	@Query("SELECT mp FROM MontoPrestamo mp WHERE CAST(mp.capital AS string) LIKE CONCAT(?1, '%')")
	List<MontoPrestamo> obtenerMontoPrestamosPorPrimerDigitoCapital(String capitalDigits);
	
	@Query("select m from MontoPrestamo m where "
			+ " m.capital = ?1 and "
			+ " m.estado = ?2 and "
			+ " m.monto = ?3 and "
			+ " (?4 = -1 or m.dias.idDataCatalogo = ?4)")
	public abstract List<MontoPrestamo> listaconsultaComplejoMonto(int capital,  int estado, BigDecimal monto, int idDias);

}
