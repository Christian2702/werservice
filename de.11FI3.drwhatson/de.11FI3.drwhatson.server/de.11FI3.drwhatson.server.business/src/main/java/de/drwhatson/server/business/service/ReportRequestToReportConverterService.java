package de.drwhatson.server.business.service;

import org.springframework.core.convert.converter.Converter;

import de.drwhatson.server.api.ReportRequest;
import de.drwhatson.server.api.domain.Report;

public class ReportRequestToReportConverterService implements Converter<ReportRequest, Report>{

	public Report convert(ReportRequest arg0) {
		
		return null;
	}

}
