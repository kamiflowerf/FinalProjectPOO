package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;


//import Visual.Catalogo.DataWrapper;

public class TableEditor extends AbstractCellEditor implements TableCellEditor {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panel;
    private final JLabel lblIcon;
    private final JLabel lblId;
    private final JRadioButton rdbtnNewRadioButton;
    private final JSpinner spinner;
    private DataWrapper currentData;
    private JLabel lblName;
    private Integer tempSpinnerValue;

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

        lblId = new JLabel();
        lblId.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblId.setBounds(41, 128, 146, 26);
        innerPanel.add(lblId);

        rdbtnNewRadioButton = new JRadioButton("");
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		currentData.setRadioButtonSelected(rdbtnNewRadioButton.isSelected());
        	}
        });
        rdbtnNewRadioButton.setBounds(11, 153, 34, 29);
        innerPanel.add(rdbtnNewRadioButton);

        spinner = new JSpinner();
        spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
        spinner.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
        		 tempSpinnerValue = (Integer) spinner.getValue();
        	}
        });
        spinner.setFont(new Font("Verdana", Font.PLAIN, 15));
        spinner.setBounds(41, 156, 146, 26);
        innerPanel.add(spinner);

        panel.add(innerPanel, BorderLayout.CENTER);
        
        lblName = new JLabel();
        lblName.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblName.setBounds(41, 92, 146, 26);
        innerPanel.add(lblName);
    }
    
    public int getTempSpinnerValue() {
    	return (Integer) spinner.getValue(); 
    }

    @Override
    public Object getCellEditorValue() {
        currentData.setSpinnerValue(getTempSpinnerValue());
        currentData.setTextField(lblId.getText());
        currentData.setTxtName(lblName.getText());
        currentData.setRadioButtonSelected(rdbtnNewRadioButton.isSelected());
        return currentData;
    }

    
    public boolean getradbutton() {
        return rdbtnNewRadioButton.isSelected();
    }	

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        currentData = (DataWrapper) value;
        
        Image img = currentData.getIcon().getImage();
        Image scaledImg = img.getScaledInstance(lblIcon.getWidth(), lblIcon.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaledImg);
        lblIcon.setIcon(icon);
        lblId.setText(currentData.getTextField());
        lblName.setText(currentData.getTxtName());
        spinner.setValue(currentData.getSpinnerValue());
        
        tempSpinnerValue = currentData.getSpinnerValue();
        
        rdbtnNewRadioButton.setSelected(currentData.isRadioButtonSelected());

        panel.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
        return panel;
    }
}
