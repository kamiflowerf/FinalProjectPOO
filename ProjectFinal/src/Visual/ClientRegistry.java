package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logic.Administration;
import logic.Client;
import logic.IdGenerator;

public class ClientRegistry extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_clientId;
	private JTextField txt_clientName;
	private JTextField txt_clientPersonalDoc;
	private JTextField txt_clientEmail;
	private JTextField txt_clientAddress;
	private JTextField txt_clientPhoneNum;
	private JLabel lbl_warningName;
	private JLabel lbl_warningPersonalDoc;
	private JLabel lbl_warningEmail;
	private JLabel lbl_warningAddress;
	private JLabel lbl_warningPhoneNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ClientRegistry dialog = new ClientRegistry(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ClientRegistry(Client client) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Registro Cliente");
		setResizable(false);
		setBounds(100, 100, 691, 566);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(336, 38, 299, 409);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lbl_clientInfo = new JLabel("Informaci\u00F3n del Cliente:");
			lbl_clientInfo.setBounds(91, 13, 142, 16);
			panel_1.add(lbl_clientInfo);
			
			JLabel lbl_clientId = new JLabel("Id:");
			lbl_clientId.setBounds(12, 66, 56, 16);
			panel_1.add(lbl_clientId);
			
			JLabel lbl_clientName = new JLabel("Nombre:");
			lbl_clientName.setBounds(12, 126, 56, 16);
			panel_1.add(lbl_clientName);
			
			JLabel lbl_clientAddress = new JLabel("Direcci\u00F3n:");
			lbl_clientAddress.setBounds(12, 306, 70, 16);
			panel_1.add(lbl_clientAddress);
			
			JLabel lbl_clientPersonalDoc = new JLabel("C\u00E9dula:");
			lbl_clientPersonalDoc.setBounds(12, 186, 56, 16);
			panel_1.add(lbl_clientPersonalDoc);
			
			JLabel lbl_clientEmail = new JLabel("Correo electr\u00F3nico:");
			lbl_clientEmail.setBounds(13, 246, 110, 16);
			panel_1.add(lbl_clientEmail);
			
			JLabel lbl_clientPhoneNum = new JLabel("Tel\u00E9fono:");
			lbl_clientPhoneNum.setBounds(12, 366, 56, 16);
			panel_1.add(lbl_clientPhoneNum);
			
			txt_clientId = new JTextField();
			txt_clientId.setEditable(false);
			txt_clientId.setBounds(139, 55, 148, 22);
			panel_1.add(txt_clientId);
			txt_clientId.setText(IdGenerator.generateId());
			txt_clientId.setColumns(10);    
			
			txt_clientName = new JTextField();
			txt_clientName.setBounds(139, 123, 148, 22);
			panel_1.add(txt_clientName);
			txt_clientName.setColumns(10);
			
			txt_clientPersonalDoc = new JTextField();
			txt_clientPersonalDoc.setBounds(139, 183, 148, 22);
			panel_1.add(txt_clientPersonalDoc);
			txt_clientPersonalDoc.setColumns(10);
			
			txt_clientEmail = new JTextField();
			txt_clientEmail.setBounds(139, 238, 148, 22);
			panel_1.add(txt_clientEmail);
			txt_clientEmail.setColumns(10);
			
			txt_clientAddress = new JTextField();
			txt_clientAddress.setBounds(139, 299, 148, 22);
			panel_1.add(txt_clientAddress);
			txt_clientAddress.setColumns(10);
			
			txt_clientPhoneNum = new JTextField();
			txt_clientPhoneNum.setBounds(139, 360, 148, 22);
			panel_1.add(txt_clientPhoneNum);
			txt_clientPhoneNum.setColumns(10);
			
			lbl_warningName = new JLabel("ESTE CAMPO ES OBLIGATORIO");
			lbl_warningName.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbl_warningName.setForeground(Color.RED);
			lbl_warningName.setBounds(91, 154, 208, 16);
			panel_1.add(lbl_warningName);
			lbl_warningName.setVisible(false);
			
			lbl_warningPersonalDoc = new JLabel("ESTE CAMPO ES OBLIGATORIO");
			lbl_warningPersonalDoc.setForeground(Color.RED);
			lbl_warningPersonalDoc.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbl_warningPersonalDoc.setBounds(91, 217, 208, 16);
			panel_1.add(lbl_warningPersonalDoc);
			lbl_warningPersonalDoc.setVisible(false);
			
			lbl_warningEmail = new JLabel("ESTE CAMPO ES OBLIGATORIO");
			lbl_warningEmail.setForeground(Color.RED);
			lbl_warningEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbl_warningEmail.setBounds(91, 270, 208, 16);
			panel_1.add(lbl_warningEmail);
			lbl_warningEmail.setVisible(false);
			
			lbl_warningAddress = new JLabel("ESTE CAMPO ES OBLIGATORIO");
			lbl_warningAddress.setForeground(Color.RED);
			lbl_warningAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbl_warningAddress.setBounds(91, 331, 208, 16);
			panel_1.add(lbl_warningAddress);
			lbl_warningAddress.setVisible(false);
			
			lbl_warningPhoneNum = new JLabel("ESTE CAMPO ES OBLIGATORIO");
			lbl_warningPhoneNum.setForeground(Color.RED);
			lbl_warningPhoneNum.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbl_warningPhoneNum.setBounds(91, 393, 208, 16);
			panel_1.add(lbl_warningPhoneNum);
			lbl_warningPhoneNum.setVisible(false);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(24, 38, 274, 409);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JLabel foto = new JLabel("foto");
			foto.setBounds(116, 213, 56, 16);
			panel_2.add(foto);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						String id = txt_clientId.getText();
						String name = txt_clientName.getText();
						String personalDoc = txt_clientPersonalDoc.getText();
						String address = txt_clientAddress.getText();
						String email = txt_clientEmail.getText();
						String phoneNum = txt_clientPhoneNum.getText();
						boolean ready = true;
						
						if(name.isEmpty()){
							lbl_warningName.setVisible(true);
							ready = false;
						} else {
							lbl_warningName.setVisible(false);
						}
						
						if(personalDoc.isEmpty()){
							lbl_warningPersonalDoc.setVisible(true);
							ready = false;
						} else {
							lbl_warningPersonalDoc.setVisible(false);
						}
						
						if(address.isEmpty()){
							lbl_warningAddress.setVisible(true);
							ready = false;
						} else {
							lbl_warningAddress.setVisible(false);
						}
														
						if(email.isEmpty()) {
							lbl_warningEmail.setVisible(true);
							ready = false;
						} else {
							lbl_warningEmail.setVisible(false);
						}
						
						if(phoneNum.isEmpty()) {
							lbl_warningPhoneNum.setVisible(true);
							ready = false;
						} else {
							lbl_warningPhoneNum.setVisible(false);
						}
						
						if(ready) {
							if(client == null) {
								Client newClient = new Client(personalDoc, name, phoneNum, address, email, id);
								Administration.getInstance().addPerson(newClient);
								clean();
							} else {
								client.setName(name);
								client.setNi(personalDoc);
								client.setEmail(email);
								client.setAddress(address);
								client.setPhone(phoneNum);
								Administration.getInstance().updatePerson(client);
								dispose();
							}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
		
		loadClient(client);
	}
	
	private void loadClient(Client client) {
		if(client != null) {
			txt_clientId.setText(client.getId());
			txt_clientName.setText(client.getName());
			txt_clientPersonalDoc.setText(client.getNi());
			txt_clientEmail.setText(client.getEmail());
			txt_clientAddress.setText(client.getAddress());
			txt_clientPhoneNum.setText(client.getPhone());
		} 
	}

	private void clean() {
		txt_clientId.setText(IdGenerator.generateId());
		txt_clientName.setText("");
		txt_clientPersonalDoc.setText("");
		txt_clientEmail.setText("");
		txt_clientAddress.setText("");
		txt_clientPhoneNum.setText("");
	}
}
