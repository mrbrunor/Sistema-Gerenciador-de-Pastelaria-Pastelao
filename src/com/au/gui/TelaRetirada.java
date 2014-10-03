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

import com.au.bean.Caixa;
import com.au.bean.Despesa;
import com.au.dao.DespesaDao;
import com.au.util.LimitaDigitos;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

/**
 *
 * @author BrunoRicardo
 */
public class TelaRetirada extends javax.swing.JDialog {

    private final Caixa caixa;
    private final Border vermelha = new MatteBorder(1, 1, 1, 1, Color.red);
    private final Border normal;
    private final DespesaDao dDao = new DespesaDao();

    /**
     * Creates new form TelaRetirada
     * @param parent
     * @param modal
     * @param caixa
     */
    public TelaRetirada(java.awt.Frame parent, boolean modal, Caixa caixa) {
        super(parent, modal);
        initComponents();
        campoMotivo.setDocument(new LimitaDigitos((300), ""));
        campoValor.setDocument(new LimitaDigitos((7), "[^0-9\\.]"));
        normal = campoValor.getBorder();
        this.caixa = caixa;
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
        textoRetiradaCaixa = new javax.swing.JLabel();
        textoInsiraDados = new javax.swing.JLabel();
        painelInferior = new javax.swing.JPanel();
        textoValor = new javax.swing.JLabel();
        textoSenha = new javax.swing.JLabel();
        campoValor = new javax.swing.JTextField();
        campoValor.setActionCommand("Valor");
        jScrollPane1 = new javax.swing.JScrollPane();
        campoMotivo = new javax.swing.JTextArea();
        botaoCancelarRetirada = new javax.swing.JButton();
        botaoRegistrarRetirada = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textoRetiradaCaixa.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        textoRetiradaCaixa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoRetiradaCaixa.setText("Retirada de Caixa");

        textoInsiraDados.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        textoInsiraDados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoInsiraDados.setText("Insira os dados abaixo para efetuar a retirada:");

        javax.swing.GroupLayout painelSuperiorLayout = new javax.swing.GroupLayout(painelSuperior);
        painelSuperior.setLayout(painelSuperiorLayout);
        painelSuperiorLayout.setHorizontalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textoRetiradaCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoInsiraDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelSuperiorLayout.setVerticalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoRetiradaCaixa)
                .addGap(18, 18, 18)
                .addComponent(textoInsiraDados)
                .addContainerGap())
        );

        painelInferior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textoValor.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoValor.setText("Valor:");

        textoSenha.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textoSenha.setText("Motivo:");

        campoValor.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        campoValor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        campoValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoValorFocusGained(evt);
            }
        });
        campoValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoValorActionPerformed(evt);
            }
        });

        campoMotivo.setColumns(20);
        campoMotivo.setRows(5);
        campoMotivo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoMotivoFocusGained(evt);
            }
        });
        campoMotivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoMotivoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(campoMotivo);
        campoMotivo.setLineWrap(true);

        campoMotivo.setWrapStyleWord(true);

        javax.swing.GroupLayout painelInferiorLayout = new javax.swing.GroupLayout(painelInferior);
        painelInferior.setLayout(painelInferiorLayout);
        painelInferiorLayout.setHorizontalGroup(
            painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoSenha)
                    .addComponent(textoValor))
                .addGap(18, 18, 18)
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoValor)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        painelInferiorLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {textoSenha, textoValor});

        painelInferiorLayout.setVerticalGroup(
            painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoValor)
                    .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoSenha)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        botaoCancelarRetirada.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoCancelarRetirada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/cancel-32.png"))); // NOI18N
        botaoCancelarRetirada.setText("Cancelar Retirada");
        botaoCancelarRetirada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarRetiradaActionPerformed(evt);
            }
        });

        botaoRegistrarRetirada.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoRegistrarRetirada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/ok-32.png"))); // NOI18N
        botaoRegistrarRetirada.setText("Registrar Retirada");
        botaoRegistrarRetirada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRegistrarRetiradaActionPerformed(evt);
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
                        .addComponent(botaoCancelarRetirada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoRegistrarRetirada)))
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
                    .addComponent(botaoCancelarRetirada, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoRegistrarRetirada))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoValorFocusGained
        campoValor.selectAll();
    }//GEN-LAST:event_campoValorFocusGained

    private void campoMotivoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoMotivoFocusGained
        campoMotivo.selectAll();
    }//GEN-LAST:event_campoMotivoFocusGained

    private void campoValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoValorActionPerformed
        campoMotivo.requestFocus();
    }//GEN-LAST:event_campoValorActionPerformed

    private void campoMotivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMotivoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (valida()) {
                registrarRetirada();
                this.dispose();
            }
        }
    }//GEN-LAST:event_campoMotivoKeyPressed

    private void botaoCancelarRetiradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarRetiradaActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoCancelarRetiradaActionPerformed

    private void botaoRegistrarRetiradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRegistrarRetiradaActionPerformed
        if (valida()) {
            registrarRetirada();
            this.dispose();
        }
    }//GEN-LAST:event_botaoRegistrarRetiradaActionPerformed

    public void registrarRetirada() {
        dDao.abreConnection();
        Despesa despesa = new Despesa();
        Date data = new Date();
        despesa.setDataDesp(new java.sql.Date(data.getTime()));
        despesa.setDescDesp(campoMotivo.getText());
        despesa.setValorDesp(Double.valueOf(campoValor.getText()));
        despesa.setRetirada((byte) 1);
        despesa.setIdCaixa(caixa.getIdCaixa());
        dDao.adicionaDespesa(despesa);
        JOptionPane.showMessageDialog(this, "Retirada de caixa efetuada com sucesso!", "Retirada de Caixa", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean valida() {
        boolean valida = true;

        if (!"".equals(campoValor.getText())) {
            campoValor.setBorder(normal);
        } else {
            campoValor.setBorder(vermelha);
            valida = false;
        }

        if (!"".equals(campoMotivo.getText()) && campoMotivo.getText().length() > 3) {
            campoMotivo.setBorder(normal);
        } else {
            campoMotivo.setBorder(vermelha);
            valida = false;
        }
        return valida;
    }

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelarRetirada;
    private javax.swing.JButton botaoRegistrarRetirada;
    private javax.swing.JTextArea campoMotivo;
    private javax.swing.JTextField campoValor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelInferior;
    private javax.swing.JPanel painelSuperior;
    private javax.swing.JLabel textoInsiraDados;
    private javax.swing.JLabel textoRetiradaCaixa;
    private javax.swing.JLabel textoSenha;
    private javax.swing.JLabel textoValor;
    // End of variables declaration//GEN-END:variables
}
