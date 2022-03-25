package obd.fumageira.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import obd.fumageira.entities.Produtor;

public interface ProdutorRepository extends JpaRepository<Produtor, Long> { 

	@Query(value = 
			"select tb_produtor.nome as qualprodutor, sum(tb_localidade.area) as areaproduzida from tb_produtor join tb_localidade on tb_produtor.id = tb_localidade.produtor_id group by qualprodutor", 
			nativeQuery = true)
	List<Object[]> findAreaProduzidaPorProdutor();

	@Query(value = 
			"select tb_produtor.nome as qualprodutor, count(tb_fardo.id) as fardosproduzidos from tb_produtor join tb_safra on tb_produtor.id = tb_safra.produtor_id join tb_fardo on tb_safra.id = tb_fardo.safra_id where tb_fardo.peso != 0.0 group by qualprodutor", 
	nativeQuery = true)
			List<Object[]> findQuantosFardosoProdutorProduziu();

}
