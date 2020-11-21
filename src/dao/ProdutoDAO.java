
package dao;

import lib.ConexaoBD;
import lib.IDAO_T;
import control.Produto;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author ykelv
 */
public class ProdutoDAO  implements IDAO_T <Produto> {
    
    private ResultSet resultadoQ = null;
    
    //@Override
    public boolean salvar(Produto o) {
        try {
//            Statement st = automedquinta.AutoMedQuinta.conexao.createStatement();
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "";
            if (o.getId_produto()== 0) {
                sql = "INSERT INTO produto VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getId_cat() + "',"
                        + "'" + o.getId_marca() + "',"
                        + "'" + o.getNome() + "'," 
                        + "'" + o.getGramatura() + "'," 
                        + "'" + o.getDescricao() + "',"
                        + "'" + o.getId_forne() + "',"       
                        + "'" + o.getId_tpremedio() + "',"
                        + "'" + o.getPreco() + "',"                
                        + "'" + o.getTipo() + "',"
                        + "'" + o.getSituacao() + "')";
            } else {
                sql = "UPDATE produto "
                        + "SET id_cat = '" + o.getId_cat() + "', "
                        + "id_marca = '" + o.getId_marca() + "', "
                        + "nome = '" + o.getNome() + "', "
                        + "gramatura = '" + o.getGramatura() + "', "
                        + "descricao = '" + o.getDescricao() + "', "
                        + "id_forne = '" + o.getId_forne() + "', "
                        + "id_tpremedio = '" + o.getId_tpremedio() + "', "
                        + "preco = '" + o.getPreco() + "', "                       
                        + "tipo = '" + o.getTipo() + "', "
                        + "situacao = '" + o.getSituacao() + "' "
                        + "WHERE id_produto = " + o.getId_produto();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro salvar produto = " + e);
            return false;
        }
    }

    public boolean atualizar(Produto o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM produto "
                    + "WHERE id_produto = " + id;

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
    public ArrayList<Produto> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Produto> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produto consultarId(int id) {
        Produto produto = null; //= new Produto();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM produto "
                    + "WHERE id_produto = " + id
                    + " ORDER BY id_produto";
 
            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                produto = new Produto();

                // obtem dados do RS
                produto.setId_produto(resultadoQ.getInt("id_produto"));
                produto.setId_cat(resultadoQ.getInt("id_cat"));
                produto.setId_marca(resultadoQ.getInt("id_marca"));
                produto.setNome(resultadoQ.getString("nome"));
                produto.setGramatura(resultadoQ.getString("gramatura"));               
                produto.setDescricao(resultadoQ.getString("descricao"));
                produto.setId_forne(resultadoQ.getInt("id_forne"));
                produto.setId_tpremedio(resultadoQ.getInt("id_tpremedio"));              
                produto.setPreco(resultadoQ.getBigDecimal("preco"));
                produto.setTipo(resultadoQ.getString("tipo"));
                produto.setSituacao(resultadoQ.getString("situacao"));
                
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return produto;
    }
    
    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Gramatura";
        cabecalho[3] = "Preço";
        cabecalho[4] = "Situação";
       
        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM produto "
                    + "WHERE "
                    + "NOME ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][5];

        } catch (Exception e) {
            System.out.println("Erro ao consultar XXX: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM produto "
                    + "WHERE "
                    + "nome ILIKE '%" + criterio + "%' ORDER BY id_produto");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id_produto");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getString("gramatura");
                dadosTabela[lin][3] = resultadoQ.getBigDecimal("preco");
                dadosTabela[lin][4] = resultadoQ.getString("situacao");

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

                if (column == 5) {
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
    
     public String proximaId() {
        String resp = "";
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT MAX(p.id_produto) "
                    + "FROM produto p");

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
