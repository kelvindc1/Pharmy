package dao;

import lib.ConexaoBD;
import lib.Formatting;
import lib.IDAO_T;
import control.Filtros;
import control.Pedido;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author ykelv
 */
public class PedidoDAO implements IDAO_T<Pedido> {

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Pedido o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int salvarPed(Pedido o) {
        try {
//          
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "";
            if (o.getId_pedido() == 0) {
                sql = "INSERT INTO pedido VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getId_cliente() + "',"
                        + "'" + o.getId_func() + "',"
                        + "'" + o.getDt_pedido() + "',"
                        + "'" + o.getDt_pag() + "',"
                        + "'" + o.getValor_total() + "',"
                        + "'" + o.getId_financeiro() + "',"
                        + "'" + o.getSituacao() + "',"
                        + "'" + o.getQtd_total_itens() + "')";
            } else {
                sql = "UPDATE pedido "
                        + "SET situacao = '" + o.getSituacao() + "', "
                        + "id_func = '" + o.getId_func() + "', "
                        + "valor_total = '" + o.getValor_total() + "', "
                        + "dt_pedido = '" + o.getDt_pedido() + "', "
                        + "id_cliente = '" + o.getId_cliente() + "', "
                        + "dt_pag = '" + o.getDt_pag() + "', "
                        + "id_financeiro = '" + o.getId_financeiro() + "', "
                        + "qtd_total_itens = '" + o.getQtd_total_itens() + "' "
                        + "WHERE id_pedido = " + o.getId_pedido();
            }

            System.out.println("SQL: " + sql);

            st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            resultadoQ = st.getGeneratedKeys();
            int id = 0;
            if (resultadoQ.next()) {
                id = resultadoQ.getInt(1);
            }

            System.out.println(id);

            return id;

        } catch (Exception e) {
            System.out.println("Erro salvar pedido = " + e);
            return 0;
        }
    }

    public boolean atualizar(Pedido o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM pedido "
                    + "WHERE id_pedido = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta - exclusao
            int resultado = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e);
            return false;
        }
    }

    @Override
    public ArrayList<Pedido> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pedido> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pedido consultarId(int id) {
        Pedido pedido = null; //= new Pedido();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM pedido "
                    + "WHERE id_pedido = " + id
                    + "ORDER BY id_pedido";

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                pedido = new Pedido();

                // obtem dados do RS
                pedido.setId_pedido(resultadoQ.getInt("id_pedido"));
                pedido.setId_cliente(resultadoQ.getInt("id_cliente"));
                pedido.setSituacao(resultadoQ.getString("situacao"));
                pedido.setId_func(resultadoQ.getInt("id_func"));
                pedido.setValor_total(resultadoQ.getBigDecimal("valor_total"));
                pedido.setId_financeiro(resultadoQ.getInt("id_financeiro"));
                pedido.setDt_pedido(resultadoQ.getDate("dt_pedido"));
                pedido.setDt_pag(resultadoQ.getDate("dt_pag"));
                pedido.setQtd_total_itens(resultadoQ.getInt("qtd_total_itens"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return pedido;
    }

    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Código";
        cabecalho[1] = "Valor Total";
        cabecalho[2] = "Quantidade Itens";
        cabecalho[3] = "Data Pedido";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM pedido "
                    + "WHERE "
                    + "situacao ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][4];

        } catch (Exception e) {
            System.out.println("Erro ao consultar XXX: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM pedido "
                    + "WHERE "
                    + "situacao ILIKE '%" + criterio + "%' ORDER BY id_pedido");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id_pedido");
                dadosTabela[lin][1] = resultadoQ.getBigDecimal("valor_total");
                dadosTabela[lin][2] = resultadoQ.getInt("qtd_total_itens");
                dadosTabela[lin][3] = Formatting.ajustaDataDMA(resultadoQ.getDate("dt_pedido").toString());

                // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
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

                if (column == 4) {
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
                    setBackground(Color.GRAY);
                } else {
                    setBackground(Color.LIGHT_GRAY);
                }
                return this;
            }
        });
    }

    public void popularTabela2(JTable tabela, Filtros f) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Código";
        cabecalho[1] = "Valor Total";
        cabecalho[2] = "Quantidade Itens";
        cabecalho[3] = "Data Pedido";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM pedido ");
            //      + "WHERE "
            //      + "situacao ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][4];

        } catch (Exception e) {
            System.out.println("Erro ao consultar XXX: " + e);
        }

        int lin = 0;

        String sql = "";
        // efetua consulta na tabela
        try {

            sql = "SELECT * FROM pedido WHERE 1=1 ";

            if (f.getDt_inicial() != null && f.getDt_final() != null) {
                sql = sql + " AND dt_pedido BETWEEN '" + f.getDt_inicial() + "' AND '" + f.getDt_final() + "' ";
            }

            if (f.getFuncionario() != null) {
                sql = sql + " AND id_func = " + f.getFuncionario();
            }

            if (f.getForma_pagamento() != null) {
                sql = sql + " AND id_financeiro = " + f.getForma_pagamento();
            }

            if (f.getQtd_itens() != 0) {
                sql = sql + " AND qtd_total_itens = " + f.getQtd_itens();
            }

            if (f.getSituacao()) {
                sql = sql + " AND situacao = 'A' ";
            } else {
                sql = sql + " AND situacao = 'I' ";
            }

            sql = sql + " ORDER BY id_pedido ";

            System.out.println(sql);
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id_pedido");
                dadosTabela[lin][1] = resultadoQ.getBigDecimal("valor_total");
                dadosTabela[lin][2] = resultadoQ.getInt("qtd_total_itens");
                dadosTabela[lin][3] = Formatting.ajustaDataDMA(resultadoQ.getDate("dt_pedido").toString());

                // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
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

                if (column == 4) {
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
                    setBackground(Color.GRAY);
                } else {
                    setBackground(Color.LIGHT_GRAY);
                }
                return this;
            }
        });
    }

}
