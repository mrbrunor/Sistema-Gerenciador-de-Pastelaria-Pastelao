/*
 * The MIT License
 *
 * Copyright 2014 Tiago.
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

import com.au.gui.listener.TabelaPesquisaActionListener;
import com.au.gui.listener.VendaActionListener;
import com.au.modelo.Caixa;
import com.au.modelo.Funcionario;
import com.au.util.Clock;
import com.au.util.LimitaDigitos;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Tiago
 */
public class TelaVenda extends javax.swing.JFrame {
    private Caixa caixa;
    private Funcionario funcionario;
    private final VendaActionListener listener;
    private final TabelaPesquisaActionListener listener2;
    

    /**
     * Creates new form TelaVenda
     * @param funcionario
     */
    public TelaVenda(Funcionario funcionario) {
        this.funcionario = funcionario;
        initComponents();
        campoBusca.setDocument(new LimitaDigitos((250), "[^a-zA-Z À-ÄÈ-ËÌ-ÏÒ-ÖÙ-Üà-äè-ëì-ïò-öù-ü0-9]"));
        campoAdicionarItem.setDocument(new LimitaDigitos((6), "[^0-9]"));
        textoNomeFuncionario.setText(funcionario.getNomeFunc());
        listener = new VendaActionListener(this);
        listener2 = new TabelaPesquisaActionListener(this);
        this.setExtendedState(this.MAXIMIZED_BOTH); 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelSuperior = new javax.swing.JPanel();
        textoFotoFuncionario = new javax.swing.JLabel();
        textoNomeFuncionario = new javax.swing.JLabel();
        textoData = new javax.swing.JLabel();
        textoHora = new javax.swing.JLabel();
        Thread t = new Clock(textoHora);
        t.start();
        botaoAlternarUsuario = new javax.swing.JButton();
        botaoCaixa = new javax.swing.JButton();
        painelPedido = new javax.swing.JPanel();
        textoDigiteParaAdicionar = new javax.swing.JLabel();
        botaoAdicionarItem = new javax.swing.JButton();
        campoAdicionarItem = new javax.swing.JTextField();
        campoAdicionarItem.setActionCommand("Adicionar Item");
        botaoFecharPedido = new javax.swing.JButton();
        botaoCancelarPedido = new javax.swing.JButton();
        painelScrollTabelaPedido = new javax.swing.JScrollPane();
        tabelaPedido = new javax.swing.JTable();
        botaoExcluirItem = new javax.swing.JButton();
        textoValorTotal = new javax.swing.JLabel();
        painelBusca = new javax.swing.JPanel();
        textoDigiteParaBuscar = new javax.swing.JLabel();
        campoBusca = new javax.swing.JTextField();
        botaoBuscar = new javax.swing.JButton();
        painelScrollTabelaBusca = new javax.swing.JScrollPane();
        tabelaBusca = new javax.swing.JTable();
        botaoAdicionarAoPedido = new javax.swing.JButton();
        barraMenu = new javax.swing.JMenuBar();
        menuPrincipal = new javax.swing.JMenu();
        itemMenuAbrirCaixa = new javax.swing.JMenuItem();
        itemMenuFecharCaixa = new javax.swing.JMenuItem();
        itemMenuCancelarCupom = new javax.swing.JMenuItem();
        itemMenuRetiradaDeCaixa = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemMenuTrocarSenha = new javax.swing.JMenuItem();
        itemMenuDeslogar = new javax.swing.JMenuItem();
        itemMenuSair = new javax.swing.JMenuItem();
        menuCadastros = new javax.swing.JMenu();
        itemMenuFormaPagamento = new javax.swing.JMenuItem();
        itemMenuFuncionarios = new javax.swing.JMenuItem();
        itemMenuIngredientes = new javax.swing.JMenuItem();
        itemMenuProdutos = new javax.swing.JMenuItem();
        MenuRelatorio = new javax.swing.JMenu();
        itemMenuVendasGerais = new javax.swing.JMenuItem();
        itemMenuVendasFiltradasFormaPgto = new javax.swing.JMenuItem();
        itemMenuVendasFiltradasIngredientes = new javax.swing.JMenuItem();
        MenuAjuda = new javax.swing.JMenu();
        itemMenuSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Pastelão - Vendas");

        painelSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textoFotoFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/user-64.png"))); // NOI18N

        textoNomeFuncionario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        textoNomeFuncionario.setText("Nome do Funcionário");

        textoData.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        textoData.setText("DATA");
        textoData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        textoHora.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        textoHora.setText("HORA");

        botaoAlternarUsuario.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        botaoAlternarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/logout-32.png"))); // NOI18N
        botaoAlternarUsuario.setText("Deslogar");

        botaoCaixa.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        botaoCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/moneybox-32.png"))); // NOI18N
        botaoCaixa.setText("Abrir Caixa");
        botaoCaixa.setToolTipText("Clique aqui para fechar o caixa");

        javax.swing.GroupLayout painelSuperiorLayout = new javax.swing.GroupLayout(painelSuperior);
        painelSuperior.setLayout(painelSuperiorLayout);
        painelSuperiorLayout.setHorizontalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoFotoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelSuperiorLayout.createSequentialGroup()
                        .addComponent(textoNomeFuncionario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textoData))
                    .addGroup(painelSuperiorLayout.createSequentialGroup()
                        .addComponent(botaoAlternarUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCaixa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textoHora)))
                .addContainerGap())
        );
        painelSuperiorLayout.setVerticalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelSuperiorLayout.createSequentialGroup()
                        .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoData)
                            .addComponent(textoNomeFuncionario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoHora)
                            .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botaoAlternarUsuario)
                                .addComponent(botaoCaixa)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(textoFotoFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        painelPedido.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pedido"));

        textoDigiteParaAdicionar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoDigiteParaAdicionar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoDigiteParaAdicionar.setText("Digite o código do produto para inserir no pedido:");

        botaoAdicionarItem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoAdicionarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/add_list-26.png"))); // NOI18N
        botaoAdicionarItem.setText("Adicionar Item");
        botaoAdicionarItem.setToolTipText("Clique aqui para adicionar o produto ao pedido");

        campoAdicionarItem.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        botaoFecharPedido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoFecharPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/ok-32.png"))); // NOI18N
        botaoFecharPedido.setText("Fechar Pedido");
        botaoFecharPedido.setToolTipText("Clique aqui para finalizar o pedido e selecionar a forma de pagamento");

        botaoCancelarPedido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoCancelarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/cancel-32.png"))); // NOI18N
        botaoCancelarPedido.setText("Cancelar Pedido");
        botaoCancelarPedido.setToolTipText("Clique aqui para cancelar o pedido atual");

        tabelaPedido.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tabelaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição", "Valor Unitario", "Quantidade", "Valor Total"
            }
        ));
        painelScrollTabelaPedido.setViewportView(tabelaPedido);
        if (tabelaPedido.getColumnModel().getColumnCount() > 0) {
            tabelaPedido.getColumnModel().getColumn(0).setMaxWidth(35);
            tabelaPedido.getColumnModel().getColumn(2).setMaxWidth(75);
            tabelaPedido.getColumnModel().getColumn(3).setMaxWidth(75);
            tabelaPedido.getColumnModel().getColumn(4).setMaxWidth(75);
        }

        botaoExcluirItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/minus-26.png"))); // NOI18N
        botaoExcluirItem.setToolTipText("Clique aqui para excluir este item do pedido");
        botaoExcluirItem.setActionCommand("Remover Item");

        textoValorTotal.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        textoValorTotal.setText("Valor Total: 0,00");

        javax.swing.GroupLayout painelPedidoLayout = new javax.swing.GroupLayout(painelPedido);
        painelPedido.setLayout(painelPedidoLayout);
        painelPedidoLayout.setHorizontalGroup(
            painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPedidoLayout.createSequentialGroup()
                        .addComponent(textoDigiteParaAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoAdicionarItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoAdicionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelPedidoLayout.createSequentialGroup()
                        .addComponent(painelScrollTabelaPedido)
                        .addGap(18, 18, 18)
                        .addComponent(botaoExcluirItem))
                    .addGroup(painelPedidoLayout.createSequentialGroup()
                        .addComponent(textoValorTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(botaoCancelarPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoFecharPedido)))
                .addContainerGap())
        );
        painelPedidoLayout.setVerticalGroup(
            painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoDigiteParaAdicionar)
                    .addComponent(campoAdicionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAdicionarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelScrollTabelaPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addGroup(painelPedidoLayout.createSequentialGroup()
                        .addComponent(botaoExcluirItem)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoFecharPedido)
                    .addComponent(botaoCancelarPedido)
                    .addComponent(textoValorTotal))
                .addContainerGap())
        );

        painelPedidoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botaoAdicionarItem, botaoCancelarPedido, botaoFecharPedido});

        painelBusca.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Busca"));

        textoDigiteParaBuscar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoDigiteParaBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoDigiteParaBuscar.setText("Digite o nome do produto para buscar:");

        campoBusca.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        botaoBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/search-26.png"))); // NOI18N
        botaoBuscar.setText("Buscar");
        botaoBuscar.setToolTipText("Clique aqui para buscar");

        tabelaBusca.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tabelaBusca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição", "Valor"
            }
        ));
        painelScrollTabelaBusca.setViewportView(tabelaBusca);
        if (tabelaBusca.getColumnModel().getColumnCount() > 0) {
            tabelaBusca.getColumnModel().getColumn(0).setMaxWidth(35);
            tabelaBusca.getColumnModel().getColumn(2).setMaxWidth(75);
        }

        botaoAdicionarAoPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/plus-26.png"))); // NOI18N
        botaoAdicionarAoPedido.setToolTipText("Clique aqui para adicionar este item ao pedido");
        botaoAdicionarAoPedido.setActionCommand("Adicionar Item");

        javax.swing.GroupLayout painelBuscaLayout = new javax.swing.GroupLayout(painelBusca);
        painelBusca.setLayout(painelBuscaLayout);
        painelBuscaLayout.setHorizontalGroup(
            painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelBuscaLayout.createSequentialGroup()
                        .addComponent(painelScrollTabelaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoAdicionarAoPedido))
                    .addGroup(painelBuscaLayout.createSequentialGroup()
                        .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoBusca)
                            .addComponent(textoDigiteParaBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoBuscar)))
                .addContainerGap())
        );
        painelBuscaLayout.setVerticalGroup(
            painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBuscaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelBuscaLayout.createSequentialGroup()
                        .addComponent(textoDigiteParaBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botaoBuscar))
                .addGap(18, 18, 18)
                .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelScrollTabelaBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addGroup(painelBuscaLayout.createSequentialGroup()
                        .addComponent(botaoAdicionarAoPedido)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        botaoAdicionarAoPedido.getAccessibleContext().setAccessibleName("teste");

        barraMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        menuPrincipal.setText("Principal");
        menuPrincipal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        itemMenuAbrirCaixa.setText("Abrir Caixa");
        menuPrincipal.add(itemMenuAbrirCaixa);

        itemMenuFecharCaixa.setText("Fechar Caixa");
        menuPrincipal.add(itemMenuFecharCaixa);

        itemMenuCancelarCupom.setText("Cancelar Cupom");
        menuPrincipal.add(itemMenuCancelarCupom);

        itemMenuRetiradaDeCaixa.setText("Retirada de Caixa");
        menuPrincipal.add(itemMenuRetiradaDeCaixa);
        menuPrincipal.add(jSeparator1);

        itemMenuTrocarSenha.setText("Trocar Senha");
        menuPrincipal.add(itemMenuTrocarSenha);

        itemMenuDeslogar.setText("Deslogar");
        menuPrincipal.add(itemMenuDeslogar);

        itemMenuSair.setText("Sair");
        menuPrincipal.add(itemMenuSair);

        barraMenu.add(menuPrincipal);

        menuCadastros.setText("Cadastros");
        menuCadastros.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        itemMenuFormaPagamento.setText("Formas de Pagamento");
        menuCadastros.add(itemMenuFormaPagamento);

        itemMenuFuncionarios.setText("Funcionários");
        menuCadastros.add(itemMenuFuncionarios);

        itemMenuIngredientes.setText("Ingredientes");
        menuCadastros.add(itemMenuIngredientes);

        itemMenuProdutos.setText("Produtos");
        menuCadastros.add(itemMenuProdutos);

        barraMenu.add(menuCadastros);

        MenuRelatorio.setText("Relatórios");
        MenuRelatorio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        itemMenuVendasGerais.setText("Vendas Gerais");
        MenuRelatorio.add(itemMenuVendasGerais);

        itemMenuVendasFiltradasFormaPgto.setText("Vendas por  Forma de Pagamento");
        MenuRelatorio.add(itemMenuVendasFiltradasFormaPgto);

        itemMenuVendasFiltradasIngredientes.setText("Vendas por Ingredientes");
        MenuRelatorio.add(itemMenuVendasFiltradasIngredientes);

        barraMenu.add(MenuRelatorio);

        MenuAjuda.setText("Ajuda");
        MenuAjuda.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        itemMenuSobre.setText("Sobre");
        MenuAjuda.add(itemMenuSobre);

        barraMenu.add(MenuAjuda);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setItemMenuCancelarCupom(JMenuItem itemMenuCancelarCupom) {
        this.itemMenuCancelarCupom = itemMenuCancelarCupom;
    }

    public JMenuItem getItemMenuCancelarCupom() {
        return itemMenuCancelarCupom;
    }

    public JMenu getMenuAjuda() {
        return MenuAjuda;
    }

    public void setMenuAjuda(JMenu MenuAjuda) {
        this.MenuAjuda = MenuAjuda;
    }

    public JMenu getMenuRelatorio() {
        return MenuRelatorio;
    }

    public void setMenuRelatorio(JMenu MenuRelatorio) {
        this.MenuRelatorio = MenuRelatorio;
    }

    public JMenu getMenuCadastros() {
        return menuCadastros;
    }

    public void setMenuCadastros(JMenu menuCadastros) {
        this.menuCadastros = menuCadastros;
    }

    public JMenu getMenuPrincipal() {
        return menuPrincipal;
    }

    public void setMenuPrincipal(JMenu menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
    }

    public JMenuItem getItemMenuFormaPagamento() {
        return itemMenuFormaPagamento;
    }

    public void setItemMenuFormaPagamento(JMenuItem itemMenuFormaPagamento) {
        this.itemMenuFormaPagamento = itemMenuFormaPagamento;
    }

    public JLabel getTextoData() {
        return textoData;
    }

    public void setTextoData(JLabel textoData) {
        this.textoData = textoData;
    }

    
    
    public JMenuItem getItemMenuAbrirCaixa() {
        return itemMenuAbrirCaixa;
    }

    public void setItemMenuAbrirCaixa(JMenuItem itemMenuAbrirCaixa) {
        this.itemMenuAbrirCaixa = itemMenuAbrirCaixa;
    }


    public JMenuItem getItemMenuDeslogar() {
        return itemMenuDeslogar;
    }

    public void setItemMenuDeslogar(JMenuItem itemMenuDeslogar) {
        this.itemMenuDeslogar = itemMenuDeslogar;
    }

    public JMenuItem getItemMenuFecharCaixa() {
        return itemMenuFecharCaixa;
    }

    public void setItemMenuFecharCaixa(JMenuItem itemMenuFecharCaixa) {
        this.itemMenuFecharCaixa = itemMenuFecharCaixa;
    }

    public JMenuItem getItemMenuFuncionarios() {
        return itemMenuFuncionarios;
    }

    public void setItemMenuFuncionarios(JMenuItem itemMenuFuncionarios) {
        this.itemMenuFuncionarios = itemMenuFuncionarios;
    }

    public JMenuItem getItemMenuIngredientes() {
        return itemMenuIngredientes;
    }

    public void setItemMenuIngredientes(JMenuItem itemMenuIngredientes) {
        this.itemMenuIngredientes = itemMenuIngredientes;
    }

    public JMenuItem getItemMenuProdutos() {
        return itemMenuProdutos;
    }

    public void setItemMenuProdutos(JMenuItem itemMenuProdutos) {
        this.itemMenuProdutos = itemMenuProdutos;
    }

    public JMenuItem getItemMenuRetiradaDeCaixa() {
        return itemMenuRetiradaDeCaixa;
    }

    public void setItemMenuRetiradaDeCaixa(JMenuItem itemMenuRetiradaDeCaixa) {
        this.itemMenuRetiradaDeCaixa = itemMenuRetiradaDeCaixa;
    }

    public JMenuItem getItemMenuSair() {
        return itemMenuSair;
    }

    public void setItemMenuSair(JMenuItem itemMenuSair) {
        this.itemMenuSair = itemMenuSair;
    }

    public JMenuItem getItemMenuSobre() {
        return itemMenuSobre;
    }

    public void setItemMenuSobre(JMenuItem itemMenuSobre) {
        this.itemMenuSobre = itemMenuSobre;
    }

    public JMenuItem getItemMenuTrocarSenha() {
        return itemMenuTrocarSenha;
    }

    public void setItemMenuTrocarSenha(JMenuItem itemMenuTrocarSenha) {
        this.itemMenuTrocarSenha = itemMenuTrocarSenha;
    }

    public JLabel getTextoValorTotal() {
        return textoValorTotal;
    }

    public void setTextoValorTotal(JLabel textoValorTotal) {
        this.textoValorTotal = textoValorTotal;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public JButton getBotaoAdicionarAoPedido() {
        return botaoAdicionarAoPedido;
    }

    public void setBotaoAdicionarAoPedido(JButton botaoAdicionarAoPedido) {
        this.botaoAdicionarAoPedido = botaoAdicionarAoPedido;
    }

    public JButton getBotaoAdicionarItem() {
        return botaoAdicionarItem;
    }

    public void setBotaoAdicionarItem(JButton botaoAdicionarItem) {
        this.botaoAdicionarItem = botaoAdicionarItem;
    }

    public JButton getBotaoAlternarUsuario() {
        return botaoAlternarUsuario;
    }

    public void setBotaoAlternarUsuario(JButton botaoAlternarUsuario) {
        this.botaoAlternarUsuario = botaoAlternarUsuario;
    }

    public JButton getBotaoBuscar() {
        return botaoBuscar;
    }

    public void setBotaoBuscar(JButton botaoBuscar) {
        this.botaoBuscar = botaoBuscar;
    }

    public JButton getBotaoCancelarPedido() {
        return botaoCancelarPedido;
    }

    public void setBotaoCancelarPedido(JButton botaoCancelarPedido) {
        this.botaoCancelarPedido = botaoCancelarPedido;
    }

    public JButton getBotaoExcluirItem() {
        return botaoExcluirItem;
    }

    public void setBotaoExcluirItem(JButton botaoExcluirItem) {
        this.botaoExcluirItem = botaoExcluirItem;
    }

    public JButton getBotaoCaixa() {
        return botaoCaixa;
    }

    public void setBotaoCaixa(JButton botaoFecharCaixa) {
        this.botaoCaixa = botaoFecharCaixa;
    }

    public JButton getBotaoFecharPedido() {
        return botaoFecharPedido;
    }

    public void setBotaoFecharPedido(JButton botaoFecharPedido) {
        this.botaoFecharPedido = botaoFecharPedido;
    }

    public JTextField getCampoAdicionarItem() {
        return campoAdicionarItem;
    }

    public void setCampoAdicionarItem(JTextField campoAdicionarItem) {
        this.campoAdicionarItem = campoAdicionarItem;
    }

    public JTextField getCampoBusca() {
        return campoBusca;
    }

    public void setCampoBusca(JTextField campoBusca) {
        this.campoBusca = campoBusca;
    }

    public JTable getTabelaBusca() {
        return tabelaBusca;
    }

    public void setTabelaBusca(JTable tabelaBusca) {
        this.tabelaBusca = tabelaBusca;
    }

    public JTable getTabelaPedido() {
        return tabelaPedido;
    }

    public void setTabelaPedido(JTable tabelaPedido) {
        this.tabelaPedido = tabelaPedido;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public JMenuItem getItemMenuVendasPorPeriodo() {
        return itemMenuVendasGerais;
    }

    public void setItemMenuVendasPorPeriodo(JMenuItem itemMenuVendasPorPeriodo) {
        this.itemMenuVendasGerais = itemMenuVendasPorPeriodo;
    }

    public JMenuItem getItemMenuVendasFiltradasFormaPgto() {
        return itemMenuVendasFiltradasFormaPgto;
    }

    public void setItemMenuVendasFiltradasFormaPgto(JMenuItem itemMenuVendasFiltradasFormaPgto) {
        this.itemMenuVendasFiltradasFormaPgto = itemMenuVendasFiltradasFormaPgto;
    }

    public JMenuItem getItemMenuVendasFiltradasIngredientes() {
        return itemMenuVendasFiltradasIngredientes;
    }

    public void setItemMenuVendasFiltradasIngredientes(JMenuItem itemMenuVendasFiltradasIngredientes) {
        this.itemMenuVendasFiltradasIngredientes = itemMenuVendasFiltradasIngredientes;
    }

    public JMenuItem getItemMenuVendasGerais() {
        return itemMenuVendasGerais;
    }

    public void setItemMenuVendasGerais(JMenuItem itemMenuVendasGerais) {
        this.itemMenuVendasGerais = itemMenuVendasGerais;
    }
    
       
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Windows look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TelaVenda().setVisible(true);
//            }
//        }); 
//     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuAjuda;
    private javax.swing.JMenu MenuRelatorio;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton botaoAdicionarAoPedido;
    private javax.swing.JButton botaoAdicionarItem;
    private javax.swing.JButton botaoAlternarUsuario;
    private javax.swing.JButton botaoBuscar;
    private javax.swing.JButton botaoCaixa;
    private javax.swing.JButton botaoCancelarPedido;
    private javax.swing.JButton botaoExcluirItem;
    private javax.swing.JButton botaoFecharPedido;
    private javax.swing.JTextField campoAdicionarItem;
    private javax.swing.JTextField campoBusca;
    private javax.swing.JMenuItem itemMenuAbrirCaixa;
    private javax.swing.JMenuItem itemMenuCancelarCupom;
    private javax.swing.JMenuItem itemMenuDeslogar;
    private javax.swing.JMenuItem itemMenuFecharCaixa;
    private javax.swing.JMenuItem itemMenuFormaPagamento;
    private javax.swing.JMenuItem itemMenuFuncionarios;
    private javax.swing.JMenuItem itemMenuIngredientes;
    private javax.swing.JMenuItem itemMenuProdutos;
    private javax.swing.JMenuItem itemMenuRetiradaDeCaixa;
    private javax.swing.JMenuItem itemMenuSair;
    private javax.swing.JMenuItem itemMenuSobre;
    private javax.swing.JMenuItem itemMenuTrocarSenha;
    private javax.swing.JMenuItem itemMenuVendasFiltradasFormaPgto;
    private javax.swing.JMenuItem itemMenuVendasFiltradasIngredientes;
    private javax.swing.JMenuItem itemMenuVendasGerais;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenu menuPrincipal;
    private javax.swing.JPanel painelBusca;
    private javax.swing.JPanel painelPedido;
    private javax.swing.JScrollPane painelScrollTabelaBusca;
    private javax.swing.JScrollPane painelScrollTabelaPedido;
    private javax.swing.JPanel painelSuperior;
    private javax.swing.JTable tabelaBusca;
    private javax.swing.JTable tabelaPedido;
    private javax.swing.JLabel textoData;
    private javax.swing.JLabel textoDigiteParaAdicionar;
    private javax.swing.JLabel textoDigiteParaBuscar;
    private javax.swing.JLabel textoFotoFuncionario;
    private javax.swing.JLabel textoHora;
    private javax.swing.JLabel textoNomeFuncionario;
    private javax.swing.JLabel textoValorTotal;
    // End of variables declaration//GEN-END:variables
}
