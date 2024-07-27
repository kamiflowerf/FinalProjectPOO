package Visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import logic.Administration;
import javax.swing.ImageIcon;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	static Socket sfd = null;
	static DataInputStream EntradaSocket;
	static DataOutputStream SalidaSocket;
	static ObjectOutputStream writeSocket;
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
	private JTextField txtUsuario;
	private JPanel pnlUser;
	private JLabel lblRegUser;
	private JLabel lblMore;
	private JPanel morePnl;
	private JLabel lblRespaldo;

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream empresa;
				ObjectOutputStream empresaWrite;
				try {
					empresa = new FileOutputStream("adkEnterprise.dat");
					empresaWrite = new ObjectOutputStream(empresa);
					empresaWrite.writeObject(Administration.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		setTitle("Principal");
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
		panel_1.setBounds(12, 303, 292, 427);
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
				pnlUser.setVisible(false);
				morePnl.setVisible(false);
			}
		});
		txtComponents.setForeground(new Color(255, 255, 255));
		txtComponents.setText("              Inventario");
		txtComponents.setBackground(background);
		txtComponents.setEditable(false);
		txtComponents.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtComponents.setBounds(-12, 83, 304, 88);
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
				pnlUser.setVisible(false);
				morePnl.setVisible(false);
			}
		});
		txtClients.setText("               Clientes");
		txtClients.setForeground(Color.WHITE);
		txtClients.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtClients.setEditable(false);
		txtClients.setColumns(10);
		txtClients.setBackground(new Color(51, 51, 51));
		txtClients.setBounds(-12, 169, 304, 88);
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
				pnlUser.setVisible(false);
				morePnl.setVisible(false);
			}
		});
		txtSupplier.setText("            Proveedores");
		txtSupplier.setForeground(Color.WHITE);
		txtSupplier.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtSupplier.setEditable(false);
		txtSupplier.setColumns(10);
		txtSupplier.setBackground(background);
		txtSupplier.setBounds(-12, 256, 304, 88);
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
				pnlUser.setVisible(false);
				morePnl.setVisible(false);
			}
		});
		txtAdmin.setText("                 Ventas");
		txtAdmin.setForeground(Color.WHITE);
		txtAdmin.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtAdmin.setEditable(false);
		txtAdmin.setColumns(10);
		txtAdmin.setBackground(new Color(51, 51, 51));
		txtAdmin.setBounds(-12, 339, 304, 88);
		panel_1.add(txtAdmin);
		
		txtUsuario = new JTextField();
		txtUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				txtUsuario.setBackground(selected);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtUsuario.setBackground(background);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlCompMenu.setVisible(false);
				pnlCliMenu.setVisible(false);
				pnlSup.setVisible(false);
				pnlAdmin.setVisible(false);
				pnlUser.setVisible(true);
				morePnl.setVisible(false);
			}
		});
		txtUsuario.setText("                Usuario");
		txtUsuario.setForeground(Color.WHITE);
		txtUsuario.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtUsuario.setEditable(false);
		txtUsuario.setColumns(10);
		txtUsuario.setBackground(new Color(51, 51, 51));
		txtUsuario.setBounds(-12, 0, 304, 88);
		panel_1.add(txtUsuario);
		
		lblMore = new JLabel("");
		lblMore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				morePnl.setVisible(true);
			}
		});
		lblMore.setBounds(12, 948, 53, 53);
		Image img = new ImageIcon(this.getClass().getResource("/Images/menu-bar (1).png")).getImage();
		Image scaledImg = img.getScaledInstance(lblMore.getWidth(), lblMore.getHeight(), Image.SCALE_SMOOTH);
		lblMore.setIcon(new ImageIcon(scaledImg));
		panel.add(lblMore);
		
		morePnl = new JPanel();
		morePnl.setBorder(null);
		morePnl.setBounds(62, 915, 242, 86);
		morePnl.setVisible(false);
		morePnl.setBackground(new Color(51,51,51));
		panel.add(morePnl);
		morePnl.setLayout(null);
		
		lblRespaldo = new JLabel("      Respaldo");
		lblRespaldo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRespaldo.setForeground(selected);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblRespaldo.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					sfd = new Socket("127.0.0.1", 7000);
					EntradaSocket = new DataInputStream(new BufferedInputStream(sfd.getInputStream()));
					SalidaSocket = new DataOutputStream(new BufferedOutputStream(sfd.getOutputStream()));
					SalidaSocket.writeUTF("adkEnterprise.dat");
					
					// Enviar el contenido del archivo
		            FileInputStream fileInputStream = new FileInputStream("adkEnterprise.dat");
		            byte[] buffer = new byte[4096];
		            int bytesRead;
		            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
		                SalidaSocket.write(buffer, 0, bytesRead);
		            }
		            SalidaSocket.flush();
		            fileInputStream.close();
		            System.out.println("Archivo enviado: adkEnterprise.dat");

		            EntradaSocket.close();
		            SalidaSocket.close();
		            sfd.close();
		            JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Respaldo", JOptionPane.INFORMATION_MESSAGE);
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
					System.out.println("No se puede acceder al servidor.");
					System.exit(1);
				} catch (IOException e1) {
					e1.printStackTrace();
					System.out.println("Comunicación rechazada.");
		            System.exit(1);
				}
			}
		});
		lblRespaldo.setForeground(Color.WHITE);
		lblRespaldo.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblRespaldo.setBounds(0, 18, 242, 55);
		morePnl.add(lblRespaldo);
		
		pnlCompMenu = new JPanel();
		pnlCompMenu.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlCompMenu.setBounds(292, 370, 335, 117);
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
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RegComps regComp = new RegComps();
				regComp.setModal(true);
				regComp.setVisible(true);
				regComp.setResizable(false);
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
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Catalogo catalogo = new Catalogo(null);
				catalogo.setModal(true);
				catalogo.setVisible(true);
				catalogo.setResizable(false);
			}
			
		});
		lblListComp.setForeground(Color.WHITE);
		lblListComp.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblListComp.setBounds(0, 55, 335, 55);
		pnlCompMenu.add(lblListComp);
		
		pnlCliMenu = new JPanel();
		pnlCliMenu.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlCliMenu.setLayout(null);
		pnlCliMenu.setBackground(new Color(51, 51, 51));
		pnlCliMenu.setBounds(292, 457, 335, 117);
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
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ClientRegistry regCli = new ClientRegistry(null);
				regCli.setModal(true);
				regCli.setVisible(true);
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
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		lblListClient.setForeground(Color.WHITE);
		lblListClient.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblListClient.setBounds(0, 55, 335, 55);
		pnlCliMenu.add(lblListClient);
		
		pnlSup = new JPanel();
		pnlSup.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlSup.setLayout(null);
		pnlSup.setBackground(new Color(51, 51, 51));
		pnlSup.setBounds(292, 543, 335, 117);
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
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SupplierRegistry regSuppli = new SupplierRegistry(null);
				regSuppli.setModal(true);
				regSuppli.setVisible(true);
				
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
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SupplierList suppliList = new SupplierList(null);
				suppliList.setVisible(true);
			}
		});
		lblListSup.setForeground(Color.WHITE);
		lblListSup.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblListSup.setBounds(0, 55, 335, 55);
		pnlSup.add(lblListSup);
		
		pnlAdmin = new JPanel();
		pnlAdmin.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlAdmin.setLayout(null);
		pnlAdmin.setBackground(new Color(51, 51, 51));
		pnlAdmin.setBounds(292, 630, 335, 179);
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
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Venta venta = new Venta(); 
				venta.setModal(true);
				venta.setVisible(true); 
				venta.setResizable(false);
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
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Pedido pedido = new Pedido();  
				pedido.setModal(true);
				pedido.setVisible(true); 
				pedido.setResizable(false);
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
		
		pnlUser = new JPanel();
		pnlUser.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlUser.setBackground(new Color(51,51,51));
		pnlUser.setVisible(false);
		pnlUser.setBounds(292, 286, 335, 85);
		contentPane.add(pnlUser);
		pnlUser.setLayout(null);
		
		lblRegUser = new JLabel("      Registrar Usuario");
		lblRegUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblRegUser.setForeground(selected);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblRegUser.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				RegUser user = new RegUser();
				user.setModal(true);
				user.setVisible(true);
				user.setResizable(false);
			}
		});
		lblRegUser.setForeground(Color.WHITE);
		lblRegUser.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblRegUser.setBounds(0, 15, 335, 55);
		pnlUser.add(lblRegUser);
	}
}
