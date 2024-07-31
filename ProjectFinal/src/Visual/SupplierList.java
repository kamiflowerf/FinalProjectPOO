package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import logic.Administration;
import logic.Component;
import logic.Supplier;

public class SupplierList extends JDialog implements MouseListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane = new JPanel();
    private static JScrollPane scrollPaneTable;
    private static JTable SupplierTable;
    static ArrayList<Supplier> suppliers;
    static TableModel model;
    private static int rows;
    private static int columns;
    private JPanel panelBotton;
    private JButton btn_cancel;
    private JButton btn_update;
    private JButton btn_select;
    private JButton btn_addNew;
    private JButton btn_delete;
    private String idSuppli = "";
    public onSelectedSupplier supplierInterface;
    
    public interface onSelectedSupplier {
        void getSelectedSupplier(String id);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            SupplierList dialog = new SupplierList(null);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public SupplierList(onSelectedSupplier supplierInterface) {
        setIconImage(Toolkit.getDefaultToolkit().getImage(SupplierList.class.getResource("/Images/empleado.png")));
        this.supplierInterface = supplierInterface;
        
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(1000,551);
        
        startComponents();
        setLocationRelativeTo(null);
        buildTable();
    }

    private static void buildTable() {
        suppliers = Administration.getInstance().getTheSuppliers();
        
        ArrayList<String> headers = new ArrayList<>();
        headers.add("Código");
        headers.add("Nombre");
        headers.add("Cédula");
        headers.add("E-mail");
        headers.add("Dirección");
        headers.add("Teléfono");
        headers.add("Tiempo de entrega");
        headers.add("Productos que provee");
        
        String titles[] = new String[headers.size()];
        
        for(int i = 0; i < titles.length; i++) {
            titles[i] = headers.get(i);
        }
        
        Object[][] data = getData(headers);
        putEverythingTogether(titles, data);
    }

    private static void putEverythingTogether(String[] titles, Object[][] data) {
        model = new TableModel(titles,data);
        
        SupplierTable.setModel(model);
        
        setRows(SupplierTable.getRowCount());
        setColumns(SupplierTable.getColumnCount());
        
        for (int i = 0; i < titles.length; i++) {
            SupplierTable.getColumnModel().getColumn(i).setCellRenderer(new CellsConfig("text"));
        }
        
        SupplierTable.getTableHeader().setReorderingAllowed(false);
        SupplierTable.setRowHeight(25);
        SupplierTable.setGridColor(new java.awt.Color(0,0,0));
        
        SupplierTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        SupplierTable.getColumnModel().getColumn(1).setPreferredWidth(400);
        SupplierTable.getColumnModel().getColumn(2).setPreferredWidth(350);
        SupplierTable.getColumnModel().getColumn(3).setPreferredWidth(400);
        SupplierTable.getColumnModel().getColumn(4).setPreferredWidth(300);
        SupplierTable.getColumnModel().getColumn(5).setPreferredWidth(350);
        SupplierTable.getColumnModel().getColumn(6).setPreferredWidth(400);
        SupplierTable.getColumnModel().getColumn(7).setPreferredWidth(450);
        
        JTableHeader tableHeader = SupplierTable.getTableHeader();
        tableHeader.setDefaultRenderer(new TableTitles());
        SupplierTable.setTableHeader(tableHeader);
        
        scrollPaneTable.setViewportView(SupplierTable);
    }

    private static Object[][] getData(ArrayList<String> headers) {
        String info[][] = new String[suppliers.size()][headers.size()];
        
        for(int i = 0; i < info.length; i++) {
            int devTime = suppliers.get(i).getDeliveryTime();
            String deliveryTime = String.valueOf(devTime);
            
            info[i][0] = suppliers.get(i).getId();
            info[i][1] = suppliers.get(i).getName();
            info[i][2] = suppliers.get(i).getNi();
            info[i][3] = suppliers.get(i).getEmail();
            info[i][4] = suppliers.get(i).getAddress();
            info[i][5] = suppliers.get(i).getPhone();
            info[i][6] = deliveryTime;
            
            // Verificar si los componentes están correctamente asignados
            List<Component> components = suppliers.get(i).getMyComponents();
            StringBuilder componentsString = new StringBuilder();
            if (components != null && !components.isEmpty()) {
                for (Component component : components) {
                    componentsString.append(component.getId()).append(", ");
                }
                if (componentsString.length() > 0) {
                    componentsString.setLength(componentsString.length() - 2); // Eliminar la última coma
                }
            } else {
                componentsString.append("No componentes");
            }
           
            info[i][7] = componentsString.toString();
        }
        
        return info;
    }

    private void startComponents() {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0,0));
        
        JLabel lbl_supplierTable = new JLabel("Listado suplidores");
        lbl_supplierTable.setFont(new Font("Verdana", Font.BOLD, 30));
        contentPane.add(lbl_supplierTable, BorderLayout.NORTH);
        
        scrollPaneTable = new JScrollPane();
        contentPane.add(scrollPaneTable);
        
        SupplierTable = new JTable();
        SupplierTable.setBackground(Color.white);
        SupplierTable.setBorder(new BevelBorder(BevelBorder.RAISED,null,null,null,null));
        SupplierTable.addMouseListener(this);
        SupplierTable.setOpaque(false);
        scrollPaneTable.setViewportView(SupplierTable);
        
        panelBotton = new JPanel();
        contentPane.add(panelBotton, BorderLayout.SOUTH);
        
        btn_select = new JButton("Seleccionar");
        btn_select.setFont(new Font("Verdana", Font.BOLD, 12));
        btn_select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(idSuppli != "") {
                    supplierInterface.getSelectedSupplier(idSuppli);
                    dispose();
                }
            }
        });
        btn_select.setPreferredSize(new Dimension(85, 30));
        btn_select.setBorder(new RoundedBorder(Color.BLACK,1,25));
        btn_select.setEnabled(false);
        panelBotton.add(btn_select);
        
        btn_update = new JButton("Actualizar");
        btn_update.setFont(new Font("Verdana", Font.BOLD, 12));
        btn_update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(idSuppli != "") {
                    Supplier suppli = Administration.getInstance().searchSupplierById(idSuppli);
                    
                    if(suppli != null) {
                        SupplierRegistry updateSuppli = new SupplierRegistry(suppli);
                        updateSuppli.setModal(true);
                        updateSuppli.setVisible(true);
                    }
                }
            }
        });
        btn_update.setPreferredSize(new Dimension(85, 30));
        btn_update.setBorder(new RoundedBorder(Color.BLACK,1,25));
        btn_update.setEnabled(false);
        panelBotton.add(btn_update);
        
        btn_delete = new JButton("Eliminar");
        btn_delete.setFont(new Font("Verdana", Font.BOLD, 12));
        btn_delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(idSuppli != "") {
                    int option = JOptionPane.showConfirmDialog(null, "Seguro desea eliminar el proveedor con código: "+idSuppli, "Confirmación", JOptionPane.WARNING_MESSAGE);
                    if(option == JOptionPane.YES_OPTION) {
                        Administration.getInstance().deleteSupplier(idSuppli);
                        btn_delete.setEnabled(false);
                        updateTable();
                    }
                }
            }
        });
        btn_delete.setPreferredSize(new Dimension(85, 30));
        btn_delete.setBorder(new RoundedBorder(Color.BLACK,1,25));
        btn_delete.setEnabled(false);
        panelBotton.add(btn_delete);
        
        btn_addNew = new JButton("Agregar");
        btn_addNew.setFont(new Font("Verdana", Font.BOLD, 12));
        btn_addNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SupplierRegistry newSuppli = new SupplierRegistry(null);
                newSuppli.setModal(true);
                newSuppli.setVisible(true);
                updateTable();
            }
        });
        btn_addNew.setPreferredSize(new Dimension(85, 30));
        btn_addNew.setBorder(new RoundedBorder(Color.BLACK,1,25));
        panelBotton.add(btn_addNew);
        
        btn_cancel = new JButton("Cancelar");
        btn_cancel.setFont(new Font("Verdana", Font.BOLD, 12));
        btn_cancel.setPreferredSize(new Dimension(85, 30));
        btn_cancel.setBorder(new RoundedBorder(Color.BLACK,1,25));
        btn_cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panelBotton.add(btn_cancel);
        
        updateTable();
    }

    public static int getRows() {
        return rows;
    }

    public static void setRows(int rows) {
        SupplierList.rows = rows;
    }

    public static int getColumns() {
        return columns;
    }

    public static void setColumns(int columns) {
        SupplierList.columns = columns;
    }

    @Override
    public void mouseClicked(MouseEvent e) {        
        int i = SupplierTable.getSelectedRow();
        
        if( i >= 0) {
            idSuppli = new String(SupplierTable.getValueAt(i, 0).toString());
            btn_addNew.setEnabled(false);
            
            if(supplierInterface == null) {
                btn_delete.setEnabled(true);
                btn_update.setEnabled(true);
            } else {
                btn_select.setEnabled(true);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

    public static void updateTable() {
        buildTable();
    }
}
