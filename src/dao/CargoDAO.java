/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.Cargo;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lib.ConexaoBD;
import lib.IDAO_T;

/**
 *
 * @author Cristian
 */
public class CargoDAO implements IDAO_T<Cargo> {

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Cargo o) {

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "";
            if (o.getId_cargo() == 0) {
                sql = "INSERT INTO cargo VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getNome() + "',"
                        + "'" + o.getDescricao() + "',"
                        + "'" + o.getId_funcao() + "'"
                        + "'" + o.getSituacao() + "')";
            } else {
                sql = "UPDATE cargo "
                        + "SET nome = '" + o.getNome() + "',"
                        + "descricao = '" + o.getDescricao() + "',"
                        + "id_funcao = '" + o.getId_funcao() + "',"
                        + "situacao = '" + o.getSituacao() + "',"
                        + "WHERE id = " + o.getId_cargo();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar Cargo = " + e);
            return false;
        }
    }

    @Override
    public boolean atualizar(Cargo o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM cargo "
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
    public ArrayList<Cargo> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cargo> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cargo consultarId(int id) {
        Cargo cargo = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM cargo "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                cargo = new Cargo();

                // obtem dados do RS
                cargo.setId_cargo(resultadoQ.getInt("id_cargo"));
                cargo.setNome(resultadoQ.getString("nome"));
                cargo.setDescricao(resultadoQ.getString("descricao"));
                cargo.setId_funcao(resultadoQ.getInt("id_funcao"));
                cargo.setSituacao(resultadoQ.getString("situacao"));

            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return cargo;
    }
}
