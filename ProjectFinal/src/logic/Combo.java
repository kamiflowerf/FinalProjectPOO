package logic;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Combo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private ImageIcon icon;
	private int discount;
	private ArrayList<Component> comboComp;
	
	public Combo(String id, String name, int discount, ArrayList<Component> comboComp) {
		super();
		this.id = id;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
}
