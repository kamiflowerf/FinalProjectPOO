package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import logic.Administration;
import logic.Client;

public class ClientList extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane = new JPanel();
	private static JScrollPane scrollPaneTable;
	private static JTable ClientTable;
	static ArrayList<Client> clients; //lista de las personas que voy a cargar a la tabla
	static TableModel model; // modelo creado de la clase del modelo de la tabla
	private static int rows;
	private static int columns;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ClientList dialog = new ClientList();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ClientList() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800,551);
		
		startComponents();
		setLocationRelativeTo(null);
		buildTable();
	}
	
	/*
	 * Metodo que construye la tabla, primero se crean las columnas y luego se
	 * asigna la info correspondiente a cada una.
	 */

	public static int getRows() {
		return rows;
	}

	public static void setRows(int rows) {
		ClientList.rows = rows;
	}

	public static int getColumns() {
		return columns;
	}

	public static void setColumns(int columns) {
		ClientList.columns = columns;
	}

	private static void buildTable() {
		
		clients = Administration.getInstance().getTheClients();
		
		ArrayList<String> headers = new ArrayList <>();
		headers.add("Código");
		headers.add("Nombre");
		headers.add("Cédula");
		headers.add("E-mail");
		headers.add("Dirección");
		headers.add("Teléfono");
		
		
		// Se asignan las columnas al arreglo para enviarse cuando se vaya a contruir la tabla
		String Titles[] = new String[headers.size()];
		
		for(int i = 0; i < Titles.length; i++)
		{
			Titles[i] = headers.get(i);
		}
		
		//Se obtienen los datos de la lista y se guardan en la matriz y luego se construye la tabla.
		
		Object [][] data = getData(headers);	
		putTogetherEverything(Titles,data);
	}

	private static void putTogetherEverything(String[] Titles, Object[][] data) {
		
		/*
		 * En esta funcion se toma toda la informacion y se organiza en la tabla
		 * Asignando tamaño a las celdas y columnas segun el texto contenido dentro. 
		 * 
		 */
		model = new TableModel(Titles, data);
		
		ClientTable.setModel(model);
		
		setRows(ClientTable.getRowCount());
		setColumns(ClientTable.getColumnCount());
		
		//Se asigna el tipo de dato a cada celda
		ClientTable.getColumnModel().getColumn(0).setCellRenderer(new CellsConfig ("number"));
		ClientTable.getColumnModel().getColumn(2).setCellRenderer(new CellsConfig ("number"));
		ClientTable.getColumnModel().getColumn(5).setCellRenderer(new CellsConfig ("number"));
		
		//Se recorre y asigna el resto e celdas que serian las que almacenanr datos de tipo texto
		for(int i = 0; i < Titles.length-3; i++) // se resta 3 porque ya se asigno el tipo de formato numerico a 3 filas
		{
			ClientTable.getColumnModel().getColumn(i).setCellRenderer(new CellsConfig("text"));
		}
		
		ClientTable.getTableHeader().setReorderingAllowed(false);
		ClientTable.setRowHeight(25); // alto de las celdas
		ClientTable.setGridColor(new java.awt.Color(0,0,0));
		
		//Se define el ancho para cada columna
		
		ClientTable.getColumnModel().getColumn(0).setPreferredWidth(200);
		ClientTable.getColumnModel().getColumn(1).setPreferredWidth(380);
		ClientTable.getColumnModel().getColumn(2).setPreferredWidth(350);
		ClientTable.getColumnModel().getColumn(3).setPreferredWidth(400);
		ClientTable.getColumnModel().getColumn(4).setPreferredWidth(350);
		ClientTable.getColumnModel().getColumn(5).setPreferredWidth(200);
		
		JTableHeader TableHeader = ClientTable.getTableHeader();
		TableHeader.setDefaultRenderer(new TableTitles());
		ClientTable.setTableHeader(TableHeader);
		
		//Se le asigna la tabla al  scrollPane
		
		scrollPaneTable.setViewportView(ClientTable);
		
	}

	private static Object[][] getData(ArrayList<String> titles) {
		
		/*Se crea la matriz donde las filas son dinamicas y 
		 * las columnas estaticas siguiendo el regimen de los 
		 * datos que se van a mostrar
		 * 
		 */
		
		String info[][] = new String[clients.size()][titles.size()];
		
		for(int i = 0; i < info.length; i++)
		{
			
			info[i][0] = clients.get(i).getId();
			info[i][1] = clients.get(i).getName();
			info[i][2] = clients.get(i).getNi();
			info[i][3] = clients.get(i).getEmail();
			info[i][4] = clients.get(i).getAddress();
			info[i][5] = clients.get(i).getPhone();
				
		}
		return info;
	}

	private void startComponents() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0,0));
		
		JLabel lbl_clientTable = new JLabel("Listado Clientes");
		lbl_clientTable.setFont(new Font("Centaur",Font.PLAIN,30));
		contentPane.add(lbl_clientTable, BorderLayout.NORTH);
		
		scrollPaneTable = new JScrollPane();
		contentPane.add(scrollPaneTable);
		
		ClientTable = new JTable();
		ClientTable.setBackground(Color.white);
		ClientTable.setBorder(new BevelBorder(BevelBorder.RAISED,null,null,null,null));
		ClientTable.addMouseListener(this);
		ClientTable.setOpaque(false);
		scrollPaneTable.setViewportView(ClientTable);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int row = ClientTable.rowAtPoint(e.getPoint());
		int column = ClientTable.columnAtPoint(e.getPoint());
		
		// validar que la seleccion se realizo encima del rango 
		if(row >= 0 && column >= 0 )
		{
			Client selCli = clients.get(row);
			
			/*String info = "INFO CLIENTE\n";
            info += "Código: " + selCli.getId() + "\n";
            info += "Nombre: " + selCli.getName() + "\n";
            info += "Cédula: " + selCli.getNi() + "\n";
            info += "E-mail: " + selCli.getEmail() + "\n";
            info += "Dirección: " + selCli.getAddress() + "\n";
            info += "Teléfono: " + selCli.getPhone();*/
            
            if(ClientTable != null)
            {
            	ClientRegistry updateClient = new ClientRegistry(selCli);
            	updateClient.setModal(true);
            	updateClient.setVisible(true);
            }
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public static void updateTable() {
		buildTable();
		
	}

}