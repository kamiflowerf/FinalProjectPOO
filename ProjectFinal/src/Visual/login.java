package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logic.Administration;
import logic.User;

public class login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream empresa;
				FileOutputStream empresa2;
				ObjectInputStream empresaRead;
				ObjectOutputStream empresaWrite;
				try {
					empresa = new FileInputStream ("adkEnterprise.dat");
					empresaRead = new ObjectInputStream(empresa);
					Administration temp = (Administration)empresaRead.readObject();
					Administration.setAdministration(temp);
					empresa.close();
					empresaRead.close();
				} catch (FileNotFoundException e) {
					try {
						empresa2 = new  FileOutputStream("adkEnterprise.dat");
						empresaWrite = new ObjectOutputStream(empresa2);
						User aux = new User("Administrador", "admin", "admin");
						Administration.getInstance().regUser(aux);
						empresaWrite.writeObject(Administration.getInstance());
						empresa2.close();
						empresaWrite.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 553);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido!");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 27));
		lblNewLabel.setBounds(196, 173, 159, 29);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new RoundedBorder(Color.BLACK, 1, 15));
		panel_1.setBounds(71, 264, 409, 158);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Usuario:");
		label.setFont(new Font("Verdana", Font.PLAIN, 17));
		label.setBounds(45, 42, 72, 16);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Contrase\u00F1a:");
		label_1.setFont(new Font("Verdana", Font.PLAIN, 17));
		label_1.setBounds(12, 100, 105, 16);
		panel_1.add(label_1);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Verdana", Font.PLAIN, 17));
		txtUsername.setBounds(129, 41, 167, 22);
		panel_1.add(txtUsername);
		txtUsername.setColumns(10);
		
		password = new JPasswordField();
		password.setFont(new Font("Verdana", Font.PLAIN, 17));
		password.setBounds(129, 99, 268, 22);
		panel_1.add(password);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char[] passTemp = password.getPassword();
				String pass = new String(passTemp);
				if(Administration.getInstance().confirmLogin(new String (txtUsername.getText()), pass)) {
					User authenticatedUser = Administration.getInstance().getConfirmedUser(new String (txtUsername.getText()), pass);
					Principal frame = new Principal(authenticatedUser);
					dispose();
					frame.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Usuario o contrase�a incorrectos", "Error de inicio de sesi�n", JOptionPane.ERROR_MESSAGE);				
				}
			}
		});
		btnLogin.setBorder(new RoundedBorder(Color.BLACK,1,25));
		btnLogin.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnLogin.setBounds(383, 447, 97, 25);
		panel.add(btnLogin);
	}
}
