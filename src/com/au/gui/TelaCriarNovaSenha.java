/*
 * The MIT License
 *
 * Copyright 2014 Tiago.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.au.gui;

import com.au.bean.Funcionario;
import com.au.dao.FuncionarioDao;
import com.au.util.HexSha;
import com.au.util.LimitaDigitos;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Tiago
 */
public class TelaCriarNovaSenha extends javax.swing.JDialog {

    private final Border vermelha = new MatteBorder(1, 1, 1, 1, Color.red);
    private final Border normal;
    private final FuncionarioDao fDao = new FuncionarioDao();

    /**
     * Creates new form TelaRecuperarSenha
     *
     * @param parent
     * @param modal
     */
    public TelaCriarNovaSenha(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        normal = campoCpfFuncionario.getBorder();
        campoConfirmacaoNovaSenha.setDocument(new LimitaDigitos((64), ""));
        campoCpfFuncionario.setDocument(new LimitaDigitos((15), "[^0-9\\.-]"));
        campoNovaSenha.setDocument(new LimitaDigitos((64), ""));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelSuperior = new javax.swing.JPanel();
        textoCriarNovaSenha = new javax.swing.JLabel();
        textoDevidoAManeiraComoSenhaEArmazenada = new javax.swing.JLabel();
        textoPreenchaInformacoesParaCriarNovaSenha = new javax.swing.JLabel();
        textoNaoEPossivelRecuperarSenhaAntiga = new javax.swing.JLabel();
        painelDadosFuncionario = new javax.swing.JPanel();
        textoCpfFuncionario = new javax.swing.JLabel();
        campoCpfFuncionario = new javax.swing.JTextField();
        campoCpfFuncionario.setActionCommand("CPF");
        textoDigiteNovaSenha = new javax.swing.JLabel();
        textoConfirmeNovaSenha = new javax.swing.JLabel();
        campoNovaSenha = new javax.swing.JPasswordField();
        campoConfirmacaoNovaSenha = new javax.swing.JPasswordField();
        botaoCriarNovaSenha = new javax.swing.JButton();
        botaoCancelarNovaSenha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textoCriarNovaSenha.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        textoCriarNovaSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoCriarNovaSenha.setText("Criar Nova Senha");

        textoDevidoAManeiraComoSenhaEArmazenada.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        textoDevidoAManeiraComoSenhaEArmazenada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoDevidoAManeiraComoSenhaEArmazenada.setText("Devido à maneira como a senha é armazenada,");

        textoPreenchaInformacoesParaCriarNovaSenha.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        textoPreenchaInformacoesParaCriarNovaSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoPreenchaInformacoesParaCriarNovaSenha.setText("Preencha as informações abaixo para criar uma nova senha.");

        textoNaoEPossivelRecuperarSenhaAntiga.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        textoNaoEPossivelRecuperarSenhaAntiga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoNaoEPossivelRecuperarSenhaAntiga.setText("não é possível recuperar a senha antiga.");

        javax.swing.GroupLayout painelSuperiorLayout = new javax.swing.GroupLayout(painelSuperior);
        painelSuperior.setLayout(painelSuperiorLayout);
        painelSuperiorLayout.setHorizontalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textoDevidoAManeiraComoSenhaEArmazenada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoCriarNovaSenha, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoPreenchaInformacoesParaCriarNovaSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoNaoEPossivelRecuperarSenhaAntiga, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelSuperiorLayout.setVerticalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoCriarNovaSenha)
                .addGap(18, 18, 18)
                .addComponent(textoDevidoAManeiraComoSenhaEArmazenada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoNaoEPossivelRecuperarSenhaAntiga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoPreenchaInformacoesParaCriarNovaSenha)
                .addContainerGap())
        );

        painelDadosFuncionario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados do Funcionário"));

        textoCpfFuncionario.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoCpfFuncionario.setText("CPF do Funcionário:");

        campoCpfFuncionario.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        campoCpfFuncionario.setNextFocusableComponent(campoNovaSenha);
        campoCpfFuncionario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoCpfFuncionarioFocusGained(evt);
            }
        });
        campoCpfFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCpfFuncionarioActionPerformed(evt);
            }
        });

        textoDigiteNovaSenha.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoDigiteNovaSenha.setText("Digite a Nova Senha:");

        textoConfirmeNovaSenha.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoConfirmeNovaSenha.setText("Confirme a Nova Senha:");

        campoNovaSenha.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        campoNovaSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoNovaSenhaFocusGained(evt);
            }
        });
        campoNovaSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNovaSenhaActionPerformed(evt);
            }
        });

        campoConfirmacaoNovaSenha.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        campoConfirmacaoNovaSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoConfirmacaoNovaSenhaFocusGained(evt);
            }
        });
        campoConfirmacaoNovaSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoConfirmacaoNovaSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDadosFuncionarioLayout = new javax.swing.GroupLayout(painelDadosFuncionario);
        painelDadosFuncionario.setLayout(painelDadosFuncionarioLayout);
        painelDadosFuncionarioLayout.setHorizontalGroup(
            painelDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosFuncionarioLayout.createSequentialGroup()
                        .addComponent(textoCpfFuncionario)
                        .addGap(18, 18, 18)
                        .addComponent(campoCpfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelDadosFuncionarioLayout.createSequentialGroup()
                            .addComponent(textoConfirmeNovaSenha)
                            .addGap(18, 18, 18)
                            .addComponent(campoConfirmacaoNovaSenha))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelDadosFuncionarioLayout.createSequentialGroup()
                            .addComponent(textoDigiteNovaSenha)
                            .addGap(18, 18, 18)
                            .addComponent(campoNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelDadosFuncionarioLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {textoConfirmeNovaSenha, textoCpfFuncionario, textoDigiteNovaSenha});

        painelDadosFuncionarioLayout.setVerticalGroup(
            painelDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoCpfFuncionario)
                    .addComponent(campoCpfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoDigiteNovaSenha)
                    .addComponent(campoNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoConfirmeNovaSenha)
                    .addComponent(campoConfirmacaoNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        botaoCriarNovaSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoCriarNovaSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/ok-32.png"))); // NOI18N
        botaoCriarNovaSenha.setText("Criar Nova Senha");
        botaoCriarNovaSenha.setNextFocusableComponent(botaoCancelarNovaSenha);
        botaoCriarNovaSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarNovaSenhaActionPerformed(evt);
            }
        });

        botaoCancelarNovaSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoCancelarNovaSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/cancel-32.png"))); // NOI18N
        botaoCancelarNovaSenha.setText("Cancelar Criação de Nova Senha");
        botaoCancelarNovaSenha.setNextFocusableComponent(campoCpfFuncionario);
        botaoCancelarNovaSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarNovaSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelDadosFuncionario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelSuperior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoCancelarNovaSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCriarNovaSenha)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelDadosFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCriarNovaSenha)
                    .addComponent(botaoCancelarNovaSenha))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoCpfFuncionarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCpfFuncionarioFocusGained
        campoCpfFuncionario.selectAll();
    }//GEN-LAST:event_campoCpfFuncionarioFocusGained

    private void campoNovaSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNovaSenhaFocusGained
        campoNovaSenha.selectAll();
    }//GEN-LAST:event_campoNovaSenhaFocusGained

    private void campoConfirmacaoNovaSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoConfirmacaoNovaSenhaFocusGained
        campoConfirmacaoNovaSenha.selectAll();
    }//GEN-LAST:event_campoConfirmacaoNovaSenhaFocusGained

    private void botaoCancelarNovaSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarNovaSenhaActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoCancelarNovaSenhaActionPerformed

    private void botaoCriarNovaSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarNovaSenhaActionPerformed
        if (valida()) {
            alterarSenha();
            this.dispose();
        }
    }//GEN-LAST:event_botaoCriarNovaSenhaActionPerformed

    private void campoCpfFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCpfFuncionarioActionPerformed
        campoNovaSenha.requestFocus();
    }//GEN-LAST:event_campoCpfFuncionarioActionPerformed

    private void campoNovaSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNovaSenhaActionPerformed
        campoConfirmacaoNovaSenha.requestFocus();
    }//GEN-LAST:event_campoNovaSenhaActionPerformed

    private void campoConfirmacaoNovaSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoConfirmacaoNovaSenhaActionPerformed
        if (valida()) {
            alterarSenha();
            this.dispose();
        }
    }//GEN-LAST:event_campoConfirmacaoNovaSenhaActionPerformed

    public void alterarSenha() {
        fDao.abreConnection();
        if (fDao.validaCPF(campoCpfFuncionario.getText())) {
            fDao.atualizaFuncionario(formToFuncionario());
            JOptionPane.showMessageDialog(this, "Senha Alterada com Sucesso!", "Recuperação de Senha", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "CPF não encontrado!", "Recuperação de Senha", JOptionPane.WARNING_MESSAGE);
        }
        fDao.fechaConnection();
    }

    public Funcionario formToFuncionario() {
        Funcionario funcionario = fDao.pesquisarFuncionarioPorCpf(campoCpfFuncionario.getText());
        HexSha hexSha = new HexSha(String.valueOf(campoNovaSenha.getPassword()));
        funcionario.setPassFunc(hexSha.ConvertSha());
        return funcionario;
    }

    public boolean valida() {
        boolean valida = true;
        if (!"".equals(campoCpfFuncionario.getText())) {
            campoCpfFuncionario.setBorder(normal);
        } else {
            campoCpfFuncionario.setBorder(vermelha);
            valida = false;
        }
        if (!"".equals(campoNovaSenha.getPassword()) && campoNovaSenha.getPassword().length > 4) {
            campoNovaSenha.setBorder(normal);
        } else {
            campoNovaSenha.setBorder(vermelha);
            valida = false;
        }
        if (!"".equals(campoConfirmacaoNovaSenha.getPassword()) && campoConfirmacaoNovaSenha.getText().equals(campoNovaSenha.getText())) {
            campoConfirmacaoNovaSenha.setBorder(normal);
        } else {
            campoConfirmacaoNovaSenha.setBorder(vermelha);
            valida = false;
        }
        return valida;
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelarNovaSenha;
    private javax.swing.JButton botaoCriarNovaSenha;
    private javax.swing.JPasswordField campoConfirmacaoNovaSenha;
    private javax.swing.JTextField campoCpfFuncionario;
    private javax.swing.JPasswordField campoNovaSenha;
    private javax.swing.JPanel painelDadosFuncionario;
    private javax.swing.JPanel painelSuperior;
    private javax.swing.JLabel textoConfirmeNovaSenha;
    private javax.swing.JLabel textoCpfFuncionario;
    private javax.swing.JLabel textoCriarNovaSenha;
    private javax.swing.JLabel textoDevidoAManeiraComoSenhaEArmazenada;
    private javax.swing.JLabel textoDigiteNovaSenha;
    private javax.swing.JLabel textoNaoEPossivelRecuperarSenhaAntiga;
    private javax.swing.JLabel textoPreenchaInformacoesParaCriarNovaSenha;
    // End of variables declaration//GEN-END:variables
}
