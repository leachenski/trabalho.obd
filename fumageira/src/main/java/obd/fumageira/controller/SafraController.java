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

import obd.fumageira.entities.Safra;
import obd.fumageira.repositories.SafraRepository;

@CrossOrigin(origins = "http://127.0.0.1:8080")
@RestController
@RequestMapping("/api")
public class SafraController {

	@Autowired
	SafraRepository rep;

	@GetMapping(value = "/safras")
	public List<Safra> getAllSafras() {
		try {
			List<Safra> ls = rep.findAll();
			return ls;
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping(value = "/safras/{id}")
	public Safra getById(@PathVariable Long id) {
		try {
			Safra s = rep.findById(id).get();
			return s;
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping(value = "/safras")
	public Safra insert(@RequestBody Safra safra) {
		Safra s = rep.save(safra);
		return s;
	}

	@DeleteMapping(value = "/safras/{id}")
	public Safra delete(@PathVariable Long id) {
		Safra s = rep.findById(id).get();
		if (s != null) {
			rep.delete(s);
			return s;
		} else {
			return null;
		}
	}

	@DeleteMapping(value = "/safras")
	public void deleteAll() {
		rep.deleteAll();
	}

	@PutMapping(value = "/safras/{id}")
	public Safra attSafra(@PathVariable Long id, @RequestBody Safra safra) {
		Safra s = rep.findById(id).get();
		try {
			if (safra.getAno() != null)
				s.setAno(safra.getAno());
			if (safra.getEstimativa() != null)
				s.setEstimativa(safra.getEstimativa());
			if (safra.getFuncionario() != null)
				s.setFuncionario(safra.getFuncionario());
			if (safra.getProdutor() != null)
				s.setProdutor(safra.getProdutor());
			rep.save(s);
			return s;
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping(value = "/safras/estimativadoano")
	public List<Object[]> consultaSafra1() {
		try {
			List<Object[]> ls = rep.findSafraEstimativaDoAno();
			return ls;
		} catch (Exception e) {
			return null;
		}
	}

}
