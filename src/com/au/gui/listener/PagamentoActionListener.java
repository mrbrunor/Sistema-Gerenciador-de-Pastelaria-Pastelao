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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author BrunoRicardo
 */
public class PagamentoActionListener implements ActionListener, ListSelectionListener {

    private final TelaConfirmacaoPagamento frm;
    private VendaTableModel tableModelVenda;

    public PagamentoActionListener(TelaConfirmacaoPagamento frm) {
        this.frm = frm;
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

    @Override
    public void valueChanged(ListSelectionEvent event) {
        System.out.println(frm.getCampoDesconto().getText());
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println(event);
        switch (event.getActionCommand()) {
            case "Desconto":
                atualizaTotal();
                break;
        }
    }   
}
