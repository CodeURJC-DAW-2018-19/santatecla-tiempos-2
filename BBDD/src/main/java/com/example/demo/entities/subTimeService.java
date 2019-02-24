package com.example.demo.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class subTimeService {
	
	@Autowired
	public subTimeRepository subTimeRep;
	
	public List<subTime> findAll(){
		return subTimeRep.findAll();
	}
}
