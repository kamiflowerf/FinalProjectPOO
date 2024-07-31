package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logic.Administration;
import logic.Component;
import logic.HardDisk;
import logic.IdGenerator;
import logic.MicroProcessor;
import logic.MotherBoard;
import logic.RAM;
import logic.Supplier;

public class SupplierRegistry extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_suppliName;
	private JTextField txt_suppliNi;
	private JTextField txt_suppliEmail;
	private JTextField txt_suppliAddress;
	private JTextField txt_suppliPhone;
	private JTextField txt_suppliId;
	private JLabel lbl_warningName;
	private JLabel lbl_warningEmail;
	private JLabel lbl_warningAddress;
	private JLabel lbl_warningPhone;
	private JLabel lbl_warningComponentsProv;
	private JLabel lbl_warningNi;
	private JSpinner spn_deliveryTime;
	private JButton btn_reg;
	private JButton cancelButton;
	private JTable tableComponents;
	private DefaultTableModel tableModel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SupplierRegistry dialog = new SupplierRegistry(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SupplierRegistry(Supplier suppli) {
		setBackground(new Color(102, 204, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(SupplierRegistry.class.getResource("/Images/empleado.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		if(suppli != null)
		{
			setTitle("Actualizar Proveedor");
		}
		else
		{
			setTitle("Registro Proveedor");
		}
		setBounds(100, 100, 614, 561);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 153, 255));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_1.setBackground(new Color(102, 204, 255));
			panel_1.setBounds(303, 56, 271, 400);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lbl_suppliName = new JLabel("Nombre:");
			lbl_suppliName.setFont(new Font("Verdana", Font.BOLD, 12));
			lbl_suppliName.setBounds(12, 65, 70, 16);
			panel_1.add(lbl_suppliName);
			
			JLabel lbl_suppliNi = new JLabel("C\u00E9dula:");
			lbl_suppliNi.setFont(new Font("Verdana", Font.BOLD, 12));
			lbl_suppliNi.setBounds(12, 139, 56, 16);
			panel_1.add(lbl_suppliNi);
			
			JLabel lbl_suppliEmail = new JLabel("Correo electr\u00F3nico:");
			lbl_suppliEmail.setFont(new Font("Verdana", Font.BOLD, 12));
			lbl_suppliEmail.setBounds(12, 216, 137, 16);
			panel_1.add(lbl_suppliEmail);
			
			JLabel lbl_suppliAddress = new JLabel("Direcci\u00F3n:");
			lbl_suppliAddress.setFont(new Font("Verdana", Font.BOLD, 12));
			lbl_suppliAddress.setBounds(12, 275, 70, 16);
			panel_1.add(lbl_suppliAddress);
			
			JLabel lbl_suppliPhone = new JLabel("Tel\u00E9fono:");
			lbl_suppliPhone.setFont(new Font("Verdana", Font.BOLD, 12));
			lbl_suppliPhone.setBounds(12, 339, 70, 16);
			panel_1.add(lbl_suppliPhone);
			
			txt_suppliName = new JTextField();
			txt_suppliName.setBounds(143, 61, 116, 22);
			panel_1.add(txt_suppliName);
			txt_suppliName.setColumns(10);
			
			txt_suppliNi = new JTextField();
			txt_suppliNi.setColumns(10);
			txt_suppliNi.setBounds(143, 136, 116, 22);
			panel_1.add(txt_suppliNi);
			
			txt_suppliEmail = new JTextField();
			txt_suppliEmail.setColumns(10);
			txt_suppliEmail.setBounds(143, 214, 116, 22);
			panel_1.add(txt_suppliEmail);
			
			txt_suppliAddress = new JTextField();
			txt_suppliAddress.setColumns(10);
			txt_suppliAddress.setBounds(143, 274, 116, 22);
			panel_1.add(txt_suppliAddress);
			
			txt_suppliPhone = new JTextField();
			txt_suppliPhone.setColumns(10);
			txt_suppliPhone.setBounds(143, 339, 116, 22);
			panel_1.add(txt_suppliPhone);
			
			JLabel lbl_suppliId = new JLabel("Id:");
			lbl_suppliId.setBackground(new Color(255, 255, 255));
			lbl_suppliId.setFont(new Font("Verdana", Font.BOLD, 12));
			lbl_suppliId.setBounds(12, 18, 56, 16);
			panel_1.add(lbl_suppliId);
			
			txt_suppliId = new JTextField();
			txt_suppliId.setEditable(false);
			txt_suppliId.setBounds(143, 13, 116, 22);
			panel_1.add(txt_suppliId);
			txt_suppliId.setColumns(10);
			txt_suppliId.setText(IdGenerator.generateId());
			
			lbl_warningName = new JLabel("ESTE CAMPO ES OBLIGATORIO");
			lbl_warningName.setForeground(Color.RED);
			lbl_warningName.setFont(new Font("Verdana", Font.BOLD, 12));
			lbl_warningName.setBounds(44, 95, 215, 16);
			panel_1.add(lbl_warningName);
			lbl_warningName.setVisible(false);
			
			lbl_warningNi = new JLabel("ESTE CAMPO ES OBLIGATORIO");
			lbl_warningNi.setForeground(Color.RED);
			lbl_warningNi.setFont(new Font("Verdana", Font.BOLD, 12));
			lbl_warningNi.setBounds(44, 170, 215, 16);
			panel_1.add(lbl_warningNi);
			lbl_warningNi.setVisible(false);
			
			lbl_warningEmail = new JLabel("ESTE CAMPO ES OBLIGATORIO");
			lbl_warningEmail.setForeground(Color.RED);
			lbl_warningEmail.setFont(new Font("Verdana", Font.BOLD, 12));
			lbl_warningEmail.setBounds(44, 245, 215, 16);
			panel_1.add(lbl_warningEmail);
			lbl_warningEmail.setVisible(false);
			
			lbl_warningAddress = new JLabel("ESTE CAMPO ES OBLIGATORIO");
			lbl_warningAddress.setForeground(Color.RED);
			lbl_warningAddress.setFont(new Font("Verdana", Font.BOLD, 12));
			lbl_warningAddress.setBounds(44, 308, 215, 16);
			panel_1.add(lbl_warningAddress);
			lbl_warningAddress.setVisible(false);
			
			lbl_warningPhone = new JLabel("ESTE CAMPO ES OBLIGATORIO");
			lbl_warningPhone.setForeground(Color.RED);
			lbl_warningPhone.setFont(new Font("Verdana", Font.BOLD, 12));
			lbl_warningPhone.setBounds(44, 371, 215, 16);
			panel_1.add(lbl_warningPhone);
			lbl_warningPhone.setVisible(false);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(22, 69, 264, 187);
			panel.add(panel_2);
			panel_2.setLayout(new BorderLayout(0, 0));
			
			String headers[] = {"Id", "Tipo", "Modelo"};
			tableModel = new DefaultTableModel(new Object[][]{},headers);
			populateComponentsTable(Administration.getInstance().getTheComponents());
			
			tableComponents = new JTable(tableModel);
			JScrollPane scroll = new JScrollPane (tableComponents);
			panel_2.add(scroll,BorderLayout.CENTER);
					
			JLabel lbl_suppliDeliveryTime = new JLabel("Tiempo de entrega:");
			lbl_suppliDeliveryTime.setFont(new Font("Verdana", Font.BOLD, 12));
			lbl_suppliDeliveryTime.setBounds(22, 13, 185, 16);
			panel.add(lbl_suppliDeliveryTime);
			
			spn_deliveryTime = new JSpinner();
			spn_deliveryTime.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spn_deliveryTime.setBounds(203, 10, 83, 22);
			panel.add(spn_deliveryTime);
			
			JLabel lbl_products = new JLabel("Componentes que provee: ");
			lbl_products.setFont(new Font("Verdana", Font.BOLD, 12));
			lbl_products.setBounds(22, 53, 217, 16);
			panel.add(lbl_products);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBounds(22, 270, 264, 187);
			panel.add(panel_3);
			panel_3.setLayout(null);
			
			JLabel foto = new JLabel("");
			foto.setMaximumSize(new Dimension(48, 70));
			foto.setBounds(0, 0, 274, 187);
			panel_3.add(foto);
			
			ImageIcon icon = new ImageIcon(this.getClass().getResource("/Images/foto.jpg"));
			Image pic = icon.getImage();
			Image sized = pic.getScaledInstance(panel_3.getWidth(), panel_3.getHeight(), Image.SCALE_SMOOTH);
			foto.setIcon(new ImageIcon(sized));
			
			{
				JLabel lbl_info = new JLabel("Informaci\u00F3n del Proveedor");
				lbl_info.setFont(new Font("Verdana", Font.BOLD, 14));
				lbl_info.setBounds(329, 26, 221, 16);
				panel.add(lbl_info);
			}
			
			lbl_warningComponentsProv = new JLabel("!!");
			lbl_warningComponentsProv.setForeground(Color.RED);
			lbl_warningComponentsProv.setFont(new Font("Verdana", Font.BOLD, 14));
			lbl_warningComponentsProv.setBounds(201, 52, 56, 16);
			panel.add(lbl_warningComponentsProv);
			lbl_warningComponentsProv.setVisible(false);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 153, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btn_reg = new JButton("Registrar");
				btn_reg.setFont(new Font("Verdana", Font.BOLD, 12));
				if(suppli != null)
				{
					btn_reg.setText("Actualizar");
				}
				btn_reg.setPreferredSize(new Dimension(85, 30));
				btn_reg.setBorder(new RoundedBorder(Color.BLACK,1,25));
				btn_reg.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent arg0) {
				        String id = txt_suppliId.getText();
				        String name = txt_suppliName.getText();
				        String personalDoc = txt_suppliNi.getText();
				        String email = txt_suppliEmail.getText();
				        String address = txt_suppliAddress.getText();
				        String phone = txt_suppliPhone.getText();
				        int deliTime = (int) spn_deliveryTime.getValue();
				        ArrayList<Component> componentsProvided = getSelectedComponents();
				        boolean valid = validateFields();

				        // Manejo de proveedores
				        if (valid) {
				            Supplier sup;
				            if (componentsProvided.isEmpty()) {
				                sup = new Supplier(personalDoc, name, phone, address, email, id, deliTime, null);
				            } else {
				                sup = new Supplier(personalDoc, name, phone, address, email, id, deliTime, componentsProvided);
				            }

				            if (suppli == null) {
				                // Crear nuevo proveedor
				                Administration.getInstance().addPerson(sup);
				                JOptionPane.showMessageDialog(null, "Proveedor registrado satisfactoriamente.", "Registro Proveedor", JOptionPane.INFORMATION_MESSAGE);
				                clean();
				            } else {
				                // Actualizar proveedor existente
				                suppli.setName(name);
				                suppli.setNi(personalDoc);
				                suppli.setEmail(email);
				                suppli.setAddress(address);
				                suppli.setPhone(phone);
				                suppli.setDeliveryTime(deliTime);
				                suppli.setMyComponents(componentsProvided);
				                Administration.getInstance().updatePerson(suppli);
				                SupplierList.updateTable();
				                JOptionPane.showMessageDialog(null, "Proveedor actualizado satisfactoriamente.", "Actualizar Proveedor", JOptionPane.INFORMATION_MESSAGE);
				                dispose();
				            }
				        } else {
				            lbl_warningComponentsProv.setVisible(true);
				        }
				    }
				});

				btn_reg.setActionCommand("OK");
				buttonPane.add(btn_reg);
				getRootPane().setDefaultButton(btn_reg);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Verdana", Font.BOLD, 12));
				cancelButton.setPreferredSize(new Dimension(85, 30));
				cancelButton.setBorder(new RoundedBorder(Color.BLACK,1,25));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		loadSupplier(suppli);
	}

	private void populateComponentsTable(ArrayList<Component> theComponents) {
		
		tableModel.setRowCount(0);
		String type = "";
		
		for(Component c: theComponents)
		{
			if(c instanceof  HardDisk) type = "Disco duro";
			else if (c instanceof  MicroProcessor) type = "Microprocesador";
			else if (c instanceof  MotherBoard) type = "Tarjeta madre";
			else if (c instanceof  RAM) type = "RAM";
			
			tableModel.addRow(new Object[] {c.getId(),type,c.getSerie()});
		}
		
	}

	private void loadSupplier(Supplier suppli) {
	    if (suppli != null) 
	    {
	    	try 
	    	{
	    		txt_suppliId.setText(suppli.getId());
		        txt_suppliName.setText(suppli.getName());
		        txt_suppliNi.setText(suppli.getNi());
		        txt_suppliEmail.setText(suppli.getEmail());
		        txt_suppliAddress.setText(suppli.getAddress());
		        txt_suppliPhone.setText(suppli.getPhone());
		        spn_deliveryTime.setValue(suppli.getDeliveryTime());
		        
		        
	    	} 
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}  
	    }
	}
	private void clean() {
	
		try 
		{
			txt_suppliId.setText(IdGenerator.generateId());
			txt_suppliName.setText("");
			txt_suppliNi.setText("");
			txt_suppliEmail.setText("");
			txt_suppliAddress.setText("");
			txt_suppliPhone.setText("");
	        spn_deliveryTime.setValue(1);
	  
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private ArrayList<Component> getSelectedComponents() {
	    
		ArrayList<Component> selectedComponents = new ArrayList<>();
	    int[] selectedRows = tableComponents.getSelectedRows();
	    
	    if (selectedRows.length == 0) 
	    {
	        return selectedComponents;
	    }
	    
	    for (int row : selectedRows) 
	    {
	        Object idObject = tableModel.getValueAt(row, 0);
	        if (idObject != null) 
	        {
	            String id = idObject.toString();
	            Component component = Administration.getInstance().searchComponentById(id);
	            if (component != null) 
	            {
	                selectedComponents.add(component);
	            }
	        }
	    }
	    return selectedComponents;
	}
	
	private boolean validateFields() {
        boolean isValid = true;

        if (txt_suppliName.getText().trim().isEmpty()) {
            lbl_warningName.setVisible(true);
            isValid = false;
        } else {
            lbl_warningName.setVisible(false);
        }

        if (txt_suppliNi.getText().trim().isEmpty()) {
            lbl_warningNi.setVisible(true);
            isValid = false;
        } else {
            lbl_warningNi.setVisible(false);
        }

        if (txt_suppliEmail.getText().trim().isEmpty()) {
            lbl_warningEmail.setVisible(true);
            isValid = false;
        } else {
            lbl_warningEmail.setVisible(false);
        }

        if (txt_suppliAddress.getText().trim().isEmpty()) {
            lbl_warningAddress.setVisible(true);
            isValid = false;
        } else {
            lbl_warningAddress.setVisible(false);
        }

        if (txt_suppliPhone.getText().trim().isEmpty()) {
            lbl_warningPhone.setVisible(true);
            isValid = false;
        } else {
            lbl_warningPhone.setVisible(false);
        }

        if (getSelectedComponents().isEmpty()) {
            lbl_warningComponentsProv.setVisible(true);
            isValid = false;
        } else {
            lbl_warningComponentsProv.setVisible(false);
        }

        return isValid;
    }
}
