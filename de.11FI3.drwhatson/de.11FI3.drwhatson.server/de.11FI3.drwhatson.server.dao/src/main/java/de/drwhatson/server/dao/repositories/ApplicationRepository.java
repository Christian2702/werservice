package de.drwhatson.server.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.drwhatson.server.api.domain.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long>{

}
