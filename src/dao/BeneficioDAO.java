/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.Beneficio;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lib.ConexaoBD;
import lib.IDAOT;

/**
 *
 * @author Cristian
 */
public class BeneficioDAO implements IDAOT<Beneficio> {

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Beneficio o) {
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
    public boolean atualizar(Beneficio o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM beneficio "
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
    public ArrayList<Beneficio> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Beneficio> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Beneficio consultarId(int id) {
        Beneficio benef = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM tipo_beneficio "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                benef = new Beneficio();

                // obtem dados do RS
                benef.setId_beneficio(resultadoQ.getInt("id_beneficio"));
                benef.setDescricao(resultadoQ.getString("descricao"));
                benef.setValor(resultadoQ.getBigDecimal("valor"));
                benef.setId_contrato(resultadoQ.getInt("id_contrato"));
                benef.setId_tpbeneficio(resultadoQ.getInt("id_tpbeneficio"));
                benef.setSituacao(resultadoQ.getString("situcao"));

            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }
        return benef;
    }
}
