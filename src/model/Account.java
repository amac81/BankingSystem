package model;

/* Class {@link CurrentAccount} 
F * that represents a real current account and that 
 * can be associated with a client. */

public class Account {

	private int id;
	private Client client;
	private double balance;
	private boolean active;

	public Account(int id, double balance, boolean ativa, Client client) {
		this.id = id;		
		this.balance = balance;
		this.active = ativa;
		this.client = client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "CurrentAccount [id=" + id + ", client=" + client + ", balance=" + balance + ", active=" + active + "]";
	}

}
