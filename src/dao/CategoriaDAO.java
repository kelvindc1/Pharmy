/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.Categoria;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lib.ConexaoBD;
import lib.IDAO_T;

/**
 *
 * @author Cristian
 */
public class CategoriaDAO implements IDAO_T<Categoria> {

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Categoria o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "";
            if (o.getId_cat() == 0) {
                sql = "INSERT INTO categoria VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getDescricao() + "',"
                        + "'" + o.getSituacao() + "')";
            } else {
                sql = "UPDATE categoria "
                        + "SET descricao = '" + o.getDescricao() + "',"
                        + "situacao = '" + o.getSituacao() + "',"
                        + "WHERE id = " + o.getId_cat();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao salvar categoria = " + e);
            return false;
        }
    }

    @Override
    public boolean atualizar(Categoria o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM categoria "
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
    public ArrayList<Categoria> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Categoria> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria consultarId(int id) {
        Categoria categoria = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM categoria "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                categoria = new Categoria();

                // obtem dados do RS
                categoria.setId_cat(resultadoQ.getInt("id_cat"));
                categoria.setDescricao(resultadoQ.getString("descricao"));
                categoria.setSituacao(resultadoQ.getString("situacao"));

            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }
        return categoria;
    }
}
