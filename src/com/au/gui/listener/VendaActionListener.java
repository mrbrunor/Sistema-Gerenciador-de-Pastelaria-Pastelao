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

import com.au.gui.TelaCadastrarFornecedor;
import com.au.gui.TelaCadastrarFuncionario;
import com.au.gui.TelaCadastrarIngrediente;
import com.au.gui.TelaCadastrarProduto;
import com.au.gui.TelaConfirmacaoPagamento;
import com.au.gui.TelaFechamentoCaixa;
import com.au.gui.TelaLogin;
import com.au.gui.TelaVenda;
import com.au.gui.TelaVendasPorPeriodo;
import com.au.gui.tmodel.VendaTableModel;
import com.au.modelo.Caixa;
import com.au.modelo.Itempedido;
import com.au.modelo.ItempedidoPK;
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
    private boolean numeroPedidoVerificado = false;
    private int numPedido = 1;

    public VendaActionListener(TelaVenda frm) {
        this.frm = frm;
        adicionaListener();
        inicializaTableModel();
        inicializaData();
        indexCaixa = verificaCaixa();
        if (indexCaixa == null) {
            Caixa caixa = novoCaixa();
            new DAO<>(Caixa.class).adiciona(caixa);//atualiza(caixa);
            numeroPedidoVerificado = true;
            System.out.println("O ID do caixa é: " + caixa.getIdCaixa());
            frm.getFuncionario().getCaixas().add(caixa);
            System.out.println("Novo caixa Criado");
            indexCaixa = frm.getFuncionario().getCaixas().size() - 1;
        }
        System.out.println(indexCaixa);
        frm.getBotaoCaixa().setText("Fechar Caixa");
        frm.getCampoAdicionarItem().requestFocus();
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

    public void inicializaData() {
        Date date = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
        frm.getTextoData().setText(formatador.format(date));
    }

    public void adicionaListener() {
        frm.getBotaoAdicionarAoPedido().addActionListener(this);
        frm.getBotaoAdicionarItem().addActionListener(this);
        frm.getBotaoAlternarUsuario().addActionListener(this);
        frm.getBotaoCancelarPedido().addActionListener(this);
        frm.getBotaoExcluirItem().addActionListener(this);
        frm.getBotaoCaixa().addActionListener(this);
        frm.getBotaoFecharPedido().addActionListener(this);
        frm.getItemMenuAbrirCaixa().addActionListener(this);
        frm.getItemMenuAjuda().addActionListener(this);
        frm.getItemMenuDeslogar().addActionListener(this);
        frm.getItemMenuDespesas().addActionListener(this);
        frm.getItemMenuFecharCaixa().addActionListener(this);
        frm.getItemMenuFornecedores().addActionListener(this);
        frm.getItemMenuFuncionarios().addActionListener(this);
        frm.getItemMenuIngredientes().addActionListener(this);
        frm.getItemMenuNotasFiscais().addActionListener(this);
        frm.getItemMenuProdutos().addActionListener(this);
        frm.getItemMenuRetiradaDeCaixa().addActionListener(this);
        frm.getItemMenuSair().addActionListener(this);
        frm.getItemMenuSobre().addActionListener(this);
        frm.getItemMenuTeclasAtalho().addActionListener(this);
        frm.getItemMenuTrocarSenha().addActionListener(this);
        frm.getItemMenuVendasPorPeriodo().addActionListener(this);
    }

    private void fecharPedido() {
        if (numeroPedidoVerificado) {
            pedido.setNumPedido(numPedido++);
        } else {
            pedido.setNumPedido(verificaNumeroPedido());
        }
        new TelaConfirmacaoPagamento(frm, true, frm.getFuncionario(), pedido, indexCaixa, totalPedido).setVisible(true);
        if (TelaConfirmacaoPagamento.isCadastrou()) {
            TelaConfirmacaoPagamento.setCadastrou(false);
            frm.getFuncionario().getCaixas().set(indexCaixa, TelaConfirmacaoPagamento.getCaixa());
            limparPedido();
        } else {
            //JOptionPane.show(frm, ""); Mensagem perguntando se deseja limpar o pedido
            System.out.println("Cadastro Cancelado");
        }

    }

    private Pedido formToVenda() {
        return pedido;
    }

    private void atualizaTotal() {
        frm.getTextoValorTotal().setText(String.format("Valor Total: %.2f", totalPedido));
    }

    private void verificaSeExiste(Itempedido itempedido) {
        for (int i = 0; i < pedido.getItempedidos().size(); i++) {
            System.out.println("Entrou FOR");
            if (pedido.getItempedidos().get(i).getProduto().getIdProd() == itempedido.getProduto().getIdProd()) {
                System.out.println("Item ja existe no pedido");
                totalPedido = totalPedido - pedido.getItempedidos().get(i).getTotProd();
                if (itempedido.getQtdProd() == 0) {
                    if (pedido.getItempedidos().size() == 1) {
                        System.out.println("Apenas 1 Item");
                        limparPedido();
                    } else {
                        pedido.getItempedidos().remove(i);
                    }
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
        ItempedidoPK itempedidoPK = new ItempedidoPK();

        produto.setIdProd(Integer.valueOf(frm.getCampoAdicionarItem().getText()));
        produto = new DAO<>(Produto.class).buscaPorId(produto.getIdProd());
        itempedido.setProduto(produto);
        itempedidoPK.setIdProd(produto.getIdProd());
        itempedido.setId(itempedidoPK);
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

    public void limparPedido() {
        pedido = new Pedido();
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
            limparPedido();
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
        caixa.setDataAberturaCaixa(data);
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

    public boolean fecharCaixa(Integer index) {
        //System.out.println(index);
        //System.out.println(indexCaixa);
        //System.out.println("ID caixa :P");
        //System.out.println(frm.getFuncionario().getCaixas().get(indexCaixa).getIdCaixa());
        new TelaFechamentoCaixa(frm, true, frm.getFuncionario().getCaixas().get(index).getIdCaixa()).setVisible(true);
        if (TelaFechamentoCaixa.isFechou()) {
            JOptionPane.showMessageDialog(frm, "Caixa Fechado com Sucesso");
            System.out.println("Resultado" + TelaFechamentoCaixa.isFechou());
            return true;
        }
        System.out.println("Resultado" + TelaFechamentoCaixa.isFechou());
        return false;
    }

    public Integer verificaCaixa() {
        byte x = 1;
        String dataStr = geraDataStr();
        for (int i = 0; frm.getFuncionario().getCaixas().size() > i; i++) {
            System.out.println(frm.getFuncionario().getCaixas().get(i).getDataAberturaCaixa());
            System.out.println(frm.getFuncionario().getCaixas().size());
            System.out.println(dataStr);
            if (frm.getFuncionario().getCaixas().get(i).getEstaAberto() == x) {
                if (String.valueOf(frm.getFuncionario().getCaixas().get(i).getDataAberturaCaixa()).equals(dataStr)) {
                    System.out.println("Chegou");
                    return i;
                } else {
                    JOptionPane.showMessageDialog(frm, "Você não fechou o caixa do ultimo dia, antes de iniciar um novo caixa, devemos fechar o anterior. Clique em OK para Fechar o Caixa");
                    while(!TelaFechamentoCaixa.isFechou()){
                        fecharCaixa(i);
                    }                    
                }
            }

        }
        return null;
    }

    public Integer verificaNumeroPedido() {
        String dataStr = geraDataStr();
        numPedido = 1;
        if (indexCaixa != null && frm.getFuncionario().getCaixas().get(indexCaixa).getPedidos() != null) {
            System.out.println("index caixa...." + indexCaixa);
            for (int i = 0; frm.getFuncionario().getCaixas().get(indexCaixa).getPedidos().size() > i; i++) {
                System.out.println("Entrou For Numero Pedido");
                System.out.println("Numero Pedido Antes: " + numPedido);
                if (frm.getFuncionario().getCaixas().get(indexCaixa).getPedidos().get(i).getNumPedido() >= numPedido) {
                    numPedido = frm.getFuncionario().getCaixas().get(indexCaixa).getPedidos().get(i).getNumPedido();
                    numPedido++;
                    System.out.println("Numero Pedido Depois: " + numPedido);
                }
            }
            numeroPedidoVerificado = true;
        }
        return numPedido;
    }

    public String geraDataStr() {
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        return formatador.format(data);
    }

    public void deslogar() {
        new TelaLogin().setVisible(true);
        frm.dispose();
    }

    public void vendaToForm(Itempedido itempedido) {
        frm.getCampoAdicionarItem().setText(String.valueOf(itempedido.getProduto().getIdProd()));
    }

    public boolean validaAddItem() {
        boolean valida = true;
        if ("".equals(frm.getCampoAdicionarItem().getText()) || "0".equals(frm.getCampoAdicionarItem().getText())) {
            valida = false;
            JOptionPane.showMessageDialog(frm, "Insira o ID do produto para adiciona-lo ao pedido.");
        }
        return valida;
    }

    public boolean validaDelItem() {
        boolean valida = true;
        if (frm.getTabelaPedido().getSelectedRow() == -1) {
            valida = false;
            JOptionPane.showMessageDialog(frm, "Selecione um item para remover!");
        }
        return valida;
    }

    public boolean validaPedido() {
        boolean valida = true;
        System.out.println(frm.getTabelaPedido().getRowCount());
        System.out.println(frm.getTabelaPedido().getRowCount());
        System.out.println(frm.getTabelaPedido().getRowCount());
        System.out.println(frm.getTabelaPedido().getRowCount());
        System.out.println(frm.getTabelaPedido().getRowCount());
        System.out.println(frm.getTabelaPedido().getRowCount());
        System.out.println(frm.getTabelaPedido().getRowCount());
        System.out.println(frm.getTabelaPedido().getRowCount());
        System.out.println(frm.getTabelaPedido().getRowCount());
        if (frm.getTabelaPedido().getRowCount() == 0) {
            valida = false;
            JOptionPane.showMessageDialog(frm, "Adicione um item ao pedido antes!");
        }
        return valida;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println(event);
        switch (event.getActionCommand()) {
            case "Adicionar Item":
                if (validaAddItem()) {
                    atualizaTableModelVenda();
                    adicionaItempedido();
                }
                break;
            case "Remover Item":
                if (validaDelItem()) {
                    removerItem();
                }
                break;
            case "Fechar Caixa":
                if (fecharCaixa(indexCaixa)) {
                    deslogar();
                }
                break;
            case "Fechar Pedido":
                if (validaPedido()) {
                    fecharPedido();
                }
                break;
            case "Cancelar Pedido":
                limparPedido();
                break;
            case "Deslogar":
                deslogar();
                break;
            case "Fornecedores":
                new TelaCadastrarFornecedor(frm, true).setVisible(true);
                break;
            case "Funcionários":
                new TelaCadastrarFuncionario(frm, true).setVisible(true);
                break;
            case "Ingredientes":
                new TelaCadastrarIngrediente(frm, true).setVisible(true);
                break;
            case "Produtos":
                new TelaCadastrarProduto(frm, true).setVisible(true);
                new TabelaPesquisaActionListener(frm).pesquisaProdutos();
                break;
            case "Vendas Por Período":
                new TelaVendasPorPeriodo(frm, true).setVisible(true);
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
