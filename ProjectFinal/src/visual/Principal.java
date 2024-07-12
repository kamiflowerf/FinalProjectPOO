package visual;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Dimension dim;
	private JTextField txtComponents;
	private JTextField txtClients;
	private JTextField txtSupplier;
	private JTextField txtAdmin;
	private Color background = new Color(51, 51, 51);
	private Color selected = new Color(102, 102, 102);
	private JPanel pnlCompMenu;
	private JLabel lblRegComp;
	private JLabel lblListComp;
	private JPanel pnlCliMenu;
	private JLabel lblRegClient;
	private JLabel lblListClient;
	private JPanel pnlSup;
	private JLabel lblRegSup;
	private JLabel lblListSup;
	private JPanel pnlAdmin;
	private JLabel lblMakeSale;
	private JLabel lblMakeDelivery;
	private JLabel lblSaleManage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height-50);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(background);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(-11, -16, 304, 1014);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(background);
		panel_1.setBounds(12, 273, 292, 343);
		panel.add(panel_1);
		
		txtComponents = new JTextField();
		txtComponents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				txtComponents.setBackground(selected);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtComponents.setBackground(background);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlCompMenu.setVisible(true);
				pnlCliMenu.setVisible(false);
				pnlSup.setVisible(false);
				pnlAdmin.setVisible(false);
			}
		});
		txtComponents.setForeground(new Color(255, 255, 255));
		txtComponents.setText("           Componentes");
		txtComponents.setBackground(background);
		txtComponents.setEditable(false);
		txtComponents.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtComponents.setBounds(-12, 0, 304, 88);
		panel_1.add(txtComponents);
		txtComponents.setColumns(10);
		
		txtClients = new JTextField();
		txtClients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				txtClients.setBackground(selected);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtClients.setBackground(background);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlCompMenu.setVisible(false);
				pnlCliMenu.setVisible(true);
				pnlSup.setVisible(false);
				pnlAdmin.setVisible(false);
			}
		});
		txtClients.setText("               Clientes");
		txtClients.setForeground(Color.WHITE);
		txtClients.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtClients.setEditable(false);
		txtClients.setColumns(10);
		txtClients.setBackground(new Color(51, 51, 51));
		txtClients.setBounds(-12, 86, 304, 88);
		panel_1.add(txtClients);
		
		txtSupplier = new JTextField();
		txtSupplier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				txtSupplier.setBackground(selected);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtSupplier.setBackground(background);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlCompMenu.setVisible(false);
				pnlCliMenu.setVisible(false);
				pnlSup.setVisible(true);
				pnlAdmin.setVisible(false);
			}
		});
		txtSupplier.setText("            Proveedores");
		txtSupplier.setForeground(Color.WHITE);
		txtSupplier.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtSupplier.setEditable(false);
		txtSupplier.setColumns(10);
		txtSupplier.setBackground(background);
		txtSupplier.setBounds(-12, 171, 304, 88);
		panel_1.add(txtSupplier);
		
		txtAdmin = new JTextField();
		txtAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				txtAdmin.setBackground(selected);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtAdmin.setBackground(background);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlCompMenu.setVisible(false);
				pnlCliMenu.setVisible(false);
				pnlSup.setVisible(false);
				pnlAdmin.setVisible(true);
			}
		});
		txtAdmin.setText("           Administraci\u00F3n");
		txtAdmin.setForeground(Color.WHITE);
		txtAdmin.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtAdmin.setEditable(false);
		txtAdmin.setColumns(10);
		txtAdmin.setBackground(new Color(51, 51, 51));
		txtAdmin.setBounds(-12, 254, 304, 88);
		panel_1.add(txtAdmin);
		
		pnlCompMenu = new JPanel();
		pnlCompMenu.setBounds(292, 256, 335, 117);
		contentPane.add(pnlCompMenu);
		pnlCompMenu.setBackground(background);
		pnlCompMenu.setVisible(false);
		pnlCompMenu.setLayout(null);
		
		lblRegComp = new JLabel("      Registrar Componente");
		lblRegComp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRegComp.setForeground(selected);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblRegComp.setForeground(Color.WHITE);
			}
		});
		lblRegComp.setForeground(new Color(255, 255, 255));
		lblRegComp.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblRegComp.setBounds(0, 0, 335, 55);
		pnlCompMenu.add(lblRegComp);
		
		lblListComp = new JLabel("      Listar Componentes");
		lblListComp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblListComp.setForeground(selected);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblListComp.setForeground(Color.WHITE);
			}
		});
		lblListComp.setForeground(Color.WHITE);
		lblListComp.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblListComp.setBounds(0, 55, 335, 55);
		pnlCompMenu.add(lblListComp);
		
		pnlCliMenu = new JPanel();
		pnlCliMenu.setLayout(null);
		pnlCliMenu.setBackground(new Color(51, 51, 51));
		pnlCliMenu.setBounds(292, 344, 335, 117);
		pnlCliMenu.setVisible(false);
		contentPane.add(pnlCliMenu);
		
		lblRegClient = new JLabel("      Registrar Cliente");
		lblRegClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRegClient.setForeground(selected);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblRegClient.setForeground(Color.WHITE);
			}
		});
		lblRegClient.setForeground(Color.WHITE);
		lblRegClient.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblRegClient.setBounds(0, 0, 335, 55);
		pnlCliMenu.add(lblRegClient);
		
		lblListClient = new JLabel("      Listar Cliente");
		lblListClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblListClient.setForeground(selected);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblListClient.setForeground(Color.WHITE);
			}
		});
		lblListClient.setForeground(Color.WHITE);
		lblListClient.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblListClient.setBounds(0, 55, 335, 55);
		pnlCliMenu.add(lblListClient);
		
		pnlSup = new JPanel();
		pnlSup.setLayout(null);
		pnlSup.setBackground(new Color(51, 51, 51));
		pnlSup.setBounds(292, 430, 335, 117);
		pnlSup.setVisible(false);
		contentPane.add(pnlSup);
		
		lblRegSup = new JLabel("      Registrar Proveedor");
		lblRegSup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRegSup.setForeground(selected);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblRegSup.setForeground(Color.WHITE);
			}
		});
		lblRegSup.setForeground(Color.WHITE);
		lblRegSup.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblRegSup.setBounds(0, 0, 335, 55);
		pnlSup.add(lblRegSup);
		
		lblListSup = new JLabel("      Listar Proveedor");
		lblListSup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblListSup.setForeground(selected);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblListSup.setForeground(Color.WHITE);
			}
		});
		lblListSup.setForeground(Color.WHITE);
		lblListSup.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblListSup.setBounds(0, 55, 335, 55);
		pnlSup.add(lblListSup);
		
		pnlAdmin = new JPanel();
		pnlAdmin.setLayout(null);
		pnlAdmin.setBackground(new Color(51, 51, 51));
		pnlAdmin.setBounds(292, 515, 335, 179);
		pnlAdmin.setVisible(false);
		contentPane.add(pnlAdmin);
		
		lblMakeSale = new JLabel("      Realizar Venta");
		lblMakeSale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMakeSale.setForeground(selected);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMakeSale.setForeground(Color.WHITE);
			}
		});
		lblMakeSale.setForeground(Color.WHITE);
		lblMakeSale.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblMakeSale.setBounds(0, 0, 335, 55);
		pnlAdmin.add(lblMakeSale);
		
		lblMakeDelivery = new JLabel("      Realizar Pedido");
		lblMakeDelivery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMakeDelivery.setForeground(selected);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMakeDelivery.setForeground(Color.WHITE);
			}
		});
		lblMakeDelivery.setForeground(Color.WHITE);
		lblMakeDelivery.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblMakeDelivery.setBounds(0, 55, 335, 55);
		pnlAdmin.add(lblMakeDelivery);
		
		lblSaleManage = new JLabel("      Control de Ventas");
		lblSaleManage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSaleManage.setForeground(selected);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSaleManage.setForeground(Color.WHITE);
			}
		});
		lblSaleManage.setForeground(Color.WHITE);
		lblSaleManage.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblSaleManage.setBounds(0, 111, 335, 55);
		pnlAdmin.add(lblSaleManage);
	}
}
