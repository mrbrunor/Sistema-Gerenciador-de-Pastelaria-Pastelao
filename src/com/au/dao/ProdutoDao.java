/*
 * The MIT License
 *
 * Copyright 2014 BrunoRicardo.
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

package com.au.dao;

import com.au.bd.FabricaConexao;
import com.au.bean.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BrunoRicardo
 */
public class ProdutoDao {
    Connection conexao = null;
    
    public ProdutoDao(){
        conexao = new FabricaConexao().getConexao();
    }
    
    public boolean addProdutoInd(Produto novoProd){
        String sql = "INSERT INTO Produto(idProd,descProd,valorProd,qtdProd,idForn,codBarras,eIndustrializado) values(?,?,?,?,?,?,?)";
        PreparedStatement stmt;
        boolean resultado=false;
        
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novoProd.getIdProd());
            stmt.setString(2, novoProd.getDescProd());
            stmt.setDouble(3, novoProd.getValorProd());
            stmt.setInt(4, novoProd.getQtdProd());
            stmt.setInt(5, novoProd.getIdForn());
            stmt.setString(6, novoProd.getCodBarras());
            stmt.setBoolean(7, novoProd.getEIndustrializado());
            
            resultado = stmt.execute();
            stmt.close();
            conexao.close();
        }
        catch (SQLException ex){
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    public boolean addProdutoPrep(Produto novoProd){
        String sql = "INSERT INTO Produto(idProd,descProd,valorProd,idForn,eIndustrializado) values(?,?,?,?,?)";
        PreparedStatement stmt;
        boolean resultado=false;
        
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novoProd.getIdProd());
            stmt.setString(2, novoProd.getDescProd());
            stmt.setDouble(3, novoProd.getValorProd());
            stmt.setInt(4, novoProd.getIdForn());
            stmt.setBoolean(5, novoProd.getEIndustrializado());
            
            resultado = stmt.execute();
            stmt.close();
            conexao.close();
        }
        catch (SQLException ex){
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
