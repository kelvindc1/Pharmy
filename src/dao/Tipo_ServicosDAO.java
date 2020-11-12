package dao;

import control.Tipo_Servicos;
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
 * @author kelvin.costa
 */
public class Tipo_ServicosDAO implements IDAO_T<Tipo_Servicos> {

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Tipo_Servicos o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "";
            if (o.getId_tpservicos() == 0) {
                sql = "INSERT INTO tipo_servicos VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getDescricao() + "',"
                        + "'" + o.getSituacao() + "')";
            } else {
                sql = "UPDATE tipo_servicos "
                        + "SET descricao = '" + o.getDescricao() + "',"
                        + "situacao = '" + o.getSituacao() + "' "
                        + "WHERE id_tpservicos = " + o.getId_tpservicos();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao salvar TIPO DE SERVICO = " + e);
            return false;
        }
    }

    @Override
    public boolean atualizar(Tipo_Servicos o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM tipo_servicos "
                    + "WHERE id_tpservicos = " + id;

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e);
            return false;
        }
    }

    @Override
    public ArrayList<Tipo_Servicos> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Tipo_Servicos> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tipo_Servicos consultarId(int id) {
        Tipo_Servicos tpServicos = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM tipo_servicos "
                    + "WHERE id_tpservicos = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                tpServicos = new Tipo_Servicos();

                // obtem dados do RS
                tpServicos.setId_tpservicos(resultadoQ.getInt("id_tpservicos"));
                tpServicos.setDescricao(resultadoQ.getString("descricao"));
                tpServicos.setSituacao(resultadoQ.getString("situacao"));

            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }
        return tpServicos;
    }

    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Situação";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM tipo_servicos ts "
                    + "WHERE "
                    + "ts.descricao ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][3];

        } catch (Exception e) {
            System.out.println("Erro ao consultar de TIPO DE SERVIÇOS: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM tipo_servicos ts "
                    + "WHERE "
                    + "ts.descricao ILIKE '%" + criterio + "%' "
                    + "ORDER BY ts.id_tpservicos");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id_tpservicos");
                dadosTabela[lin][1] = resultadoQ.getString("descricao");
                dadosTabela[lin][2] = resultadoQ.getString("situacao");

                // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela de TIPO DE SERVIÇO");
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
                    + "SELECT MAX(ts.id_tpservicos) "
                    + "FROM tipo_servicos ts");

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
