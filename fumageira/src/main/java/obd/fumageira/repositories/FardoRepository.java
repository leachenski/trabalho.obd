package obd.fumageira.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import obd.fumageira.entities.Fardo;

public interface FardoRepository extends JpaRepository<Fardo, Long> {
	
	@Query(value = 
			"select tb_fardo.id as fardo, tb_classe.nome as nomedaclasse from tb_fardo join tb_classe on tb_fardo.classe_id = tb_classe.id where tb_classe.nome like '_L_'", 
			nativeQuery = true)
	List<Object[]> findFardoL();
	
	@Query(value = 
			"select count(tb_fardo.id) as fardoscompradospor, tb_funcionario.nome as qualfuncionario from tb_fardo join tb_funcionario on tb_fardo.funcionario_id = tb_funcionario.id group by qualfuncionario", 
			nativeQuery = true)
	List<Object[]> findQtdFardosCompradosPor();

}