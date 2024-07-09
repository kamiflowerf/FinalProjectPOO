package logic;

public class HardDisk extends Component {

	private String model;
	private int capacity;
	private String conectionType;
	public HardDisk(String id, String brand, double price, int units, int serie, String model, int capacity, String conectionType) {
		super(id, brand, price, units, serie);
		this.model = model;
		this.capacity = capacity;
		this.conectionType = conectionType;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getConectionType() {
		return conectionType;
	}
	public void setConectionType(String conectionType) {
		this.conectionType = conectionType;
	}

}
