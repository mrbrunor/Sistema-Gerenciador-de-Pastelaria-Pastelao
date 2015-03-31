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
package com.au.util;

import java.sql.Connection;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author tiago_000
 */
public class GeradorRelatorio {

    private final Map<String, Object> parametros;
    private final Connection conexao;
    private final JasperReport templateCompilado;
    private final String caminhoImg;

    public GeradorRelatorio(String caminhoTemplate, Map<String, Object> parametros, Connection conexao) throws JRException {
        this.parametros = parametros;
        this.conexao = conexao;
        caminhoImg = "img\\Logomarca.png";

        parametros.put("LOGO", caminhoImg);
        templateCompilado = JasperCompileManager.compileReport(caminhoTemplate);
    }

    /* public void geraPdfParaOutputStream(OutputStream outputStream) {
     try {
     JasperPrint jasperPrint = JasperFillManager.fillReport(this.nomeArquivo, this.parametros, this.conexao);

     JRExporter exporter = new JRPdfExporter();
     exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
     exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
     exporter.exportReport();
     outputStream.close();
     } catch (JRException e) {
     throw new RuntimeException(e);
     } catch (IOException ex) {
     Logger.getLogger(GeradorRelatorio.class.getName()).log(Level.SEVERE, null, ex);
     }
     } */
    public void geraPdf(String localParaSalvar) {
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(templateCompilado, this.parametros, this.conexao);

            JasperExportManager.exportReportToPdfFile(jasperPrint, localParaSalvar);

        } catch (JRException e) {
            System.out.println("Houve Erro ao Compilar o Template... Foi utilizado o template pré-compilado em seu lugar");
            throw new RuntimeException(e);
        }
        //} catch (IOException ex) {
        //   Logger.getLogger(GeradorRelatorio.class.getName()).log(Level.SEVERE, null, ex);
    }

    public void geraPdf(String localParaSalvar, String templateAlternativo) {
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(templateAlternativo, this.parametros, this.conexao);

            JasperExportManager.exportReportToPdfFile(jasperPrint, localParaSalvar);
        } catch (JRException e) {
            System.out.println("Houve Erro ao usar o template pré-compilado... Impossível criar o relatório");
            throw new RuntimeException(e);
        }

    }
}
