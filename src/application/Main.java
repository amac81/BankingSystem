package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Client;
import model.Account;
import service.AccountManager;
import service.ClientManager;

public class Main {

	static ClientManager clientManager;
	static AccountManager accountManager;

	public static void main(String[] args) {

		systemInit(); // creating some fictitious accounts and clients

		try (Scanner sc = new Scanner(System.in)) {
			boolean keepHere = true;

			while (keepHere) {

				printMenu();

				int option = sc.nextInt();

				switch (option) {
				// Search a client
				case 1: {
					System.out.print("Enter the client ID: ");
					int clientId = sc.nextInt();
					Client client = clientManager.searchClient(clientId);

					if (client != null) {
						System.out.println(client.toString());
					} else {
						System.out.println("Client not found!");
					}

					System.out.println("\n");
					break;
				}

				// Consult a current account
				case 2: {
					System.out.print("Enter account ID: ");
					int accountId = sc.nextInt();
					Account account = accountManager.searchAccount(accountId);

					if (account != null)
						System.out.println(account.toString());
					else
						System.out.println("Account not found!");

					System.out.println("\n");
					break;
				}

				// Activate a client
				case 3: {

					System.out.print("Enter client ID: ");
					int idClient = sc.nextInt();
					Client client = clientManager.searchClient(idClient);

					if (client != null) {
						client.setActive(true);
						System.out.println("Client activated successfully!");
					} else
						System.out.println("Client not found!");

					System.out.println("\n");
					break;
				}

				// Deactivate a client
				case 4: {
					System.out.print("Enter client ID: ");
					int idClient = sc.nextInt();
					Client client = clientManager.searchClient(idClient);

					if (client != null) {
						client.setActive(false);
						System.out.println("Client successfully deactivated!");
					} else {
						System.out.println("Client not found!");

						System.out.println("\n");
						break;
					}
				}
				// exit
				case 5: {
					keepHere = false;
					System.out.println("################# System Closed #################");
					break;
				}
				default:								
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Print menu of options for our banking system
	 */
	private static void printMenu() {
		System.out.println("What do you want to do? \n");
		System.out.println("1) Query by a client");
		System.out.println("2) Check for a current account");
		System.out.println("3) Activate a client");
		System.out.println("4) Deactivate a client");
		System.out.println("5) Exit");
		System.out.println();
	}

	private static void systemInit() 
	{
		List<Client> clients = new ArrayList<>();
		List<Account> accounts = new ArrayList<>();
	
		Client client1 = new Client(1, "Mary Jane", 22, "mary@mail.com", true);
		Client client2 = new Client(2, "Joe Doe", 53, "jd@gmail.com", true);

		
		Account account1 = new Account(1, 0, true, client1);
		Account account2 = new Account(2, 0, true, client2);

		clients.add(client1);
		clients.add(client2);
	
		accounts.add(account1);
		accounts.add(account2);


		clientManager = new ClientManager(clients);
		accountManager = new AccountManager(accounts);

	}

}
