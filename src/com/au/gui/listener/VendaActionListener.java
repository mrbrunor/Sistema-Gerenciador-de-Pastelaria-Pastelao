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

import com.au.gui.TelaCadastrarFormasDePagamento;
import com.au.gui.TelaCadastrarFuncionario;
import com.au.gui.TelaCadastrarIngrediente;
import com.au.gui.TelaCadastrarProduto;
import com.au.gui.TelaConfirmacaoPagamento;
import com.au.gui.TelaFechamentoCaixa;
import com.au.gui.TelaLogin;
import com.au.gui.TelaRetirada;
import com.au.gui.TelaSobre;
import com.au.gui.TelaVenda;
import com.au.gui.TelaVendasGerais;
import com.au.gui.TelaVendasPorFormaPgto;
import com.au.gui.TelaVendasPorIngrediente;
import com.au.gui.tmodel.VendaTableModel;
import com.au.modelo.Caixa;
import com.au.modelo.Itempedido;
import com.au.modelo.ItempedidoPK;
import com.au.modelo.Pedido;
import com.au.modelo.Produto;
import com.au.dao.DAO;
import com.au.gui.TelaCancelamento;
import com.au.gui.TelaReimpressao;
import com.au.gui.TelaReimprimirRelatorio;
import com.au.gui.TelaVisualizarCaixa;
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
        frm.getCampoAdicionarItem().requestFocus();
        indexCaixa = verificaCaixa();
        if (frm.getFuncionario().getNivelFunc() == 0) {
            frm.getMenuCadastros().setEnabled(false);
            frm.getMenuRelatorio().setEnabled(false);
            abrirCaixa();
        } else if (indexCaixa == null) {
            caixaFechado();
        }
        frm.getCampoAdicionarItem().requestFocus();
    }

    public void inicializaTableModel() {
        atualizaTableModelVenda();
    }

    public void atualizaTableModelVenda() {
        tableModelVenda = new VendaTableModel(pedido.getItempedidos());
        frm.getTabelaPedido().setModel(tableModelVenda);
        frm.getTabelaPedido().getSelectionModel().addListSelectionListener(this);

        frm.getTabelaPedido().getColumnModel().getColumn(0).setMaxWidth(65);
        frm.getTabelaPedido().getColumnModel().getColumn(2).setMaxWidth(85);
        frm.getTabelaPedido().getColumnModel().getColumn(2).setMinWidth(85);
        frm.getTabelaPedido().getColumnModel().getColumn(3).setMaxWidth(55);
        frm.getTabelaPedido().getColumnModel().getColumn(3).setMinWidth(55);
        frm.getTabelaPedido().getColumnModel().getColumn(4).setMaxWidth(85);
        frm.getTabelaPedido().getColumnModel().getColumn(4).setMinWidth(85);
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
        frm.getItemMenuDeslogar().addActionListener(this);
        frm.getItemMenuFecharCaixa().addActionListener(this);
        frm.getItemMenuFuncionarios().addActionListener(this);
        frm.getItemMenuIngredientes().addActionListener(this);
        frm.getItemMenuProdutos().addActionListener(this);
        frm.getItemMenuRetiradaDeCaixa().addActionListener(this);
        frm.getItemMenuSair().addActionListener(this);
        frm.getItemMenuSobre().addActionListener(this);
        frm.getItemMenuTrocarSenha().addActionListener(this);
        frm.getItemMenuVendasPorPeriodo().addActionListener(this);
        frm.getItemMenuFormaPagamento().addActionListener(this);
        frm.getCampoAdicionarItem().addActionListener(this);
        frm.getItemMenuVendasFiltradasFormaPgto().addActionListener(this);
        frm.getItemMenuVendasFiltradasIngredientes().addActionListener(this);
        frm.getItemMenuCancelarCupom().addActionListener(this);
        frm.getItemMenuVisualizarCaixas().addActionListener(this);
        frm.getItemMenuReimprimirCupom().addActionListener(this);
    }

    public void caixaAberto() {
        frm.getBotaoCaixa().setText("Fechar Caixa");
        frm.getItemMenuAbrirCaixa().setEnabled(false);
        frm.getItemMenuFecharCaixa().setEnabled(true);
        frm.getItemMenuRetiradaDeCaixa().setEnabled(true);
        frm.getItemMenuCancelarCupom().setEnabled(true);

        frm.getCampoAdicionarItem().setEnabled(true);
        frm.getCampoBusca().setEnabled(true);

        frm.getBotaoAdicionarAoPedido().setEnabled(true);
        frm.getBotaoAdicionarItem().setEnabled(true);
        frm.getBotaoBuscar().setEnabled(true);
        frm.getBotaoCancelarPedido().setEnabled(true);
        frm.getBotaoExcluirItem().setEnabled(true);
        frm.getBotaoFecharPedido().setEnabled(true);

        frm.getTabelaBusca().setEnabled(true);
        frm.getTabelaPedido().setEnabled(true);
    }

    public void caixaFechado() {
        frm.getBotaoCaixa().setText("Abrir Caixa");
        frm.getItemMenuAbrirCaixa().setEnabled(true);
        frm.getItemMenuFecharCaixa().setEnabled(false);
        frm.getItemMenuRetiradaDeCaixa().setEnabled(false);
        frm.getItemMenuCancelarCupom().setEnabled(false);

        frm.getCampoAdicionarItem().setEnabled(false);
        frm.getCampoBusca().setEnabled(false);

        frm.getBotaoAdicionarAoPedido().setEnabled(false);
        frm.getBotaoAdicionarItem().setEnabled(false);
        frm.getBotaoBuscar().setEnabled(false);
        frm.getBotaoCancelarPedido().setEnabled(false);
        frm.getBotaoExcluirItem().setEnabled(false);
        frm.getBotaoFecharPedido().setEnabled(false);

        frm.getTabelaBusca().setEnabled(false);
        frm.getTabelaPedido().setEnabled(false);
    }

    private void abrirCaixa() {
        if (indexCaixa == null) {
            Caixa caixa = novoCaixa();
            if (caixa != null) {
                new DAO<>(Caixa.class).adiciona(caixa);//atualiza(caixa);
                numeroPedidoVerificado = true;
                frm.getFuncionario().getCaixas().add(caixa);
                indexCaixa = frm.getFuncionario().getCaixas().size() - 1;
                caixaAberto();
            } else {
                JOptionPane.showMessageDialog(frm, "Abertura de Caixa Cancelada!", "Abertura de Caixa", JOptionPane.WARNING_MESSAGE);
                caixaFechado();
            }
        }
    }

    private void fecharPedido() {
        if (numeroPedidoVerificado) {
            pedido.setNumPedido(numPedido);
            numPedido++;
        } else {
            pedido.setNumPedido(verificaNumeroPedido());
            numPedido++;
        }
        new TelaConfirmacaoPagamento(frm, true, frm.getFuncionario(), pedido, indexCaixa, totalPedido).setVisible(true);
        if (TelaConfirmacaoPagamento.isCadastrou()) {
            TelaConfirmacaoPagamento.setCadastrou(false);
            frm.getFuncionario().getCaixas().set(indexCaixa, TelaConfirmacaoPagamento.getCaixa());
            limparPedido();
        } else {
            //JOptionPane.show(frm, ""); Mensagem perguntando se deseja limpar o pedido
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
            if (pedido.getItempedidos().get(i).getProduto().getIdProd() == itempedido.getProduto().getIdProd()) {
                totalPedido = totalPedido - pedido.getItempedidos().get(i).getTotProd();
                if (itempedido.getQtdProd() == 0) {
                    if (pedido.getItempedidos().size() == 1) {
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
        pedido.getItempedidos().add(itempedido);
    }

    private void adicionaItempedido() throws NullPointerException {
        Produto produto = new Produto();
        Itempedido itempedido = new Itempedido();
        ItempedidoPK itempedidoPK = new ItempedidoPK();
        String padrao = "[0-9]{1,2}";

        produto.setIdProd(Integer.valueOf(frm.getCampoAdicionarItem().getText()));
        produto = new DAO<>(Produto.class).buscaPorId(produto.getIdProd());
        itempedido.setProduto(produto);
        itempedidoPK.setIdProd(produto.getIdProd());
        itempedido.setId(itempedidoPK);
        itempedido.setQtdProd(-1);
        while (itempedido.getQtdProd() == -1) {
            String aux = JOptionPane.showInputDialog(frm ,"Digite a Quantidade", 1);
            if (aux == null) {
                return;
            } else if (aux.matches(padrao)) {
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
        atualizaTableModelVenda();
        totalPedido = 0;
        atualizaTotal();
        atualizaTableModelVenda();
    }

    public void removerItem() {
        if (pedido.getItempedidos().size() == 1) {
            limparPedido();
        } else if (frm.getTabelaPedido().getSelectedRow() != -1) {
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
        String padrao = "[0-9]{1,3}";
        String msg = "Digite o valor do fundo de caixa";
        while (caixa.getFundoCaixa() == 0) {
            String aux = JOptionPane.showInputDialog(frm, msg, "Fundo de Caixa", JOptionPane.INFORMATION_MESSAGE);
            if (aux == null) {
                return null;
            } else if (aux.matches(padrao)) {
                caixa.setFundoCaixa(Double.valueOf(aux));
            } else {
                msg = "Digite o valor do fundo de caixa, Ex.: 80";
            }
        }
        caixa.setTotalCaixa(0);
        return caixa;
    }

    public boolean fecharCaixa(Integer index) {
        new TelaFechamentoCaixa(frm, true, frm.getFuncionario().getCaixas().get(index).getIdCaixa()).setVisible(true);
        if (TelaFechamentoCaixa.isFechou()) {
            JOptionPane.showMessageDialog(frm, "Caixa Fechado com Sucesso!", "Fechamento de Caixa", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
    }

    public Integer verificaCaixa() {
        byte x = 1;
        String dataStr = geraDataStr();
        for (int i = 0; frm.getFuncionario().getCaixas().size() > i; i++) {
            if (frm.getFuncionario().getCaixas().get(i).getEstaAberto() == x) {
                if (String.valueOf(frm.getFuncionario().getCaixas().get(i).getDataAberturaCaixa()).equals(dataStr)) {
                    caixaAberto();
                    return i;
                } else {
                    JOptionPane.showMessageDialog(frm, "Você possui um caixa aberto com data anterior ao dia de hoje. \nPor favor, clique em OK para fechar o caixa anterior", "Caixa anterior encontrado", JOptionPane.WARNING_MESSAGE);
                    while (!TelaFechamentoCaixa.isFechou()) {
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
            for (int i = 0; frm.getFuncionario().getCaixas().get(indexCaixa).getPedidos().size() > i; i++) {
                if (frm.getFuncionario().getCaixas().get(indexCaixa).getPedidos().get(i).getNumPedido() >= numPedido) {
                    numPedido = frm.getFuncionario().getCaixas().get(indexCaixa).getPedidos().get(i).getNumPedido();
                    numPedido++;
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
        if ("0".equals(frm.getCampoAdicionarItem().getText())) {
            valida = false;
            JOptionPane.showMessageDialog(frm, "Insira o ID do produto para adiciona-lo ao pedido.", "Inserir ID", JOptionPane.INFORMATION_MESSAGE);
        }
        if ("".equals(frm.getCampoAdicionarItem().getText())) {
            if (validaPedido()) {
                fecharPedido();
            }
            valida = false;
        }
        return valida;
    }

    public boolean validaDelItem() {
        boolean valida = true;
        if (frm.getTabelaPedido().getSelectedRow() == -1) {
            valida = false;
            JOptionPane.showMessageDialog(frm, "Selecione um item para remover!", "Selecione um item", JOptionPane.INFORMATION_MESSAGE);
        }
        return valida;
    }

    public boolean validaPedido() {
        boolean valida = true;
        if (frm.getTabelaPedido().getRowCount() == 0) {
            valida = false;
            JOptionPane.showMessageDialog(frm, "É necessário ao menos um item no pedido para concluí-lo!", "Pedido sem Itens", JOptionPane.WARNING_MESSAGE);
        }
        return valida;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Adicionar Item":
                if (validaAddItem()) {
                    try {
                        atualizaTableModelVenda();
                        adicionaItempedido();
                    } catch (NullPointerException e) {
                        JOptionPane.showMessageDialog(frm, "Este código é inválido. Por favor, insira um código válido.", "Código Inválido", JOptionPane.WARNING_MESSAGE);
                        frm.getCampoAdicionarItem().setText("");
                    }
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
            case "Abrir Caixa":
                abrirCaixa();
                break;
            case "Fechar Pedido":
                if (validaPedido()) {
                    fecharPedido();
                }
                break;
            case "Cancelar Pedido":
                limparPedido();
                break;
            case "Cancelar Cupom":
                new TelaCancelamento(frm, true, frm.getFuncionario().getCaixas().get(indexCaixa).getIdCaixa()).setVisible(true);
                new DAO<>(Caixa.class).atualiza(frm.getFuncionario().getCaixas().get(indexCaixa));
                break;
            case "Reimprimir Cupom":
                new TelaReimpressao(frm, true, frm.getFuncionario().getCaixas().get(indexCaixa).getIdCaixa()).setVisible(true);
                break;
            case "Reimprimir Relatório de Caixa":
                new TelaReimprimirRelatorio(frm, true).setVisible(true);
                break;
            case "Deslogar":
                deslogar();
                break;
            case "Formas de Pagamento":
                new TelaCadastrarFormasDePagamento(frm, true).setVisible(true);
                break;
            case "Funcionários":
                new TelaCadastrarFuncionario(frm, true).setVisible(true);
                break;
            case "Ingredientes":
                new TelaCadastrarIngrediente(frm, true).setVisible(true);
                break;
            case "Produtos":
                new TelaCadastrarProduto(frm, true).setVisible(true);
                frm.getBotaoBuscar().doClick();
                break;
            case "Vendas Gerais":
                new TelaVendasGerais(frm, true).setVisible(true);
                break;
            case "Retirada de Caixa":
                new TelaRetirada(frm, true, frm.getFuncionario().getCaixas().get(indexCaixa)).setVisible(true);
                break;
            case "Vendas por  Forma de Pagamento":
                new TelaVendasPorFormaPgto(frm, true).setVisible(true);
                break;
            case "Vendas por Ingredientes":
                new TelaVendasPorIngrediente(frm, true).setVisible(true);
                break;
            case "Sobre":
                new TelaSobre(frm, true).setVisible(true);
                break;
            case "Sair":
                System.exit(1);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (frm.getTabelaPedido().getSelectedRow() != -1) {
            Itempedido itempedido = tableModelVenda.getItemspedido().get(frm.getTabelaPedido().getSelectedRow());
            vendaToForm(itempedido);
            
        }
        frm.getCampoAdicionarItem().requestFocus();
    }
}