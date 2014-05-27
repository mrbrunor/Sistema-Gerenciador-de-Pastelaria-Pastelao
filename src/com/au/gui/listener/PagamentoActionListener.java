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
import com.au.modelo.FormaPagamento;
import com.au.modelo.Itempedido;
import com.au.modelo.Pedido;
import com.au.util.Bematech;
import com.au.util.CustomComboBoxInt;
import com.au.util.DAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Time;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author BrunoRicardo
 */
public class PagamentoActionListener implements ActionListener, ListSelectionListener, KeyListener {

    private final TelaConfirmacaoPagamento frm;
    private VendaTableModel tableModelVenda;
    private Border vermelha = new MatteBorder(1, 1, 1, 1, Color.red);
    private Border normal;

    public PagamentoActionListener(TelaConfirmacaoPagamento frm) {
        this.frm = frm;
        normal = frm.getCampoDesconto().getBorder();
        adicionaListener();
        inicializaTableModel();
        frm.getCampoDesconto().requestFocus();
        frm.getTextoValorTotal().setText(String.format("Valor Total: %.2f", frm.getSubTotal()));
        System.out.println("Qtd Pedidos= " + frm.getPedido().getItempedidos().size());
        System.out.println(frm.getFuncionario().getNomeFunc());
        System.out.println(frm.getIndexCaixa());
    }

    public void inicializaTableModel() {
        atualizaTableModelVenda();
    }

    public void atualizaTableModelVenda() {
        //if (!frm.getPedido().getItempedidos().isEmpty()) {
        tableModelVenda = new VendaTableModel(frm.getPedido().getItempedidos());
        frm.getTabelaPedido().setModel(tableModelVenda);
        frm.getTabelaPedido().getSelectionModel().addListSelectionListener(this);
        frm.getTabelaPedido().getColumnModel().getColumn(0).setMaxWidth(35);
        frm.getTabelaPedido().getColumnModel().getColumn(2).setMaxWidth(100);
        frm.getTabelaPedido().getColumnModel().getColumn(3).setMaxWidth(75);
        frm.getTabelaPedido().getColumnModel().getColumn(4).setMaxWidth(75);
        //}
    }

    public void adicionaListener() {

        frm.getBotaoCancelarPedido().addActionListener(this);
        frm.getBotaoCartaoDebito().addActionListener(this);
        frm.getBotaoConfirmarPedido().addActionListener(this);
        frm.getBotaoRadioCartaoCredito().addActionListener(this);
        frm.getBotaoRadioDinheiro().addActionListener(this);
        frm.getBotaoRadioValeRefeicao().addActionListener(this);
        frm.getCampoDesconto().addKeyListener(this);
        frm.getCampoDesconto().addActionListener(this);
    }

    private void atualizaTotal() {
        if ("".equals(frm.getCampoDesconto().getText())) {
            frm.setTotal(frm.getSubTotal());
            frm.getTextoValorTotal().setText("Valor Total: " + String.valueOf(frm.getTotal()));
        } else {
            frm.setTotal(frm.getSubTotal() - Double.valueOf(frm.getCampoDesconto().getText()));
            frm.getTextoValorTotal().setText("Valor Total: " + String.valueOf(frm.getTotal()));
        }
    }

    private void criaPedido() {
        Date data = new Date();
        frm.getPedido().setCaixa(frm.getFuncionario().getCaixas().get(frm.getIndexCaixa()));
        frm.getPedido().setDataPedido(data);
        frm.getPedido().setDescPedido(Double.valueOf(frm.getCampoDesconto().getText()));
        frm.getPedido().setEstadoPedido("Finalizado");
        if (frm.getBotaoRadioDinheiro().isSelected()) {
            frm.getPedido().setFormaPagamento(new DAO<>(FormaPagamento.class).buscaPorId(1));
        } else if (frm.getBotaoRadioCartaoCredito().isSelected()) {
            CustomComboBoxInt ob = (CustomComboBoxInt) frm.getCaixaSelecaoCC().getSelectedItem();
            frm.getPedido().setFormaPagamento((new DAO<>(FormaPagamento.class).buscaPorId(ob.getId())));
        } else if (frm.getBotaoCartaoDebito().isSelected()) {
            CustomComboBoxInt ob = (CustomComboBoxInt) frm.getCaixaSelecaoCD().getSelectedItem();
            frm.getPedido().setFormaPagamento((new DAO<>(FormaPagamento.class).buscaPorId(ob.getId())));
        } else if (frm.getBotaoRadioValeRefeicao().isSelected()) {
            CustomComboBoxInt ob = (CustomComboBoxInt) frm.getCaixaSelecaoVR().getSelectedItem();
            frm.getPedido().setFormaPagamento((new DAO<>(FormaPagamento.class).buscaPorId(ob.getId())));
        }

        frm.getPedido().setHoraPedido(new Time(data.getTime()));
        frm.getPedido().setSubTotPedido(frm.getSubTotal());
        frm.getPedido().setTotPedido(frm.getTotal());

        TelaConfirmacaoPagamento.setCaixa(frm.getFuncionario().getCaixas().get(frm.getIndexCaixa()));
        new DAO<>(Pedido.class).adiciona(frm.getPedido());
        TelaConfirmacaoPagamento.getCaixa().setTotalCaixa(TelaConfirmacaoPagamento.getCaixa().getTotalCaixa() + frm.getPedido().getTotPedido());
        new DAO<>(Caixa.class).atualiza(TelaConfirmacaoPagamento.getCaixa());

        if (frm.getPedido().getItempedidos() != null) {
            for (int i = 0; frm.getPedido().getItempedidos().size() > i; i++) {
                frm.getPedido().getItempedidos().get(i).setPedido(frm.getPedido());
                frm.getPedido().getItempedidos().get(i).getId().setIdPedido(frm.getPedido().getIdPedido());
                new DAO<>(Itempedido.class).adiciona(frm.getPedido().getItempedidos().get(i));
            }
        }
    }

