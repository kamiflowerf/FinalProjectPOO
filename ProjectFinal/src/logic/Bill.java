package logic;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Bill implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private ArrayList<Component> components;
	private Client cliente;
	private double total;
	private Date sold;
	
	public Bill(ArrayList<Component> components, Client cliente, double total, Date sold) {
		super();
		this.id = IdGenerator.generateId();
		this.components = components;
		this.cliente = cliente;
		this.total = total;
		this.sold = sold;
	}

	public ArrayList<Component> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<Component> components) {
		this.components = components;
	}

	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getSold() {
		return sold;
	}

	public void setSold(Date sold) {
		this.sold = sold;
	}

	public String getId() {
		return id;
	}
	
	
}
