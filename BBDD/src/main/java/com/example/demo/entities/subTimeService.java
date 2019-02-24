package com.example.demo.entities;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class subTimeService {
	
	@Autowired
	public subTimeRepository subTimeRep;
	
	public List<SubTime> findAll(){
		return subTimeRep.findAll();
	}
	
	public Optional<SubTime> findOne(long id){
		return subTimeRep.findById(id);
	}
}
