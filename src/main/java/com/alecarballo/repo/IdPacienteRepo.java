package com.alecarballo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alecarballo.model.Paciente;

public interface IdPacienteRepo extends JpaRepository<Paciente, Integer> {

}
