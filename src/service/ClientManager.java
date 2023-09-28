package service;

import java.util.List;

import exception.BussinessException;
import model.Client;

/**
 * Business class to carry out operations on the bank's clients.
 */

public class ClientManager {

	private List<Client> clients;

	public ClientManager(List<Client> clients) {
		this.clients = clients;
	}

	public List<Client> getClients() {
		return clients;
	}

	/**
	 * Search for a client based on their ID.
	 * 
	 * @param clientId id of the client to be searched
	 * @return the searched client or null if not found
	 */
	public Client searchClient(int clientId) {

		for (Client client : clients) {
			if (client.getId() == clientId)
				return client;
		}
		return null;
	}

	/**
	 * Adds a new client to the bank's clients list.
	 * 
	 * @param client new client to be added
	 */
	public void addClient(Client client) {
		clients.add(client);
	}

	/**
	 * Removes client from the bank's client list.
	 * 
	 * @param clientId ID of the client to be removed
	 * @return true if the client was removed. False otherwise.
	 */
	public boolean removeClient(int clientId) {
		boolean removed = false;

		for (int i = 0; i < clients.size(); i++) {
			Client client = clients.get(i);
			if (client.getId() == clientId) {
				clients.remove(i);
				removed = true;
				break;
			}
		}

		return removed;
	}

	/**
	* Informs if a given client is active or not.
	*
	* @param clientId ID of the client whose status will be checked
	* @return true if the client is active. False otherwise.
	*/
	public boolean isClientActive(int clientId) {
		boolean active = false;

		for (int i = 0; i < clients.size(); i++) {
			Client client = clients.get(i);
			if (client.getId() == clientId)
				if (client.isActive()) {
					active = true;
					break;
				}
		}

		return active;
	}

	/**
	* Cleans the client list; removes all of them.
	*/
	public void clean() {
		this.clients.clear();
	}

	/**
	* Validates if the client's age is within the allowed range (17 - 70).
	*
	* @param age the age of the potential new client
	* @throws BussinessException 
	*/
	public boolean checkAge(int age) throws BussinessException  {

		if (age < 17 || age > 70) 
		{
			throw new BussinessException("The client's age must be between 17 and 70 years old.");
		}
		
		return true;
	}

}
