/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.Cliente;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lib.ConexaoBD;
import lib.IDAOT;

/**
 *
 * @author Cristian
 */
public class ClienteDAO implements IDAOT<Cliente> {

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Cliente o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "";
            if (o.getId_cliente() == 0) {
                sql = "INSERT INTO cliente VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getNome() + "',"
                        + "'" + o.getCpf() + "',"
                        + "'" + o.getRg() + "',"
                        + "'" + o.getTelefone() + "',"
                        + "'" + o.getDt_cadastro() + "',"
                        + "'" + o.getSexo() + "',"
                        + "'" + o.getId_cid() + "',"
                        + "'" + o.getSituacao() + "')";
            } else {
                sql = "UPDATE cliente "
                        + "SET nome = '" + o.getNome() + "',"
                        + "cpf = '" + o.getCpf() + "',"
                        + "rg = '" + o.getRg() + "',"
                        + "telefone = '" + o.getTelefone() + "',"
                        + "dt_cadastro = '" + o.getDt_cadastro() + "',"
                        + "sexo ='" + o.getSexo() + "',"
                        + "id_cid ='" + o.getId_cid() + "',"
                        + "situacao = '" + o.getSituacao() + "'"
                        + "WHERE id = " + o.getId_cliente();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar cliente = " + e);
            return false;
        }

    }

    @Override
    public boolean atualizar(Cliente o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM cliente "
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
    public ArrayList<Cliente> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cliente> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente consultarId(int id) {
        Cliente pessoa = null;

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
                pessoa = new Cliente();

                // obtem dados do RS
                pessoa.setId_cliente(resultadoQ.getInt("id"));
                pessoa.setNome(resultadoQ.getString("nome"));
                pessoa.setCpf(resultadoQ.getString("cpf"));
                pessoa.setRg(resultadoQ.getString("rg"));
                pessoa.setTelefone(resultadoQ.getString("telefone"));
                pessoa.setDt_cadastro(resultadoQ.getTime("dt_cadastro"));  //verificar se o getTime ta certo
                pessoa.setSexo(resultadoQ.getString("sexo"));
                pessoa.setId_cid(resultadoQ.getInt("id_cid"));
                pessoa.setSituacao(resultadoQ.getString("situacao"));

            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return pessoa;

    }

}
