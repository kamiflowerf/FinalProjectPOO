package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

import Visual.*;

//import Visual.Catalogo.DataWrapper;

public class TableEditor extends AbstractCellEditor implements TableCellEditor {
 
	private static final long serialVersionUID = 1L;
	private final JPanel panel;
    private final JLabel lblIcon;
    private final JTextField textField;
    private final JRadioButton rdbtnNewRadioButton;
    private final JSpinner spinner;
    private DataWrapper currentData;

    public TableEditor() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(227, 194));

        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(null);
        innerPanel.setPreferredSize(new Dimension(227, 194));

        lblIcon = new JLabel();
        lblIcon.setBounds(70, 16, 79, 63);
        innerPanel.add(lblIcon);

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
        lblIcon.setIcon(currentData.getIcon());
        textField.setText(currentData.getTextField());
        spinner.setValue(currentData.getSpinnerValue());
        rdbtnNewRadioButton.setSelected(currentData.isRadioButtonSelected());

        panel.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
        return panel;
    }
}
