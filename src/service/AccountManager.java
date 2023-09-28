package service;

import java.util.List;

import exception.BussinessException;
import model.Account;
/*
 * Business class to carry out operations on bank accounts.
 */

public class AccountManager {

	private List<Account> accounts;

	public AccountManager(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	/**
	 * Search for an account from your ID.
	 * 
	 * @param AccountID ID of the account to be searched
	 * @return the searched account or null if not found
	 */
	public Account searchAccount(int accountId) {

		for (Account account : accounts) {
			if (account.getId() == accountId)
				return account;
		}
		return null;
	}

	public void addAccount(Account newAccount) {
		accounts.add(newAccount);
	}

	/**
	 * Remove account from the bank's account list.
	 * 
	 * @param id Account ID of the account to be removed
	 * @return true if the account was removed. False otherwise.
	 **/
	public boolean removeAccount(int accountId) {

		boolean removed = false;

		for (int i = 0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			if (account.getId() == accountId) {
				accounts.remove(i);
				break;
			}
		}

		return removed;
	}

	/**
	 * Informs whether a given account is active or not.
	 *
	 * @param AccountID ID of the account whose status will be checked
	 * @return true if the account is active. False otherwise.
	 */
	public boolean isAccountActive(int accountId) {

		boolean active = false;

		for (int i = 0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			if (account.getId() == accountId)
				if (account.isActive()) {
					active = true;
					break;
				}
		}

		return active;
	}

	/**
	 * Transfers a certain amount from an Origin account to a Destination account.
	 * If there is not enough balance, the amount will not be transferred.
	 *
	 * @param originAccountId  account that will have the amount deducted
	 * @param value value to be transferred
	 * @param destinAccountId account that will have the value increased
	 * @return true, if the transfer was successful.
	 * @throws BussinessException
	 */
	public boolean transferValue(int originAccountId, double value, int destinAccountId) throws BussinessException {

		boolean success = false;

		Account originAccount = searchAccount(originAccountId);
		Account destinAccount = searchAccount(destinAccountId);

		if (originAccount.getBalance() >= value) {
			destinAccount.setBalance(destinAccount.getBalance() + value);
			originAccount.setBalance(originAccount.getBalance() - value);
			success = true;
		} else {
			throw new BussinessException("Insufficient funds in the origin account!");
		}

		return success;
	}

}
