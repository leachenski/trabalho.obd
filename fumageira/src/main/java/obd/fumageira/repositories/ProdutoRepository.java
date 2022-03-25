package obd.fumageira.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import obd.fumageira.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Query(value = "select * from tb_produto where qtddisponivel = 0", nativeQuery = true)
	List<Object[]> findProdutoSemEstoque();
	
	@Query(value = "select tb_produto.descricao as descr, \n"
			+ "count(tb_produtopedido.id) as vezespedido,  \n"
			+ "sum(tb_produtopedido.qtd * tb_produto.valorunitario) as arrecadacao, \n"
			+ "sum(tb_produtopedido.qtd) as quantidadetotalvendida \n"
			+ "from tb_produto \n"
			+ "join tb_produtopedido \n"
			+ "on tb_produto.id = tb_produtopedido.produto_id\n"
			+ "group by tb_produto.id", nativeQuery = true)
	List<Object[]> findProdutoeArrecadacao();

}