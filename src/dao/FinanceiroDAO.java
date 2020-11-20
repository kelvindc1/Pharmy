/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.Banco;
import control.Financeiro;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import lib.ConexaoBD;
import lib.IDAO_T;

/**
 *
 * @author Cristian
 */
public class FinanceiroDAO implements IDAO_T<Financeiro> {

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Financeiro o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "";
            if (o.getId_financeiro() == 0) {
                sql = "INSERT INTO financeiro VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getTp_conta()+ "',"
                        + "'" + o.getValor() + "',"
                        + "'" + o.getDt_inicio() + "',"
                        + "'" + o.getDt_inicio() + "',"
                        + "'" + o.getDt_pag() + "',"
                        + "'" + o.getObs()+ "',"
                        + "'" + o.getMulta() + "',"
                        + "'" + o.getId_forma_pag() + "')";
            } else {
                sql = "UPDATE financeiro "
                        + "SET tp_conta = '" + o.getTp_conta() + "', "
                        + "valor = '"+o.getValor() +"', "
                        + "dt_inicio = '"+o.getDt_inicio() +"', "
                        + "dt_final = '"+o.getDt_final() +"', "
                        + "dt_pag = '"+o.getDt_pag() +"', "
                        + "obs = '"+o.getObs() +"', "
                        + "multa = '"+o.getMulta() +"', "
                        + "id_forma_pag = '"+o.getId_forma_pag() +"' "
                        + "WHERE id_financeiro = " + o.getId_financeiro();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar FINANCEIRO = " + e);
            return false;
        }
    }

    @Override
    public boolean atualizar(Financeiro o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM financeiro "
                    + "WHERE id_financeiro = " + id;

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e);
            return false;
        }
    }

    @Override
    public ArrayList<Financeiro> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Financeiro> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Financeiro consultarId(int id) {
        Financeiro finaceiro = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM financeiro "
                    + "WHERE id_financeiro = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                finaceiro = new Financeiro();

                // obtem dados do RS
                finaceiro.setId_financeiro(resultadoQ.getInt("id_financeiro"));
                finaceiro.setTp_conta(resultadoQ.getString("tp_conta"));
                finaceiro.setDt_inicio(resultadoQ.getDate("dt_inico"));
                finaceiro.setDt_final(resultadoQ.getDate("dt_final"));
                finaceiro.setDt_pag(resultadoQ.getDate("dt_pag"));
                finaceiro.setObs(resultadoQ.getString("obs"));
                finaceiro.setMulta(resultadoQ.getBigDecimal("multa"));
                finaceiro.setId_forma_pag(resultadoQ.getInt("id_forma_pag"));

            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }
        return finaceiro;
    }

    public void popularTabela(JTable tabela, String data1, String data2) {
// dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[8];
        cabecalho[0] = "Id";
        cabecalho[1] = "Tipo de Conta";
        cabecalho[2] = "Data Início";
        cabecalho[3] = "Data Final";
        cabecalho[4] = "Data Pagamento";
        cabecalho[5] = "Observação";
        cabecalho[6] = "Multa";
        cabecalho[7] = "Forma de Pagamento";
        
        
        if (data1.equals("")){
            data1 = "01/01/1910";
        }
        if (data2.equals("")){
            data2 = "31/12/2080";
        }

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM financeiro f "
                    + "WHERE "
                    + "f.dt_inicio BETWEEN '"+data1+"' AND '"+data2+"'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][8];

        } catch (Exception e) {
            System.out.println("Erro ao consultar de FINANCEIRO: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT f.id_financeiro, f.tp_conta, f.dt_inicio, f.dt_final, f.dt_pag, f.obs, f.multa, fp.nome "
                    + "FROM financeiro f, forma_pagamento fp "
                    + "WHERE  "
                    + "f.id_forma_pag = fp.id_forma_pag AND f.dt_inicio BETWEEN '"+data1+"' AND '"+data2+"' "
                    + "ORDER BY f.id_financeiro ");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id_financeiro");
                dadosTabela[lin][1] = resultadoQ.getString("tp_conta");
                dadosTabela[lin][2] = resultadoQ.getDate("dt_inicio");
                dadosTabela[lin][3] = resultadoQ.getDate("td_final");
                dadosTabela[lin][4] = resultadoQ.getDate("td_pag");
                dadosTabela[lin][5] = resultadoQ.getString("obs");
                dadosTabela[lin][6] = resultadoQ.getBigDecimal("multa");
                dadosTabela[lin][7] = resultadoQ.getString("nome");

                // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela de BANCO");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
                /*  
                 if (column == 3) {  // apenas a coluna 3 sera editavel
                 return true;
                 } else {
                 return false;
                 }
                 */
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
//                    return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
//                case 2:
//                    column.setPreferredWidth(14);
//                    break;
            }
        }
        // renderizacao das linhas da tabela = mudar a cor
        tabela.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                if (row % 2 == 0) {
                    setBackground(Color.WHITE);
                } else {
                    setBackground(Color.LIGHT_GRAY);
                }
                return this;
            }
        });
    }

    public String proximaId() {
        String resp = "";
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT MAX(os.id_financeiro) "
                    + "FROM financeiro os");

            resultadoQ.next();
            int aux = resultadoQ.getInt("max");
            aux = aux + 1;
            resp = aux + "";
        } catch (Exception e) {
            System.out.println("Erro ao achar próxima ID: " + e);
        }
        return resp;
    }

}
