package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Visual.Catalogo.onSelectedComp;
import Visual.SupplierList.onSelectedSupplier;
import logic.Administration;
import logic.Component;
import logic.HardDisk;
import logic.IdGenerator;
import logic.MicroProcessor;
import logic.MotherBoard;
import logic.RAM;

public class Pedido extends JDialog implements onSelectedSupplier, onSelectedComp {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private String idSup;
    private JTable tableComponents;
    private DefaultTableModel tableModel;
    private JTextField txtIdSup;
    private JTextField txtPedido;
    private JTextField textField;
    private JButton btnSearchComp; 
    private boolean isSupplierSelected = false; 

    public static void main(String[] args) {
        try {
            Pedido dialog = new Pedido();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pedido() {
        setTitle("Pedido");
        setBounds(100, 100, 701, 445);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPanel.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("ID Suplidor");
        lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        lblNewLabel.setBounds(33, 51, 99, 20);
        panel.add(lblNewLabel);

        txtIdSup = new JTextField();
        txtIdSup.setFont(new Font("Verdana", Font.PLAIN, 14));
        txtIdSup.setEditable(false);
        txtIdSup.setBounds(33, 84, 164, 26);
        panel.add(txtIdSup);
        txtIdSup.setColumns(10);

        JButton btnSearchSup = new JButton("Buscar");
        btnSearchSup.setFont(new Font("Verdana", Font.PLAIN, 14));
        btnSearchSup.setBorder(new RoundedBorder(Color.BLACK, 1, 20));
        btnSearchSup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SupplierList suplist = new SupplierList(Pedido.this);
                suplist.setModal(true);
                suplist.setVisible(true);
                suplist.setResizable(false);
                txtIdSup.setText(idSup);
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
        txtPedido.setText(IdGenerator.generateId());

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
        textField.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        JLabel lblComponentes = new JLabel("Componentes");
        lblComponentes.setFont(new Font("Verdana", Font.BOLD, 14));
        lblComponentes.setBounds(33, 170, 115, 20);
        panel.add(lblComponentes);

        btnSearchComp = new JButton("Buscar");
        btnSearchComp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (!isSupplierSelected) {
                    JOptionPane.showMessageDialog(Pedido.this, "Por favor, seleccione un proveedor primero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Catalogo cat = new Catalogo(Pedido.this);
                cat.setModal(true);
                cat.setVisible(true);
                cat.setResizable(false);
            }
        });
        btnSearchComp.setFont(new Font("Verdana", Font.PLAIN, 14));
        btnSearchComp.setBounds(264, 166, 99, 29);
        btnSearchComp.setBorder(new RoundedBorder(Color.BLACK, 1, 20));
        btnSearchComp.setEnabled(false); 
        panel.add(btnSearchComp);

        JPanel pnlComponents = new JPanel();
        pnlComponents.setBorder(new RoundedBorder(Color.BLACK, 1, 15));
        pnlComponents.setBounds(33, 203, 330, 165);
        panel.add(pnlComponents);
        pnlComponents.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        pnlComponents.add(scrollPane, BorderLayout.CENTER);
        tableModel = new DefaultTableModel(new Object[]{"ID", "Tipo", "Cantidad"}, 0); 
        tableComponents = new JTable(tableModel);
        tableComponents.setFont(new Font("Verdana", Font.PLAIN, 13));
        scrollPane.setViewportView(tableComponents);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 14));
        btnCancelar.setBounds(515, 339, 99, 29);
        btnCancelar.setBorder(new RoundedBorder(Color.BLACK, 1, 20));
        panel.add(btnCancelar);

        JButton btnRealizarPedido = new JButton("Pedir");
        btnRealizarPedido.setFont(new Font("Verdana", Font.PLAIN, 14));
        btnRealizarPedido.setBounds(388, 339, 115, 29);
        btnRealizarPedido.setBorder(new RoundedBorder(Color.BLACK, 1, 20));
        btnRealizarPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener ID del proveedor
                String idSupplier = txtIdSup.getText();

                // Obtener fecha del pedido
                String orderDateStr = textField.getText();
                Date orderDate = null;
                try {
                    orderDate = new SimpleDateFormat("dd/MM/yyyy").parse(orderDateStr);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(Pedido.this, "Error en el formato de la fecha.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                
                ArrayList<Component> componentsOrder = new ArrayList<>();
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    String id = (String) tableModel.getValueAt(i, 0);
                    int quantity = (int) tableModel.getValueAt(i, 2);
                    Component comp = Administration.getInstance().searchComponentById(id);
                    if (comp != null) {
                        comp.setUnits(quantity);
                        componentsOrder.add(comp);
                    }
                }

               
                boolean refillSuccessful = Administration.getInstance().inventoryRefill(componentsOrder);
                if (refillSuccessful) {
                    JOptionPane.showMessageDialog(Pedido.this, "Reabastecimiento de inventario realizado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    txtIdSup.setText("");
                    txtPedido.setText(IdGenerator.generateId());
                    textField.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    tableModel.setRowCount(0);
                } else {
                    JOptionPane.showMessageDialog(Pedido.this, "Error al reabastecer el inventario. Verifique los datos e intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(btnRealizarPedido);
    }

    @Override
    public void getSelectedComp(String ID) {
        Component comp = Administration.getInstance().searchComponentById(ID);

        if (comp != null) {
            String componentType = Catalogo.getComponentType(comp);
            int quantity = comp.getUnits();

            // Verificar si el componente ya está en la tabla
            boolean exists = false;
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String id = (String) tableModel.getValueAt(i, 0);
                if (id.equals(ID)) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                tableModel.addRow(new Object[]{ID, componentType, quantity});
            } else {
                JOptionPane.showMessageDialog(this, "El componente ya está en la tabla.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    @Override
    public void getSelectedSupplier(String id) {
        this.idSup = id;
        btnSearchComp.setEnabled(true); 
        isSupplierSelected = true; 
    }
    
    private void autoRefill() {
        // Obtener componentes seleccionados
        ArrayList<Component> componentsOrder = new ArrayList<>();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String id = (String) tableModel.getValueAt(i, 0);
            int quantity = (int) tableModel.getValueAt(i, 2);
            Component comp = Administration.getInstance().searchComponentById(id);
            if (comp != null) {
                comp.setUnits(quantity);
                componentsOrder.add(comp);
            }
        }

        // Actualizar el inventario con los componentes ordenados
        Administration.getInstance().inventoryRefill(componentsOrder);
    }
}
