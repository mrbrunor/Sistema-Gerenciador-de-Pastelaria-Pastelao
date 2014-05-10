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
import javax.swing.JButton;
import javax.swing.JLabel;
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
        textoNomeFuncionario.setText(funcionario.getNomeFunc());
        listener = new VendaActionListener(this);
        listener2 = new TabelaPesquisaActionListener(this);
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
        botaoAlternarUsuario = new javax.swing.JButton();
        botaoCaixa = new javax.swing.JButton();
        painelPedido = new javax.swing.JPanel();
        textoDigiteParaAdicionar = new javax.swing.JLabel();
        botaoAdicionarItem = new javax.swing.JButton();
        campoAdicionarItem = new javax.swing.JTextField();
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
        itemMenuRetiradaDeCaixa = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemMenuTrocarSenha = new javax.swing.JMenuItem();
        itemMenuDeslogar = new javax.swing.JMenuItem();
        itemMenuSair = new javax.swing.JMenuItem();
        menuCadastros = new javax.swing.JMenu();
        itemMenuDespesas = new javax.swing.JMenuItem();
        itemMenuFornecedores = new javax.swing.JMenuItem();
        itemMenuFuncionarios = new javax.swing.JMenuItem();
        itemMenuIngredientes = new javax.swing.JMenuItem();
        itemMenuNotasFiscais = new javax.swing.JMenuItem();
        itemMenuProdutos = new javax.swing.JMenuItem();
        MenuRelatorio = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        MenuAjuda = new javax.swing.JMenu();
        itemMenuAjuda = new javax.swing.JMenuItem();
        itemMenuTeclasAtalho = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itemMenuSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Pastelão - Vendas");

        painelSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textoFotoFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/user-64.png"))); // NOI18N

        textoNomeFuncionario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        textoNomeFuncionario.setText("Nome do Funcionário");

        textoData.setText("DATA");
        textoData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        textoHora.setText("HORA");

        botaoAlternarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/logout-32.png"))); // NOI18N
        botaoAlternarUsuario.setText("Deslogar");

        botaoCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/moneybox-32.png"))); // NOI18N
        botaoCaixa.setText("Abre Caixa");
        botaoCaixa.setToolTipText("Clique aqui para fechar o caixa");

        javax.swing.GroupLayout painelSuperiorLayout = new javax.swing.GroupLayout(painelSuperior);
        painelSuperior.setLayout(painelSuperiorLayout);
        painelSuperiorLayout.setHorizontalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoFotoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelSuperiorLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(textoNomeFuncionario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textoData))
                    .addGroup(painelSuperiorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(textoFotoFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        painelPedido.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pedido"));

        textoDigiteParaAdicionar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoDigiteParaAdicionar.setText("Digite o código do produto para inserir no pedido:");

        botaoAdicionarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/add_list-26.png"))); // NOI18N
        botaoAdicionarItem.setText("Adicionar Item");
        botaoAdicionarItem.setToolTipText("Clique aqui para adicionar o produto ao pedido");

        botaoFecharPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/ok-32.png"))); // NOI18N
        botaoFecharPedido.setText("Fechar Pedido");
        botaoFecharPedido.setToolTipText("Clique aqui para finalizar o pedido e selecionar a forma de pagamento");

        botaoCancelarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/cancel-32.png"))); // NOI18N
        botaoCancelarPedido.setText("Cancelar Pedido");
        botaoCancelarPedido.setToolTipText("Clique aqui para cancelar o pedido atual");

        tabelaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        painelScrollTabelaPedido.setViewportView(tabelaPedido);

        botaoExcluirItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/minus-26.png"))); // NOI18N
        botaoExcluirItem.setToolTipText("Clique aqui para excluir este item do pedido");
        botaoExcluirItem.setActionCommand("Remover Item");

        textoValorTotal.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        textoValorTotal.setText("Valor Total: 100,00");

        javax.swing.GroupLayout painelPedidoLayout = new javax.swing.GroupLayout(painelPedido);
        painelPedido.setLayout(painelPedidoLayout);
        painelPedidoLayout.setHorizontalGroup(
            painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPedidoLayout.createSequentialGroup()
                        .addComponent(textoDigiteParaAdicionar)
                        .addGap(18, 18, 18)
                        .addComponent(campoAdicionarItem)
                        .addGap(18, 18, 18)
                        .addComponent(botaoAdicionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelPedidoLayout.createSequentialGroup()
                        .addComponent(painelScrollTabelaPedido)
                        .addGap(18, 18, 18)
                        .addComponent(botaoExcluirItem))
                    .addGroup(painelPedidoLayout.createSequentialGroup()
                        .addComponent(textoValorTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoCancelarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoFecharPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        painelPedidoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botaoCancelarPedido, botaoFecharPedido});

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
                    .addComponent(painelScrollTabelaPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
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

        textoDigiteParaBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoDigiteParaBuscar.setText("Digite o nome do produto para buscar:");

        botaoBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/search-26.png"))); // NOI18N
        botaoBuscar.setText("Buscar");
        botaoBuscar.setToolTipText("Clique aqui para buscar");

        painelScrollTabelaBusca.setViewportView(tabelaBusca);

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
                            .addComponent(textoDigiteParaBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(botaoBuscar)))
                .addContainerGap())
        );
        painelBuscaLayout.setVerticalGroup(
            painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBuscaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelBuscaLayout.createSequentialGroup()
                        .addComponent(textoDigiteParaBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botaoBuscar))
                .addGap(18, 18, 18)
                .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelScrollTabelaBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                    .addGroup(painelBuscaLayout.createSequentialGroup()
                        .addComponent(botaoAdicionarAoPedido)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        botaoAdicionarAoPedido.getAccessibleContext().setAccessibleName("teste");

        menuPrincipal.setText("Principal");

        itemMenuAbrirCaixa.setText("Abrir Caixa");
        menuPrincipal.add(itemMenuAbrirCaixa);

        itemMenuFecharCaixa.setText("Fechar Caixa");
        menuPrincipal.add(itemMenuFecharCaixa);

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

        itemMenuDespesas.setText("Despesas");
        menuCadastros.add(itemMenuDespesas);

        itemMenuFornecedores.setText("Fornecedores");
        menuCadastros.add(itemMenuFornecedores);

        itemMenuFuncionarios.setText("Funcionários");
        menuCadastros.add(itemMenuFuncionarios);

        itemMenuIngredientes.setText("Ingredientes");
        menuCadastros.add(itemMenuIngredientes);

        itemMenuNotasFiscais.setText("Notas Fiscais");
        menuCadastros.add(itemMenuNotasFiscais);

        itemMenuProdutos.setText("Produtos");
        menuCadastros.add(itemMenuProdutos);

        barraMenu.add(menuCadastros);

        MenuRelatorio.setText("Relatórios");

        jMenuItem7.setText("jMenuItem1");
        MenuRelatorio.add(jMenuItem7);

        jMenuItem8.setText("jMenuItem1");
        MenuRelatorio.add(jMenuItem8);

        barraMenu.add(MenuRelatorio);

        MenuAjuda.setText("Ajuda");

        itemMenuAjuda.setText("Ajuda");
        MenuAjuda.add(itemMenuAjuda);

        itemMenuTeclasAtalho.setText("Teclas de Atalho");
        MenuAjuda.add(itemMenuTeclasAtalho);
        MenuAjuda.add(jSeparator2);

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
                        .addGap(18, 18, 18)
                        .addComponent(painelBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JMenuItem itemMenuAjuda;
    private javax.swing.JMenuItem itemMenuDeslogar;
    private javax.swing.JMenuItem itemMenuDespesas;
    private javax.swing.JMenuItem itemMenuFecharCaixa;
    private javax.swing.JMenuItem itemMenuFornecedores;
    private javax.swing.JMenuItem itemMenuFuncionarios;
    private javax.swing.JMenuItem itemMenuIngredientes;
    private javax.swing.JMenuItem itemMenuNotasFiscais;
    private javax.swing.JMenuItem itemMenuProdutos;
    private javax.swing.JMenuItem itemMenuRetiradaDeCaixa;
    private javax.swing.JMenuItem itemMenuSair;
    private javax.swing.JMenuItem itemMenuSobre;
    private javax.swing.JMenuItem itemMenuTeclasAtalho;
    private javax.swing.JMenuItem itemMenuTrocarSenha;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
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
