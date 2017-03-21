package de.drwhatson.server.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.drwhatson.server.web.controller.HomeController;

@Configuration
public class WebConfig {

	@Bean
	public HomeController homeController(){
		return new HomeController();
	}
}
