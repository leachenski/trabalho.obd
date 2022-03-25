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

import obd.fumageira.entities.Classe;
import obd.fumageira.repositories.ClasseRepository;

@CrossOrigin(origins = "http://127.0.0.1:8080")
@RestController
@RequestMapping("/api")
public class ClasseController {
	
	@Autowired
	ClasseRepository rep;
	
	@GetMapping(value = "/classes")
	public List<Classe> getAllClasses() {
		try {
			List<Classe> lc = rep.findAll();
			return lc;
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping(value = "/classes/{id}")
	public Classe getById(@PathVariable Long id) {
		try {
			Classe c = rep.findById(id).get();
			return c;
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping(value = "/classes")
	public Classe insert(@RequestBody Classe classe) {
		Classe c = rep.save(classe);
		return c;
	}
	
	@DeleteMapping(value = "/classes/{id}")
	public Classe delete(@PathVariable Long id) {
		Classe c = rep.findById(id).get();
		if (c != null) {
			rep.delete(c);
			return c;
		} else {
			return null;
		}
	}

	@DeleteMapping(value = "/classes")
	public void deleteAll() {
		rep.deleteAll();
	}
	
	@PutMapping(value = "/classes/{id}")
	public Classe attClasse(@PathVariable Long id, @RequestBody Classe classe) {
		Classe c = rep.findById(id).get();
		try {
			if(classe.getNome() != null) c.setNome(classe.getNome());
			if(classe.getValor() != null) c.setValor(classe.getValor());
			if(classe.getAno() != null) c.setAno(classe.getAno());
			rep.save(c);
			return c;
		} catch (Exception e) {
			return null;
		}
	}

}
