/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package renderer;

import entities.Editoriales;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Raul
 */
public class EditorialesListRenderer implements ListCellRenderer{
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        //Se van a mostrar los elementos en un JLabel, que es el componente habitual en los JList
        DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);
        
        //Convertir el valor recibido (value) al tipo de datos corespondiente
        Editoriales editorial = (Editoriales) value;
        //Crear el texto que se quiere mostrar para cada objeto
        renderer.setText(editorial.getIdEditorial() + " " + editorial.getNombre() + "Telefono: "+ editorial.getTelefono());
        
        return renderer;
    }
    
}
