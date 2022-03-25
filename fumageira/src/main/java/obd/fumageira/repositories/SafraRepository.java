package obd.fumageira.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import obd.fumageira.entities.Safra;

public interface SafraRepository extends JpaRepository<Safra, Long> {
		
	@Query(value = 
			"select ano, sum(estimativa) from tb_safra group by ano", 
			nativeQuery = true)
	List<Object[]> findSafraEstimativaDoAno();

}