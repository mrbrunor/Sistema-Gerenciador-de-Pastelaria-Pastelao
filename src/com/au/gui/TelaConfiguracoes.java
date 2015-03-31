/*
 * Copyright (C) 2014 tiago_000
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

import com.au.util.ManipulaConfigs;
import static com.au.util.ManipulaConfigs.getProp;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiago_000
 */
public class TelaConfiguracoes extends javax.swing.JDialog {

    private Properties prop;
    private int modeloImpressoraCaixa;
    private int modeloImpressoraCozinha;
    private String interfaceImpressoraCaixa;
    private String interfaceImpressoraCozinha;
    private String enderecoImpressoraCaixa;
    private String enderecoImpressoraCozinha;
    private boolean ativarConsole;

    /**
     * Creates new form TelaConfiguracoes
     */
    public TelaConfiguracoes() {
        initComponents();
        try {
            prop = getProp();
        } catch (IOException ex) {
            Logger.getLogger(TelaConfiguracoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        textoEnderecoCaixa.setEnabled(false);
        campoEnderecoCaixa.setEnabled(false);
        textoEnderecoCozinha.setEnabled(false);
        campoEnderecoCozinha.setEnabled(false);
        preencheCamposImpressora();
        preencheCamposDebug();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotoesCaixa = new javax.swing.ButtonGroup();
        grupoBotoesCozinha = new javax.swing.ButtonGroup();
        painelSuperior = new javax.swing.JPanel();
        textoIconeConfiguracoes = new javax.swing.JLabel();
        textoConfiguracoes = new javax.swing.JLabel();
        textoNaveguePelasAbas = new javax.swing.JLabel();
        painelComAbasGeral = new javax.swing.JTabbedPane();
        painelImpressoras = new javax.swing.JPanel();
        painelImpressoraCaixa = new javax.swing.JPanel();
        textoModeloCaixa = new javax.swing.JLabel();
        comboboxModeloCaixa = new javax.swing.JComboBox();
        textoInterfaceCaixa = new javax.swing.JLabel();
        botaoRadioParalelaCaixa = new javax.swing.JRadioButton();
        botaoRadioEthernetCaixa = new javax.swing.JRadioButton();
        textoEnderecoCaixa = new javax.swing.JLabel();
        campoEnderecoCaixa = new javax.swing.JTextField();
        painelImpressoraCozinha = new javax.swing.JPanel();
        botaoRadioEthernetCozinha = new javax.swing.JRadioButton();
        textoInterfaceCozinha = new javax.swing.JLabel();
        botaoRadioParalelaCozinha = new javax.swing.JRadioButton();
        textoModeloCozinha = new javax.swing.JLabel();
        comboboxModeloCozinha = new javax.swing.JComboBox();
        textoEnderecoCozinha = new javax.swing.JLabel();
        campoEnderecoCozinha = new javax.swing.JTextField();
        textoDefinaModelosEPortas = new javax.swing.JLabel();
        painelDebug = new javax.swing.JPanel();
        textoDefinaConfiguracoesDebug = new javax.swing.JLabel();
        checkboxIniciarConsole = new javax.swing.JCheckBox();
        textoParaFazerEfeito = new javax.swing.JLabel();
        botaoSalvarConfiguracoes = new javax.swing.JButton();
        botaCancelarConfiguracoes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurações - Sistema Pastelão");
        setMinimumSize(new java.awt.Dimension(644, 420));

        painelSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textoIconeConfiguracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/settings-64.png"))); // NOI18N
        textoIconeConfiguracoes.setToolTipText("");

        textoConfiguracoes.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        textoConfiguracoes.setText("Configurações");

        textoNaveguePelasAbas.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        textoNaveguePelasAbas.setText("Navegue pelas abas abaixo para definir as configurações do sistema.");

        javax.swing.GroupLayout painelSuperiorLayout = new javax.swing.GroupLayout(painelSuperior);
        painelSuperior.setLayout(painelSuperiorLayout);
        painelSuperiorLayout.setHorizontalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoIconeConfiguracoes)
                .addGap(18, 18, 18)
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoConfiguracoes)
                    .addComponent(textoNaveguePelasAbas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelSuperiorLayout.setVerticalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelSuperiorLayout.createSequentialGroup()
                        .addComponent(textoConfiguracoes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoNaveguePelasAbas))
                    .addComponent(textoIconeConfiguracoes))
                .addContainerGap())
        );

        painelComAbasGeral.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        painelImpressoraCaixa.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Caixa"));

        textoModeloCaixa.setText("Modelo:");

        comboboxModeloCaixa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o modelo", "MP-4000 TH", "MP-4200 TH" }));

        textoInterfaceCaixa.setText("Interface:");

        grupoBotoesCaixa.add(botaoRadioParalelaCaixa);
        botaoRadioParalelaCaixa.setText("Paralela");

        grupoBotoesCaixa.add(botaoRadioEthernetCaixa);
        botaoRadioEthernetCaixa.setText("Ethernet");

        textoEnderecoCaixa.setText("Endereço IP:");

        javax.swing.GroupLayout painelImpressoraCaixaLayout = new javax.swing.GroupLayout(painelImpressoraCaixa);
        painelImpressoraCaixa.setLayout(painelImpressoraCaixaLayout);
        painelImpressoraCaixaLayout.setHorizontalGroup(
            painelImpressoraCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImpressoraCaixaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelImpressoraCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelImpressoraCaixaLayout.createSequentialGroup()
                        .addComponent(textoModeloCaixa)
                        .addGap(18, 18, 18)
                        .addComponent(comboboxModeloCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelImpressoraCaixaLayout.createSequentialGroup()
                        .addComponent(textoInterfaceCaixa)
                        .addGap(18, 18, 18)
                        .addComponent(botaoRadioParalelaCaixa)
                        .addGap(18, 18, 18)
                        .addComponent(botaoRadioEthernetCaixa))
                    .addGroup(painelImpressoraCaixaLayout.createSequentialGroup()
                        .addComponent(textoEnderecoCaixa)
                        .addGap(18, 18, 18)
                        .addComponent(campoEnderecoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        painelImpressoraCaixaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {textoEnderecoCaixa, textoInterfaceCaixa, textoModeloCaixa});

        painelImpressoraCaixaLayout.setVerticalGroup(
            painelImpressoraCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImpressoraCaixaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelImpressoraCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoModeloCaixa)
                    .addComponent(comboboxModeloCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelImpressoraCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoInterfaceCaixa)
                    .addGroup(painelImpressoraCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoRadioParalelaCaixa)
                        .addComponent(botaoRadioEthernetCaixa)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelImpressoraCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoEnderecoCaixa)
                    .addComponent(campoEnderecoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        painelImpressoraCozinha.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cozinha"));

        grupoBotoesCozinha.add(botaoRadioEthernetCozinha);
        botaoRadioEthernetCozinha.setText("Ethernet");

        textoInterfaceCozinha.setText("Interface:");

        grupoBotoesCozinha.add(botaoRadioParalelaCozinha);
        botaoRadioParalelaCozinha.setText("Paralela");

        textoModeloCozinha.setText("Modelo:");

        comboboxModeloCozinha.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o modelo", "MP-4000 TH", "MP-4200 TH" }));

        textoEnderecoCozinha.setText("Endereço IP:");

        javax.swing.GroupLayout painelImpressoraCozinhaLayout = new javax.swing.GroupLayout(painelImpressoraCozinha);
        painelImpressoraCozinha.setLayout(painelImpressoraCozinhaLayout);
        painelImpressoraCozinhaLayout.setHorizontalGroup(
            painelImpressoraCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImpressoraCozinhaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelImpressoraCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelImpressoraCozinhaLayout.createSequentialGroup()
                        .addComponent(textoModeloCozinha)
                        .addGap(18, 18, 18)
                        .addComponent(comboboxModeloCozinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelImpressoraCozinhaLayout.createSequentialGroup()
                        .addComponent(textoInterfaceCozinha)
                        .addGap(18, 18, 18)
                        .addComponent(botaoRadioParalelaCozinha)
                        .addGap(18, 18, 18)
                        .addComponent(botaoRadioEthernetCozinha))
                    .addGroup(painelImpressoraCozinhaLayout.createSequentialGroup()
                        .addComponent(textoEnderecoCozinha)
                        .addGap(18, 18, 18)
                        .addComponent(campoEnderecoCozinha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelImpressoraCozinhaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {textoEnderecoCozinha, textoInterfaceCozinha, textoModeloCozinha});

        painelImpressoraCozinhaLayout.setVerticalGroup(
            painelImpressoraCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImpressoraCozinhaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelImpressoraCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoModeloCozinha)
                    .addComponent(comboboxModeloCozinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelImpressoraCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoInterfaceCozinha)
                    .addGroup(painelImpressoraCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoRadioParalelaCozinha)
                        .addComponent(botaoRadioEthernetCozinha)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelImpressoraCozinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoEnderecoCozinha)
                    .addComponent(campoEnderecoCozinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        textoDefinaModelosEPortas.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoDefinaModelosEPortas.setText("Defina abaixo os modelos e portas das impressoras do sistema:");

        javax.swing.GroupLayout painelImpressorasLayout = new javax.swing.GroupLayout(painelImpressoras);
        painelImpressoras.setLayout(painelImpressorasLayout);
        painelImpressorasLayout.setHorizontalGroup(
            painelImpressorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImpressorasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelImpressorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoDefinaModelosEPortas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelImpressorasLayout.createSequentialGroup()
                        .addComponent(painelImpressoraCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelImpressoraCozinha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelImpressorasLayout.setVerticalGroup(
            painelImpressorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelImpressorasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoDefinaModelosEPortas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelImpressorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelImpressoraCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelImpressoraCozinha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        painelComAbasGeral.addTab("Impressoras", painelImpressoras);

        textoDefinaConfiguracoesDebug.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        textoDefinaConfiguracoesDebug.setText("Defina abaixo as configurações para debugar o sistema:");

        checkboxIniciarConsole.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkboxIniciarConsole.setText("Ativar Console ao iniciar o sistema");

        textoParaFazerEfeito.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        textoParaFazerEfeito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoParaFazerEfeito.setText("Para estas alterações fazerem efeito, é necessário fechar e abrir novamente o sistema");

        javax.swing.GroupLayout painelDebugLayout = new javax.swing.GroupLayout(painelDebug);
        painelDebug.setLayout(painelDebugLayout);
        painelDebugLayout.setHorizontalGroup(
            painelDebugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDebugLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDebugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDebugLayout.createSequentialGroup()
                        .addComponent(checkboxIniciarConsole)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDebugLayout.createSequentialGroup()
                        .addGroup(painelDebugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textoParaFazerEfeito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textoDefinaConfiguracoesDebug, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        painelDebugLayout.setVerticalGroup(
            painelDebugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDebugLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoDefinaConfiguracoesDebug)
                .addGap(18, 18, 18)
                .addComponent(checkboxIniciarConsole)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(textoParaFazerEfeito)
                .addContainerGap())
        );

        painelComAbasGeral.addTab("Debug", painelDebug);

        botaoSalvarConfiguracoes.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        botaoSalvarConfiguracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/ok-32.png"))); // NOI18N
        botaoSalvarConfiguracoes.setText("Salvar Alterações nas Configurações");
        botaoSalvarConfiguracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarConfiguracoesActionPerformed(evt);
            }
        });

        botaCancelarConfiguracoes.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        botaCancelarConfiguracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/cancel-32.png"))); // NOI18N
        botaCancelarConfiguracoes.setText("CancelarAlterações nas Configurações");
        botaCancelarConfiguracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaCancelarConfiguracoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaCancelarConfiguracoes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoSalvarConfiguracoes))
                    .addComponent(painelComAbasGeral)
                    .addComponent(painelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelComAbasGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvarConfiguracoes)
                    .addComponent(botaCancelarConfiguracoes))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(660, 459));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void preencheCamposImpressora() {
        modeloImpressoraCaixa = Integer.parseInt(prop.getProperty("prop.impressora.caixa.modelo"));
        modeloImpressoraCozinha = Integer.parseInt(prop.getProperty("prop.impressora.cozinha.modelo"));
        switch (modeloImpressoraCaixa) {
            case 5:
                comboboxModeloCaixa.setSelectedIndex(1);
                break;
            case 7:
                comboboxModeloCaixa.setSelectedIndex(2);
                break;
            default:
                comboboxModeloCaixa.setSelectedIndex(0);
        }
        switch (modeloImpressoraCozinha) {
            case 5:
                comboboxModeloCozinha.setSelectedIndex(1);
                break;
            case 7:
                comboboxModeloCozinha.setSelectedIndex(2);
                break;
            default:
                comboboxModeloCozinha.setSelectedIndex(0);
        }
        interfaceImpressoraCaixa = prop.getProperty("prop.impressora.caixa.interface");
        interfaceImpressoraCozinha = prop.getProperty("prop.impressora.cozinha.interface");
        switch (interfaceImpressoraCaixa) {
            case "ethernet":
                botaoRadioEthernetCaixa.setSelected(true);
                break;
            case "paralela":
                botaoRadioParalelaCaixa.setSelected(true);
                break;
            default:
                grupoBotoesCaixa.clearSelection();
        }
        switch (interfaceImpressoraCozinha) {
            case "ethernet":
                botaoRadioEthernetCozinha.setSelected(true);
                break;
            case "paralela":
                botaoRadioParalelaCozinha.setSelected(true);
                break;
            default:
                grupoBotoesCozinha.clearSelection();
        }
        enderecoImpressoraCaixa = prop.getProperty("prop.impressora.caixa.endereco");
        enderecoImpressoraCozinha = prop.getProperty("prop.impressora.cozinha.endereco");
        if (botaoRadioEthernetCaixa.isSelected()) {
            textoEnderecoCaixa.setEnabled(true);
            campoEnderecoCaixa.setEnabled(true);
            campoEnderecoCaixa.setText(enderecoImpressoraCaixa);
        }
        if (botaoRadioEthernetCozinha.isSelected()) {
            textoEnderecoCozinha.setEnabled(true);
            campoEnderecoCozinha.setEnabled(true);
            campoEnderecoCozinha.setText(enderecoImpressoraCozinha);
        }
        enderecoImpressoraCaixa = prop.getProperty("prop.impressora.caixa.endereco");
        enderecoImpressoraCozinha = prop.getProperty("prop.impressora.cozinha.endereco");

    }

    private void preencheCamposDebug() {
        ativarConsole = Boolean.parseBoolean(prop.getProperty("prop.debug.console"));
        if (ativarConsole) {
            checkboxIniciarConsole.setSelected(true);
        }
    }

    private void botaCancelarConfiguracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaCancelarConfiguracoesActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaCancelarConfiguracoesActionPerformed

    private void botaoSalvarConfiguracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarConfiguracoesActionPerformed
        // VERIFICAR E SALVAR AS CONFIGS, no momento apenas a config do console está sendo salva
        try {
            boolean saveProp = ManipulaConfigs.setProp("prop.debug.console", String.valueOf(checkboxIniciarConsole.isSelected()));
            System.out.println("O console agora foi configurado para: " + getProp().getProperty("prop.debug.console"));
        } catch (IOException ex) {
            Logger.getLogger(TelaConfiguracoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_botaoSalvarConfiguracoesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaConfiguracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConfiguracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConfiguracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConfiguracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConfiguracoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaCancelarConfiguracoes;
    private javax.swing.JRadioButton botaoRadioEthernetCaixa;
    private javax.swing.JRadioButton botaoRadioEthernetCozinha;
    private javax.swing.JRadioButton botaoRadioParalelaCaixa;
    private javax.swing.JRadioButton botaoRadioParalelaCozinha;
    private javax.swing.JButton botaoSalvarConfiguracoes;
    private javax.swing.JTextField campoEnderecoCaixa;
    private javax.swing.JTextField campoEnderecoCozinha;
    private javax.swing.JCheckBox checkboxIniciarConsole;
    private javax.swing.JComboBox comboboxModeloCaixa;
    private javax.swing.JComboBox comboboxModeloCozinha;
    private javax.swing.ButtonGroup grupoBotoesCaixa;
    private javax.swing.ButtonGroup grupoBotoesCozinha;
    private javax.swing.JTabbedPane painelComAbasGeral;
    private javax.swing.JPanel painelDebug;
    private javax.swing.JPanel painelImpressoraCaixa;
    private javax.swing.JPanel painelImpressoraCozinha;
    private javax.swing.JPanel painelImpressoras;
    private javax.swing.JPanel painelSuperior;
    private javax.swing.JLabel textoConfiguracoes;
    private javax.swing.JLabel textoDefinaConfiguracoesDebug;
    private javax.swing.JLabel textoDefinaModelosEPortas;
    private javax.swing.JLabel textoEnderecoCaixa;
    private javax.swing.JLabel textoEnderecoCozinha;
    private javax.swing.JLabel textoIconeConfiguracoes;
    private javax.swing.JLabel textoInterfaceCaixa;
    private javax.swing.JLabel textoInterfaceCozinha;
    private javax.swing.JLabel textoModeloCaixa;
    private javax.swing.JLabel textoModeloCozinha;
    private javax.swing.JLabel textoNaveguePelasAbas;
    private javax.swing.JLabel textoParaFazerEfeito;
    // End of variables declaration//GEN-END:variables
}
