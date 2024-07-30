package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;
import java.awt.Font;

public class CustomTableCellRenderer extends JPanel implements TableCellRenderer {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JLabel lblIcon;
    private final JLabel lblId;
    private final JRadioButton rdbtnSelected;
    private final JSpinner spinner;
    private final JPanel innerPanel;
    private JLabel lblName;

    public CustomTableCellRenderer() {
        setLayout(new BorderLayout());
        innerPanel = new JPanel();
        innerPanel.setLayout(null);
        innerPanel.setPreferredSize(new Dimension(227/3, 194));

        lblIcon = new JLabel();
        lblIcon.setBounds(70, 16, 79, 63);
        innerPanel.add(lblIcon);

        lblId = new JLabel();
        lblId.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblId.setBounds(41, 128, 146, 26);
        innerPanel.add(lblId);

        rdbtnSelected = new JRadioButton("");
        rdbtnSelected.setBounds(11, 153, 34, 29);
        innerPanel.add(rdbtnSelected);

        spinner = new JSpinner();
        spinner.setFont(new Font("Verdana", Font.PLAIN, 15));
        spinner.setBounds(41, 156, 146, 26);
        innerPanel.add(spinner);

        add(innerPanel, BorderLayout.CENTER);
        
        lblName = new JLabel();
        lblName.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblName.setBounds(41, 92, 146, 26);
        innerPanel.add(lblName);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof DataWrapper) {
            DataWrapper data = (DataWrapper) value;

            Image img = data.getIcon().getImage();
            Image scaledImg = img.getScaledInstance(lblIcon.getWidth(), lblIcon.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImg);
            lblIcon.setIcon(icon != null ? icon : new ImageIcon());
            
            if(data.getTextField() != null) {
            	lblId.setText(data.getTextField());
            	lblName.setText(data.getTxtName());
            	spinner.setValue(data.getSpinnerValue());
            	rdbtnSelected.setSelected(data.isRadioButtonSelected());

            }else {
            	lblId.setVisible(false);
            	lblName.setVisible(false);
            	spinner.setVisible(false);
            	rdbtnSelected.setVisible(false);
            }

        } else {
            lblIcon.setIcon(null);
            lblId.setVisible(false);
            lblName.setVisible(false);
            spinner.setVisible(false);
            rdbtnSelected.setVisible(false);
        }

        return this;
    }
}
