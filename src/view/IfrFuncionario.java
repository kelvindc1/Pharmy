package view;

import lib.ComboItens;
import lib.CombosDAO;
import lib.Formatting;
import lib.Validation;
import dao.CidadeDAO;
import dao.FuncionarioDAO;
import control.Cidade;
import control.Funcionario;
import java.awt.event.ItemEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author kelvin.costa
 */
public class IfrFuncionario extends javax.swing.JInternalFrame {

    int id_func = 0;

    private int codigoContrato = 0;
    private int codigoCidade = 0;
    private int codigoDados = 0;
    
    public IfrFuncionario() {
        initComponents();

        new FuncionarioDAO().popularTabela(tblFuncionario, "");

        Formatting.formatarData(tffDataNascimento);
        Formatting.formatarCpf(tffCpf);
        Formatting.formatarTelefone(tffTelefone);
        Formatting.formatarData(tffDataNascimento);
        Formatting.formatarData(tffDataAdmissao);
        Formatting.formatarData(tffDataDemissao);
        
        //tfdSalario.setDocument(new SoNumeros());
        //Formatacao.formatarDecimal(tfdSalario);

        if (!tffDataAdmissao.getText().equals("")) {
            tffDataAdmissao.setText(Formatting.getDataAtual());
        }

        //new CombosDAO().popularCombo("cidade", cmbCidade);
        new CombosDAO().popularCombo("cidade", "id_cid", "nome", cmbCidade, "ORDER BY nome");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnFechar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        tfdId = new javax.swing.JTextField();
        tfdNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rbMasculino = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        rbFeminino = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        cmbCidade = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        tffCpf = new javax.swing.JFormattedTextField();
        tffTelefone = new javax.swing.JFormattedTextField();
        tffDataAdmissao = new javax.swing.JFormattedTextField();
        tffDataDemissao = new javax.swing.JFormattedTextField();
        tffDataNascimento = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        tfdRg = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tfdBusca = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();

        setTitle("Cadastro: Funcionario");

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/iconeFechar.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        jLabel2.setText("Id");

        jLabel3.setText("Nome");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/iconeSalvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        tfdId.setEnabled(false);

        jLabel5.setText("CPF");

        jLabel6.setText("Telefone");

        buttonGroup1.add(rbMasculino);
        rbMasculino.setText("Masculino");

        jLabel7.setText("Sexo");

        buttonGroup1.add(rbFeminino);
        rbFeminino.setText("Feminino");

        jLabel9.setText("Data de admissão");

        jLabel10.setText("Data de demissão");

        jLabel11.setText("Situação");

        jCheckBox1.setText("Ativo");

        jLabel13.setText("Data de nascimento");

        cmbCidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCidadeItemStateChanged(evt);
            }
        });

        jLabel18.setText("Cidade");

        jLabel19.setForeground(new java.awt.Color(255, 0, 51));
        jLabel19.setText("*");

        jLabel21.setForeground(new java.awt.Color(255, 0, 51));
        jLabel21.setText("* ");

        jLabel23.setForeground(new java.awt.Color(255, 0, 51));
        jLabel23.setText("*");

        jLabel25.setForeground(new java.awt.Color(255, 0, 51));
        jLabel25.setText("* ");

        jLabel27.setForeground(new java.awt.Color(255, 0, 51));
        jLabel27.setText("* ");

        jLabel28.setForeground(new java.awt.Color(255, 0, 51));
        jLabel28.setText("* ");

        jLabel29.setForeground(new java.awt.Color(255, 0, 51));
        jLabel29.setText("* ");

        jLabel31.setForeground(new java.awt.Color(255, 0, 51));
        jLabel31.setText("* ");

        jLabel15.setText("RG");

        jLabel32.setForeground(new java.awt.Color(255, 0, 51));
        jLabel32.setText("* ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfdRg, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                    .addComponent(tffCpf)
                                    .addComponent(tfdNome)
                                    .addComponent(tffDataNascimento))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel27)))))
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jCheckBox1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(cmbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel25)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(61, 61, 61)
                                    .addComponent(tffTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel28))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel9))
                                    .addGap(20, 20, 20)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tffDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tffDataDemissao, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel31)
                                        .addComponent(jLabel29))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(79, 79, 79)
                                .addComponent(rbMasculino)
                                .addGap(37, 37, 37)
                                .addComponent(rbFeminino)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23)))
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tffCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tffDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addComponent(jLabel21))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(cmbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(rbMasculino)
                            .addComponent(rbFeminino)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tffTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel28))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tffDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel31)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tffDataDemissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jCheckBox1)
                    .addComponent(btnSalvar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cadastro", jPanel1);

        tblFuncionario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblFuncionario);

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
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta", jPanel2);

        jLabel24.setForeground(new java.awt.Color(255, 0, 51));
        jLabel24.setText("Campos com * são obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFechar)
                    .addComponent(jLabel24))
                .addGap(14, 14, 14))
        );

        setBounds(250, 110, 861, 450);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        boolean continuar = true;
        Funcionario func = new Funcionario();

        if (tfdNome.getText().equals("")
                    || tffDataNascimento.getText().equals("  /  /    ")
                || cmbCidade.getSelectedItem().equals("Selecione")
                    || tffCpf.getText().equals("   .   .   -  ")
                || tffTelefone.getText().equals("(  )    -    ")
                    || tffDataAdmissao.getText().equals("  /  /    ")
                || tfdRg.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios (*)");
            continuar = false;
            tfdNome.requestFocus();
        }

        /*if (rbFeminino.getSelectedIcon().equals("") || rbMasculino.getSelectedIcon().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios (*)");
            continuar = false;
        } */
        
        if (tffDataNascimento.getText().trim().length() == 10
                && tffDataAdmissao.getText().trim().length() == 10
                && tffDataDemissao.getText().trim().length() == 10) {
            if (Validation.validarDataFormatada(tffDataNascimento.getText())
                    && Validation.validarDataFormatada(tffDataAdmissao.getText())
                    && Validation.validarDataFormatada(tffDataDemissao.getText())) {
                System.out.println("Datas Ok");
            } else {
                System.out.println("Erro na data");
            }
        } else {
            System.out.println("Preencha adequadamente");
        }

        /*if (tffCpf.getText().trim().length() == 14) {
            if (Validacao.validarCPF(Formatacao.limpaCaracter(tffCpf.getText()))) {
                System.out.println("OK");
                continuar = true;
            } else {
                JOptionPane.showMessageDialog(null, "CPF Inválido");
                continuar = false;
                tffCpf.requestFocus();
            }
        } else {
            System.out.println("Preencha adequadamente");
            continuar = false;
            tffCpf.requestFocus();
        }*/

        if (continuar) {

            func.setNome(tfdNome.getText());

            func.setSexo("F");
            if (rbMasculino.isSelected()) {
                func.setSexo("M");
            }

            try {
                if (!tffDataDemissao.getText().replaceAll("[/]", "").trim().equals("")) {
                    Date dt_demissao = new SimpleDateFormat("dd/MM/yyyy").parse(tffDataDemissao.getText());
                    func.setDt_demissao(dt_demissao);
                }
                Date dt_nasc = new SimpleDateFormat("dd/MM/yyyy").parse(tffDataNascimento.getText());
                func.setDt_nasc(dt_nasc);

                Date dt_admissao = new SimpleDateFormat("dd/MM/yyyy").parse(tffDataAdmissao.getText());
                func.setDt_admissao(dt_admissao);

            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao converter a data!");
            }

            func.setTelefone(tffTelefone.getText());

            func.setSituacao("I");
            if (jCheckBox1.isSelected()) {
                func.setSituacao("A");
            }

            func.setCpf(tffCpf.getText());
            func.setRg(tfdRg.getText());
            
            // ID CONTRATO    (COLOCAR NA TELA E AQUI)
            // ID DADOS       (COLOCAR NA TELA E AQUI)

            if (codigoCidade > 0) {
                func.setId_cid(codigoCidade);
            }

            // ComboItem ci = (ComboItem) cmbCidade.getSelectedItem();
            // func.setId_cid((ci.getCodigo()));
            
            func.setId_func(id_func);

            // salvar
            FuncionarioDAO funcDAO = new FuncionarioDAO();

            if (funcDAO.salvar(func)) {

                JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");

                tfdNome.setText("");
                //sexo               
                tffDataNascimento.setText("");
                tffDataAdmissao.setText("");
                tffDataDemissao.setText("");
                tffTelefone.setText("");
                tffCpf.setText("");
                tfdRg.setText("");
                cmbCidade.setSelectedIndex(0);
                tfdId.setText("");
                
                // CAMPO DE CONTRATO (VAI SER O QUE?)
                // CAMPO DADOS (VAI SER O QUE?)

                tfdNome.requestFocus();

                id_func = 0;

            } else {
                JOptionPane.showMessageDialog(null, "Problemas ao salvar registro!");
            }
        }

