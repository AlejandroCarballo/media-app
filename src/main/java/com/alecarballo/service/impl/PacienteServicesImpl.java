package com.alecarballo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alecarballo.model.Paciente;
import com.alecarballo.repo.IPacienteRepo;
import com.alecarballo.service.IPacienteService;

public class PacienteServicesImpl implements IPacienteService {
	
	@Autowired
	private IPacienteRepo repo;

	@Override
	public void registrar(Paciente pac) {
		repo.save(pac);

	}

	@Override
	public void modificar(Paciente pac) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Paciente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paciente leerPorId(Integer id) {
		repo.findOne(id);
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub

	}

}
