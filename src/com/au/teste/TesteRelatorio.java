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

package com.au.teste;

import com.au.conexao.FabricaConexao;
import com.au.util.GeradorRelatorio;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tiago_000
 */
public class TesteRelatorio {
    public static void main (String[] args) throws FileNotFoundException, ParseException {
        String nome = "src\\com\\au\\resources\\reports\\Vendas Diárias.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        Connection conexao = new FabricaConexao().getConexao();
        OutputStream saida = new FileOutputStream("Relatório.pdf");
        
        String dataIni = "2014/05/14";
        String dataFim = "2014/05/15";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
        Date dataInicial = sdf.parse(dataIni);
        Date dataFinal = sdf.parse(dataFim);
        
        parametros.put("DATA_INI", dataInicial);
        parametros.put("DATA_FIM", dataFinal);
        
        //GeradorRelatorio gerador = new GeradorRelatorio(nome, parametros, conexao);
        //gerador.geraPdfParaOutputStream(saida);
    } 
}
