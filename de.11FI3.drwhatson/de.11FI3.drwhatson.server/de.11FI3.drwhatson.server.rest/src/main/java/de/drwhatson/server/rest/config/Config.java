package de.drwhatson.server.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.drwhatson.server.rest.controller.ReportController;

@Configuration
public class Config {

	@Bean
	public ReportController reportController() {
		return new ReportController();
	}
	
}