//        try {
////          Statement st = automedquinta.AutoMedQuinta.conexao.createStatement();
//            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
//
//            String sql = "INSERT INTO apresentacao VALUES ("
//                    + "DEFAULT, "
//                    + "'" + tfdDescricao.getText() + "')";
//
//            System.out.println("SQL: " + sql);
//
//            int resultado = st.executeUpdate(sql);
//
//        } catch (Exception e) {
//            System.out.println("Erro salvar apresentação = " + e);
//        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        new FuncionarioDAO().popularTabela(tblFuncionario, tfdBusca.getText());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {

            String idString = String.valueOf(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 0));

            id_func = Integer.parseInt(idString);

            FuncionarioDAO funcDAO = new FuncionarioDAO();

            Funcionario func = funcDAO.consultarId(id_func);

            if (func != null) {
                tfdNome.setText(func.getNome());
                tffDataAdmissao.setText(Formatting.ajustaDataDMA(String.valueOf(func.getDt_admissao())));
                tffDataDemissao.setText(Formatting.ajustaDataDMA(String.valueOf(func.getDt_demissao())));
                tffDataNascimento.setText(Formatting.ajustaDataDMA(String.valueOf(func.getDt_nasc())));
                tffCpf.setText(func.getCpf());
                tfdRg.setText(func.getRg());
                tffTelefone.setText(String.valueOf(func.getTelefone()));
                jCheckBox1.setSelected(func.getSituacao().equals("A"));

                Cidade cidade = new CidadeDAO().consultarId(func.getId_cid());
                ComboItens cbItem = new ComboItens(cidade.getId_cid(), cidade.getNome());
                cmbCidade.getModel().setSelectedItem(cbItem);

                rbFeminino.setSelected(func.getSexo().equals("F"));
                rbMasculino.setSelected(func.getSexo().equals("M"));
                
                // CONTRATO 
                // DADOS

                tfdId.setText(String.valueOf(func.getId_func()));

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

            String idString = String.valueOf(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 0));

            id_func = Integer.parseInt(idString);

            FuncionarioDAO fDAO = new FuncionarioDAO();

            if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?") == JOptionPane.OK_OPTION) {
                if (fDAO.excluir(id_func)) {
                    JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
                    new FuncionarioDAO().popularTabela(tblFuncionario, tfdBusca.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Problemas ao excluir registro!");
                }
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para excluir");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void cmbCidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCidadeItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            ComboItens ci = (ComboItens) cmbCidade.getSelectedItem();
            codigoCidade = ci.getCodigo();
        }
    }//GEN-LAST:event_cmbCidadeItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbCidade;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rbFeminino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JTable tblFuncionario;
    private javax.swing.JTextField tfdBusca;
    private javax.swing.JTextField tfdId;
    private javax.swing.JTextField tfdNome;
    private javax.swing.JTextField tfdRg;
    private javax.swing.JFormattedTextField tffCpf;
    private javax.swing.JFormattedTextField tffDataAdmissao;
    private javax.swing.JFormattedTextField tffDataDemissao;
    private javax.swing.JFormattedTextField tffDataNascimento;
    private javax.swing.JFormattedTextField tffTelefone;
    // End of variables declaration//GEN-END:variables

    void definirValorFuncao(String id, String nome, String setor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
