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

import com.au.bean.FormaPagamento;
import com.au.conexao.FabricaConexao;
import com.au.dao.FormaPagamentoDao;
import com.au.util.CustomComboBoxInt;
import com.au.util.GeradorRelatorio;
import com.au.util.JFileChooserCustomizado;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author tiago_000
 */
public class TelaVendasPorFormaPgto extends javax.swing.JDialog {

    private final Border vermelha = new MatteBorder(1, 1, 1, 1, Color.red);
    private final Border normal;
    private List<FormaPagamento> listaResFormasPagamento;
    private final FormaPagamentoDao fpDao = new FormaPagamentoDao();

    /**
     * Cria o novo form TelaVendasPorPeríodo
     *
     * @param parent Tela que chamou
     * @param modal
     */
    public TelaVendasPorFormaPgto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        buscaFormasPagamento();
        initComponents();
        normal = campoLocalParaSalvar.getBorder();
        campoDataInicio.setBorder(normal);
        campoDataTermino.setBorder(normal);
        caixaSelecaoCC.setVisible(false);
        caixaSelecaoCD.setVisible(false);
        caixaSelecaoVR.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupFormasPgto = new javax.swing.ButtonGroup();
        painelSuperior = new javax.swing.JPanel();
        textoVendasPorPeriodo = new javax.swing.JLabel();
        textoIconeVendasPorPeriodo = new javax.swing.JLabel();
        textoPreenchaOsCampos = new javax.swing.JLabel();
        painelInferior = new javax.swing.JPanel();
        textoDataInicio = new javax.swing.JLabel();
        campoDataInicio = new com.toedter.calendar.JDateChooser();
        textoDataTermino = new javax.swing.JLabel();
        campoDataTermino = new com.toedter.calendar.JDateChooser();
        textoEscolhaOLocal = new javax.swing.JLabel();
        campoLocalParaSalvar = new javax.swing.JTextField();
        botaoProcurarLocal = new javax.swing.JButton();
        textoIconeVR = new javax.swing.JLabel();
        botaoRadioDinheiro = new javax.swing.JRadioButton();
        botaoRadioCartaoDebito = new javax.swing.JRadioButton();
        textoIconeCD = new javax.swing.JLabel();
        textoIconeCC = new javax.swing.JLabel();
        botaoRadioCartaoCredito = new javax.swing.JRadioButton();
        textoIconeDinheiro = new javax.swing.JLabel();
        caixaSelecaoCC = new javax.swing.JComboBox(getFormasCredito());
        caixaSelecaoCD = new javax.swing.JComboBox(getFormasDebito());
        caixaSelecaoVR = new javax.swing.JComboBox(getFormasVale());
        botaoRadioValeRefeicao = new javax.swing.JRadioButton();
        textoSelecioneFormaPgto = new javax.swing.JLabel();
        botaoGerarRelatorio = new javax.swing.JButton();
        botaoCancelarGeracaoDeRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textoVendasPorPeriodo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        textoVendasPorPeriodo.setText("<html>Vendas Gerais, filtradas por <br/>Forma de Pagamento");

        textoIconeVendasPorPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/tag-64.png"))); // NOI18N

        textoPreenchaOsCampos.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        textoPreenchaOsCampos.setText("Preencha o campos abaixo para gerar o relatório de vendas gerais:");

