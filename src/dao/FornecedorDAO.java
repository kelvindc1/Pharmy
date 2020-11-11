/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.Fornecedor;
import java.sql.Statement;
import java.util.ArrayList;
import lib.ConexaoBD;
import lib.IDAO_T;

/**
 *
 * @author Win10
 */
public class FornecedorDAO implements IDAO_T<Fornecedor>{

    @Override
    public boolean salvar(Fornecedor o) {
 try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "";
            if (o.getId_beneficio() == 0) {
                sql = "INSERT INTO beneficio VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getDescricao() + "',"
                        + "'" + o.getValor() + "',"
                        + "'" + o.getId_contrato() + "',"
                        + "'" + o.getId_tpbeneficio() + "',"
                        + "'" + o.getSituacao() + "')";
            } else {
                sql = "UPDATE beneficio "
                        + "SET descricao = '" + o.getDescricao() + "',"
                        + "valor = '" + o.getValor() + "',"
                        + "id_contrato = '" + o.getId_contrato() + "',"
                        + "id_tbbeneficio = '" + o.getId_tpbeneficio() + "',"
                        + "situacao = '" + o.getSituacao() + "',"
                        + "WHERE id = " + o.getId_beneficio();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao salvar Benefício = " + e);
            return false;
        }
    }

    @Override
    public boolean atualizar(Fornecedor o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Fornecedor> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Fornecedor> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Fornecedor consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
