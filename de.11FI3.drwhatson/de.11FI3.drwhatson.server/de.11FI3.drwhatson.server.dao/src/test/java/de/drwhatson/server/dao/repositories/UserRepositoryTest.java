package de.drwhatson.server.dao.repositories;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.drwhatson.server.api.domain.User;
import de.drwhatson.server.dao.config.TestDatabaseConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestDatabaseConfig.class})
public class UserRepositoryTest {
	
	@Inject
	private UserRepository userRepository;
	
	@Test
	public void testSave(){
		User userToSave = new User();
		userToSave.setUsername("test");
		
		User savedUser = userRepository.save(userToSave);
		
		Assert.assertNotNull("id shouldn't be null", savedUser.getId());
		Assert.assertEquals("name dousent match",  "test", savedUser.getUsername());
	}

}
