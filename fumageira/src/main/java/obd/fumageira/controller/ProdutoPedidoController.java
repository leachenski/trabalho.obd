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

import obd.fumageira.entities.ProdutoPedido;
import obd.fumageira.repositories.ProdutoPedidoRepository;

@CrossOrigin(origins = "http://127.0.0.1:8080")
@RestController
@RequestMapping("/api")
public class ProdutoPedidoController {
	
	@Autowired
	ProdutoPedidoRepository rep;
	
	@GetMapping(value = "/produtospedidos")
	public List<ProdutoPedido> getAllProdutosPedidos() {
		try {
			List<ProdutoPedido> lp = rep.findAll();
			return lp;
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping(value = "/produtospedidos/{id}")
	public ProdutoPedido getById(@PathVariable Long id) {
		try {
			ProdutoPedido p = rep.findById(id).get();
			return p;
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping(value = "/produtospedidos")
	public ProdutoPedido insert(@RequestBody ProdutoPedido produtopedido) {
		ProdutoPedido p = rep.save(produtopedido);
		return p;
	}
	
	@DeleteMapping(value = "/produtospedidos/{id}")
	public ProdutoPedido delete(@PathVariable Long id) {
		ProdutoPedido p = rep.findById(id).get();
		if (p != null) {
			rep.delete(p);
			return p;
		} else {
			return null;
		}
	}

	@DeleteMapping(value = "/produtospedidos")
	public void deleteAll() {
		rep.deleteAll();
	}
	
	@PutMapping(value = "/produtospedidos/{id}")
	public ProdutoPedido attProdutoPedido(@PathVariable Long id, @RequestBody ProdutoPedido produtopedido) {
		ProdutoPedido p = rep.findById(id).get();
		try {
			if(produtopedido.getPedido() != null) p.setPedido(produtopedido.getPedido());
			if(produtopedido.getProduto() != null) p.setProduto(produtopedido.getProduto());
			p.setQtd(produtopedido.getQtd());
			rep.save(p);
			return p;
		} catch (Exception e) {
			return null;
		}
	}

}

