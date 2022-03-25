package obd.fumageira.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import obd.fumageira.entities.Produto;
import obd.fumageira.repositories.ProdutoRepository;

@CrossOrigin(origins = "http://127.0.0.1:8080")
@RestController
@RequestMapping("/api")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository rep;
	
	@GetMapping(value = "/produtos")
	public List<Produto> getAllProdutos() {
		try {
			List<Produto> lp = rep.findAll();
			return lp;
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping(value = "/produtos/{id}")
	public Produto getById(@PathVariable Long id) {
		try {
			Produto p = rep.findById(id).get();
			return p;
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping(value = "/produtos")
	public Produto insert(@RequestBody Produto produto) {
		Produto p = rep.save(produto);
		return p;
	}
	
	@DeleteMapping(value = "/produtos/{id}")
	public Produto delete(@PathVariable Long id) {
		Produto p = rep.findById(id).get();
		if (p != null) {
			rep.delete(p);
			return p;
		} else {
			return null;
		}
	}

	@DeleteMapping(value = "/produtos")
	public void deleteAll() {
		rep.deleteAll();
	}
	
	@PutMapping(value = "/produtos/{id}")
	public Produto attProduto(@PathVariable Long id, @RequestBody Produto produto) {
		Produto p = rep.findById(id).get();
		try {
			if(produto.getDescricao() != null) p.setDescricao(produto.getDescricao());
			p.setQtddisponivel(produto.getQtddisponivel());
		    if(produto.getValorunitario() != null) p.setValorunitario(produto.getValorunitario());
			rep.save(p);
			return p;
		} catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping(value = "/produtos/semestoque")
	public List<Object[]> consultaProduto1() {
		try {
			List<Object[]> lp = rep.findProdutoSemEstoque();
			return lp;
		} catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping(value = "/produtos/arrecadacao")
	public List<Object[]> consultaProduto2() {
		try {
			List<Object[]> lp = rep.findProdutoeArrecadacao();
			return lp;
		} catch (Exception e) {
			return null;
		}
	}

}
