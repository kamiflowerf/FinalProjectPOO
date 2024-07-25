package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import logic.*;

public class Catalogo extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

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
        
        CustomTableModel tableModel = new CustomTableModel();
        loadComponents(tableModel); // Cargar datos en el modelo de la tabla

        JTable table = new JTable(tableModel);
        table.setRowHeight(200);

        // Set custom renderers and editors for each column
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setCellRenderer(new CustomTableCellRenderer());
            column.setCellEditor(new TableEditor());
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(700, 400));
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPane = new JPanel(new BorderLayout());
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPane.add(buttonsPanel, BorderLayout.CENTER);

        JComboBox<String> comboBox = new JComboBox<String>();
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

    public static void loadComponents(CustomTableModel tableModel) {
        ArrayList<Component> aux = Administration.getInstance().getTheComponents();
        List<DataWrapper> data = new ArrayList<>();
        Set<String> uniqueIds = new HashSet<>(); // Conjunto para almacenar los IDs únicos

        for (Component comp : aux) {
            ImageIcon icon = comp.getIcon();
            String textField = comp.getId();
            int spinnerValue = comp.getUnits();
            boolean radioButtonSelected = false; // Si tienes una lógica específica para esto, ajusta en consecuencia

            if (!uniqueIds.contains(textField)) { // Verifica si el ID ya está presente en el conjunto
                uniqueIds.add(textField); // Agrega el ID al conjunto
                data.add(new DataWrapper(icon, textField, spinnerValue, radioButtonSelected)); // Agrega el componente a la lista de datos
            }
        }

        tableModel.setData(data);
    }

}