        javax.swing.GroupLayout painelSuperiorLayout = new javax.swing.GroupLayout(painelSuperior);
        painelSuperior.setLayout(painelSuperiorLayout);
        painelSuperiorLayout.setHorizontalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoPreenchaOsCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelSuperiorLayout.createSequentialGroup()
                        .addComponent(textoIconeVendasPorPeriodo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoVendasPorPeriodo)))
                .addContainerGap())
        );
        painelSuperiorLayout.setVerticalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoIconeVendasPorPeriodo)
                    .addComponent(textoVendasPorPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(textoPreenchaOsCampos)
                .addContainerGap())
        );

        painelInferior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textoDataInicio.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoDataInicio.setText("Data de Início:");

        campoDataInicio.setDateFormatString("dd-MM-yyyy");
        campoDataInicio.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        textoDataTermino.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoDataTermino.setText("Data de Término:");

        campoDataTermino.setDateFormatString("dd-MM-yyyy");
        campoDataTermino.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        textoEscolhaOLocal.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoEscolhaOLocal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoEscolhaOLocal.setText("Escolha o local para salvar o relatório em pdf:");

        campoLocalParaSalvar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        botaoProcurarLocal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoProcurarLocal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/folder-26.png"))); // NOI18N
        botaoProcurarLocal.setText("Procurar");
        botaoProcurarLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoProcurarLocalActionPerformed(evt);
            }
        });

        textoIconeVR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/barcode-26.png"))); // NOI18N

        buttonGroupFormasPgto.add(botaoRadioDinheiro);
        botaoRadioDinheiro.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        botaoRadioDinheiro.setText("Dinheiro");
        botaoRadioDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRadioDinheiroActionPerformed(evt);
            }
        });

        buttonGroupFormasPgto.add(botaoRadioCartaoDebito);
        botaoRadioCartaoDebito.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        botaoRadioCartaoDebito.setText("Cartão de Débito");
        botaoRadioCartaoDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRadioCartaoDebitoActionPerformed(evt);
            }
        });

        textoIconeCD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/bank_cards-26.png"))); // NOI18N

        textoIconeCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/mastercard-26.png"))); // NOI18N

        buttonGroupFormasPgto.add(botaoRadioCartaoCredito);
        botaoRadioCartaoCredito.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        botaoRadioCartaoCredito.setText("Cartão de Crédito");
        botaoRadioCartaoCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRadioCartaoCreditoActionPerformed(evt);
            }
        });

        textoIconeDinheiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/banknotes-26.png"))); // NOI18N

        buttonGroupFormasPgto.add(botaoRadioValeRefeicao);
        botaoRadioValeRefeicao.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        botaoRadioValeRefeicao.setText("Vale Refeição");
        botaoRadioValeRefeicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRadioValeRefeicaoActionPerformed(evt);
            }
        });

        textoSelecioneFormaPgto.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoSelecioneFormaPgto.setText("Selecione a forma de pagamento desejada:");

        javax.swing.GroupLayout painelInferiorLayout = new javax.swing.GroupLayout(painelInferior);
        painelInferior.setLayout(painelInferiorLayout);
        painelInferiorLayout.setHorizontalGroup(
            painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoSelecioneFormaPgto)
                    .addGroup(painelInferiorLayout.createSequentialGroup()
                        .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoEscolhaOLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(painelInferiorLayout.createSequentialGroup()
                                .addComponent(campoLocalParaSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoProcurarLocal))
                            .addGroup(painelInferiorLayout.createSequentialGroup()
                                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelInferiorLayout.createSequentialGroup()
                                        .addComponent(botaoRadioDinheiro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textoIconeDinheiro)
                                        .addGap(18, 18, 18)
                                        .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(painelInferiorLayout.createSequentialGroup()
                                                .addComponent(botaoRadioCartaoCredito)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textoIconeCC))
                                            .addComponent(caixaSelecaoCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(painelInferiorLayout.createSequentialGroup()
                                                .addComponent(botaoRadioCartaoDebito)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textoIconeCD))
                                            .addComponent(caixaSelecaoCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(painelInferiorLayout.createSequentialGroup()
                                                .addComponent(botaoRadioValeRefeicao)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textoIconeVR))
                                            .addComponent(caixaSelecaoVR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelInferiorLayout.createSequentialGroup()
                                            .addComponent(textoDataTermino)
                                            .addGap(18, 18, 18)
                                            .addComponent(campoDataTermino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelInferiorLayout.createSequentialGroup()
                                            .addComponent(textoDataInicio)
                                            .addGap(18, 18, 18)
                                            .addComponent(campoDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        painelInferiorLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {textoDataInicio, textoDataTermino});

        painelInferiorLayout.setVerticalGroup(
            painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoDataInicio)
                    .addComponent(campoDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoDataTermino)
                    .addComponent(campoDataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoSelecioneFormaPgto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textoIconeDinheiro)
                            .addComponent(botaoRadioDinheiro)
                            .addComponent(botaoRadioCartaoCredito))
                        .addComponent(botaoRadioCartaoDebito)
                        .addComponent(textoIconeCC)
                        .addComponent(textoIconeCD)
                        .addComponent(botaoRadioValeRefeicao, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(textoIconeVR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caixaSelecaoCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caixaSelecaoCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caixaSelecaoVR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textoEscolhaOLocal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoLocalParaSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoProcurarLocal))
                .addContainerGap())
        );

        botaoGerarRelatorio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoGerarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/ok-32.png"))); // NOI18N
        botaoGerarRelatorio.setText("Gerar Relatório");
        botaoGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerarRelatorioActionPerformed(evt);
            }
        });

        botaoCancelarGeracaoDeRelatorio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoCancelarGeracaoDeRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/cancel-32.png"))); // NOI18N
        botaoCancelarGeracaoDeRelatorio.setText("Cancelar Geração de Relatório");
        botaoCancelarGeracaoDeRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarGeracaoDeRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoCancelarGeracaoDeRelatorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botaoCancelarGeracaoDeRelatorio, botaoGerarRelatorio});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoGerarRelatorio)
                    .addComponent(botaoCancelarGeracaoDeRelatorio))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoRadioDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRadioDinheiroActionPerformed
        habilitaDinheiro();
        botaoGerarRelatorio.requestFocus();
    }//GEN-LAST:event_botaoRadioDinheiroActionPerformed

    private void botaoRadioCartaoCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRadioCartaoCreditoActionPerformed
        habilitaCC();
    }//GEN-LAST:event_botaoRadioCartaoCreditoActionPerformed

    private void botaoRadioCartaoDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRadioCartaoDebitoActionPerformed
        habilitaCD();
    }//GEN-LAST:event_botaoRadioCartaoDebitoActionPerformed

    private void botaoRadioValeRefeicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRadioValeRefeicaoActionPerformed
        habilitaVR();
    }//GEN-LAST:event_botaoRadioValeRefeicaoActionPerformed

    private void botaoProcurarLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoProcurarLocalActionPerformed
        procuraLocal();
    }//GEN-LAST:event_botaoProcurarLocalActionPerformed

    private void botaoGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerarRelatorioActionPerformed
        if (valida()) {
            JOptionPane.showMessageDialog(this, "A geração de Relatórios pode demorar alguns minutos. \n Aguarde a mensagem de confirmação.");
            try {
                geraRelatorio();
            } catch (ParseException ex) {
                Logger.getLogger(TelaVendasPorFormaPgto.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        }
    }//GEN-LAST:event_botaoGerarRelatorioActionPerformed

    private void botaoCancelarGeracaoDeRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarGeracaoDeRelatorioActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoCancelarGeracaoDeRelatorioActionPerformed

    private void buscaFormasPagamento() {
        fpDao.abreConnection();
        listaResFormasPagamento = fpDao.getLista();
        fpDao.fechaConnection();
    }

    public void habilitaDinheiro() {
        limpaBorda();
        caixaSelecaoCC.setVisible(false);
        caixaSelecaoCC.setSelectedIndex(-1);
        caixaSelecaoCD.setVisible(false);
        caixaSelecaoCD.setSelectedIndex(-1);
        caixaSelecaoVR.setVisible(false);
        caixaSelecaoVR.setSelectedIndex(-1);
    }

    public void habilitaCC() {
        limpaBorda();
        caixaSelecaoCC.setVisible(true);
        caixaSelecaoCC.setSelectedIndex(-1);
        caixaSelecaoCD.setVisible(false);
        caixaSelecaoCD.setSelectedIndex(-1);
        caixaSelecaoVR.setVisible(false);
        caixaSelecaoVR.setSelectedIndex(-1);
    }

    public void habilitaCD() {
        limpaBorda();
        caixaSelecaoCC.setVisible(false);
        caixaSelecaoCC.setSelectedIndex(-1);
        caixaSelecaoCD.setVisible(true);
        caixaSelecaoCD.setSelectedIndex(-1);
        caixaSelecaoVR.setVisible(false);
        caixaSelecaoVR.setSelectedIndex(-1);
    }

    public void habilitaVR() {
        limpaBorda();
        caixaSelecaoCC.setVisible(false);
        caixaSelecaoCC.setSelectedIndex(-1);
        caixaSelecaoCD.setVisible(false);
        caixaSelecaoCD.setSelectedIndex(-1);
        caixaSelecaoVR.setVisible(true);
        caixaSelecaoVR.setSelectedIndex(-1);
    }

    private void geraRelatorio() throws ParseException {
        String nome = "reports\\vendas_por_pagamento.jasper";
        Map<String, Object> parametros = new HashMap<>();
        Connection conexao = new FabricaConexao().getConexao();
        OutputStream saida = null;
        String tipoPgto = "";
        String nomePgto = "";
        try {
            saida = new FileOutputStream(campoLocalParaSalvar.getText());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TelaVendasPorFormaPgto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Houve um erro ao salvar o arquivo:\n" + ex);
            return;
        }
        File arquivo = new File(campoLocalParaSalvar.getText());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dataIni = sdf.format(campoDataInicio.getDate());
        String dataFim = sdf.format(campoDataTermino.getDate());

        Date dataInicial = sdf.parse(dataIni);
        Date dataFinal = sdf.parse(dataFim);

        if (botaoRadioDinheiro.isSelected()) {
            tipoPgto = "Dinheiro";
            nomePgto = "Dinheiro";
        } else if (botaoRadioCartaoCredito.isSelected()) {
            tipoPgto = "Credito";
            nomePgto = caixaSelecaoCC.getSelectedItem().toString();
        } else if (botaoRadioCartaoDebito.isSelected()) {
            tipoPgto = "Debito";
            nomePgto = caixaSelecaoCD.getSelectedItem().toString();
        } else if (botaoRadioValeRefeicao.isSelected()) {
            tipoPgto = "Vale";
            nomePgto = caixaSelecaoVR.getSelectedItem().toString();
        }

        parametros.put("DATA_INI", dataInicial);
        parametros.put("DATA_FIM", dataFinal);
        parametros.put("TIPO_PGTO", tipoPgto);
        parametros.put("NOME_PGTO", nomePgto);

        GeradorRelatorio gerador = new GeradorRelatorio(nome, parametros, conexao);
        gerador.geraPdfParaOutputStream(saida);

        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "Relatório Gerado com Sucesso!\nDeseja abrir o relatório agora?", "Geração de Relatório", JOptionPane.YES_NO_OPTION)) {
            try {
                Desktop.getDesktop().open(arquivo);

            } catch (IOException ex) {
                Logger.getLogger(TelaVendasPorFormaPgto.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private CustomComboBoxInt[] getFormasDebito() {
        List<FormaPagamento> listaResFormasDebito = new ArrayList<>();
        if (listaResFormasPagamento != null) {
            for (int i = 0; listaResFormasPagamento.size() > i; i++) {
                if ("Debito".equals(listaResFormasPagamento.get(i).getTipoFormaPgto()) && listaResFormasPagamento.get(i).getEstaAtivo() == ((byte) 1)) {
                    listaResFormasDebito.add(listaResFormasPagamento.get(i));
                }
            }
        }
        CustomComboBoxInt[] oItems = new CustomComboBoxInt[listaResFormasDebito.size()];
        for (int i = 0; i < listaResFormasDebito.size(); i++) {
            oItems[i] = new CustomComboBoxInt(listaResFormasDebito.get(i).getNomeFormaPgto(), listaResFormasDebito.get(i).getIdFormaPgto());
        }
        return oItems;
    }

    private CustomComboBoxInt[] getFormasCredito() {
        List<FormaPagamento> listaResFormasCredito = new ArrayList<>();
        if (listaResFormasPagamento != null) {
            for (int i = 0; listaResFormasPagamento.size() > i; i++) {
                if ("Credito".equals(listaResFormasPagamento.get(i).getTipoFormaPgto()) && listaResFormasPagamento.get(i).getEstaAtivo() == ((byte) 1)) {
                    listaResFormasCredito.add(listaResFormasPagamento.get(i));
                }
            }
        }
        CustomComboBoxInt[] oItems = new CustomComboBoxInt[listaResFormasCredito.size()];
        for (int i = 0; i < listaResFormasCredito.size(); i++) {
            oItems[i] = new CustomComboBoxInt(listaResFormasCredito.get(i).getNomeFormaPgto(), listaResFormasCredito.get(i).getIdFormaPgto());
        }
        return oItems;
    }

    private CustomComboBoxInt[] getFormasVale() {
        List<FormaPagamento> listaResFormasVale = new ArrayList<>();
        if (listaResFormasPagamento != null) {
            for (int i = 0; listaResFormasPagamento.size() > i; i++) {
                if ("Vale".equals(listaResFormasPagamento.get(i).getTipoFormaPgto()) && listaResFormasPagamento.get(i).getEstaAtivo() == ((byte) 1)) {
                    listaResFormasVale.add(listaResFormasPagamento.get(i));
                }
            }
        }
        CustomComboBoxInt[] oItems = new CustomComboBoxInt[listaResFormasVale.size()];
        for (int i = 0; i < listaResFormasVale.size(); i++) {
            oItems[i] = new CustomComboBoxInt(listaResFormasVale.get(i).getNomeFormaPgto(), listaResFormasVale.get(i).getIdFormaPgto());
        }
        return oItems;
    }

    public void limpaBorda() {
        botaoRadioCartaoDebito.setBorderPainted(false);
        botaoRadioCartaoCredito.setBorderPainted(false);
        botaoRadioDinheiro.setBorderPainted(false);
        botaoRadioValeRefeicao.setBorderPainted(false);
        caixaSelecaoCC.setBorder(normal);
        caixaSelecaoCD.setBorder(normal);
        caixaSelecaoVR.setBorder(normal);
    }

    private void procuraLocal() {
        JFileChooserCustomizado file = new JFileChooserCustomizado(".", "pdf");
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        file.setFileFilter(new FileNameExtensionFilter("Documentos em PDF", "pdf"));
        int selecao = file.showSaveDialog(this);
        if (selecao != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File arquivo = file.getSelectedFile();
        if (arquivo.exists() && JOptionPane.showConfirmDialog(this, "O Arquivo já existe. Deseja mesmo substituí-lo?", "Substituir Arquivo Existente", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }
        String localArquivo = arquivo.getAbsolutePath();
        campoLocalParaSalvar.setText(localArquivo);
    }

    public boolean valida() {
        boolean valida = true;
        if (campoDataInicio.getDate() != null) {
            campoDataInicio.setBorder(normal);
        } else {
            campoDataInicio.setBorder(vermelha);
            valida = false;
        }
        if (campoDataTermino.getDate() != null) {
            campoDataTermino.setBorder(normal);
        } else {
            campoDataTermino.setBorder(vermelha);
            valida = false;
        }
        if (botaoRadioDinheiro.isSelected() || botaoRadioCartaoCredito.isSelected() || botaoRadioCartaoDebito.isSelected() || botaoRadioValeRefeicao.isSelected()) {
            limpaBorda();
        } else {
            valida = false;
            botaoRadioCartaoDebito.setBorder(vermelha);
            botaoRadioCartaoDebito.setBorderPainted(true);
            botaoRadioCartaoCredito.setBorder(vermelha);
            botaoRadioCartaoCredito.setBorderPainted(true);
            botaoRadioDinheiro.setBorder(vermelha);
            botaoRadioDinheiro.setBorderPainted(true);
            botaoRadioValeRefeicao.setBorder(vermelha);
            botaoRadioValeRefeicao.setBorderPainted(true);
        }
        if (botaoRadioCartaoCredito.isSelected()) {
            if (caixaSelecaoCC.getSelectedIndex() == -1) {
                valida = false;
                caixaSelecaoCC.setBorder(vermelha);
            }
        } else {
            caixaSelecaoCC.setBorder(normal);
        }
        if (botaoRadioCartaoDebito.isSelected()) {
            if (caixaSelecaoCD.getSelectedIndex() == -1) {
                valida = false;
                caixaSelecaoCD.setBorder(vermelha);
            }
        } else {
            caixaSelecaoCD.setBorder(normal);
        }
        if (botaoRadioValeRefeicao.isSelected()) {
            if (caixaSelecaoVR.getSelectedIndex() == -1) {
                valida = false;
                caixaSelecaoVR.setBorder(vermelha);
            }
        } else {
            caixaSelecaoVR.setBorder(normal);
        }

        if (!"".equals(campoLocalParaSalvar.getText())) {
            campoLocalParaSalvar.setBorder(normal);
        } else {
            valida = false;
            campoLocalParaSalvar.setBorder(vermelha);
        }
        return valida;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelarGeracaoDeRelatorio;
    private javax.swing.JButton botaoGerarRelatorio;
    private javax.swing.JButton botaoProcurarLocal;
    private javax.swing.JRadioButton botaoRadioCartaoCredito;
    private javax.swing.JRadioButton botaoRadioCartaoDebito;
    private javax.swing.JRadioButton botaoRadioDinheiro;
    private javax.swing.JRadioButton botaoRadioValeRefeicao;
    private javax.swing.ButtonGroup buttonGroupFormasPgto;
    private javax.swing.JComboBox caixaSelecaoCC;
    private javax.swing.JComboBox caixaSelecaoCD;
    private javax.swing.JComboBox caixaSelecaoVR;
    private com.toedter.calendar.JDateChooser campoDataInicio;
    private com.toedter.calendar.JDateChooser campoDataTermino;
    private javax.swing.JTextField campoLocalParaSalvar;
    private javax.swing.JPanel painelInferior;
    private javax.swing.JPanel painelSuperior;
    private javax.swing.JLabel textoDataInicio;
    private javax.swing.JLabel textoDataTermino;
    private javax.swing.JLabel textoEscolhaOLocal;
    private javax.swing.JLabel textoIconeCC;
    private javax.swing.JLabel textoIconeCD;
    private javax.swing.JLabel textoIconeDinheiro;
    private javax.swing.JLabel textoIconeVR;
    private javax.swing.JLabel textoIconeVendasPorPeriodo;
    private javax.swing.JLabel textoPreenchaOsCampos;
    private javax.swing.JLabel textoSelecioneFormaPgto;
    private javax.swing.JLabel textoVendasPorPeriodo;
    // End of variables declaration//GEN-END:variables
}
