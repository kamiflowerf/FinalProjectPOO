package logic;

import java.io.Serializable;

public abstract class Component implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String id;
	protected String brand;
	protected double price;
	protected int units;
	protected int serie;
	
	public Component(String id, String brand, double price, int units, int serie) {
		super();
		this.id = id;
		this.brand = brand;
		this.price = price;
		this.units = units;
		this.serie = serie;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public String getId() {
		return id;
	}
}
