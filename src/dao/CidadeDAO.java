/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import lib.ConexaoBD;
import control.Cidade;
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
 * @author kelvin.costa
 */

public class CidadeDAO {
    
    private ResultSet resultadoQ = null;
    
    //@Override
    public boolean salvar(Cidade o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public int salvarCID(Cidade o) {
        try {        
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "";
            if (o.getId_cid() == 0) {
                sql = "INSERT INTO cidade VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getNome() + "',"
                        + "'" + o.getId_est() + "')";
            } else {
                sql = "UPDATE cidade "
                        + "SET nome = '" + o.getNome() + "', "
                        + "id_est = '" + o.getId_est() + "' "
                        + "WHERE id_cid = " + o.getId_cid();
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
            System.out.println("Erro salvar cidade = " + e);
            return 0;
        }
    }

    //@Override
    public boolean atualizar(Cidade o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM cidade "
                    + "WHERE id_cid = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta - exclusao
            int resultado = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e);
            return false;
        }
    }

    //@Override
    public ArrayList<Cidade> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public ArrayList<Cidade> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override    
    public Cidade consultarId(int id) {
        Cidade cidade = null; //= new Cidade();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM cidade "
                    + "WHERE id_cid = " + id
                    + "ORDER BY id_cid";

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                cidade = new Cidade();

                // obtem dados do RS
                cidade.setId_cid(resultadoQ.getInt("id_cid"));
                cidade.setNome(resultadoQ.getString("nome"));
                cidade.setId_est(resultadoQ.getInt("id_est"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return cidade;
    }
    
    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Estado";
        
        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM cidade "
                    + "WHERE "
                    + "NOME ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][3];

        } catch (Exception e) {
            System.out.println("Erro ao consultar XXX: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT c.id_cid, c.nome, e.nome as nome_estado "
                    + "FROM cidade c, estado e "
                    + "WHERE "
                    + "c.nome ILIKE '%" + criterio + "%' AND "
                    + "c.id_est = e.id_est ORDER BY c.nome");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id_cid");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getString("nome_estado");

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

        // configuracões adicionais no componente tabela
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
                    setBackground(Color.GRAY);
                } else {
                    setBackground(Color.LIGHT_GRAY);
                }
                return this;
            }
        });
    }
    
}
