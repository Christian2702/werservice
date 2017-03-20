package de.drwhatson.server.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.drwhatson.server.api.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
