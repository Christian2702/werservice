package de.drwhatson.server.dao.repositories;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.drwhatson.server.api.domain.Application;
import de.drwhatson.server.dao.config.TestDatabaseConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestDatabaseConfig.class })
public class ApplicationRepositoryTest {

	@Inject
	private ApplicationRepository applicationRepository;

	@Test
	public void testSave() {
		Application application = new Application();
		application.setName("Testapp");

		Application savedApplication = applicationRepository.save(application);

		Assert.assertNotNull("id shouldn't be null", savedApplication.getId());
		Assert.assertEquals("name dosent match", "Testapp", savedApplication.getName());
	}
}
