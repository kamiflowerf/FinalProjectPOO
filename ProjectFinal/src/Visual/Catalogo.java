package Visual;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

public class Catalogo extends JDialog {

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
        setBounds(100, 100, 800, 600); // Adjusted for better visibility with more columns
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        {
            JTable table = new JTable(new CustomTableModel());
            table.setRowHeight(200);

            // Set custom renderers and editors for each column
            TableColumnModel columnModel = table.getColumnModel();
            TableColumn column1 = columnModel.getColumn(0);
            column1.setCellRenderer(new CustomTableCellRenderer());
            column1.setCellEditor(new CustomTableCellEditor());

            TableColumn column2 = columnModel.getColumn(1);
            column2.setCellRenderer(new CustomTableCellRenderer());
            column2.setCellEditor(new CustomTableCellEditor());

            TableColumn column3 = columnModel.getColumn(2);
            column3.setCellRenderer(new CustomTableCellRenderer());
            column3.setCellEditor(new CustomTableCellEditor());

            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(700, 400));
            contentPanel.add(scrollPane, BorderLayout.CENTER);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

    // Custom TableModel to hold the data
    private static class CustomTableModel extends AbstractTableModel {
        private final String[] columnNames = {"Column 1", "Column 2", "Column 3"};
        private final DataWrapper[][] data = {
                {new DataWrapper("Element 1", "", 0, false), new DataWrapper("Element A", "", 0, false), new DataWrapper("Element X", "", 0, false)},
                {new DataWrapper("Element 2", "", 0, false), new DataWrapper("Element B", "", 0, false), new DataWrapper("Element Y", "", 0, false)},
                {new DataWrapper("Element 3", "", 0, false), new DataWrapper("Element C", "", 0, false), new DataWrapper("Element Z", "", 0, false)}
        };

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
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
            data[rowIndex][columnIndex] = (DataWrapper) value;
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }

    // DataWrapper class to encapsulate the editable data
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

    // Custom TableCellRenderer to render JTable cells with specific components
    private static class CustomTableCellRenderer extends JPanel implements TableCellRenderer {

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
            lblNewLabel.setOpaque(true); // Ensure background is visible
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



