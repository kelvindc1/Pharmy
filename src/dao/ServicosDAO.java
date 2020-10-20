/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.Servicos;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lib.ConexaoBD;
import lib.IDAO_T;

/**
 *
 * @author kelvin.costa
 */
public class ServicosDAO implements IDAO_T<Servicos> {

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Servicos o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "";
            if (o.getId_servicos() == 0) {
                sql = "INSERT INTO servicos VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getId_tpservicos() + "',"
                        + "'" + o.getDescricao() + "',"
                        + "'" + o.getValor() + "',"
                        + "'" + o.getSituacao() + "')";
            } else {
                sql = "UPDATE servicos "
                        + "SET id_tpservicos = '" + o.getId_tpservicos() + "',"
                        + "descricao = '" + o.getDescricao() + "',"
                        + "valor = '" + o.getValor() + "',"
                        + "situacao = '" + o.getSituacao() + "',"
                        + "WHERE id = " + o.getId_servicos();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar Serviço = " + e);
            return false;
        }

    }

    @Override
    public boolean atualizar(Servicos o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM servicos "
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
    public ArrayList<Servicos> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Servicos> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Servicos consultarId(int id) {
        Servicos servicos = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM servicos "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                servicos = new Servicos();

                // obtem dados do RS
                servicos.setId_servicos(resultadoQ.getInt("id_servicos"));
                servicos.setId_tpservicos(resultadoQ.getInt("id_tpservicos"));
                servicos.setDescricao(resultadoQ.getString("descricao"));
                servicos.setValor(resultadoQ.getBigDecimal("valor"));
                servicos.setSituacao(resultadoQ.getString("situacao"));

            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return servicos;
    }
}
