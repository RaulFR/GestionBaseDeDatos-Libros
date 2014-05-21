/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Raul
 */
public class AgotandoseRenderer extends DefaultTableCellRenderer {

    public AgotandoseRenderer() {
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    protected void setValue(Object aValue) {
        //Cuando el stockActual sea menor de 10 se mostrara una imagen o la otra
        
        if ((aValue != null) && (aValue instanceof Number)) {
            Integer numberValue = (Integer) aValue;
            if (numberValue < 10) {
                setIcon(new ImageIcon(getClass().getResource("/img/OkTick.png")));
            } else {
                setIcon(new ImageIcon(getClass().getResource("/img/NoOkTick.jpg")));
            }
        }
    }

}
