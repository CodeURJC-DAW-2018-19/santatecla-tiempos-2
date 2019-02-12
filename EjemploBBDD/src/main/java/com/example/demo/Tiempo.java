package com.example.demo;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Tiempo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nameInterval;
	private Date fechainicio;
	private Date fechaFin;
}
