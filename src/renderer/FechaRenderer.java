/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package renderer;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Raul
 */
public class FechaRenderer extends DefaultTableCellRenderer {
    
    public FechaRenderer() {
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public void setValue(Object aValue) {
        Object result = aValue;
        if ((aValue != null) && (aValue instanceof Date)) {
            Date dateValue = (Date) aValue;
            SimpleDateFormat formatFecha = new SimpleDateFormat("yyyy");
            result = formatFecha.format(dateValue);
        }
        super.setValue(result);
    }
}