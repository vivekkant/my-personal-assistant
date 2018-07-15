package org.weekendsoft.mpa.referencedata.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "Home URL default response of the reference data microservice";
	}

}
