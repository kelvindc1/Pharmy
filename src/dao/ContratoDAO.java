/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.Contrato;
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
import lib.Formatting;
import lib.IDAO_T;

/**
 *
 * @author Cristian
 */
public class ContratoDAO implements IDAO_T<Contrato> {

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Contrato o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "";
            if (o.getId_contrato() == 0) {
                sql = "INSERT INTO contrato VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getId_setor() + "',"
                        + "'" + o.getSal_ant() + "',"
                        + "'" + o.getSal_novo() + "',"
                        + "'05/11/2020',"
                       // + "'" + o.getDt_alteracao() + "',"
                        + "'" + o.getObs() + "')";
            } else {
                sql = "UPDATE contrato "
                        + "SET id_setor = '" + o.getId_setor() + "',"
                        + "sal_ant = '" + o.getSal_ant() + "',"
                        + "sal_novo = '" + o.getSal_novo() + "',"
                        + "dt_alteracao = '27/11/2020',"
                       // + "dt_alteracao = '" + o.getDt_alteracao() + "',"
                        + "obs = '" + o.getObs() + "' "
                        + "WHERE id_contrato = " + o.getId_contrato();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar CONTRATO = " + e);
            return false;
        }

    }

    @Override
    public boolean atualizar(Contrato o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM contrato c "
                    + "WHERE c.id_contrato = " + id;

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e);
            return false;
        }
    }

    @Override
    public ArrayList<Contrato> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Contrato> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contrato consultarId(int id) {
        Contrato cont = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM contrato c "
                    + "WHERE c.id_contrato = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                cont = new Contrato();

                // obtem dados do RS
                cont.setId_contrato(resultadoQ.getInt("id_contrato"));
                cont.setId_setor(resultadoQ.getInt("id_setor"));
                cont.setSal_ant(resultadoQ.getBigDecimal("sal_ant"));
                cont.setSal_novo(resultadoQ.getBigDecimal("sal_novo"));
                cont.setDt_alteracao(resultadoQ.getDate("dt_alteracao"));
                cont.setObs(resultadoQ.getString("obs"));

            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return cont;
    }

    public void popularTabela(JTable tabela, String criterio) {
// dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[7];
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Setor";
        cabecalho[3] = "Salário Anterior";
        cabecalho[4] = "Salário Novo";
        cabecalho[5] = "Data da Alteração";
        cabecalho[6] = "Observação";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM contrato c ");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][7];

        } catch (Exception e) {
            System.out.println("Erro ao consultar de CONTRATO: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT c.id_contrato, f.nome, s.nome AS setor, c.sal_ant, c.sal_novo, c.dt_alteracao, c.obs "
                    + "FROM contrato c, funcionario f, setor s "
                    + "WHERE c.id_contrato = f.id_contrato AND c.id_setor = s.id_setor AND "
                    + "f.nome ILIKE '%" + criterio + "%' "
                    + "ORDER BY c.id_contrato ");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id_contrato");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getString("setor");
                dadosTabela[lin][3] = resultadoQ.getString("sal_ant");
                dadosTabela[lin][4] = resultadoQ.getString("sal_novo");
                dadosTabela[lin][5] = Formatting.ajustaDataDMA(resultadoQ.getString("dt_alteracao"));
                dadosTabela[lin][6] = resultadoQ.getString("obs");

                // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela de CONTRATO");
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
                    + "SELECT MAX(c.id_contrato) "
                    + "FROM contrato c");

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
