/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limiters;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Raul
 */
public class DocumentNumbersLimiter extends PlainDocument {

    private int limit;

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        String string = str;

        if (string == null) {
            return;
        }
        if ((getLength() + string.length()) > limit) {
            string = string.substring(0, limit - getLength());
        }

        if (string.equals("-") && offset == 0) {

        } else {
            try {
                Integer.valueOf(string);
            } catch (NumberFormatException ex) {
                return;
            }
        }

        super.insertString(offset, string, attr);
    }

}
