package de.drwhatson.server.dao.repositories;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.drwhatson.server.api.domain.Admin;
import de.drwhatson.server.dao.config.TestDatabaseConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestDatabaseConfig.class})
public class AdminRepositoryTest {

	@Inject
	private AdminRepository adminRepository;
	
	@Test
	public void testSave(){
		Admin adminToSave = new Admin();
		adminToSave.setUserName("testUsername");
		adminToSave.setPassword("secret");
		
		Admin savedUser = adminRepository.save(adminToSave);
		
		Assert.assertNotNull("id shouldn't be null", savedUser.getId());
		Assert.assertEquals("name dousent match",  "testUsername", savedUser.getUserName());
		Assert.assertEquals("password dousent match",  "secret", savedUser.getPassword());
	}
}
