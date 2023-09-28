package business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.Client;
import service.ClientManager;

public class ClientManagerTestEx2 {

	private ClientManager clientManager;

	@Test
	public void testSearchClient() {

		// creating some clients
		Client client1 = new Client(1, "Mary Jane", 22, "mary@mail.com", true);
		Client client2 = new Client(2, "Joe Doe", 53, "jd@gmail.com", true);
		
		// inserting the created clients into the bank's client list
		List<Client> clients = new ArrayList<>();
		clients.add(client1);
		clients.add(client2);
		
		clientManager = new ClientManager(clients);
		
		Client client = clientManager.searchClient(1);
		
		assertThat(client.getId(), is(1));
		
	}
	
	@Test
	public void testRemoveClient() {

		// creating some clients
		Client client1 = new Client(1, "Mary Jane", 22, "mary@mail.com", true);
		Client client2 = new Client(2, "Joe Doe", 53, "jd@gmail.com", true);
		
		// inserting the created clients into the bank's client list
		List<Client> clients = new ArrayList<>();
		clients.add(client1);
		clients.add(client2);
		
		clientManager = new ClientManager(clients);
		
		boolean removedClient = clientManager.removeClient(2);
		
		assertThat(removedClient, is(true));
		assertThat(clientManager.getClients().size(), is(1));
		assertNull(clientManager.searchClient(2));
		
	}

}
