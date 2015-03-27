/*
 * Copyright (C) 2014 BrunoRicardo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.au.gui;

import com.au.bean.FormaPagamento;
import com.au.dao.FormaPagamentoDao;
import com.au.gui.tmodel.FormaPagamentoTableModel;
import java.awt.Color;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author BrunoRicardo
 */
public class TelaCadastrarFormasDePagamento extends javax.swing.JDialog implements ListSelectionListener {

    private FormaPagamentoTableModel tableModel;
    private final FormaPagamentoDao fpDao = new FormaPagamentoDao();
    private final Border vermelha = new MatteBorder(1, 1, 1, 1, Color.red);
    private final Border normal;
    private boolean[] valida = {false, false, false};

    /**
     * Creates new form TelaCadastrarFormasDePagamento
     *
     * @param parent
     * @param modal
     */
    public TelaCadastrarFormasDePagamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        textoErroAtivo.setVisible(false);
        textoErroNome.setVisible(false);
        textoErroTipo.setVisible(false);
        normal = campoNome.getBorder();
        inicializaTableModel();
        habilitaBotoesParaSalvar();
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
        textoErroNome = new javax.swing.JLabel();
        textoErroTipo = new javax.swing.JLabel();
        textoErroAtivo = new javax.swing.JLabel();
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
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNomeFocusLost(evt);
            }
        });

        campoId.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        campoId.setEnabled(false);

        textoId.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoId.setText("ID Forma de Pagamento:");

        caixaTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Dinheiro", "Debito", "Credito", "Vale" }));
        caixaTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caixaTipoActionPerformed(evt);
            }
        });

        caixaAtivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Sim", "Não" }));
        caixaAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caixaAtivoActionPerformed(evt);
            }
        });

        textoAtiva.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoAtiva.setText("Ativa:");

        textoErroNome.setForeground(new java.awt.Color(255, 0, 0));
        textoErroNome.setText("Informe o nome.");

        textoErroTipo.setForeground(new java.awt.Color(255, 0, 0));
        textoErroTipo.setText("Selecione o tipo da forma de pagamento.");

        textoErroAtivo.setForeground(new java.awt.Color(255, 0, 0));
        textoErroAtivo.setText("Selecione se esta ativa ou não.");

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
                    .addComponent(textoErroAtivo)
                    .addComponent(textoErroTipo)
                    .addComponent(textoErroNome)
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
                .addComponent(textoErroNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelAdicionarModificarFormasPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoTipo)
                    .addComponent(caixaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoErroTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelAdicionarModificarFormasPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoAtiva)
                    .addComponent(caixaAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoErroAtivo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelProcurarFormaPagamento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Procurar Formas de Pagamento Existente"));

        campoPesquisarFormapagamento.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        campoPesquisarFormapagamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPesquisarFormapagamentoFocusGained(evt);
            }
        });
        campoPesquisarFormapagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPesquisarFormapagamentoActionPerformed(evt);
            }
        });

        botaoProcurarFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoProcurarFormaPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/search-26.png"))); // NOI18N
        botaoProcurarFormaPagamento.setText("Procurar");
        botaoProcurarFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoProcurarFormaPagamentoActionPerformed(evt);
            }
        });

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
        botaoCancelarFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarFormaPagamentoActionPerformed(evt);
            }
        });

        botaoCadastrarFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoCadastrarFormaPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/ok-32.png"))); // NOI18N
        botaoCadastrarFormaPagamento.setText("Cadastrar Forma Pgto");
        botaoCadastrarFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarFormaPagamentoActionPerformed(evt);
            }
        });

        botaoLimparCampos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/erase-32.png"))); // NOI18N
        botaoLimparCampos.setText("Limpar Campos");
        botaoLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparCamposActionPerformed(evt);
            }
        });

        botaoAtualizarFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoAtualizarFormaPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/refresh-32.png"))); // NOI18N
        botaoAtualizarFormaPagamento.setText("Atualizar Forma Pgto");
        botaoAtualizarFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtualizarFormaPagamentoActionPerformed(evt);
            }
        });

        botaoExcluirFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoExcluirFormaPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/delete-32.png"))); // NOI18N
        botaoExcluirFormaPagamento.setText("Excluir Forma Pgto");
        botaoExcluirFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirFormaPagamentoActionPerformed(evt);
            }
        });

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

    private void botaoCadastrarFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarFormaPagamentoActionPerformed
        if (valida()) {
            cadastrarFormaPagamento();
        }
    }//GEN-LAST:event_botaoCadastrarFormaPagamentoActionPerformed

    private void botaoLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparCamposActionPerformed
        limpaCampos();
        habilitaBotoesParaSalvar();
    }//GEN-LAST:event_botaoLimparCamposActionPerformed

    private void botaoExcluirFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirFormaPagamentoActionPerformed
        if (valida()) {
            excluirFormaPagamento();
            habilitaBotoesParaSalvar();
        }
    }//GEN-LAST:event_botaoExcluirFormaPagamentoActionPerformed

    private void botaoAtualizarFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtualizarFormaPagamentoActionPerformed
        if (valida()) {
            atualizarFormaPagamento();
            habilitaBotoesParaSalvar();
        }
    }//GEN-LAST:event_botaoAtualizarFormaPagamentoActionPerformed

    private void botaoCancelarFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarFormaPagamentoActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoCancelarFormaPagamentoActionPerformed

    private void botaoProcurarFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoProcurarFormaPagamentoActionPerformed
        pesquisaFormaPagamento();
    }//GEN-LAST:event_botaoProcurarFormaPagamentoActionPerformed

    private void campoPesquisarFormapagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPesquisarFormapagamentoActionPerformed
        pesquisaFormaPagamento();
    }//GEN-LAST:event_campoPesquisarFormapagamentoActionPerformed

    private void campoNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNomeFocusLost
        valida(campoNome, null, 0, textoErroNome);
    }//GEN-LAST:event_campoNomeFocusLost

    private void caixaTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixaTipoActionPerformed
        valida(null, caixaTipo, 1, textoErroTipo);
    }//GEN-LAST:event_caixaTipoActionPerformed

    private void caixaAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixaAtivoActionPerformed
        valida(null, caixaAtivo, 2, textoErroAtivo);
    }//GEN-LAST:event_caixaAtivoActionPerformed

    private void atualizarFormaPagamento() {
        fpDao.abreConnection();
        fpDao.atualizaFormaPagamento(formToFormaPagamento());
        fpDao.fechaConnection();
        JOptionPane.showMessageDialog(this, "Forma de Pagamento Atualizada Com Sucesso", "Cadastro de Formas de Pagamento", JOptionPane.INFORMATION_MESSAGE);
        limpaCampos();
        inicializaTableModel();
    }

    private void atualizaTableModel(List<FormaPagamento> formasPagamento) {
        if (formasPagamento != null && formasPagamento.isEmpty()) {
            FormaPagamento formaPagamento = new FormaPagamento();
            formaPagamento.setNomeFormaPgto("Nenhum Registro Encontrado");
            formasPagamento.add(formaPagamento);
        }
        tableModel = new FormaPagamentoTableModel(formasPagamento);
        tabelaFormasPagamento.setModel(tableModel);
        tabelaFormasPagamento.getSelectionModel().addListSelectionListener(this);
        tabelaFormasPagamento.getColumnModel().getColumn(0).setMaxWidth(35);
        tabelaFormasPagamento.getColumnModel().getColumn(2).setMaxWidth(110);
        tabelaFormasPagamento.getColumnModel().getColumn(3).setMaxWidth(110);
    }

    private void cadastrarFormaPagamento() {
        FormaPagamento formaPagamento = formToFormaPagamento();
        fpDao.abreConnection();
        fpDao.adicionaFormaPagamento(formaPagamento);
        fpDao.fechaConnection();
        JOptionPane.showMessageDialog(this, "Forma de Pagamento Cadastrada Com Sucesso", "Cadastro de Formas de Pagamento", JOptionPane.INFORMATION_MESSAGE);
        limpaCampos();
        inicializaTableModel();
    }

    private void desabilitaBotoesParaSalvar() {
        habilitaOuDesabilitaBotoesEdicao(false);
    }

    private void excluirFormaPagamento() {
        fpDao.abreConnection();
        fpDao.deletaFormaPagamento(formToFormaPagamento());
        fpDao.fechaConnection();
        JOptionPane.showMessageDialog(this, "Forma de Pagamento Removida Com Sucesso", "Cadastro de Formas de Pagamento", JOptionPane.INFORMATION_MESSAGE);
        limpaCampos();
        inicializaTableModel();
    }

    private void formaPagamentoToForm(FormaPagamento formaPagamento) {
        campoId.setText(String.valueOf(formaPagamento.getIdFormaPgto()));
        campoNome.setText(formaPagamento.getNomeFormaPgto());
        switch (formaPagamento.getTipoFormaPgto()) {
            case "Dinheiro":
                caixaTipo.setSelectedIndex(1);
                break;
            case "Debito":
                caixaTipo.setSelectedIndex(2);
                break;
            case "Credito":
                caixaTipo.setSelectedIndex(3);
                break;
            default:
                caixaTipo.setSelectedIndex(4);
                break;
        }
        if ((byte) 0 == formaPagamento.getEstaAtivo()) {
            caixaAtivo.setSelectedIndex(2);
        } else {
            caixaAtivo.setSelectedIndex(1);
        }
        desabilitaBotoesParaSalvar();
    }

    private FormaPagamento formToFormaPagamento() {
        FormaPagamento formaPagamento = new FormaPagamento();
        if (!"".equals(campoId.getText())) {
            formaPagamento.setIdFormaPgto(Integer.parseInt(campoId.getText()));
        }
        formaPagamento.setNomeFormaPgto(campoNome.getText());
        formaPagamento.setTipoFormaPgto(String.valueOf(caixaTipo.getSelectedItem()));

        if (caixaAtivo.getSelectedItem() == "Não") {
            formaPagamento.setEstaAtivo((byte) 0);
        } else {
            formaPagamento.setEstaAtivo((byte) 1);
        }
        return formaPagamento;
    }

    private void habilitaBotoesParaSalvar() {
        habilitaOuDesabilitaBotoesEdicao(true);
    }

    private void habilitaOuDesabilitaBotoesEdicao(boolean enabled) {
        botaoAtualizarFormaPagamento.setEnabled(!enabled);
        botaoCadastrarFormaPagamento.setEnabled(enabled);
        botaoExcluirFormaPagamento.setEnabled(!enabled);
    }

    private void inicializaTableModel() {
        fpDao.abreConnection();
        atualizaTableModel(fpDao.getLista());
        fpDao.fechaConnection();
    }

    private void limpaCampos() {
        campoId.setText("");
        campoNome.setText("");
        caixaAtivo.setSelectedIndex(0);
        caixaTipo.setSelectedIndex(0);
        caixaAtivo.setBorder(normal);
        caixaTipo.setBorder(normal);
        campoId.setBorder(normal);
        campoNome.setBorder(normal);
        textoErroAtivo.setVisible(false);
        textoErroNome.setVisible(false);
        textoErroTipo.setVisible(false);
    }

    private void pesquisaFormaPagamento() {
        fpDao.abreConnection();
        String pesquisa = "%" + campoPesquisarFormapagamento.getText() + "%";
        limpaCampos();
        atualizaTableModel(fpDao.pesquisarFormaPagamento(pesquisa));
        fpDao.fechaConnection();
    }

    public void valida(JTextField campo, JComboBox combo, int indexVetor, JLabel texto) {

        if (campo != null) {
            if (!"".equals(campo.getText())) {
                campo.setBorder(normal);
                valida[indexVetor] = true;
                texto.setVisible(false);
            } else {
                campo.setBorder(vermelha);
                valida[indexVetor] = false;
                texto.setVisible(true);
            }
        }
        if (combo != null) {
            if (combo.getSelectedIndex() != 0) {
                combo.setBorder(normal);
                valida[indexVetor] = true;
                texto.setVisible(false);
            } else {
                combo.setBorder(vermelha);
                valida[indexVetor] = false;
                texto.setVisible(true);
            }
        }
    }

    public boolean valida() {
        boolean validar = true;
        if (valida[0] == false) {
            valida(campoNome, null, 0, textoErroNome);
            validar = false;
        }
        if (valida[1] == false) {
            valida(null, caixaTipo, 1, textoErroTipo);
            validar = false;
        }
        if (valida[2] == false) {
            valida(null, caixaAtivo, 2, textoErroAtivo);
            validar = false;
        }
        return validar;
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
    private javax.swing.JLabel textoErroAtivo;
    private javax.swing.JLabel textoErroNome;
    private javax.swing.JLabel textoErroTipo;
    private javax.swing.JLabel textoIconeNovFormaPagamento;
    private javax.swing.JLabel textoId;
    private javax.swing.JLabel textoNome;
    private javax.swing.JLabel textoPreencherDados;
    private javax.swing.JLabel textoProcurarFormaPagamento;
    private javax.swing.JLabel textoTipo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (tabelaFormasPagamento.getSelectedRow() != -1) {
            FormaPagamento formaPagamento = tableModel.getFormasPagamento().get(tabelaFormasPagamento.getSelectedRow());
            if (formaPagamento.getIdFormaPgto() != 0) {
                formaPagamentoToForm(formaPagamento);
            }
        }
    }
}
