package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import logic.Administration;
import logic.Component;
import logic.IdGenerator;
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
	private JList<String> providedProducts;
	private DefaultListModel<String> model;
	private ArrayList<Component> myComponents;
	

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
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		if(suppli != null)
		{
			setTitle("Actualizar Suplidor");
		}
		else
		{
			setTitle("Registro Suplidor");
		}
		setBounds(100, 100, 614, 561);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		
		myComponents = new ArrayList<>();
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(303, 56, 271, 400);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lbl_suppliName = new JLabel("Nombre:");
			lbl_suppliName.setBounds(12, 104, 56, 16);
			panel_1.add(lbl_suppliName);
			
			JLabel lbl_suppliNi = new JLabel("C\u00E9dula:");
			lbl_suppliNi.setBounds(12, 166, 56, 16);
			panel_1.add(lbl_suppliNi);
			
			JLabel lbl_suppliEmail = new JLabel("Correo electr\u00F3nico:");
			lbl_suppliEmail.setBounds(12, 228, 119, 16);
			panel_1.add(lbl_suppliEmail);
			
			JLabel lbl_suppliAddress = new JLabel("Direcci\u00F3n:");
			lbl_suppliAddress.setBounds(12, 290, 70, 16);
			panel_1.add(lbl_suppliAddress);
			
			JLabel lbl_suppliPhone = new JLabel("Tel\u00E9fono:");
			lbl_suppliPhone.setBounds(12, 352, 56, 16);
			panel_1.add(lbl_suppliPhone);
			
			txt_suppliName = new JTextField();
			txt_suppliName.setBounds(143, 100, 116, 22);
			panel_1.add(txt_suppliName);
			txt_suppliName.setColumns(10);
			
			txt_suppliNi = new JTextField();
			txt_suppliNi.setColumns(10);
			txt_suppliNi.setBounds(143, 163, 116, 22);
			panel_1.add(txt_suppliNi);
			
			txt_suppliEmail = new JTextField();
			txt_suppliEmail.setColumns(10);
			txt_suppliEmail.setBounds(143, 226, 116, 22);
			panel_1.add(txt_suppliEmail);
			
			txt_suppliAddress = new JTextField();
			txt_suppliAddress.setColumns(10);
			txt_suppliAddress.setBounds(143, 289, 116, 22);
			panel_1.add(txt_suppliAddress);
			
			txt_suppliPhone = new JTextField();
			txt_suppliPhone.setColumns(10);
			txt_suppliPhone.setBounds(143, 352, 116, 22);
			panel_1.add(txt_suppliPhone);
			
			JLabel lbl_suppliId = new JLabel("Id:");
			lbl_suppliId.setBounds(12, 42, 56, 16);
			panel_1.add(lbl_suppliId);
			
			txt_suppliId = new JTextField();
			txt_suppliId.setEditable(false);
			txt_suppliId.setBounds(143, 37, 116, 22);
			panel_1.add(txt_suppliId);
			txt_suppliId.setColumns(10);
			txt_suppliId.setText(IdGenerator.generateId());
			
			lbl_warningName = new JLabel("ESTE CAMPO ES OBLIGATORIO");
			lbl_warningName.setForeground(Color.RED);
			lbl_warningName.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbl_warningName.setBounds(71, 134, 188, 16);
			panel_1.add(lbl_warningName);
			lbl_warningName.setVisible(false);
			
			lbl_warningNi = new JLabel("ESTE CAMPO ES OBLIGATORIO");
			lbl_warningNi.setForeground(Color.RED);
			lbl_warningNi.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbl_warningNi.setBounds(71, 197, 188, 16);
			panel_1.add(lbl_warningNi);
			lbl_warningNi.setVisible(false);
			
			lbl_warningEmail = new JLabel("ESTE CAMPO ES OBLIGATORIO");
			lbl_warningEmail.setForeground(Color.RED);
			lbl_warningEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbl_warningEmail.setBounds(71, 257, 188, 16);
			panel_1.add(lbl_warningEmail);
			lbl_warningEmail.setVisible(false);
			
			lbl_warningAddress = new JLabel("ESTE CAMPO ES OBLIGATORIO");
			lbl_warningAddress.setForeground(Color.RED);
			lbl_warningAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbl_warningAddress.setBounds(71, 323, 188, 16);
			panel_1.add(lbl_warningAddress);
			lbl_warningAddress.setVisible(false);
			
			lbl_warningPhone = new JLabel("ESTE CAMPO ES OBLIGATORIO");
			lbl_warningPhone.setForeground(Color.RED);
			lbl_warningPhone.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbl_warningPhone.setBounds(71, 384, 188, 16);
			panel_1.add(lbl_warningPhone);
			lbl_warningPhone.setVisible(false);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(22, 70, 264, 187);
			panel.add(panel_2);
			panel_2.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			panel_2.add(scrollPane, BorderLayout.CENTER);
			
			model = new DefaultListModel<>();
			ArrayList<Component> componentsForSale = Administration.getInstance().getTheComponents();
			if(componentsForSale != null) {
				
				for(Component c : componentsForSale) {
					
					model.addElement(c.getId());
				}
			}
				
			
			
			providedProducts = new JList<>();
			providedProducts.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					myComponents.clear();
                    for (String selectedId : providedProducts.getSelectedValuesList()) {
                    		Component c = Administration.getInstance().searchComponentById(selectedId);
                    		if (c != null) {
                    			myComponents.add(c);
                        }
                    }
					
				}
			});
			scrollPane.setViewportView(providedProducts);
			
			JLabel lbl_suppliDeliveryTime = new JLabel("Tiempo de entrega:");
			lbl_suppliDeliveryTime.setBounds(22, 13, 114, 16);
			panel.add(lbl_suppliDeliveryTime);
			
			spn_deliveryTime = new JSpinner();
			spn_deliveryTime.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spn_deliveryTime.setBounds(203, 10, 83, 22);
			panel.add(spn_deliveryTime);
			
			JLabel lbl_products = new JLabel("Componentes que provee: ");
			lbl_products.setBounds(22, 53, 171, 16);
			panel.add(lbl_products);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBounds(22, 270, 264, 187);
			panel.add(panel_3);
			panel_3.setLayout(null);
			
			JLabel foto = new JLabel("foto");
			foto.setBounds(104, 85, 56, 16);
			panel_3.add(foto);
			{
				JLabel lbl_info = new JLabel("Informaci\u00F3n del Suplidor");
				lbl_info.setBounds(369, 27, 151, 16);
				panel.add(lbl_info);
			}
			
			lbl_warningComponentsProv = new JLabel("!!");
			lbl_warningComponentsProv.setForeground(Color.RED);
			lbl_warningComponentsProv.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbl_warningComponentsProv.setBounds(186, 53, 56, 16);
			panel.add(lbl_warningComponentsProv);
			lbl_warningComponentsProv.setVisible(false);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_reg = new JButton("Registrar");
				if(suppli != null)
				{
					btn_reg.setText("Actualizar");
				}
				btn_reg.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						try {
						Supplier sup;
						String id = txt_suppliId.getText();
						String name = txt_suppliName.getText();
						String personalDoc = txt_suppliNi.getText();
						String email = txt_suppliEmail.getText();
						String address = txt_suppliAddress.getText();
						String phone = txt_suppliPhone.getText();
						int deliTime = (int) spn_deliveryTime.getValue();
						boolean ready = true;
						
						if(name.isEmpty()){
							lbl_warningName.setVisible(true);
							ready = false;
						}
						else
							lbl_warningName.setVisible(false);
						
						if(personalDoc.isEmpty()){
							lbl_warningNi.setVisible(true);
							ready = false;
						}
						else
							lbl_warningNi.setVisible(false);
						
						if(email.isEmpty()) {
							lbl_warningEmail.setVisible(true);
							ready = false;
						}
						else
							lbl_warningEmail.setVisible(false);
						
						if(address.isEmpty()){
							lbl_warningAddress.setVisible(true);
							ready = false;
						} else {
							lbl_warningAddress.setVisible(false);
						}
						
						if(phone.isEmpty()) {
							lbl_warningPhone.setVisible(true);
							ready = false;
						} else {
							lbl_warningPhone.setVisible(false);
						}
						
						/*if(providedProducts.getSelectedIndex() == -1){
							lbl_warningComponentsProv.setVisible(true);
							ready = false;
						}
						else
							lbl_warningComponentsProv.setVisible(false); */
						
						
						if(ready) 
						{
							if(suppli == null) 
							{
								
								if(myComponents.isEmpty())
								{
									sup = new Supplier(personalDoc, name, phone, address, email, id, deliTime, null);
								}
								
								else 
								{
									sup = new Supplier(personalDoc, name, phone, address, email, id, deliTime, myComponents);
								}
									
								Administration.getInstance().addPerson(sup);
								clean();
							}
						
						
							else 
							{
							
								suppli.setName(name);
								suppli.setNi(personalDoc);
								suppli.setEmail(email);
								suppli.setAddress(address);
								suppli.setPhone(phone);
								suppli.setDeliveryTime(deliTime);
								suppli.setMyComponents(myComponents);
								Administration.getInstance().updatePerson(suppli);
								SupplierList.updateTable();
								dispose();
							}
							
						}

						} 
						catch (Exception e)
						{
							e.printStackTrace();
						}
					}
					
				});
				btn_reg.setActionCommand("OK");
				buttonPane.add(btn_reg);
				getRootPane().setDefaultButton(btn_reg);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
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

		        // Verificar que myComponents no sea null
		        if (suppli.getMyComponents() != null) {
		            myComponents = new ArrayList<>(suppli.getMyComponents()); // si es distinto de null se inicializa con los componentes asociados
		        } else {
		            myComponents = new ArrayList<>();// si es null pues se inicializa la lista de los componentes vacia.
		        }

		        // Crear un array de los IDs de los componentes del suplidor
		        ArrayList<String> selectedIds = new ArrayList<>();
		        for (Component c : myComponents) {
		            selectedIds.add(c.getId());
		        }

		        // Verificar que model no sea null
		        if (model != null) {
		            providedProducts.clearSelection();
		            for (int i = 0; i < model.getSize(); i++) {
		                if (selectedIds.contains(model.getElementAt(i))) {
		                    providedProducts.addSelectionInterval(i, i);
		                }
		            }
		        }
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
			providedProducts.clearSelection();
	        spn_deliveryTime.setValue(1);
	        myComponents.clear();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
