package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;



import Visual.Catalogo.onSelectedComp;
import Visual.ClientList.onSelectedClient;
import Visual.ComboList.onSelectedCombo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import logic.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Venta extends JDialog implements onSelectedComp, onSelectedClient, onSelectedCombo {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private String idClient;
    private double price = 0.0;
    ArrayList<Component> comps = new ArrayList<>();
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
        contentPanel.setBackground(new Color(70, 130, 180));
        contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JLabel lblNewLabel = new JLabel("ID Cliente");
            lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 15));
            lblNewLabel.setBounds(25, 16, 83, 16);
            contentPanel.add(lblNewLabel);
        }
        {
            txtIdClient = new JTextField();
            txtIdClient.setFont(new Font("Verdana", Font.PLAIN, 15));
            txtIdClient.setEditable(false);
            txtIdClient.setBounds(25, 39, 147, 22);
            contentPanel.add(txtIdClient);
            txtIdClient.setColumns(10);
        }
        {
            JLabel lblComponentes = new JLabel("Componentes");
            lblComponentes.setFont(new Font("Verdana", Font.BOLD, 15));
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

                tableModel = new DefaultTableModel(new Object[]{"ID", "Tipo de Componente", "Modelo", "Precio"}, 0);
                tableComponents = new JTable(tableModel);
                tableComponents.setFont(new Font("Verdana", Font.PLAIN, 13));
                scrollPane.setViewportView(tableComponents);
            }
        }
        {
            JButton btnSearchComp = new JButton("Buscar Componente");
            btnSearchComp.setBackground(new Color(230, 230, 250));
            btnSearchComp.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Catalogo catalogo = new Catalogo(Venta.this);
                    catalogo.setModal(true);
                    catalogo.setVisible(true);
                    catalogo.setResizable(false);
                    updateTotal();
                }
            });
            btnSearchComp.setFont(new Font("Verdana", Font.PLAIN, 15));
            btnSearchComp.setBounds(174, 126, 171, 25);
            btnSearchComp.setBorder(new RoundedBorder(Color.BLACK, 1, 20));
            contentPanel.add(btnSearchComp);
        }
        {
            JButton btnSearchClient = new JButton("Buscar");
            btnSearchClient.setBackground(new Color(230, 230, 250));
            btnSearchClient.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    ClientList clist = new ClientList(Venta.this);
                    clist.setModal(true);
                    clist.setVisible(true);
                    clist.setResizable(true);
                    txtIdClient.setText(idClient);
                }
            });
            btnSearchClient.setFont(new Font("Verdana", Font.PLAIN, 15));
            btnSearchClient.setBounds(248, 38, 97, 25);
            btnSearchClient.setBorder(new RoundedBorder(Color.BLACK, 1, 20));
            contentPanel.add(btnSearchClient);
        }
        {
            JPanel panel = new JPanel();
            panel.setBackground(new Color(230, 230, 250));
            panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            panel.setBounds(357, 13, 281, 233);
            contentPanel.add(panel);
            panel.setLayout(null);
            {
                JLabel lblIdFactura = new JLabel("ID Factura");
                lblIdFactura.setFont(new Font("Verdana", Font.BOLD, 15));
                lblIdFactura.setBounds(12, 17, 90, 16);
                panel.add(lblIdFactura);
            }
            {
                txtBillId = new JTextField();
                txtBillId.setFont(new Font("Verdana", Font.PLAIN, 15));
                txtBillId.setEditable(false);
                txtBillId.setColumns(10);
                txtBillId.setText(IdGenerator.generateId());
                txtBillId.setBounds(12, 50, 147, 22);
                panel.add(txtBillId);
            }
            {
                JLabel lblFechaFacturacin = new JLabel("Fecha Facturaci\u00F3n");
                lblFechaFacturacin.setFont(new Font("Verdana", Font.BOLD, 15));
                lblFechaFacturacin.setBounds(12, 89, 147, 16);
                panel.add(lblFechaFacturacin);
            }
            {
                txtBillDate = new JTextField();
                txtBillDate.setFont(new Font("Verdana", Font.PLAIN, 15));
                txtBillDate.setEditable(false);
                txtBillDate.setColumns(10);
                txtBillDate.setBounds(12, 122, 147, 22);
                panel.add(txtBillDate);
                // Establecer la fecha actual en el campo de texto
                txtBillDate.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
            {
                JLabel lblTotal = new JLabel("Total");
                lblTotal.setFont(new Font("Verdana", Font.BOLD, 15));
                lblTotal.setBounds(12, 161, 147, 16);
                panel.add(lblTotal);
            }
            {
                txtTotal = new JTextField();
                txtTotal.setFont(new Font("Verdana", Font.PLAIN, 15));
                txtTotal.setEditable(false);
                txtTotal.setColumns(10);
                txtTotal.setBounds(12, 194, 147, 22);
                panel.add(txtTotal);
            }
        }
        {
        	JButton btnVender = new JButton("Vender");
        	btnVender.setBackground(new Color(230, 230, 250));
            btnVender.setFont(new Font("Verdana", Font.PLAIN, 15));
            btnVender.setBounds(357, 273, 97, 25);
            btnVender.setBorder(new RoundedBorder(Color.BLACK, 1, 20));
            btnVender.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Obtener ID del cliente
                    String idClient = txtIdClient.getText();

                    // Obtener fecha de la factura
                    String billDateStr = txtBillDate.getText();
                    Date billDate = null;
                    try {
                        billDate = new SimpleDateFormat("dd/MM/yyyy").parse(billDateStr);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(Venta.this, "Error en el formato de la fecha.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                   
                    ArrayList<Component> componentsSale = new ArrayList<>();
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        String id = (String) tableModel.getValueAt(i, 0);
                        Component comp = Administration.getInstance().searchComponentById(id);
                        if (comp != null) {
                            componentsSale.add(comp);
                        }
                    }

                  
                    boolean saleSuccessful = Administration.getInstance().makeSale(idClient, billDate, componentsSale);
                    if (saleSuccessful) {
                        JOptionPane.showMessageDialog(Venta.this, "Venta realizada con �xito.", "�xito", JOptionPane.INFORMATION_MESSAGE);
                        txtIdClient.setText("");
                        txtBillId.setText(IdGenerator.generateId()); 
                        txtBillDate.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        txtTotal.setText("");

                        tableModel.setRowCount(0);
                    } else {
                        JOptionPane.showMessageDialog(Venta.this, "Error al realizar la venta. Verifique los datos e intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            contentPanel.add(btnVender);
        }
        {
            JButton btnCancelar = new JButton("Cancelar");
            btnCancelar.setBackground(new Color(230, 230, 250));
            btnCancelar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 15));
            btnCancelar.setBounds(466, 273, 97, 25);
            btnCancelar.setBorder(new RoundedBorder(Color.BLACK, 1, 20));
            contentPanel.add(btnCancelar);
        }
        {
            JButton btnComb = new JButton("Buscar Combo");
            btnComb.setBackground(new Color(230, 230, 250));
            btnComb.setFont(new Font("Verdana", Font.PLAIN, 15));
            btnComb.setBorder(new RoundedBorder(Color.BLACK, 1, 20));
            btnComb.setBounds(211, 90, 134, 25);
            btnComb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ComboList catalogoCombo = new ComboList(Venta.this);
                    catalogoCombo.setModal(true); 
                    catalogoCombo.setVisible(true); 
                    catalogoCombo.setResizable(true); 
                    updateTotal();
                }
            });
            contentPanel.add(btnComb);
        }

    }
																		
    @Override
    public void getSelectedComp(String ID) {
        Component comp = Administration.getInstance().searchComponentById(ID);
    	
        if (comp != null) {
	        String componentType = Catalogo.getComponentType(comp);		        
	        String model = "";
	        if(comp instanceof MotherBoard) {
	        	model = ((MotherBoard) comp).getModel();
	        } else if(comp instanceof HardDisk) {
	        	model = ((HardDisk) comp).getModel();
	        } else if(comp instanceof MicroProcessor) {
	        	model = ((MicroProcessor) comp).getModel();
	        } else if(comp instanceof RAM) {
	        	model = ((RAM) comp).getType();
	        }
		    price += comp.getPrice();
	        double localPrice = comp.getPrice();
	        
		    boolean exists = false;
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String id = (String) tableModel.getValueAt(i, 0);
                if (id.equals(ID)) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
            	tableModel.addRow(new Object[]{ID, componentType, model,localPrice});
            	comps.add(comp);
            } else {
                JOptionPane.showMessageDialog(this, "El componente ya est� en la tabla.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
		    
	    }
        updateTotal();
    }

    private void updateTotal() {
        txtTotal.setText(String.format("%.2f $RD", price));
    }

    @Override
    public void getSelectedClient(String id) {
        this.idClient = id;
    }
    
    private void addComboToTable(Combo combo) {
        for (Component comp : combo.getComboComp()) {
            String componentType = Catalogo.getComponentType(comp);
            String model = "";
            if(comp instanceof MotherBoard) {
	        	model = ((MotherBoard) comp).getModel();
	        } else if(comp instanceof HardDisk) {
	        	model = ((HardDisk) comp).getModel();
	        } else if(comp instanceof MicroProcessor) {
	        	model = ((MicroProcessor) comp).getModel();
	        } else if(comp instanceof RAM) {
	        	model = ((RAM) comp).getType();
	        }
            double discount = combo.getDiscount() / 100.0;
            double localPrice = comp.getPrice() * (1 - discount);
            price += localPrice;
            
            boolean exists = false;
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String id = (String) tableModel.getValueAt(i, 0);
                if (id.equals(comp.getId())) {
                    exists = true;
                    break;
                }
            }
            
            if (!exists) {
                tableModel.addRow(new Object[]{comp.getId(), componentType, model,localPrice});
                comps.add(comp);
            } else {
                JOptionPane.showMessageDialog(this, "El componente del combo ya est� en la tabla.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        updateTotal();
    }

	@Override
	public void getSelectedCombo(String id) {
		Combo combo = Administration.getInstance().searchComboById(id);
		addComboToTable(combo);
	}

}
