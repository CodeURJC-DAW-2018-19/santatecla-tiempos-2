package com.example.demo.Entidades;


import java.util.List;

import javax.persistence.*;



@Entity
public class Categorias {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nameCategory;
	
	/*UniDireccional*/
	@ManyToMany(mappedBy="categorias")
	private List<Eventos>event;
	
	
	public Categorias() {
		
	}

	public Categorias( String nameCategory) {
		
		
		this.nameCategory = nameCategory;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	@Override
	public String toString() {
		return "Categorias [id=" + id + ", nameCategory=" + nameCategory + "]";
	}
	
	
	
}
