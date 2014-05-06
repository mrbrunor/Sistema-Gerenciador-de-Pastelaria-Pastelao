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
import com.au.gui.TelaVenda;
import com.au.gui.tmodel.ProdutoIngredientesTableModel;
import com.au.gui.tmodel.ProdutoTableModel;
import com.au.gui.tmodel.VendaTableModel;
import com.au.modelo.Fornecedor;
import com.au.modelo.Ingrediente;
import com.au.modelo.Itempedido;
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
public class VendaActionListener implements ActionListener, ListSelectionListener {

    private final TelaVenda frm;
    private VendaTableModel tableModelVenda;
    private List<Itempedido> itemspedido = new ArrayList<>();
    
    public VendaActionListener(TelaVenda frm) {
        this.frm = frm;
        adicionaListener();
        inicializaTableModel();
    }

    public void inicializaTableModel() {
        atualizaTableModelVenda();
    }
    
    public void atualizaTableModelVenda(){
        if(!itemspedido.isEmpty()){
            tableModelVenda = new VendaTableModel(itemspedido);
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
        new DAO<>(Produto.class).adiciona(formToVenda());
        
        JOptionPane.showMessageDialog(frm, "Lógica de Pagamento Aqui", "Cadastro de Pedido", JOptionPane.INFORMATION_MESSAGE);
        
        itemspedido = new ArrayList<>();
        tableModelVenda = new VendaTableModel(itemspedido);
        frm.getTabelaPedido().setModel(tableModelVenda);
        frm.getTabelaPedido().getSelectionModel().addListSelectionListener(this);
        
        inicializaTableModel();
    }
    
    private Produto formToVenda() {
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
            produto.setIngredientes(ingredientes);
        }   
        return produto;
    }

    private void vendaToForm(Produto produto) {
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
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Cadastrar Produto":
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
            case "Adiciona Ingrediente":
                System.out.println("Chegou aqui");
                adicionaIngrediente();
        }
        habilitaBotoesParaSalvar();
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        Produto produto = tableModelVenda.getProdutos().get(frm.getTabelaProdutos().getSelectedRow());
        vendaToForm(produto);
        
    }
}
