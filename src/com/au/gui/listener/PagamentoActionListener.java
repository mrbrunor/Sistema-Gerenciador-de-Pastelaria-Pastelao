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
package com.au.gui.listener;

import com.au.gui.TelaConfirmacaoPagamento;
import com.au.gui.tmodel.VendaTableModel;
import com.au.modelo.Caixa;
import com.au.modelo.Pedido;
import com.au.util.Bematech;
import com.au.util.DAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author BrunoRicardo
 */
public class PagamentoActionListener implements ActionListener, ListSelectionListener {

    private final TelaConfirmacaoPagamento frm;
    private VendaTableModel tableModelVenda;
    private Border vermelha = new MatteBorder(1, 1, 1, 1, Color.red);
    private Border normal;

    public PagamentoActionListener(TelaConfirmacaoPagamento frm) {
        this.frm = frm;
        normal = frm.getCampoDesconto().getBorder();
        adicionaListener();
        inicializaTableModel();
        frm.getTextoValorTotal().setText("Valor Total: " + String.valueOf(frm.getSubTotal()));
        System.out.println(frm.getPedido().getItempedidos().size());
        System.out.println(frm.getFuncionario().getNomeFunc());
        System.out.println(frm.getIndexCaixa());
    }

    public void inicializaTableModel() {
        atualizaTableModelVenda();
    }

    public void atualizaTableModelVenda() {
        if (!frm.getPedido().getItempedidos().isEmpty()) {
            tableModelVenda = new VendaTableModel(frm.getPedido().getItempedidos());
            frm.getTabelaPedido().setModel(tableModelVenda);
            frm.getTabelaPedido().getSelectionModel().addListSelectionListener(this);
        }
    }

    public void adicionaListener() {

        frm.getBotaoCancelarPedido().addActionListener(this);
        frm.getBotaoCartaoDebito().addActionListener(this);
        frm.getBotaoConfirmarPedido().addActionListener(this);
        frm.getBotaoRadioCartaoCredito().addActionListener(this);
        frm.getBotaoRadioDinheiro().addActionListener(this);
        frm.getBotaoRadioValeRefeicao().addActionListener(this);
        frm.getCampoDesconto().addActionListener(this);
    }

    private void atualizaTotal() {
        frm.setTotal(frm.getSubTotal() - Double.valueOf(frm.getCampoDesconto().getText()));
        frm.getTextoValorTotal().setText("Valor Total: " + String.valueOf(frm.getTotal()));
    }

    private void criaPedido() {
        Date data = new Date();
        //SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");        
        //String dataStr = formatador.format(data);

        frm.getPedido().setCaixa(frm.getFuncionario().getCaixas().get(frm.getIndexCaixa()));
        frm.getPedido().setDataPedido(data);
        frm.getPedido().setDescPedido(Double.valueOf(frm.getCampoDesconto().getText()));
        frm.getPedido().setEstadoPedido("Finalizado");
        if (frm.getBotaoRadioDinheiro().isSelected()) {
            frm.getPedido().setFormaPagtoPedido("Dinheiro");
        } else if (frm.getBotaoRadioCartaoCredito().isSelected()) {
            frm.getPedido().setFormaPagtoPedido("Credito");
        } else if (frm.getBotaoCartaoDebito().isSelected()) {
            frm.getPedido().setFormaPagtoPedido("Debito");
        } else if (frm.getBotaoRadioValeRefeicao().isSelected()) {
            frm.getPedido().setFormaPagtoPedido("Vale");
        }
        frm.getPedido().setHoraPedido(new Time(data.getTime()));
        frm.getPedido().setSubTotPedido(frm.getSubTotal());
        frm.getPedido().setTotPedido(frm.getTotal());
        
        TelaConfirmacaoPagamento.setCaixa(frm.getFuncionario().getCaixas().get(frm.getIndexCaixa()));
        TelaConfirmacaoPagamento.getCaixa().addPedido(frm.getPedido());
        TelaConfirmacaoPagamento.getCaixa().setTotalCaixa(TelaConfirmacaoPagamento.getCaixa().getTotalCaixa() + frm.getPedido().getTotPedido());
        new DAO<>(Pedido.class).adiciona(frm.getPedido());
        new DAO<>(Caixa.class).atualiza(TelaConfirmacaoPagamento.getCaixa());
    }

    private void geraComanda() {

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataStr = formatador.format(frm.getPedido().getDataPedido());

        Bematech bematech = new Bematech();
        bematech.detectaImpressoras("MP-4000 TH");

        bematech.imprime("P A S T E L A O");
        bematech.imprime("");
        bematech.imprime(dataStr + "                  " + frm.getPedido().getHoraPedido());
        bematech.imprime("AGUARDE PELO NUMERO:     " + frm.getPedido().getNumPedido());
        bematech.imprime("Codigo QT Descricao            Unit         Total");
        bematech.imprime("");

        for (int i = 0; frm.getPedido().getItempedidos().size() > i; i++) {
            bematech.imprime(frm.getPedido().getItempedidos().get(i).getProduto().getIdProd() + "       x  " + frm.getPedido().getItempedidos().get(i).getQtdProd() + "            " + frm.getPedido().getItempedidos().get(i).getProduto().getValorProd() + "         " + frm.getPedido().getItempedidos().get(i).getTotProd());
            bematech.imprime(frm.getPedido().getItempedidos().get(i).getProduto().getDescProd());
        }

        bematech.imprime("");
        bematech.imprime("");
        bematech.imprime("");
        bematech.imprime("                       TOTAL.........." + frm.getPedido().getTotPedido());
        bematech.imprime("");
        bematech.imprime("");
        bematech.imprime("");
        bematech.imprime("");
        bematech.imprime("");
        bematech.imprime("");
        bematech.imprime("");
        bematech.imprime("");
    }

