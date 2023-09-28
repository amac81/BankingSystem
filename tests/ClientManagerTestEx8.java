package business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exception.BussinessException;
import model.Client;
import service.ClientManager;
/**
 * Test class created to ensure the functioning of key operations
 * about clients, carried out by the {@link ClientManager} class. 
 */

public class ClientManagerTestEx8 {

	private ClientManager clientManager;
	private int clientId1 = 1;
	private	int clientId2 = 2;
	
	@Before
	public void setUp() {
	
		// Setting up the scene
		
		// creating some clients
		Client client1 = new Client(clientId1, "Mary Jane", 22, "mary@mail.com", true);
		Client client2 = new Client(clientId2, "Joe Doe", 53, "jd@gmail.com", true);
		
		// inserting the created clients into the bank's client list
		List<Client> clients = new ArrayList<>();
		clients.add(client1);
		clients.add(client2);
		
		clientManager = new ClientManager(clients);
	}

	@After
	public void tearDown() {
		clientManager.clean();
	}
	
	/**
	* Basic test of searching for a client based on their ID.
	*/
	
	@Test
	public void testSearchClient() {

		// Execution
		Client client = clientManager.searchClient(clientId1);
		
		// Verifications
		assertThat(client.getId(), is(clientId1));
		
	}
	
	/*
	* Basic test of searching for a client that does not exist.
	*/
	@Test
	public void testSearchClientInexistente() {

		// Execution
		Client client = clientManager.searchClient(1001);
		
		// Verifications
		assertNull(client);
		
	}
	
	/*
	* Basic test of removing a client from its ID.
	*/
	@Test
	public void testRemoveClient() {
		
		// Execution
		boolean removedClient = clientManager.removeClient(clientId2);
		
		// Verifications
		assertThat(removedClient, is(true));
		assertThat(clientManager.getClients().size(), is(1));
		assertNull(clientManager.searchClient(clientId2));
		
	}
	
	/*
	* Testing the attempt to remove a non-existent client.
	*/
	@Test
	public void testRemoveNonExistingClient() {
	
		// Execution
		boolean removedClient = clientManager.removeClient(1001);
		
		// Verifications
		assertThat(removedClient, is(false));
		assertThat(clientManager.getClients().size(), is(2));
		
	}
	
	/**
	* Validation of a client's age when it is within the permitted range.
	* @throws BussinessException
	*/
	@Test
	public void testClientAcceptableAge() throws BussinessException {

		// Setting up the scene
		Client client = new Client(2, "Joe Doe", 53, "jd@gmail.com", true);
		
		// Execution
		boolean validAge = clientManager.checkAge(client.getAge());
		
		// Verifications
		assertTrue(validAge);	
	}
	
	/**
	* Validation of a client's age when it is within the permitted range.
	* @throws BusinessException
	*/
	@Test
	public void testClientAcceptableAge02() throws BussinessException {

		// Setting up the scene
		Client client = new Client(1, "Joe Doe", 53, "jd@gmail.com", true);
		
		// Execution
		boolean validAge = clientManager.checkAge(client.getAge());
		
		// Verifications
		assertTrue(validAge);	
	}
	
	/**
	* Validation of a client's age when it is within the permitted range.
	* @throws BusinessException
	*/
	@Test
	public void testClientAcceptableAge03() throws BussinessException {

		// Setting up the scene
		Client client = new Client(1, "Joe Doe", 53, "jd@gmail.com", true);
		
		// Execution
		boolean validAge = clientManager.checkAge(client.getAge());
		
		// Verifications
		assertTrue(validAge);	
	}
	
	/**
	* Validation of a client's age when it is below the permitted range.
	* @throws BusinessException
	*/
	@Test
	public void testClientAcceptableAge04() throws BussinessException {

		// Setting up the scene
		Client client = new Client(1, "Antony Joseph", 16, "ag@gmail.com", true);

		// Execution
		try {
			clientManager.checkAge(client.getAge());
			fail();
		} catch (Exception e) {
			// Verifications
			assertThat(e.getMessage(), is(new BussinessException("The client's age must be between 17 and 70 years old.")));			
		}	
	}
	
	/**
	* Validation of a client's age when it is above the permitted range.
	* @throws BusinessException
	*/
	@Test
	public void testClientAcceptableAge05() throws BussinessException {
		
		// Setting up the scene
		Client client = new Client(1, "Mary Lopez", 71, "marylopez@gmail.com", true);

		// Execution
		try {
			clientManager.checkAge(client.getAge());
			fail();
		} catch (Exception e) {
			// Verifications
			assertThat(e.getMessage(), is(new BussinessException("The client's age must be between 17 and 70 years old.")));
		}	
	}
	
}

