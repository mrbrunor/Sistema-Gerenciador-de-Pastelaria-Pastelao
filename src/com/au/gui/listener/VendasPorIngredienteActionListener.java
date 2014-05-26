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
import com.au.gui.TelaVendasPorIngrediente;
import com.au.util.GeradorRelatorio;
import com.au.util.JFileChooserCustomizado;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Classe Listener da tela TelaVendasPorIngrediente
 *
 * @author tiago_000
 */
public class VendasPorIngredienteActionListener implements ActionListener, ListSelectionListener {

    private final TelaVendasPorIngrediente frm;

    /**
     * Construtor Default do Listener, o qual recebe o objeto do tipo
 TelaVendasPorIngrediente
     *
     * @param frm Parâmetro recebido
     */
    public VendasPorIngredienteActionListener(TelaVendasPorIngrediente frm) {
        this.frm = frm;
        adicionaListener();
    }

    /**
     *
     */
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
        System.out.println("Salvar como arquivo: " + arquivo.getAbsolutePath());
        String localArquivo = arquivo.getAbsolutePath();
        frm.getCampoLocalParaSalvar().setText(localArquivo);
    }

    private void geraRelatorio() throws ParseException {
        String nome = "src\\com\\au\\resources\\reports\\vendas_por_ingrediente.jasper";
        Map<String, Object> parametros = new HashMap<>();
        Connection conexao = new FabricaConexao().getConexao();
        OutputStream saida = null;
        try {
            saida = new FileOutputStream(frm.getCampoLocalParaSalvar().getText());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VendasPorIngredienteActionListener.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(frm, "Houve um erro ao salvar o arquivo:\n" + ex);
            return;
        }
        File arquivo = new File(frm.getCampoLocalParaSalvar().getText());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dataIni = sdf.format(frm.getCampoDataInicio().getDate());
        String dataFim = sdf.format(frm.getCampoDataTermino().getDate());

        Date dataInicial = sdf.parse(dataIni);
        Date dataFinal = sdf.parse(dataFim);
        String ingrediente = (String) frm.getComboBoxIngredientes().getSelectedItem();

        parametros.put("DATA_INI", dataInicial);
        parametros.put("DATA_FIM", dataFinal);
        parametros.put("INGREDIENTE", ingrediente);

        GeradorRelatorio gerador = new GeradorRelatorio(nome, parametros, conexao);
        gerador.geraPdfParaOutputStream(saida);

        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(frm, "Relatório Gerado com Sucesso!\nDeseja abrir o relatório agora?", "Geração de Relatório", JOptionPane.YES_NO_OPTION)) {
            try {
                Desktop.getDesktop().open(arquivo);

            } catch (IOException ex) {
                Logger.getLogger(VendasPorIngredienteActionListener.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Método responsável por capturar qualquer ActionPerformed da tela
     * VendasPorPeríodo
     *
     * @param event Objeto do tipo ActionEvent contendo o ActionPerformed
     */
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
                    } catch (ParseException ex) {
                        Logger.getLogger(VendasPorIngredienteActionListener.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                }
                frm.dispose();
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
