package Visual;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CustomTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private final String[] columnNames = {"", "Lista de componentes", ""};
    private List<DataWrapper> data;

	public CustomTableModel() {
        data = new ArrayList<>();
    }

	public List<DataWrapper> getData() {
		return data;
	}

    public void setData(List<DataWrapper> data) {
        this.data = data;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return (data.size() + 2) / 3; // Número de filas necesario para acomodar todos los elementos
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int dataIndex = rowIndex * 3 + columnIndex;
        if (dataIndex < data.size()) {
            return data.get(dataIndex);
        } else {
            return null; // Si no hay datos, devuelve nulo
        }
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
        int dataIndex = rowIndex * 3 + columnIndex;
        if (dataIndex < data.size()) {
            data.set(dataIndex, (DataWrapper) value);
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }
}
