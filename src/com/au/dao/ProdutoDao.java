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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    public void abreConnection(){
        conexao = new FabricaConexao().getConexao();
    }
    
    public void fechaConnection() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReceitaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            stmt.setBoolean(7, novoProd.iseIndustrializado());
            
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
            stmt.setBoolean(5, novoProd.iseIndustrializado());
            
            resultado = stmt.execute();
            stmt.close();
            conexao.close();
        }
        catch (SQLException ex){
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    public boolean updateProdutoInd(Produto produto){
        String sql = "UPDATE Produto SET descProd=?, valorProd=?, qtdProd=?,idForn=?,codBarras=?,eIndustrializado=?) WHERE idProd=?)";
        PreparedStatement stmt;
        boolean resultado=false;
        
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, produto.getDescProd());
            stmt.setDouble(2, produto.getValorProd());
            stmt.setInt(3, produto.getQtdProd());
            stmt.setInt(4, produto.getIdForn());
            stmt.setString(5, produto.getCodBarras());
            stmt.setBoolean(6, produto.iseIndustrializado());
            stmt.setInt(7, produto.getIdProd());
            
            resultado = stmt.execute();
            stmt.close();
            conexao.close();
        }
        catch (SQLException ex){
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    public boolean updateProdutoPrep(Produto produto){
        String sql = "UPDATE Produto SET descProd=?, valorProd=?, idForn=?, eIndustrializado=? WHERE idProd=?";
        PreparedStatement stmt;
        boolean resultado=false;
        
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, produto.getDescProd());
            stmt.setDouble(2, produto.getValorProd());
            stmt.setInt(3, produto.getIdForn());
            stmt.setBoolean(4, produto.iseIndustrializado());
            stmt.setInt(5, produto.getIdProd());
            
            resultado = stmt.execute();
            stmt.close();
            conexao.close();
        }
        catch (SQLException ex){
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    public boolean deleteProduto(Produto produto){
        String sql = "DELETE FOM Produto WHERE idProd=?";
        PreparedStatement stmt;
        boolean resultado=false;
        
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, produto.getIdProd());
            
            resultado = stmt.execute();
            stmt.close();
            conexao.close();
        }
        catch (SQLException ex){
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public List<Produto> getLista(String pesquisa){
        String sql = "SELECT * FROM Produto WHERE descProd LIKE ? OR idProd LIKE ?";
        PreparedStatement stmt;
        ResultSet res;
        List<Produto> listaResProd = new ArrayList<>();
        
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pesquisa);
            stmt.setString(2, pesquisa);
            res = stmt.executeQuery();                        
            while(res.next()){
                Produto novoProd = new Produto();
                novoProd.setIdProd(res.getInt("idProd"));
                novoProd.setDescProd(res.getString("descProd"));
                novoProd.setValorProd(res.getDouble("valorProd"));                
                novoProd.setQtdProd(res.getInt("qtdProd"));                
                novoProd.setIdForn(res.getInt("idForn"));                
                novoProd.setCodBarras(res.getString("codBarras"));                
                novoProd.seteIndustrializado(res.getBoolean("eIndustrializado"));                
                listaResProd.add(novoProd);
            }
            res.close();
            stmt.close();
            conexao.close();
        }    
        catch (SQLException ex){
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResProd;
    }
}