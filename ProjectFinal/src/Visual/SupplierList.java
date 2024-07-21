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
import logic.Supplier;

public class SupplierList extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane = new JPanel();
	private static JScrollPane scrollPaneTable;
	private static JTable SupplierTable;
	static ArrayList<Supplier> suppliers;
	static TableModel model;
	private static int rows;
	private static int columns;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SupplierList dialog = new SupplierList();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SupplierList() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1000,551);
		
		startComponents();
		setLocationRelativeTo(null);
		buildTable();
		
	}

	private static void buildTable() {
		
		suppliers = Administration.getInstance().getTheSuppliers();
		
		ArrayList<String> headers = new ArrayList<>();
		
		headers.add("Código");
		headers.add("Nombre");
		headers.add("Cédula");
		headers.add("E-mail");
		headers.add("Dirección");
		headers.add("Teléfono");
		headers.add("Tiempo de entrega");
		headers.add("Productos que provee");
		
		String titles[] = new String[headers.size()];
		
		for(int i = 0; i < titles.length; i++)
		{
			titles[i] = headers.get(i);
		}
		
		Object[][] data = getData(headers);
		putEverythingTogether(titles, data);
		
	}

	private static void putEverythingTogether(String[] titles, Object[][] data) {
		
		model = new TableModel(titles,data);
		
		SupplierTable.setModel(model);
		
		setRows(SupplierTable.getRowCount());
		setColumns(SupplierTable.getColumnCount());
		
		for (int i = 0; i < titles.length; i++) {
			
			SupplierTable.getColumnModel().getColumn(i).setCellRenderer(new CellsConfig("text"));
		}
		
		SupplierTable.getTableHeader().setReorderingAllowed(false);
		SupplierTable.setRowHeight(25);
		SupplierTable.setGridColor(new java.awt.Color(0,0,0));
		
		SupplierTable.getColumnModel().getColumn(0).setPreferredWidth(200);
		SupplierTable.getColumnModel().getColumn(1).setPreferredWidth(400);
		SupplierTable.getColumnModel().getColumn(2).setPreferredWidth(350);
		SupplierTable.getColumnModel().getColumn(3).setPreferredWidth(400);
		SupplierTable.getColumnModel().getColumn(4).setPreferredWidth(300);
		SupplierTable.getColumnModel().getColumn(5).setPreferredWidth(350);
		SupplierTable.getColumnModel().getColumn(6).setPreferredWidth(400);
		SupplierTable.getColumnModel().getColumn(7).setPreferredWidth(450);
		
		JTableHeader tableHeader = SupplierTable.getTableHeader();
		tableHeader.setDefaultRenderer(new TableTitles());
		SupplierTable.setTableHeader(tableHeader);
		
		scrollPaneTable.setViewportView(SupplierTable);
		
		
	}

	private static Object[][] getData(ArrayList<String> headers) {
		
		String info[][] = new String[suppliers.size()][headers.size()];
		
		for(int i = 0; i < info.length; i++)
		{
			int devTime = suppliers.get(i).getDeliveryTime();
			String deliveryTime = String.valueOf(devTime);
			
			info[i][0] = suppliers.get(i).getId();
			info[i][1] = suppliers.get(i).getName();
			info[i][2] = suppliers.get(i).getNi();
			info[i][3] = suppliers.get(i).getEmail();
			info[i][4] = suppliers.get(i).getAddress();
			info[i][5] = suppliers.get(i).getPhone();
			info[i][6] = deliveryTime;
			//info[i][7] = suppliers.get(i).getMyComponents().toString();
		}
		return info;
	}

	private void startComponents() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0,0));
		
		JLabel lbl_supplierTable = new JLabel("Listado suplidores");
		lbl_supplierTable.setFont(new Font("Centaur",Font.PLAIN,30));
		contentPane.add(lbl_supplierTable, BorderLayout.NORTH);
		
		scrollPaneTable = new JScrollPane();
		contentPane.add(scrollPaneTable);
		
		SupplierTable = new JTable();
		SupplierTable.setBackground(Color.white);
		SupplierTable.setBorder(new BevelBorder(BevelBorder.RAISED,null,null,null,null));
		SupplierTable.addMouseListener(this);
		SupplierTable.setOpaque(false);
		scrollPaneTable.setViewportView(SupplierTable);
	}

	public static int getRows() {
		return rows;
	}

	public static void setRows(int rows) {
		SupplierList.rows = rows;
	}

	public static int getColumns() {
		return columns;
	}

	public static void setColumns(int columns) {
		SupplierList.columns = columns;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int row = SupplierTable.rowAtPoint(e.getPoint());
		int column = SupplierTable.columnAtPoint(e.getPoint());
		
		if(row >= 0 && column >= 0)
		{
			Supplier selSuppli = suppliers.get(row);
			
			if(SupplierTable != null)
			{
				SupplierRegistry updateSuppli = new SupplierRegistry(selSuppli);
				updateSuppli.setModal(true);
				updateSuppli.setVisible(true);
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
