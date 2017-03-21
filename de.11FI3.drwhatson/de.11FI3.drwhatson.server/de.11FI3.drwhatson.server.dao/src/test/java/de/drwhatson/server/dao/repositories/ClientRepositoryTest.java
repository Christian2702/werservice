package de.drwhatson.server.dao.repositories;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.drwhatson.server.api.domain.Client;
import de.drwhatson.server.dao.config.TestDatabaseConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestDatabaseConfig.class})
public class ClientRepositoryTest {

	@Inject
	private ClientRepository clientRepository;
	
	@Test
	public void testSave(){
		Client clientToSave = new Client();
		clientToSave.setName("testclient");
		clientToSave.setMacAddress("AB:4A:43:67:C3");
		
		Client savedClient = clientRepository.save(clientToSave);
		
		Assert.assertNotNull("id shouldn't be null", savedClient.getId());
		Assert.assertEquals("name dosent match",  "testclient", savedClient.getName());
		Assert.assertEquals("mac address dosent match", "AB:4A:43:67:C3", savedClient.getMacAddress());
	}
}
