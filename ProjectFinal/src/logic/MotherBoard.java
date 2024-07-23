package logic;

import java.io.Serializable;
import java.util.ArrayList;

public class MotherBoard extends Component implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String model;
	private String socket;
	private String typeRAM;
	private ArrayList<String> hardDiskCon;
	
	public MotherBoard(String id, String brand, double price, int units, int serie, String model, String socket, String typeRAM, ArrayList<String> hardDiskCon) {
		super(id, brand, price, units, serie);
		this.model = model;
		this.socket = socket;
		this.typeRAM = typeRAM;
		this.hardDiskCon = hardDiskCon;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public String getTypeRAM() {
		return typeRAM;
	}

	public void setTypeRAM(String typeRAM) {
		this.typeRAM = typeRAM;
	}

	public ArrayList<String> getHardDiskCon() {
		return hardDiskCon;
	}

	public void setHardDiskCon(ArrayList<String> hardDiskCon) {
		this.hardDiskCon = hardDiskCon;
	}

}
