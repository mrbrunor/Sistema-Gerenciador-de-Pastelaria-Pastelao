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

import com.au.bean.Pedido;
import com.au.dao.PedidoDao;
import com.au.util.LimitaDigitos;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

/**
 *
 * @author BrunoRicardo
 */
public class TelaCancelamento extends javax.swing.JDialog {

    private final int idCaixa;
    private final Border vermelha = new MatteBorder(1, 1, 1, 1, Color.red);
    private final Border normal;
    private final PedidoDao pDao = new PedidoDao();

    /**
     * Creates new form TelaRetirada
     * @param parent
     * @param modal
     * @param idCaixa
     */
    public TelaCancelamento(java.awt.Frame parent, boolean modal, int idCaixa) {
        super(parent, modal);
        initComponents();
        textoErroNumero.setVisible(false);
        normal = campoNumeroPedido.getBorder();
        campoNumeroPedido.setDocument(new LimitaDigitos((7), "[^0-9]"));
        this.idCaixa = idCaixa;
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
        textoCancelamentoPedido = new javax.swing.JLabel();
        textoInsiraDados = new javax.swing.JLabel();
        painelInferior = new javax.swing.JPanel();
        textoNumeroPedido = new javax.swing.JLabel();
        campoNumeroPedido = new javax.swing.JTextField();
        textoErroNumero = new javax.swing.JLabel();
        botaoSair = new javax.swing.JButton();
        botaoCancelarPedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textoCancelamentoPedido.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        textoCancelamentoPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoCancelamentoPedido.setText("Cancelamento de Pedido");

        textoInsiraDados.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        textoInsiraDados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoInsiraDados.setText("Insira os dados abaixo para efetuar o cancelamento do pedido:");

        javax.swing.GroupLayout painelSuperiorLayout = new javax.swing.GroupLayout(painelSuperior);
        painelSuperior.setLayout(painelSuperiorLayout);
        painelSuperiorLayout.setHorizontalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textoCancelamentoPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoInsiraDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelSuperiorLayout.setVerticalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoCancelamentoPedido)
                .addGap(18, 18, 18)
                .addComponent(textoInsiraDados)
                .addContainerGap())
        );

        painelInferior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textoNumeroPedido.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoNumeroPedido.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textoNumeroPedido.setText("Número do Pedido:");

        campoNumeroPedido.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        campoNumeroPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        campoNumeroPedido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoNumeroPedidoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNumeroPedidoFocusLost(evt);
            }
        });
        campoNumeroPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNumeroPedidoActionPerformed(evt);
            }
        });

        textoErroNumero.setForeground(new java.awt.Color(255, 0, 0));
        textoErroNumero.setText("Digite o número do produto");

        javax.swing.GroupLayout painelInferiorLayout = new javax.swing.GroupLayout(painelInferior);
        painelInferior.setLayout(painelInferiorLayout);
        painelInferiorLayout.setHorizontalGroup(
            painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoNumeroPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelInferiorLayout.createSequentialGroup()
                        .addComponent(textoErroNumero)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(campoNumeroPedido))
                .addContainerGap())
        );
        painelInferiorLayout.setVerticalGroup(
            painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoNumeroPedido)
                    .addComponent(campoNumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textoErroNumero))
        );

        botaoSair.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/cancel-32.png"))); // NOI18N
        botaoSair.setText("Sair");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        botaoCancelarPedido.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoCancelarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/ok-32.png"))); // NOI18N
        botaoCancelarPedido.setText("Cancelar Pedido");
        botaoCancelarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelSuperior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelInferior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoSair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoCancelarPedido)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCancelarPedido))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarPedidoActionPerformed
        if (valida()) {
            this.dispose();
        }
    }//GEN-LAST:event_botaoCancelarPedidoActionPerformed

    private void campoNumeroPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNumeroPedidoActionPerformed
        if (valida()) {
            this.dispose();
        }
    }//GEN-LAST:event_campoNumeroPedidoActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoSairActionPerformed

    private void campoNumeroPedidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNumeroPedidoFocusGained
        campoNumeroPedido.selectAll();
    }//GEN-LAST:event_campoNumeroPedidoFocusGained

    private void campoNumeroPedidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNumeroPedidoFocusLost
        valida();
    }//GEN-LAST:event_campoNumeroPedidoFocusLost

    public boolean valida() {
        boolean valida;
        if (!"".equals(campoNumeroPedido.getText())) {
            campoNumeroPedido.setBorder(normal);
            valida = validaPedido();
            textoErroNumero.setVisible(false);
        } else {
            campoNumeroPedido.setBorder(vermelha);
            valida = false;
            textoErroNumero.setVisible(true);
        }
        return valida;
    }

    public boolean validaPedido() {
        pDao.abreConnection();
        List<Pedido> pedidos = pDao.listaPedidosPorCaixa(idCaixa);
        if (pedidos != null) {
            for (int i = 0; i < pedidos.size(); i++) {
                if (pedidos.get(i).getNumPedido() == Integer.valueOf(campoNumeroPedido.getText())) {
                    if (pedidos.get(i).getEstadoPedido().equals("Cancelado")) {
                        JOptionPane.showMessageDialog(this, "Pedido informado já esta Cancelado!", "Cancelamento de Pedido", JOptionPane.INFORMATION_MESSAGE);
                        pDao.fechaConnection();
                        return false;
                    }
                    pedidos.get(i).setEstadoPedido("Cancelado");
                    pDao.atualizaPedido(pedidos.get(i));
                    JOptionPane.showMessageDialog(this, "Pedido cancelado com sucesso!", "Cancelamento de Pedido", JOptionPane.INFORMATION_MESSAGE);
                    pDao.fechaConnection();
                    return true;
                }
            }
        }
        JOptionPane.showMessageDialog(this, "Pedido não foi encontrado!", "Cancelamento de Pedido", JOptionPane.INFORMATION_MESSAGE);
        pDao.fechaConnection();
        return false;
    }

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelarPedido;
    private javax.swing.JButton botaoSair;
    private javax.swing.JTextField campoNumeroPedido;
    private javax.swing.JPanel painelInferior;
    private javax.swing.JPanel painelSuperior;
    private javax.swing.JLabel textoCancelamentoPedido;
    private javax.swing.JLabel textoErroNumero;
    private javax.swing.JLabel textoInsiraDados;
    private javax.swing.JLabel textoNumeroPedido;
    // End of variables declaration//GEN-END:variables
}
