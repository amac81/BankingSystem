package business;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.Client;
import service.ClientManager;

/**
 * Test class created to ensure the functioning of key operations
 * about clients, carried out by the {@link ClientManager} class.
 */
public class ClientManagerTestEx5 {

	private ClientManager clientManager;

	
	/**
	* Basic test of searching for a client based on their ID.
	*/
	
	@Test
	public void testSearchClient() {

		// Setting up the scene
		
		int clientId1 = 1;
		int clientId2 = 2;
	
		// creating some clients
		Client client1 = new Client(clientId1, "Mary Jane", 22, "mary@mail.com", true);
		Client client2 = new Client(clientId2, "Joe Doe", 53, "jd@gmail.com", true);

		
		// inserting the created clients into the bank's client list
		List<Client> clients = new ArrayList<>();
		clients.add(client1);
		clients.add(client2);
		
		clientManager = new ClientManager(clients);

		// Execution
		Client client = clientManager.searchClient(clientId1);
		
		// Verification
		assertThat(client.getId(), is(clientId1));
		
	}
	
	/*
	* Basic test of removing a client from its ID.	
	*/
	@Test
	public void testRemoveClient() {

		// Setting up the scene
		
		// creating some clients
		int clientId1 = 1;
		int clientId2 = 2;
		
		Client client1 = new Client(clientId1, "Mary Jane", 22, "mary@mail.com", true);
		Client client2 = new Client(clientId2, "Joe Doe", 53, "jd@gmail.com", true);
		
		// inserting the created clients into the bank's client list
		List<Client> clients = new ArrayList<>();
		clients.add(client1);
		clients.add(client2);
		
		clientManager = new ClientManager(clients);
		
		// Execution
		boolean removedClient = clientManager.removeClient(clientId2);
		
		// Verification
		assertThat(removedClient, is(true));
		assertThat(clientManager.getClients().size(), is(1));
		assertNull(clientManager.searchClient(clientId2));
		
	}
	
}