    public String removeAcentos(String str) {
        str = Normalizer.normalize(str, Normalizer.Form.NFD);
        str = str.replaceAll("[^\\p{ASCII}]", "");
        return str;
    }

    private void geraComanda() {

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataStr = formatador.format(frm.getPedido().getDataPedido());
        Bematech bematech = new Bematech();
        bematech.detectaImpressoras("MP-4000 TH");
        if (Bematech.impressora != null){
            
        
        bematech.imprime("P A S T E L A O \n\n"
        
                        + dataStr + "                    " + frm.getPedido().getHoraPedido() +
                        "\n\nAGUARDE PELO NUMERO:     " + frm.getPedido().getNumPedido() +
                        "\n\nCodigo\t\tQT\tUnit\tTotal" );
        

        for (int i = 0; frm.getPedido().getItempedidos().size() > i; i++) {
            bematech.imprime("\n" + frm.getPedido().getItempedidos().get(i).getProduto().getIdProd() + "\tx\t" + frm.getPedido().getItempedidos().get(i).getQtdProd() + "\t" + frm.getPedido().getItempedidos().get(i).getProduto().getValorProd() + "\t" + frm.getPedido().getItempedidos().get(i).getTotProd());
            bematech.imprime(removeAcentos(frm.getPedido().getItempedidos().get(i).getProduto().getDescProd()));
        }
        
        bematech.imprime("\n\n\t\t\tTOTAL.......... " + frm.getPedido().getTotPedido() + "\n\n\n\n\n\n\n\n\n");
        } else {
            JOptionPane.showMessageDialog(frm, "Impressora MP-4000 TH não foi encontrada. Instale uma impressora padrão \r\n(Generic Text Only) e reinicie o programa.");
        }
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
        frm.getCaixaSelecaoCC().setSelectedIndex(-1);
        frm.getCaixaSelecaoCD().setVisible(false);
        frm.getCaixaSelecaoCD().setSelectedIndex(-1);
        frm.getCaixaSelecaoVR().setVisible(false);
        frm.getCaixaSelecaoVR().setSelectedIndex(-1);
    }

    public void habilitaCC() {
        limpaBorda();
        frm.getCaixaSelecaoCC().setVisible(true);
        frm.getCaixaSelecaoCC().setSelectedIndex(-1);
        frm.getCaixaSelecaoCD().setVisible(false);
        frm.getCaixaSelecaoCD().setSelectedIndex(-1);
        frm.getCaixaSelecaoVR().setVisible(false);
        frm.getCaixaSelecaoVR().setSelectedIndex(-1);
    }

    public void habilitaCD() {
        limpaBorda();
        frm.getCaixaSelecaoCC().setVisible(false);
        frm.getCaixaSelecaoCC().setSelectedIndex(-1);
        frm.getCaixaSelecaoCD().setVisible(true);
        frm.getCaixaSelecaoCD().setSelectedIndex(-1);
        frm.getCaixaSelecaoVR().setVisible(false);
        frm.getCaixaSelecaoVR().setSelectedIndex(-1);
    }

    public void habilitaVR() {
        limpaBorda();
        frm.getCaixaSelecaoCC().setVisible(false);
        frm.getCaixaSelecaoCC().setSelectedIndex(-1);
        frm.getCaixaSelecaoCD().setVisible(false);
        frm.getCaixaSelecaoCD().setSelectedIndex(-1);
        frm.getCaixaSelecaoVR().setVisible(true);
        frm.getCaixaSelecaoVR().setSelectedIndex(-1);
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
            if (frm.getCaixaSelecaoCC().getSelectedIndex() == -1) {
                valida = false;
                frm.getCaixaSelecaoCC().setBorder(vermelha);
            }
        } else {
            frm.getCaixaSelecaoCC().setBorder(normal);
        }
        if (frm.getBotaoCartaoDebito().isSelected()) {
            if (frm.getCaixaSelecaoCD().getSelectedIndex() == -1) {
                valida = false;
                frm.getCaixaSelecaoCD().setBorder(vermelha);
            }
        } else {
            frm.getCaixaSelecaoCD().setBorder(normal);
        }
        if (frm.getBotaoRadioValeRefeicao().isSelected()) {
            if (frm.getCaixaSelecaoVR().getSelectedIndex() == -1) {
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
            case "Confirmar Pedido":
                if (valida()) {
                    criaPedido();
                    geraComanda();
                    TelaConfirmacaoPagamento.setCadastrou(true);
                    frm.dispose();
                }
                break;
            case "Dinheiro":
                habilitaDinheiro();
                frm.getBotaoConfirmarPedido().requestFocus();
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
                TelaConfirmacaoPagamento.setCadastrou(false);
                frm.dispose();
                break;
            case "Desconto":
                frm.getBotaoRadioDinheiro().requestFocus();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        atualizaTotal();
    }
}
