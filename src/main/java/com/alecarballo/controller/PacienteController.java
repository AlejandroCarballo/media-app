package com.alecarballo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
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

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


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
	
	@GetMapping("/hateoas{id}")
	public Resource <Paciente> leerPorIdHateoas(@PathVariable("id") Integer id) {
		Paciente paciente = service.leerPorId(id);
		if (paciente == null) {
			throw new ModelNotFoundException("ID no encontrado:" + id);
		}
		
		Resource<Paciente> resource = new Resource<Paciente>(paciente);
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).leerPorId(id));
		resource.add(linkTo.withRel("paciente-resource"));
		return resource;
	}


	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Paciente pac) {
		Paciente paciente = service.registrar(pac);
		// localhost:8080/pacientes/1
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
