package logic;

import java.util.ArrayList;

public class Combo {
	private String id;
	private int discount;
	private ArrayList<Component> comboComp;
	
	public Combo(String id, int discount, ArrayList<Component> comboComp) {
		super();
		this.id = id;
		this.discount = discount;
		this.comboComp = comboComp;
	}
	
	public String getId() {
		return id;
	}
	
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public ArrayList<Component> getComboComp() {
		return comboComp;
	}
	public void setComboComp(ArrayList<Component> comboComp) {
		this.comboComp = comboComp;
	}
	
}
