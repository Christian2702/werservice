package de.drwhatson.server.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.drwhatson.server.api.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

}
