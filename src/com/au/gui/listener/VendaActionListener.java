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

import com.au.gui.TelaVenda;
import com.au.gui.tmodel.VendaTableModel;
import com.au.modelo.Itempedido;
import com.au.modelo.Pedido;
import com.au.modelo.Produto;
import com.au.util.DAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author BrunoRicardo
 */
public class VendaActionListener implements ActionListener, ListSelectionListener {

    private final TelaVenda frm;
    private VendaTableModel tableModelVenda;
    private Pedido pedido = new Pedido();
    private double totalPedido=0;
    
    public VendaActionListener(TelaVenda frm) {
        this.frm = frm;
        adicionaListener();
        inicializaTableModel();
    }

    public void inicializaTableModel() {
        atualizaTableModelVenda();
    }

    public void atualizaTableModelVenda() {
        if (!pedido.getItempedidos().isEmpty()) {
            tableModelVenda = new VendaTableModel(pedido.getItempedidos());
            frm.getTabelaPedido().setModel(tableModelVenda);
            frm.getTabelaPedido().getSelectionModel().addListSelectionListener(this);
        }
    }

    public void adicionaListener() {
        frm.getBotaoAdicionarAoPedido().addActionListener(this);
        frm.getBotaoAdicionarItem().addActionListener(this);
        frm.getBotaoAlternarUsuario().addActionListener(this);
        frm.getBotaoBuscar().addActionListener(this);
        frm.getBotaoCancelarPedido().addActionListener(this);
        frm.getBotaoExcluirItem().addActionListener(this);
        frm.getBotaoCaixa().addActionListener(this);
        frm.getBotaoFecharPedido().addActionListener(this);
    }

    private void salvar() {

        JOptionPane.showMessageDialog(frm, "Lógica de Pagamento Aqui", "Cadastro de Pedido", JOptionPane.INFORMATION_MESSAGE);

        tableModelVenda = new VendaTableModel(pedido.getItempedidos());
        frm.getTabelaPedido().setModel(tableModelVenda);
        frm.getTabelaPedido().getSelectionModel().addListSelectionListener(this);

        inicializaTableModel();
    }

    private Pedido formToVenda() {
        return pedido;
    }
    
    private void atualizaTotal(){
        frm.getTextoValorTotal().setText("Valor Total: " + String.valueOf(totalPedido));
    }

    private void adicionaItempedido() {
        Produto produto = new Produto();
        Itempedido itempedido = new Itempedido();
        produto.setIdProd(Integer.valueOf(frm.getCampoAdicionarItem().getText()));
        produto = new DAO<>(Produto.class).buscaPorId(produto.getIdProd());
        itempedido.setProduto(produto);
        itempedido.setQtdProd(null);
        while (itempedido.getQtdProd() == null) {
            String aux = JOptionPane.showInputDialog("Digite a Quantidade");
            if (aux != null) {
                if (aux.equals("0")) {
                    System.out.println("Lógica de Remover Item");
                } else {
                    itempedido.setQtdProd(Integer.valueOf(aux));
                }
            }
        }
        itempedido.setTotProd(itempedido.getQtdProd() * produto.getValorProd());
        totalPedido = totalPedido + itempedido.getTotProd();
        atualizaTotal();
        pedido.getItempedidos().add(itempedido);
        frm.getCampoAdicionarItem().setText("");
        atualizaTableModelVenda();
    }

    public void cancelarPedido() {
        pedido.setItempedidos(new ArrayList<Itempedido>());
        tableModelVenda = new VendaTableModel(pedido.getItempedidos());
        frm.getTabelaPedido().setModel(tableModelVenda);
        frm.getTabelaPedido().getSelectionModel().addListSelectionListener(this);
        totalPedido = 0;
        atualizaTotal();
        atualizaTableModelVenda();
    }

    public void removerItem() {
        System.out.println("Chegou no Remover");
        if (pedido.getItempedidos().size() == 1) {
            System.out.println("Apenas 1 Item");
            cancelarPedido();
        } else if (frm.getTabelaPedido().getSelectedRow() != -1) {
            System.out.println("Removendo 1 Item");
            totalPedido = totalPedido - pedido.getItempedidos().get(frm.getTabelaPedido().getSelectedRow()).getTotProd();
            pedido.getItempedidos().remove(frm.getTabelaPedido().getSelectedRow());
            atualizaTotal();
            atualizaTableModelVenda();
        }
    }

    public void vendaToForm(Itempedido itempedido) {
        frm.getCampoAdicionarItem().setText(String.valueOf(itempedido.getId()));
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println(event);
        switch (event.getActionCommand()) {
            case "Adicionar Item":
                atualizaTableModelVenda();
                adicionaItempedido();
                break;
            case "":
                removerItem();
                break;
            case "Excluir":
                break;
            case "Salvar":
                salvar();
                break;
            case "Cancelar Pedido":
                cancelarPedido();
                break;
            case "Adiciona Ingrediente":
                System.out.println("Chegou aqui");
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (frm.getTabelaPedido().getSelectedRow() != -1) {
            Itempedido itempedido = tableModelVenda.getItemspedido().get(frm.getTabelaPedido().getSelectedRow());
            vendaToForm(itempedido);
        }
    }
}
