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

import com.au.modelo.FormaPagamento;
import com.au.util.CustomComboBoxInt;
import com.au.dao.DAO;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author tiago_000
 */
public class TelaVendasPorFormaPgto extends javax.swing.JDialog {

    private List<FormaPagamento> listaResFormasPagamento;


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

        textoIconeVR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/barcode-26.png"))); // NOI18N

        buttonGroupFormasPgto.add(botaoRadioDinheiro);
        botaoRadioDinheiro.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        botaoRadioDinheiro.setText("Dinheiro");

        buttonGroupFormasPgto.add(botaoRadioCartaoDebito);
        botaoRadioCartaoDebito.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        botaoRadioCartaoDebito.setText("Cartão de Débito");

        textoIconeCD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/bank_cards-26.png"))); // NOI18N

        textoIconeCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/mastercard-26.png"))); // NOI18N

        buttonGroupFormasPgto.add(botaoRadioCartaoCredito);
        botaoRadioCartaoCredito.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        botaoRadioCartaoCredito.setText("Cartão de Crédito");

        textoIconeDinheiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/banknotes-26.png"))); // NOI18N

        buttonGroupFormasPgto.add(botaoRadioValeRefeicao);
        botaoRadioValeRefeicao.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        botaoRadioValeRefeicao.setText("Vale Refeição");

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

        botaoCancelarGeracaoDeRelatorio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoCancelarGeracaoDeRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/cancel-32.png"))); // NOI18N
        botaoCancelarGeracaoDeRelatorio.setText("Cancelar Geração de Relatório");

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

    public JButton getBotaoCancelarGeracaoDeRelatorio() {
        return botaoCancelarGeracaoDeRelatorio;
    }

    public void setBotaoCancelarGeracaoDeRelatorio(JButton botaoCancelarGeracaoDeRelatorio) {
        this.botaoCancelarGeracaoDeRelatorio = botaoCancelarGeracaoDeRelatorio;
    }

    public JButton getBotaoGerarRelatorio() {
        return botaoGerarRelatorio;
    }

    public void setBotaoGerarRelatorio(JButton botaoGerarRelatorio) {
        this.botaoGerarRelatorio = botaoGerarRelatorio;
    }

    public JButton getBotaoProcurarLocal() {
        return botaoProcurarLocal;
    }

    public void setBotaoProcurarLocal(JButton botaoProcurarLocal) {
        this.botaoProcurarLocal = botaoProcurarLocal;
    }

    public JRadioButton getBotaoRadioCartaoCredito() {
        return botaoRadioCartaoCredito;
    }

    public void setBotaoRadioCartaoCredito(JRadioButton botaoRadioCartaoCredito) {
        this.botaoRadioCartaoCredito = botaoRadioCartaoCredito;
    }

    public JRadioButton getBotaoRadioCartaoDebito() {
        return botaoRadioCartaoDebito;
    }

    public void setBotaoRadioCartaoDebito(JRadioButton botaoCartaoDebito) {
        this.botaoRadioCartaoDebito = botaoCartaoDebito;
    }

    public JRadioButton getBotaoRadioDinheiro() {
        return botaoRadioDinheiro;
    }

    public void setBotaoRadioDinheiro(JRadioButton botaoRadioDinheiro) {
        this.botaoRadioDinheiro = botaoRadioDinheiro;
    }

    public JRadioButton getBotaoRadioValeRefeicao() {
        return botaoRadioValeRefeicao;
    }

    public void setBotaoRadioValeRefeicao(JRadioButton botaoRadioValeRefeicao) {
        this.botaoRadioValeRefeicao = botaoRadioValeRefeicao;
    }

    public JComboBox getCaixaSelecaoCC() {
        return caixaSelecaoCC;
    }

    public void setCaixaSelecaoCC(JComboBox caixaSelecaoCC) {
        this.caixaSelecaoCC = caixaSelecaoCC;
    }

    public JComboBox getCaixaSelecaoCD() {
        return caixaSelecaoCD;
    }

    public void setCaixaSelecaoCD(JComboBox caixaSelecaoCD) {
        this.caixaSelecaoCD = caixaSelecaoCD;
    }

    public JComboBox getCaixaSelecaoVR() {
        return caixaSelecaoVR;
    }

    public void setCaixaSelecaoVR(JComboBox caixaSelecaoVR) {
        this.caixaSelecaoVR = caixaSelecaoVR;
    }

    public JDateChooser getCampoDataInicio() {
        return campoDataInicio;
    }

    public void setCampoDataInicio(JDateChooser campoDataInicio) {
        this.campoDataInicio = campoDataInicio;
    }

    public JDateChooser getCampoDataTermino() {
        return campoDataTermino;
    }

    public void setCampoDataTermino(JDateChooser campoDataTermino) {
        this.campoDataTermino = campoDataTermino;
    }

    public JTextField getCampoLocalParaSalvar() {
        return campoLocalParaSalvar;
    }

    public void setCampoLocalParaSalvar(JTextField campoLocalParaSalvar) {
        this.campoLocalParaSalvar = campoLocalParaSalvar;
    }

    public void buscaFormasPagamento() {
        System.out.println("Chegou na Busca");
        listaResFormasPagamento = new DAO<>(FormaPagamento.class).listaTodos();
        System.out.println(listaResFormasPagamento.size());

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
