package logic;

public class Person {
	protected String id;
	protected String ni;
	protected String name;
	protected String phone;
	protected String address;
	protected String email;
	
	public Person(String ni, String name, String phone, String address, String email) {
		super();
		this.id = IdGenerator.generateId();
		this.ni = ni;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}

	public String getNi() {
		return ni;
	}

	public void setNi(String ni) {
		this.ni = ni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}
	
	
}
