/*
 * Copyright (C) 2014 BrunoRicardo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.au.gui;

import com.au.bean.Funcionario;
import com.au.dao.FuncionarioDao;
import com.au.util.HexSha;
import com.au.util.LimitaDigitos;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
    private boolean[] valida = {false, false, false};

    /**
     * Creates new form TelaRecuperarSenha
     *
     * @param parent
     * @param modal
     */
    public TelaCriarNovaSenha(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        textoErroCpf.setVisible(false);
        textoErroPass1.setVisible(false);
        textoErroPass2.setVisible(false);
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
        textoErroCpf = new javax.swing.JLabel();
        textoErroPass1 = new javax.swing.JLabel();
        textoErroPass2 = new javax.swing.JLabel();
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
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoCpfFuncionarioFocusLost(evt);
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
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNovaSenhaFocusLost(evt);
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
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoConfirmacaoNovaSenhaFocusLost(evt);
            }
        });
        campoConfirmacaoNovaSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoConfirmacaoNovaSenhaActionPerformed(evt);
            }
        });

        textoErroCpf.setForeground(new java.awt.Color(255, 0, 0));
        textoErroCpf.setText("CPF Inválido");

        textoErroPass1.setForeground(new java.awt.Color(255, 0, 0));
        textoErroPass1.setText("Minímo cinco caracteres");

        textoErroPass2.setForeground(new java.awt.Color(255, 0, 0));
        textoErroPass2.setText("Senhas não conferem");

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
                            .addComponent(textoDigiteNovaSenha)
                            .addGap(18, 18, 18)
                            .addGroup(painelDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textoErroCpf)
                                .addComponent(campoNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textoErroPass1)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelDadosFuncionarioLayout.createSequentialGroup()
                            .addComponent(textoConfirmeNovaSenha)
                            .addGap(18, 18, 18)
                            .addGroup(painelDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textoErroPass2)
                                .addComponent(campoConfirmacaoNovaSenha)))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoErroCpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoDigiteNovaSenha)
                    .addComponent(campoNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoErroPass1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoConfirmeNovaSenha)
                    .addComponent(campoConfirmacaoNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textoErroPass2))
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

    private void campoCpfFuncionarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCpfFuncionarioFocusLost
        valida(campoCpfFuncionario, 10, 0, textoErroCpf);
    }//GEN-LAST:event_campoCpfFuncionarioFocusLost

    private void campoNovaSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNovaSenhaFocusLost
        valida(campoNovaSenha, 4, 1, textoErroPass1);
    }//GEN-LAST:event_campoNovaSenhaFocusLost

    private void campoConfirmacaoNovaSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoConfirmacaoNovaSenhaFocusLost
        validaSenha2();
    }//GEN-LAST:event_campoConfirmacaoNovaSenhaFocusLost

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

    public void valida(JTextField campo, Integer tamanho, int indexVetor, JLabel texto) {

        if (campo != null && !"".equals(campo.getText()) && campo.getText().length() > tamanho) {
            campo.setBorder(normal);
            valida[indexVetor] = true;
            texto.setVisible(false);
        } else {
            campo.setBorder(vermelha);
            valida[indexVetor] = false;
            texto.setVisible(true);
        }
    }

    public void validaSenha2() {
        if (campoConfirmacaoNovaSenha != null && campoConfirmacaoNovaSenha.getText().equals(campoNovaSenha.getText()) && campoConfirmacaoNovaSenha.getText().length() > 4) {
            campoConfirmacaoNovaSenha.setBorder(normal);
            valida[2] = true;
            textoErroPass2.setVisible(false);
        } else {
            campoConfirmacaoNovaSenha.setBorder(vermelha);
            valida[2] = false;
            textoErroPass2.setVisible(true);
        }
    }

    public boolean valida() {
        boolean validar = true;

        if (valida[0] == false) {
            valida(campoCpfFuncionario, 10, 0, textoErroCpf);
            validar = false;
        }
        if (valida[1] == false) {
            valida(campoNovaSenha, 4, 1, textoErroPass1);
            validar = false;
        }
        if (valida[2] == false) {
            validaSenha2();
            validar = false;
        }
        return validar;
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
    private javax.swing.JLabel textoErroCpf;
    private javax.swing.JLabel textoErroPass1;
    private javax.swing.JLabel textoErroPass2;
    private javax.swing.JLabel textoNaoEPossivelRecuperarSenhaAntiga;
    private javax.swing.JLabel textoPreenchaInformacoesParaCriarNovaSenha;
    // End of variables declaration//GEN-END:variables
}
