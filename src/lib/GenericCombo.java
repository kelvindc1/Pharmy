/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;

/**
 *
 * @author Cristiano Peiter <cristiano.peiter@universo.univates.br>
 */
public class GenericCombo {

    ResultSet resultado = null;

    public void popularCombo(String tabela, JComboBox combo) throws Exception {

        ComboItens item = new ComboItens();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        resultado = new ConexaoBD().getConnection().createStatement().executeQuery("select * from " + tabela);

        if (resultado.isBeforeFirst()) {
            while (resultado.next()) {
                item = new ComboItens();
                item.setCodigo(resultado.getInt(1));
                item.setDescricao(resultado.getString(2));

                combo.addItem(item);
            }
        }
    }
    
    public void popularCombo(String tabela, JComboBox combo, Order order, Filter... filters) throws Exception {

        String constraint = null;
        for (Filter filter : filters) 
        {
            if (constraint == null) 
            {
                constraint = filter.getStatement();
            } else 
            {
                constraint += " AND " + filter.getStatement();
            }
        }
        
        String sql = "SELECT * FROM " + tabela + " WHERE " + constraint + " " + order.getStatement();
        System.out.println(sql);
        ComboItens item = new ComboItens();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);
        
        Connection connection = ConexaoBD.getInstance().getConnection();
        
        PreparedStatement ps = connection.prepareStatement(sql);
        
        int aux = 1;
        for (int i = 1; i <= filters.length; i++) 
        {
            Filter filter = filters[i - 1];
            if (filter.getOperator() == Operator.ILIKE) 
            {
                ps.setObject(aux, "%" + filter.getValue() + "%");
            } 
            else 
            {
                ps.setObject(aux, filter.getValue());
            }
            aux++;
            if (filter.getOperator() == Operator.BET) 
            {
                ps.setObject(aux, filter.getValue2());
                aux++;
            }
        }
        System.out.println(ps);
        ResultSet resultado = ps.executeQuery();

        if (resultado.isBeforeFirst()) {
            while (resultado.next()) {
                item = new ComboItens();
                item.setCodigo(resultado.getInt(1));
                item.setDescricao(resultado.getString(2));

                combo.addItem(item);
            }
        }
    }

    public void definirItemCombo(JComboBox combo, int codigo) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (((ComboItens) combo.getItemAt(i)).getCodigo() == codigo) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }
}
