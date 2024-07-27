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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import logic.*;
import java.awt.Font;

public class Catalogo extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private CustomTableModel tableModel = new CustomTableModel();
    private List<DataWrapper> selectedItems = new ArrayList<>();
    public interface onSelectedComp{
    	void getSelectedComp(String ID);
    }
    private JTable table;
    private JTable table2;
    private JTable table3;
    private JButton cancelButton;
    private static JButton deleteBtn;
    private static JButton selectBtn;
    private static JButton addBtn;
 

    public static void main(String[] args) {
        try {
            Catalogo dialog = new Catalogo(null);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Catalogo(onSelectedComp compInterface) {
        setTitle("Catálogo");
    	setBounds(100, 100, 800, 600);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        
        // Load initial data into the model
        loadComponents(tableModel, "Todos");

        table = new JTable(tableModel);
        table.setRowHeight(200);
        
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Allow multiple selection

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                updateSelectedItems();
            }
        });

        table2 = new JTable(tableModel);
        table2.setRowHeight(200);
        table3 = new JTable(tableModel);
        table3.setRowHeight(200);
        
        /*
        if(compInterface == null) {
        	deleteBtn.setEnabled(true);
        } else {
        	selectBtn.setEnabled(true);
        }*/
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
        comboBox.setFont(new Font("Verdana", Font.PLAIN, 15));
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

        selectBtn = new JButton("Seleccionar");
        selectBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(!selectedItems.isEmpty()) {
        			for(DataWrapper dw : selectedItems) {
        				compInterface.getSelectedComp(dw.getTextField());
        			}
        			dispose();
        		}
        	}
        });
        //selectBtn.setEnabled(false);
        selectBtn.setFont(new Font("Verdana", Font.PLAIN, 15));
        selectBtn.setPreferredSize(new Dimension(95, 30));
        selectBtn.setBorder(new RoundedBorder(Color.BLACK, 1, 25));
        selectBtn.setActionCommand("OK");
        buttonsPanel.add(selectBtn);

        deleteBtn = new JButton("Eliminar");
        deleteBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(!selectedItems.isEmpty()) {
        			int option = JOptionPane.showConfirmDialog(null, "Seguro desea eliminar el/los componentes?", "Confirmación", JOptionPane.WARNING_MESSAGE);
        			if(option == JOptionPane.YES_OPTION) {
        				for(DataWrapper dw : selectedItems) {
        					Administration.getInstance().deleteComponent(dw.getTextField());
        				}
        				deleteBtn.setEnabled(false);
    					loadComponents(tableModel, "Todos");
        			}
        		}
        	}
        });
        //deleteBtn.setEnabled(false);
        deleteBtn.setFont(new Font("Verdana", Font.PLAIN, 15));
        deleteBtn.setBorder(new RoundedBorder(Color.BLACK, 1, 25));
        deleteBtn.setPreferredSize(new Dimension(75, 30)); 
        deleteBtn.setActionCommand("OK");
        buttonsPanel.add(deleteBtn);
        getRootPane().setDefaultButton(deleteBtn);

        cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		dispose();
        	}
        });
        
        addBtn = new JButton("Agregar");
        addBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		RegComps newComp = new RegComps();
        		newComp.setModal(true);
        		newComp.setVisible(true);
        		loadComponents(tableModel, "Todos");
        	}
        });
        addBtn.setFont(new Font("Verdana", Font.PLAIN, 15));
        addBtn.setBorder(new RoundedBorder(Color.BLACK,1,25));
        addBtn.setPreferredSize(new Dimension(80, 30));
        buttonsPanel.add(addBtn);
        
        cancelButton.setFont(new Font("Verdana", Font.PLAIN, 15));
        cancelButton.setBorder(new RoundedBorder(Color.BLACK, 1, 25));
        cancelButton.setPreferredSize(new Dimension(80, 30)); 
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
        
        //deleteBtn.setEnabled(false);
        //selectBtn.setEnabled(false);
        //addBtn.setEnabled(true);
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
    
    private void updateSelectedItems() {
        int[] selectedRows = table.getSelectedRows();
        selectedItems.clear();
        for (int row : selectedRows) {
        	selectedItems.add(tableModel.getData().get(row));
        }
    }

    public List<DataWrapper> getSelectedItems() {
    	return new ArrayList<>(selectedItems);
    }

}