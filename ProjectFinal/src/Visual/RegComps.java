package Visual;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import logic.IdGenerator;

import java.awt.Color;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegComps extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JRadioButton rdbtnMotherBoard;
	private JRadioButton rdbtnMicro;
	private JRadioButton rdbtnRAM;
	private JRadioButton rdbtnHardDisk;
	private JTextField txtIdMB;
	private JTextField txtBrand;
	private JPanel pnlMB;
	private JTextField txtModelMB;
	private JTextField txtSocketMB;
	private JTextField txtRamTypeMB;
	private JTextField txtTypeRAM;
	private JTextField txtModelMicro;
	private JTextField txtSocketMicro;
	private JTextField txtSpeedMicro;
	private JTextField txtModelHD;
	private JPanel pnlRAM;
	private JPanel pnlMicroP;
	private JPanel pnlHardDisk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegComps dialog = new RegComps();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	/**
	 * 
	 */
	public RegComps() {
		setTitle("Registrar Componentes");
		setBounds(100, 100, 772, 523);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setFont(new Font("Verdana", Font.PLAIN,15));
			
			contentPanel.add(tabbedPane, BorderLayout.CENTER);
			{
				JPanel pnlComponents = new JPanel();
				pnlComponents.setBorder(new RoundedBorder(Color.BLACK, 1, 5));
				tabbedPane.addTab("Componente", null, pnlComponents, null);
				pnlComponents.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("Componente");
				lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 15));
				lblNewLabel.setBounds(31, 27, 114, 16);
				pnlComponents.add(lblNewLabel);
				
				JPanel pnlCompSelect = new JPanel();
				pnlCompSelect.setBounds(12, 50, 328, 99);
				pnlComponents.add(pnlCompSelect);
				pnlCompSelect.setBorder(new RoundedBorder(Color.BLACK,1,20));
				pnlCompSelect.setLayout(null);
				
				rdbtnMotherBoard = new JRadioButton("Tarjeta Madre");
				rdbtnMotherBoard.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rdbtnMotherBoard.setSelected(true);
						rdbtnHardDisk.setSelected(false);
						rdbtnMicro.setSelected(false);
						rdbtnRAM.setSelected(false);
						pnlMB.setVisible(true);
						pnlRAM.setVisible(false);
						pnlMicroP.setVisible(false);
						pnlHardDisk.setVisible(false);
					}
				});
				rdbtnMotherBoard.setSelected(true);
				rdbtnMotherBoard.setFont(new Font("Verdana", Font.PLAIN, 14));
				rdbtnMotherBoard.setBounds(8, 16, 127, 25);
				pnlCompSelect.add(rdbtnMotherBoard);
				
				rdbtnMicro = new JRadioButton("Microprocesador");
				rdbtnMicro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rdbtnMotherBoard.setSelected(false);
						rdbtnHardDisk.setSelected(false);
						rdbtnMicro.setSelected(true);
						rdbtnRAM.setSelected(false);
						pnlMB.setVisible(false);
						pnlRAM.setVisible(false);
						pnlMicroP.setVisible(true);
						pnlHardDisk.setVisible(false);
					}
				});
				rdbtnMicro.setFont(new Font("Verdana", Font.PLAIN, 14));
				rdbtnMicro.setBounds(8, 57, 143, 25);
				pnlCompSelect.add(rdbtnMicro);
				
				rdbtnRAM = new JRadioButton("Memoria RAM");
				rdbtnRAM.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rdbtnMotherBoard.setSelected(false);
						rdbtnHardDisk.setSelected(false);
						rdbtnMicro.setSelected(false);
						rdbtnRAM.setSelected(true);
						pnlMB.setVisible(false);
						pnlRAM.setVisible(true);
						pnlMicroP.setVisible(false);
						pnlHardDisk.setVisible(false);
					}
				});
				rdbtnRAM.setFont(new Font("Verdana", Font.PLAIN, 14));
				rdbtnRAM.setBounds(160, 17, 127, 25);
				pnlCompSelect.add(rdbtnRAM);
				
				rdbtnHardDisk = new JRadioButton("Disco Duro");
				rdbtnHardDisk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rdbtnMotherBoard.setSelected(false);
						rdbtnHardDisk.setSelected(true);
						rdbtnMicro.setSelected(false);
						rdbtnRAM.setSelected(false);
						pnlMB.setVisible(false);
						pnlRAM.setVisible(false);
						pnlMicroP.setVisible(false);
						pnlHardDisk.setVisible(true);
					}
				});
				rdbtnHardDisk.setFont(new Font("Verdana", Font.PLAIN, 14));
				rdbtnHardDisk.setBounds(160, 58, 127, 25);
				pnlCompSelect.add(rdbtnHardDisk);
				
				JLabel lblDatos = new JLabel("Datos");
				lblDatos.setFont(new Font("Verdana", Font.BOLD, 15));
				lblDatos.setBounds(31, 175, 59, 16);
				pnlComponents.add(lblDatos);
				
				JPanel infoPnl = new JPanel();
				infoPnl.setBorder(new RoundedBorder(Color.BLACK,1,20));
				infoPnl.setBounds(12, 200, 719, 194);
				pnlComponents.add(infoPnl);
				infoPnl.setLayout(null);
				
				JLabel lblNewLabel_2 = new JLabel("ID: ");
				lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblNewLabel_2.setBounds(64, 26, 28, 16);
				infoPnl.add(lblNewLabel_2);
				
				txtIdMB = new JTextField();
				txtIdMB.setFont(new Font("Verdana", Font.PLAIN, 15));
				txtIdMB.setEditable(false);
				txtIdMB.setText(IdGenerator.generateId());
				txtIdMB.setBounds(98, 21, 122, 22);
				infoPnl.add(txtIdMB);
				txtIdMB.setColumns(10);
				
				JLabel lblMarca = new JLabel("Marca:");
				lblMarca.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblMarca.setBounds(34, 68, 58, 16);
				infoPnl.add(lblMarca);
				
				JLabel lblPrecio = new JLabel("Precio:");
				lblPrecio.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblPrecio.setBounds(34, 110, 58, 16);
				infoPnl.add(lblPrecio);
				
				txtBrand = new JTextField();
				txtBrand.setFont(new Font("Verdana", Font.PLAIN, 15));
				txtBrand.setBounds(98, 64, 145, 22);
				infoPnl.add(txtBrand);
				txtBrand.setColumns(10);
				
				JSpinner spnPrice = new JSpinner();
				spnPrice.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
				spnPrice.setFont(new Font("Verdana", Font.PLAIN, 15));
				spnPrice.setBounds(98, 107, 145, 22);
				infoPnl.add(spnPrice);
				
				JLabel lblUnidades = new JLabel("Unidades:");
				lblUnidades.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblUnidades.setBounds(12, 152, 80, 16);
				infoPnl.add(lblUnidades);
				
				JSpinner spnUnits = new JSpinner();
				spnUnits.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
				spnUnits.setFont(new Font("Verdana", Font.PLAIN, 15));
				spnUnits.setBounds(98, 150, 104, 22);
				infoPnl.add(spnUnits);
				
				pnlMB = new JPanel();
				pnlMB.setBounds(255, 13, 452, 168);
				infoPnl.add(pnlMB);
				pnlMB.setLayout(null);
				
				JLabel lblModelo = new JLabel("Modelo:");
				lblModelo.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblModelo.setBounds(27, 30, 66, 16);
				pnlMB.add(lblModelo);
				
				JLabel lblSocket = new JLabel("Socket: ");
				lblSocket.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblSocket.setBounds(27, 76, 66, 16);
				pnlMB.add(lblSocket);
				
				JLabel lblRamCompatible = new JLabel("Tipo RAM: ");
				lblRamCompatible.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblRamCompatible.setBounds(12, 122, 81, 16);
				pnlMB.add(lblRamCompatible);
				
				txtModelMB = new JTextField();
				txtModelMB.setBounds(90, 25, 116, 22);
				pnlMB.add(txtModelMB);
				txtModelMB.setColumns(10);
				
				txtSocketMB = new JTextField();
				txtSocketMB.setColumns(10);
				txtSocketMB.setBounds(90, 72, 116, 22);
				pnlMB.add(txtSocketMB);
				
				txtRamTypeMB = new JTextField();
				txtRamTypeMB.setColumns(10);
				txtRamTypeMB.setBounds(90, 119, 116, 22);
				pnlMB.add(txtRamTypeMB);
				
				JLabel lblConexionesDeDisco = new JLabel("Conexiones de Disco Duro:");
				lblConexionesDeDisco.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblConexionesDeDisco.setBounds(218, 30, 222, 16);
				pnlMB.add(lblConexionesDeDisco);
				
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(218, 47, 222, 85);
				pnlMB.add(panel_1);
				panel_1.setLayout(null);
				
				JCheckBox chckbxIdeMB = new JCheckBox("IDE");
				chckbxIdeMB.setFont(new Font("Verdana", Font.PLAIN, 15));
				chckbxIdeMB.setBounds(8, 11, 74, 25);
				panel_1.add(chckbxIdeMB);
				
				JCheckBox chckbxSataMB = new JCheckBox("SATA");
				chckbxSataMB.setFont(new Font("Verdana", Font.PLAIN, 15));
				chckbxSataMB.setBounds(8, 47, 74, 25);
				panel_1.add(chckbxSataMB);
				
				JCheckBox chckbxSata2MB = new JCheckBox("SATA-2");
				chckbxSata2MB.setFont(new Font("Verdana", Font.PLAIN, 15));
				chckbxSata2MB.setBounds(101, 11, 101, 25);
				panel_1.add(chckbxSata2MB);
				
				JCheckBox chckbxSata3MB = new JCheckBox("SATA-3");
				chckbxSata3MB.setFont(new Font("Verdana", Font.PLAIN, 15));
				chckbxSata3MB.setBounds(101, 47, 101, 25);
				panel_1.add(chckbxSata3MB);
				
				pnlRAM = new JPanel();
				pnlRAM.setBounds(255, 13, 452, 168);
				pnlRAM.setVisible(false);
				infoPnl.add(pnlRAM);
				pnlRAM.setLayout(null);
				
				JLabel lblCapacidad = new JLabel("Capacidad:");
				lblCapacidad.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblCapacidad.setBounds(20, 45, 83, 16);
				pnlRAM.add(lblCapacidad);
				
				JSpinner spnCapacityRAM = new JSpinner();
				spnCapacityRAM.setModel(new SpinnerNumberModel(new Integer(4), new Integer(4), null, new Integer(1)));
				spnCapacityRAM.setFont(new Font("Verdana", Font.PLAIN, 15));
				spnCapacityRAM.setBounds(121, 41, 63, 22);
				pnlRAM.add(spnCapacityRAM);
				
				JLabel lblMeasureRAM = new JLabel("GB");
				lblMeasureRAM.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblMeasureRAM.setBounds(189, 47, 28, 16);
				pnlRAM.add(lblMeasureRAM);
				
				JLabel lblTipo = new JLabel("Tipo:");
				lblTipo.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblTipo.setBounds(65, 106, 38, 16);
				pnlRAM.add(lblTipo);
				
				txtTypeRAM = new JTextField();
				txtTypeRAM.setBounds(121, 104, 116, 22);
				pnlRAM.add(txtTypeRAM);
				txtTypeRAM.setColumns(10);
				
				pnlMicroP = new JPanel();
				pnlMicroP.setBounds(255, 13, 452, 168);
				pnlMicroP.setVisible(false);
				infoPnl.add(pnlMicroP);
				pnlMicroP.setLayout(null);
				
				JLabel label = new JLabel("Modelo:");
				label.setFont(new Font("Verdana", Font.PLAIN, 15));
				label.setBounds(27, 30, 66, 16);
				pnlMicroP.add(label);
				
				JLabel label_1 = new JLabel("Socket: ");
				label_1.setFont(new Font("Verdana", Font.PLAIN, 15));
				label_1.setBounds(27, 76, 66, 16);
				pnlMicroP.add(label_1);
				
				JLabel lblVelocidad = new JLabel("Velocidad:");
				lblVelocidad.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblVelocidad.setBounds(12, 122, 81, 16);
				pnlMicroP.add(lblVelocidad);
				
				txtModelMicro = new JTextField();
				txtModelMicro.setColumns(10);
				txtModelMicro.setBounds(105, 25, 116, 22);
				pnlMicroP.add(txtModelMicro);
				
				txtSocketMicro = new JTextField();
				txtSocketMicro.setColumns(10);
				txtSocketMicro.setBounds(105, 72, 116, 22);
				pnlMicroP.add(txtSocketMicro);
				
				txtSpeedMicro = new JTextField();
				txtSpeedMicro.setColumns(10);
				txtSpeedMicro.setBounds(105, 120, 116, 22);
				pnlMicroP.add(txtSpeedMicro);
				
				JLabel lblMeasureMicro = new JLabel("GHz");
				lblMeasureMicro.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblMeasureMicro.setBounds(226, 126, 32, 16);
				pnlMicroP.add(lblMeasureMicro);
				
				pnlHardDisk = new JPanel();
				pnlHardDisk.setBounds(255, 13, 452, 168);
				pnlHardDisk.setVisible(false);
				infoPnl.add(pnlHardDisk);
				pnlHardDisk.setLayout(null);
				
				JLabel label_2 = new JLabel("Modelo:");
				label_2.setFont(new Font("Verdana", Font.PLAIN, 15));
				label_2.setBounds(34, 30, 61, 16);
				pnlHardDisk.add(label_2);
				
				JLabel lblCapacidad_1 = new JLabel("Capacidad:");
				lblCapacidad_1.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblCapacidad_1.setBounds(12, 76, 83, 16);
				pnlHardDisk.add(lblCapacidad_1);
				
				JLabel lblConexin = new JLabel("Conexi\u00F3n:");
				lblConexin.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblConexin.setBounds(18, 122, 77, 16);
				pnlHardDisk.add(lblConexin);
				
				txtModelHD = new JTextField();
				txtModelHD.setColumns(10);
				txtModelHD.setBounds(107, 28, 116, 22);
				pnlHardDisk.add(txtModelHD);
				
				JSpinner spnCapacityHD = new JSpinner();
				spnCapacityHD.setModel(new SpinnerNumberModel(new Integer(500), new Integer(500), null, new Integer(1)));
				spnCapacityHD.setFont(new Font("Verdana", Font.PLAIN, 15));
				spnCapacityHD.setBounds(107, 74, 83, 22);
				pnlHardDisk.add(spnCapacityHD);
				
				JLabel lblMeasureHD = new JLabel("GB");
				lblMeasureHD.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblMeasureHD.setBounds(195, 80, 28, 16);
				pnlHardDisk.add(lblMeasureHD);
				
				JComboBox<String> comboBox = new JComboBox<String>();
				comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccionar>", "IDE", "SATA", "SATA-2", "SATA-3"}));
				comboBox.setFont(new Font("Verdana", Font.PLAIN, 15));
				comboBox.setBounds(107, 120, 139, 22);
				pnlHardDisk.add(comboBox);
				
				JPanel iconPane = new JPanel();
				iconPane.setBackground(new Color(176, 224, 230));
				iconPane.setBorder(new RoundedBorder(Color.BLACK,1,20));
				iconPane.setBounds(399, 27, 154, 160);
				pnlComponents.add(iconPane);
				
				JButton btnCancel = new JButton("Cancelar");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				
				btnCancel.setFont(new Font("Verdana", Font.PLAIN, 15));
				btnCancel.setBounds(634, 407, 97, 25);
				btnCancel.setBorder(new RoundedBorder (Color.BLACK, 1, 25));
				pnlComponents.add(btnCancel);
				
				JButton btnReg = new JButton("Registrar");
				btnReg.setFont(new Font("Verdana", Font.PLAIN, 15));
				btnReg.setBorder(new RoundedBorder (Color.BLACK, 1, 25));
				btnReg.setBounds(525, 407, 97, 25);
				pnlComponents.add(btnReg);
			}
			{
				JPanel pnlCombos = new JPanel();
				pnlCombos.setBorder(new RoundedBorder(Color.BLACK,1,5));
				tabbedPane.addTab("Combo", null, pnlCombos, null);
				pnlCombos.setLayout(null);
				
				JLabel lblNewLabel_1 = new JLabel("tab 2");
				lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(327, 162, 56, 16);
				pnlCombos.add(lblNewLabel_1);
			}
		}
	}
}
