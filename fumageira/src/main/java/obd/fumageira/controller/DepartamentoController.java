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

import obd.fumageira.entities.Departamento;
import obd.fumageira.repositories.DepartamentoRepository;

@CrossOrigin(origins = "http://127.0.0.1:8080")
@RestController
@RequestMapping("/api")
public class DepartamentoController {

	@Autowired
	DepartamentoRepository rep;

	@GetMapping(value = "/departamentos")
	public List<Departamento> getAllDepartamentos() {
		try {
			List<Departamento> ld = rep.findAll();
			return ld;
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping(value = "/departamentos/{id}")
	public Departamento getById(@PathVariable Long id) {
		try {
			Departamento d = rep.findById(id).get();
			return d;
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping(value = "/departamentos")
	public Departamento insert(@RequestBody Departamento departamento) {
		Departamento d = rep.save(departamento);
		return d;
	}
	
	@DeleteMapping(value = "/departamentos/{id}")
	public Departamento delete(@PathVariable Long id) {
		Departamento d = rep.findById(id).get();
		if (d != null) {
			rep.delete(d);
			return d;
		} else {
			return null;
		}
	}

	@DeleteMapping(value = "/departamentos")
	public void deleteAll() {
		rep.deleteAll();
	}
	
	@PutMapping(value = "/departamentos/{id}")
	public Departamento attDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
		Departamento d = rep.findById(id).get();
		try {
			if(departamento.getNome() != null) d.setNome(departamento.getNome());
			rep.save(d);
			return d;
		} catch (Exception e) {
			return null;
		}
	}
	

	
}