    public void limpaBorda() {
        frm.getBotaoCartaoDebito().setBorderPainted(false);
        frm.getBotaoRadioCartaoCredito().setBorderPainted(false);
        frm.getBotaoRadioDinheiro().setBorderPainted(false);
        frm.getBotaoRadioValeRefeicao().setBorderPainted(false);
        frm.getCaixaSelecaoCC().setBorder(normal);
        frm.getCaixaSelecaoCD().setBorder(normal);
        frm.getCaixaSelecaoVR().setBorder(normal);
    }

    public void habilitaDinheiro() {
        limpaBorda();
        frm.getCaixaSelecaoCC().setVisible(false);
        frm.getCaixaSelecaoCC().setSelectedIndex(0);
        frm.getCaixaSelecaoCD().setVisible(false);
        frm.getCaixaSelecaoCD().setSelectedIndex(0);
        frm.getCaixaSelecaoVR().setVisible(false);
        frm.getCaixaSelecaoVR().setSelectedIndex(0);
    }

    public void habilitaCC() {
        limpaBorda();
        frm.getCaixaSelecaoCC().setVisible(true);
        frm.getCaixaSelecaoCC().setSelectedIndex(0);
        frm.getCaixaSelecaoCD().setVisible(false);
        frm.getCaixaSelecaoCD().setSelectedIndex(0);
        frm.getCaixaSelecaoVR().setVisible(false);
        frm.getCaixaSelecaoVR().setSelectedIndex(0);
    }

    public void habilitaCD() {
        limpaBorda();
        frm.getCaixaSelecaoCC().setVisible(false);
        frm.getCaixaSelecaoCC().setSelectedIndex(0);
        frm.getCaixaSelecaoCD().setVisible(true);
        frm.getCaixaSelecaoCD().setSelectedIndex(0);
        frm.getCaixaSelecaoVR().setVisible(false);
        frm.getCaixaSelecaoVR().setSelectedIndex(0);
    }

    public void habilitaVR() {
        limpaBorda();
        frm.getCaixaSelecaoCC().setVisible(false);
        frm.getCaixaSelecaoCC().setSelectedIndex(0);
        frm.getCaixaSelecaoCD().setVisible(false);
        frm.getCaixaSelecaoCD().setSelectedIndex(0);
        frm.getCaixaSelecaoVR().setVisible(true);
        frm.getCaixaSelecaoVR().setSelectedIndex(0);
    }

    public boolean valida() {
        boolean valida = true;
        if ("".equals(frm.getCampoDesconto().getText())) {
            frm.getCampoDesconto().setText("0");
            atualizaTotal();
        }

        if (frm.getBotaoRadioDinheiro().isSelected() || frm.getBotaoRadioCartaoCredito().isSelected() || frm.getBotaoCartaoDebito().isSelected() || frm.getBotaoRadioValeRefeicao().isSelected()) {
            limpaBorda();
        } else {
            valida = false;
            frm.getBotaoCartaoDebito().setBorder(vermelha);
            frm.getBotaoCartaoDebito().setBorderPainted(true);
            frm.getBotaoRadioCartaoCredito().setBorder(vermelha);
            frm.getBotaoRadioCartaoCredito().setBorderPainted(true);
            frm.getBotaoRadioDinheiro().setBorder(vermelha);
            frm.getBotaoRadioDinheiro().setBorderPainted(true);
            frm.getBotaoRadioValeRefeicao().setBorder(vermelha);
            frm.getBotaoRadioValeRefeicao().setBorderPainted(true);
        }
        if (frm.getBotaoRadioCartaoCredito().isSelected()) {
            if (frm.getCaixaSelecaoCC().getSelectedIndex() == 0) {
                valida = false;
                frm.getCaixaSelecaoCC().setBorder(vermelha);
            }
        } else {
            frm.getCaixaSelecaoCC().setBorder(normal);
        }
        if (frm.getBotaoCartaoDebito().isSelected()) {
            if (frm.getCaixaSelecaoCD().getSelectedIndex() == 0) {
                valida = false;
                frm.getCaixaSelecaoCD().setBorder(vermelha);
            }
        } else {
            frm.getCaixaSelecaoCD().setBorder(normal);
        }
        if (frm.getBotaoRadioValeRefeicao().isSelected()) {
            if (frm.getCaixaSelecaoVR().getSelectedIndex() == 0) {
                valida = false;
                frm.getCaixaSelecaoVR().setBorder(vermelha);
            }
        } else {
            frm.getCaixaSelecaoVR().setBorder(normal);
        }
        return valida;
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println(event);
        switch (event.getActionCommand()) {
            case "Desconto":
                atualizaTotal();
                break;
            case "Confirmar Pedido":
                if (valida()) {
                    criaPedido();
                    //geraComanda();
                    frm.dispose();
                }
                break;
            case "Dinheiro":
                habilitaDinheiro();
                break;
            case "Cartão de Crédito":
                habilitaCC();
                break;
            case "Cartão de Débito":
                habilitaCD();
                break;
            case "Vale Refeição":
                habilitaVR();
                break;
            case "Cancelar Pedido":
                frm.setCadastrou(false);
                frm.dispose();
                break;
        }
    }
}
