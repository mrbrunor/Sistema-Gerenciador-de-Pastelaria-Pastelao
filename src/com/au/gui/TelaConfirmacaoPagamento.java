/*
 * The MIT License
 *
 * Copyright 2014 BrunoRicardo.
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

import com.au.gui.listener.PagamentoActionListener;
import com.au.modelo.Caixa;
import com.au.modelo.FormaPagamento;
import com.au.modelo.Funcionario;
import com.au.modelo.Pedido;
import com.au.util.CustomComboBoxInt;
import com.au.dao.DAO;
import com.au.util.LimitaDigitos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author BrunoRicardo
 */
public class TelaConfirmacaoPagamento extends javax.swing.JDialog {

    private Funcionario funcionario = new Funcionario();
    private Pedido pedido = new Pedido();
    private static Caixa caixa = null;
    private Integer indexCaixa = null;
    private double subTotal = 0;
    private double total = 0;
    private final PagamentoActionListener listener;
    private static boolean pagou = false;
    private List<FormaPagamento> listaResFormasPagamento;

    public TelaConfirmacaoPagamento(java.awt.Frame parent, boolean modal, Funcionario funcionario, Pedido pedido, Integer indexCaixa, Double subTotal) {
        super(parent, modal);
        this.pedido = pedido;
        this.funcionario = funcionario;
        this.indexCaixa = indexCaixa;
        this.subTotal = subTotal;
        buscaFormasPagamento();
        initComponents();
        campoDesconto.setDocument(new LimitaDigitos((8), "[^0-9\\.]"));
        campoMesa.setDocument(new LimitaDigitos((2), "[^0-9]"));
        caixaSelecaoCC.setVisible(false);
        caixaSelecaoCD.setVisible(false);
        caixaSelecaoVR.setVisible(false);
        listener = new PagamentoActionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        painelDadosPedido = new javax.swing.JPanel();
        campoDesconto = new javax.swing.JTextField();
        campoDesconto.setActionCommand("Desconto");
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPedido = new javax.swing.JTable();
        textoConfiraDadosPedido = new javax.swing.JLabel();
        textoValorTotal = new javax.swing.JLabel();
        textoDesconto = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        painelFormasDePagamento = new javax.swing.JPanel();
        textoSelecioneFormaPagamento = new javax.swing.JLabel();
        botaoRadioDinheiro = new javax.swing.JRadioButton();
        botaoRadioCartaoCredito = new javax.swing.JRadioButton();
        botaoRadioValeRefeicao = new javax.swing.JRadioButton();
        botaoCartaoDebito = new javax.swing.JRadioButton();
        caixaSelecaoCC = new javax.swing.JComboBox(getFormasCredito());
        caixaSelecaoCD = new javax.swing.JComboBox(getFormasDebito());
        caixaSelecaoVR = new javax.swing.JComboBox(getFormasVale());
        textoIconeDinheiro = new javax.swing.JLabel();
        textoIconeCD = new javax.swing.JLabel();
        textoIconeCC = new javax.swing.JLabel();
        textoIconeVR = new javax.swing.JLabel();
        campoValorRecebido = new javax.swing.JTextField();
        textoValorRecebido = new javax.swing.JLabel();
        textoTroco = new javax.swing.JLabel();
        textoValorTroco = new javax.swing.JLabel();
        botaoConfirmarPedido = new javax.swing.JButton();
        botaoCancelarPedido = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        botaoRadioBalcao = new javax.swing.JRadioButton();
        botaoRadioMesa = new javax.swing.JRadioButton();
        botaoRadioViagem = new javax.swing.JRadioButton();
        campoMesa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirmação de Pedido");
        setAlwaysOnTop(true);
        setResizable(false);

        painelDadosPedido.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados do Pedido"));

        campoDesconto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoDesconto.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tabelaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição", "Valor Unitario", "Quantidade", "Valor Total"
            }
        ));
        jScrollPane1.setViewportView(tabelaPedido);
        if (tabelaPedido.getColumnModel().getColumnCount() > 0) {
            tabelaPedido.getColumnModel().getColumn(0).setMaxWidth(35);
            tabelaPedido.getColumnModel().getColumn(2).setMaxWidth(100);
            tabelaPedido.getColumnModel().getColumn(3).setMaxWidth(75);
            tabelaPedido.getColumnModel().getColumn(4).setMaxWidth(75);
        }

        textoConfiraDadosPedido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoConfiraDadosPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoConfiraDadosPedido.setText("Confira abaixo os dados do pedido:");

        textoValorTotal.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        textoValorTotal.setText("VALOR TOTAL:");

        textoDesconto.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        textoDesconto.setText("DESCONTO:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout painelDadosPedidoLayout = new javax.swing.GroupLayout(painelDadosPedido);
        painelDadosPedido.setLayout(painelDadosPedidoLayout);
        painelDadosPedidoLayout.setHorizontalGroup(
            painelDadosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(textoConfiraDadosPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelDadosPedidoLayout.createSequentialGroup()
                        .addComponent(textoDesconto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1)
                        .addGap(18, 18, 18)
                        .addComponent(textoValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelDadosPedidoLayout.setVerticalGroup(
            painelDadosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosPedidoLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(textoConfiraDadosPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textoValorTotal)
                    .addComponent(textoDesconto)
                    .addGroup(painelDadosPedidoLayout.createSequentialGroup()
                        .addComponent(campoDesconto)
                        .addGap(2, 2, 2))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );

        painelFormasDePagamento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Formas de Pagamento"));

        textoSelecioneFormaPagamento.setText("Selecione a forma de pagamento utilizada:");

        buttonGroup1.add(botaoRadioDinheiro);
        botaoRadioDinheiro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botaoRadioDinheiro.setText("Dinheiro");

        buttonGroup1.add(botaoRadioCartaoCredito);
        botaoRadioCartaoCredito.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botaoRadioCartaoCredito.setText("Cartão de Crédito");

        buttonGroup1.add(botaoRadioValeRefeicao);
        botaoRadioValeRefeicao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botaoRadioValeRefeicao.setText("Vale Refeição");

        buttonGroup1.add(botaoCartaoDebito);
        botaoCartaoDebito.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botaoCartaoDebito.setText("Cartão de Débito");

        textoIconeDinheiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/banknotes-26.png"))); // NOI18N

        textoIconeCD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/bank_cards-26.png"))); // NOI18N

        textoIconeCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/mastercard-26.png"))); // NOI18N

        textoIconeVR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/barcode-26.png"))); // NOI18N

        textoValorRecebido.setText("Valor Recebido:");

        textoTroco.setText("Troco:");

        textoValorTroco.setText("R$ 0,00");

        javax.swing.GroupLayout painelFormasDePagamentoLayout = new javax.swing.GroupLayout(painelFormasDePagamento);
        painelFormasDePagamento.setLayout(painelFormasDePagamentoLayout);
        painelFormasDePagamentoLayout.setHorizontalGroup(
            painelFormasDePagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormasDePagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFormasDePagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoSelecioneFormaPagamento)
                    .addGroup(painelFormasDePagamentoLayout.createSequentialGroup()
                        .addGroup(painelFormasDePagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelFormasDePagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(botaoRadioDinheiro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textoValorRecebido))
                            .addComponent(textoTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelFormasDePagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelFormasDePagamentoLayout.createSequentialGroup()
                                .addGroup(painelFormasDePagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoIconeDinheiro)
                                    .addComponent(campoValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(painelFormasDePagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(caixaSelecaoCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(painelFormasDePagamentoLayout.createSequentialGroup()
                                        .addComponent(botaoRadioCartaoCredito)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textoIconeCC)))
                                .addGap(18, 18, 18)
                                .addGroup(painelFormasDePagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(caixaSelecaoCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(painelFormasDePagamentoLayout.createSequentialGroup()
                                        .addComponent(botaoCartaoDebito)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textoIconeCD)))
                                .addGap(18, 18, 18)
                                .addGroup(painelFormasDePagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(caixaSelecaoVR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(painelFormasDePagamentoLayout.createSequentialGroup()
                                        .addComponent(botaoRadioValeRefeicao)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textoIconeVR))))
                            .addComponent(textoValorTroco))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelFormasDePagamentoLayout.setVerticalGroup(
            painelFormasDePagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFormasDePagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoSelecioneFormaPagamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelFormasDePagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelFormasDePagamentoLayout.createSequentialGroup()
                        .addComponent(botaoRadioCartaoCredito)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(caixaSelecaoCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormasDePagamentoLayout.createSequentialGroup()
                        .addGroup(painelFormasDePagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoCartaoDebito)
                            .addComponent(textoIconeCC))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(caixaSelecaoCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormasDePagamentoLayout.createSequentialGroup()
                        .addGroup(painelFormasDePagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoIconeVR)
                            .addComponent(botaoRadioValeRefeicao)
                            .addComponent(textoIconeCD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(caixaSelecaoVR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFormasDePagamentoLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(botaoRadioDinheiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoValorRecebido))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFormasDePagamentoLayout.createSequentialGroup()
                        .addComponent(textoIconeDinheiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFormasDePagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoTroco)
                    .addComponent(textoValorTroco))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoConfirmarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/ok-32.png"))); // NOI18N
        botaoConfirmarPedido.setText("Confirmar Pedido");

        botaoCancelarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/cancel-32.png"))); // NOI18N
        botaoCancelarPedido.setText("Cancelar Pedido");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Forma de Consumo"));

        buttonGroup2.add(botaoRadioBalcao);
        botaoRadioBalcao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botaoRadioBalcao.setText("Balcão");

        buttonGroup2.add(botaoRadioMesa);
        botaoRadioMesa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botaoRadioMesa.setText("Mesa");

        buttonGroup2.add(botaoRadioViagem);
        botaoRadioViagem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botaoRadioViagem.setText("Viagem");

        campoMesa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        campoMesa.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoRadioBalcao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(65, 65, 65)
                .addComponent(botaoRadioMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(botaoRadioViagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoRadioBalcao)
                    .addComponent(botaoRadioMesa)
                    .addComponent(botaoRadioViagem)
                    .addComponent(campoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelDadosPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelFormasDePagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoCancelarPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoConfirmarPedido)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoCancelarPedido)
                            .addComponent(botaoConfirmarPedido)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelDadosPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelFormasDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public JLabel getTextoValorTotal() {
        return textoValorTotal;
    }

    public void setTextoValorTotal(JLabel textoValorTotal) {
        this.textoValorTotal = textoValorTotal;
    }

    public Integer getIndexCaixa() {
        return indexCaixa;
    }

    public void setIndexCaixa(Integer indexCaixa) {
        this.indexCaixa = indexCaixa;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public JButton getBotaoCancelarPedido() {
        return botaoCancelarPedido;
    }

    public void setBotaoCancelarPedido(JButton botaoCancelarPedido) {
        this.botaoCancelarPedido = botaoCancelarPedido;
    }

    public JRadioButton getBotaoCartaoDebito() {
        return botaoCartaoDebito;
    }

    public void setBotaoCartaoDebito(JRadioButton botaoCartaoDebito) {
        this.botaoCartaoDebito = botaoCartaoDebito;
    }

    public JButton getBotaoConfirmarPedido() {
        return botaoConfirmarPedido;
    }

    public void setBotaoConfirmarPedido(JButton botaoConfirmarPedido) {
        this.botaoConfirmarPedido = botaoConfirmarPedido;
    }

    public JRadioButton getBotaoRadioCartaoCredito() {
        return botaoRadioCartaoCredito;
    }

    public void setBotaoRadioCartaoCredito(JRadioButton botaoRadioCartaoCredito) {
        this.botaoRadioCartaoCredito = botaoRadioCartaoCredito;
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

    public JTextField getCampoDesconto() {
        return campoDesconto;
    }

    public void setCampoDesconto(JTextField campoDesconto) {
        this.campoDesconto = campoDesconto;
    }

    public JTable getTabelaPedido() {
        return tabelaPedido;
    }

    public void setTabelaPedido(JTable tabelaPedido) {
        this.tabelaPedido = tabelaPedido;
    }

    public static boolean isCadastrou() {
        return pagou;
    }

    public static void setCadastrou(boolean cadastrou) {
        TelaConfirmacaoPagamento.pagou = cadastrou;
    }

    public static Caixa getCaixa() {
        return caixa;
    }

    public static void setCaixa(Caixa caixa) {
        TelaConfirmacaoPagamento.caixa = caixa;
    }

    public JRadioButton getBotaoRadioBalcao() {
        return botaoRadioBalcao;
    }

    public void setBotaoRadioBalcao(JRadioButton botaoRadioBalcao) {
        this.botaoRadioBalcao = botaoRadioBalcao;
    }

    public JRadioButton getBotaoRadioMesa() {
        return botaoRadioMesa;
    }

    public void setBotaoRadioMesa(JRadioButton botaoRadioMesa) {
        this.botaoRadioMesa = botaoRadioMesa;
    }

    public JRadioButton getBotaoRadioViagem() {
        return botaoRadioViagem;
    }

    public void setBotaoRadioViagem(JRadioButton botaoRadioViagem) {
        this.botaoRadioViagem = botaoRadioViagem;
    }

    public JTextField getCampoMesa() {
        return campoMesa;
    }

    public void setCampoMesa(JTextField campoMesa) {
        this.campoMesa = campoMesa;
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
                if ("Debito".equals(listaResFormasPagamento.get(i).getTipoFormaPgto()) && listaResFormasPagamento.get(i).getEstaAtivo() == ((byte)1)) {
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
                if ("Credito".equals(listaResFormasPagamento.get(i).getTipoFormaPgto()) && listaResFormasPagamento.get(i).getEstaAtivo() == ((byte)1)){
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
                if ("Vale".equals(listaResFormasPagamento.get(i).getTipoFormaPgto()) && listaResFormasPagamento.get(i).getEstaAtivo() == ((byte)1)) {
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
    private javax.swing.JButton botaoCancelarPedido;
    private javax.swing.JRadioButton botaoCartaoDebito;
    private javax.swing.JButton botaoConfirmarPedido;
    private javax.swing.JRadioButton botaoRadioBalcao;
    private javax.swing.JRadioButton botaoRadioCartaoCredito;
    private javax.swing.JRadioButton botaoRadioDinheiro;
    private javax.swing.JRadioButton botaoRadioMesa;
    private javax.swing.JRadioButton botaoRadioValeRefeicao;
    private javax.swing.JRadioButton botaoRadioViagem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox caixaSelecaoCC;
    private javax.swing.JComboBox caixaSelecaoCD;
    private javax.swing.JComboBox caixaSelecaoVR;
    private javax.swing.JTextField campoDesconto;
    private javax.swing.JTextField campoMesa;
    private javax.swing.JTextField campoValorRecebido;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel painelDadosPedido;
    private javax.swing.JPanel painelFormasDePagamento;
    private javax.swing.JTable tabelaPedido;
    private javax.swing.JLabel textoConfiraDadosPedido;
    private javax.swing.JLabel textoDesconto;
    private javax.swing.JLabel textoIconeCC;
    private javax.swing.JLabel textoIconeCD;
    private javax.swing.JLabel textoIconeDinheiro;
    private javax.swing.JLabel textoIconeVR;
    private javax.swing.JLabel textoSelecioneFormaPagamento;
    private javax.swing.JLabel textoTroco;
    private javax.swing.JLabel textoValorRecebido;
    private javax.swing.JLabel textoValorTotal;
    private javax.swing.JLabel textoValorTroco;
    // End of variables declaration//GEN-END:variables
}
