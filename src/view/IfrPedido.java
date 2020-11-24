package view;

import lib.ComboItens;
import lib.CombosDAO;
import lib.Formatting;
import lib.SoNumeros;
import com.sun.javafx.css.Combinator;
import dao.Forma_PagamentoDAO;
import dao.FuncionarioDAO;
import dao.ItensPedidoDAO; 
import dao.PedidoDAO;   
import dao.ProdutoDAO;  
import control.Filtros; 
import control.Forma_Pagamento;
import control.Funcionario;
import control.ItensPedido;
import control.ItensPedido;
import control.Pedido;
import control.Produto;
import dao.ItensPedidoDAO;
import dao.PedidoDAO;
import dao.ProdutoDAO;
import java.awt.event.ItemEvent;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DefaultFormatter;

/**
 *
 * @author kelvin.costa
 */
public class IfrPedido extends javax.swing.JInternalFrame {

    int id_ped = 0;
    private int codigoFuncionario = 0;
    private int codigoProduto = 0;
    private int codigoPagamento = 0;
    private Pedido pedido;

    public IfrPedido() {
        initComponents();

        new PedidoDAO().popularTabela(tblPedido, "");

        //DefaultTableModel modelo = (DefaultTableModel) tblPedido.getModel();
        //tblPedido.setRowSorter(new TableRowSorter(modelo));
        Formatting.formatarData(tffDataPedido);
        Formatting.formatarData(tffDt_inicial);
        Formatting.formatarData(tffDt_final);
        Formatting.formatarData(tffDataPag);       

        if (!tffDataPedido.getText().equals("")) {
            tffDataPedido.setText(Formatting.getDataAtual());
        }

        //new CombosDAO().popularCombo("funcionario", cmbFunc);
        new CombosDAO().popularCombo("funcionario", "id_func", "nome", cmbFunc, "where situacao = 'A' ORDER BY nome");
        new CombosDAO().popularCombo("funcionario", "id_func", "nome", cmbFunc2, "where situacao = 'A' ORDER BY nome");
        //new CombosDAO().popularCombo("produto", cmbProduto);
        new CombosDAO().popularCombo("produto", "id_produto", "nome", cmbProduto, "where situacao = 'A' ORDER BY nome");

        new CombosDAO().popularCombo("forma_pagamento", "id_forma_pag", "nome", cmbPagamento, "ORDER BY nome");
        new CombosDAO().popularCombo("forma_pagamento", "id_forma_pag", "nome", cmbPagamento2, "ORDER BY nome");

        SpQuantidade.setModel(new SpinnerNumberModel(0, 0, 100, 1));
        SpQtd2.setModel(new SpinnerNumberModel(0, 0, 100, 1));

        cbSituacao.setSelected(true);
        cbSituacao2.setSelected(true);

        pedido = new Pedido();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel23 = new javax.swing.JLabel();
        btnFechar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        tfdId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbSituacao = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cmbFunc = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        tffDataPedido = new javax.swing.JFormattedTextField();
        btAdicionar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tfdValorTotal = new javax.swing.JTextField();
        cmbProduto = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        tfdValor_unit = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        SpQuantidade = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        tfdQtdTotalItens = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        btnExcluir2 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbPagamento = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        tffDataPag = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnBuscarFinanceiro = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        btnBuscarServico = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        tfdIdFinanceiro = new javax.swing.JTextField();
        tfdIdServico = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        tfdIdCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        tfdCliente = new javax.swing.JTextField();
        tfdServico = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedido = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tfdBusca = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnPesquisarItens = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cmbPagamento2 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        btnPesquisar2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPesquisa = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        cmbFunc2 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        SpQtd2 = new javax.swing.JSpinner();
        tffDt_final = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        tffDt_inicial = new javax.swing.JFormattedTextField();
        cbSituacao2 = new javax.swing.JCheckBox();

        jLabel23.setForeground(new java.awt.Color(255, 0, 51));
        jLabel23.setText("* ");

        setTitle("Cadastro: Pedido");

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/iconeFechar.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        jLabel2.setText("Id Pedido");

        jLabel3.setText("Funcionário");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/iconeSalvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        tfdId.setEnabled(false);

        jLabel4.setText("Situação");

        cbSituacao.setText("Ativo");

        jLabel5.setText("Produto");

        jLabel24.setForeground(new java.awt.Color(255, 0, 51));
        jLabel24.setText("Campos com * são obrigatórios");

        jLabel20.setForeground(new java.awt.Color(255, 0, 51));
        jLabel20.setText("* ");

        jLabel22.setForeground(new java.awt.Color(255, 0, 51));
        jLabel22.setText("* ");

        cmbFunc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbFuncItemStateChanged(evt);
            }
        });

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblProduto);

        jLabel7.setText("Data");

        tffDataPedido.setEditable(false);

        btAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/add_icon-iconscom_52393.png"))); // NOI18N
        btAdicionar.setText("Adicionar Produto");
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        jLabel8.setText("Valor Total");

        tfdValorTotal.setEnabled(false);

        cmbProduto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProdutoItemStateChanged(evt);
            }
        });

        jLabel9.setText("Valor Unitário");

        tfdValor_unit.setEnabled(false);

        jLabel10.setText("Quantidade");

        jLabel11.setText(" Total de Itens");

        tfdQtdTotalItens.setEnabled(false);

        jLabel25.setForeground(new java.awt.Color(255, 0, 51));
        jLabel25.setText("* ");

        btnExcluir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/trash-can_115312 (1).png"))); // NOI18N
        btnExcluir2.setText("Excluir Item");
        btnExcluir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluir2ActionPerformed(evt);
            }
        });

        jLabel21.setForeground(new java.awt.Color(255, 0, 51));
        jLabel21.setText("* ");

        jLabel12.setText("Forma de Pgto");

        cmbPagamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPagamentoItemStateChanged(evt);
            }
        });

        jLabel27.setForeground(new java.awt.Color(255, 0, 51));
        jLabel27.setText("* ");

        jLabel13.setText("Data pagamento");

        jLabel26.setForeground(new java.awt.Color(255, 0, 51));
        jLabel26.setText("* ");

        jLabel28.setText("Id Financeiro");

        btnBuscarFinanceiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/seo-social-web-network-internet_340_icon-iconscom_61497.png"))); // NOI18N
        btnBuscarFinanceiro.setText("Buscar");
        btnBuscarFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFinanceiroActionPerformed(evt);
            }
        });

        jLabel29.setText("__________________________________________________________________________________________________________________________________________");

        jLabel31.setText("Id Servico");

        btnBuscarServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/seo-social-web-network-internet_340_icon-iconscom_61497.png"))); // NOI18N
        btnBuscarServico.setText("Buscar");
        btnBuscarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarServicoActionPerformed(evt);
            }
        });

        jLabel32.setForeground(new java.awt.Color(255, 0, 51));
        jLabel32.setText("* ");

        jLabel33.setForeground(new java.awt.Color(255, 0, 51));
        jLabel33.setText("* ");

        jLabel30.setText("Id Cliente");

        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/seo-social-web-network-internet_340_icon-iconscom_61497.png"))); // NOI18N
        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        jLabel34.setForeground(new java.awt.Color(255, 0, 51));
        jLabel34.setText("* ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5))
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cmbFunc, 0, 211, Short.MAX_VALUE)
                                            .addComponent(cmbProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel21))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel20)))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfdValor_unit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(SpQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcluir2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel28))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfdIdFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel27))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnBuscarFinanceiro)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tffDataPag, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel26))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbSituacao)
                                    .addGap(212, 212, 212)
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfdQtdTotalItens, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel22)
                                    .addGap(31, 31, 31)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfdValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel25)
                                    .addGap(78, 78, 78))
                                .addComponent(jLabel29)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(18, 18, 18)
                                .addComponent(tfdIdServico, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel32)
                                .addGap(18, 18, 18)
                                .addComponent(tfdServico))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addGap(21, 21, 21)
                                        .addComponent(tfdIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel34)
                                .addGap(18, 18, 18)
                                .addComponent(tfdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarServico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(467, 467, 467)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tffDataPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(tffDataPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(tfdIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34)
                            .addComponent(btnBuscarCliente)
                            .addComponent(tfdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(btnBuscarServico)
                            .addComponent(jLabel32)
                            .addComponent(tfdIdServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel9)
                    .addComponent(tfdValor_unit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(SpQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSalvar)
                                .addGap(7, 7, 7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(cbSituacao)
                                    .addComponent(jLabel11)
                                    .addComponent(tfdQtdTotalItens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel8)
                                    .addComponent(tfdValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel29)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(cmbPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel26)
                                        .addComponent(jLabel27)
                                        .addComponent(tffDataPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(btnBuscarFinanceiro)
                                    .addComponent(jLabel33)
                                    .addComponent(tfdIdFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(jLabel24))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnExcluir2)
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Cadastro", jPanel1);

        tblPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPedido);

        jLabel1.setText("Busca");

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/seo-social-web-network-internet_340_icon-iconscom_61497.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/trash-can_115312 (1).png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/iconeEditar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnPesquisarItens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/seo-social-web-network-internet_340_icon-iconscom_61497.png"))); // NOI18N
        btnPesquisarItens.setText("Consultar itens pedido");
        btnPesquisarItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarItensActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tfdBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisarItens)
                        .addGap(0, 438, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar)
                    .addComponent(btnPesquisarItens))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta", jPanel2);

        jPanel3.setLayout(null);

        jLabel14.setText("Data final");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(20, 80, 60, 14);

        jLabel15.setText("Funcionário");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(20, 130, 70, 14);

        jPanel3.add(cmbPagamento2);
        cmbPagamento2.setBounds(480, 20, 140, 30);

        jLabel16.setText("Situação");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(390, 130, 60, 14);

        btnPesquisar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/seo-social-web-network-internet_340_icon-iconscom_61497.png"))); // NOI18N
        btnPesquisar2.setText("Pesquisar");
        btnPesquisar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisar2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnPesquisar2);
        btnPesquisar2.setBounds(720, 60, 150, 50);

        tblPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblPesquisa);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(20, 170, 930, 280);

        jLabel17.setText("Forma de Pgto");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(390, 30, 110, 14);

        jPanel3.add(cmbFunc2);
        cmbFunc2.setBounds(100, 120, 160, 30);

        jLabel18.setText("Qtd. Itens");
        jPanel3.add(jLabel18);
        jLabel18.setBounds(390, 80, 70, 14);
        jPanel3.add(SpQtd2);
        SpQtd2.setBounds(480, 70, 60, 30);
        jPanel3.add(tffDt_final);
        tffDt_final.setBounds(100, 70, 160, 30);

        jLabel19.setText("Data Incial");
        jPanel3.add(jLabel19);
        jLabel19.setBounds(20, 30, 60, 14);
        jPanel3.add(tffDt_inicial);
        tffDt_inicial.setBounds(100, 20, 160, 30);

        cbSituacao2.setText("Ativo");
        jPanel3.add(cbSituacao2);
        cbSituacao2.setBounds(480, 120, 90, 30);

        jTabbedPane1.addTab("Filtro de Pesquisa", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addContainerGap())
        );

        setBounds(150, 70, 1140, 742);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        /*try {

            String idString = String.valueOf(tblPedido.getValueAt(tblPedido.getSelectedRow(), 0));

            id_ped = Integer.parseInt(idString);

            PedidoDAO pDAO = new PedidoDAO();

            pedido = pDAO.consultarId(id_ped);

            if (pedido != null) {
                cbSituacao.setSelected(pedido.getSituacao().equals("A"));

                Funcionario funcionario = new FuncionarioDAO().consultarId(pedido.getId_func());
                ComboItens cbItem = new ComboItens(funcionario.getId_func(), funcionario.getNome());
                cmbFunc.getModel().setSelectedItem(cbItem);

                Forma_Pagamento forma_pagamento = new Forma_PagamentoDAO().consultarId(pedido.getId_financeiro()); // tem que pegar o id da forma de pagamento
                ComboItens cbItem2 = new ComboItens(forma_pagamento.getId_forma_pag(), forma_pagamento.getDescricao());  // tem que pegar o id da forma de pagamento
                cmbPagamento.getModel().setSelectedItem(cbItem2);

                if (id_ped > 0) {
                    new ItensPedidoDAO().consultarIdPedido(id_ped).forEach(item -> pedido.adicionarItemPedido(item));
                    popularTableItens(pedido);
                    pedido.calcularTotalItens();
                    pedido.calcularValorTotal();       
                }
      
                tfdValorTotal.setText(String.valueOf(pedido.getValor_total()));
                tfdQtdTotalItens.setText(String.valueOf(pedido.getQtd_total_itens()));
                
                tfdIdCliente.setText(String.valueOf(pedido.getId_cliente()));
                
                tfdId.setText(String.valueOf(pedido.getId_pedido()));

                jTabbedPane1.setSelectedIndex(0);
            } else {
                System.out.println("Erro na consulta");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para editar");
        }*/
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {

            String idString = String.valueOf(tblPedido.getValueAt(tblPedido.getSelectedRow(), 0));

            id_ped = Integer.parseInt(idString);

            PedidoDAO pDAO = new PedidoDAO();

            if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?") == JOptionPane.OK_OPTION) {
                if (pDAO.excluir(id_ped)) {
                    JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
                    new PedidoDAO().popularTabela(tblPedido, tfdBusca.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Problemas ao excluir registro!");
                }
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para excluir");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        new PedidoDAO().popularTabela(tblPedido, tfdBusca.getText());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void cmbPagamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPagamentoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            ComboItens ci = (ComboItens) cmbPagamento.getSelectedItem();
            codigoPagamento = ci.getCodigo();
        }
    }//GEN-LAST:event_cmbPagamentoItemStateChanged

    private void btnExcluir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluir2ActionPerformed
        try {

            ItensPedido item = (ItensPedido) pedido.getItensPedido().get(tblProduto.getSelectedRow());
            pedido.removerItemPedido(item);
            popularTableItens(pedido);

            cmbProduto.setSelectedIndex(0);
            tfdValor_unit.setText("");
            SpQuantidade.setValue(0);

            pedido.calcularValorTotal();
            pedido.calcularTotalItens();
            tfdValorTotal.setText(String.valueOf(pedido.getValor_total()));
            tfdQtdTotalItens.setText(String.valueOf(pedido.getQtd_total_itens()));

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para excluir");
        }
    }//GEN-LAST:event_btnExcluir2ActionPerformed

    private void cmbProdutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProdutoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            ComboItens ci = (ComboItens) cmbProduto.getSelectedItem();
            codigoProduto = ci.getCodigo();
        }

        if (codigoProduto > 0) {
            Produto produto = new ProdutoDAO().consultarId(codigoProduto);
            tfdValor_unit.setText(produto.getPreco().toString());
        }
    }//GEN-LAST:event_cmbProdutoItemStateChanged

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        boolean continuar = true;

        if (tfdValor_unit.getText().equals("")
                || tffDataPedido.getText().equals("  /  /    ")
                || cmbFunc.getSelectedItem().equals("Selecione")
                || tfdIdServico.getText().equals("")
                || cmbProduto.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios (*)");
            continuar = false;
            tfdValor_unit.requestFocus();
        }

        if (SpQuantidade.getValue().equals(0)) {
            JOptionPane.showMessageDialog(null, "A quantidade não pode ser zero!");
            continuar = false;
        }

        if (continuar) {
            ItensPedido item = new ItensPedido();
            Produto produto = new ProdutoDAO().consultarId(codigoProduto);

            item.setProduto(produto);

            item.setItem_quant((int) SpQuantidade.getValue());
            item.setValor_unit(produto.getPreco());
                       
            String id_servicot = Formatting.removerFormatacao(tfdIdServico.getText());
            int id_servico = Integer.parseInt(id_servicot);
            item.setId_servicos(id_servico);
            
            pedido.adicionarItemPedido(item);
            
            //Não deixar editar a célula
            //tblProduto.
            popularTableItens(pedido);
            pedido.calcularValorTotal();
            pedido.calcularTotalItens();
            tfdValorTotal.setText(String.valueOf(pedido.getValor_total()));
            tfdQtdTotalItens.setText(String.valueOf(pedido.getQtd_total_itens()));

            //cmbPagamento.setEnabled(false);
         
            cmbFunc.setEnabled(false);   
        }
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void cmbFuncItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFuncItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            ComboItens ci = (ComboItens) cmbFunc.getSelectedItem();
            codigoFuncionario = ci.getCodigo();
        }
    }//GEN-LAST:event_cmbFuncItemStateChanged

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        boolean continuar = true;
        
        ItensPedido item = new ItensPedido();
        
        if(pedido.getItensPedido().size() == 0) {
            if (tfdValor_unit.getText().equals("")
                    || tfdQtdTotalItens.getText().equals("")
                    || tfdValorTotal.getText().equals("")
                    || tffDataPedido.getText().equals("  /  /    ")
                    || tffDataPag.getText().equals("  /  /    ")
                    || tfdIdFinanceiro.getText().equals("")
                    || tfdIdServico.getText().equals("")
                    || tfdIdCliente.getText().equals("")
                    || cmbPagamento.getSelectedItem().equals("Selecione")
                    || cmbFunc.getSelectedItem().equals("Selecione")
                    || cmbProduto.getSelectedItem().equals("Selecione")) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios (*)");
                continuar = false;
                tfdValor_unit.requestFocus();
            }
        }

        if (continuar) {

            if (cbSituacao.isSelected()) {
                pedido.setSituacao("A");
            } else {
                pedido.setSituacao("I");
            }

            try {
                Date dt_pedido = new SimpleDateFormat("dd/MM/yyyy").parse(tffDataPedido.getText());
                pedido.setDt_pedido(dt_pedido);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao converter a data!");
            }
            
            try {
                Date dt_pagamento = new SimpleDateFormat("dd/MM/yyyy").parse(tffDataPag.getText());
                pedido.setDt_pag(dt_pagamento);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao converter a data!");
            }

            if (codigoPagamento > 0) {
                //pedido.setId_pag(codigoPagamento);  //VER
                pedido.setId_financeiro(codigoPagamento); //VER
            }

            if (codigoFuncionario > 0) {
                pedido.setId_func(codigoFuncionario);
            }

            if (codigoProduto > 0) {
                Produto produto = new ProdutoDAO().consultarId(codigoProduto);
                tfdValor_unit.setText(produto.getPreco().toString());
            }

            String qtd_total_itensstr = Formatting.removerFormatacao(tfdQtdTotalItens.getText());
            int qtd_total_itens = Integer.parseInt(qtd_total_itensstr);
            pedido.setQtd_total_itens(qtd_total_itens);

            //String valor_totalstr = Formatting.removerFormatacao(tfdValorTotal.getText());
            //BigDecimal valor_total = BigDecimal.valueOf((double) 0);
            //pedido.setValor_total(valor_total);
            
            pedido.setValor_total(BigDecimal.valueOf(Double.parseDouble(tfdValorTotal.getText())));
            
            
            String id_financeirot = Formatting.removerFormatacao(tfdIdFinanceiro.getText());
            int id_financeiro = Integer.parseInt(id_financeirot);
            pedido.setId_financeiro(id_financeiro);
            
            String id_clientet = Formatting.removerFormatacao(tfdIdCliente.getText());
            int id_cliente = Integer.parseInt(id_clientet);
            pedido.setId_cliente(id_cliente);
                     
            //String id_servicot = Formatting.removerFormatacao(tfdIdServico.getText());
            //int id_servico = Integer.parseInt(id_servicot);
            //item.setId_servicos(id_servico);
            

            pedido.setId_pedido(id_ped);

            // salvar
       
            PedidoDAO pDAO = new PedidoDAO();
            id_ped = pDAO.salvarPed(pedido);

            if (id_ped > 0) {

                ItensPedidoDAO iDAO = new ItensPedidoDAO();
                iDAO.excluirIdPed(id_ped);

                for (int i = 0; i < pedido.getItensPedido().size(); i++) {
                    pedido.getItensPedido().get(i).setId_itens_ped(0);
                    pedido.getItensPedido().get(i).getPedido().setId_pedido(id_ped);
                    continuar = iDAO.salvar(pedido.getItensPedido().get(i));
                }

                if (continuar) {
                    JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");

                    pedido = new Pedido();

                    tfdValor_unit.setText("");
                    cbSituacao.isSelected();
                    cmbFunc.setEnabled(true);
                    cmbFunc.setSelectedIndex(0);
                    cmbProduto.setSelectedIndex(0);
                    tfdQtdTotalItens.setText("");
                    tfdValorTotal.setText("");
                    tfdValor_unit.setText("");
                    SpQuantidade.setValue(0);
                    cmbPagamento.setSelectedIndex(0);
                    tfdId.setText("");
                    tfdIdFinanceiro.setText("");
                    tfdIdServico.setText("");
                    tfdIdCliente.setText("");
                    tffDataPag.setText("");
                    tfdCliente.setText("");
                    tfdServico.setText("");

                    //Remover itens do pedido feito
                    tblProduto.setModel(new DefaultTableModel());

                    tfdValor_unit.requestFocus();

                    id_ped = 0;

                } else {
                    JOptionPane.showMessageDialog(null, "Problemas ao salvar registro!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Problemas ao salvar registro!");
            }
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisar2ActionPerformed
        try {
            Filtros f = new Filtros();

            if (!tffDt_inicial.getText().equals("  /  /    ")) {
                try {
                    Date Dt_inicial = new SimpleDateFormat("dd/MM/yyyy").parse(tffDt_inicial.getText());
                    f.setDt_inicial(Dt_inicial);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao converter a data!");
                }
            }

            if (!tffDt_final.getText().equals("  /  /    ")) {
                try {
                    Date Dt_final = new SimpleDateFormat("dd/MM/yyyy").parse(tffDt_final.getText());
                    f.setDt_final(Dt_final);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao converter a data!");
                }
            }

            if (cmbFunc2.getSelectedIndex() != 0) {
                ComboItens item = (ComboItens) cmbFunc2.getSelectedItem();
                f.setFuncionario(String.valueOf(item.getCodigo()));
            }

            if (cmbPagamento2.getSelectedIndex() != 0) {
                ComboItens item = (ComboItens) cmbPagamento2.getSelectedItem();
                f.setForma_pagamento(String.valueOf(item.getCodigo()));
            }

            f.setQtd_itens((int) SpQtd2.getValue());

            f.setSituacao(cbSituacao2.isSelected());

            PedidoDAO pDAO = new PedidoDAO();
            pDAO.popularTabela2(tblPesquisa, f);

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Adicione filtros");
        }
    }//GEN-LAST:event_btnPesquisar2ActionPerformed

    private void btnPesquisarItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarItensActionPerformed
        try {
            int id = (int) tblPedido.getValueAt(tblPedido.getSelectedRow(), 0);
            DlgPesquisarItens dlgPesqItens = new DlgPesquisarItens(new javax.swing.JFrame(), true, id);
            dlgPesqItens.setVisible(true);

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para ver os itens");
        }
    }//GEN-LAST:event_btnPesquisarItensActionPerformed

    private void btnBuscarFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFinanceiroActionPerformed
        DlgPesquisarFinanceiro dlgPesquisarFinanceiro = new DlgPesquisarFinanceiro(null, true, this);
        dlgPesquisarFinanceiro.setVisible(true);
    }//GEN-LAST:event_btnBuscarFinanceiroActionPerformed

    private void btnBuscarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarServicoActionPerformed
        DlgPesquisarServico dlgPesquisarServico = new DlgPesquisarServico(null, true, this);
        dlgPesquisarServico.setVisible(true);
    }//GEN-LAST:event_btnBuscarServicoActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        DlgPesquisarCliente dlgPesquisarCliente = new DlgPesquisarCliente(null, true, this);
        dlgPesquisarCliente.setVisible(true);
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void popularTableItens(Pedido pedido) {

        String[] colunas = {"Id Produto", "Nome", "Valor Unit.", "Qtd."};
        Object[][] dadosTabela = new Object[pedido.tamanhoListItens()][4];

        for (int linha = 0; linha < pedido.getItensPedido().size(); linha++) {
            dadosTabela[linha][0] = pedido.getItensPedido().get(linha).getProduto().getId_produto();
            dadosTabela[linha][1] = pedido.getItensPedido().get(linha).getProduto().getNome();
            dadosTabela[linha][2] = pedido.getItensPedido().get(linha).getValor_unit();
            dadosTabela[linha][3] = pedido.getItensPedido().get(linha).getItem_quant();
        }
  
        DefaultTableModel model = new DefaultTableModel(dadosTabela, colunas);
        tblProduto.setModel(model);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner SpQtd2;
    private javax.swing.JSpinner SpQuantidade;
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarFinanceiro;
    private javax.swing.JButton btnBuscarServico;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnExcluir2;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnPesquisar2;
    private javax.swing.JButton btnPesquisarItens;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox cbSituacao;
    private javax.swing.JCheckBox cbSituacao2;
    private javax.swing.JComboBox<String> cmbFunc;
    private javax.swing.JComboBox<String> cmbFunc2;
    private javax.swing.JComboBox<String> cmbPagamento;
    private javax.swing.JComboBox<String> cmbPagamento2;
    private javax.swing.JComboBox<String> cmbProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblPedido;
    private javax.swing.JTable tblPesquisa;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTextField tfdBusca;
    private javax.swing.JTextField tfdCliente;
    private javax.swing.JTextField tfdId;
    private javax.swing.JTextField tfdIdCliente;
    private javax.swing.JTextField tfdIdFinanceiro;
    private javax.swing.JTextField tfdIdServico;
    private javax.swing.JTextField tfdQtdTotalItens;
    private javax.swing.JTextField tfdServico;
    private javax.swing.JTextField tfdValorTotal;
    private javax.swing.JTextField tfdValor_unit;
    private javax.swing.JFormattedTextField tffDataPag;
    private javax.swing.JFormattedTextField tffDataPedido;
    private javax.swing.JFormattedTextField tffDt_final;
    private javax.swing.JFormattedTextField tffDt_inicial;
    // End of variables declaration//GEN-END:variables

    void definirValorFuncaoCliente(String id, String nome) {
        tfdIdCliente.setText(id);
        tfdCliente.setText(nome);
    }

    void definirValorFuncaoServicos(String id, String nome) {
        tfdIdServico.setText(id);
        tfdServico.setText(nome);
    }
    
    void definirValorFuncaoFinanceiro(String id) {
        tfdIdFinanceiro.setText(id);
    }

}
