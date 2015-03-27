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

import com.au.conexao.FabricaConexao;
import com.au.util.GeradorRelatorio;
import com.au.util.JFileChooserCustomizado;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author tiago_000
 */
public class TelaVendasGerais extends javax.swing.JDialog {

    private final Border vermelha = new MatteBorder(1, 1, 1, 1, Color.red);
    private final Border normal;

    /**
     * Cria o novo form TelaVendasPorPeríodo
     *
     * @param parent Tela que chamou
     * @param modal
     */
    public TelaVendasGerais(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        textoErroDtFim.setVisible(false);
        textoErroDtInicio.setVisible(false);
        textoErroLocal.setVisible(false);
        normal = campoLocalParaSalvar.getBorder();
        campoDataInicio.setBorder(normal);
        campoDataTermino.setBorder(normal);
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
        textoErroDtInicio = new javax.swing.JLabel();
        textoErroDtFim = new javax.swing.JLabel();
        textoErroLocal = new javax.swing.JLabel();
        botaoGerarRelatorio = new javax.swing.JButton();
        botaoCancelarGeracaoDeRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema Pastelão - Relatório de Vendas");

        painelSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textoVendasPorPeriodo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        textoVendasPorPeriodo.setText("Vendas Gerais");

        textoIconeVendasPorPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/tag-64.png"))); // NOI18N

        textoPreenchaOsCampos.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        textoPreenchaOsCampos.setText("<html>Preencha o campos abaixo para gerar o relatório <br/>de vendas gerais:");

        javax.swing.GroupLayout painelSuperiorLayout = new javax.swing.GroupLayout(painelSuperior);
        painelSuperior.setLayout(painelSuperiorLayout);
        painelSuperiorLayout.setHorizontalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoIconeVendasPorPeriodo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoPreenchaOsCampos)
                    .addComponent(textoVendasPorPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelSuperiorLayout.setVerticalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textoIconeVendasPorPeriodo)
                    .addGroup(painelSuperiorLayout.createSequentialGroup()
                        .addComponent(textoVendasPorPeriodo)
                        .addGap(18, 18, 18)
                        .addComponent(textoPreenchaOsCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        botaoProcurarLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoProcurarLocalActionPerformed(evt);
            }
        });

        textoErroDtInicio.setForeground(new java.awt.Color(255, 0, 0));
        textoErroDtInicio.setText("Informe a data inicial");

        textoErroDtFim.setForeground(new java.awt.Color(255, 0, 0));
        textoErroDtFim.setText("Informe a data final");

        textoErroLocal.setForeground(new java.awt.Color(255, 0, 0));
        textoErroLocal.setText("Informe o local para salvar o relatório");

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
                        .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(painelInferiorLayout.createSequentialGroup()
                                    .addComponent(textoDataInicio)
                                    .addGap(18, 18, 18)
                                    .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(campoDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textoErroDtInicio)))
                                .addGroup(painelInferiorLayout.createSequentialGroup()
                                    .addComponent(textoDataTermino)
                                    .addGap(18, 18, 18)
                                    .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textoErroDtFim)
                                        .addComponent(campoDataTermino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(textoErroLocal))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        painelInferiorLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {textoDataInicio, textoDataTermino});

        painelInferiorLayout.setVerticalGroup(
            painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoDataInicio)
                    .addGroup(painelInferiorLayout.createSequentialGroup()
                        .addComponent(campoDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoErroDtInicio)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoDataTermino)
                    .addGroup(painelInferiorLayout.createSequentialGroup()
                        .addComponent(campoDataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textoErroDtFim)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoEscolhaOLocal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoLocalParaSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoProcurarLocal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoErroLocal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoGerarRelatorio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoGerarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/ok-32.png"))); // NOI18N
        botaoGerarRelatorio.setText("Gerar Relatório");
        botaoGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerarRelatorioActionPerformed(evt);
            }
        });

        botaoCancelarGeracaoDeRelatorio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoCancelarGeracaoDeRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/cancel-32.png"))); // NOI18N
        botaoCancelarGeracaoDeRelatorio.setText("Cancelar Geração de Relatório");
        botaoCancelarGeracaoDeRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarGeracaoDeRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoCancelarGeracaoDeRelatorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(painelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoProcurarLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoProcurarLocalActionPerformed
        procuraLocal();
    }//GEN-LAST:event_botaoProcurarLocalActionPerformed

    private void botaoGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerarRelatorioActionPerformed
        if (valida()) {
            JOptionPane.showMessageDialog(this, "A geração de Relatórios pode demorar alguns minutos. \n Aguarde a mensagem de confirmação.");
            try {
                geraRelatorio();
            } catch (ParseException ex) {
                Logger.getLogger(TelaVendasGerais.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        }
    }//GEN-LAST:event_botaoGerarRelatorioActionPerformed

    private void botaoCancelarGeracaoDeRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarGeracaoDeRelatorioActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoCancelarGeracaoDeRelatorioActionPerformed

    private void geraRelatorio() throws ParseException {
        String nome = "reports\\vendas_gerais.jrxml";

        Map<String, Object> parametros = new HashMap<>();
        Connection conexao = new FabricaConexao().getConexao();
        String caminhoParaSalvar = campoLocalParaSalvar.getText();
        File arquivo = new File(caminhoParaSalvar);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dataIni = sdf.format(campoDataInicio.getDate());
        String dataFim = sdf.format(campoDataTermino.getDate());

        Date dataInicial = sdf.parse(dataIni);
        Date dataFinal = sdf.parse(dataFim);
        
        parametros.put("DATA_INI", dataInicial);
        parametros.put("DATA_FIM", dataFinal);
        
        GeradorRelatorio gerador;
        
        try {
            gerador = new GeradorRelatorio(nome,parametros,conexao);
            gerador.geraPdfParaOutputStreamNovo(caminhoParaSalvar);
        } catch (JRException e) {
            System.out.println(e);
        }

        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "Relatório Gerado com Sucesso!\nDeseja abrir o relatório agora?", "Geração de Relatório", JOptionPane.YES_NO_OPTION)) {
            try {
                Desktop.getDesktop().open(arquivo);

            } catch (IOException ex) {
                Logger.getLogger(TelaVendasGerais.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void procuraLocal() {
        JFileChooserCustomizado file = new JFileChooserCustomizado(".", "pdf");
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        file.setFileFilter(new FileNameExtensionFilter("Documentos em PDF", "pdf"));
        int selecao = file.showSaveDialog(this);
        if (selecao != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File arquivo = file.getSelectedFile();
        if (arquivo.exists() && JOptionPane.showConfirmDialog(this, "O Arquivo já existe. Deseja mesmo substituí-lo?", "Substituir Arquivo Existente", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }
        String localArquivo = arquivo.getAbsolutePath();
        campoLocalParaSalvar.setText(localArquivo);
    }

    public boolean valida() {
        boolean valida = true;
        if (campoDataInicio.getDate() != null) {
            campoDataInicio.setBorder(normal);
            textoErroDtInicio.setVisible(false);
        } else {
            campoDataInicio.setBorder(vermelha);
            textoErroDtInicio.setVisible(true);
            valida = false;
        }
        if (campoDataTermino.getDate() != null) {
            campoDataTermino.setBorder(normal);
            textoErroDtFim.setVisible(false);
        } else {
            campoDataTermino.setBorder(vermelha);
            textoErroDtFim.setVisible(true);
            valida = false;
        }
        if (!"".equals(campoLocalParaSalvar.getText())) {
            campoLocalParaSalvar.setBorder(normal);
            textoErroLocal.setVisible(false);
        } else {
            valida = false;
            textoErroLocal.setVisible(true);
            campoLocalParaSalvar.setBorder(vermelha);
        }
        return valida;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel textoErroDtFim;
    private javax.swing.JLabel textoErroDtInicio;
    private javax.swing.JLabel textoErroLocal;
    private javax.swing.JLabel textoEscolhaOLocal;
    private javax.swing.JLabel textoIconeVendasPorPeriodo;
    private javax.swing.JLabel textoPreenchaOsCampos;
    private javax.swing.JLabel textoVendasPorPeriodo;
    // End of variables declaration//GEN-END:variables
}
