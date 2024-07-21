package Visual;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.border.TitledBorder;

public class Pedido extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdSup;
	private JTextField txtPedido;
	private JTextField textField;

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
		setBounds(100, 100, 701, 445);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("ID Suplidor");
				lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
				lblNewLabel.setBounds(33, 51, 99, 20);
				panel.add(lblNewLabel);
			}
			
			txtIdSup = new JTextField();
			txtIdSup.setFont(new Font("Verdana", Font.PLAIN, 14));
			txtIdSup.setEditable(false);
			txtIdSup.setBounds(33, 84, 164, 26);
			panel.add(txtIdSup);
			txtIdSup.setColumns(10);
			
			JButton btnSearchSup = new JButton("Buscar");
			btnSearchSup.setFont(new Font("Verdana", Font.PLAIN, 14));
			btnSearchSup.setBorder(new RoundedBorder(Color.BLACK,1,20));
			btnSearchSup.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnSearchSup.setBounds(264, 83, 99, 29);
			panel.add(btnSearchSup);
			
			JPanel pnlRefillInfo = new JPanel();
			pnlRefillInfo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlRefillInfo.setBounds(388, 23, 264, 210);
			panel.add(pnlRefillInfo);
			pnlRefillInfo.setLayout(null);
			
			JLabel lblIdPedido = new JLabel("ID Pedido");
			lblIdPedido.setFont(new Font("Verdana", Font.BOLD, 14));
			lblIdPedido.setBounds(26, 25, 99, 20);
			pnlRefillInfo.add(lblIdPedido);
			
			txtPedido = new JTextField();
			txtPedido.setFont(new Font("Verdana", Font.PLAIN, 14));
			txtPedido.setEditable(false);
			txtPedido.setColumns(10);
			txtPedido.setBounds(26, 58, 164, 26);
			pnlRefillInfo.add(txtPedido);
			
			JLabel lblFechaRealizado = new JLabel("Fecha Realizado");
			lblFechaRealizado.setFont(new Font("Verdana", Font.BOLD, 14));
			lblFechaRealizado.setBounds(26, 109, 131, 20);
			pnlRefillInfo.add(lblFechaRealizado);
			
			textField = new JTextField();
			textField.setFont(new Font("Verdana", Font.PLAIN, 14));
			textField.setEditable(false);
			textField.setColumns(10);
			textField.setBounds(26, 145, 164, 26);
			pnlRefillInfo.add(textField);
			
			JLabel lblComponentes = new JLabel("Componentes");
			lblComponentes.setFont(new Font("Verdana", Font.BOLD, 14));
			lblComponentes.setBounds(33, 170, 115, 20);
			panel.add(lblComponentes);
			
			JButton btnSearchComp = new JButton("Buscar");
			btnSearchComp.setFont(new Font("Verdana", Font.PLAIN, 14));
			btnSearchComp.setBounds(264, 166, 99, 29);
			btnSearchComp.setBorder(new RoundedBorder(Color.BLACK,1,20));
			panel.add(btnSearchComp);
			
			JPanel pnlComponents = new JPanel();
			pnlComponents.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlComponents.setBounds(33, 203, 330, 165);
			panel.add(pnlComponents);
			pnlComponents.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			pnlComponents.add(scrollPane, BorderLayout.CENTER);
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 14));
			btnCancelar.setBounds(515, 339, 99, 29);
			btnCancelar.setBorder(new RoundedBorder(Color.BLACK,1,20));
			panel.add(btnCancelar);
			
			JButton btnRealizarPedido = new JButton("Pedir");
			btnRealizarPedido.setFont(new Font("Verdana", Font.PLAIN, 14));
			btnRealizarPedido.setBounds(388, 339, 115, 29);
			btnRealizarPedido.setBorder(new RoundedBorder(Color.BLACK,1,20));
			panel.add(btnRealizarPedido);
		}
	}
}
