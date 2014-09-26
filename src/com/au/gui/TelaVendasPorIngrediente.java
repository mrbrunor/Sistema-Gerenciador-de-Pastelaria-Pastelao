/*
 * The MIT License
 *
 * Copyright 2014 tiago_000.
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

import com.au.modelo.Ingrediente;
import com.au.util.CustomComboBoxInt;
import com.au.dao.DAO;
import com.toedter.calendar.JDateChooser;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author tiago_000
 */
public class TelaVendasPorIngrediente extends javax.swing.JDialog {


    /**
     * Cria o novo form TelaVendasPorPeríodo
     *
     * @param parent Tela que chamou
     * @param modal
     */
    public TelaVendasPorIngrediente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        textoVendasPorPeriodo = new javax.swing.JLabel();
        textoIconeVendasPorPeriodo = new javax.swing.JLabel();
        textoPreenchaOsCampos = new javax.swing.JLabel();
        painelInferior = new javax.swing.JPanel();
        textoDataInicio = new javax.swing.JLabel();
        textoDataTermino = new javax.swing.JLabel();
        campoDataInicio = new com.toedter.calendar.JDateChooser();
        campoDataTermino = new com.toedter.calendar.JDateChooser();
        textoEscolhaOLocal = new javax.swing.JLabel();
        campoLocalParaSalvar = new javax.swing.JTextField();
        botaoProcurarLocal = new javax.swing.JButton();
        textoingrediente = new javax.swing.JLabel();
        ComboBoxIngredientes = new javax.swing.JComboBox(getIngs());
        botaoGerarRelatorio = new javax.swing.JButton();
        botaoCancelarGeracaoDeRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textoVendasPorPeriodo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        textoVendasPorPeriodo.setText("<html>Vendas Gerais, filtradas por <br/>Ingredientes");

        textoIconeVendasPorPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/tag-64.png"))); // NOI18N

        textoPreenchaOsCampos.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        textoPreenchaOsCampos.setText("<html>Preencha o campos abaixo para gerar o relatório de <br />vendas gerais, filtradas por ingredientes:");

