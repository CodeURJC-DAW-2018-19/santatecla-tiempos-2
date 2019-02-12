package com.example.demo;
/*Imports*/


import java.sql.Date;
import java.util.List;

import javax.persistence.*;


/*Declaramos la clase como entidad para crear la base de datos*/
@Entity
public class Eventos {

	/*Generamos el Id de cada evento*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nameEvent ;
	private Date date;
	private String photo;
	private String wiki;
	
	/*bidireccionalidad*/
	@ManyToMany
	private List<Categorias>categorie;
	
	/*Constructor vacio*/
	public Eventos() {
		
	}
	
	/*Constructor*/
	public Eventos( String nameEvent, Date date, String photo, String wiki) {
	
		
		this.nameEvent = nameEvent;
		this.date = date;
		this.photo = photo;
		this.wiki = wiki;
	}

	/*Getters and setters*/
	public long getIdEventos() {
		return id;
	}

	public void setIdEventos(long idEventos) {
		this.id = idEventos;
	}

	public String getNameEvent() {
		return nameEvent;
	}

	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getWiki() {
		return wiki;
	}

	public void setWiki(String wiki) {
		this.wiki = wiki;
	}

	@Override
	public String toString() {
		return "Eventos [idEventos=" + id + ", nameEvent=" + nameEvent + ", date=" + date + ", photo=" + photo
				+ ", wiki=" + wiki + "]";
	}
	
	
}
