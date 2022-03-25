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

import obd.fumageira.entities.Localidade;
import obd.fumageira.repositories.LocalidadeRepository;

@CrossOrigin(origins = "http://127.0.0.1:8080")
@RestController
@RequestMapping("/api")
public class LocalidadeController {
	
	@Autowired
	LocalidadeRepository rep;
	
	@GetMapping(value = "/localidades")
	public List<Localidade> getAllLocalidades() {
		try {
			List<Localidade> ll = rep.findAll();
			return ll;
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping(value = "/localidades/{id}")
	public Localidade getById(@PathVariable Long id) {
		try {
			Localidade l = rep.findById(id).get();
			return l;
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping(value = "/localidades")
	public Localidade insert(@RequestBody Localidade localidade) {
		Localidade l = rep.save(localidade);
		return l;
	}
	
	@DeleteMapping(value = "/localidades/{id}")
	public Localidade delete(@PathVariable Long id) {
		Localidade l = rep.findById(id).get();
		if (l != null) {
			rep.delete(l);
			return l;
		} else {
			return null;
		}
	}

	@DeleteMapping(value = "/localidades")
	public void deleteAll() {
		rep.deleteAll();
	}
	
	@PutMapping(value = "/localidades/{id}")
	public Localidade attLocalidade(@PathVariable Long id, @RequestBody Localidade localidade) {
		Localidade l = rep.findById(id).get();
		try {
			if(localidade.getArea() != null) l.setArea(localidade.getArea());
			if(localidade.getCidade() != null) l.setCidade(localidade.getCidade());
			if(localidade.getEstado() != null) l.setEstado(localidade.getEstado());
			if(localidade.getProdutor() != null) l.setProdutor(localidade.getProdutor());
			rep.save(l);
			return l;
		} catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping(value = "/localidades/cidadeareaproduzida")
	public List<Object[]> consultaLocalidade1() {
		try {
			List<Object[]> ll = rep.findCidadeAreaProduzida();
			return ll;
		} catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping(value = "/localidades/quantosproduzemnumacidade")
	public List<Object[]> consultaLocalidade2() {
		try {
			List<Object[]> ll = rep.findQuantosProduzemNumaCidade();
			return ll;
		} catch (Exception e) {
			return null;
		}
	}

}
