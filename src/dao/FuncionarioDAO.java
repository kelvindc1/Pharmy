/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.Funcionario;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lib.ConexaoBD;
import lib.IDAOT;

/**
 *
 * @author Cristian
 */
public class FuncionarioDAO implements IDAOT<Funcionario> {

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Funcionario o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "";
            if (o.getId_func() == 0) {
                sql = "INSERT INTO funcionario VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getNome() + "',"
                        + "'" + o.getCpf() + "',"
                        + "'" + o.getRg() + "',"
                        + "'" + o.getDt_nasc() + "',"
                        + "'" + o.getDt_admissao() + "',"
                        + "'" + o.getDt_demissao() + "',"
                        + "'" + o.getSexo() + "',"
                        + "'" + o.getTelefone() + "',"
                        + "'" + o.getId_contrato() + "',"
                        + "'" + o.getId_cid() + "',"
                        + "'" + o.getId_dados() + "',"
                        + "'" + o.getSituacao() + "')";
            } else {
                sql = "UPDATE funcionario "
                        + "SET nome = '" + o.getNome() + "',"
                        + "cpf = '" + o.getCpf() + "',"
                        + "rg = '" + o.getRg() + "',"
                        + "dt_nasc = '" + o.getDt_nasc() + "',"
                        + "dt_admissao = '" + o.getDt_admissao() + "',"
                        + "dt_demissao= '" + o.getDt_demissao() + "',"
                        + "sexo = '" + o.getSexo() + "',"
                        + "telefone = '" + o.getTelefone() + "',"
                        + "id_contrato = '" + o.getId_contrato() + "',"
                        + "id_cid ='" + o.getId_cid() + "',"
                        + "id_dados ='" + o.getId_dados() + "',"
                        + "situacao = '" + o.getSituacao() + "'"
                        + "WHERE id = " + o.getId_func();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar funcionário = " + e);
            return false;
        }
    }

    @Override
    public boolean atualizar(Funcionario o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM funcionario "
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
    public ArrayList<Funcionario> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Funcionario> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario consultarId(int id) {
        Funcionario pessoa = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM funcionario "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                pessoa = new Funcionario();

                // obtem dados do RS
                pessoa.setId_func(resultadoQ.getInt("id"));
                pessoa.setNome(resultadoQ.getString("nome"));
                pessoa.setCpf(resultadoQ.getString("cpf"));
                pessoa.setRg(resultadoQ.getString("rg"));
                pessoa.setDt_nasc(resultadoQ.getTime("dt_nasci"));  //verificar se o getTime ta certo
                pessoa.setDt_admissao(resultadoQ.getTime("dt_admissao"));  //verificar se o getTime ta certo
                pessoa.setDt_demissao(resultadoQ.getTime("dt_demissao"));  //verificar se o getTime ta certo
                pessoa.setSexo(resultadoQ.getString("sexo"));
                pessoa.setTelefone(resultadoQ.getString("telefone"));
                pessoa.setId_contrato(resultadoQ.getInt("id_contrato"));
                pessoa.setId_cid(resultadoQ.getInt("id_cid"));
                pessoa.setId_dados(resultadoQ.getInt("id_dados"));
                pessoa.setSituacao(resultadoQ.getString("situacao"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }
        return pessoa;
    }
}
