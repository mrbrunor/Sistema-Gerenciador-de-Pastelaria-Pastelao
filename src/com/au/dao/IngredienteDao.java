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
import com.au.bean.Ingrediente;
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
public class IngredienteDao {
    Connection conexao = null;
    
    public IngredienteDao(){
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
    
    
    public boolean addIngrediente(Ingrediente novoIng){
        String sql = "INSERT INTO Ingrediente(descIng,valorIng) values(?,?)";
        PreparedStatement stmt;
        boolean resultado=false;
        
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, novoIng.getDescIng());
            stmt.setDouble(2, novoIng.getValorIng());
            resultado = stmt.execute();
            stmt.close();
            conexao.close();
        }
        catch (SQLException ex){
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
        
    
    public List<Ingrediente> getLista(){
        String sql = "SELECT * FROM Ingrediente";
        PreparedStatement stmt;
        ResultSet res;
        List<Ingrediente> listaResIng = new ArrayList<>();
        
        try{
            stmt = conexao.prepareStatement(sql);
            res = stmt.executeQuery();                        
            
            while(res.next()){
                System.out.println("Entrou While res.next() Ingrediente");
                Ingrediente novoIng = new Ingrediente();
                novoIng.setDescIng(res.getString("descIng"));
                novoIng.setIdIng(res.getInt("idIng"));
                listaResIng.add(novoIng);
            }
            res.close();
            stmt.close();
            conexao.close();
        }    
        catch (SQLException ex){
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Lista Vazia " + listaResIng.isEmpty());
        System.out.println("Qtd Lista " + listaResIng.size());
        return listaResIng;
    }
}
