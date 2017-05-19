package de.drwhatson.server.business.service;

import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.drwhatson.server.api.domain.Client;
import de.drwhatson.server.dao.repositories.ClientRepository;

public class ClientService {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);
	@Inject
	private ClientRepository clientRepository;
	
	public Optional<Client> getClientByMacAddress(String macAddress){
		Client client = clientRepository.findByMacAddress(macAddress);
		LOGGER.debug("found client=[{}] by macAddress=[{}] ", client, macAddress);
		return Optional.ofNullable(client);
	}

}
