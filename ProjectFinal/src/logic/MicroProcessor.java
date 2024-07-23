package logic;

import java.io.Serializable;

public class MicroProcessor extends Component implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String model;
	private String socket;
	private float processingSpeed;
	
	public MicroProcessor(String id, String brand, double price, int units, int serie, String model, String socket, float processingSpeed) {
		super(id, brand, price, units, serie);
		this.model = model;
		this.socket = socket;
		this.processingSpeed = processingSpeed;
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

	public float getProcessingSpeed() {
		return processingSpeed;
	}

	public void setProcessingSpeed(float processingSpeed) {
		this.processingSpeed = processingSpeed;
	}

	
}
