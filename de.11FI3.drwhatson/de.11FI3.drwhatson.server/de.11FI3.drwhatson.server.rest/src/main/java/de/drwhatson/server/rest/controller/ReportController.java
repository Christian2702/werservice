package de.drwhatson.server.rest.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.drwhatson.server.api.Report;

@RequestMapping("rest/report")
public class ReportController {

	@RequestMapping(method = RequestMethod.POST)
	public void post(@RequestBody Report report){
		
	}
	
}
