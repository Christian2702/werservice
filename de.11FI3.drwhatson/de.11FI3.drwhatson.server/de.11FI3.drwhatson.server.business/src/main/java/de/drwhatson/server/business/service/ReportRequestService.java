package de.drwhatson.server.business.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import de.drwhatson.server.api.ReportRequest;
import de.drwhatson.server.api.domain.Report;

public class ReportRequestService {
	
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private ReportService reportService;
	
	@Transactional
	public void saveReportRequests(List<ReportRequest> reportRequests){
		for(ReportRequest reportRequest : reportRequests){
			saveReportRequest(reportRequest);
		}
	}
	
	@Transactional
	public void saveReportRequest(ReportRequest reportRequest){
		Report report = convertReportRequest(reportRequest);
		reportService.saveReport(report);
	}
	
	private Report convertReportRequest(ReportRequest reportRequest){
		return conversionService.convert(reportRequest, Report.class);
	}

}
