/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.Login;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lib.ConexaoBD;
import lib.IDAO_T;

/**
 *
 * @author Win10
 */
public class LoginDAO implements IDAO_T<Login> {

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Login o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "";
            if (o.getId_login() == 0) {
                sql = "INSERT INTO login VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getId_func() + "',"
                        + "'" + o.getUsuario() + "',"
                        + "'" + o.getSenha() + "',"
                        + "'" + o.getEmail() + "',"
                        + "'" + o.getSituacao() + "')";
            } else {
                sql = "UPDATE login "
                        + "SET id_func = '" + o.getId_func() + "',"
                        + "usuario = '" + o.getUsuario() + "',"
                        + "senha = '" + o.getSenha() + "',"
                        + "email = '" + o.getEmail() + "',"
                        + "situacao = '" + o.getSituacao() + "',"
                        + "WHERE id = " + o.getId_login();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar Login " + e);
            return false;
        }

    }

    @Override
    public boolean atualizar(Login o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM login "
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
    public ArrayList<Login> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Login> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Login consultarId(int id) {
        Login log = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM login "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                log = new Login();

                // obtem dados do RS
                log.setId_login(resultadoQ.getInt("id_login"));
                log.setId_func(resultadoQ.getInt("id_func"));
                log.setUsuario(resultadoQ.getString("usuario"));
                log.setSenha(resultadoQ.getString("senha"));
                log.setEmail(resultadoQ.getString("email"));
                log.setSituacao(resultadoQ.getString("situcao"));

            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }
        return log;

    }

}
