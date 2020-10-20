/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.Marca;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lib.ConexaoBD;
import lib.IDAO_T;

/**
 *
 * @author Cristian
 */
public class MarcaDAO implements IDAO_T<Marca> {

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Marca o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "";
            if (o.getId_marca() == 0) {
                sql = "INSERT INTO marca VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getNome() + "')";
            } else {
                sql = "UPDATE marca "
                        + "SET nome = '" + o.getNome() + "',"
                        + "WHERE id = " + o.getId_marca();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar marca = " + e);
            return false;
        }
    }

    @Override
    public boolean atualizar(Marca o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM marca "
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
    public ArrayList<Marca> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Marca> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Marca consultarId(int id) {
        Marca marca = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM marca "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                marca = new Marca();

                // obtem dados do RS
                marca.setId_marca(resultadoQ.getInt("id_marca"));
                marca.setNome(resultadoQ.getString("nome"));

            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }
        return marca;
    }
}
