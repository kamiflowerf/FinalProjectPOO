package logic;

import java.io.Serializable;
import java.util.ArrayList;

public class Combo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private int discount;
	private ArrayList<Component> comboComp;
	
	public Combo(int discount, ArrayList<Component> comboComp) {
		super();
		this.id = IdGenerator.generateId();
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
