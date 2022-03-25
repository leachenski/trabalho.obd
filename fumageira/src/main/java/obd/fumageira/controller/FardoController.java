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

import obd.fumageira.entities.Fardo;
import obd.fumageira.repositories.FardoRepository;

@CrossOrigin(origins = "http://127.0.0.1:8080")
@RestController
@RequestMapping("/api")
public class FardoController {

	@Autowired
	FardoRepository rep;

	@GetMapping(value = "/fardos")
	public List<Fardo> getAllFardos() {
		try {
			List<Fardo> lf = rep.findAll();
			return lf;
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping(value = "/fardos/{id}")
	public Fardo getById(@PathVariable Long id) {
		try {
			Fardo f = rep.findById(id).get();
			return f;
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping(value = "/fardos")
	public Fardo insert(@RequestBody Fardo fardo) {
		Fardo f = rep.save(fardo);
		return f;
	}
	
	@DeleteMapping(value = "/fardos/{id}")
	public Fardo delete(@PathVariable Long id) {
		Fardo f = rep.findById(id).get();
		if (f != null) {
			rep.delete(f);
			return f;
		} else {
			return null;
		}
	}

	@DeleteMapping(value = "/fardos")
	public void deleteAll() {
		rep.deleteAll();
	}
	
	@PutMapping(value = "/fardos/{id}")
	public Fardo attFardo(@PathVariable Long id, @RequestBody Fardo fardo) {
		Fardo f = rep.findById(id).get();
		try {
			if(fardo.getClasse() != null) f.setClasse(fardo.getClasse());
			if(fardo.getFuncionario() != null) f.setFuncionario(fardo.getFuncionario());
			if(fardo.getPeso() != null) f.setPeso(fardo.getPeso());
			f.setPago(fardo.isPago());
			if(fardo.getSafra() != null) f.setSafra(fardo.getSafra());
			rep.save(f);
			return f;
		} catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping(value = "/fardos/fardol")
	public List<Object[]> consultaFardo1() {
		try {
			List<Object[]> lf = rep.findFardoL();
			return lf;
		} catch (Exception e) {
			return null;
		}	
	}
	
	@GetMapping(value = "/fardos/qtdfardoscompradorpor")
	public List<Object[]> consultaFardo2() {
		try {
			List<Object[]> lf = rep.findQtdFardosCompradosPor();
			return lf;
		} catch (Exception e) {
			return null;
		}
	}
}
