/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.DadosBancarios;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lib.ConexaoBD;
import lib.IDAO_T;

/**
 *
 * @author Cristian
 */
public class DadosBancariosDAO implements IDAO_T<DadosBancarios> {

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(DadosBancarios o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "";
            if (o.getId_dados() == 0) {
                sql = "INSERT INTO dados_bancarios VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getConta() + "',"
                        + "'" + o.getAgencia() + "',"
                        + "'" + o.getId_banco() + "')";
            } else {
                sql = "UPDATE cliente "
                        + "SET conta = '" + o.getConta() + "',"
                        + "agencia = '" + o.getAgencia() + "',"
                        + "banco = '" + o.getId_banco() + "',"
                        + "WHERE id = " + o.getId_dados();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar Dados Bancários = " + e);
            return false;
        }

    }

    @Override
    public boolean atualizar(DadosBancarios o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM dados_bancarios "
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
    public ArrayList<DadosBancarios> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DadosBancarios> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DadosBancarios consultarId(int id) {
        DadosBancarios db = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM dados_bancarios "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                db = new DadosBancarios();

                // obtem dados do RS
                db.setId_dados(resultadoQ.getInt("id_dados"));
                db.setConta(resultadoQ.getInt("conta"));
                db.setAgencia(resultadoQ.getInt("agencia"));
                db.setId_banco(resultadoQ.getInt("id_banco"));

            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return db;
    }
}
