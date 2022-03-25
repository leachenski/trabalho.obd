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

import obd.fumageira.entities.Funcionario;
import obd.fumageira.repositories.FuncionarioRepository;

@CrossOrigin(origins = "http://127.0.0.1:8080")
@RestController
@RequestMapping("/api")
public class FuncionarioController {

	@Autowired
	FuncionarioRepository rep;

	@GetMapping(value = "/funcionarios")
	public List<Funcionario> getAllFuncionarios() {
		try {
			List<Funcionario> lf = rep.findAll();
			return lf;
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping(value = "/funcionarios/{id}")
	public Funcionario getById(@PathVariable Long id) {
		try {
			Funcionario f = rep.findById(id).get();
			return f;
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping(value = "/funcionarios")
	public Funcionario insert(@RequestBody Funcionario funcionario) {
		Funcionario f = rep.save(funcionario);
		return f;
	}

	@DeleteMapping(value = "/funcionarios/{id}")
	public Funcionario delete(@PathVariable Long id) {
		Funcionario f = rep.findById(id).get();
		if (f != null) {
			rep.delete(f);
			return f;
		} else {
			return null;
		}
	}

	@DeleteMapping(value = "/funcionarios")
	public void deleteAll() {
		rep.deleteAll();
	}
	
	@PutMapping(value = "/funcionarios/{id}")
	public Funcionario attFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
		Funcionario f = rep.findById(id).get();
		try {
			if(funcionario.getNome() != null) f.setNome(funcionario.getNome());
			if(funcionario.getDepartamento() != null) f.setDepartamento(funcionario.getDepartamento());
			rep.save(f);
			return f;
		} catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping(value = "/funcionarios/quantosofuncionarioorienta")
	public List<Object[]> consultaFuncionario1() {
		try {
			List<Object[]> lf = rep.findQuantosoFuncionarioOrienta();
			return lf;
		} catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping(value = "/funcionarios/quantosnodepartamento")
	public List<Object[]> consultaFuncionario2() {
		try {
			List<Object[]> ld = rep.findQuantosnoDepartamento();
			return ld;
		} catch (Exception e) {
			return null;
		}
	}

}
