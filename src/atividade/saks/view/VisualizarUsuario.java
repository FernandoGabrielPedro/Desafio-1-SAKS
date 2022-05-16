/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package atividade.saks.view;

import atividade.saks.controller.CadastroC;
import atividade.saks.dao.AdminDAO;
import atividade.saks.dao.UsuarioDAO;
import atividade.saks.model.Admin;
import atividade.saks.model.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author ferna
 */
public class VisualizarUsuario extends javax.swing.JFrame {
    
    Usuario usuario;
    Admin admin;

    /**
     * Creates new form VisualizarUsuario
     */
    public VisualizarUsuario(Usuario newUsuario) {
        initComponents();
        setLocationRelativeTo(null);
        
        usuario = newUsuario;
        admin = null;
        
        varTipoCadastro.setText("Usuário");
        varId.setText(Integer.toString(usuario.getId()));
        varNome.setText(usuario.getNome());
        varIdade.setText(Integer.toString(usuario.getIdade()));
        varCpf.setText(usuario.getCpf());
        varEmail.setText(usuario.getEmail());
    }
    public VisualizarUsuario(Admin newAdmin) {
        initComponents();
        setLocationRelativeTo(null);
        
        usuario = null;
        admin = newAdmin;
        
        varTipoCadastro.setText("Admin");
        varId.setText(Integer.toString(admin.getId()));
        varNome.setText(admin.getNome());
        varIdade.setText(Integer.toString(admin.getIdade()));
        varCpf.setText(admin.getCpf());
        varEmail.setText(admin.getEmail());
    }
    public VisualizarUsuario() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        varId = new javax.swing.JLabel();
        varTipoCadastro = new javax.swing.JLabel();
        varNome = new javax.swing.JLabel();
        varIdade = new javax.swing.JLabel();
        varCpf = new javax.swing.JLabel();
        varEmail = new javax.swing.JLabel();
        botaoEditarNome = new javax.swing.JButton();
        botaoEditarIdade = new javax.swing.JButton();
        botaoEditarCpf = new javax.swing.JButton();
        botaoEditarEmail = new javax.swing.JButton();
        botaoEditarSenha = new javax.swing.JButton();
        botaoEditarAtivo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Tipo de Cadastro:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Idade:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("CPF:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Email:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Número de Identificação:");

        varId.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        varId.setText("*id");

        varTipoCadastro.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        varTipoCadastro.setText("*tipo");

        varNome.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        varNome.setText("*nome");

        varIdade.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        varIdade.setText("*idade");

        varCpf.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        varCpf.setText("*cpf");

        varEmail.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        varEmail.setText("*email");

        botaoEditarNome.setText("Editar");
        botaoEditarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarNomeActionPerformed(evt);
            }
        });

        botaoEditarIdade.setText("Editar");
        botaoEditarIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarIdadeActionPerformed(evt);
            }
        });

        botaoEditarCpf.setText("Editar");
        botaoEditarCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarCpfActionPerformed(evt);
            }
        });

        botaoEditarEmail.setText("Editar");
        botaoEditarEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarEmailActionPerformed(evt);
            }
        });

        botaoEditarSenha.setText("Redefinir Senha");
        botaoEditarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarSenhaActionPerformed(evt);
            }
        });

        botaoEditarAtivo.setText("Desativar Cadastro");
        botaoEditarAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarAtivoActionPerformed(evt);
            }
        });

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(varId))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(botaoEditarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(botaoEditarAtivo))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(varNome)
                                        .addComponent(varIdade)
                                        .addComponent(varCpf)
                                        .addComponent(varEmail))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(botaoEditarEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(botaoEditarCpf, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(botaoEditarIdade, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(botaoEditarNome, javax.swing.GroupLayout.Alignment.TRAILING)))))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(varTipoCadastro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(varTipoCadastro)))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(varId))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(varNome)
                    .addComponent(botaoEditarNome))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(varIdade)
                    .addComponent(botaoEditarIdade))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(varCpf)
                    .addComponent(botaoEditarCpf))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(varEmail)
                    .addComponent(botaoEditarEmail))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoEditarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoEditarAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEditarEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarEmailActionPerformed
        String par = "email";
        
        CadastroC.AltPar(usuario, admin, par, this);
    }//GEN-LAST:event_botaoEditarEmailActionPerformed

    private void botaoEditarAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarAtivoActionPerformed
        if(usuario != null) {
            CadastroC.DeletCadastro(usuario, admin);
            JOptionPane.showMessageDialog(rootPane, "Usuário deletado.");
        } else {
            CadastroC.DeletCadastro(usuario, admin);
            JOptionPane.showMessageDialog(rootPane, "Admin deletado.");
        }
        this.dispose();
    }//GEN-LAST:event_botaoEditarAtivoActionPerformed

    private void botaoEditarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarNomeActionPerformed
        String par = "nome";
        
        CadastroC.AltPar(usuario, admin, par, this);
    }//GEN-LAST:event_botaoEditarNomeActionPerformed

    private void botaoEditarIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarIdadeActionPerformed
        String par = "idade";
        
        CadastroC.AltPar(usuario, admin, par, this);
    }//GEN-LAST:event_botaoEditarIdadeActionPerformed

    private void botaoEditarCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarCpfActionPerformed
        String par = "cpf";
        
        CadastroC.AltPar(usuario, admin, par, this);
    }//GEN-LAST:event_botaoEditarCpfActionPerformed

    private void botaoEditarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarSenhaActionPerformed
        String par = "senha";
        
        CadastroC.AltPar(usuario, admin, par);
    }//GEN-LAST:event_botaoEditarSenhaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VisualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEditarAtivo;
    private javax.swing.JButton botaoEditarCpf;
    private javax.swing.JButton botaoEditarEmail;
    private javax.swing.JButton botaoEditarIdade;
    private javax.swing.JButton botaoEditarNome;
    private javax.swing.JButton botaoEditarSenha;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel varCpf;
    private javax.swing.JLabel varEmail;
    private javax.swing.JLabel varId;
    private javax.swing.JLabel varIdade;
    private javax.swing.JLabel varNome;
    private javax.swing.JLabel varTipoCadastro;
    // End of variables declaration//GEN-END:variables
}
