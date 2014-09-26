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
package old.com.au.gui.listener;

import com.au.conexao.FabricaConexao;
import old.com.au.gui.TelaVendasPorFormaPgto;
import com.au.util.GeradorRelatorio;
import com.au.util.JFileChooserCustomizado;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Classe Listener da tela TelaVendasGerais
 *
 * @author tiago_000
 */
public class VendasPorFormaPgtoActionListener implements ActionListener, ListSelectionListener {

    private final TelaVendasPorFormaPgto frm;
    private Border vermelha = new MatteBorder(1, 1, 1, 1, Color.red);
    private Border normal;

    /**
     * Construtor Default do Listener, o qual recebe o objeto do tipo
     * TelaVendasPorFormaPgto
     *
     * @param frm Parâmetro recebido
     */
    public VendasPorFormaPgtoActionListener(TelaVendasPorFormaPgto frm) {
        this.frm = frm;
        normal = frm.getCampoLocalParaSalvar().getBorder();
        frm.getCampoDataInicio().setBorder(normal);
        frm.getCampoDataTermino().setBorder(normal);
        adicionaListener();
    }

    /**
     *
     */
    public void adicionaListener() {
        frm.getBotaoProcurarLocal().addActionListener(this);
        frm.getBotaoGerarRelatorio().addActionListener(this);
        frm.getBotaoCancelarGeracaoDeRelatorio().addActionListener(this);
        frm.getBotaoRadioDinheiro().addActionListener(this);
        frm.getBotaoRadioCartaoCredito().addActionListener(this);
        frm.getBotaoRadioCartaoDebito().addActionListener(this);
        frm.getBotaoRadioValeRefeicao().addActionListener(this);
    }

    public void habilitaDinheiro() {
        limpaBorda();
        frm.getCaixaSelecaoCC().setVisible(false);
        frm.getCaixaSelecaoCC().setSelectedIndex(-1);
        frm.getCaixaSelecaoCD().setVisible(false);
        frm.getCaixaSelecaoCD().setSelectedIndex(-1);
        frm.getCaixaSelecaoVR().setVisible(false);
        frm.getCaixaSelecaoVR().setSelectedIndex(-1);
    }

    public void habilitaCC() {
        limpaBorda();
        frm.getCaixaSelecaoCC().setVisible(true);
        frm.getCaixaSelecaoCC().setSelectedIndex(-1);
        frm.getCaixaSelecaoCD().setVisible(false);
        frm.getCaixaSelecaoCD().setSelectedIndex(-1);
        frm.getCaixaSelecaoVR().setVisible(false);
        frm.getCaixaSelecaoVR().setSelectedIndex(-1);
    }

    public void habilitaCD() {
        limpaBorda();
        frm.getCaixaSelecaoCC().setVisible(false);
        frm.getCaixaSelecaoCC().setSelectedIndex(-1);
        frm.getCaixaSelecaoCD().setVisible(true);
        frm.getCaixaSelecaoCD().setSelectedIndex(-1);
        frm.getCaixaSelecaoVR().setVisible(false);
        frm.getCaixaSelecaoVR().setSelectedIndex(-1);
    }

    public void habilitaVR() {
        limpaBorda();
        frm.getCaixaSelecaoCC().setVisible(false);
        frm.getCaixaSelecaoCC().setSelectedIndex(-1);
        frm.getCaixaSelecaoCD().setVisible(false);
        frm.getCaixaSelecaoCD().setSelectedIndex(-1);
        frm.getCaixaSelecaoVR().setVisible(true);
        frm.getCaixaSelecaoVR().setSelectedIndex(-1);
    }

    public void limpaBorda() {
        frm.getBotaoRadioCartaoDebito().setBorderPainted(false);
        frm.getBotaoRadioCartaoCredito().setBorderPainted(false);
        frm.getBotaoRadioDinheiro().setBorderPainted(false);
        frm.getBotaoRadioValeRefeicao().setBorderPainted(false);
        frm.getCaixaSelecaoCC().setBorder(normal);
        frm.getCaixaSelecaoCD().setBorder(normal);
        frm.getCaixaSelecaoVR().setBorder(normal);
    }

    public boolean valida() {
        boolean valida = true;

        if (frm.getCampoDataInicio().getDate() != null) {
            frm.getCampoDataInicio().setBorder(normal);
        } else {
            frm.getCampoDataInicio().setBorder(vermelha);
            valida = false;
        }

        if (frm.getCampoDataTermino().getDate() != null) {
            frm.getCampoDataTermino().setBorder(normal);
        } else {
            frm.getCampoDataTermino().setBorder(vermelha);
            valida = false;
        }

        if (frm.getBotaoRadioDinheiro().isSelected() || frm.getBotaoRadioCartaoCredito().isSelected() || frm.getBotaoRadioCartaoDebito().isSelected() || frm.getBotaoRadioValeRefeicao().isSelected()) {
            limpaBorda();
        } else {
            valida = false;
            frm.getBotaoRadioCartaoDebito().setBorder(vermelha);
            frm.getBotaoRadioCartaoDebito().setBorderPainted(true);
            frm.getBotaoRadioCartaoCredito().setBorder(vermelha);
            frm.getBotaoRadioCartaoCredito().setBorderPainted(true);
            frm.getBotaoRadioDinheiro().setBorder(vermelha);
            frm.getBotaoRadioDinheiro().setBorderPainted(true);
            frm.getBotaoRadioValeRefeicao().setBorder(vermelha);
            frm.getBotaoRadioValeRefeicao().setBorderPainted(true);
        }
        if (frm.getBotaoRadioCartaoCredito().isSelected()) {
            if (frm.getCaixaSelecaoCC().getSelectedIndex() == -1) {
                valida = false;
                frm.getCaixaSelecaoCC().setBorder(vermelha);
            }
        } else {
            frm.getCaixaSelecaoCC().setBorder(normal);
        }
        if (frm.getBotaoRadioCartaoDebito().isSelected()) {
            if (frm.getCaixaSelecaoCD().getSelectedIndex() == -1) {
                valida = false;
                frm.getCaixaSelecaoCD().setBorder(vermelha);
            }
        } else {
            frm.getCaixaSelecaoCD().setBorder(normal);
        }
        if (frm.getBotaoRadioValeRefeicao().isSelected()) {
            if (frm.getCaixaSelecaoVR().getSelectedIndex() == -1) {
                valida = false;
                frm.getCaixaSelecaoVR().setBorder(vermelha);
            }
        } else {
            frm.getCaixaSelecaoVR().setBorder(normal);
        }

        if (!"".equals(frm.getCampoLocalParaSalvar().getText())) {
            frm.getCampoLocalParaSalvar().setBorder(normal);
        } else {
            valida = false;
            frm.getCampoLocalParaSalvar().setBorder(vermelha);
        }
        return valida;
    }

