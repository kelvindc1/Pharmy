/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.Forma_Pagamento;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lib.ConexaoBD;
import lib.IDAO_T;

/**
 *
 * @author kelvin.Costa
 */
public class Forma_PagamentoDAO implements IDAO_T<Forma_Pagamento> {

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Forma_Pagamento o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "";
            if (o.getId_forma_pag() == 0) {
                sql = "INSERT INTO forma_pagamento VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getNome() + "',"
                        + "'" + o.getDescricao() + "')";
            } else {
                sql = "UPDATE forma_pagamento "
                        + "SET nome = '" + o.getNome() + "',"
                        + "descricao = '" + o.getDescricao() + "',"
                        + "WHERE id = " + o.getId_forma_pag();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao salvar forma de pagamento = " + e);
            return false;
        }
    }

    @Override
    public boolean atualizar(Forma_Pagamento o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM forma_pagamento "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e);
            return false;
        }
    }

    @Override
    public ArrayList<Forma_Pagamento> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Forma_Pagamento> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Forma_Pagamento consultarId(int id) {
        Forma_Pagamento forma_pagamento = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM forma_pagamento "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                forma_pagamento = new Forma_Pagamento();

                // obtem dados do RS
                forma_pagamento.setId_forma_pag(resultadoQ.getInt("id_forma_pag"));
                forma_pagamento.setNome(resultadoQ.getString("nome"));
                forma_pagamento.setDescricao(resultadoQ.getString("descricao"));

            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }
        return forma_pagamento;
    }
}
