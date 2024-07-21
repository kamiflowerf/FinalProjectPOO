package Visual;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] titles;
    private Object[][] data;
    
    public TableModel(String[] titles, Object[][] data) {
        super();
        
        //Validaciones para asegurar el mejor rendimiento de la tabla
        //Para que el titulo y los datos no sean nulos, vacio.
        if (titles == null || data == null) {
            throw new IllegalArgumentException("Titles and data cannot be null");
        }
        //Para que el tamaño de la columna sea proporcional al largo del titulo
        if (data.length > 0 && data[0].length != titles.length) {
            throw new IllegalArgumentException("Data column length must match titles length");
        }
        
        this.titles = titles;
        this.data = data;
        setDataVector(data, titles);
    }

    public String[] getTitles() {
        return titles;
    }

    public Object[][] getData() {
        return data;
    }
/*
    @Override
    public boolean isCellEditable(int row, int column) {
        // Aquí puedes definir qué celdas son editables
        return false; // Ejemplo: ninguna celda es editable
    }*/
}
