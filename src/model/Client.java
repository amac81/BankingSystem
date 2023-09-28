package model;

/**
 * Class {@link Client} representing a real client of the bank.
 */
public class Client {

	private int id;	
	private String name;
	private int age;
	private String email;
	private boolean active;
	
	public Client(int id, String name, int age, String email, boolean active) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", active=" + active + "]";
	}

}


