package business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import exception.BussinessException;
import model.Account;
import model.Client;
import service.AccountManager;
/**
 * Test class created to ensure the functioning of key operations
 * about accounts, carried out by the {@link AccountManager} class.
 */
public class AccountManagerTestEx4 {

	private AccountManager accountManager;
	
	/**
	 * Basic test of transferring an amount from one client's account to another,
	 * with both clients being active and there being sufficient balance for such
	 * transfer to occur successfully.	 
	 * @throws BussinessException 
	 */
	@Test
	public void testValueTransfer() throws BussinessException {

		// Setting up the scene
		
		// creating some clients
		Client client1 = new Client(1, "Mary Jane", 22, "mary@mail.com", true);
		Client client2 = new Client(2, "Joe Doe", 53, "jd@gmail.com", true);
		
		// creating some accounts
		int accountId1 = 1;
		int accountId2 = 2;
		Account account1 = new Account(accountId1, 200, true, client1);
		Account account2 = new Account(accountId2, 0, true, client2);
		
		// inserting the created clients into the bank's client list
		List<Account> accounts = new ArrayList<>();
		accounts.add(account1);
		accounts.add(account2);
		
		accountManager = new AccountManager(accounts);

		// Execution
		boolean success = accountManager.transferValue(accountId1, 100, accountId2);
		
		// Verifications
		assertTrue(success);
		assertThat(account2.getBalance(), is(100.0));
		assertThat(account1.getBalance(), is(100.0));
	}
	
	/**
	* Basic test of attempting to transfer a value from one client's account to another
	* when there is not enough balance.
	 * @throws BussinessException 
	*/
	@Test
	public void testValueTransferInsufficientFunds() throws BussinessException {

		// Setting up the scene
		
		// creating some clients
		Client client1 = new Client(1, "Mary Jane", 22, "mary@mail.com", true);
		Client client2 = new Client(2, "Joe Doe", 53, "jd@gmail.com", true);		
		
		// creating some accounts
		int accountId1 = 1;
		int accountId2 = 2;
		Account account1 = new Account(accountId1, 100, true, client1);
		Account account2 = new Account(accountId2, 0, true, client2);
		
		// inserting the created accounts into the bank's account lists
		List<Account> accounts = new ArrayList<>();
		accounts.add(account1);
		accounts.add(account2);
		
		accountManager = new AccountManager(accounts);

		// Execution
		boolean success = accountManager.transferValue(accountId1, 200, accountId2);
		
		// Verifications
		assertTrue(success);
		assertThat(account1.getBalance(), is(-100.0));
		assertThat(account2.getBalance(), is(200.0));
	}

}
