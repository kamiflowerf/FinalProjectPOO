package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import java.util.ArrayList;
import javax.swing.AbstractCellEditor;
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
        loadData(tableModel); // Cargar datos en el modelo de la tabla

        JTable table = new JTable(tableModel);
        table.setRowHeight(200);

        // Set custom renderers and editors for each column
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setCellRenderer(new CustomTableCellRenderer());
            column.setCellEditor(new CustomTableCellEditor());
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

    private void loadData(CustomTableModel tableModel) {
        List<DataWrapper> data = new ArrayList<>();
        data.add(new DataWrapper("Element 1", "Text 1", 5, false));
        data.add(new DataWrapper("Element 2", "Text 2", 10, false));
        data.add(new DataWrapper("Element 3", "Text 3", 15, false));

        tableModel.setData(data);
    }

    private static class CustomTableModel extends AbstractTableModel {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private final String[] columnNames = {"Column 1", "Column 2", "Column 3"};
        private List<DataWrapper> data;

        public CustomTableModel() {
            data = new ArrayList<>();
        }

        public void setData(List<DataWrapper> data) {
            this.data = data;
            fireTableDataChanged();
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data.get(rowIndex);
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

        @Override
        public void setValueAt(Object value, int rowIndex, int columnIndex) {
            data.set(rowIndex, (DataWrapper) value);
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }

    private static class DataWrapper {
        private String label;
        private String textField;
        private int spinnerValue;
        private boolean radioButtonSelected;

        public DataWrapper(String label, String textField, int spinnerValue, boolean radioButtonSelected) {
            this.label = label;
            this.textField = textField;
            this.spinnerValue = spinnerValue;
            this.radioButtonSelected = radioButtonSelected;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getTextField() {
            return textField;
        }

        public void setTextField(String textField) {
            this.textField = textField;
        }

        public int getSpinnerValue() {
            return spinnerValue;
        }

        public void setSpinnerValue(int spinnerValue) {
            this.spinnerValue = spinnerValue;
        }

        public boolean isRadioButtonSelected() {
            return radioButtonSelected;
        }

        public void setRadioButtonSelected(boolean radioButtonSelected) {
            this.radioButtonSelected = radioButtonSelected;
        }
    }

    private static class CustomTableCellRenderer extends JPanel implements TableCellRenderer {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private final JLabel lblNewLabel;
        private final JTextField textField;
        private final JRadioButton rdbtnNewRadioButton;
        private final JSpinner spinner;

        public CustomTableCellRenderer() {
            setLayout(new BorderLayout());
            JPanel innerPanel = new JPanel();
            innerPanel.setLayout(null);
            innerPanel.setPreferredSize(new Dimension(227, 194));

            lblNewLabel = new JLabel();
            lblNewLabel.setBounds(70, 16, 79, 63);
            lblNewLabel.setOpaque(true); 
            innerPanel.add(lblNewLabel);

            textField = new JTextField();
            textField.setBounds(41, 85, 146, 26);
            innerPanel.add(textField);

            rdbtnNewRadioButton = new JRadioButton("");
            rdbtnNewRadioButton.setBounds(11, 153, 34, 29);
            innerPanel.add(rdbtnNewRadioButton);

            spinner = new JSpinner();
            spinner.setBounds(41, 126, 146, 26);
            innerPanel.add(spinner);

            add(innerPanel, BorderLayout.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            DataWrapper data = (DataWrapper) value;
            lblNewLabel.setText(data.getLabel());
            textField.setText(data.getTextField());
            spinner.setValue(data.getSpinnerValue());
            rdbtnNewRadioButton.setSelected(data.isRadioButtonSelected());

            if (isSelected) {
                setBackground(table.getSelectionBackground());
                lblNewLabel.setForeground(table.getSelectionForeground());
                textField.setForeground(table.getSelectionForeground());
                rdbtnNewRadioButton.setForeground(table.getSelectionForeground());
                spinner.setForeground(table.getSelectionForeground());
            } else {
                setBackground(table.getBackground());
                lblNewLabel.setForeground(table.getForeground());
                textField.setForeground(table.getForeground());
                rdbtnNewRadioButton.setForeground(table.getForeground());
                spinner.setForeground(table.getForeground());
            }

            return this;
        }
    }

    private static class CustomTableCellEditor extends AbstractCellEditor implements TableCellEditor {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private final JPanel panel;
        private final JTextField textField;
        private final JRadioButton rdbtnNewRadioButton;
        private final JSpinner spinner;
        private DataWrapper currentData;

        public CustomTableCellEditor() {
            panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.setPreferredSize(new Dimension(227, 194));

            JPanel innerPanel = new JPanel();
            innerPanel.setLayout(null);
            innerPanel.setPreferredSize(new Dimension(227, 194));

            textField = new JTextField();
            textField.setBounds(41, 85, 146, 26);
            innerPanel.add(textField);

            rdbtnNewRadioButton = new JRadioButton("");
            rdbtnNewRadioButton.setBounds(11, 153, 34, 29);
            innerPanel.add(rdbtnNewRadioButton);

            spinner = new JSpinner();
            spinner.setBounds(41, 126, 146, 26);
            innerPanel.add(spinner);

            panel.add(innerPanel, BorderLayout.CENTER);
        }

        @Override
        public Object getCellEditorValue() {
            currentData.setTextField(textField.getText());
            currentData.setSpinnerValue((Integer) spinner.getValue());
            currentData.setRadioButtonSelected(rdbtnNewRadioButton.isSelected());
            return currentData;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            currentData = (DataWrapper) value;
            textField.setText(currentData.getTextField());
            spinner.setValue(currentData.getSpinnerValue());
            rdbtnNewRadioButton.setSelected(currentData.isRadioButtonSelected());

            panel.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
            return panel;
        }
    }
}
