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

import com.au.gui.TelaCadastrarProduto;
import com.au.gui.tmodel.ProdutoIngredientesTableModel;
import com.au.gui.tmodel.ProdutoTableModel;
import com.au.modelo.Fornecedor;
import com.au.modelo.Ingrediente;
import com.au.modelo.Produto;
import com.au.util.CustomComboBoxInt;
import com.au.util.DAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author BrunoRicardo
 */
public class ProdutoActionListener implements ActionListener, ListSelectionListener {

    private final TelaCadastrarProduto frm;
    private ProdutoTableModel tableModelProdutos;
    private ProdutoIngredientesTableModel tableModelIngredientes;
    private List<Ingrediente> ingredientes = new ArrayList<>();
    
    public void limpaCampos(){
        frm.limpaCampos();
    }

    public ProdutoActionListener(TelaCadastrarProduto frm) {
        this.frm = frm;
        adicionaListener();
        inicializaTableModel();
        habilitaBotoesParaSalvar();
    }

    public void inicializaTableModel() {
        atualizaTableModelProdutos();
        frm.getTabelaProdutos().setModel(tableModelProdutos);
        frm.getTabelaProdutos().getSelectionModel().addListSelectionListener(this);
        atualizaTableModelIngredientes();
    }
    
    public void atualizaTableModelProdutos(){
        tableModelProdutos = new ProdutoTableModel(new DAO<>(Produto.class).listaTodos());
    }
    
    public void atualizaTableModelIngredientes(){
        if(!ingredientes.isEmpty()){
            tableModelIngredientes = new ProdutoIngredientesTableModel(ingredientes);
            frm.getTabelaIngredientes().setModel(tableModelIngredientes);
            frm.getTabelaIngredientes().getSelectionModel().addListSelectionListener(this);
        }
    }

    public void adicionaListener() {
        frm.getBotaoAdicionarIngrediente().addActionListener(this);
        frm.getBotaoAtualizarProduto().addActionListener(this);
        frm.getBotaoCadastrarProduto().addActionListener(this);
        frm.getBotaoCancelarCadastro().addActionListener(this);
        frm.getBotaoExcluirProduto().addActionListener(this);
        frm.getBotaoLimparCampos().addActionListener(this);
        frm.getBotaoProcurarProduto().addActionListener(this);
        
    }

    private void habilitaBotoesParaSalvar() {
        habilitaOuDesabilitaBotoesEdicao(true);
    }

    private void desabilitaBotoesParaSalvar() {
        habilitaOuDesabilitaBotoesEdicao(false);
    }

    private void habilitaOuDesabilitaBotoesEdicao(boolean enabled) {
        frm.getBotaoCadastrarProduto().setEnabled(enabled);
        frm.getBotaoAtualizarProduto().setEnabled(!enabled);
        frm.getBotaoExcluirProduto().setEnabled(!enabled);
    }

    private void cadastrarProduto() {
        new DAO<>(Produto.class).adiciona(formToProduto());

        JOptionPane.showMessageDialog(frm, "Cadastrado Com Sucesso", "Cadastro de Produto", JOptionPane.INFORMATION_MESSAGE);

        limpaCampos();
        
        ingredientes = new ArrayList<>();
        tableModelIngredientes = new ProdutoIngredientesTableModel(ingredientes);
        frm.getTabelaIngredientes().setModel(tableModelIngredientes);
        frm.getTabelaIngredientes().getSelectionModel().addListSelectionListener(this);

        inicializaTableModel();
    }

    public void atualizarProduto() {
        new DAO<>(Produto.class).atualiza(formToProduto());

        JOptionPane.showMessageDialog(frm, "Cadastro Atualizado Com Sucesso", "Cadastro de Produto", JOptionPane.INFORMATION_MESSAGE);

        limpaCampos();

        inicializaTableModel();

    }

    public void excluirProduto() {
        new DAO<>(Produto.class).remove(formToProduto());

        JOptionPane.showMessageDialog(frm, "Cadastro Removido Com Sucesso", "Cadastro de Produto", JOptionPane.INFORMATION_MESSAGE);

        limpaCampos();

        inicializaTableModel();

    }
    
    private void adicionaIngrediente() {
        CustomComboBoxInt ob = (CustomComboBoxInt) frm.getCaixaSelecaoIng().getSelectedItem();
        
        for(int i=0; i<frm.getTabelaIngredientes().getRowCount(); i++){
            if(ob.getNome().equals(frm.getTabelaIngredientes().getValueAt(i, 0))){
                System.out.println("FUDEU");
                return;
            }
        }        
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setDescIng(ob.getNome());
        ingrediente.setIdIng(ob.getId());
        ingredientes.add(ingrediente);
        System.out.println("Adicionou " + ingrediente.getDescIng());
        atualizaTableModelIngredientes();
    }

    private Produto formToProduto() {
        Produto produto = new Produto();
        
        if (!"".equals(frm.getCampoId().getText())) {
            produto.setIdProd(Integer.valueOf(frm.getCampoId().getText()));
        }        
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
            produto.setIngredientes(ingredientes);
        }   
        return produto;
    }

    private void produtoToForm(Produto produto) {
        frm.getCampoId().setText(String.valueOf(produto.getIdProd()));
        frm.getCampoNome().setText(produto.getDescProd());
        frm.getCampoValor().setText(String.valueOf(produto.getValorProd()));
        //Fornecedor
        List<Fornecedor> fornecedores = frm.getListaResForn();
        for(int i=0; i<frm.getCaixaSelecaoForn().getItemCount(); i++){
            if(produto.getFornecedor().getIdForn() == fornecedores.get(i).getIdForn()){
                frm.getCaixaSelecaoForn().setSelectedIndex(i);
            }
        }        
        //
        if(produto.getEIndustrializado() == (byte)1){
            frm.getRadioInd().setSelected(true);
            frm.getRadioPrep().setSelected(false);
            frm.getCampoQtd().setText(String.valueOf(produto.getQtdProd()));
            frm.getCampoBarras().setText(produto.getCodBarras());
        }
        else{
            frm.getRadioPrep().setSelected(true);
            frm.getRadioInd().setSelected(false);
            tableModelIngredientes = new ProdutoIngredientesTableModel(produto.getIngredientes());
            frm.getTabelaIngredientes().setModel(tableModelIngredientes);
            frm.getTabelaIngredientes().getSelectionModel().addListSelectionListener(this);
        }
        desabilitaBotoesParaSalvar();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Adicionar Ingrediente":
                adicionaIngrediente();
                break;
            case "Cadastrar Produto":
                cadastrarProduto();
                break;
            case "Limpar Campos":
                limpaCampos();
                habilitaBotoesParaSalvar();
                break;
            case "Excluir Produto":
                excluirProduto();
                habilitaBotoesParaSalvar();
                break;
            case "Atualizar Produto":
                atualizarProduto();
                habilitaBotoesParaSalvar();
                break;
            case "Cancelar Cadastro":
                this.frm.dispose();
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if(frm.getTabelaProdutos().getSelectedRow() != -1){
            Produto produto = tableModelProdutos.getProdutos().get(frm.getTabelaProdutos().getSelectedRow());
            produtoToForm(produto);
        }        
    }
}
