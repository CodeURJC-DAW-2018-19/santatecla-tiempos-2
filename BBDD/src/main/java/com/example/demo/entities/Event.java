package com.example.demo.entities;
/*Imports*/


import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;


/*Declaramos la clase como entidad para crear la base de datos*/
@Entity
public class Event {

	/*Generamos el Id de cada evento*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private long id;
	private String nameEvent ;
	private String date;
	//private String photo;
	private String wiki;
	
	/*bidireccionalidad*/

	@ManyToMany
	private List<Category> categories;

	@OneToOne (cascade = CascadeType.ALL)
	private Photo image;


	
	/*Constructor*/

	public Event(String nameEvent, String date, String wiki) {
		this.nameEvent = nameEvent;
		this.date = date;
		//this.photo = photo;
		this.wiki = wiki;
	}

	/*Getters and setters*/
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameEvent() {
		return nameEvent;
	}

	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
/*
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
*/
	public String getWiki() {
		return wiki;
	}

	public void setWiki(String wiki) {
		this.wiki = wiki;
	}

	public List<Category> getCategorias() {
		return categories;
	}

	public void setCategoras(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Eventos [idEventos=" + id + ", nameEvent=" + nameEvent + ", date=" + date
				+ ", wiki=" + wiki + "]";
	}
	
	
}
