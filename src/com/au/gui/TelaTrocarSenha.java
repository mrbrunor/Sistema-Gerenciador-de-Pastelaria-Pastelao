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

import com.au.gui.listener.RecuperarSenhaActionListener;
import com.au.util.LimitaDigitos;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Tiago
 */
public class TelaTrocarSenha extends javax.swing.JDialog {
    private final RecuperarSenhaActionListener listener;

    /**
     * Creates new form TelaRecuperarSenha
     */
    public TelaTrocarSenha(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        campoConfirmacaoNovaSenha.setDocument(new LimitaDigitos((64), ""));
        campoCpfFuncionario.setDocument(new LimitaDigitos((15), "[^0-9\\.-]"));
        campoNovaSenha.setDocument(new LimitaDigitos((64), ""));
        listener = new TrocarSenhaActionListener(this);
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
        textoTrocarSenha = new javax.swing.JLabel();
        textoInsiraDados = new javax.swing.JLabel();
        painelDadosFuncionario = new javax.swing.JPanel();
        textoSenhaAtual = new javax.swing.JLabel();
        textoDigiteNovaSenha = new javax.swing.JLabel();
        textoConfirmeNovaSenha = new javax.swing.JLabel();
        campoSenhaAtual = new javax.swing.JPasswordField();
        campoNovaSenha = new javax.swing.JPasswordField();
        campoConfirmacaoNovaSenha = new javax.swing.JPasswordField();
        botaoTrocarSenha = new javax.swing.JButton();
        botaoCancelarTrocaSenha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textoTrocarSenha.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        textoTrocarSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoTrocarSenha.setText("Trocar Senha");

        textoInsiraDados.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        textoInsiraDados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoInsiraDados.setText("Insira os dados abaixo para trocar a sua senha:");

        javax.swing.GroupLayout painelSuperiorLayout = new javax.swing.GroupLayout(painelSuperior);
        painelSuperior.setLayout(painelSuperiorLayout);
        painelSuperiorLayout.setHorizontalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoTrocarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoInsiraDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelSuperiorLayout.setVerticalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoTrocarSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoInsiraDados)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelDadosFuncionario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados do Funcionário"));

        textoSenhaAtual.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoSenhaAtual.setText("Senha Atual:");

        textoDigiteNovaSenha.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoDigiteNovaSenha.setText("Digite a Nova Senha:");

        textoConfirmeNovaSenha.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoConfirmeNovaSenha.setText("Confirme a Nova Senha:");

        campoSenhaAtual.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        campoNovaSenha.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        campoConfirmacaoNovaSenha.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        javax.swing.GroupLayout painelDadosFuncionarioLayout = new javax.swing.GroupLayout(painelDadosFuncionario);
        painelDadosFuncionario.setLayout(painelDadosFuncionarioLayout);
        painelDadosFuncionarioLayout.setHorizontalGroup(
            painelDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelDadosFuncionarioLayout.createSequentialGroup()
                        .addComponent(textoDigiteNovaSenha)
                        .addGap(18, 18, 18)
                        .addComponent(campoNovaSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                    .addGroup(painelDadosFuncionarioLayout.createSequentialGroup()
                        .addComponent(textoConfirmeNovaSenha)
                        .addGap(18, 18, 18)
                        .addComponent(campoConfirmacaoNovaSenha))
                    .addGroup(painelDadosFuncionarioLayout.createSequentialGroup()
                        .addComponent(textoSenhaAtual)
                        .addGap(18, 18, 18)
                        .addComponent(campoSenhaAtual)))
                .addContainerGap())
        );

        painelDadosFuncionarioLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {textoConfirmeNovaSenha, textoDigiteNovaSenha, textoSenhaAtual});

        painelDadosFuncionarioLayout.setVerticalGroup(
            painelDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoSenhaAtual)
                    .addComponent(campoSenhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        botaoTrocarSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoTrocarSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/ok-32.png"))); // NOI18N
        botaoTrocarSenha.setText("Trocar Senha");
        botaoTrocarSenha.setNextFocusableComponent(botaoCancelarTrocaSenha);

        botaoCancelarTrocaSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoCancelarTrocaSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/cancel-32.png"))); // NOI18N
        botaoCancelarTrocaSenha.setText("Cancelar Troca de Senha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelDadosFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoCancelarTrocaSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoTrocarSenha)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(painelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelDadosFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoTrocarSenha)
                    .addComponent(botaoCancelarTrocaSenha))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBotaoCancelarNovaSenha() {
        return botaoCancelarTrocaSenha;
    }

    public void setBotaoCancelarNovaSenha(JButton botaoCancelarNovaSenha) {
        this.botaoCancelarTrocaSenha = botaoCancelarNovaSenha;
    }

    public JButton getBotaoCriarNovaSenha() {
        return botaoTrocarSenha;
    }

    public void setBotaoCriarNovaSenha(JButton botaoCriarNovaSenha) {
        this.botaoTrocarSenha = botaoCriarNovaSenha;
    }

    public JPasswordField getCampoConfirmacaoNovaSenha() {
        return campoConfirmacaoNovaSenha;
    }

    public void setCampoConfirmacaoNovaSenha(JPasswordField campoConfirmacaoNovaSenha) {
        this.campoConfirmacaoNovaSenha = campoConfirmacaoNovaSenha;
    }

    public JTextField getCampoCpfFuncionario() {
        return campoCpfFuncionario;
    }

    public void setCampoCpfFuncionario(JTextField campoCpfFuncionario) {
        this.campoCpfFuncionario = campoCpfFuncionario;
    }

    public JPasswordField getCampoNovaSenha() {
        return campoNovaSenha;
    }

    public void setCampoNovaSenha(JPasswordField campoNovaSenha) {
        this.campoNovaSenha = campoNovaSenha;
    }

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelarTrocaSenha;
    private javax.swing.JButton botaoTrocarSenha;
    private javax.swing.JPasswordField campoConfirmacaoNovaSenha;
    private javax.swing.JPasswordField campoNovaSenha;
    private javax.swing.JPasswordField campoSenhaAtual;
    private javax.swing.JPanel painelDadosFuncionario;
    private javax.swing.JPanel painelSuperior;
    private javax.swing.JLabel textoConfirmeNovaSenha;
    private javax.swing.JLabel textoDigiteNovaSenha;
    private javax.swing.JLabel textoInsiraDados;
    private javax.swing.JLabel textoSenhaAtual;
    private javax.swing.JLabel textoTrocarSenha;
    // End of variables declaration//GEN-END:variables
}