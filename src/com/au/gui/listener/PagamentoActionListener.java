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
import com.au.util.CustomComboBoxInt;
import com.au.util.Imprime;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Time;
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
    private double valorTotal = 0;

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
        tableModelVenda = new VendaTableModel(frm.getPedido().getItempedidos());
        frm.getTabelaPedido().setModel(tableModelVenda);
        frm.getTabelaPedido().getSelectionModel().addListSelectionListener(this);
        frm.getTabelaPedido().getColumnModel().getColumn(0).setMaxWidth(55);
        frm.getTabelaPedido().getColumnModel().getColumn(2).setMaxWidth(100);
        frm.getTabelaPedido().getColumnModel().getColumn(3).setMaxWidth(55);
        frm.getTabelaPedido().getColumnModel().getColumn(4).setMaxWidth(75);
    }

    public void adicionaListener() {

        frm.getBotaoCancelarPedido().addActionListener(this);
        frm.getBotaoCartaoDebito().addActionListener(this);
        frm.getBotaoCartaoDebito().addKeyListener(this);
        frm.getBotaoConfirmarPedido().addActionListener(this);
        frm.getBotaoRadioCartaoCredito().addActionListener(this);
        frm.getBotaoRadioCartaoCredito().addKeyListener(this);
        frm.getBotaoRadioDinheiro().addActionListener(this);
        frm.getBotaoRadioDinheiro().addKeyListener(this);
        frm.getBotaoRadioValeRefeicao().addActionListener(this);
        frm.getBotaoRadioValeRefeicao().addKeyListener(this);
        frm.getCampoDesconto().addKeyListener(this);
        frm.getCampoDesconto().addActionListener(this);
        frm.getBotaoRadioBalcao().addActionListener(this);
        frm.getBotaoRadioBalcao().addKeyListener(this);
        frm.getBotaoRadioMesa().addActionListener(this);
        frm.getBotaoRadioMesa().addKeyListener(this);
        frm.getBotaoRadioViagem().addActionListener(this);
        frm.getBotaoRadioViagem().addKeyListener(this);
        frm.getCampoValorRecebido().addKeyListener(this);
        frm.getCampoValorRecebidoVR().addKeyListener(this);
        frm.getCaixaSelecaoCC().addKeyListener(this);
        frm.getCaixaSelecaoCD().addKeyListener(this);
        frm.getCaixaSelecaoVR().addKeyListener(this);
        frm.getCampoMesa().addKeyListener(this);
    }

    private void atualizaTotal() {
        if ("".equals(frm.getCampoDesconto().getText())) {
            frm.setTotal(frm.getSubTotal());
            frm.getTextoValorTotal().setText(String.format("Valor Total: %.2f", frm.getTotal()));
            frm.getPedido().setSubTotPedido(frm.getTotal());
            frm.getPedido().setTotPedido(frm.getTotal());
        } else if (Double.valueOf(frm.getCampoDesconto().getText()) > frm.getSubTotal()) {
            JOptionPane.showMessageDialog(frm, "O valor do desconto não deve ultrapassar o valor do pedido.", "Desconto de Pedido", JOptionPane.WARNING_MESSAGE);
            frm.getCampoDesconto().setText("");
            atualizaTotal();
        } else {
            frm.setTotal(frm.getSubTotal() - Double.valueOf(frm.getCampoDesconto().getText()));
            frm.getTextoValorTotal().setText(String.format("Valor Total: %.2f", frm.getTotal()));
            frm.getPedido().setSubTotPedido(frm.getTotal());
            frm.getPedido().setTotPedido(frm.getTotal() - Double.valueOf(frm.getCampoDesconto().getText()));
        }
    }

    public void preencheValorRecebido() {
        frm.getCampoValorRecebido().setText(String.valueOf(frm.getPedido().getTotPedido())); //Necessario acertar troco E Desconto
        frm.getCampoValorRecebido().selectAll(); // Seleciona o texto, para caso seja necessário inserir um novo valor não seja necessário ficar dando backspace
    }
    
    public void preencheValorRecebidoVR() {
        frm.getCampoValorRecebidoVR().setText(String.valueOf(frm.getPedido().getTotPedido())); //Preenche o campo de valor recebido do Vale
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

        if (frm.getBotaoRadioDinheiro().isSelected()) { //Preenche o valor recebido no caso de dinheiro
            frm.getPedido().setValorRecebido(Double.valueOf(frm.getCampoValorRecebido().getText()));
        } else if (frm.getBotaoRadioValeRefeicao().isSelected()) { //Preenche o valor recebido no caso de vale
            frm.getPedido().setValorRecebido(Double.valueOf(frm.getCampoValorRecebidoVR().getText()));
        } else {
            frm.getPedido().setValorRecebido(frm.getTotal());
        }

        TelaConfirmacaoPagamento.setCaixa(frm.getFuncionario().getCaixas().get(frm.getIndexCaixa()));
        new DAO<>(Pedido.class).adiciona(frm.getPedido());
        //TelaConfirmacaoPagamento.getCaixa().setTotalCaixa(TelaConfirmacaoPagamento.getCaixa().getTotalCaixa() + frm.getPedido().getTotPedido());
        new DAO<>(Caixa.class).atualiza(TelaConfirmacaoPagamento.getCaixa());

        if (frm.getPedido().getItempedidos() != null) {
            for (int i = 0; frm.getPedido().getItempedidos().size() > i; i++) {
                frm.getPedido().getItempedidos().get(i).setPedido(frm.getPedido());
                frm.getPedido().getItempedidos().get(i).getId().setIdPedido(frm.getPedido().getIdPedido());
                new DAO<>(Itempedido.class).adiciona(frm.getPedido().getItempedidos().get(i));
            }
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
        frm.getCampoValorRecebido().setBorder(normal);
        frm.getCampoValorRecebidoVR().setBorder(normal);
    }

    public void limpaBordaConsumo() {
        frm.getBotaoRadioBalcao().setBorderPainted(false);
        frm.getBotaoRadioMesa().setBorderPainted(false);
        frm.getBotaoRadioViagem().setBorderPainted(false);
        frm.getCampoMesa().setBorder(normal);
    }

    public void habilitaDinheiro() {
        limpaBordaPagamento();
        frm.getCampoValorRecebido().setText("");
        frm.getTextoValorRecebido().setVisible(true);
        frm.getCampoValorRecebido().setVisible(true);
        frm.getCampoValorRecebidoVR().setText("");
        frm.getCampoValorRecebidoVR().setVisible(false);
        frm.getTextoValorRecebidoVR().setVisible(false);
        frm.getCaixaSelecaoCC().setVisible(false);
        frm.getCaixaSelecaoCC().setSelectedIndex(-1);
        frm.getCaixaSelecaoCD().setVisible(false);
        frm.getCaixaSelecaoCD().setSelectedIndex(-1);
        frm.getCaixaSelecaoVR().setVisible(false);
        frm.getCaixaSelecaoVR().setSelectedIndex(-1);
    }

    public void habilitaCC() {
        limpaBordaPagamento();
        frm.getCampoValorRecebido().setText("");
        frm.getTextoValorRecebido().setVisible(false);
        frm.getCampoValorRecebido().setVisible(false);
        frm.getCampoValorRecebidoVR().setText("");
        frm.getTextoValorRecebidoVR().setVisible(false);
        frm.getCampoValorRecebidoVR().setVisible(false);
        frm.getCaixaSelecaoCC().setVisible(true);
        frm.getCaixaSelecaoCC().requestFocus();
        frm.getCaixaSelecaoCC().setSelectedIndex(-1);
        frm.getCaixaSelecaoCD().setVisible(false);
        frm.getCaixaSelecaoCD().setSelectedIndex(-1);
        frm.getCaixaSelecaoVR().setVisible(false);
        frm.getCaixaSelecaoVR().setSelectedIndex(-1);
    }

    public void habilitaCD() {
        limpaBordaPagamento();
        frm.getCampoValorRecebido().setText("");
        frm.getTextoValorRecebido().setVisible(false);
        frm.getCampoValorRecebido().setVisible(false);
        frm.getCampoValorRecebidoVR().setText("");
        frm.getTextoValorRecebidoVR().setVisible(false);
        frm.getCampoValorRecebidoVR().setVisible(false);
        frm.getCaixaSelecaoCC().setVisible(false);
        frm.getCaixaSelecaoCC().setSelectedIndex(-1);
        frm.getCaixaSelecaoCD().setVisible(true);
        frm.getCaixaSelecaoCD().requestFocus();
        frm.getCaixaSelecaoCD().setSelectedIndex(-1);
        frm.getCaixaSelecaoVR().setVisible(false);
        frm.getCaixaSelecaoVR().setSelectedIndex(-1);
    }

    public void habilitaVR() {
        limpaBordaPagamento();
        frm.getCampoValorRecebidoVR().setText("");
        frm.getTextoValorRecebidoVR().setVisible(true);
        frm.getCampoValorRecebidoVR().setVisible(true);
        frm.getCampoValorRecebido().setText("");
        frm.getTextoValorRecebido().setVisible(false);
        frm.getCampoValorRecebido().setVisible(false);
        frm.getCaixaSelecaoCC().setVisible(false);
        frm.getCaixaSelecaoCC().setSelectedIndex(-1);
        frm.getCaixaSelecaoCD().setVisible(false);
        frm.getCaixaSelecaoCD().setSelectedIndex(-1);
        frm.getCaixaSelecaoVR().setVisible(true);
        frm.getCaixaSelecaoVR().requestFocus();
        frm.getCaixaSelecaoVR().setSelectedIndex(-1);
    }

    public void habilitaMesa(boolean valida) {
        limpaBordaConsumo();
        frm.getCampoMesa().setEnabled(valida);
        frm.getCampoMesa().setText("");
    }

    public boolean valida() {
        boolean valida = true;
        if ("".equals(frm.getCampoDesconto().getText())) {
            frm.getCampoDesconto().setText("0");
            atualizaTotal();
        } else if (Double.valueOf(frm.getCampoDesconto().getText()) > frm.getSubTotal()) {
            JOptionPane.showMessageDialog(frm, "O valor do desconto não deve ultrapassar o valor do pedido.", "Desconto de Pedido", JOptionPane.WARNING_MESSAGE);
            frm.getCampoDesconto().setText("");
            atualizaTotal();
            valida = false;
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
        if (frm.getBotaoRadioDinheiro().isSelected()) {
            if (frm.getCampoValorRecebido().getText().equals("")) {
                valida = false;
                frm.getCampoValorRecebido().setBorder(vermelha);
            } else {
                if (Double.valueOf(frm.getCampoValorRecebido().getText()) < frm.getTotal()) {
                    JOptionPane.showMessageDialog(frm, "O valor recebido não pode ser inferior ao total do pedido.", "Valor Recebido", JOptionPane.WARNING_MESSAGE);
                    frm.getCampoValorRecebido().setText("");
                    atualizaTotal();
                    valida = false;
                }
                frm.getCampoValorRecebido().setBorder(normal);
            }
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
                if (frm.getCampoValorRecebidoVR().getText().equals("")) {
                    frm.getCampoValorRecebidoVR().setBorder(vermelha);
                }
            } else if (frm.getCampoValorRecebidoVR().getText().equals("")) {
                valida = false;
                frm.getCampoValorRecebidoVR().setBorder(vermelha);
            } else {
                if (Double.valueOf(frm.getCampoValorRecebidoVR().getText()) < frm.getTotal()) {
                    JOptionPane.showMessageDialog(frm, "O valor recebido não pode ser inferior ao total do pedido.", "Valor Recebido", JOptionPane.WARNING_MESSAGE);
                    frm.getCampoValorRecebidoVR().setText("");
                    atualizaTotal();
                    valida = false;
                }
                frm.getCampoValorRecebidoVR().setBorder(normal);
                frm.getCaixaSelecaoVR().setBorder(normal);
            }
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
                    if (frm.getPedido().getFormaPagamento().getIdFormaPgto() == 1 || frm.getPedido().getFormaPagamento().getTipoFormaPgto().equals("Vale")) {
                        JOptionPane.showMessageDialog(frm, String.format("Valor Recebido: R$ %.2f", frm.getPedido().getValorRecebido()) + String.format("\n<html><font color=red><b>Troco: R$ %.2f", frm.getPedido().getValorRecebido() - frm.getPedido().getTotPedido()), "Troco", JOptionPane.INFORMATION_MESSAGE);
                    }
                    //new Imprime().geraComandaCozinha(frm.getPedido().getIdPedido());
                    try {
                        new Imprime().geraComandaVenda(frm.getPedido().getIdPedido());
                    } catch (UnsatisfiedLinkError | NoClassDefFoundError e) {
                        JOptionPane.showMessageDialog(frm, "Erro ao imprimir o Cupom.\nVerifique a impressora e tente novamente.", "Erro ao Imprimir o Cupom", JOptionPane.ERROR_MESSAGE);
                    }
                    TelaConfirmacaoPagamento.setCadastrou(true);
                    frm.dispose();
                }
                break;
            case "Dinheiro":
                habilitaDinheiro();
                frm.getCampoValorRecebido().requestFocus();
                preencheValorRecebido();
                //frm.getBotaoConfirmarPedido().requestFocus();
                break;
            case "Cartão de Crédito":
                habilitaCC();
                break;
            case "Cartão de Débito":
                habilitaCD();
                break;
            case "Vale Refeição":
                habilitaVR();
                preencheValorRecebidoVR();
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
                preencheValorRecebido();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (frm.getBotaoRadioDinheiro().isFocusOwner()) {
                frm.getBotaoRadioDinheiro().doClick();
            } else if (frm.getBotaoRadioCartaoCredito().isFocusOwner()) {
                frm.getBotaoRadioCartaoCredito().doClick();
                frm.getCaixaSelecaoCC().requestFocus();
            } else if (frm.getBotaoCartaoDebito().isFocusOwner()) {
                frm.getBotaoCartaoDebito().doClick();
                frm.getCaixaSelecaoCD().requestFocus();
            } else if (frm.getBotaoRadioValeRefeicao().isFocusOwner()) {
                frm.getBotaoRadioValeRefeicao().doClick();
                frm.getCaixaSelecaoVR().requestFocus();
            }

            if (frm.getBotaoRadioBalcao().isFocusOwner()) {
                frm.getBotaoRadioBalcao().doClick();
                frm.getBotaoConfirmarPedido().requestFocus();
            } else if (frm.getBotaoRadioMesa().isFocusOwner()) {
                frm.getBotaoRadioMesa().doClick();
                frm.getCampoMesa().requestFocus();
            } else if (frm.getBotaoRadioViagem().isFocusOwner()) {
                frm.getBotaoRadioViagem().doClick();
                frm.getBotaoConfirmarPedido().requestFocus();
            }

            if (frm.getCaixaSelecaoCC().isFocusOwner() || frm.getCaixaSelecaoCD().isFocusOwner()) {
                frm.getBotaoRadioBalcao().requestFocus();
            }
            
            if (frm.getCaixaSelecaoVR().isFocusOwner()) {
                frm.getCampoValorRecebidoVR().requestFocus();
                frm.getCampoValorRecebidoVR().selectAll();;
            }
            
            if (frm.getCampoValorRecebido().isFocusOwner() || frm.getCampoValorRecebidoVR().isFocusOwner()) {
                frm.getBotaoRadioBalcao().requestFocus();
            }
            
            if (frm.getCampoMesa().isFocusOwner()) {
                frm.getBotaoConfirmarPedido().requestFocus();
            }
            
        } else if (e.getKeyCode() == KeyEvent.VK_C) {
            frm.getBotaoRadioCartaoCredito().doClick();
            frm.getCaixaSelecaoCC().requestFocus();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            frm.getBotaoCartaoDebito().doClick();
            frm.getCaixaSelecaoCD().requestFocus();
        } else if (e.getKeyCode() == KeyEvent.VK_R) {
            frm.getBotaoRadioValeRefeicao().doClick();
            frm.getCaixaSelecaoVR().requestFocus();
        } else if (e.getKeyCode() == KeyEvent.VK_M) {
            frm.getBotaoRadioMesa().doClick();
            frm.getCampoMesa().requestFocus();
        } else if (e.getKeyCode() == KeyEvent.VK_V) {
            frm.getBotaoRadioViagem().doClick();
            frm.getBotaoConfirmarPedido().requestFocus();
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            frm.dispose();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (frm.getBotaoCartaoDebito().isFocusOwner()) {
                frm.getBotaoRadioCartaoCredito().requestFocus();
            } else if (frm.getBotaoRadioViagem().isFocusOwner()) {
                frm.getBotaoRadioMesa().requestFocus();
            } else if (frm.getBotaoRadioValeRefeicao().isFocusOwner()) {
                frm.getBotaoCartaoDebito().requestFocus();
            } else if (frm.getBotaoRadioMesa().isFocusOwner()) {
                frm.getBotaoRadioBalcao().requestFocus();
            } else if (frm.getBotaoRadioCartaoCredito().isFocusOwner()) {
                frm.getBotaoRadioDinheiro().requestFocus();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (frm.getBotaoCartaoDebito().isFocusOwner()) {
                frm.getBotaoRadioValeRefeicao().requestFocus();
            } else if (frm.getBotaoRadioMesa().isFocusOwner()) {
                frm.getBotaoRadioViagem().requestFocus();
            } else if (frm.getBotaoRadioDinheiro().isFocusOwner()) {
                frm.getBotaoRadioCartaoCredito().requestFocus();
            } else if (frm.getBotaoRadioCartaoCredito().isFocusOwner()) {
                frm.getBotaoCartaoDebito().requestFocus();
            } else if (frm.getBotaoRadioBalcao().isFocusOwner()) {
                frm.getBotaoRadioMesa().requestFocus();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        atualizaTotal();
    }
}