        javax.swing.GroupLayout painelSuperiorLayout = new javax.swing.GroupLayout(painelSuperior);
        painelSuperior.setLayout(painelSuperiorLayout);
        painelSuperiorLayout.setHorizontalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoPreenchaOsCampos)
                    .addGroup(painelSuperiorLayout.createSequentialGroup()
                        .addComponent(textoIconeVendasPorPeriodo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoVendasPorPeriodo)))
                .addContainerGap())
        );
        painelSuperiorLayout.setVerticalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoIconeVendasPorPeriodo)
                    .addComponent(textoVendasPorPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(textoPreenchaOsCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelInferior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textoDataInicio.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoDataInicio.setText("Data de Início:");

        textoDataTermino.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoDataTermino.setText("Data de Término:");

        campoDataInicio.setDateFormatString("dd-MM-yyyy");
        campoDataInicio.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        campoDataTermino.setDateFormatString("dd-MM-yyyy");
        campoDataTermino.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        textoEscolhaOLocal.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoEscolhaOLocal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoEscolhaOLocal.setText("Escolha o local para salvar o relatório em pdf:");

        campoLocalParaSalvar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        botaoProcurarLocal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoProcurarLocal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/folder-26.png"))); // NOI18N
        botaoProcurarLocal.setText("Procurar");

        textoingrediente.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoingrediente.setText("Ingrediente:");

        javax.swing.GroupLayout painelInferiorLayout = new javax.swing.GroupLayout(painelInferior);
        painelInferior.setLayout(painelInferiorLayout);
        painelInferiorLayout.setHorizontalGroup(
            painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoEscolhaOLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelInferiorLayout.createSequentialGroup()
                        .addComponent(campoLocalParaSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoProcurarLocal))
                    .addGroup(painelInferiorLayout.createSequentialGroup()
                        .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(painelInferiorLayout.createSequentialGroup()
                                .addComponent(textoDataTermino)
                                .addGap(18, 18, 18)
                                .addComponent(campoDataTermino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(painelInferiorLayout.createSequentialGroup()
                                .addComponent(textoingrediente)
                                .addGap(18, 18, 18)
                                .addComponent(ComboBoxIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelInferiorLayout.createSequentialGroup()
                                .addComponent(textoDataInicio)
                                .addGap(18, 18, 18)
                                .addComponent(campoDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)))
                .addContainerGap())
        );

        painelInferiorLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {textoDataInicio, textoDataTermino, textoingrediente});

        painelInferiorLayout.setVerticalGroup(
            painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoDataInicio)
                    .addComponent(campoDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoDataTermino)
                    .addComponent(campoDataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoingrediente)
                    .addComponent(ComboBoxIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textoEscolhaOLocal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoLocalParaSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoProcurarLocal))
                .addContainerGap())
        );

        botaoGerarRelatorio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoGerarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/ok-32.png"))); // NOI18N
        botaoGerarRelatorio.setText("Gerar Relatório");

        botaoCancelarGeracaoDeRelatorio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoCancelarGeracaoDeRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/cancel-32.png"))); // NOI18N
        botaoCancelarGeracaoDeRelatorio.setText("Cancelar Geração de Relatório");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoCancelarGeracaoDeRelatorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoGerarRelatorio)
                    .addComponent(botaoCancelarGeracaoDeRelatorio))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JComboBox getComboBoxIngredientes() {
        return ComboBoxIngredientes;
    }

    public void setComboBoxIngredientes(JComboBox ComboBoxIngredientes) {
        this.ComboBoxIngredientes = ComboBoxIngredientes;
    }

    public JButton getBotaoCancelarGeracaoDeRelatorio() {
        return botaoCancelarGeracaoDeRelatorio;
    }

    public void setBotaoCancelarGeracaoDeRelatorio(JButton botaoCancelarGeracaoDeRelatorio) {
        this.botaoCancelarGeracaoDeRelatorio = botaoCancelarGeracaoDeRelatorio;
    }

    public JButton getBotaoGerarRelatorio() {
        return botaoGerarRelatorio;
    }

    public void setBotaoGerarRelatorio(JButton botaoGerarRelatorio) {
        this.botaoGerarRelatorio = botaoGerarRelatorio;
    }

    public JButton getBotaoProcurarLocal() {
        return botaoProcurarLocal;
    }

    public void setBotaoProcurarLocal(JButton botaoProcurarLocal) {
        this.botaoProcurarLocal = botaoProcurarLocal;
    }

    public JDateChooser getCampoDataInicio() {
        return campoDataInicio;
    }

    public void setCampoDataInicio(JDateChooser campoDataInicio) {
        this.campoDataInicio = campoDataInicio;
    }

    public JDateChooser getCampoDataTermino() {
        return campoDataTermino;
    }

    public void setCampoDataTermino(JDateChooser campoDataTermino) {
        this.campoDataTermino = campoDataTermino;
    }

    public JTextField getCampoLocalParaSalvar() {
        return campoLocalParaSalvar;
    }

    public void setCampoLocalParaSalvar(JTextField campoLocalParaSalvar) {
        this.campoLocalParaSalvar = campoLocalParaSalvar;
    }

    private CustomComboBoxInt[] getIngs() {
        List<Ingrediente> listaResIng = new DAO<>(Ingrediente.class).listaTodos();

        CustomComboBoxInt[] oItems = new CustomComboBoxInt[listaResIng.size()];
        for (int i = 0; i < listaResIng.size(); i++) {
            oItems[i] = new CustomComboBoxInt(listaResIng.get(i).getDescIng(), listaResIng.get(i).getIdIng());
        }
        return oItems;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBoxIngredientes;
    private javax.swing.JButton botaoCancelarGeracaoDeRelatorio;
    private javax.swing.JButton botaoGerarRelatorio;
    private javax.swing.JButton botaoProcurarLocal;
    private com.toedter.calendar.JDateChooser campoDataInicio;
    private com.toedter.calendar.JDateChooser campoDataTermino;
    private javax.swing.JTextField campoLocalParaSalvar;
    private javax.swing.JPanel painelInferior;
    private javax.swing.JPanel painelSuperior;
    private javax.swing.JLabel textoDataInicio;
    private javax.swing.JLabel textoDataTermino;
    private javax.swing.JLabel textoEscolhaOLocal;
    private javax.swing.JLabel textoIconeVendasPorPeriodo;
    private javax.swing.JLabel textoPreenchaOsCampos;
    private javax.swing.JLabel textoVendasPorPeriodo;
    private javax.swing.JLabel textoingrediente;
    // End of variables declaration//GEN-END:variables
}
