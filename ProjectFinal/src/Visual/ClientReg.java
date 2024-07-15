package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ClientReg extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_clientId;
	private JTextField txt_clientName;
	private JTextField txt_clientPersonalDoc;
	private JTextField txt_clientEmail;
	private JTextField txt_clientAdress;
	private JTextField txt_clientPhoneNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ClientReg dialog = new ClientReg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ClientReg() {
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
			
			JLabel lbl_clientAdress = new JLabel("Direcci\u00F3n:");
			lbl_clientAdress.setBounds(12, 306, 70, 16);
			panel_1.add(lbl_clientAdress);
			
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
			txt_clientId.setBounds(139, 55, 148, 22);
			panel_1.add(txt_clientId);
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
			
			txt_clientAdress = new JTextField();
			txt_clientAdress.setBounds(139, 299, 148, 22);
			panel_1.add(txt_clientAdress);
			txt_clientAdress.setColumns(10);
			
			txt_clientPhoneNum = new JTextField();
			txt_clientPhoneNum.setBounds(139, 360, 148, 22);
			panel_1.add(txt_clientPhoneNum);
			txt_clientPhoneNum.setColumns(10);
			
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
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
