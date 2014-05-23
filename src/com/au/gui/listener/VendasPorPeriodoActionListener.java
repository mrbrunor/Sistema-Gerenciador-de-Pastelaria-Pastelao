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
package com.au.gui.listener;

import com.au.bd.FabricaConexao;
import com.au.gui.TelaVendasPorPeriodo;
import com.au.util.ExtensionFilterFilePDF;
import com.au.util.GeradorRelatorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author tiago_000
 */
public class VendasPorPeriodoActionListener implements ActionListener, ListSelectionListener {

    private final TelaVendasPorPeriodo frm;

    public VendasPorPeriodoActionListener(TelaVendasPorPeriodo frm) {
        this.frm = frm;
        adicionaListener();
    }

    public void adicionaListener() {
        frm.getBotaoProcurarLocal().addActionListener(this);
        frm.getBotaoGerarRelatorio().addActionListener(this);
        frm.getBotaoCancelarGeracaoDeRelatorio().addActionListener(this);
    }

    private boolean valida() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }

    private void procuraLocal() {
        //Está Setando o caminho, porém se após ter setado procurar novamente e cancelar ele reseta
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        file.setFileFilter(new ExtensionFilterFilePDF());
        int i = file.showSaveDialog(this.frm);
        if (i == 1) {
            frm.getCampoLocalParaSalvar().setText("");
        }
        File arquivo = file.getSelectedFile();
        /* if (arquivo.exists()) {
            int result = JOptionPane.showConfirmDialog(this.frm, "O Arquivo já existe. Deseja mesmo substituí-lo?",
                    "Substituir Arquivo Existente", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                frm.getCampoLocalParaSalvar().setText(arquivo.getPath() + ".pdf");
            } else frm.getCampoLocalParaSalvar().setText("");
        } */
        frm.getCampoLocalParaSalvar().setText(arquivo.getPath() + ".pdf");
    }

    private void geraRelatorio() throws FileNotFoundException, ParseException {
        String nome = "src\\com\\au\\resources\\reports\\Vendas Diárias.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        Connection conexao = new FabricaConexao().getConexao();
        OutputStream saida = new FileOutputStream(frm.getCampoLocalParaSalvar().getText());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dataIni = sdf.format(frm.getCampoDataInicio().getDate());
        String dataFim = sdf.format(frm.getCampoDataTermino().getDate());

        Date dataInicial = sdf.parse(dataIni);
        Date dataFinal = sdf.parse(dataFim);

        parametros.put("DATA_INI", dataInicial);
        parametros.put("DATA_FIM", dataFinal);

        GeradorRelatorio gerador = new GeradorRelatorio(nome, parametros, conexao);
        gerador.geraPdfParaOutputStream(saida);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Procurar":
                if (valida()) {
                    procuraLocal();
                }
                break;
            case "Gerar Relatório":
                if (valida()) {
                    try {
                        geraRelatorio();
                        JOptionPane.showMessageDialog(frm, "Relatório Gerado com Sucesso!", "Geração de Relatório", JOptionPane.INFORMATION_MESSAGE);

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(VendasPorPeriodoActionListener.class
                                .getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(VendasPorPeriodoActionListener.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case "Cancelar Geração de Relatório":
                this.frm.dispose();
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}