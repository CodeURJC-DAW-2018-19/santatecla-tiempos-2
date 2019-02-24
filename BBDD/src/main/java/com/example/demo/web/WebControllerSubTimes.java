package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.entities.subTimeService;

@Controller
public class WebControllerSubTimes {

	@Autowired
    private subTimeService subTimeService;
}
