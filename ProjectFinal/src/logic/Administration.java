package logic;

import java.util.ArrayList;
import java.util.Date;

public class Administration {
	private ArrayList<Component> theComponents;
	private ArrayList<Person> thePeople;
	private ArrayList<Bill> theBills;
	private ArrayList<Combo> theCombos;
	private static Administration myAdmin = null;
	
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
	}
	
	public void addPerson(Person p) {
		thePeople.add(p);
	}
	
	public void addBill(Bill bill) {
		theBills.add(bill);
	}
	
	public void addCombo(Combo comb) {
		theCombos.add(comb);
	}
	
	public Client searchClientById(String id) {
		
		ArrayList<Client> clients = getTheClients();
		for(Client aux: clients){
			if(aux.getId().equalsIgnoreCase(id)){
				return aux;
			}
		}
		return null;
	}
	
	public Component searchComponentById(String id) {
		
		for(Component aux: theComponents)
		{
			if(aux.getId().equalsIgnoreCase(id)){
				return aux;
			}
		}
		return null;
	}
	
	public int searchComponentGetIndex(String id){
		int component = -1;
		boolean found = false;
		int i = 0;
		
		while(!found && i < theComponents.size()){
			if(theComponents.get(i).getId().equalsIgnoreCase(id)) {
				component = i;
				found = true;
			}
			i++;
		}
		return component;
	}
	
	public Bill searchBillById(String id) {
		
		for(Bill aux: theBills)	{
			if(aux.getId().equalsIgnoreCase(id)){
				return aux;
			}
		}
		return null;
	}
	
	public Supplier searchSupplierById(String id) {
		
		ArrayList<Supplier> theSuppliers = getTheSuppliers();
		for(Supplier s : theSuppliers){
			if(s.getId().equalsIgnoreCase(id))	{
				return s;
			}
		}
		return null;
	}
	
	public int searchPeopleGetIndex(String id){
		int person = -1;
		boolean found = false;
		int i = 0;
		
		while(!found && i < thePeople.size()){
			if(thePeople.get(i).getId().equalsIgnoreCase(id)) {
				person = i;
				found = true;
			}
			i++;
		}
		return person;
	}
	
	public Combo searchComboById(String codComb) {
		
		for(Combo c : theCombos){
			if(c.getId().equalsIgnoreCase(codComb)){
				return c;
			}
		}
		return null;
	}
	
	public int searchComboGetIndex(String codComb){
		int combo = -1;
		boolean found = false;
		int i = 0;
		
		while(!found && i < theCombos.size()){
			if(theCombos.get(i).getId().equalsIgnoreCase(codComb)) {
				combo = i;
				found = true;
			}
			i++;
		}
		return combo;
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
	
	public void updateComponent(Component comp) {
		int index = searchComponentGetIndex(comp.getId());
		if(index != -1)
			theComponents.set(index, comp);
	}
	
	public void updatePerson(Person per) {
		int index = searchPeopleGetIndex(per.getId());
		if(index != -1) 
			thePeople.set(index, per);
	}
	
	public void updateCombo(Combo com) {
		int index = searchComboGetIndex(com.getId());
		if(index != -1) 
			theCombos.set(index, com);
	}
	
	public boolean makeSale(String idClient, Date saleDate, ArrayList<Component> componetsSale) {
		Client cliente = searchClientById(idClient);
		boolean allValid = false;
		for (Component component : componetsSale) {
			if(component.getUnits() > 0) {
				allValid = true;
			}
		}
		
		if(cliente != null && allValid) {
			return true;
		}else 
			return false;
	}

	public boolean inventoryRefill() {
		int threshold = 3;
		int countComponentRefill = 0;

		for (Component component : theComponents) {
			if (component.getUnits() < threshold) {
				countComponentRefill++;
				if (countComponentRefill >= threshold) 
					return true;	
			}
		}
		return false;
	}
	
}
