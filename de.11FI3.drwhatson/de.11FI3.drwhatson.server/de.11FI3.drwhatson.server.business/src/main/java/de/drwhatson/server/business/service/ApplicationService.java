package de.drwhatson.server.business.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.drwhatson.server.api.domain.Application;
import de.drwhatson.server.dao.repositories.ApplicationRepository;

public class ApplicationService {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ApplicationService.class);
	@Inject
	private ApplicationRepository applicationRepository;

	public Optional<Application> getApplicationByName(String name){
		Application application = applicationRepository.findByName(name);
		LOGGER.debug("found application=[{}] by name=[{}] ", application, name);
		return Optional.ofNullable(application);
	}
	
	public List<Application> getAll(){
		List<Application> applications = applicationRepository.findAll();
		LOGGER.debug("found applications=[{}]", applications);
		return applications;
	}
	
}
