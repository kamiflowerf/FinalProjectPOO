package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logic.Administration;
import logic.User;

public class RegUser extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_Username;
	private JTextField txtPassword;
	private JPasswordField passwordField;
	private JPasswordField passwordField_originalPassword;
	private JCheckBox chckbxShowPassword;
	private JComboBox<String> cbxUserType;
	private JLabel lblWrongPassword;
	private JLabel lblUserEmptyWarning;
	private JLabel lblEmptyPassword;
	private JLabel lblPasswordConfirmationWarning;
	private JLabel lblSelectionWarning;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegUser dialog = new RegUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegUser() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegUser.class.getResource("/Images/empleado.png")));
		setTitle("Registro Usuario");
		setResizable(false);
		setBounds(100, 100, 601, 401);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblRegUser = new JLabel("Informaci\u00F3n del usuario");
			lblRegUser.setFont(new Font("Verdana", Font.BOLD, 14));
			lblRegUser.setBounds(195, 33, 190, 16);
			panel.add(lblRegUser);
			
			JLabel lblUserName = new JLabel("Usuario:");
			lblUserName.setFont(new Font("Verdana", Font.PLAIN, 14));
			lblUserName.setBounds(126, 71, 77, 16);
			panel.add(lblUserName);
			
			JLabel lblPassword = new JLabel("Contrase\u00F1a:");
			lblPassword.setFont(new Font("Verdana", Font.PLAIN, 14));
			lblPassword.setBounds(126, 181, 98, 16);
			panel.add(lblPassword);
			
			JLabel lblUserType = new JLabel("Posici\u00F3n: ");
			lblUserType.setFont(new Font("Verdana", Font.PLAIN, 14));
			lblUserType.setBounds(373, 71, 77, 16);
			panel.add(lblUserType);
			
			JLabel lblPasswrdConfirmation = new JLabel("Confirmar contrase\u00F1a:");
			lblPasswrdConfirmation.setFont(new Font("Verdana", Font.PLAIN, 14));
			lblPasswrdConfirmation.setBounds(326, 181, 178, 16);
			panel.add(lblPasswrdConfirmation);
			
			txt_Username = new JTextField();
			txt_Username.setBounds(102, 115, 139, 22);
			panel.add(txt_Username);
			txt_Username.setColumns(10);
			
			cbxUserType = new JComboBox<String>();
			cbxUserType.setFont(new Font("Verdana", Font.PLAIN, 14));
			cbxUserType.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleci\u00F3n>", "Administrador", "Empleado"}));
			cbxUserType.setBounds(343, 115, 139, 22);
			panel.add(cbxUserType);
			
			chckbxShowPassword = new JCheckBox("Mostrar contrase\u00F1a");
			chckbxShowPassword.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if (chckbxShowPassword.isSelected()) 
					{
                        txtPassword.setText(new String(passwordField_originalPassword.getPassword()));
                        passwordField_originalPassword.setVisible(false);
                        txtPassword.setVisible(true);
                    } 
					else 
                    {
                        passwordField_originalPassword.setText(txtPassword.getText());
                        txtPassword.setVisible(false);
                        passwordField_originalPassword.setVisible(true);
                    }
				}
			});
			chckbxShowPassword.setBounds(95, 250, 156, 25);
			panel.add(chckbxShowPassword);
			
			passwordField = new JPasswordField();
			passwordField.setFont(new Font("Verdana", Font.PLAIN, 14));
			passwordField.setBounds(343, 219, 139, 22);
			panel.add(passwordField);
			
			lblWrongPassword = new JLabel("Las contrase\u00F1as no coinciden!");
			lblWrongPassword.setForeground(Color.RED);
			lblWrongPassword.setFont(new Font("Verdana", Font.BOLD, 12));
			lblWrongPassword.setBounds(326, 254, 212, 16);
			lblWrongPassword.setVisible(false);
			panel.add(lblWrongPassword);
			
			passwordField_originalPassword = new JPasswordField();
			passwordField_originalPassword.setBounds(102, 220, 139, 22);
			panel.add(passwordField_originalPassword);
			
			txtPassword = new JTextField();
			txtPassword.setBounds(102, 220, 139, 22);
			panel.add(txtPassword);
			txtPassword.setColumns(10);
			
			lblUserEmptyWarning = new JLabel("El campo no puede estar vac\u00EDo!");
			lblUserEmptyWarning.setForeground(Color.RED);
			lblUserEmptyWarning.setFont(new Font("Verdana", Font.BOLD, 12));
			lblUserEmptyWarning.setBounds(65, 150, 212, 16);
			lblUserEmptyWarning.setVisible(false);
			panel.add(lblUserEmptyWarning);
			
			lblSelectionWarning = new JLabel("Debe seleccionar una opci\u00F3n!");
			lblSelectionWarning.setForeground(Color.RED);
			lblSelectionWarning.setFont(new Font("Verdana", Font.BOLD, 12));
			lblSelectionWarning.setBounds(326, 150, 212, 16);
			lblSelectionWarning.setVisible(false);
			panel.add(lblSelectionWarning);
			
			lblEmptyPassword = new JLabel("El campo no puede estar vac\u00EDo!");
			lblEmptyPassword.setForeground(Color.RED);
			lblEmptyPassword.setFont(new Font("Verdana", Font.BOLD, 12));
			lblEmptyPassword.setBounds(65, 283, 212, 16);
			lblEmptyPassword.setVisible(false);
			panel.add(lblEmptyPassword);
			
			lblPasswordConfirmationWarning = new JLabel("El campo no puede estar vac\u00EDo!");
			lblPasswordConfirmationWarning.setForeground(Color.RED);
			lblPasswordConfirmationWarning.setFont(new Font("Verdana", Font.BOLD, 12));
			lblPasswordConfirmationWarning.setBounds(326, 283, 212, 16);
			lblPasswordConfirmationWarning.setVisible(false);
			panel.add(lblPasswordConfirmationWarning);
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_regUser = new JButton("Registrar");
				btn_regUser.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String user = txt_Username.getText();
						String password;
						String type = new String(cbxUserType.getSelectedItem().toString());
						if(chckbxShowPassword.isSelected())
						{
							password = txtPassword.getText();
						}
						else
						{
							password = new String(passwordField_originalPassword.getPassword());
						}
						boolean ready = verifyFields();
						
						if(ready)
						{
							User newUser = new User (type,user,password);
							Administration.getInstance().regUser(newUser);
							JOptionPane.showMessageDialog(null, "Operación satisfactoriamente completada.", "Registro Usuario", JOptionPane.INFORMATION_MESSAGE);
							clean();
						}
					}
				});
				btn_regUser.setPreferredSize(new Dimension(85, 30));
				btn_regUser.setBorder(new RoundedBorder(Color.BLACK,1,25));
				btn_regUser.setActionCommand("OK");
				buttonPane.add(btn_regUser);
				getRootPane().setDefaultButton(btn_regUser);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setPreferredSize(new Dimension(85, 30));
				cancelButton.setBorder(new RoundedBorder(Color.BLACK,1,25));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void clean() {
		
		txt_Username.setText("");
		cbxUserType.setSelectedIndex(0);
		txtPassword.setText("");
		passwordField_originalPassword.setText("");
		chckbxShowPassword.setSelected(false);
		passwordField.setText("");
	}

	private boolean verifyFields() {
	    boolean isValid = true;
	    
	    String user = txt_Username.getText();
	    String password;
	    String confirmation = new String(passwordField.getPassword());

	    if (chckbxShowPassword.isSelected()) {
	        password = txtPassword.getText();
	    } else {
	        password = new String(passwordField_originalPassword.getPassword());
	    }

	    boolean passwordsMatch = password.equals(confirmation);
	    lblWrongPassword.setVisible(!passwordsMatch);

	    // Verificación del campo de usuario
	    if (user.isEmpty()) {
	        lblUserEmptyWarning.setVisible(true);
	        isValid = false;
	    } else {
	        lblUserEmptyWarning.setVisible(false);
	    }

	    // Verificación de la contraseña
	    if (password.isEmpty()) {
	        lblEmptyPassword.setVisible(true);
	        isValid = false;
	    } else {
	        lblEmptyPassword.setVisible(false);
	    }

	    // Verificación de la confirmación de contraseña
	    if (confirmation.isEmpty()) {
	        lblPasswordConfirmationWarning.setVisible(true);
	        isValid = false;
	    } else {
	        lblPasswordConfirmationWarning.setVisible(false);
	    }

	    // Verificación de coincidencia de contraseñas
	    if (!passwordsMatch) {
	        lblWrongPassword.setVisible(true);
	        isValid = false;
	    } else {
	        lblWrongPassword.setVisible(false);
	    }

	    // Verificación del tipo de usuario
	    if (cbxUserType.getSelectedIndex() == 0) {
	        lblSelectionWarning.setVisible(true);
	        isValid = false;
	    } else {
	        lblSelectionWarning.setVisible(false);
	    }

	    return isValid;
	}

}
