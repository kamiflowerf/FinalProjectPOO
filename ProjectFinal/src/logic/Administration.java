package logic;

import java.util.ArrayList;

public class Administration {
	private ArrayList<Component> theComponents;
	private ArrayList<Person> thePeople;
	private ArrayList<Bill> theBills;
	private ArrayList<Combo> theCombos;
	private static Administration myAdmin = null;
	public static int idClient = 1;
	public static int idSupplier = 1;
	public static int idCombo = 1;
	public static int idBill = 1;
	public static int idComp = 1;
	
	public Administration() {
		super();
		theComponents = new ArrayList<Component>();
		thePeople = new ArrayList<Person>();
		theBills = new ArrayList<Bill>();
		theCombos = new ArrayList<Combo>();
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
		ArrayList<Client> theClients = new ArrayList<Client>();
		
		for(Person p : thePeople) {
			if(p instanceof Client) {
				theClients.add((Client)p);
			}
		}
		return theClients;
	}
	
	public ArrayList<Supplier> getTheSuppliers() {
		ArrayList<Supplier> theSuppliers = new ArrayList<Supplier>();
		
		for(Person p : thePeople) {
			if(p instanceof Supplier) {
				theSuppliers.add((Supplier)p);
			}
		}
		return theSuppliers;
	}

	public ArrayList<Bill> getTheBills() {
		return theBills;
	}
	
	public ArrayList<Combo> getTheCombos(){
		return theCombos;
	}
	
	public void addComponent(Component comp) {
		theComponents.add(comp);
		idComp++;
	}
	
	public void addPerson(Person p) {
		thePeople.add(p);
		if(p instanceof Client)
			idClient++;
		else
			idSupplier++;
	}
	
	public void addBill(Bill bill) {
		theBills.add(bill);
		idBill++;
	}
	
	public void addCombo(Combo comb) {
		theCombos.add(comb);
		idCombo++;
	}
	
	public Client searchClientById(String id) {
		return null;
	}
	
	public Supplier searchSupplierById(String id) {
		return null;
	}
	
	public Component searchComponentById(String id) {
		return null;
	}
	
	public Bill searchBillById(String id) {
		return null;
	}
	
	public Combo searchComboById(String codComb) {
		return null;
	}
	
	public void deleteClient(String codCli) {
		Client aux = searchClientById(codCli);
		if(aux != null)
			thePeople.remove(aux);
	}
	
	public void deleteSupplier(String codSup) {
		Supplier aux = searchSupplierById(codSup);
		if(aux != null)
			thePeople.remove(aux);
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
	
	public void deleteCombo(String codComb) {
		Combo aux = searchComboById(codComb);
		if(aux != null)
			theCombos.add(aux);
	}
	
}
