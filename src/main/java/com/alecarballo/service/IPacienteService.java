package com.alecarballo.service;

import java.util.List;

import com.alecarballo.model.Paciente;

public interface IPacienteService {

	Paciente registrar(Paciente pac);

	void modificar(Paciente pac);

	List<Paciente> listar();

	Paciente leerPorId(Integer id);

	void eliminar(Integer id);

}
