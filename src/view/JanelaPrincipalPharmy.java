package view;

import lib.ConexaoBD;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import lib.Grafico;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author kelvin.costa
 */
public class JanelaPrincipalPharmy extends javax.swing.JFrame {

    /**
     * Creates new form JanelaPrincipal
     */
    public JanelaPrincipalPharmy() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        new Grafico().getGrafico();
        //setIcon();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem13 = new javax.swing.JMenuItem();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        jMenuItem13.setText("jMenuItem13");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pharmy");
        setMinimumSize(new java.awt.Dimension(800, 800));
        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                formAncestorResized(evt);
            }
        });

        jDesktopPane1.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                jDesktopPane1AncestorResized(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1188, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 746, Short.MAX_VALUE)
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/cadastro-icon-png-7 (4).png"))); // NOI18N
        jMenu1.setText("Cadastros");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem22.setText("Contrato");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem22);

        jMenuItem6.setText("Cliente");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem2.setText("Produto");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Fornecedor");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem21.setText("Benefícios");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem21);

        jMenuItem7.setText("Funcionário");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem23.setText("Produto");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem23);
        jMenu1.add(jSeparator1);

        jMenuItem18.setText("Cargo");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem18);

        jMenuItem14.setText("Cidade");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem14);

        jMenuItem15.setText("Estado");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem15);

        jMenuItem16.setText("Forma de Pagamento");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem16);

        jMenuItem17.setText("Função");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem17);

        jMenuItem20.setText("Login");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem20);

        jMenuItem1.setText("Marca");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem12.setText("País");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);

        jMenuItem5.setText("Tipo de Benefício");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem19.setText("Setor");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem19);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/icone-mundFin-1024x1024 (1).png"))); // NOI18N
        jMenu2.setText("Movimentações");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem4.setText("Pedido");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/icone_verde (1).png"))); // NOI18N
        jMenu4.setText("Relatórios");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem8.setText("Listagem - Marcas");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem9.setText("Listagem - Formas de Pagamento");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem11.setText("Listagem - Produtos");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem11);

        jMenuItem10.setText("Relatório - Pedidos");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuBar1.add(jMenu4);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/system/icons/Help-icon (3).png"))); // NOI18N
        jMenu3.setText("Ajuda");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        IfrMarca ifrMarca = new IfrMarca();
        jDesktopPane1.add(ifrMarca);
        ifrMarca.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        IfrProduto ifrProduto = new IfrProduto();
        jDesktopPane1.add(ifrProduto);
        ifrProduto.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        //IfrFornecedor ifrFornecedor = new IfrFornecedor();
        //jDesktopPane1.add(ifrFornecedor);
        //ifrFornecedor.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        IfrFuncionario ifrFuncionario = new IfrFuncionario();
        jDesktopPane1.add(ifrFuncionario);
        ifrFuncionario.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        IfrCliente ifrCliente = new IfrCliente();
        jDesktopPane1.add(ifrCliente);
        ifrCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
    }//GEN-LAST:event_formAncestorResized

    private void jDesktopPane1AncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jDesktopPane1AncestorResized
        //jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/download.jpg")).getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));
        //jLabel1.setVisible(false);
    }//GEN-LAST:event_jDesktopPane1AncestorResized

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed

    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
         IfrPedido ifrPedido = new IfrPedido();
        jDesktopPane1.add(ifrPedido);
        ifrPedido.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        try {
            // Compila o relatorio

            //InputStream input = getClass().getResourceAsStream("/relatorios/report_Func_Sexo_Masc.jrxml");
            JasperReport relatorio1 = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/reportPharmyMarca.jrxml"));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map parametros = new HashMap();

            // Executa relatorio
            JasperPrint impressao1 = JasperFillManager.fillReport(relatorio1, parametros, ConexaoBD.getInstance().getConnection());

            // Exibe resultado em video
            JasperViewer.viewReport(impressao1, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        try {
            // Compila o relatorio
            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/reportPharmyForma_Pag.jrxml"));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map parametros = new HashMap();

            // Executa relatoio
            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, ConexaoBD.getInstance().getConnection());

            // Exibe resultado em video
            JasperViewer.viewReport(impressao, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        //DlgRelatorioPedidos dlgRelatorioPedidos = new DlgRelatorioPedidos(this, true);
        //dlgRelatorioPedidos.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        try {
            // Compila o relatorio
            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/report_Produtos.jrxml"));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map parametros = new HashMap();

            // Executa relatoio
            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, ConexaoBD.getInstance().getConnection());

            // Exibe resultado em video
            JasperViewer.viewReport(impressao, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }        
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        IfrPais ifrPais = new IfrPais();
        jDesktopPane1.add(ifrPais);
        ifrPais.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        IfrEstado ifrEstado = new IfrEstado();
        jDesktopPane1.add(ifrEstado);
        ifrEstado.setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        IfrCidade ifrCidade = new IfrCidade();
        jDesktopPane1.add(ifrCidade);
        ifrCidade.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        ifrForma_Pagamento ifr_Forma_pag = new ifrForma_Pagamento();
        jDesktopPane1.add(ifr_Forma_pag);
        ifr_Forma_pag.setVisible(true);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        IfrFuncao ifrFuncao = new IfrFuncao();
        jDesktopPane1.add(ifrFuncao);
        ifrFuncao.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        IfrCargo ifrCargo = new IfrCargo();
        jDesktopPane1.add(ifrCargo);
        ifrCargo.setVisible(true);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        IfrSetor ifrSetor = new IfrSetor();
        jDesktopPane1.add(ifrSetor);
        ifrSetor.setVisible(true);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        IfrLogin ifrLogin = new IfrLogin();
        jDesktopPane1.add(ifrLogin);
        ifrLogin.setVisible(true);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        IfrBeneficio ifrBeneficio = new IfrBeneficio();
        jDesktopPane1.add(ifrBeneficio);
        ifrBeneficio.setVisible(true);
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        IfrTipoBeneficio ifrTipoBeneficio = new IfrTipoBeneficio();
        jDesktopPane1.add(ifrTipoBeneficio);
        ifrTipoBeneficio.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        IfrContrato ifrContrato = new IfrContrato();
        jDesktopPane1.add(ifrContrato);
        ifrContrato.setVisible(true);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        IfrProduto ifrProduto = new IfrProduto();
        jDesktopPane1.add(ifrProduto);
        ifrProduto.setVisible(true);

    }//GEN-LAST:event_jMenuItem23ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                JanelaPrincipalPharmy janelaPrincipal = new JanelaPrincipalPharmy();
                janelaPrincipal.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables

    /*private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images.system.branding/linkedin_banner_image_1.png")));
    }*/
}
