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

import obd.fumageira.entities.Produtor;
import obd.fumageira.repositories.ProdutorRepository;

@CrossOrigin(origins = "http://127.0.0.1:8080")
@RestController
@RequestMapping("/api")
public class ProdutorController {
	
	@Autowired
	ProdutorRepository rep;
	
	@GetMapping(value = "/produtores")
	public List<Produtor> getAllProdutores() {
		try {
			List<Produtor> lp = rep.findAll();
			return lp;
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping(value = "/produtores/{id}")
	public Produtor getById(@PathVariable Long id) {
		try {
			Produtor p = rep.findById(id).get();
			return p;
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping(value = "/produtores")
	public Produtor insert(@RequestBody Produtor produtor) {
		Produtor p = rep.save(produtor);
		return p;
	}
	
	@DeleteMapping(value = "/produtores/{id}")
	public Produtor delete(@PathVariable Long id) {
		Produtor p = rep.findById(id).get();
		if (p != null) {
			rep.delete(p);
			return p;
		} else {
			return null;
		}
	}

	@DeleteMapping(value = "/produtores")
	public void deleteAll() {
		rep.deleteAll();
	}
	
	@PutMapping(value = "/produtores/{id}")
	public Produtor attProdutor(@PathVariable Long id, @RequestBody Produtor produtor) {
		Produtor p = rep.findById(id).get();
		try {
			if(produtor.getFuncionario() != null) p.setFuncionario(produtor.getFuncionario());
			if(produtor.getNome() != null) p.setNome(produtor.getNome());
			rep.save(p);
			return p;
		} catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping(value = "/produtores/areaproduzidaporprodutor")
	public List<Object[]> consultaProdutores1() {
		try {
			List<Object[]> lp = rep.findAreaProduzidaPorProdutor();
			return lp;
		} catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping(value = "/produtores/quantosfardosoprodutorproduziu")
	public List<Object[]> consultaProdutores2() {
		try {
			List<Object[]> lp = rep.findQuantosFardosoProdutorProduziu();
			return lp;
		} catch (Exception e) {
			return null;
		}
	}

}
