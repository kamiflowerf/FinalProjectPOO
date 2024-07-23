package logic;

import java.io.Serializable;
import java.util.ArrayList;

public class Client extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Bill> myBills;

	

	public Client(String ni, String name, String phone, String address, String email, String id) {
		super(ni, name, phone, address, email, id);
		
		this.myBills = new ArrayList<Bill>();
	}

	public ArrayList<Bill> getMyBills() {
		return myBills;
	}

	public void addMyBills(Bill theBill) {
		this.myBills.add(theBill);
	}
	
}
