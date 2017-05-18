package de.drwhatson.server.business.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.drwhatson.server.api.domain.Report;
import de.drwhatson.server.dao.repositories.ReportRepository;

public class ReportService {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ReportService.class);
	@Inject
	private ReportRepository reportRepository;
	
	public Report saveReport(Report report){
		Report savedReport = reportRepository.save(report);
		LOGGER.debug("saved report=[{}]", report);
		return savedReport;
	}

}
