package logic;

public class RAM extends Component {

	private int capacity;
	private String type;
	
	public RAM(String brand, double price, int units, int serie, int capacity, String type) {
		super(brand, price, units, serie);
		this.capacity = capacity;
		this.type = type;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
