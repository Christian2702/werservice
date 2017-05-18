package de.drwhatson.server.business.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.drwhatson.server.business.service.ApplicationService;
import de.drwhatson.server.business.service.ClientService;
import de.drwhatson.server.business.service.ReportRequestToReportConverterService;
import de.drwhatson.server.business.service.ReportService;
import de.drwhatson.server.business.service.UserService;

@Configuration
public class ServiceConfiguration {

	@Bean
	public ApplicationService applicationService() {
		return new ApplicationService();
	}

	@Bean
	public ClientService clientService() {
		return new ClientService();
	}

	@Bean
	public ReportService reportService() {
		return new ReportService();
	}

	@Bean
	public UserService userService() {
		return new UserService();
	}

	@Bean
	public ReportRequestToReportConverterService reportRequestToReportConverterService() {
		return new ReportRequestToReportConverterService();
	}
}
