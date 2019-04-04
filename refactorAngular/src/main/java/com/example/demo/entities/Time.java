package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Time {

	public interface Visitante{}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@JsonView(Visitante.class)
	private String nameInterval;

	private String startDate;
	private String endDate;

	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@ElementCollection
	private List<Event> event;


	/*@OneToMany(cascade=CascadeType.ALL)
	@ElementCollection
	private List<SubTime> subIntervals;*/
	
	public Time() {}

	public Time(String nameInterval, String startDate, String endDate) {
		this.nameInterval = nameInterval;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Time(String nameInterval, String startDate, String endDate, List<Event> event) {
		this.nameInterval = nameInterval;
		this.startDate = startDate;
		this.endDate = endDate;
		this.event = event;
		//this.subIntervals = new ArrayList<SubTime>();
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

	public List<Event> getEvent() {
		return event;
	}

	public void setEvent(List<Event> event) {
		this.event = event;
	}	

	/*public List<SubTime> getSubIntervals() {
		return subIntervals;
	}

	public void setSubIntervals(List<SubTime> subIntervals) {
		this.subIntervals = subIntervals;
	}*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Time [id=" + id + ", nameInterval=" + nameInterval + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", event=" + event + "]";
	}
	
	

	
	
	
}
