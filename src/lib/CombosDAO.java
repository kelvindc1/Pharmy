/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.sql.ResultSet;
import javax.swing.JComboBox;

/**
 *
 * @author pretto
 */
public class CombosDAO {

    ResultSet resultado = null;
    
    // construtor 1
    public void popularCombo(String tabela, JComboBox combo) {
        
        combo.removeAllItems();

        ComboItens item = new ComboItens();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        try {
            resultado = new ConexaoBD().getConnection().createStatement().executeQuery("select * from " + tabela);

            if (resultado.isBeforeFirst()) {
                while (resultado.next()) {
                    item = new ComboItens();
                    item.setCodigo(resultado.getInt(1));
                    item.setDescricao(resultado.getString(2));

                    combo.addItem(item);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.toString());
        }
    }

    // construtor 2
    public void popularCombo(String tabela, String campo1, String campo2, JComboBox combo, String complementoSQL) {
         
        combo.removeAllItems();
 
        ComboItens item = new ComboItens();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        try {
            resultado = new ConexaoBD().getConnection().createStatement().executeQuery("select * from " + tabela + " " + complementoSQL);

            if (resultado.isBeforeFirst()) {
                while (resultado.next()) {
                    item = new ComboItens();
                    item.setCodigo(resultado.getInt(campo1));
                    item.setDescricao(resultado.getString(campo2));

                    combo.addItem(item);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.toString());
        }
    }

    public void definirItemCombo(JComboBox combo, ComboItens item) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (((ComboItens) combo.getItemAt(i)).getCodigo() == (item.getCodigo())) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }
}
