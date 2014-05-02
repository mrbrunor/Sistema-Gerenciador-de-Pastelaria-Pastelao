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
import com.au.gui.tmodel.ProdutoTableModel;
import com.au.modelo.Pedido;
import com.au.modelo.Produto;
import com.au.util.DAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author BrunoRicardo
 */
public class VendaActionListener implements ActionListener, ListSelectionListener {

    private final TelaVenda frm;
    private ProdutoTableModel tableModel;

    public VendaActionListener(TelaVenda frm) {
        this.frm = frm;
        adicionaListener();
        inicializaTableModel();
    }

    public void inicializaTableModel() {
        tableModel = new ProdutoTableModel(new DAO<>(Produto.class).listaTodos());
        frm.getTabelaBusca().setModel(tableModel);
        frm.getTabelaBusca().getSelectionModel().addListSelectionListener(this);

    }

    public void adicionaListener() {
        frm.getBotaoAdicionarAoPedido().addActionListener(this);
        frm.getBotaoAdicionarItem().addActionListener(this);
        frm.getBotaoAlternarUsuario().addActionListener(this);
        frm.getBotaoBuscar().addActionListener(this);
        frm.getBotaoCancelarPedido().addActionListener(this);
        frm.getBotaoExcluirItem().addActionListener(this);
        frm.getBotaoFecharCaixa().addActionListener(this);
        frm.getBotaoFecharPedido().addActionListener(this);
    }

    private void salvar() {
        //Lógica de Criar o Pedido - new DAO<>(Pedido.class).adiciona();

        JOptionPane.showMessageDialog(frm, "Cadastrado Com Sucesso", "Cadastro de Funcionario", JOptionPane.INFORMATION_MESSAGE);

        //Limpar o Pedido após Registrar o Pedido - limpaCampos();

        inicializaTableModel();
    }

    private void produtoToAddItem(Produto produto) {
        frm.getCampoAdicionarItem().setText(String.valueOf(produto.getIdProd()));        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Cadastrar Fornecedor":
                salvar();
                break;
            case "Alterar":
                break;
            case "Excluir":
                break;
            case "Salvar":
                break;
            case "Cancelar":
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        Produto produto = tableModel.getProdutos().get(frm.getTabelaBusca().getSelectedRow());
        produtoToAddItem(produto);
    }
}
