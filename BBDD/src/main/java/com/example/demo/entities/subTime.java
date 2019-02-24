package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class subTime {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nameSubTime;
	private String startDate;
	private String endDate;
	
	@OneToMany
	private List<subTime> subTimes;
	
	public subTime() {}
	
	public subTime(String nameSubTime, String startDate, String endDate) {
		this.nameSubTime = nameSubTime;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getNameSubTime() {
		return nameSubTime;
	}

	public void setNameSubTime(String nameSubTime) {
		this.nameSubTime = nameSubTime;
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

	public List<subTime> getSubTimes() {
		return subTimes;
	}

	public void setSubTimes(List<subTime> subTimes) {
		this.subTimes = subTimes;
	}

	@Override
	public String toString() {
		return "subTime [id=" + id + ", nameSubTime=" + nameSubTime + ", startDate=" + startDate + ", endDate="
				+ endDate + ", subTimes=" + subTimes + "]";
	}
	
	
}
