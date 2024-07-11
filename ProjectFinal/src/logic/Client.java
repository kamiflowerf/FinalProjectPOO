package logic;

import java.util.ArrayList;

public class Client extends Person {
	private ArrayList<Bill> myBills;

	public Client(String id, String ni, String name, String phone, String address, String email,
			ArrayList<Bill> myBills) {
		super(id, ni, name, phone, address, email);
		this.myBills = new ArrayList<Bill>();
	}

	public ArrayList<Bill> getMyBills() {
		return myBills;
	}

	public void addMyBills(Bill theBill) {
		this.myBills.add(theBill);
	}
}
