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

import com.au.gui.listener.FormaPagamentoActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author BrunoRicardo
 */
public class TelaCadastrarFormasDePagamento extends javax.swing.JDialog {
    
    private final FormaPagamentoActionListener listener;

    /**
     * Creates new form TelaCadastrarFormasDePagamento
     */
    public TelaCadastrarFormasDePagamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        listener = new FormaPagamentoActionListener(this);
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
        textoAdicionarFormaPagamento = new javax.swing.JLabel();
        textoIconeNovFormaPagamento = new javax.swing.JLabel();
        textoPreencherDados = new javax.swing.JLabel();
        painelAdicionarModificarFormasPagamento = new javax.swing.JPanel();
        textoTipo = new javax.swing.JLabel();
        textoNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        campoId = new javax.swing.JTextField();
        textoId = new javax.swing.JLabel();
        caixaTipo = new javax.swing.JComboBox();
        caixaAtivo = new javax.swing.JComboBox();
        textoAtiva = new javax.swing.JLabel();
        painelProcurarFormaPagamento = new javax.swing.JPanel();
        campoPesquisarFormapagamento = new javax.swing.JTextField();
        botaoProcurarFormaPagamento = new javax.swing.JButton();
        textoProcurarFormaPagamento = new javax.swing.JLabel();
        textoCliqueParaEditar = new javax.swing.JLabel();
        painelScrollTabela = new javax.swing.JScrollPane();
        tabelaFormasPagamento = new javax.swing.JTable();
        painelBotoes = new javax.swing.JPanel();
        botaoCancelarFormaPagamento = new javax.swing.JButton();
        botaoCadastrarFormaPagamento = new javax.swing.JButton();
        botaoLimparCampos = new javax.swing.JButton();
        botaoAtualizarFormaPagamento = new javax.swing.JButton();
        botaoExcluirFormaPagamento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textoAdicionarFormaPagamento.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        textoAdicionarFormaPagamento.setText("Adicionar Nova Forma de Pagamento");

        textoIconeNovFormaPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/bank_cards-64.png"))); // NOI18N

        textoPreencherDados.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        textoPreencherDados.setText("Preencha os dados abaixo para adicionar uma nova forma de pagamento.");

