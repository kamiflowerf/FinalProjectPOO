package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;

public class CustomTableCellRenderer extends JPanel implements TableCellRenderer {
    private final JLabel lblIcon;
    private final JTextField textField;
    private final JRadioButton rdbtnNewRadioButton;
    private final JSpinner spinner;
    private final JPanel innerPanel;

    public CustomTableCellRenderer() {
        setLayout(new BorderLayout());
        innerPanel = new JPanel();
        innerPanel.setLayout(null);
        innerPanel.setPreferredSize(new Dimension(227/3, 194));

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

        add(innerPanel, BorderLayout.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof DataWrapper) {
            DataWrapper data = (DataWrapper) value;

            lblIcon.setIcon(data.getIcon() != null ? data.getIcon() : new ImageIcon());
            if(data.getTextField() != null) {
            textField.setText(data.getTextField());
            spinner.setValue(data.getSpinnerValue());
            rdbtnNewRadioButton.setSelected(data.isRadioButtonSelected());

            }else {
            	textField.setVisible(false);
            	spinner.setVisible(false);
            	rdbtnNewRadioButton.setVisible(false);
            }

        } else {
            lblIcon.setIcon(null);
            textField.setVisible(false);
            spinner.setVisible(false);
            rdbtnNewRadioButton.setVisible(false);
        }

        return this;
    }
}
