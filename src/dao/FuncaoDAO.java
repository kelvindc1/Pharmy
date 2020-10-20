/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.Funcao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lib.ConexaoBD;
import lib.IDAO_T;

/**
 *
 * @author Cristian
 */
public class FuncaoDAO implements IDAO_T<Funcao> {

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Funcao o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "";
            if (o.getId_funcao() == 0) {
                sql = "INSERT INTO funcao VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getNome() + "',"
                        + "'" + o.getDescricao() + "',"
                        + "'" + o.getSituacao() + "')";
            } else {
                sql = "UPDATE funcao "
                        + "SET nome = '" + o.getNome() + "',"
                        + "descricao = '" + o.getDescricao() + "',"
                        + "situacao = '" + o.getSituacao() + "',"
                        + "WHERE id = " + o.getId_funcao();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar Função = " + e);
            return false;
        }

    }

    @Override
    public boolean atualizar(Funcao o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM funcao "
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
    public ArrayList<Funcao> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Funcao> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcao consultarId(int id) {
        Funcao func = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM funcao "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                func = new Funcao();

                // obtem dados do RS
                func.setId_funcao(resultadoQ.getInt("id_funcao"));
                func.setNome(resultadoQ.getString("nome"));
                func.setDescricao(resultadoQ.getString("descricao"));
                func.setSituacao(resultadoQ.getString("situacao"));

            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return func;
    }
}
