package view;

import lib.CombosDAO;
import lib.SoNumeros;
import dao.ProdutoDAO;
import control.Produto;
import java.awt.event.ItemEvent;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author kelvin.costa
 */
public class IfrProduto extends javax.swing.JInternalFrame {
    
    int id_prod = 0;
    private int codigoApresentacao = 0;
    
    public IfrProduto() {
        initComponents();
        
        new ProdutoDAO().popularTabela(tblProduto, "");

        //DefaultTableModel modelo = (DefaultTableModel) tblProduto.getModel();
        //tblProduto.setRowSorter(new TableRowSorter(modelo));
        new CombosDAO().popularCombo("apresentacao", cmbTpRemedio);
        new CombosDAO().popularCombo("categoria", cmbCategoria);
        tfdId.setText(new ProdutoDAO().proximaId());
        rbAtivo.setSelected(true);
        tfdValorunit.setDocument(new SoNumeros());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btnFechar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tfdBusca = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        tfdId = new javax.swing.JTextField();
        tfdDescricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbTpRemedio = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfdId_marca = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfdMarca = new javax.swing.JTextField();
        btnBuscar2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        tfdNome = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        rbAtivo = new javax.swing.JRadioButton();
        rbInativo = new javax.swing.JRadioButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfdGramatura = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tfdIdFornecedor = new javax.swing.JTextField();
        tfdFornecedor = new javax.swing.JTextField();
        btnBuscar3 = new javax.swing.JButton();
        tffValor = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();

        jLabel23.setForeground(new java.awt.Color(255, 0, 51));
        jLabel23.setText("* ");

        jLabel25.setForeground(new java.awt.Color(255, 0, 51));
        jLabel25.setText("* ");

        setTitle("Cadastro: Produto");

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/iconeFechar.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblProduto);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tfdBusca)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta", jPanel2);

        jLabel2.setText("Id");

        jLabel3.setText("Descrição");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/iconeSalvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        tfdId.setEnabled(false);

        jLabel5.setText("Valor");

        cmbTpRemedio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTpRemedioItemStateChanged(evt);
            }
        });

        jLabel8.setText("Tipo Remédio");

        jLabel20.setForeground(new java.awt.Color(255, 0, 51));
        jLabel20.setText("* ");

        jLabel21.setForeground(new java.awt.Color(255, 0, 51));
        jLabel21.setText("* ");

        jLabel22.setForeground(new java.awt.Color(255, 0, 51));
        jLabel22.setText("* ");

        jLabel9.setText("Categoria");

        jLabel10.setText("Id Marca");

        tfdId_marca.setEnabled(false);

        jLabel11.setText("Marca");

        tfdMarca.setEnabled(false);

        btnBuscar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/seo-social-web-network-internet_340_icon-iconscom_61497.png"))); // NOI18N
        btnBuscar2.setText("Buscar");
        btnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar2ActionPerformed(evt);
            }
        });

        jLabel12.setText("Nome");

        jLabel26.setForeground(new java.awt.Color(255, 0, 51));
        jLabel26.setText("* ");

        cmbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCategoriaItemStateChanged(evt);
            }
        });

        jLabel13.setText("Situação");

        rbAtivo.setText("Ativo");
        rbAtivo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rbAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAtivoActionPerformed(evt);
            }
        });

        rbInativo.setText("Inativo");
        rbInativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbInativoActionPerformed(evt);
            }
        });

        jLabel27.setForeground(new java.awt.Color(255, 0, 51));
        jLabel27.setText("* ");

        jLabel4.setText("Gramatura");

        jLabel7.setText("Fornecedor");

        jLabel14.setText("Id Fornecedor");

        tfdIdFornecedor.setEnabled(false);

        tfdFornecedor.setEnabled(false);

        btnBuscar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/seo-social-web-network-internet_340_icon-iconscom_61497.png"))); // NOI18N
        btnBuscar3.setText("Buscar");
        btnBuscar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar3ActionPerformed(evt);
            }
        });

        jLabel15.setText("Tipo");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(rbAtivo)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbInativo)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel27)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbTpRemedio, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel22)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfdGramatura, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tffValor, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel21))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(31, 31, 31)
                                                .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(31, 31, 31)
                                                .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel26)
                                                .addGap(48, 48, 48)
                                                .addComponent(jLabel15)
                                                .addGap(18, 18, 18)
                                                .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 59, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel14))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfdId_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(73, 73, 73)
                                                .addComponent(jLabel6))
                                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(46, 46, 46))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(tfdIdFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(8, 8, 8)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfdMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(tfdFornecedor))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(tfdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tfdId_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfdFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar3)
                    .addComponent(jLabel14)
                    .addComponent(tfdIdFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel26)
                    .addComponent(jLabel15)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTpRemedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel22)
                    .addComponent(jLabel4)
                    .addComponent(tfdGramatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel21)
                    .addComponent(tffValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(rbAtivo)
                            .addComponent(rbInativo)
                            .addComponent(jLabel27))
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Cadastro", jPanel1);

        jLabel24.setForeground(new java.awt.Color(255, 0, 51));
        jLabel24.setText("Campos com * são obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFechar)
                    .addComponent(jLabel24))
                .addContainerGap())
        );

        setBounds(150, 70, 641, 460);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Produto prod = new Produto();
        boolean flag = true;
        
        prod.setId_produto(id_prod);
        prod.setId_cat(cmbCategoria.getSelectedIndex());
        prod.setId_marca(Integer.valueOf(tfdId_marca.getText()));
        prod.setNome(tfdNome.getText());
        prod.setGramatura(tfdGramatura.getText());
        prod.setDescricao(tfdDescricao.getText());
        prod.setId_forne(Integer.parseInt(tfdIdFornecedor.getText()));
        prod.setId_tpremedio(cmbTpRemedio.getSelectedIndex());
        prod.setPreco(BigDecimal.valueOf(Double.parseDouble(tffValor.getText())));
        
        prod.setTipo(cmbTipo.getSelectedItem());
        
        
        
        
        
        prod.setUsuario(tfdUsuario.getText());
        prod.setEmail(tfdEmail.getText());
        
        if (prod.getId_func() != 0 && !prod.getEmail().equals("") && !prod.getUsuario().equals("") && !prod.getUsuario().equals("") && !tffSenha.getText().equals("") && tffSenha.getText().equals(tffRepSenha.getText())) {
            prod.setSenha(String.valueOf(tffSenha.getPassword()));
            if (rbAtivo.isSelected()) {
                prod.setSituacao("A");
            } else {
                prod.setSituacao("I");
            }

            // salvar
            LoginDAO apDAO = new LoginDAO();
            
            if (apDAO.salvar(prod) && flag == true) {
                // exibir msg
                JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");

                // limpar campos
                tfdFuncionario.setText("");
                tfdId.setText(idFunc + "");
                tffSenha.setText("");
                tffRepSenha.setText("");
                tfdUsuario.setText("");
                tfdEmail.setText("");
                rbAtivo.setSelected(true);
                
                btnFechar.requestFocus();

                // atualiza ID
                id = 0;
                new LoginDAO().popularTabela(tblLogin, tfdBusca.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Problemas ao salvar registro!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campos não preenchidos!");
            
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        new ProdutoDAO().popularTabela(tblProduto, tfdBusca.getText());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            
            String idString = String.valueOf(tblProduto.getValueAt(tblProduto.getSelectedRow(), 0));
            
            id_prod = Integer.parseInt(idString);
            
            ProdutoDAO pDAO = new ProdutoDAO();
            
            Produto p = pDAO.consultarId(id_prod);
            
            if (p != null) {
                
                tfdDescricao.setText(p.getDescricao());
                jCheckBox1.setSelected(p.getSituacao().equals("A"));
                
                tfdValorunit.setText(p.getValor_unit().toString());
                
                Apresentacao apresentacao = new ApresentacaoDAO().consultarId(p.getId_apre());
                ComboItem cbItem = new ComboItem(apresentacao.getId_apre(), apresentacao.getDescricao());
                cmbTpRemedio.getModel().setSelectedItem(cbItem);
                
                tfdId.setText(String.valueOf(p.getId_prod()));
                
                jTabbedPane1.setSelectedIndex(0);
            } else {
                System.out.println("Erro na consulta");
            }
            
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para editar");
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            
            String idString = String.valueOf(tblProduto.getValueAt(tblProduto.getSelectedRow(), 0));
            
            id_prod = Integer.parseInt(idString);
            
            ProdutoDAO pDAO = new ProdutoDAO();
            
            if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?") == JOptionPane.OK_OPTION) {
                if (pDAO.excluir(id_prod)) {
                    JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
                    new ProdutoDAO().popularTabela(tblProduto, tfdBusca.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Problemas ao excluir registro!");
                }
            }
            
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para excluir");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void cmbTpRemedioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTpRemedioItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            ComboItem ci = (ComboItem) cmbTpRemedio.getSelectedItem();
            codigoApresentacao = ci.getCodigo();
        }
    }//GEN-LAST:event_cmbTpRemedioItemStateChanged

    private void btnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar2ActionPerformed
        DlgPesquisarMarca dlgPesquisarMarca = new DlgPesquisarMarca(null, true, this);
        dlgPesquisarMarca.setVisible(true);
    }//GEN-LAST:event_btnBuscar2ActionPerformed

    private void cmbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCategoriaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoriaItemStateChanged

    private void rbAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAtivoActionPerformed

    private void rbInativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbInativoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbInativoActionPerformed

    private void btnBuscar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscar3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar2;
    private javax.swing.JButton btnBuscar3;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JComboBox<String> cmbTpRemedio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rbAtivo;
    private javax.swing.JRadioButton rbInativo;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTextField tfdBusca;
    private javax.swing.JTextField tfdDescricao;
    private javax.swing.JTextField tfdFornecedor;
    private javax.swing.JTextField tfdGramatura;
    private javax.swing.JTextField tfdId;
    private javax.swing.JTextField tfdIdFornecedor;
    private javax.swing.JTextField tfdId_marca;
    private javax.swing.JTextField tfdMarca;
    private javax.swing.JTextField tfdNome;
    private javax.swing.JFormattedTextField tffValor;
    // End of variables declaration//GEN-END:variables

    void definirValorFuncao(String id, String nome) {
        tfdId_marca.setText(id);
        tfdMarca.setText(nome);
        
    }

    void definirValorFuncaoFornecedor(String id, String nome) {
        tfdIdFornecedor.setText(id);
        tfdFornecedor.setText(nome);
    }
}
