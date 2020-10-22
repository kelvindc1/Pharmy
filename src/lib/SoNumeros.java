
package lib;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class SoNumeros extends PlainDocument{
    
    @Override
    public void insertString(int i, String s, AttributeSet a) throws BadLocationException {
        super.insertString(i, s.replaceAll("[^0-9  | ^.]", ""), a);
    }
}
