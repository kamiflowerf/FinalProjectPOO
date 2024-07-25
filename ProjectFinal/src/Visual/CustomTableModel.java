package Visual;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class CustomTableModel extends AbstractTableModel {
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

