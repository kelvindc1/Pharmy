/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.Tipo_Beneficio;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lib.ConexaoBD;
import lib.IDAOT;

/**
 *
 * @author Cristian
 */
public class Tipo_BeneficioDAO implements IDAOT <Tipo_Beneficio>{
private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Tipo_Beneficio o) {
try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "";
            if (o.getId_tpbeneficio()== 0) {
                sql = "INSERT INTO tipo_beneficio VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getNome() + "',"
                        + "'" + o.getObs() + "')";
            } else {
                sql = "UPDATE tipo_beneficio "
                        + "SET nome = '" + o.getNome() + "',"
                        + "descricao = '" + o.getObs() + "',"
                        + "WHERE id = " + o.getId_tpbeneficio();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao salvar Tipo de Benefício = " + e);
            return false;
        }
    }

    @Override
    public boolean atualizar(Tipo_Beneficio o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Tipo_Beneficio> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Tipo_Beneficio> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tipo_Beneficio consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
