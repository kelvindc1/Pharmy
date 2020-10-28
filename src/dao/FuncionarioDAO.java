/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.Funcionario;
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
public class FuncionarioDAO implements IDAO_T<Funcionario> {

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Funcionario o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "";
            if (o.getId_func() == 0) {
                sql = "INSERT INTO funcionario VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getNome() + "',"
                        + "'" + o.getCpf() + "',"
                        + "'" + o.getRg() + "',"
                        + "'" + o.getDt_nasc() + "',"
                        + "'" + o.getDt_admissao() + "',"
                        + "'" + o.getDt_demissao() + "',"
                        + "'" + o.getSexo() + "',"
                        + "'" + o.getTelefone() + "',"
                        + "'" + o.getId_contrato() + "',"
                        + "'" + o.getId_cid() + "',"
                        + "'" + o.getId_dados() + "',"
                        + "'" + o.getSituacao() + "')";
            } else {
                sql = "UPDATE funcionario "
                        + "SET nome = '" + o.getNome() + "',"
                        + "cpf = '" + o.getCpf() + "',"
                        + "rg = '" + o.getRg() + "',"
                        + "dt_nasc = '" + o.getDt_nasc() + "',"
                        + "dt_admissao = '" + o.getDt_admissao() + "',"
                        + "dt_demissao= '" + o.getDt_demissao() + "',"
                        + "sexo = '" + o.getSexo() + "',"
                        + "telefone = '" + o.getTelefone() + "',"
                        + "id_contrato = '" + o.getId_contrato() + "',"
                        + "id_cid ='" + o.getId_cid() + "',"
                        + "id_dados ='" + o.getId_dados() + "',"
                        + "situacao = '" + o.getSituacao() + "'"
                        + "WHERE id = " + o.getId_func();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar funcionário = " + e);
            return false;
        }
    }

    @Override
    public boolean atualizar(Funcionario o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM funcionario "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e);
            return false;
        }
    }

    @Override
    public ArrayList<Funcionario> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Funcionario> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario consultarId(int id) {
        Funcionario pessoa = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM funcionario "
                    + "WHERE id_func = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                pessoa = new Funcionario();

                // obtem dados do RS
                pessoa.setId_func(resultadoQ.getInt("id_func"));
                pessoa.setNome(resultadoQ.getString("nome"));
                pessoa.setCpf(resultadoQ.getString("cpf"));
                pessoa.setRg(resultadoQ.getString("rg"));
                pessoa.setDt_nasc(resultadoQ.getDate("dt_nasc"));
                pessoa.setDt_admissao(resultadoQ.getDate("dt_admissao"));
                pessoa.setDt_demissao(resultadoQ.getDate("dt_demissao"));
                pessoa.setSexo(resultadoQ.getString("sexo"));
                pessoa.setTelefone(resultadoQ.getString("telefone"));
                pessoa.setId_contrato(resultadoQ.getInt("id_contrato"));
                pessoa.setId_cid(resultadoQ.getInt("id_cid"));
                pessoa.setId_dados(resultadoQ.getInt("id_dados"));
                pessoa.setSituacao(resultadoQ.getString("situacao"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }
        return pessoa;
    }

    public void popularTabelaFiltro(JTable tabela, String criterio, String criterio2) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[2];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT f.id_func, f.nome "
                    + "FROM funcionario f "
                    + "WHERE "
                    + "f.nome ILIKE '%" + criterio + "%' AND f.situacao = '" + criterio2 + "'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][2];
        } catch (Exception e) {
            System.out.println("Erro ao consultar Filtro: " + e);
        }
        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT f.id_func, f.nome "
                    + "FROM funcionario f "
                    + "WHERE "
                    + "f.nome ILIKE '%" + criterio + "%' AND f.situacao = '" + criterio2 + "'");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id_func");
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

                if (column == 7) {
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

    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[7];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Cpf";
        cabecalho[3] = "Rg";
        cabecalho[4] = "Data de admissão";
        cabecalho[5] = "Sexo";
        cabecalho[6] = "Telefone";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM funcionario "
                    + "WHERE "
                    + "NOME ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][7];

        } catch (Exception e) {
            System.out.println("Erro ao consultar XXX: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM funcionario "
                    + "WHERE "
                    + "NOME ILIKE '%" + criterio + "%' ORDER BY id_func");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id_func");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getString("cpf");
                dadosTabela[lin][3] = resultadoQ.getString("rg");
                dadosTabela[lin][4] = resultadoQ.getDate("data_admissao");
                dadosTabela[lin][5] = resultadoQ.getString("sexo");
                dadosTabela[lin][6] = resultadoQ.getString("telefone");

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

                if (column == 7) {
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
