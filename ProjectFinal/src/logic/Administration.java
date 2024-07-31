package logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import logic.*;

public class Administration implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Component> theComponents;
	private ArrayList<Person> thePeople;
	private ArrayList<Bill> theBills;
	private ArrayList<Combo> theCombos;
	private ArrayList<User> myUsers;
	private static Administration myAdmin = null;
	private static User loginUser;
	
	public Administration() {
		super();
		theComponents = new ArrayList<Component>();
		thePeople = new ArrayList<Person>();
		theBills = new ArrayList<Bill>();
		theCombos = new ArrayList<Combo>();
		myUsers = new ArrayList<User>();
	}
	
	public static Administration getInstance() {
		if(myAdmin == null) {
			myAdmin = new Administration();
		} return myAdmin;
	}

	public ArrayList<User> getMyUsers() {
		return myUsers;
	}

	public void setMyUsers(ArrayList<User> myUsers) {
		this.myUsers = myUsers;
	}
	
	
	public static Administration getAdministration() {
		return myAdmin;
	}

	public static void setAdministration(Administration admin) {
		Administration.myAdmin = admin;
	}

	public static User getLoginUser() {
		return loginUser;
	}

	public static void setLoginUser(User loginUser) {
		Administration.loginUser = loginUser;
	}

	public void regUser(User user) {
		myUsers.add(user);
		
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
			theCombos.remove(aux);
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
	
	public boolean makeSale(String idClient, Date saleDate, ArrayList<Component> componentsSale) {
	    // Buscar al cliente por ID
	    Client client = searchClientById(idClient);
	    
	    boolean allValid = true; 
	    double totalSale = 0.0;
	    
	    // Verificar que todos los componentes estén disponibles y calcular el total
	    for (Component component : componentsSale) {
	        Component storedComponent = searchComponentById(component.getId());
	        if (storedComponent == null || storedComponent.getUnits() < component.getUnits()) {
	            allValid = false;
	            break;
	        } else {
	            // Asumir que cada componente tiene un método getPrice() para obtener el precio
	            totalSale += storedComponent.getPrice() * component.getUnits();
	        }
	    }
	    
	    if (client != null && allValid) {
	        // Actualizar las unidades de los componentes en el inventario
	        for (Component component : componentsSale) {
	            Component storedComponent = searchComponentById(component.getId());
	            if (storedComponent != null) {
	                int newUnits = storedComponent.getUnits() - 1;
	                storedComponent.setUnits(newUnits);
	                updateComponent(storedComponent);
	            }
	        }
	        
	        // Crear una nueva factura y agregarla al array de facturas
	        Bill newBill = new Bill(componentsSale, client, totalSale, saleDate); 
	        addBill(newBill);
	        
	        return true;
	    } else {
	        return false;
	    }
	}



	public boolean inventoryRefill(ArrayList<Component> componentsToOrder) {
	    boolean allComponentsUpdated = true; // Asumimos que todo está bien inicialmente

	    for (Component orderComponent : componentsToOrder) {
	        boolean componentFound = false;

	        for (Component inventoryComponent : theComponents) {
	            if (inventoryComponent.getId().equals(orderComponent.getId())) {
	                componentFound = true; // Encontramos el componente en el inventario
	                int newUnits = inventoryComponent.getUnits() + orderComponent.getUnits();
	                inventoryComponent.setUnits(newUnits);
	                break; // No es necesario seguir buscando en el inventario
	            }
	        }

	        if (!componentFound) {
	            // Si no encontramos el componente en el inventario
	            allComponentsUpdated = false;
	            break; // No es necesario seguir con los demás componentes
	        }
	    }

	    return allComponentsUpdated; // Retornamos true solo si todos los componentes fueron actualizados
	}


	public boolean confirmLogin(String username, String pass) {
		boolean login = false;
		
		for(User user : myUsers) {
			
			if(user.getUsername().equals(username) && user.getPassword().equals(pass)) {
				loginUser = user;
				login = true;
			}
		}
		return login;
	}

	public User getConfirmedUser(String username, String pass) {
        if (confirmLogin(username, pass)) {
            return loginUser;
        }
        return null;
    }

	public int getHowManyHDs() {
		int hds = 0;
		
		for(Component c : theComponents)
		{
			if(c instanceof HardDisk)
			{
				hds++;
			}
		}
		return hds;
	}

	public int getHowManyMPs() {
		int mps = 0;
		
		for(Component c : theComponents)
		{
			if(c instanceof MicroProcessor)
			{
				mps++;
			}
		}
		return mps;
}

	public int getHowManyMBs() {
		int mbs = 0;
		
		for(Component c : theComponents)
		{
			if(c instanceof MotherBoard)
			{
				mbs++;
			}
		}
		return mbs;
	}

	public int getHowManyRAMs() {
		int rams = 0;
		
		for(Component c : theComponents)
		{
			if(c instanceof RAM)
			{
				rams++;
			}
		}
		return rams;

	}

	public double[] getMonthlyProfits() {
	    double[] monthlyProfits = new double[12]; 

	    for (Bill bill : theBills) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(bill.getSold());
	        int month = cal.get(Calendar.MONTH); 
	        monthlyProfits[month] += bill.getTotal();
	    }

	    return monthlyProfits;
	}
	
	public ArrayList<Component> getComponentsBySupplier(String supplierId) {
	    ArrayList<Supplier> suppliers = getTheSuppliers();
	    
	    for (Supplier supplier : suppliers) {
	        if (supplier.getId().equalsIgnoreCase(supplierId)) {
	            return supplier.getMyComponents();
	        }
	    }
	    
	    return new ArrayList<>();
	}

	
}
