package obd.fumageira.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import obd.fumageira.entities.Localidade;

public interface LocalidadeRepository extends JpaRepository<Localidade, Long> {
	
	@Query(value = 
			"select cidade, sum(area) from tb_localidade group by cidade order by cidade", 
			nativeQuery = true)
	List<Object[]> findCidadeAreaProduzida();

	@Query(value = 
			"select tb_localidade.estado, tb_localidade.cidade, count(tb_localidade.produtor_id) as quantosproduzemaqui from tb_produtor join tb_localidade on tb_produtor.id = tb_localidade.produtor_id group by tb_localidade.estado, tb_localidade.cidade", 
			nativeQuery = true)
	List<Object[]> findQuantosProduzemNumaCidade();
}