package com.example.demo.Entidades;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Time {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nameInterval;
	private String startDate;
	private String endDate;

	@OneToMany
	private List<Eventos> events;

	public Time(String nameInterval, String startDate, String endDate) {
		this.nameInterval = nameInterval;
		this.startDate = startDate;
		this.endDate = endDate;
		this.events = new ArrayList<Eventos>();
	}

	public String getNameInterval() {
		return nameInterval;
	}

	public void setNameInterval(String nameInterval) {
		this.nameInterval = nameInterval;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<Eventos> getEvents() {
		return events;
	}

	public void setEvents(List<Eventos> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Time [id=" + id + ", nameInterval=" + nameInterval + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", events=" + events + "]";
	}
	
	

	
	
	
}
