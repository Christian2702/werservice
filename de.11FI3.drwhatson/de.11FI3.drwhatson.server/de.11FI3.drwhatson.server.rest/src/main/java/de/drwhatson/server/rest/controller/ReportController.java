package de.drwhatson.server.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import de.drwhatson.server.api.Report;

@RequestMapping("rest/report")
public class ReportController {

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.ACCEPTED)
	public void post(@RequestBody List<Report> report){
		
	}
	
}
