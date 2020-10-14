/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Cristiano Peiter <cristiano.peiter@universo.univates.br>
 * @param <T>
 */
public class GenericList<T extends Entity> extends javax.swing.JInternalFrame 
{

    private final Class<T> entityClass;

    public GenericList(Class<T> e) 
    {
        entityClass = e;
    }

    public void popularTabela(JTable table, List<T> objs, Cabecalho cabecalho) throws Exception 
    {
        //prepara dados para tabela
        Object[][] dadosTabela = new Object[objs.size()][cabecalho.getColumns().length];
        for (int i = 0; i < objs.size(); i++) 
        {
            for (int j = 0; j < cabecalho.getColumns().length; j++) 
            {
                if (!"id".equals(cabecalho.getColumns()[j].getName_bd())) 
                {
                    //verifica se precisa transformar campo foreign key
                    if (cabecalho.getColumns()[j].isTransformes()) 
                    {
                        //pega valor do campo
                        Field field = objs.get(i).getClass().getDeclaredField(cabecalho.getColumns()[j].getName_bd());
                        field.setAccessible(true);
                        Object objectValue = field.get(objs.get(i));

                        //transforma foreign key
                        ResultSet resultado = new ConexaoBD().getConnection().createStatement().executeQuery("SELECT " + cabecalho.getColumns()[j].getColuna_transformes() + " FROM " + cabecalho.getColumns()[j].getTabela_Transformes() + " WHERE id = " + objectValue + " LIMIT 1");
                        while (resultado.next()) 
                        {
                            dadosTabela[i][j] = resultado.getString(1);
                        }

                    } 
                    else 
                    {
                        Field field = objs.get(i).getClass().getDeclaredField(cabecalho.getColumns()[j].getName_bd());
                        field.setAccessible(true);
                        Object objectValue = field.get(objs.get(i));
                        dadosTabela[i][j] = objectValue;
                    }
                } 
                else 
                {
                    //pega valor do campo
                    dadosTabela[i][j] = objs.get(i).getId();
                }
            }
        }

        //prepara titulos para tabela
        Object[] dadosTitulos = new Object[cabecalho.getColumns().length];
        Column colunas[] = cabecalho.getColumns();
        int count = 0;
        for (Column co : colunas) 
        {
            dadosTitulos[count] = co.getName();
            count++;
        }

        // configuracoes adicionais no componente tabela
        table.setModel(new DefaultTableModel(dadosTabela, dadosTitulos) 
        {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) 
            {
                return false;
            }
        });

        // permite seleção de apenas uma linha da tabela
        table.setSelectionMode(0);

        //tamanho das colunas
        for (int i = 0; i < table.getColumnCount(); i++) 
        {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(colunas[i].getSize());
        }

        // renderizacao das linhas da tabela = mudar a cor
//        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value,
//                    boolean isSelected, boolean hasFocus, int row, int column) {
//                super.getTableCellRendererComponent(table, value, isSelected,
//                        hasFocus, row, column);
//                if (row % 2 == 0) {
//                    setBackground(Color.WHITE);
//                } else {
//                    setBackground(Color.LIGHT_GRAY);
//                }
//                return this;
//            }
//        });
    }

    public void telaCadastro(JDialog form) throws Exception 
    {
        //exibe o form no centro da tela
        form.setLocationRelativeTo(null);
        form.setVisible(true);
    }

    public void limparCampos(Container container) 
    {
        Component c[] = container.getComponents();
        for (int i = 0; i < c.length; i++) 
        {
            if (c[i] instanceof JFormattedTextField) 
            {
                JFormattedTextField field = (JFormattedTextField) c[i];
                field.setValue("");
            } else if (c[i] instanceof JTextField) 
            {
                JTextField field = (JTextField) c[i];
                field.setText("");
            } else if (c[i] instanceof JScrollPane) 
            {
                ((JTextArea) ((JScrollPane) c[i]).getViewport().getComponent(0)).setText("");
            } else if (c[i] instanceof JComboBox) 
            {
                JComboBox cb = (JComboBox) c[i];
                cb.setSelectedIndex(-1);
            } else if (c[i] instanceof JCheckBox) 
            {
                JCheckBox ckb = (JCheckBox) c[i];
                ckb.setSelected(false);
            }
        }
    }

    public static boolean validarCampoVazio(JFormattedTextField campo) 
    {
        Validation validation = new Validation();
        return Validation.validarCampoComConteudo(campo);
    }

    public static boolean validarCampoVazio(JTextField campo) 
    {
        Validation validation = new Validation();
        return Validation.validarCampoComConteudo(campo);
    }
}
