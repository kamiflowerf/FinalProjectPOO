package logic;

import java.io.Serializable;
import java.util.ArrayList;

public class Supplier extends Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int deliveryTime;
	private ArrayList<Component> myComponents;
	
	public Supplier(String ni, String name, String phone, String address, String email, String id,int deliveryTime,
			ArrayList<Component> myComponents) {
		super(ni, name, phone, address, email, id);
		this.deliveryTime = deliveryTime;
		this.myComponents = myComponents;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public ArrayList<Component> getMyComponents() {
		return myComponents;
	}

	public void setMyComponents(ArrayList<Component> myComponents) {
		this.myComponents = myComponents;
	}
	
	
}
