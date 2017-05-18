package de.drwhatson.server.business.service;

import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.drwhatson.server.api.domain.User;
import de.drwhatson.server.dao.repositories.UserRepository;

public class UserService {

	public static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	@Inject
	private UserRepository userRepository;

	public Optional<User> getUserByUsername(String username) {
		User user = userRepository.findByUsername(username);
		LOGGER.debug("found user=[{}] by username=[{}] ", user, username);
		return Optional.ofNullable(user);
	}

}
