/*
 * The MIT License
 *
 * Copyright 2014.
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

package com.au.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author BrunoRicardo
 */
public class FabricaConexao {
    String usuario = "root";
    String senha = "27639932xD";
    String url = "jdbc:mysql://sistemapastelao.no-ip.biz:3306/sistemapastelao";
    Connection ready = null;
    /**
     * 
     * @return 
     * Função para criar uma conexão e retorna-la
     */
    public Connection getConexao(){
        try{
            ready = DriverManager.getConnection(url, usuario, senha);
            return ready;
        }
        catch(SQLException fail){
            System.out.println("Impossivel Conectar: " + fail);
            return ready;
        }
    }        
}
