package com.example.demo.entities;
/*Imports*/


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/*Entity for DB*/
@Entity
public class Event {

	/*ID of the entity*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nameEvent ;
	private String date;
	private String location;
	@Column(length = 429496729)
	private String photo;
	private String wiki;
	
	/*One-way*/

	@OneToMany

	private List<Category> categories;

	/*@OneToOne (cascade = CascadeType.ALL)
	private Image image;*/

	public Event() {}
	
	/*Constructor*/

	public Event(String nameEvent, String date, String location, String wiki, List<Category> categories) {
		this.nameEvent = nameEvent;
		this.date = date;
		this.location = location;
		this.wiki = wiki;
		this.categories = categories;
	}

	public Event(String nameEvent, String date, String location, String wiki,String photo) {
		this.nameEvent = nameEvent;
		this.date = date;
		this.photo = photo;
		this.location = location;
		this.wiki = wiki;
		this.categories = new ArrayList<>();
	}

	/*Getters and setters*/
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		if(photo==null){
			photo="";
		}
		this.photo = photo;
	}

	public String getWiki() {
		return wiki;
	}

	public void setWiki(String wiki) {
		this.wiki = wiki;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Event{" +
				"id=" + id +
				", nameEvent='" + nameEvent + '\'' +
				", date='" + date + '\'' +
				", location='" + location + '\'' +
				", photo='" + photo + '\'' +
				", wiki='" + wiki + '\'' +
				", categories=" + categories +
				'}';
	}
}
