package com.example.demo.entities;
/*Imports*/


import com.fasterxml.jackson.annotation.JsonCreator;
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
	private String wiki;
	private boolean hasImage;
	
	/*One-way*/


	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@ElementCollection
	private List<Category> categories;



	@Lob
	private byte[] photo;
	
	@Lob
	private String encodedImage;

	public Event() {}
	
	/*Constructor*/
	@JsonCreator
	public Event(Long id){
		this.id=id;
	}

	public Event(String nameEvent, String date, String location, String wiki, List<Category> categories) {
		this.nameEvent = nameEvent;
		this.date = date;
		this.location = location;
		this.wiki = wiki;
		this.categories = categories;
		this.hasImage=false;
	}

	public Event(String nameEvent, String date, String location, String wiki) {
		this.nameEvent = nameEvent;
		this.date = date;
		//this.photo = photo;
		this.location = location;
		this.wiki = wiki;
		this.categories = new ArrayList<>();
		this.hasImage=false;
	}

	/*Getters and setters*/
	
	
	public boolean isHasImage() {
		return hasImage;
	}

	public String getEncodedImage() {
		return encodedImage;
	}

	public void setEncodedImage(String encodedImage) {
		this.encodedImage = encodedImage;
	}

	public void setHasImage(boolean hasImage) {
		this.hasImage = hasImage;
	}

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

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
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
