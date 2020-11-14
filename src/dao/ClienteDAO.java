/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.Cliente;
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
public class ClienteDAO implements IDAO_T<Cliente> {

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Cliente o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "";
            if (o.getId_cliente() == 0) {
                sql = "INSERT INTO cliente VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getNome() + "',"
                        + "'" + o.getCpf() + "',"
                        + "'" + o.getRg() + "',"
                        + "'" + o.getTelefone() + "',"
                        + "'" + o.getDt_cadastro() + "',"
                        + "'" + o.getSexo() + "',"
                        + "'" + o.getId_cid() + "',"
                        + "'" + o.getSituacao() + "')";
            } else {
                sql = "UPDATE cliente "
                        + "SET nome = '" + o.getNome() + "',"
                        + "cpf = '" + o.getCpf() + "',"
                        + "rg = '" + o.getRg() + "',"
                        + "telefone = '" + o.getTelefone() + "',"
                        + "dt_cadastro = '" + o.getDt_cadastro() + "',"
                        + "sexo ='" + o.getSexo() + "',"
                        + "id_cid ='" + o.getId_cid() + "',"
                        + "situacao = '" + o.getSituacao() + "'"
                        + "WHERE id_cliente = " + o.getId_cliente();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar cliente = " + e);
            return false;
        }

    }

    @Override
    public boolean atualizar(Cliente o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM cliente "
                    + "WHERE id_cliente = " + id;

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e);
            return false;
        }
    }

    @Override
    public ArrayList<Cliente> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cliente> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente consultarId(int id) {
        Cliente pessoa = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM cliente "
                    + "WHERE id_cliente = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                pessoa = new Cliente();

                // obtem dados do RS
                pessoa.setId_cliente(resultadoQ.getInt("id_cliente"));
                pessoa.setNome(resultadoQ.getString("nome"));
                pessoa.setCpf(resultadoQ.getString("cpf"));
                pessoa.setRg(resultadoQ.getString("rg"));
                pessoa.setTelefone(resultadoQ.getString("telefone"));
                pessoa.setDt_cadastro(resultadoQ.getDate("dt_cadastro"));  
                pessoa.setSexo(resultadoQ.getString("sexo"));
                pessoa.setId_cid(resultadoQ.getInt("id_cid"));
                pessoa.setSituacao(resultadoQ.getString("situacao"));

            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }
        return pessoa;
    }

    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[8];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Cpf";
        cabecalho[3] = "Rg";
        cabecalho[4] = "Telefone";
        cabecalho[5] = "Sexo";
        cabecalho[6] = "Data de cadastro";
        cabecalho[7] = "Situação";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM cliente "
                    + "WHERE "
                    + "NOME ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][8];

        } catch (Exception e) {
            System.out.println("Erro ao consultar XXX: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM cliente "
                    + "WHERE "
                    + "NOME ILIKE '%" + criterio + "%' ORDER BY id_cliente");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id_cliente");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = Formatting.ajustarCpf(resultadoQ.getString("cpf"));
                dadosTabela[lin][3] = resultadoQ.getString("rg");
                dadosTabela[lin][4] = Formatting.ajustarTelefone(resultadoQ.getString("telefone"));
                dadosTabela[lin][5] = resultadoQ.getString("sexo");
                dadosTabela[lin][6] = Formatting.ajustaDataDMA(resultadoQ.getString("dt_cadastro"));
                dadosTabela[lin][7] = resultadoQ.getString("situacao");

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

                if (column == 8) {
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
                    + "SELECT MAX(os.id_cliente) "
                    + "FROM cliente os");

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

