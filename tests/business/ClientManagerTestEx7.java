package business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Client;
import service.ClientManager;

/**
 * Test class created to ensure the functioning of key operations
 * about clients, carried out by the {@link ClientManager} class.
 */

public class ClientManagerTestEx7 {

	private ClientManager clientManager;
	private int clientId1 = 1;
	private int clientId2 = 2;

	@Before
	public void setUp() {

		// Setting up the scene

		// creating some clients
		Client client1 = new Client(1, "Mary Jane", 22, "mary@mail.com", true);
		Client client2 = new Client(2, "Joe Doe", 53, "jd@gmail.com", true);

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

	/*
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

}
