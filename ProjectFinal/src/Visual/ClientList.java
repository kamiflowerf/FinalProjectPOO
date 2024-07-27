package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JPanel bottonPanel;
	private JButton btn_cancel;
	private JButton btn_addNew;
	private JButton btn_delete;
	private JButton btn_update;
	private JButton btn_select;
	private String idClient = "";
	public onSelectedClient clientInterface;
	
	public interface onSelectedClient
	{
		void getSelectedClient(String id);
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ClientList dialog = new ClientList(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ClientList(onSelectedClient clientInterface) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientList.class.getResource("/Images/nueva-cuenta (2).png")));
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
			
		//Se recorre y asigna a la celdas que serian las que almacenanar datos de tipo texto
		for(int i = 0; i < Titles.length; i++) 
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
		lbl_clientTable.setFont(new Font("Verdana", Font.BOLD, 30));
		contentPane.add(lbl_clientTable, BorderLayout.NORTH);
		
		scrollPaneTable = new JScrollPane();
		contentPane.add(scrollPaneTable);
		
		ClientTable = new JTable();
		ClientTable.setFont(new Font("Verdana", Font.PLAIN, 12));
		ClientTable.setBackground(Color.white);
		ClientTable.setBorder(new BevelBorder(BevelBorder.RAISED,null,null,null,null));
		ClientTable.addMouseListener(this);
		ClientTable.setOpaque(false);
		scrollPaneTable.setViewportView(ClientTable);
		
		bottonPanel = new JPanel();
		contentPane.add(bottonPanel, BorderLayout.SOUTH);
		
		btn_select = new JButton("Seleccionar");
		btn_select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(idClient != "") {
					clientInterface.getSelectedClient(idClient);
					dispose();
				}
				
			}
		});
		btn_select.setEnabled(false);
		btn_select.setPreferredSize(new Dimension(85, 30));
		btn_select.setFont(new Font("Verdana", Font.BOLD, 12));
		btn_select.setBorder(new RoundedBorder(Color.BLACK,1,25));
		bottonPanel.add(btn_select);
		
		btn_update = new JButton("Actualizar");
		btn_update.setEnabled(false);
		btn_update.setPreferredSize(new Dimension(85, 30));
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if(idClient != "")
			{
				Client aux = Administration.getInstance().searchClientById(idClient);
				
				if(aux != null)
				{
					ClientRegistry updateClient = new ClientRegistry(aux);
	            	updateClient.setModal(true);
	            	updateClient.setVisible(true);
				}
			}
		}
		});
		btn_update.setFont(new Font("Verdana", Font.BOLD, 12));
		btn_update.setBorder(new RoundedBorder(Color.BLACK,1,25));
		bottonPanel.add(btn_update);
		
		btn_delete = new JButton("Eliminar");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(idClient != "")
				{
					int option = JOptionPane.showConfirmDialog(null, "Seguro desea eliminar el cliente con código: "+idClient, "Confirmación", JOptionPane.WARNING_MESSAGE);
					
					if(option == JOptionPane.YES_OPTION)
					{
						Administration.getInstance().deleteClient(idClient);
						btn_delete.setEnabled(false);
						updateTable();
					}
				}
			}
		});
		btn_delete.setEnabled(false);
		btn_delete.setPreferredSize(new Dimension(85, 30));
		btn_delete.setFont(new Font("Verdana", Font.BOLD, 12));
		btn_delete.setBorder(new RoundedBorder(Color.BLACK,1,25));
		bottonPanel.add(btn_delete);
		
		btn_addNew = new JButton("Agregar");
		btn_addNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClientRegistry newClient = new ClientRegistry(null);
				newClient.setModal(true);
				newClient.setVisible(true);
				updateTable();
			}
		});
		btn_addNew.setPreferredSize(new Dimension(85, 30));
		btn_addNew.setFont(new Font("Verdana", Font.BOLD, 12));
		btn_addNew.setBorder(new RoundedBorder(Color.BLACK,1,25));
		bottonPanel.add(btn_addNew);
		
		btn_cancel = new JButton("Cancelar");
		btn_cancel.setPreferredSize(new Dimension(85, 30));
		btn_cancel.setFont(new Font("Verdana", Font.BOLD, 12));
		btn_cancel.setBorder(new RoundedBorder(Color.BLACK,1,25));
		btn_cancel.setSize(50, 50);
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		bottonPanel.add(btn_cancel);
		
		updateTable();
		
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

	@Override
	public void mouseClicked(MouseEvent arg0) {	
		
		int i = ClientTable.getSelectedRow();
		
		if( i >= 0)
		{
			idClient = new String(ClientTable.getValueAt(i, 0).toString());
			btn_addNew.setEnabled(false);
			
			if(clientInterface == null)
			{
				btn_delete.setEnabled(true);
				btn_update.setEnabled(true);
			}
			else
			{
				btn_select.setEnabled(true);
			}
			
		}
		
	}

}