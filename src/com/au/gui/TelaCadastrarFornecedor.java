/*
 * The MIT License
 *
 * Copyright 2014 tiago_000.
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

import com.au.modelo.Fornecedor;
import com.au.util.DAO;
import com.au.util.LimitaDigitos;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author tiago_000
 */
public class TelaCadastrarFornecedor extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastrarFornecedor
     */
    int[] validaForm = {0, 0, 0, 0, 0};
    Border border2 = BorderFactory.createLineBorder(Color.gray, 1);
    Border border = BorderFactory.createLineBorder(Color.red, 1);

    public TelaCadastrarFornecedor() {
        initComponents();
        campoNomeFornecedor.setDocument(new LimitaDigitos((250), "[^a-z|^A-Z|^ ]"));
        campoCnpjFornecedor.setDocument(new LimitaDigitos((20), "[^0-9|^.\\-]"));
        campoEmailFornecedor.setDocument(new LimitaDigitos((150), "[^0-9|^.|^_|^@|^a-z|^A-Z\\-]"));
        campoCelularFornecedor.setDocument(new LimitaDigitos((15), "[^0-9|^()\\-]"));
        campoTelefoneFornecedor.setDocument(new LimitaDigitos((15), "[^0-9|^()\\-]"));
        campoIdFornecedor.setEnabled(false);
        campoNomeFornecedor.requestFocus();
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
        textoAdicionarFornecedor = new javax.swing.JLabel();
        textoPreencherDados = new javax.swing.JLabel();
        textoIconeNovoFornecedor = new javax.swing.JLabel();
        painelAdicionarModificarFornecedor = new javax.swing.JPanel();
        textoIdFornecedor = new javax.swing.JLabel();
        campoIdFornecedor = new javax.swing.JTextField();
        textoNomeFornecedor = new javax.swing.JLabel();
        campoNomeFornecedor = new javax.swing.JTextField();
        textoCnpjFornecedor = new javax.swing.JLabel();
        campoCnpjFornecedor = new javax.swing.JTextField();
        textoEmailFornecedor = new javax.swing.JLabel();
        campoEmailFornecedor = new javax.swing.JTextField();
        textoTelefoneFornecedor = new javax.swing.JLabel();
        campoTelefoneFornecedor = new javax.swing.JTextField();
        textoCelularFornecedor = new javax.swing.JLabel();
        campoCelularFornecedor = new javax.swing.JTextField();
        painelProcurarFornecedores = new javax.swing.JPanel();
        textoProcurarFornecedor = new javax.swing.JLabel();
        campoPesquisarFornecedor = new javax.swing.JTextField();
        botaoProcurarFornecedor = new javax.swing.JButton();
        textoCliqueParaEditar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFornecedores = new javax.swing.JTable();
        painelBotoes = new javax.swing.JPanel();
        botaoCancelarCadastro = new javax.swing.JButton();
        botaoCadastrarFornecedor = new javax.swing.JButton();
        botaoLimparCampos = new javax.swing.JButton();
        botaoAtualizarFornecedor = new javax.swing.JButton();
        botaoExcluirFornecedor = new javax.swing.JButton();
        barraMenu = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        menuEditar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adiconar novo Fornecedor");

        painelSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textoAdicionarFornecedor.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        textoAdicionarFornecedor.setText("Adicionar Novo Fornecedor");

        textoPreencherDados.setText("Preencha os dados abaixo para adicionar um novo fornecedor.");

        textoIconeNovoFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/collaborator-64.png"))); // NOI18N

        javax.swing.GroupLayout painelSuperiorLayout = new javax.swing.GroupLayout(painelSuperior);
        painelSuperior.setLayout(painelSuperiorLayout);
        painelSuperiorLayout.setHorizontalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoIconeNovoFornecedor)
                .addGap(18, 18, 18)
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoAdicionarFornecedor)
                    .addComponent(textoPreencherDados))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelSuperiorLayout.setVerticalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoIconeNovoFornecedor)
                    .addGroup(painelSuperiorLayout.createSequentialGroup()
                        .addComponent(textoAdicionarFornecedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoPreencherDados)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelAdicionarModificarFornecedor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Adicionar/Modificar Fornecedor"));

        textoIdFornecedor.setText("ID:");

        campoIdFornecedor.setEnabled(false);

        textoNomeFornecedor.setText("Nome Completo:");

        campoNomeFornecedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNomeFornecedorFocusLost(evt);
            }
        });

        textoCnpjFornecedor.setText("CNPJ: ");

        campoCnpjFornecedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoCnpjFornecedorFocusLost(evt);
            }
        });

        textoEmailFornecedor.setText("E-mail:");

        campoEmailFornecedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoEmailFornecedorFocusLost(evt);
            }
        });

        textoTelefoneFornecedor.setText("Telefone:");

        campoTelefoneFornecedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoTelefoneFornecedorFocusLost(evt);
            }
        });

        textoCelularFornecedor.setText("Celular:");

        campoCelularFornecedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoCelularFornecedorFocusLost(evt);
            }
        });

        javax.swing.GroupLayout painelAdicionarModificarFornecedorLayout = new javax.swing.GroupLayout(painelAdicionarModificarFornecedor);
        painelAdicionarModificarFornecedor.setLayout(painelAdicionarModificarFornecedorLayout);
        painelAdicionarModificarFornecedorLayout.setHorizontalGroup(
            painelAdicionarModificarFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAdicionarModificarFornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAdicionarModificarFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoNomeFornecedor)
                    .addComponent(textoIdFornecedor)
                    .addComponent(textoCnpjFornecedor)
                    .addComponent(textoEmailFornecedor)
                    .addComponent(textoTelefoneFornecedor)
                    .addComponent(textoCelularFornecedor))
                .addGap(18, 18, 18)
                .addGroup(painelAdicionarModificarFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelAdicionarModificarFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(campoCnpjFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoIdFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoNomeFornecedor)
                        .addComponent(campoEmailFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addComponent(campoTelefoneFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campoCelularFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        painelAdicionarModificarFornecedorLayout.setVerticalGroup(
            painelAdicionarModificarFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAdicionarModificarFornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAdicionarModificarFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoIdFornecedor)
                    .addComponent(campoIdFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelAdicionarModificarFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoNomeFornecedor)
                    .addComponent(campoNomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelAdicionarModificarFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoCnpjFornecedor)
                    .addComponent(campoCnpjFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelAdicionarModificarFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoEmailFornecedor)
                    .addComponent(campoEmailFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelAdicionarModificarFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoTelefoneFornecedor)
                    .addComponent(campoTelefoneFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelAdicionarModificarFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoCelularFornecedor)
                    .addComponent(campoCelularFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(180, Short.MAX_VALUE))
        );

        painelProcurarFornecedores.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Procurar Fornecedor Existente"));

        textoProcurarFornecedor.setText("Procurar Fornecedor:");

        botaoProcurarFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/search-26.png"))); // NOI18N
        botaoProcurarFornecedor.setText("Procurar");

        textoCliqueParaEditar.setText("Clique no fornecedor desejado na lista para editá-lo no painel ao lado:");

        tabelaFornecedores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaFornecedores);

        javax.swing.GroupLayout painelProcurarFornecedoresLayout = new javax.swing.GroupLayout(painelProcurarFornecedores);
        painelProcurarFornecedores.setLayout(painelProcurarFornecedoresLayout);
        painelProcurarFornecedoresLayout.setHorizontalGroup(
            painelProcurarFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProcurarFornecedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelProcurarFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(painelProcurarFornecedoresLayout.createSequentialGroup()
                        .addGroup(painelProcurarFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelProcurarFornecedoresLayout.createSequentialGroup()
                                .addComponent(textoProcurarFornecedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoPesquisarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoProcurarFornecedor))
                            .addComponent(textoCliqueParaEditar))
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelProcurarFornecedoresLayout.setVerticalGroup(
            painelProcurarFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProcurarFornecedoresLayout.createSequentialGroup()
                .addGroup(painelProcurarFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPesquisarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoProcurarFornecedor)
                    .addComponent(botaoProcurarFornecedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoCliqueParaEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        botaoCancelarCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/cancel-32.png"))); // NOI18N
        botaoCancelarCadastro.setText("Cancelar Cadastro");

        botaoCadastrarFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/ok-32.png"))); // NOI18N
        botaoCadastrarFornecedor.setText("Cadastrar Fornecedor");
        botaoCadastrarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarFornecedorActionPerformed(evt);
            }
        });

        botaoLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/erase-32.png"))); // NOI18N
        botaoLimparCampos.setText("Limpar Campos");

        botaoAtualizarFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/refresh-32.png"))); // NOI18N
        botaoAtualizarFornecedor.setText("Atualizar Fornecedor");

        botaoExcluirFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/delete-32.png"))); // NOI18N
        botaoExcluirFornecedor.setText("Excluir Fornecedor");

        javax.swing.GroupLayout painelBotoesLayout = new javax.swing.GroupLayout(painelBotoes);
        painelBotoes.setLayout(painelBotoesLayout);
        painelBotoesLayout.setHorizontalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoLimparCampos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoExcluirFornecedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoAtualizarFornecedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoCancelarCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoCadastrarFornecedor)
                .addContainerGap())
        );
        painelBotoesLayout.setVerticalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelarCadastro)
                    .addComponent(botaoCadastrarFornecedor)
                    .addComponent(botaoLimparCampos)
                    .addComponent(botaoAtualizarFornecedor)
                    .addComponent(botaoExcluirFornecedor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuArquivo.setText("Arquivo");
        barraMenu.add(menuArquivo);

        menuEditar.setText("Editar");
        barraMenu.add(menuEditar);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelSuperior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelAdicionarModificarFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelProcurarFornecedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(painelBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelProcurarFornecedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelAdicionarModificarFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean validaCampos() {
        for (int i = 0; i < validaForm.length; i++) {
            if (validaForm[i] == 0) {
                return false;
            }
        }
        return true;
    }

    private void campoNomeFornecedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNomeFornecedorFocusLost
        if (!campoNomeFornecedor.getText().equals("")) {
            validaForm[0] = 1;
            campoNomeFornecedor.setBorder(border2);
        } else {
            validaForm[0] = 0;
            campoNomeFornecedor.setBorder(border);
        }
    }//GEN-LAST:event_campoNomeFornecedorFocusLost

    private void campoCnpjFornecedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCnpjFornecedorFocusLost
        if (!campoCnpjFornecedor.getText().equals("")) {
            validaForm[1] = 1;
            campoCnpjFornecedor.setBorder(border2);
        } else {
            validaForm[1] = 0;
            campoCnpjFornecedor.setBorder(border);
        }
    }//GEN-LAST:event_campoCnpjFornecedorFocusLost

    private void campoEmailFornecedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoEmailFornecedorFocusLost
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher m = p.matcher(campoEmailFornecedor.getText());

        if (m.matches()) {
            validaForm[2] = 1;
            campoEmailFornecedor.setBorder(border2);
        } else {
            campoEmailFornecedor.setBorder(border);
            validaForm[2] = 0;
        }
    }//GEN-LAST:event_campoEmailFornecedorFocusLost

    private void campoTelefoneFornecedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoTelefoneFornecedorFocusLost
        if (!campoTelefoneFornecedor.getText().equals("")) {
            validaForm[3] = 1;
            campoTelefoneFornecedor.setBorder(border2);
        } else {
            validaForm[3] = 0;
            campoTelefoneFornecedor.setBorder(border);
        }
    }//GEN-LAST:event_campoTelefoneFornecedorFocusLost

    private void campoCelularFornecedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCelularFornecedorFocusLost
        if (!campoCelularFornecedor.getText().equals("")) {
            validaForm[4] = 1;
            campoCelularFornecedor.setBorder(border2);
        } else {
            validaForm[4] = 0;
            campoCelularFornecedor.setBorder(border);
        }
    }//GEN-LAST:event_campoCelularFornecedorFocusLost

    private void botaoCadastrarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarFornecedorActionPerformed
        if (validaCampos()) {
            Fornecedor fornecedor = new Fornecedor();

            fornecedor.setNomeForn(campoNomeFornecedor.getText());
            fornecedor.setCnpjForn(campoCnpjFornecedor.getText());
            fornecedor.setMailForn(campoEmailFornecedor.getText());
            fornecedor.setFoneForn(campoTelefoneFornecedor.getText());
            fornecedor.setCelForn(campoCelularFornecedor.getText());

            new DAO<>(Fornecedor.class).adiciona(fornecedor);

            campoNomeFornecedor.setText("");
            campoCnpjFornecedor.setText("");
            campoEmailFornecedor.setText("");
            campoTelefoneFornecedor.setText("");
            campoCelularFornecedor.setText("");
        } else {
            if (validaForm[0] == 0) {
                campoNomeFornecedor.setBorder(border);
            }
            if (validaForm[1] == 0) {
                campoCnpjFornecedor.setBorder(border);
            }
            if (validaForm[2] == 0) {
                campoEmailFornecedor.setBorder(border);
            }
            if (validaForm[3] == 0) {
                campoTelefoneFornecedor.setBorder(border);
            }
            if (validaForm[4] == 0) {
                campoCelularFornecedor.setBorder(border);
            }
        }
    }//GEN-LAST:event_botaoCadastrarFornecedorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastrarFornecedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton botaoAtualizarFornecedor;
    private javax.swing.JButton botaoCadastrarFornecedor;
    private javax.swing.JButton botaoCancelarCadastro;
    private javax.swing.JButton botaoExcluirFornecedor;
    private javax.swing.JButton botaoLimparCampos;
    private javax.swing.JButton botaoProcurarFornecedor;
    private javax.swing.JTextField campoCelularFornecedor;
    private javax.swing.JTextField campoCnpjFornecedor;
    private javax.swing.JTextField campoEmailFornecedor;
    private javax.swing.JTextField campoIdFornecedor;
    private javax.swing.JTextField campoNomeFornecedor;
    private javax.swing.JTextField campoPesquisarFornecedor;
    private javax.swing.JTextField campoTelefoneFornecedor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenu menuEditar;
    private javax.swing.JPanel painelAdicionarModificarFornecedor;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelProcurarFornecedores;
    private javax.swing.JPanel painelSuperior;
    private javax.swing.JTable tabelaFornecedores;
    private javax.swing.JLabel textoAdicionarFornecedor;
    private javax.swing.JLabel textoCelularFornecedor;
    private javax.swing.JLabel textoCliqueParaEditar;
    private javax.swing.JLabel textoCnpjFornecedor;
    private javax.swing.JLabel textoEmailFornecedor;
    private javax.swing.JLabel textoIconeNovoFornecedor;
    private javax.swing.JLabel textoIdFornecedor;
    private javax.swing.JLabel textoNomeFornecedor;
    private javax.swing.JLabel textoPreencherDados;
    private javax.swing.JLabel textoProcurarFornecedor;
    private javax.swing.JLabel textoTelefoneFornecedor;
    // End of variables declaration//GEN-END:variables
}
