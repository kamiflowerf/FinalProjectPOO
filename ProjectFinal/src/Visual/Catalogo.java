package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import logic.*;

public class Catalogo extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private CustomTableModel tableModel = new CustomTableModel();
    private JTable table;
    private JTable table2;
    private JTable table3;
 

    public static void main(String[] args) {
        try {
            Catalogo dialog = new Catalogo();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Catalogo() {
        setBounds(100, 100, 800, 600);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        
        // Load initial data into the model
        loadComponents(tableModel, "Todos");

        table = new JTable(tableModel);
        table.setRowHeight(200);
        table2 = new JTable(tableModel);
        table2.setRowHeight(200);
        table3 = new JTable(tableModel);
        table3.setRowHeight(200);
        
        // Initialize columns
        initializeColumns();

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(700, 400));
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPane = new JPanel(new BorderLayout());
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPane.add(buttonsPanel, BorderLayout.CENTER);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Todos");
        comboBox.addItem("Tarjeta Madre");
        comboBox.addItem("Disco Duro");
        comboBox.addItem("Ram");
        comboBox.addItem("Microprocesador");

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) comboBox.getSelectedItem();
                filterComponents(selectedType);
            }
        });
        buttonsPanel.add(comboBox);

        JButton btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.setPreferredSize(new Dimension(75, 30));
        btnSeleccionar.setBorder(new RoundedBorder(Color.BLACK, 1, 25));
        btnSeleccionar.setActionCommand("OK");
        buttonsPanel.add(btnSeleccionar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setPreferredSize(new Dimension(75, 30));
        btnEliminar.setBorder(new RoundedBorder(Color.BLACK, 1, 25));
        btnEliminar.setActionCommand("OK");
        buttonsPanel.add(btnEliminar);

        JButton okButton = new JButton("Editar");
        okButton.setBorder(new RoundedBorder(Color.BLACK, 1, 25));
        okButton.setPreferredSize(new Dimension(75, 30)); // Set the preferred size of the OK button
        okButton.setActionCommand("OK");
        buttonsPanel.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBorder(new RoundedBorder(Color.BLACK, 1, 25));
        cancelButton.setPreferredSize(new Dimension(75, 30)); // Set the preferred size of the Cancel button
        cancelButton.setActionCommand("Cancel");
        buttonsPanel.add(cancelButton);
    }

    private void initializeColumns() {
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setCellRenderer(new CustomTableCellRenderer());
            column.setCellEditor(new TableEditor());
        }
    }

    public void filterComponents(String componentType) {
        CustomTableModel newTableModel = new CustomTableModel();
        loadComponents(newTableModel, componentType);
        table.setModel(newTableModel);
        initializeColumns();
    }

    public static void loadComponents(CustomTableModel tableModel, String componentType) {
        ArrayList<Component> aux = Administration.getInstance().getTheComponents();
        List<DataWrapper> data = new ArrayList<>();
        Set<String> uniqueIds = new HashSet<>();
        
        for (Component comp : aux) {
            if (componentType.equals("Todos") || getComponentType(comp).equals(componentType)) {
                ImageIcon icon = comp.getIcon();
                String textField = comp.getId();
                int spinnerValue = comp.getUnits();
                boolean radioButtonSelected = false;

                if (!uniqueIds.contains(textField)) {
                    uniqueIds.add(textField);
                    data.add(new DataWrapper(icon, textField, spinnerValue, radioButtonSelected));
                }
            }
        }

        tableModel.setData(data);
    }

    private static String getComponentType(Component comp) {
        if (comp instanceof MotherBoard) {
            return "Tarjeta Madre";
        } else if (comp instanceof HardDisk) {
            return "Disco Duro";
        } else if (comp instanceof RAM) {
            return "Ram";
        } else if (comp instanceof MicroProcessor) {
            return "Microprocesador";
        } else {
            return "Otros";
        }
    }
}