package Visual;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import logic.Administration;
import logic.HardDisk;
import logic.IdGenerator;
import logic.MicroProcessor;
import logic.MotherBoard;
import logic.RAM;

import java.awt.Color;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class RegComps extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JRadioButton rdbtnMotherBoard;
	private JRadioButton rdbtnMicro;
	private JRadioButton rdbtnRAM;
	private JRadioButton rdbtnHardDisk;
	private JTextField txtId;
	private JTextField txtBrand;
	private JPanel pnlMB;
	private JTextField txtModelMB;
	private JTextField txtSocketMB;
	private JTextField txtRamTypeMB;
	private JTextField txtTypeRAM;
	private JTextField txtModelMicro;
	private JTextField txtSocketMicro;
	private JTextField txtModelHD;
	private JPanel pnlRAM;
	private JPanel pnlMicroP;
	private JPanel pnlHardDisk;
	private JLabel lblIcon;
	private Image img;
	private JLabel lblWarning;
	private JSpinner spnPrice;
	private JSpinner spnUnits;
	private JCheckBox chckbxIdeMB;
	private JCheckBox chckbxSataMB;
	private JCheckBox chckbxSata2MB;
	private JCheckBox chckbxSata3MB;
	private JSpinner spnSerie;
	private JSpinner spnCapacityRAM;
	private JSpinner spnSpeedMicro;
	private JSpinner spnCapacityHD;
	private JComboBox<String> cbxConType;
	private JButton btnSearch;
	private JTextField txtIdCombo;
	private JTextField textField;

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
		setBounds(100, 100, 772, 552);
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
						setIcon();
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
						setIcon();
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
						setIcon();
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
						setIcon();
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
				infoPnl.setBounds(12, 200, 719, 215);
				pnlComponents.add(infoPnl);
				infoPnl.setLayout(null);
				
				JLabel lblNewLabel_2 = new JLabel("ID: ");
				lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblNewLabel_2.setBounds(64, 22, 28, 16);
				infoPnl.add(lblNewLabel_2);
				
				txtId = new JTextField();
				txtId.setFont(new Font("Verdana", Font.PLAIN, 15));
				txtId.setEditable(false);
				txtId.setText(IdGenerator.generateId());
				txtId.setBounds(98, 17, 122, 22);
				infoPnl.add(txtId);
				txtId.setColumns(10);
				
				JLabel lblMarca = new JLabel("Marca:");
				lblMarca.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblMarca.setBounds(34, 60, 58, 16);
				infoPnl.add(lblMarca);
				
				JLabel lblPrecio = new JLabel("Precio:");
				lblPrecio.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblPrecio.setBounds(34, 98, 58, 16);
				infoPnl.add(lblPrecio);
				
				txtBrand = new JTextField();
				txtBrand.setFont(new Font("Verdana", Font.PLAIN, 15));
				txtBrand.setBounds(98, 56, 145, 22);
				infoPnl.add(txtBrand);
				txtBrand.setColumns(10);
				
				spnPrice = new JSpinner();
				spnPrice.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
				spnPrice.setFont(new Font("Verdana", Font.PLAIN, 15));
				spnPrice.setBounds(98, 95, 145, 22);
				infoPnl.add(spnPrice);
				
				JLabel lblUnidades = new JLabel("Unidades:");
				lblUnidades.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblUnidades.setBounds(12, 136, 80, 16);
				infoPnl.add(lblUnidades);
				
				spnUnits = new JSpinner();
				spnUnits.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
				spnUnits.setFont(new Font("Verdana", Font.PLAIN, 15));
				spnUnits.setBounds(98, 134, 104, 22);
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
				txtModelMB.setFont(new Font("Verdana", Font.PLAIN, 15));
				txtModelMB.setBounds(90, 25, 116, 22);
				pnlMB.add(txtModelMB);
				txtModelMB.setColumns(10);
				
				txtSocketMB = new JTextField();
				txtSocketMB.setFont(new Font("Verdana", Font.PLAIN, 15));
				txtSocketMB.setColumns(10);
				txtSocketMB.setBounds(90, 72, 116, 22);
				pnlMB.add(txtSocketMB);
				
				txtRamTypeMB = new JTextField();
				txtRamTypeMB.setFont(new Font("Verdana", Font.PLAIN, 15));
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
				
				chckbxIdeMB = new JCheckBox("IDE");
				chckbxIdeMB.setFont(new Font("Verdana", Font.PLAIN, 15));
				chckbxIdeMB.setBounds(8, 11, 74, 25);
				panel_1.add(chckbxIdeMB);
				
				chckbxSataMB = new JCheckBox("SATA");
				chckbxSataMB.setFont(new Font("Verdana", Font.PLAIN, 15));
				chckbxSataMB.setBounds(8, 47, 74, 25);
				panel_1.add(chckbxSataMB);
				
				chckbxSata2MB = new JCheckBox("SATA-2");
				chckbxSata2MB.setFont(new Font("Verdana", Font.PLAIN, 15));
				chckbxSata2MB.setBounds(101, 11, 101, 25);
				panel_1.add(chckbxSata2MB);
				
				chckbxSata3MB = new JCheckBox("SATA-3");
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
				
				spnCapacityRAM = new JSpinner();
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
				txtTypeRAM.setFont(new Font("Verdana", Font.PLAIN, 15));
				txtTypeRAM.setBounds(121, 104, 116, 22);
				pnlRAM.add(txtTypeRAM);
				txtTypeRAM.setColumns(10);
				
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
				txtModelHD.setFont(new Font("Verdana", Font.PLAIN, 15));
				txtModelHD.setColumns(10);
				txtModelHD.setBounds(107, 28, 116, 22);
				pnlHardDisk.add(txtModelHD);
				
				spnCapacityHD = new JSpinner();
				spnCapacityHD.setModel(new SpinnerNumberModel(new Integer(500), null, null, new Integer(1)));
				spnCapacityHD.setFont(new Font("Verdana", Font.PLAIN, 15));
				spnCapacityHD.setBounds(107, 74, 83, 22);
				pnlHardDisk.add(spnCapacityHD);
				
				JLabel lblMeasureHD = new JLabel("GB");
				lblMeasureHD.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblMeasureHD.setBounds(195, 80, 28, 16);
				pnlHardDisk.add(lblMeasureHD);
				
				cbxConType = new JComboBox<String>();
				cbxConType.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccionar>", "IDE", "SATA", "SATA-2", "SATA-3"}));
				cbxConType.setFont(new Font("Verdana", Font.PLAIN, 15));
				cbxConType.setBounds(107, 120, 139, 22);
				pnlHardDisk.add(cbxConType);
				
				JLabel lblSerie = new JLabel("Serie:");
				lblSerie.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblSerie.setBounds(41, 174, 51, 16);
				infoPnl.add(lblSerie);
				
				spnSerie = new JSpinner();
				spnSerie.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
				spnSerie.setFont(new Font("Verdana", Font.PLAIN, 15));
				spnSerie.setBounds(98, 173, 104, 22);
				infoPnl.add(spnSerie);
				
				pnlMicroP = new JPanel();
				pnlMicroP.setBounds(255, 13, 452, 168);
				infoPnl.add(pnlMicroP);
				pnlMicroP.setVisible(false);
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
				txtModelMicro.setFont(new Font("Verdana", Font.PLAIN, 15));
				txtModelMicro.setColumns(10);
				txtModelMicro.setBounds(105, 25, 116, 22);
				pnlMicroP.add(txtModelMicro);
				
				txtSocketMicro = new JTextField();
				txtSocketMicro.setFont(new Font("Verdana", Font.PLAIN, 15));
				txtSocketMicro.setColumns(10);
				txtSocketMicro.setBounds(105, 72, 116, 22);
				pnlMicroP.add(txtSocketMicro);
				
				JLabel lblMeasureMicro = new JLabel("GHz");
				lblMeasureMicro.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblMeasureMicro.setBounds(226, 126, 32, 16);
				pnlMicroP.add(lblMeasureMicro);
				
				spnSpeedMicro = new JSpinner();
				spnSpeedMicro.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
				spnSpeedMicro.setFont(new Font("Verdana", Font.PLAIN, 15));
				spnSpeedMicro.setBounds(105, 120, 116, 22);
				pnlMicroP.add(spnSpeedMicro);
				
				JPanel iconPane = new JPanel();
				iconPane.setBackground(new Color(176, 224, 230));
				iconPane.setBorder(new RoundedBorder(Color.BLACK,1,20));
				iconPane.setBounds(399, 27, 154, 160);
				pnlComponents.add(iconPane);
				iconPane.setLayout(null);
				
				lblIcon = new JLabel("");
				lblIcon.setBounds(0, 0, 154, 160);
				setIcon();
				iconPane.add(lblIcon);
				
				JButton btnCancel = new JButton("Cancelar");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				
				btnCancel.setFont(new Font("Verdana", Font.PLAIN, 15));
				btnCancel.setBounds(634, 428, 97, 25);
				btnCancel.setBorder(new RoundedBorder (Color.BLACK, 1, 25));
				pnlComponents.add(btnCancel);
				
				JButton btnReg = new JButton("Registrar");
				btnReg.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						boolean empty = isFieldEmpty();
						if(empty)
							lblWarning.setVisible(true);
						else {
							registerComp();
						}
							
					}
				});
				btnReg.setFont(new Font("Verdana", Font.PLAIN, 15));
				btnReg.setBorder(new RoundedBorder (Color.BLACK, 1, 25));
				btnReg.setBounds(525, 428, 97, 25);
				pnlComponents.add(btnReg);
				
				lblWarning = new JLabel("Por favor llenar todos los campos");
				lblWarning.setForeground(Color.RED);
				lblWarning.setFont(new Font("Verdana", Font.BOLD, 15));
				lblWarning.setBounds(112, 176, 275, 16);
				lblWarning.setVisible(false);
				pnlComponents.add(lblWarning);
			}
			{
				JPanel pnlCombos = new JPanel();
				pnlCombos.setBorder(new RoundedBorder(Color.BLACK,1,5));
				tabbedPane.addTab("Combo", null, pnlCombos, null);
				pnlCombos.setLayout(null);
				
				JLabel lblNewLabel_1 = new JLabel("ID:");
				lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(176, 51, 23, 16);
				pnlCombos.add(lblNewLabel_1);
				
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblNombre.setBounds(132, 123, 67, 16);
				pnlCombos.add(lblNombre);
				
				JLabel lblDescuento = new JLabel("Descuento:");
				lblDescuento.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblDescuento.setBounds(113, 204, 86, 16);
				pnlCombos.add(lblDescuento);
				
				JLabel lblComponentes = new JLabel("Componentes:");
				lblComponentes.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblComponentes.setBounds(87, 294, 112, 16);
				pnlCombos.add(lblComponentes);
				
				JPanel panel = new JPanel();
				panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel.setBounds(87, 315, 373, 138);
				pnlCombos.add(panel);
				panel.setLayout(new BorderLayout(0, 0));
				
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				
				btnSearch = new JButton("Buscar");
				btnSearch.setFont(new Font("Verdana", Font.PLAIN, 15));
				btnSearch.setBounds(363, 285, 97, 25);
				btnSearch.setBorder(new RoundedBorder(Color.BLACK,1,25));
				pnlCombos.add(btnSearch);
				
				txtIdCombo = new JTextField();
				txtIdCombo.setFont(new Font("Verdana", Font.PLAIN, 15));
				txtIdCombo.setEnabled(false);
				txtIdCombo.setText(IdGenerator.generateId());
				txtIdCombo.setBounds(215, 49, 116, 22);
				pnlCombos.add(txtIdCombo);
				txtIdCombo.setColumns(10);
				
				textField = new JTextField();
				textField.setFont(new Font("Verdana", Font.PLAIN, 15));
				textField.setColumns(10);
				textField.setBounds(215, 121, 245, 22);
				pnlCombos.add(textField);
				
				JSpinner spinner = new JSpinner();
				spinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
				spinner.setFont(new Font("Verdana", Font.PLAIN, 15));
				spinner.setBounds(215, 202, 73, 22);
				pnlCombos.add(spinner);
				
				JLabel lblNewLabel_3 = new JLabel("%");
				lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblNewLabel_3.setBounds(297, 204, 56, 16);
				pnlCombos.add(lblNewLabel_3);
				
				JButton btnRegCombo = new JButton("Registrar");
				btnRegCombo.setFont(new Font("Verdana", Font.PLAIN, 15));
				btnRegCombo.setBorder(new RoundedBorder (Color.BLACK, 1, 25));
				btnRegCombo.setBounds(527, 428, 97, 25);
				pnlCombos.add(btnRegCombo);
				
				JButton btnCancelCombo = new JButton("Cancelar");
				btnCancelCombo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCancelCombo.setFont(new Font("Verdana", Font.PLAIN, 15));
				btnCancelCombo.setBorder(new RoundedBorder (Color.BLACK, 1, 25));
				btnCancelCombo.setBounds(636, 428, 97, 25);
				pnlCombos.add(btnCancelCombo);
				
				JPanel pnlComboIcon = new JPanel();
				pnlComboIcon.setBackground(new Color(176, 224, 230));
				pnlComboIcon.setBounds(498, 27, 216, 197);
				pnlComboIcon.setBorder(new RoundedBorder(Color.BLACK,1,15));
				pnlCombos.add(pnlComboIcon);
				pnlComboIcon.setLayout(null);
				
				JLabel lblComboIcon = new JLabel("");
				lblComboIcon.setBounds(12, 13, 192, 171);
				pnlComboIcon.add(lblComboIcon);
				Image icon = new ImageIcon(this.getClass().getResource("/Images/pc.png")).getImage();
				Image scaledImg = icon.getScaledInstance(lblComboIcon.getWidth(), lblComboIcon.getHeight(), Image.SCALE_SMOOTH);
				lblComboIcon.setIcon(new ImageIcon(scaledImg));
				
				JLabel lblNewLabel_4 = new JLabel("Por favor llene \r\ntodos los campos");
				lblNewLabel_4.setForeground(Color.RED);
				lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 15));
				lblNewLabel_4.setBounds(448, 224, 266, 55);
				pnlCombos.add(lblNewLabel_4);
				
			}
		}
	}
	
	private void registerComp() {
		String id = txtId.getText();
		String brand = txtBrand.getText();
		double price = (double)spnPrice.getValue();
		int units = (int)spnUnits.getValue();
		int serie = (int)spnSerie.getValue();
		
		if(rdbtnMotherBoard.isSelected()) {
			String model = txtModelMB.getText();
			String socket = txtSocketMB.getText();
			String type = txtRamTypeMB.getText();
			ArrayList<String> conex = new ArrayList<String>();
			if(chckbxIdeMB.isSelected())
				conex.add("IDE");
			if(chckbxSataMB.isSelected())
				conex.add("SATA");
			if(chckbxSata2MB.isSelected())
				conex.add("SATA-2");
			if(chckbxSata3MB.isSelected())
				conex.add("SATA-3");
			MotherBoard mb = new MotherBoard(id, brand, price, units, serie, model, socket, type, conex);
			mb.setIcon((ImageIcon)lblIcon.getIcon());
			Administration.getInstance().addComponent(mb);
		} else if(rdbtnRAM.isSelected()) {
			int capacity = (int)spnCapacityRAM.getValue();
			String type = txtTypeRAM.getText();
			RAM ram = new RAM(id, brand, price, units, serie, capacity, type);
			ram.setIcon((ImageIcon)lblIcon.getIcon());
			Administration.getInstance().addComponent(ram);
		} else if(rdbtnMicro.isSelected()) {
			String model = txtModelMicro.getText();
			String socket = txtSocketMicro.getText();
			float speed = (float)spnSpeedMicro.getValue();
			MicroProcessor micro = new MicroProcessor(id, brand, price, units, serie, model, socket, speed);
			micro.setIcon((ImageIcon)lblIcon.getIcon());
			Administration.getInstance().addComponent(micro);
		} else {
			String model = txtModelHD.getText();
			int capacity = (int)spnCapacityHD.getValue();
			String conex = (String)cbxConType.getSelectedItem();
			HardDisk disk = new HardDisk(id, brand, price, units, serie, model, capacity, conex);
			disk.setIcon((ImageIcon)lblIcon.getIcon());
			Administration.getInstance().addComponent(disk);
		}
		JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Registrar Componente", JOptionPane.INFORMATION_MESSAGE);
		clean();
	}
	
	private boolean isFieldEmpty() {
		boolean empty = false;
		
		if (txtBrand.getText().trim().isEmpty() || spnPrice.getValue() == null ||
		        spnUnits.getValue() == null || spnSerie.getValue() == null) {
		        empty = true;
		    }

		    if (rdbtnMotherBoard.isSelected()) {
		        empty = empty || txtModelMB.getText().trim().isEmpty() || 
		                  txtSocketMB.getText().trim().isEmpty() || 
		                  txtRamTypeMB.getText().trim().isEmpty() || 
		                  (!chckbxIdeMB.isSelected() && !chckbxSataMB.isSelected() && 
		                		  !chckbxSata2MB.isSelected() && !chckbxSata3MB.isSelected());
		    } else if (rdbtnRAM.isSelected()) {
		        empty = empty || txtTypeRAM.getText().trim().isEmpty();
		    } else if (rdbtnMicro.isSelected()) {
		        empty = empty || txtModelMicro.getText().trim().isEmpty() || 
		                  txtSocketMicro.getText().trim().isEmpty();
		    } else if (rdbtnHardDisk.isSelected()) {
		        empty = empty || txtModelHD.getText().trim().isEmpty() || 
		                  cbxConType.getSelectedIndex() == 0;
		    }
		
		return empty;
	}
	
	private void clean() {
		txtId.setText(IdGenerator.generateId());
		txtBrand.setText("");
		spnPrice.setValue(0);
		spnUnits.setValue(1);
		spnSerie.setValue(1);
		txtModelMB.setText("");
		txtSocketMB.setText("");
		txtRamTypeMB.setText("");
		chckbxIdeMB.setSelected(false);
		chckbxSataMB.setSelected(false);
		chckbxSata2MB.setSelected(false);
		chckbxSata3MB.setSelected(false);
		spnCapacityRAM.setValue(4);
		txtTypeRAM.setText("");
		txtModelMicro.setText("");
		txtSocketMicro.setText("");
		spnSpeedMicro.setValue(1);
		txtModelHD.setText("");
		spnCapacityHD.setValue(500);
		cbxConType.setSelectedIndex(0);
		lblWarning.setVisible(false);
	}
	
	private void setIcon() {
		String path = "";
	    if (rdbtnMotherBoard.isSelected()) {
	        path = "/Images/tarjeta-madre.png";
	    } else if (rdbtnMicro.isSelected()) {
	        path = "/Images/procesador (1).png";
	    } else if (rdbtnHardDisk.isSelected()) {
	        path = "/Images/disco-duro.png";
	    } else if (rdbtnRAM.isSelected()) {
	        path = "/Images/memoria-ram.png";
	    }
	    if (!path.isEmpty()) {
	        img = new ImageIcon(this.getClass().getResource(path)).getImage();
	        Image scaledImg = img.getScaledInstance(lblIcon.getWidth(), lblIcon.getHeight(), Image.SCALE_SMOOTH);
	        lblIcon.setIcon(new ImageIcon(scaledImg));
	    }
	}
}
