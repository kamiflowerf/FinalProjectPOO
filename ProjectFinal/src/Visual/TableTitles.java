package Visual;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

public class TableTitles implements TableCellRenderer {

    /*
     * Esta clase tiene la función de personalizar el encabezado de la tabla para definir el color que tendrán las columnas.
     */

    @Override
    public Component getTableCellRendererComponent(JTable ClientTable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        JComponent jcomponent = null;
        
        // Se verifica que el contenido de la tabla sea de tipo String
        if(value instanceof String) {
            jcomponent = new JLabel((String) value); // Si es un String, se convierte en JLabel
            ((JLabel) jcomponent).setHorizontalAlignment(SwingConstants.CENTER); // Se alinea el texto al centro
            ((JLabel) jcomponent).setSize(30, jcomponent.getWidth()); // Se establece el tamaño del JLabel
            ((JLabel) jcomponent).setPreferredSize(new Dimension(6, jcomponent.getWidth())); // Se establece el tamaño preferido
        }
        
        // Se establece el borde del componente con un color blanco
        jcomponent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(255, 255, 255)));
        
        // Se establece el componente como opaco para que se muestre el fondo
        jcomponent.setOpaque(true);
        
        // Se establece el color de fondo del componente
        jcomponent.setBackground(new Color(65, 65, 65));
        
        // Se establece el texto de la herramienta que se mostrará al pasar el cursor sobre el encabezado
        jcomponent.setToolTipText("LISTADO CLIENTES");
        
        // Se establece el color del texto del componente
        jcomponent.setForeground(Color.white);
        
        // Se devuelve el componente personalizado
        return jcomponent;
    }
}
