/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.Fornecedor;
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
 * @author Win10
 */
public class FornecedorDAO implements IDAO_T<Fornecedor> {

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Fornecedor o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "";
            if (o.getId_forne() == 0) {
                sql = "INSERT INTO fornecedor VALUES ("
                        + "DEFAULT, "
                        + "'" + o.getCnpj() + "',"
                        + "'" + o.getRazao_social() + "',"
                        + "'" + o.getFantasia() + "',"
                        + "'" + o.getTelefone() + "',"
                        + "'" + o.getEmail() + "',"
                        + "'" + o.getId_cid() + "',"
                        + "'" + o.getDt_cadastro() + "',"
                        + "'" + o.getSituacao() + "')";
            } else {
                sql = "UPDATE fornecedor "
                        + "SET cnpj = '" + o.getCnpj() + "',"
                        + "razao_social = '" + o.getRazao_social() + "',"
                        + "fantasia= '" + o.getFantasia() + "',"
                        + "telefone = '" + o.getTelefone() + "',"
                        + "email = '" + o.getEmail() + "',"
                        + "id_cid = '" + o.getId_cid() + "',"
                        + "dt_cadastro = '" + o.getDt_cadastro() + "',"
                        + "situacao = '" + o.getSituacao() + "',"
                        + "WHERE id_forne = " + o.getId_forne();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao salvar FORNECEDOR = " + e);
            return false;
        }
    }

    @Override
    public boolean atualizar(Fornecedor o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM fornecedor "
                    + "WHERE id_forne= " + id;

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e);
            return false;
        }

    }

    @Override
    public ArrayList<Fornecedor> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Fornecedor> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Fornecedor consultarId(int id) {
        Fornecedor forn = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM fornecedor "
                    + "WHERE id_forne = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                forn = new Fornecedor();

                // obtem dados do RS
                forn.setId_forne(resultadoQ.getInt("id_forne"));
                forn.setCnpj(resultadoQ.getString("cnpf"));
                forn.setRazao_social(resultadoQ.getString("razao_social"));
                forn.setFantasia(resultadoQ.getString("fantasia"));
                forn.setTelefone(resultadoQ.getString("telefone"));
                forn.setEmail(resultadoQ.getString("email"));
                forn.setId_cid(resultadoQ.getInt("id_cid"));
                forn.setDt_cadastro(resultadoQ.getDate("dt_cadastro"));
                forn.setSituacao(resultadoQ.getString("situcao"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }
        return forn;

    }

    public void popularTabela(JTable tabela, String criterio) {
// dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[9];
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome Fantásia";
        cabecalho[2] = "Razão Social";
        cabecalho[3] = "CNPJ";
        cabecalho[4] = "Telefone";
        cabecalho[5] = "E-mail";
        cabecalho[6] = "Cidade";
        cabecalho[7] = "Data de Catastro";
        cabecalho[8] = "Situação";
        
        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM fornecedor f "
                    + "WHERE "
                    + "f.fantasia ILIKE '%" + criterio + "%'");

            resultadoQ.next();
            System.out.println("aqui " + resultadoQ.toString());
            dadosTabela = new Object[resultadoQ.getInt(1)][9];

        } catch (Exception e) {
            System.out.println("Erro ao consultar de FORNECEDOR: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT f.id_forne,f.fantasia, f.razao_social, f.cnpj,f.telefone, f.email, c.nome||'-'||e.sigla AS cidade, f.dt_cadastro, f.situacao "
                    + "FROM fornecedor f, cidade c, estado e "
                    + "WHERE f.id_cid = c.id_cid AND e.id_est = c.id_est AND "
                    + "f.fantasia  ILIKE '%" + criterio + "%' "
                    + "ORDER BY f.id_forne");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id_forne");
                dadosTabela[lin][1] = resultadoQ.getString("fantasia");
                dadosTabela[lin][2] = resultadoQ.getString("razao_social");
                dadosTabela[lin][3] = resultadoQ.getString("cnpj");
                dadosTabela[lin][4] = resultadoQ.getString("telefone");
                dadosTabela[lin][5] = resultadoQ.getString("email");
                dadosTabela[lin][6] = resultadoQ.getInt("cidade");
                dadosTabela[lin][7] = resultadoQ.getDate("dt_cadastro");
                dadosTabela[lin][8] = resultadoQ.getString("situacao");

                // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela de BENEFÍCIOS");
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
}
