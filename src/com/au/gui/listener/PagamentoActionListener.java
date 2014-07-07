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

import com.au.dao.DAO;
import com.au.gui.TelaConfirmacaoPagamento;
import com.au.gui.tmodel.VendaTableModel;
import com.au.modelo.Caixa;
import com.au.modelo.FormaPagamento;
import com.au.modelo.Itempedido;
import com.au.modelo.Pedido;
import com.au.util.Bematech;
import com.au.util.BematechComandosDiretos;
import com.au.util.BematechNFiscal;
import com.au.util.CustomComboBoxInt;
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
        frm.getBotaoRadioBalcao().addActionListener(this);
        frm.getBotaoRadioMesa().addActionListener(this);
        frm.getBotaoRadioViagem().addActionListener(this);
    }

    private void atualizaTotal() {
        if ("".equals(frm.getCampoDesconto().getText())) {
            frm.setTotal(frm.getSubTotal());
            frm.getTextoValorTotal().setText(String.format("Valor Total: %.2f", frm.getTotal()));
        } else {
            frm.setTotal(frm.getSubTotal() - Double.valueOf(frm.getCampoDesconto().getText()));
            frm.getTextoValorTotal().setText(String.format("Valor Total: %.2f", frm.getTotal()));
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

        if (frm.getBotaoRadioBalcao().isSelected()) {
            frm.getPedido().setFormaConsumo("Balcao");
        } else if (frm.getBotaoRadioMesa().isSelected()) {
            frm.getPedido().setFormaConsumo(String.format("Mesa %02d", Integer.valueOf(frm.getCampoMesa().getText())));
        } else if (frm.getBotaoRadioViagem().isSelected()) {
            frm.getPedido().setFormaConsumo("Viagem");
        }

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

    private void geraComandaVenda() {
        int iRetorno;
        String iComando;
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataStr = formatador.format(frm.getPedido().getDataPedido());

        BematechNFiscal cupom = BematechNFiscal.Instance;

        iRetorno = cupom.ConfiguraModeloImpressora(5);
        iRetorno = cupom.IniciaPorta("LPT1");
        iRetorno = cupom.PrintNVBitmap(1, 0);
        iRetorno = cupom.BematechTX("\n\n" + dataStr + "                    " + frm.getPedido().getHoraPedido() + "\r\n");
        iRetorno = cupom.BematechTX("AGUARDE PELO NUMERO:   " + BematechComandosDiretos.SO + BematechComandosDiretos.NEGRITO_ON + String.format("%03d", frm.getPedido().getNumPedido()) + BematechComandosDiretos.NEGRITO_OFF + "\r\n");
        iRetorno = cupom.BematechTX("FORMA DE CONSUMO   :   " + BematechComandosDiretos.SO + BematechComandosDiretos.NEGRITO_ON + frm.getPedido().getFormaConsumo() + BematechComandosDiretos.NEGRITO_OFF + "\r\n");
        iRetorno = cupom.BematechTX("" + (char) 10);
        iRetorno = cupom.FormataTX("Codigo\t\t QTD\tUnit\t Total\r\nDescricao\r\n", 3, 0, 0, 0, 0);
        for (int i = 0; frm.getPedido().getItempedidos().size() > i; i++) {
            int valorUnitarioInt = (int) frm.getPedido().getItempedidos().get(i).getProduto().getValorProd();
            String valorUnitarioStr = Integer.toString(valorUnitarioInt);
            System.out.println(valorUnitarioStr);
            System.out.println(valorUnitarioStr.length());
            if (valorUnitarioStr.length() == 1) { //Valores com 1 dígito
                iRetorno = cupom.BematechTX(BematechComandosDiretos.SO + BematechComandosDiretos.NEGRITO_ON + String.format("%03d", frm.getPedido().getItempedidos().get(i).getProduto().getIdProd())
                        + BematechComandosDiretos.avanco(3) + "x " + String.format("%02d", frm.getPedido().getItempedidos().get(i).getQtdProd()) + BematechComandosDiretos.NEGRITO_OFF + BematechComandosDiretos.DC4 + BematechComandosDiretos.avanco(4)
                        + String.format("%.2f", frm.getPedido().getItempedidos().get(i).getProduto().getValorProd()) + BematechComandosDiretos.avanco(5)
                        + String.format("%.2f", frm.getPedido().getItempedidos().get(i).getTotProd()) + "\r\n");
                iRetorno = cupom.FormataTX(removeAcentos(frm.getPedido().getItempedidos().get(i).getProduto().getDescProd()) + "\r\n\n", 3, 0, 0, 0, 1);
            } else if (valorUnitarioStr.length() == 2) { //Valores com 2 dígitos
                iRetorno = cupom.BematechTX(BematechComandosDiretos.SO + BematechComandosDiretos.NEGRITO_ON + String.format("%03d", frm.getPedido().getItempedidos().get(i).getProduto().getIdProd())
                        + BematechComandosDiretos.avanco(3) + "x " + String.format("%02d", frm.getPedido().getItempedidos().get(i).getQtdProd()) + BematechComandosDiretos.NEGRITO_OFF + BematechComandosDiretos.DC4 + BematechComandosDiretos.avanco(4)
                        + String.format("%.2f", frm.getPedido().getItempedidos().get(i).getProduto().getValorProd()) + BematechComandosDiretos.avanco(4)
                        + String.format("%.2f", frm.getPedido().getItempedidos().get(i).getTotProd()) + "\r\n");
                iRetorno = cupom.FormataTX(removeAcentos(frm.getPedido().getItempedidos().get(i).getProduto().getDescProd()) + "\r\n", 3, 0, 0, 0, 1);
            }
        }
        iRetorno = cupom.FormataTX("\n\t\t" + BematechComandosDiretos.avanco(5) + "SUBTOTAL.......... " + String.format("%.2f", frm.getPedido().getSubTotPedido()) + "\r\n", 3, 0, 0, 0, 1);
        iRetorno = cupom.FormataTX("\t\t" + BematechComandosDiretos.avanco(5) + "DESCONTO.......... " + String.format("%.2f", frm.getPedido().getDescPedido()) + "\r\n", 3, 0, 0, 0, 1);
        iRetorno = cupom.FormataTX("\t\t" + BematechComandosDiretos.avanco(5) + "TOTAL............. " + String.format("%.2f", frm.getPedido().getTotPedido()) + "\r\n\n", 3, 0, 0, 0, 1);
        iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON);
        iRetorno = cupom.BematechTX("Forma de Pagamento: " + frm.getPedido().getFormaPagamento().getTipoFormaPgto() + "\r\n");
        iRetorno = cupom.BematechTX("\tValor Recebido ==> " + "\r\n");
        iRetorno = cupom.BematechTX("\tTroco          ==> " + "\r\n\n");
        iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_OFF);

        iRetorno = cupom.BematechTX(BematechComandosDiretos.alinhamento(1));
        iRetorno = cupom.FormataTX("ESTE CUPOM NAO TEM VALIDADE FISCAL\r\n", 3, 1, 0, 0, 0);
        iRetorno = cupom.FormataTX("Obrigado pela Preferencia, Volte Sempre!\r\n", 3, 1, 0, 0, 1);
        iRetorno = cupom.BematechTX(BematechComandosDiretos.alinhamento(0));
        iComando = "" + (char) 10;
        for (int i = 0; i < 9; i++) {
            iRetorno = cupom.ComandoTX(iComando, iComando.length());
        }
        iRetorno = cupom.FechaPorta();
        /*
         iRetorno = cupom.FormataTX("TEXTO ITÁLICO\r\n", 2, 1, 0, 0, 0);
         iRetorno = cupom.FormataTX("TEXTO NEGRITO\r\n", 2, 0, 0, 0, 1);
         iRetorno = cupom.FormataTX("TEXTO SUBLINHADO\r\n", 2, 0, 1, 0, 0);
         iRetorno = cupom.FormataTX("TEXTO CONDENSADO\r\n", 1, 0, 0, 0, 0);
         iRetorno = cupom.FormataTX("TEXTO ELITE\r\n", 3, 0, 0, 0, 0);
         iRetorno = cupom.FormataTX("TEXTO NORMAL\r\n", 2, 0, 0, 0, 0);*/
    }

    private void geraComandaVendaAntiga() {

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataStr = formatador.format(frm.getPedido().getDataPedido());
        Bematech bematech = new Bematech();
        bematech.detectaImpressoras("Caixa");
        if (Bematech.impressora != null) {

            bematech.imprime("P A S T E L A O \n\n"
                    + dataStr + "                    " + frm.getPedido().getHoraPedido()
                    + "\n\nAGUARDE PELO NUMERO:     " + frm.getPedido().getNumPedido()
                    + "\n\nCodigo\t\tQT\tUnit\tTotal");

            for (int i = 0; frm.getPedido().getItempedidos().size() > i; i++) {
                bematech.imprime("\n" + frm.getPedido().getItempedidos().get(i).getProduto().getIdProd() + "\tx\t" + frm.getPedido().getItempedidos().get(i).getQtdProd() + "\t" + String.format("%.2f", frm.getPedido().getItempedidos().get(i).getProduto().getValorProd()) + "\t" + String.format("%.2f", frm.getPedido().getItempedidos().get(i).getTotProd()));
                bematech.imprime(removeAcentos(frm.getPedido().getItempedidos().get(i).getProduto().getDescProd()));
            }

            bematech.imprime("\n\n\t\t\tSUBTOTAL.......... " + String.format("%.2f", frm.getPedido().getSubTotPedido()));
            bematech.imprime("\t\t\tDESCONTO.......... " + String.format("%.2f", frm.getPedido().getDescPedido()));
            bematech.imprime("\t\t\tTOTAL............. " + String.format("%.2f", frm.getPedido().getTotPedido()) + "\n\n");
            bematech.imprime("\tESTE CUPOM NAO TEM VALIDADE FISCAL\n");
            bematech.imprime("\tObrigado pela preferencia, volte sempre!");
            bematech.imprime("\n\n\n\n\n\n\n\n\n"); //espaço necessário para um cupom não sair "colado" com outro
            Bematech.impressora = null;
        } else {
            JOptionPane.showMessageDialog(frm, "Impressora Caixa não foi encontrada. O cupom não será impresso.", "Impressão de Cupom", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void geraComandaCozinha() {

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataStr = formatador.format(frm.getPedido().getDataPedido());
        Bematech bematech = new Bematech();
        bematech.detectaImpressoras("Cozinha");
        if (Bematech.impressora != null) {
            bematech.imprime("P A S T E L A O  \nV I A  D A  C O Z I N H A\n\n"
                    + dataStr + "                    " + frm.getPedido().getHoraPedido()
                    + "\n\nPEDIDO NUMERO:     " + frm.getPedido().getNumPedido()
                    + "\n\nCodigo\t\tQT");

            for (int i = 0; frm.getPedido().getItempedidos().size() > i; i++) {
                bematech.imprime("\n" + frm.getPedido().getItempedidos().get(i).getProduto().getIdProd() + "\tx\t" + frm.getPedido().getItempedidos().get(i).getQtdProd());
            }
            bematech.imprime("\n\n\n\n\n\n\n\n\n\n\n");
            Bematech.impressora = null;
        } else {
            JOptionPane.showMessageDialog(frm, "Impressora Cozinha não foi encontrada. O cupom não será impresso.", "Impressão de Cupom", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void limpaBordaPagamento() {
        frm.getBotaoCartaoDebito().setBorderPainted(false);
        frm.getBotaoRadioCartaoCredito().setBorderPainted(false);
        frm.getBotaoRadioDinheiro().setBorderPainted(false);
        frm.getBotaoRadioValeRefeicao().setBorderPainted(false);
        frm.getCaixaSelecaoCC().setBorder(normal);
        frm.getCaixaSelecaoCD().setBorder(normal);
        frm.getCaixaSelecaoVR().setBorder(normal);
    }

    public void limpaBordaConsumo() {
        frm.getBotaoRadioBalcao().setBorderPainted(false);
        frm.getBotaoRadioMesa().setBorderPainted(false);
        frm.getBotaoRadioViagem().setBorderPainted(false);
        frm.getCampoMesa().setBorder(normal);
    }

    public void habilitaDinheiro() {
        limpaBordaPagamento();
        frm.getCaixaSelecaoCC().setVisible(false);
        frm.getCaixaSelecaoCC().setSelectedIndex(-1);
        frm.getCaixaSelecaoCD().setVisible(false);
        frm.getCaixaSelecaoCD().setSelectedIndex(-1);
        frm.getCaixaSelecaoVR().setVisible(false);
        frm.getCaixaSelecaoVR().setSelectedIndex(-1);
    }

    public void habilitaCC() {
        limpaBordaPagamento();
        frm.getCaixaSelecaoCC().setVisible(true);
        frm.getCaixaSelecaoCC().setSelectedIndex(-1);
        frm.getCaixaSelecaoCD().setVisible(false);
        frm.getCaixaSelecaoCD().setSelectedIndex(-1);
        frm.getCaixaSelecaoVR().setVisible(false);
        frm.getCaixaSelecaoVR().setSelectedIndex(-1);
    }

    public void habilitaCD() {
        limpaBordaPagamento();
        frm.getCaixaSelecaoCC().setVisible(false);
        frm.getCaixaSelecaoCC().setSelectedIndex(-1);
        frm.getCaixaSelecaoCD().setVisible(true);
        frm.getCaixaSelecaoCD().setSelectedIndex(-1);
        frm.getCaixaSelecaoVR().setVisible(false);
        frm.getCaixaSelecaoVR().setSelectedIndex(-1);
    }

    public void habilitaVR() {
        limpaBordaPagamento();
        frm.getCaixaSelecaoCC().setVisible(false);
        frm.getCaixaSelecaoCC().setSelectedIndex(-1);
        frm.getCaixaSelecaoCD().setVisible(false);
        frm.getCaixaSelecaoCD().setSelectedIndex(-1);
        frm.getCaixaSelecaoVR().setVisible(true);
        frm.getCaixaSelecaoVR().setSelectedIndex(-1);
    }

    public void habilitaMesa(boolean valida) {
        limpaBordaConsumo();
        frm.getCampoMesa().setEnabled(valida);
        frm.getCampoMesa().setText("");
    }

    public boolean valida() {
        boolean valida = true;
        if (!"".equals(frm.getCampoDesconto().getText())) {
            System.out.println("Desc: " + Double.valueOf(frm.getCampoDesconto().getText()));
            System.out.println("Total: " + frm.getPedido().getSubTotPedido());

        }
        if ("".equals(frm.getCampoDesconto().getText())) {
            frm.getCampoDesconto().setText("0");
            atualizaTotal();
        } else if (Double.valueOf(frm.getCampoDesconto().getText()) > frm.getSubTotal()) {
            JOptionPane.showMessageDialog(frm, "O valor do desconto não deve ultrapassar o valor do pedido.", "Desconto de Pedido", JOptionPane.WARNING_MESSAGE);
            frm.getCampoDesconto().setText("");
            atualizaTotal();
        }

        if (frm.getBotaoRadioDinheiro().isSelected() || frm.getBotaoRadioCartaoCredito().isSelected() || frm.getBotaoCartaoDebito().isSelected() || frm.getBotaoRadioValeRefeicao().isSelected()) {
            limpaBordaPagamento();
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

        if (frm.getBotaoRadioBalcao().isSelected() || frm.getBotaoRadioMesa().isSelected() || frm.getBotaoRadioViagem().isSelected()) {
            limpaBordaConsumo();
        } else {
            valida = false;
            frm.getBotaoRadioBalcao().setBorder(vermelha);
            frm.getBotaoRadioBalcao().setBorderPainted(true);
            frm.getBotaoRadioMesa().setBorder(vermelha);
            frm.getBotaoRadioMesa().setBorderPainted(true);
            frm.getBotaoRadioViagem().setBorder(vermelha);
            frm.getBotaoRadioViagem().setBorderPainted(true);
        }

        if (frm.getBotaoRadioMesa().isSelected()) {
            if (frm.getCampoMesa().getText().equals("")) {
                valida = false;
                frm.getCampoMesa().setBorder(vermelha);
            }
        }
        return valida;
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Confirmar Pedido":
                if (valida()) {
                    criaPedido();
                    geraComandaVenda();
                    // geraComandaCozinha();
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
            case "Balcão":
                habilitaMesa(false);
                break;
            case "Mesa":
                habilitaMesa(true);
                break;
            case "Viagem":
                habilitaMesa(false);
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
