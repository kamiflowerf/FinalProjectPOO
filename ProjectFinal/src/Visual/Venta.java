package Visual;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Visual.Catalogo.onSelectedComp;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import logic.*; 

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Venta extends JDialog implements onSelectedComp{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdClient;
	private JTextField txtBillId;
	private JTextField txtBillDate;
	private JTextField txtTotal;
	private JTable tableComponents;
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Venta dialog = new Venta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Venta() {
	    setTitle("Venta");
	    setBounds(100, 100, 668, 369);
	    setLocationRelativeTo(null);
	    getContentPane().setLayout(new BorderLayout());
	    contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    getContentPane().add(contentPanel, BorderLayout.CENTER);
	    contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("ID Cliente");
			lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
			lblNewLabel.setBounds(25, 33, 83, 16);
			contentPanel.add(lblNewLabel);
		}
		{
			txtIdClient = new JTextField();
			txtIdClient.setFont(new Font("Verdana", Font.PLAIN, 14));
			txtIdClient.setEditable(false);
			txtIdClient.setBounds(25, 62, 147, 22);
			contentPanel.add(txtIdClient);
			txtIdClient.setColumns(10);
		}
		{
			JLabel lblComponentes = new JLabel("Componentes");
			lblComponentes.setFont(new Font("Verdana", Font.BOLD, 14));
			lblComponentes.setBounds(25, 135, 119, 16);
			contentPanel.add(lblComponentes);
		}
		{
		    JPanel pnlComponents = new JPanel();
		    pnlComponents.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		    pnlComponents.setBounds(25, 158, 320, 140);
		    contentPanel.add(pnlComponents);
		    pnlComponents.setLayout(new BorderLayout(0, 0));
			{
			    JScrollPane scrollPane = new JScrollPane();
			    pnlComponents.add(scrollPane, BorderLayout.CENTER);
			    
			    tableModel = new DefaultTableModel(new Object[]{"ID", "Tipo de Componente", "Cantidad"}, 0);
			    tableComponents = new JTable(tableModel);
			    scrollPane.setViewportView(tableComponents);
			}
		}
		{
		    JButton btnSearchComp = new JButton("Buscar");
		    btnSearchComp.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            Catalogo catalogo = new Catalogo(Venta.this); // Pasar 'this' para implementar la interfaz
		            catalogo.setModal(true);
		            catalogo.setVisible(true);
		            catalogo.setResizable(false);
		        }
		    });
		    btnSearchComp.setFont(new Font("Verdana", Font.PLAIN, 14));
		    btnSearchComp.setBounds(248, 126, 97, 25);
		    btnSearchComp.setBorder(new RoundedBorder(Color.BLACK, 1, 20));
		    contentPanel.add(btnSearchComp);
		}
		{
			JButton btnSearchClient = new JButton("Buscar");
			btnSearchClient.setFont(new Font("Verdana", Font.PLAIN, 14));
			btnSearchClient.setBounds(248, 61, 97, 25);
			btnSearchClient.setBorder(new RoundedBorder(Color.BLACK,1,20));
			contentPanel.add(btnSearchClient);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(357, 13, 281, 233);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblIdFactura = new JLabel("ID Factura");
				lblIdFactura.setFont(new Font("Verdana", Font.BOLD, 14));
				lblIdFactura.setBounds(12, 17, 90, 16);
				panel.add(lblIdFactura);
			}
			{
				txtBillId = new JTextField();
				txtBillId.setFont(new Font("Verdana", Font.PLAIN, 14));
				txtBillId.setEditable(false);
				txtBillId.setColumns(10);
				txtBillId.setBounds(12, 50, 147, 22);
				panel.add(txtBillId);
			}
			{
				JLabel lblFechaFacturacin = new JLabel("Fecha Facturaci\u00F3n");
				lblFechaFacturacin.setFont(new Font("Verdana", Font.BOLD, 14));
				lblFechaFacturacin.setBounds(12, 89, 147, 16);
				panel.add(lblFechaFacturacin);
			}
			{
				txtBillDate = new JTextField();
				txtBillDate.setFont(new Font("Verdana", Font.PLAIN, 14));
				txtBillDate.setEditable(false);
				txtBillDate.setColumns(10);
				txtBillDate.setBounds(12, 122, 147, 22);
				panel.add(txtBillDate);
			}
			{
				JLabel lblTotal = new JLabel("Total");
				lblTotal.setFont(new Font("Verdana", Font.BOLD, 14));
				lblTotal.setBounds(12, 161, 147, 16);
				panel.add(lblTotal);
			}
			{
				txtTotal = new JTextField();
				txtTotal.setFont(new Font("Verdana", Font.PLAIN, 14));
				txtTotal.setEditable(false);
				txtTotal.setColumns(10);
				txtTotal.setBounds(12, 194, 147, 22);
				panel.add(txtTotal);
			}
		}
		{
			JButton btnVender = new JButton("Vender");
			btnVender.setFont(new Font("Verdana", Font.PLAIN, 14));
			btnVender.setBounds(357, 273, 97, 25);
			btnVender.setBorder(new RoundedBorder(Color.BLACK,1,20));
			contentPanel.add(btnVender);
		}
		{
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 14));
			btnCancelar.setBounds(466, 273, 97, 25);
			btnCancelar.setBorder(new RoundedBorder(Color.BLACK,1,20));
			contentPanel.add(btnCancelar);
		}
	}

	@Override
	public void getSelectedComp(String ID) {
	    // Buscar el componente por ID
	    Component comp = Administration.getInstance().searchComponentById(ID);
	    
	    if (comp != null) {
	        String componentType = Catalogo.getComponentType(comp);
	        int quantity = comp.getUnits();
	        
	        // Agregar una nueva fila a la tabla
	        tableModel.addRow(new Object[]{ID, componentType, quantity});
	    }
	}

}
