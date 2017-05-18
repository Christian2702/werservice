package de.drwhatson.server.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.drwhatson.server.rest.controller.ReportRequestController;

@Configuration
public class RestConfig {

	@Bean
	public ReportRequestController reportController() {
		return new ReportRequestController();
	}
	
}
