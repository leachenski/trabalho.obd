package obd.fumageira.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import obd.fumageira.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	@Query(
			value = "select tb_funcionario.nome as nomedofuncionario, count(tb_produtor.id) as orienta from tb_produtor join tb_funcionario on tb_funcionario.id = tb_produtor.funcionario_id group by nomedofuncionario", 
			nativeQuery = true)
	List<Object[]> findQuantosoFuncionarioOrienta();
	
	@Query(value = "select count(tb_funcionario.departamento_id) as existem, tb_departamento.nome as qualdepartamento\n"
			+ "from tb_funcionario\n"
			+ "join tb_departamento\n"
			+ "on tb_funcionario.departamento_id = tb_departamento.id\n"
			+ "group by qualdepartamento", nativeQuery = true)
	List<Object[]> findQuantosnoDepartamento();

}