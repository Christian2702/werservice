package de.drwhatson.server.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.drwhatson.server.api.Report;
import de.drwhatson.server.api.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
