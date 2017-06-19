package de.drwhatson.server.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import de.drwhatson.server.api.ReportRequest;
import de.drwhatson.server.business.service.ReportRequestService;

@RequestMapping("rest/report")
public class ReportRequestController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ReportRequestController.class);
	
	@Autowired
	private ReportRequestService reportRequestService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.ACCEPTED)
	public void post(@RequestBody List<ReportRequest> reportRequests){
		StopWatch st = new StopWatch();
		st.start();
		
		reportRequestService.saveReportRequests(reportRequests);
		
		st.stop();
		
		LOGGER.debug("Accepting ReportRequests took {} ms", st.getTotalTimeMillis());
		
	}
	
	
}
