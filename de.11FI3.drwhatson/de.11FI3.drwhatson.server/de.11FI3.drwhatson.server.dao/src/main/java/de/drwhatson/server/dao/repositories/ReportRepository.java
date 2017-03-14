package de.drwhatson.server.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.drwhatson.server.api.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {

}
