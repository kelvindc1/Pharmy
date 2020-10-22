package lib;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author ykelv
 */
public class Limite_digitos extends PlainDocument {

    private int quantidadeMax;

    public Limite_digitos(int maxLen) {
        super();
        if (maxLen <= 0) 
            throw new IllegalArgumentException("Especifique a quantidade!");        
        quantidadeMax = maxLen;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException {
        if (str == null || getLength() == quantidadeMax) {
            return;
        }
        int totalquantia = (getLength() + str.length());
        if (totalquantia <= quantidadeMax) {
            super.insertString(offset, str.replaceAll("[^A-Z]", ""), attr);
            return;
        }
        String nova = str.substring(0, getLength() - quantidadeMax);
        super.insertString(offset, nova, attr);
    }

}
