package com.example.demo.Entidades;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Tiempo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nameInterval;
	private String fechainicio;
	private String fechaFin;
	
	public Tiempo(String nameInterval, String fechainicio, String fechaFin) {
		this.nameInterval = nameInterval;
		this.fechainicio = fechainicio;
		this.fechaFin = fechaFin;
	}
	
	
	@OneToMany
	private List<Eventos> eventos;
	
	

	public List<Eventos> getEventos() {
		return eventos;
	}

	public void setEventos(List<Eventos> eventos) {
		this.eventos = eventos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameInterval() {
		return nameInterval;
	}

	public void setNameInterval(String nameInterval) {
		this.nameInterval = nameInterval;
	}

	public String getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "Tiempo [id=" + id + ", nameInterval=" + nameInterval + ", fechainicio=" + fechainicio + ", fechaFin="
				+ fechaFin + "]";
	}
	
	
	
}
