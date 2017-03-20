package de.drwhatson.server.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("home")
public class HomeController {

	@RequestMapping(method=RequestMethod.GET)
	public String home(){
		return "home";
	}
}
