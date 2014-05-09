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
import com.au.gui.tmodel.VendaTableModel;
import com.au.modelo.Itempedido;
import com.au.modelo.Produto;
import com.au.util.DAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author BrunoRicardo
 */
public class TabelaPesquisaActionListener implements ActionListener, ListSelectionListener {

    private final TelaVenda frm;
    private ProdutoTableModel tableModelPesquisa;
    
    public TabelaPesquisaActionListener(TelaVenda frm) {
        this.frm = frm;
        frm.getBotaoBuscar().addActionListener(this);
        inicializaTableModel();
    }

    public void inicializaTableModel() {
        atualizaTableModelPesquisa();
        frm.getTabelaBusca().setModel(tableModelPesquisa);
        frm.getTabelaBusca().getSelectionModel().addListSelectionListener(this);
    }
    
    public void atualizaTableModelPesquisa(){
        tableModelPesquisa = new ProdutoTableModel(new DAO<>(Produto.class).listaTodos());
    }
    
    public void pesquisaProdutos(){
        String pesquisa = frm.getCampoBusca().getText();
        System.out.println(pesquisa);
        tableModelPesquisa = new ProdutoTableModel(new DAO<>(Produto.class).buscaProduto(pesquisa));
        frm.getTabelaBusca().setModel(tableModelPesquisa);
        frm.getTabelaBusca().getSelectionModel().addListSelectionListener(this);
        
    }
    
    public void vendaToForm(Produto produto){
        frm.getCampoAdicionarItem().setText(String.valueOf(produto.getIdProd()));
    }
 
    @Override
    public void valueChanged(ListSelectionEvent event) {
        Produto produto = tableModelPesquisa.getProdutos().get(frm.getTabelaBusca().getSelectedRow());
        vendaToForm(produto);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pesquisaProdutos();
    }
}
