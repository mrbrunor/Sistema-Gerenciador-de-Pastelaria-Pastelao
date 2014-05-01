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

import com.au.bean.CustomComboBoxInt;
import com.au.modelo.Fornecedor;
import com.au.modelo.Ingrediente;
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
public class ProdutoActionListener implements ActionListener, ListSelectionListener {

    private final TelaCadastrarProduto frm;
    private ProdutoTableModel tableModel;
    
    public void limpaCampos(){
        frm.limpaCampos();
    }
    
    public ProdutoActionListener(TelaCadastrarProduto frm) {
        this.frm = frm;
        adicionaListener();
        inicializaTableModel();
    }

    public void inicializaTableModel() {
        tableModel = new ProdutoTableModel(new DAO<>(Produto.class).listaTodos());
        frm.getTabelaProdutos().setModel(tableModel);
        frm.getTabelaProdutos().getSelectionModel().addListSelectionListener(this);

    }

    public void adicionaListener() {
        frm.getBotaoCadastrarProduto().addActionListener(this);
        frm.getBotaoCancelarCadastro().addActionListener(this);
        frm.getBotaoExcluirProduto().addActionListener(this);
        frm.getBotaoAtualizarProduto().addActionListener(this);
        frm.getBotaoAdicionarFornecedor().addActionListener(this);
        frm.getBotaoAdicionarIngrediente().addActionListener(this);
    }

    private void habilitaBotoesParaSalvar() {
        habilitaOuDesabilitaBotoesEdicao(true);
    }

    private void desabilitaBotoesParaSalvar() {
        habilitaOuDesabilitaBotoesEdicao(false);
    }

    private void habilitaOuDesabilitaBotoesEdicao(boolean enabled) {
        frm.getBotaoCadastrarProduto().setEnabled(!enabled);
        frm.getBotaoAtualizarProduto().setEnabled(!enabled);
        frm.getBotaoExcluirProduto().setEnabled(!enabled);
        frm.getBotaoCancelarCadastro().setEnabled(enabled);
    }

    private void incluir() {
        habilitaBotoesParaSalvar();
    }

    private void salvar() {
        new DAO<>(Produto.class).adiciona(formToProduto());
        
        JOptionPane.showMessageDialog(frm, "Cadastrado Com Sucesso", "Cadastro de Produto", JOptionPane.INFORMATION_MESSAGE);
        
        desabilitaBotoesParaSalvar();
        
        limpaCampos();
        
        inicializaTableModel();
    }

    private Produto formToProduto() {
        Produto produto = new Produto();
        
        produto.setDescProd(frm.getCampoNome().getText());
        produto.setValorProd(Double.valueOf(frm.getCampoValor().getText()));
        
        CustomComboBoxInt ob = (CustomComboBoxInt) frm.getCaixaSelecaoForn().getSelectedItem();
        produto.setFornecedor(new DAO<>(Fornecedor.class).buscaPorId(ob.getId()));
        
        if (frm.getRadioInd().isSelected()) {
            produto.setEIndustrializado((byte)1);
            produto.setQtdProd(Integer.valueOf(frm.getCampoQtd().getText()));
            if("".equals(frm.getCampoBarras().getText())){
                produto.setCodBarras(null);
            }
            else{
                produto.setCodBarras(frm.getCampoBarras().getText());
            }            
        } else {
            produto.setQtdProd(null);
            produto.setCodBarras(null);
            produto.setEIndustrializado((byte)0);
            
            if(frm.getCaixaIng1().isSelected()){
                ob = (CustomComboBoxInt) frm.getCaixaSelecaoIng1().getSelectedItem();
                produto.adicionaIngrediente(new DAO<>(Ingrediente.class).buscaPorId(ob.getId()));
            }
            if(frm.getCaixaIng2().isSelected()){
                ob = (CustomComboBoxInt) frm.getCaixaSelecaoIng1().getSelectedItem();
                produto.adicionaIngrediente(new DAO<>(Ingrediente.class).buscaPorId(ob.getId()));
            }
            if(frm.getCaixaIng3().isSelected()){
                ob = (CustomComboBoxInt) frm.getCaixaSelecaoIng1().getSelectedItem();
                produto.adicionaIngrediente(new DAO<>(Ingrediente.class).buscaPorId(ob.getId()));
            }
            if(frm.getCaixaIng4().isSelected()){
                ob = (CustomComboBoxInt) frm.getCaixaSelecaoIng1().getSelectedItem();
                produto.adicionaIngrediente(new DAO<>(Ingrediente.class).buscaPorId(ob.getId()));
            }
            if(frm.getCaixaIng5().isSelected()){
                ob = (CustomComboBoxInt) frm.getCaixaSelecaoIng1().getSelectedItem();
                produto.adicionaIngrediente(new DAO<>(Ingrediente.class).buscaPorId(ob.getId()));
            }
        }   
        return produto;
    }

    private void produtoToForm(Produto produto) {
        frm.getCampoId().setText(String.valueOf(produto.getIdProd()));
        frm.getCampoNome().setText(produto.getDescProd());
        frm.getCampoValor().setText(String.valueOf(produto.getValorProd()));
        //Fornecedor
        if(produto.getEIndustrializado() == (byte)1){
            frm.getRadioInd().setSelected(true);
            frm.getRadioPrep().setSelected(false);
            frm.getCampoQtd().setText(String.valueOf(produto.getQtdProd()));
            frm.getCampoBarras().setText(produto.getCodBarras());
        }
        else{
            CustomComboBoxInt ob = null;
            frm.getRadioPrep().setSelected(true);
            frm.getRadioInd().setSelected(false);
            if(!produto.getIngredientes().isEmpty()){
                if(produto.getIngredientes().size()>=1){
                    ob.setId(produto.getIngredientes().get(0).getIdIng());
                    ob.setNome(produto.getIngredientes().get(0).getDescIng());
                    frm.getCaixaSelecaoIng1().setSelectedItem(ob);
                }
                if(produto.getIngredientes().size()>=2){
                    
                }
                if(produto.getIngredientes().size()>=3){
                    
                }
                if(produto.getIngredientes().size()>=4){
                    
                }
                if(produto.getIngredientes().size()>=5){
                    
                }
            }
            
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Cadastrar":
                salvar();
                break;
            case "Alterar":
                break;
            case "Excluir":
                break;
            case "Salvar":
                salvar();
                break;
            case "Cancelar":
                break;
        }
        habilitaBotoesParaSalvar();
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        Produto produto = tableModel.getProdutos().get(frm.getTabelaProdutos().getSelectedRow());
        produtoToForm(produto);
        
    }

}
