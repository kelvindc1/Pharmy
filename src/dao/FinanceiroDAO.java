/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.Financeiro;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import lib.ConexaoBD;
import lib.Formatting;
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
            if (o.getDt_pag() == null) {
                if (o.getId_financeiro() == 0) {
                    sql = "INSERT INTO financeiro VALUES ("
                            + "DEFAULT, "
                            + "'" + o.getTp_conta() + "',"
                            + "'" + o.getValor() + "',"
                            + "'" + o.getDt_inicio() + "',"
                            + "'" + o.getDt_final() + "',"
                            + " null , "
                            + "'" + o.getObs() + "',"
                            + "'" + o.getMulta() + "',"
                            + "'" + o.getId_forma_pag() + "')";
                } else {
                    sql = "UPDATE financeiro "
                            + "SET tp_conta = '" + o.getTp_conta() + "', "
                            + "valor = '" + o.getValor() + "', "
                            + "dt_inicio = '" + o.getDt_inicio() + "', "
                            + "dt_final = '" + o.getDt_final() + "', "
                            + "dt_pag = null , "
                            + "obs = '" + o.getObs() + "', "
                            + "multa = '" + o.getMulta() + "', "
                            + "id_forma_pag = '" + o.getId_forma_pag() + "' "
                            + "WHERE id_financeiro = " + o.getId_financeiro();
                }
            } else {
                if (o.getId_financeiro() == 0) {
                    sql = "INSERT INTO financeiro VALUES ("
                            + "DEFAULT, "
                            + "'" + o.getTp_conta() + "',"
                            + "'" + o.getValor() + "',"
                            + "'" + o.getDt_inicio() + "',"
                            + "'" + o.getDt_final() + "',"
                            + "'" + o.getDt_pag() + "',"
                            + "'" + o.getObs() + "',"
                            + "'" + o.getMulta() + "',"
                            + "'" + o.getId_forma_pag() + "')";
                } else {
                    sql = "UPDATE financeiro "
                            + "SET tp_conta = '" + o.getTp_conta() + "', "
                            + "valor = '" + o.getValor() + "', "
                            + "dt_inicio = '" + o.getDt_inicio() + "', "
                            + "dt_final = '" + o.getDt_final() + "', "
                            + "dt_pag = '" + o.getDt_pag() + "', "
                            + "obs = '" + o.getObs() + "', "
                            + "multa = '" + o.getMulta() + "', "
                            + "id_forma_pag = '" + o.getId_forma_pag() + "' "
                            + "WHERE id_financeiro = " + o.getId_financeiro();
                }
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

    public ArrayList<Financeiro> consultar(String tp, String dt1, String dt2) {
        Financeiro finaceiro = null;
        ArrayList<Financeiro> x = new ArrayList();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT (f.valor+f.multa) AS valor ,f.dt_inicio "
                    + "FROM financeiro f "
                    + "WHERE f.tp_conta = '"+tp+"' AND f.dt_inicio BETWEEN '"+dt1+"' AND '"+dt2+"'";

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                finaceiro = new Financeiro();

                // obtem dados do RS
                finaceiro.setValor(resultadoQ.getBigDecimal("valor"));
                finaceiro.setDt_inicio(resultadoQ.getDate("dt_inicio"));
                x.add(finaceiro);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar ArrayList: " + e);
        }
        return x;
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
                finaceiro.setValor(resultadoQ.getBigDecimal("valor"));
                finaceiro.setDt_inicio(resultadoQ.getDate("dt_inicio"));
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

    public void popularTabela(JTable tabela, String data1, String data2, String criterio, String tp) {
// dados da tabela
        Object[][] dadosTabela = null;
        String dt1 = "01/01/1900";
        String dt2 = "31/12/2080";

        // cabecalho da tabela
        Object[] cabecalho = new Object[9];
        cabecalho[0] = "Id";
        cabecalho[1] = "Título";
        cabecalho[2] = "Tipo de Conta";
        cabecalho[3] = "Valor";
        cabecalho[4] = "Multa";
        cabecalho[5] = "Forma de Pagamento";
        cabecalho[6] = "Data Início";
        cabecalho[7] = "Data Final";
        cabecalho[8] = "Data Pagamento";

        // cria matriz de acordo com nº de registros da tabela
        try {

            System.out.println("---------00");

            if (Formatting.removerFormatacao(data1).equals("") && Formatting.removerFormatacao(data2).equals("")) {

                System.out.println("---------01");

                if (tp.equals("")) {

                    System.out.println("---------02");

                    resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                            + "SELECT count(*) "
                            + "FROM financeiro f "
                            + "WHERE f.obs ILIKE '%" + criterio + "%' AND "
                            + "f.dt_inicio BETWEEN '" + dt1 + "' AND '" + dt2 + "'");
                } else {

                    System.out.println("---------03");

                    resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                            + "SELECT count(*) "
                            + "FROM financeiro f "
                            + "WHERE f.obs ILIKE '%" + criterio + "%' AND f.tp_conta = '" + tp + "' AND "
                            + "f.dt_inicio BETWEEN '" + dt1 + "' AND '" + dt2 + "'");
                }

            } else {

                System.out.println("---------04");

                if (tp.equals("")) {
                    System.out.println("---------05");
                    resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                            + "SELECT count(*) "
                            + "FROM financeiro f "
                            + "WHERE f.obs ILIKE '%" + criterio + "%' AND "
                            + "f.dt_inicio BETWEEN '" + data1 + "' AND '" + data2 + "'");

                } else {
                    System.out.println("---------06");
                    resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                            + "SELECT count(*) "
                            + "FROM financeiro f "
                            + "WHERE f.obs ILIKE '%" + criterio + "%' AND f.tp_conta = '" + tp + "' AND "
                            + "f.dt_inicio BETWEEN '" + data1 + "' AND '" + data2 + "'");

                }
            }
            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][9];

        } catch (Exception e) {
            System.out.println("Erro ao consultar de FINANCEIRO: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            if (Formatting.removerFormatacao(data1).equals("") && Formatting.removerFormatacao(data2).equals("")) {

                System.out.println("---------07");

                if (tp.equals("")) {

                    System.out.println("---------08");

                    resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                            + "SELECT f.id_financeiro, f.obs, f.tp_conta,f.valor, f.dt_pag, f.multa, fp.nome, f.dt_inicio, f.dt_final "
                            + "FROM financeiro f, forma_pagamento fp "
                            + "WHERE f.obs ILIKE '%" + criterio + "%' AND "
                            + "f.id_forma_pag = fp.id_forma_pag AND f.dt_inicio BETWEEN '" + dt1 + "' AND '" + dt2 + "' "
                            + "ORDER BY f.id_financeiro ");
                } else {

                    System.out.println("---------09");

                    resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                            + "SELECT f.id_financeiro, f.obs, f.tp_conta,f.valor, f.dt_pag, f.multa, fp.nome, f.dt_inicio, f.dt_final "
                            + "FROM financeiro f, forma_pagamento fp "
                            + "WHERE f.obs ILIKE '%" + criterio + "%' AND f.tp_conta = '" + tp + "' AND "
                            + "f.id_forma_pag = fp.id_forma_pag AND f.dt_inicio BETWEEN '" + dt1 + "' AND '" + dt2 + "' "
                            + "ORDER BY f.id_financeiro ");

                }
            } else {
                System.out.println("---------10");
                if (tp.equals("")) {
                    System.out.println("---------11");
                    resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                            + "SELECT f.id_financeiro, f.obs, f.tp_conta,f.valor, f.dt_pag, f.multa, fp.nome, f.dt_inicio, f.dt_final "
                            + "FROM financeiro f, forma_pagamento fp "
                            + "WHERE f.obs ILIKE '%" + criterio + "%' AND "
                            + "f.id_forma_pag = fp.id_forma_pag AND f.dt_inicio BETWEEN '" + data1 + "' AND '" + data2 + "' "
                            + "ORDER BY f.id_financeiro ");
                } else {
                    System.out.println("---------12");
                    resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                            + "SELECT f.id_financeiro, f.obs, f.tp_conta,f.valor, f.dt_pag, f.multa, fp.nome, f.dt_inicio, f.dt_final "
                            + "FROM financeiro f, forma_pagamento fp "
                            + "WHERE f.obs ILIKE '%" + criterio + "%' AND f.tp_conta = '" + tp + "' AND "
                            + "f.id_forma_pag = fp.id_forma_pag AND f.dt_inicio BETWEEN '" + data1 + "' AND '" + data2 + "' "
                            + "ORDER BY f.id_financeiro ");
                }
                System.out.println("");
                System.out.println("");
                System.out.println("");
            }
            while (resultadoQ.next()) {
                dadosTabela[lin][0] = resultadoQ.getInt("id_financeiro");
                dadosTabela[lin][1] = resultadoQ.getString("obs");

                if (resultadoQ.getString("tp_conta").equals("E")) {
                    dadosTabela[lin][2] = "Entrada";
                }
                if (resultadoQ.getString("tp_conta").equals("S")) {
                    dadosTabela[lin][2] = "Saída";
                }
                //dadosTabela[lin][2] = resultadoQ.getString("tp_conta");
                dadosTabela[lin][3] = resultadoQ.getBigDecimal("valor");
                dadosTabela[lin][4] = resultadoQ.getBigDecimal("multa");
                dadosTabela[lin][5] = resultadoQ.getString("nome");
                dadosTabela[lin][6] = Formatting.ajustaDataDMA(resultadoQ.getString("dt_inicio"));
                dadosTabela[lin][7] = Formatting.ajustaDataDMA(resultadoQ.getString("dt_final"));
                dadosTabela[lin][8] = Formatting.ajustaDataDMA(resultadoQ.getString("dt_pag"));

                // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela de FINANCEIRO");
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

    @Override
    public ArrayList<Financeiro> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
