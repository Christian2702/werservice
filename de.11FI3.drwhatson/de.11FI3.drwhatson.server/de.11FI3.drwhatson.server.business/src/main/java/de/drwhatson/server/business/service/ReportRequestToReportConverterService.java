package de.drwhatson.server.business.service;

import java.util.Date;
import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import de.drwhatson.server.api.ReportRequest;
import de.drwhatson.server.api.domain.Application;
import de.drwhatson.server.api.domain.Client;
import de.drwhatson.server.api.domain.Report;
import de.drwhatson.server.api.domain.User;

public class ReportRequestToReportConverterService implements Converter<ReportRequest, Report> {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ReportRequestToReportConverterService.class);
	
	@Inject
	private ApplicationService applicationService;
	@Inject
	private ClientService clientService;
	@Inject
	private UserService userService;

	public Report convert(ReportRequest reportRequest) {
		Application application = getApplicationForName(reportRequest.getAppName());
		User user = getUserForUserName(reportRequest.getUserName());
		Client client = getClientForMacAddress(reportRequest.getMacAddress());
		Report report = Report.create(client, user, application, reportRequest.getBucketId(),
				reportRequest.getEventType(), reportRequest.getAppVersion(), reportRequest.getAppPath(),
				new Date(reportRequest.getEventTime()));
		return report;
	}

	private Application getApplicationForName(String name) {
		Optional<Application> application = applicationService.getApplicationByName(name);
		return application.orElseGet(() -> {
			return Application.create(name);
		});
	}

	private User getUserForUserName(String userName) {
		Optional<User> user = userService.getUserByUsername(userName);
		return user.orElseGet(() -> {
			return User.create(userName);
		});
	}

	private Client getClientForMacAddress(String macAddress) {
		Optional<Client> clientOptional = clientService.getClientByMacAddress(macAddress);
		return clientOptional.orElseGet(() -> {
			return Client.create(null, macAddress);
		});
	}

}
