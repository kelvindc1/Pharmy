/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.Banco;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lib.ConexaoBD;
import lib.IDAO_T;

/**
 *
 * @author Cristian
 */
public class BancoDAO implements IDAO_T<Banco> {

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Banco o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "";
            if (o.getId_banco() == 0) {
                sql = "INSERT INTO banco VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getNome() + "')";
            } else {
                sql = "UPDATE banco "
                        + "SET nome = '" + o.getNome() + "',"
                        + "WHERE id = " + o.getId_banco();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar banco = " + e);
            return false;
        }
    }

    @Override
    public boolean atualizar(Banco o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM banco "
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
    public ArrayList<Banco> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Banco> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Banco consultarId(int id) {
        Banco banco = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM cliente "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                banco = new Banco();

                // obtem dados do RS
                banco.setId_banco(resultadoQ.getInt("id"));
                banco.setNome(resultadoQ.getString("nome"));

            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }
        return banco;
    }
}
