package business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import exception.BussinessException;
import model.Account;
import model.Client;
import service.AccountManager;

public class AccountManagerTestEx1 {

	private AccountManager accountManager;
	
	@Test
	public void testValueTransfer() throws BussinessException {

		/* Setting up the scene */

		// creating some clients
		Client client1 = new Client(1, "Mary Jane", 22, "mary@mail.com", true);
		Client client2 = new Client(2, "Joe Doe", 53, "jd@gmail.com", true);

		
		// creating some accounts
		Account account1 = new Account(1, 200, true, client1);
		Account account2 = new Account(2, 0, true, client2);
		
		// inserting the created accounts into the bank's account lists
		List<Account> accounts = new ArrayList<>();
		accounts.add(account1);
		accounts.add(account2);
		
		accountManager = new AccountManager(accounts);

		// Execution 
		accountManager.transferValue(1, 100, 2);
		
		// Verifications 
		assertThat(account2.getBalance(), is(100.0));
		assertThat(account1.getBalance(), is(100.0));
	}

}
