package logic;

import java.util.ArrayList;

public class Administration {
	private ArrayList<Component> theComponents;
	private ArrayList<Client> theClients;
	private ArrayList<Bill> theBills;
	private static Administration myAdmin = null;
	public static int idClient = 1;
	public static int idBill = 1;
	public static int idComp = 1;
	
	public Administration() {
		super();
		theComponents = new ArrayList<Component>();
		theClients = new ArrayList<Client>();
		theBills = new ArrayList<Bill>();
	}
	
	public static Administration getInstance() {
		if(myAdmin == null) {
			myAdmin = new Administration();
		} return myAdmin;
	}

	public ArrayList<Component> getTheComponents() {
		return theComponents;
	}

	public ArrayList<Client> getTheClients() {
		return theClients;
	}

	public ArrayList<Bill> getTheBills() {
		return theBills;
	}
	
	public void addComponent(Component comp) {
		theComponents.add(comp);
		idComp++;
	}
	
	public void addClient(Client cli) {
		theClients.add(cli);
		idClient++;
	}
	
	public void addBill(Bill bill) {
		theBills.add(bill);
		idBill++;
	}
	
	public Client searchClientById(String id) {
		return null;
	}
	
	public Component searchComponentById(String id) {
		return null;
	}
	
	public Bill searchBillById(String id) {
		return null;
	}
	
	public void deleteClient(String codCli) {
		Client aux = searchClientById(codCli);
		if(aux != null)
			theClients.remove(aux);
	}
	
	public void deleteComponent(String codComp) {
		Component aux = searchComponentById(codComp);
		if(aux != null)
			theComponents.remove(aux);
	}
	
	public void deleteBill(String codBill) {
		Bill aux = searchBillById(codBill);
		if(aux != null)
			theBills.remove(aux);
	}
}
