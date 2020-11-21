/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.ItensPedido;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import lib.ConexaoBD;
import lib.IDAO_T;

/**
 *
 * @author Win10/kelvin.costa
 */
public class ItensPedidoDAO implements IDAO_T<ItensPedido> {

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(ItensPedido o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "";
            if (o.getId_itens_ped() == 0) {
                sql = "INSERT INTO itens_pedido VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getPedido().getId_pedido() + "', "
                        + "'" + o.getProduto().getId_produto()+ "', "
                        + "'" + o.getItem_quant() + "', "
                        + "'" + o.getValor_unit() + "', "
                        + "'" + o.getId_servicos() + "')";
            } else {
                sql = "UPDATE itens_pedido "
                        + "SET id_pedido = '" + o.getPedido().getId_pedido()+ "', "
                        + "id_produto = '" + o.getProduto().getId_produto()+ "', "
                        + "item_quant = '" + o.getItem_quant()+ "',"
                        + "valor_unit = '" + o.getValor_unit() + "',"
                        + "id_servicos = '" + o.getId_servicos() + "',"
                        + "WHERE id_itens_ped = " + o.getId_itens_ped();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar ITENS PEDIDO = " + e);
            return false;
        }
    }

    @Override
    public boolean atualizar(ItensPedido o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM itens_pedido "
                    + "WHERE id_itens_ped = " + id;

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e);
            return false;
        }
    }

    @Override
    public ArrayList<ItensPedido> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ItensPedido> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ItensPedido consultarId(int id) {
        ItensPedido itensPed = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM itens_pedido "
                    + "WHERE id_itens_ped = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {

                itensPed = new ItensPedido();

                // obtem dados do RS
                itensPed.setId_itens_ped(resultadoQ.getInt("id_itens_ped"));
                itensPed.getPedido().setId_pedido(resultadoQ.getInt("id_pedido"));
                itensPed.getProduto().setId_produto(resultadoQ.getInt("id_produto")); 
                itensPed.setItem_quant(resultadoQ.getInt("item_quant"));
                itensPed.setValor_unit(resultadoQ.getBigDecimal("valor_unit"));
                itensPed.setId_servicos(resultadoQ.getInt("id_servicos"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }
        return itensPed;
    }
    
    public List<ItensPedido> consultarIdPedido(int id) {
        ItensPedido itens_pedido = null; //= new Itens_pedido();
        List<ItensPedido> itens = new ArrayList<>();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM itens_pedido i, produto p "
                    + "WHERE i.id_produto = p.id_produto  "
                    + " and id_pedido = " + id
                    + "ORDER BY id_itens_ped";

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);
      
            // avanca ResultSet
            while (resultadoQ.next()) {
                itens_pedido = new ItensPedido();

                // obtem dados do RS
                itens_pedido.setId_itens_ped(resultadoQ.getInt("id_itens_ped"));
                itens_pedido.getPedido().setId_pedido(resultadoQ.getInt("id_pedido"));
                itens_pedido.getProduto().setId_produto(resultadoQ.getInt("id_produto"));
                itens_pedido.getProduto().setDescricao(resultadoQ.getString("descricao"));
                itens_pedido.setItem_quant(resultadoQ.getInt("item_quant")); 
                itens_pedido.setValor_unit(resultadoQ.getBigDecimal("valor_unit"));
                itens_pedido.setId_servicos(resultadoQ.getInt("id_servicos"));
                
                itens.add(itens_pedido);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar itens pedido: " + e);
        }

        return itens;
    }
    
    public String proximaId() {
        String resp = "";
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT MAX(ip.id_itens_ped) "
                    + "FROM itens_pedido ip");

            resultadoQ.next();
            int aux = resultadoQ.getInt("max");
            aux = aux + 1;
            resp = aux + "";
        } catch (Exception e) {
            System.out.println("Erro ao achar próxima ID: " + e);
        }
        return resp;
    }
    
    public void popularTabela(JTable tabela, int id) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "Nome";
        cabecalho[1] = "Valor unitário";
        cabecalho[2] = "Quantidade";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM itens_pedido "
                    + "WHERE id_pedido = " + id
                    + "GROUP BY id_pedido "
                    + "ORDER BY id_pedido");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][3];

        } catch (Exception e) {
            System.out.println("Erro ao consultar itens_pedido: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT p.nome, ip.valor_unit, ip.item_quant "
                    + "FROM itens_pedido ip, produto p "
                    + "WHERE ip.id_produto=p.id_produto AND id_pedido = " + id 
                    + "ORDER BY id_pedido" );

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getString("nome");
                dadosTabela[lin][1] = resultadoQ.getBigDecimal("valor_unit");
                dadosTabela[lin][2] = resultadoQ.getInt("item_quant");

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

                if (column == 3) {
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
    
     //@Override
    public boolean excluirIdPed(int idPed) {
          try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM itens_pedido "
                    + "WHERE id_pedido = " + idPed;

            System.out.println("SQL: " + sql);

            // executa consulta - exclusao
            int resultado = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e);
            return false;
        }
    }

}
