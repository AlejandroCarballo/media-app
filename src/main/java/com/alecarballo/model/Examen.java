package com.alecarballo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Examen")
public class Examen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idExamen; 
	
	@Column(name = "name", nullable=false, length=50)
	private String name;
	
	@Column(name = "apellido", nullable=false, length= 50)
	private String apellido;
	
	
	

}
