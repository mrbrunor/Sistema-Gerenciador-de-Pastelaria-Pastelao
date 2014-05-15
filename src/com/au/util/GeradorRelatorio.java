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

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

/**
 *
 * @author tiago_000
 */
public class GeradorRelatorio {

    private final String nomeArquivo;
    private final Map<String, Object> parametros;
    private final Connection conexao;

    public GeradorRelatorio(String nomeArquivo, Map<String, Object> parametros, Connection conexao) {
        this.nomeArquivo = nomeArquivo;
        this.parametros = parametros;
        this.conexao = conexao;
    }

    public void geraPdfParaOutputStream(OutputStream outputStream) {
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
    }
}
