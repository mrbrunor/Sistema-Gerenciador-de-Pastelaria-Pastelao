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

import com.au.gui.TelaLogin;
import com.au.gui.TelaVenda;
import com.au.gui.tmodel.VendaTableModel;
import com.au.modelo.Caixa;
import com.au.modelo.Itempedido;
import com.au.modelo.Pedido;
import com.au.modelo.Produto;
import com.au.util.DAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private double totalPedido = 0;
    private Integer indexCaixa = null;

    public VendaActionListener(TelaVenda frm) {
        this.frm = frm;
        adicionaListener();
        inicializaTableModel();
        indexCaixa = verificaCaixa();
        if (indexCaixa == null){
            Caixa caixa = novoCaixa();
            new DAO<>(Caixa.class).atualiza(caixa);
            frm.getFuncionario().getCaixas().add(caixa);
            System.out.println("Novo caixa Criado");
            indexCaixa = frm.getFuncionario().getCaixas().size()-1;
        }        
        System.out.println(indexCaixa);
        frm.getBotaoCaixa().setText("Fechar Caixa");
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

    private void atualizaTotal() {
        frm.getTextoValorTotal().setText("Valor Total: " + String.valueOf(totalPedido));
    }

    private void verificaSeExiste(Itempedido itempedido) {
        for (int i = 0; i < pedido.getItempedidos().size(); i++) {
            System.out.println("Entrou FOR");
            if (pedido.getItempedidos().get(i).getProduto().getIdProd() == itempedido.getProduto().getIdProd()) {
                System.out.println("Item ja existe no pedido");
                totalPedido = totalPedido - pedido.getItempedidos().get(i).getTotProd();
                if (itempedido.getQtdProd() == 0) {
                    pedido.getItempedidos().remove(i);
                } else {
                    pedido.getItempedidos().set(i, itempedido);
                }
                return;
            }
        }
        System.out.println("saiu do for");
        pedido.getItempedidos().add(itempedido);
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
                itempedido.setQtdProd(Integer.valueOf(aux));
            }
        }
        verificaSeExiste(itempedido);
        itempedido.setTotProd(itempedido.getQtdProd() * produto.getValorProd());
        totalPedido = totalPedido + itempedido.getTotProd();
        atualizaTotal();
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

    public Caixa novoCaixa() {
        Caixa caixa = new Caixa();
        Date data = new Date();
        Time time = new Time(data.getTime());
        caixa.setAberturaCaixa(time);
        caixa.setDataCaixa(data);
        caixa.setEstaAberto((byte) 1);
        caixa.setFuncionario(frm.getFuncionario());
        caixa.setFundoCaixa(0);
        while (caixa.getFundoCaixa() == 0) {
            String aux = JOptionPane.showInputDialog("Digite o Valor do Fundo de Caixa");
            if (aux != null) {
                caixa.setFundoCaixa(Double.valueOf(aux));
            }
        }
        caixa.setTotalCaixa(0);
        return caixa;
    }

    public Integer verificaCaixa() {
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        String dataStr = formatador.format(data);
        
        
        for(int i =0; frm.getFuncionario().getCaixas().size() > i; i++){
            System.out.println("A");
            System.out.println("A");
            System.out.println("A");
            System.out.println("A");
            System.out.println("A");
            System.out.println("A");
            System.out.println("A");
            System.out.println("A");
            System.out.println("A");
            System.out.println("A");
            System.out.println("A");
            System.out.println("A");
            System.out.println("A");
            System.out.println("A");
            System.out.println(frm.getFuncionario().getCaixas().get(i).getDataCaixa());
            System.out.println(frm.getFuncionario().getCaixas().size());
            System.out.println(dataStr);
            if(String.valueOf(frm.getFuncionario().getCaixas().get(i).getDataCaixa()).equals(dataStr)){
                System.out.println("Chegou");
                byte x = 1;
                if(frm.getFuncionario().getCaixas().get(i).getEstaAberto() == x){
                    return i;
                }
            }
        }
        return null;
    }

    public void deslogar() {
        new TelaLogin().setVisible(true);
        frm.dispose();
    }

    public void vendaToForm(Itempedido itempedido) {
        frm.getCampoAdicionarItem().setText(String.valueOf(itempedido.getProduto().getIdProd()));
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println(event);
        switch (event.getActionCommand()) {
            case "Adicionar Item":
                atualizaTableModelVenda();
                adicionaItempedido();
                break;
            case "Remover Item":
                removerItem();
                break;
            case "Fechar Caixa":
                System.out.println(frm.getFuncionario().getCaixas().get(indexCaixa).getTotalCaixa());
                break;
            case "Salvar":
                salvar();
                break;
            case "Cancelar Pedido":
                cancelarPedido();
                break;
            case "Deslogar":
                deslogar();
                break;
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
