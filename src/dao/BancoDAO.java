/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.Banco;
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
public class BancoDAO implements IDAO_T<Banco> {

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Banco o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "";
            if (o.getId_banco() == 0) {
                sql = "INSERT INTO banco VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getNome() + "')";
            } else {
                sql = "UPDATE banco "
                        + "SET nome = '" + o.getNome() + "' "
                        + "WHERE id_banco = " + o.getId_banco();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar BANCO = " + e);
            return false;
        }
    }

    @Override
    public boolean atualizar(Banco o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM banco "
                    + "WHERE id_banco = " + id;

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e);
            return false;
        }
    }

    @Override
    public ArrayList<Banco> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Banco> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Banco consultarId(int id) {
        Banco banco = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM banco "
                    + "WHERE id_banco = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                banco = new Banco();

                // obtem dados do RS
                banco.setId_banco(resultadoQ.getInt("id_banco"));
                banco.setNome(resultadoQ.getString("nome"));

            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }
        return banco;
    }

    public void popularTabela(JTable tabela, String criterio) {
// dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[2];
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM banco b "
                    + "WHERE "
                    + "b.nome ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][2];

        } catch (Exception e) {
            System.out.println("Erro ao consultar de BANCO: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM banco b "
                    + "WHERE  "
                    + "b.nome ILIKE '%" + criterio + "%' "
                    + "ORDER BY b.id_banco ");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id_banco");
                dadosTabela[lin][1] = resultadoQ.getString("nome");

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
                    + "SELECT MAX(os.id_banco) "
                    + "FROM banco os");

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
