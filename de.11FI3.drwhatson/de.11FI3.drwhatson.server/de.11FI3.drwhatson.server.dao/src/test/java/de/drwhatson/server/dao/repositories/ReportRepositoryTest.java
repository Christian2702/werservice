package de.drwhatson.server.dao.repositories;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.drwhatson.server.api.domain.Application;
import de.drwhatson.server.api.domain.Client;
import de.drwhatson.server.api.domain.Report;
import de.drwhatson.server.api.domain.User;
import de.drwhatson.server.dao.config.TestDatabaseConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestDatabaseConfig.class })
public class ReportRepositoryTest {
	
	@Inject
	private ReportRepository reportRepository;

	@Test
	public void testSave() {
		Report report = createTestReport();

		Report savedReport = reportRepository.save(report);

		Assert.assertNotNull("id shouldn't be null", savedReport.getId());
		Assert.assertNotNull("application shouldn't be null", savedReport.getApplication());
		Assert.assertNotNull("user shouldn't be null", savedReport.getUser());
		Assert.assertNotNull("client shouldn't be null", savedReport.getClient());
		Assert.assertNotNull("application id shouldn't be null", savedReport.getApplication().getId());
		Assert.assertNotNull("user id shouldn't be null", savedReport.getUser().getId());
		Assert.assertNotNull("client id shouldn't be null", savedReport.getClient().getId());
	}
	
	private Report createTestReport(){
		Application application = new Application();
		application.setName("Testapp");
		
		Client client = new Client();
		client.setName("testclient");
		client.setMacAddress("AB:4A:43:67:C3");
		
		User user = new User();
		user.setUsername("test");
		
		Report report = new Report();
		report.setApplication(application);
		report.setClient(client);
		report.setUser(user);
		
		
		return report;
		
	}

}
