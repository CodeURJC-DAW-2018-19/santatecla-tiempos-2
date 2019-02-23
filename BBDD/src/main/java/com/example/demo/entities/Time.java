package com.example.demo.entities;

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
	private List<Event> events;
	
	public Time() {}

	public Time(String nameInterval, String startDate, String endDate) {
		this.nameInterval = nameInterval;
		this.startDate = startDate;
		this.endDate = endDate;
		this.events = new ArrayList<Event>();
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

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Time [id=" + id + ", nameInterval=" + nameInterval + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", events=" + events + "]";
	}
	
	

	
	
	
}