        javax.swing.GroupLayout painelSuperiorLayout = new javax.swing.GroupLayout(painelSuperior);
        painelSuperior.setLayout(painelSuperiorLayout);
        painelSuperiorLayout.setHorizontalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoIconeNovFormaPagamento)
                .addGap(18, 18, 18)
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoAdicionarFormaPagamento)
                    .addComponent(textoPreencherDados))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelSuperiorLayout.setVerticalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoIconeNovFormaPagamento)
                    .addGroup(painelSuperiorLayout.createSequentialGroup()
                        .addComponent(textoAdicionarFormaPagamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoPreencherDados)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelAdicionarModificarFormasPagamento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Adicionar/Modificar Forma de Pagamento"));

        textoTipo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoTipo.setText("Tipo Forma de Pagamento:");

        textoNome.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoNome.setText("Nome Forma de Pagamento:");

        campoNome.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        campoNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoNomeFocusGained(evt);
            }
        });

        campoId.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        campoId.setEnabled(false);

        textoId.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoId.setText("ID Forma de Pagamento:");

        caixaTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Dinheiro", "Debito", "Credito", "Vale" }));

        caixaAtivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Sim", "Não" }));

        textoAtiva.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoAtiva.setText("Ativa:");

        javax.swing.GroupLayout painelAdicionarModificarFormasPagamentoLayout = new javax.swing.GroupLayout(painelAdicionarModificarFormasPagamento);
        painelAdicionarModificarFormasPagamento.setLayout(painelAdicionarModificarFormasPagamentoLayout);
        painelAdicionarModificarFormasPagamentoLayout.setHorizontalGroup(
            painelAdicionarModificarFormasPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAdicionarModificarFormasPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAdicionarModificarFormasPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textoId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoAtiva, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelAdicionarModificarFormasPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(caixaAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caixaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        painelAdicionarModificarFormasPagamentoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {textoAtiva, textoId, textoNome, textoTipo});

        painelAdicionarModificarFormasPagamentoLayout.setVerticalGroup(
            painelAdicionarModificarFormasPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAdicionarModificarFormasPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAdicionarModificarFormasPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoId)
                    .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelAdicionarModificarFormasPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelAdicionarModificarFormasPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoTipo)
                    .addComponent(caixaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelAdicionarModificarFormasPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoAtiva)
                    .addComponent(caixaAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelProcurarFormaPagamento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Procurar Formas de Pagamento Existente"));

        campoPesquisarFormapagamento.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        campoPesquisarFormapagamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPesquisarFormapagamentoFocusGained(evt);
            }
        });

        botaoProcurarFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoProcurarFormaPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/search-26.png"))); // NOI18N
        botaoProcurarFormaPagamento.setText("Procurar");

        textoProcurarFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoProcurarFormaPagamento.setText("Procurar Forma de Pagamento:");

        textoCliqueParaEditar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoCliqueParaEditar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoCliqueParaEditar.setText("Clique na forma de pagamento desejada na lista para editá-la no painel ao lado:");

        tabelaFormasPagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição", "Tipo"
            }
        ));
        painelScrollTabela.setViewportView(tabelaFormasPagamento);
        if (tabelaFormasPagamento.getColumnModel().getColumnCount() > 0) {
            tabelaFormasPagamento.getColumnModel().getColumn(0).setMaxWidth(35);
            tabelaFormasPagamento.getColumnModel().getColumn(2).setMaxWidth(110);
        }

        javax.swing.GroupLayout painelProcurarFormaPagamentoLayout = new javax.swing.GroupLayout(painelProcurarFormaPagamento);
        painelProcurarFormaPagamento.setLayout(painelProcurarFormaPagamentoLayout);
        painelProcurarFormaPagamentoLayout.setHorizontalGroup(
            painelProcurarFormaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProcurarFormaPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelProcurarFormaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelProcurarFormaPagamentoLayout.createSequentialGroup()
                        .addComponent(textoProcurarFormaPagamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoPesquisarFormapagamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoProcurarFormaPagamento))
                    .addComponent(painelScrollTabela)
                    .addComponent(textoCliqueParaEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelProcurarFormaPagamentoLayout.setVerticalGroup(
            painelProcurarFormaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProcurarFormaPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelProcurarFormaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPesquisarFormapagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoProcurarFormaPagamento)
                    .addComponent(botaoProcurarFormaPagamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoCliqueParaEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelScrollTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );

        botaoCancelarFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoCancelarFormaPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/cancel-32.png"))); // NOI18N
        botaoCancelarFormaPagamento.setText("Cancelar Cadastro");

        botaoCadastrarFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoCadastrarFormaPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/ok-32.png"))); // NOI18N
        botaoCadastrarFormaPagamento.setText("Cadastrar Forma Pgto");

        botaoLimparCampos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/erase-32.png"))); // NOI18N
        botaoLimparCampos.setText("Limpar Campos");

        botaoAtualizarFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoAtualizarFormaPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/refresh-32.png"))); // NOI18N
        botaoAtualizarFormaPagamento.setText("Atualizar Forma Pgto");

        botaoExcluirFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoExcluirFormaPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/delete-32.png"))); // NOI18N
        botaoExcluirFormaPagamento.setText("Excluir Forma Pgto");

        javax.swing.GroupLayout painelBotoesLayout = new javax.swing.GroupLayout(painelBotoes);
        painelBotoes.setLayout(painelBotoesLayout);
        painelBotoesLayout.setHorizontalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoLimparCampos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoExcluirFormaPagamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoAtualizarFormaPagamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoCancelarFormaPagamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoCadastrarFormaPagamento)
                .addContainerGap())
        );
        painelBotoesLayout.setVerticalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelarFormaPagamento)
                    .addComponent(botaoCadastrarFormaPagamento)
                    .addComponent(botaoLimparCampos)
                    .addComponent(botaoAtualizarFormaPagamento)
                    .addComponent(botaoExcluirFormaPagamento))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(painelSuperior, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(painelAdicionarModificarFormasPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelProcurarFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(painelBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelProcurarFormaPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelAdicionarModificarFormasPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNomeFocusGained
        campoNome.selectAll();
    }//GEN-LAST:event_campoNomeFocusGained

    private void campoPesquisarFormapagamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoPesquisarFormapagamentoFocusGained
        campoPesquisarFormapagamento.selectAll();
    }//GEN-LAST:event_campoPesquisarFormapagamentoFocusGained

    public JButton getBotaoAtualizarFormaPagamento() {
        return botaoAtualizarFormaPagamento;
    }

    public void setBotaoAtualizarFormaPagamento(JButton botaoAtualizarFormaPagamento) {
        this.botaoAtualizarFormaPagamento = botaoAtualizarFormaPagamento;
    }

    public JButton getBotaoCadastrarFormaPagamento() {
        return botaoCadastrarFormaPagamento;
    }

    public void setBotaoCadastrarFormaPagamento(JButton botaoCadastrarFormaPagamento) {
        this.botaoCadastrarFormaPagamento = botaoCadastrarFormaPagamento;
    }

    public JButton getBotaoCancelarFormaPagamento() {
        return botaoCancelarFormaPagamento;
    }

    public void setBotaoCancelarFormaPagamento(JButton botaoCancelarFormaPagamento) {
        this.botaoCancelarFormaPagamento = botaoCancelarFormaPagamento;
    }

    public JButton getBotaoExcluirFormaPagamento() {
        return botaoExcluirFormaPagamento;
    }

    public void setBotaoExcluirFormaPagamento(JButton botaoExcluirFormaPagamento) {
        this.botaoExcluirFormaPagamento = botaoExcluirFormaPagamento;
    }

    public JButton getBotaoLimparCampos() {
        return botaoLimparCampos;
    }

    public void setBotaoLimparCampos(JButton botaoLimparCampos) {
        this.botaoLimparCampos = botaoLimparCampos;
    }

    public JButton getBotaoProcurarFormaPagamento() {
        return botaoProcurarFormaPagamento;
    }

    public void setBotaoProcurarFormaPagamento(JButton botaoProcurarFormaPagamento) {
        this.botaoProcurarFormaPagamento = botaoProcurarFormaPagamento;
    }

    public JComboBox getCaixaAtivo() {
        return caixaAtivo;
    }

    public void setCaixaAtivo(JComboBox caixaAtivo) {
        this.caixaAtivo = caixaAtivo;
    }

    public JComboBox getCaixaTipo() {
        return caixaTipo;
    }

    public void setCaixaTipo(JComboBox caixaTipo) {
        this.caixaTipo = caixaTipo;
    }

    public JTextField getCampoId() {
        return campoId;
    }

    public void setCampoId(JTextField campoId) {
        this.campoId = campoId;
    }

    public JTextField getCampoNome() {
        return campoNome;
    }

    public void setCampoNome(JTextField campoNome) {
        this.campoNome = campoNome;
    }

    public JTextField getCampoPesquisarFormapagamento() {
        return campoPesquisarFormapagamento;
    }

    public void setCampoPesquisarFormapagamento(JTextField campoPesquisarFormapagamento) {
        this.campoPesquisarFormapagamento = campoPesquisarFormapagamento;
    }

    public JTable getTabelaFormasPagamento() {
        return tabelaFormasPagamento;
    }

    public void setTabelaFormasPagamento(JTable tabelaFormasPagamento) {
        this.tabelaFormasPagamento = tabelaFormasPagamento;
    }
    
    public void limpaCampos(){
        campoId.setText("");
        campoNome.setText("");
        caixaAtivo.setSelectedIndex(0);
        caixaTipo.setSelectedIndex(0);
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAtualizarFormaPagamento;
    private javax.swing.JButton botaoCadastrarFormaPagamento;
    private javax.swing.JButton botaoCancelarFormaPagamento;
    private javax.swing.JButton botaoExcluirFormaPagamento;
    private javax.swing.JButton botaoLimparCampos;
    private javax.swing.JButton botaoProcurarFormaPagamento;
    private javax.swing.JComboBox caixaAtivo;
    private javax.swing.JComboBox caixaTipo;
    private javax.swing.JTextField campoId;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoPesquisarFormapagamento;
    private javax.swing.JPanel painelAdicionarModificarFormasPagamento;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelProcurarFormaPagamento;
    private javax.swing.JScrollPane painelScrollTabela;
    private javax.swing.JPanel painelSuperior;
    private javax.swing.JTable tabelaFormasPagamento;
    private javax.swing.JLabel textoAdicionarFormaPagamento;
    private javax.swing.JLabel textoAtiva;
    private javax.swing.JLabel textoCliqueParaEditar;
    private javax.swing.JLabel textoIconeNovFormaPagamento;
    private javax.swing.JLabel textoId;
    private javax.swing.JLabel textoNome;
    private javax.swing.JLabel textoPreencherDados;
    private javax.swing.JLabel textoProcurarFormaPagamento;
    private javax.swing.JLabel textoTipo;
    // End of variables declaration//GEN-END:variables
}