    private void procuraLocal() {
        JFileChooserCustomizado file = new JFileChooserCustomizado(".", "pdf");
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        file.setFileFilter(new FileNameExtensionFilter("Documentos em PDF", "pdf"));
        int selecao = file.showSaveDialog(frm);
        if (selecao != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File arquivo = file.getSelectedFile();
        if (arquivo.exists() && JOptionPane.showConfirmDialog(this.frm, "O Arquivo já existe. Deseja mesmo substituí-lo?", "Substituir Arquivo Existente", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }
        String localArquivo = arquivo.getAbsolutePath();
        frm.getCampoLocalParaSalvar().setText(localArquivo);
    }

    private void geraRelatorio() throws ParseException {
        String nome = "reports\\vendas_por_pagamento.jasper";
        Map<String, Object> parametros = new HashMap<>();
        Connection conexao = new FabricaConexao().getConexao();
        OutputStream saida = null;
        String tipoPgto = "";
        String nomePgto = "";
        try {
            saida = new FileOutputStream(frm.getCampoLocalParaSalvar().getText());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VendasPorFormaPgtoActionListener.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(frm, "Houve um erro ao salvar o arquivo:\n" + ex);
            return;
        }
        File arquivo = new File(frm.getCampoLocalParaSalvar().getText());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dataIni = sdf.format(frm.getCampoDataInicio().getDate());
        String dataFim = sdf.format(frm.getCampoDataTermino().getDate());

        Date dataInicial = sdf.parse(dataIni);
        Date dataFinal = sdf.parse(dataFim);

        if (frm.getBotaoRadioDinheiro().isSelected()) {
            tipoPgto = "Dinheiro";
            nomePgto = "Dinheiro";
        } else if (frm.getBotaoRadioCartaoCredito().isSelected()) {
            tipoPgto = "Credito";
            nomePgto = frm.getCaixaSelecaoCC().getSelectedItem().toString();
        } else if (frm.getBotaoRadioCartaoDebito().isSelected()) {
            tipoPgto = "Debito";
            nomePgto = frm.getCaixaSelecaoCD().getSelectedItem().toString();
        } else if (frm.getBotaoRadioValeRefeicao().isSelected()) {
            tipoPgto = "Vale";
            nomePgto = frm.getCaixaSelecaoVR().getSelectedItem().toString();
        }

        parametros.put("DATA_INI", dataInicial);
        parametros.put("DATA_FIM", dataFinal);
        parametros.put("TIPO_PGTO", tipoPgto);
        parametros.put("NOME_PGTO", nomePgto);

        GeradorRelatorio gerador = new GeradorRelatorio(nome, parametros, conexao);
        gerador.geraPdfParaOutputStream(saida);

        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(frm, "Relatório Gerado com Sucesso!\nDeseja abrir o relatório agora?", "Geração de Relatório", JOptionPane.YES_NO_OPTION)) {
            try {
                Desktop.getDesktop().open(arquivo);

            } catch (IOException ex) {
                Logger.getLogger(VendasPorFormaPgtoActionListener.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Método responsável por capturar qualquer ActionPerformed da tela Vendas
     * Por Forma de Pagamento
     *
     * @param event Objeto do tipo ActionEvent contendo o ActionPerformed
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Dinheiro":
                habilitaDinheiro();
                frm.getBotaoGerarRelatorio().requestFocus();
                break;
            case "Cartão de Crédito":
                habilitaCC();
                break;
            case "Cartão de Débito":
                habilitaCD();
                break;
            case "Vale Refeição":
                habilitaVR();
                break;
            case "Procurar":
                procuraLocal();
                break;
            case "Gerar Relatório":
                if (valida()) {
                    JOptionPane.showMessageDialog(frm, "A geração de Relatórios pode demorar alguns minutos. \n Aguarde a mensagem de confirmação.");
                    try {
                        geraRelatorio();
                    } catch (ParseException ex) {
                        Logger.getLogger(VendasPorFormaPgtoActionListener.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    frm.dispose();
                }
                
                break;
            case "Cancelar Geração de Relatório":
                frm.dispose();
                break;
        }
    }

    /**
     *
     * @param event
     */
    @Override
    public void valueChanged(ListSelectionEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
