package com.alecarballo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alecarballo.exception.ModelNotFoundException;
import com.alecarballo.model.Paciente;
import com.alecarballo.service.IPacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private IPacienteService service;

	@GetMapping
	public ResponseEntity<List<Paciente>> listar() {
		List<Paciente> lista = service.listar();
		return new ResponseEntity<List<Paciente>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Paciente> leerPorId(@PathVariable("id") Integer id) {
		Paciente paciente = service.leerPorId(id);
		if (paciente == null) {
			throw new ModelNotFoundException("ID no encontrado:" + id);
		}
		return new ResponseEntity<Paciente>(paciente, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Paciente pac) {
		Paciente paciente = service.registrar(pac);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(paciente.getIdPaciente()).toUri();
		service.registrar(pac);
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Object> modificar(@Valid @RequestBody Paciente pac) {
		service.modificar(pac);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
	}

}
