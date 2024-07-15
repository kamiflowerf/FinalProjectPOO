package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Pedido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Pedido dialog = new Pedido();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Pedido() {
		setTitle("Pedido");
		setBounds(100, 100, 750, 458);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("ID: ");
				lblNewLabel.setBounds(15, 87, 28, 20);
				panel.add(lblNewLabel);
			}
			
			textField = new JTextField();
			textField.setBounds(58, 84, 115, 26);
			panel.add(textField);
			textField.setColumns(10);
			
			JButton searchBtn = new JButton("Buscar");
			searchBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			searchBtn.setBounds(188, 83, 99, 29);
			panel.add(searchBtn);
			
			JLabel lblNewLabel_1 = new JLabel("Cantidad:");
			lblNewLabel_1.setBounds(15, 152, 69, 20);
			panel.add(lblNewLabel_1);
			
			JSpinner cantSnp = new JSpinner();
			cantSnp.setBounds(104, 149, 108, 26);
			panel.add(cantSnp);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(318, 97, 385, 165);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 385, 165);
			panel_1.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			
			JLabel lblNewLabel_2 = new JLabel("Total:");
			lblNewLabel_2.setBounds(318, 291, 53, 20);
			panel.add(lblNewLabel_2);
			
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setBounds(386, 288, 146, 26);
			panel.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Carrito");
			lblNewLabel_3.setBounds(318, 71, 69, 20);
			panel.add(lblNewLabel_3);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Realizar pedido");
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
