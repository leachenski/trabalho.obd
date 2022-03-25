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

import obd.fumageira.entities.Pedido;
import obd.fumageira.repositories.PedidoRepository;

@CrossOrigin(origins = "http://127.0.0.1:8080")
@RestController
@RequestMapping("/api")
public class PedidoController {
	
	@Autowired
	PedidoRepository rep;
	
	@GetMapping(value = "/pedidos")
	public List<Pedido> getAllPedidos() {
		try {
			List<Pedido> lp = rep.findAll();
			return lp;
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping(value = "/pedidos/{id}")
	public Pedido getById(@PathVariable Long id) {
		try {
			Pedido p = rep.findById(id).get();
			return p;
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping(value = "/pedidos")
	public Pedido insert(@RequestBody Pedido pedido) {
		Pedido p = rep.save(pedido);
		return p;
	}
	
	@DeleteMapping(value = "/pedidos/{id}")
	public Pedido delete(@PathVariable Long id) {
		Pedido p = rep.findById(id).get();
		if (p != null) {
			rep.delete(p);
			return p;
		} else {
			return null;
		}
	}

	@DeleteMapping(value = "/pedidos")
	public void deleteAll() {
		rep.deleteAll();
	}
	
	@PutMapping(value = "/pedidos/{id}")
	public Pedido attPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
		Pedido p = rep.findById(id).get();
		try {
			if(pedido.getFuncionario() != null) p.setFuncionario(pedido.getFuncionario());
			if(pedido.getProdutor() != null) p.setProdutor(pedido.getProdutor());
			p.setPago(pedido.isPago());
			rep.save(p);
			return p;
		} catch (Exception e) {
			return null;
		}
	}

}
