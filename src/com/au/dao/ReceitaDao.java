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
import com.au.bean.Receita;
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
public class ReceitaDao {

    Connection conexao = null;
    
    //Construtor
    public ReceitaDao() {
        conexao = new FabricaConexao().getConexao();
    }
    
    //Cria Conexão
    public void abreConnection(){
        conexao = new FabricaConexao().getConexao();
    }
    
    //Finaliza Conexão
    public void fechaConnection() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReceitaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //CRUD
    
    //CREATE
    public boolean adicionaReceita(Receita novaReceita) {
        String sql = "INSERT INTO Receita(idProd, idIng) values(?,?)";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novaReceita.getIdProd());
            stmt.setInt(2, novaReceita.getIdIng());

            resultado = stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    //READ
    public List<Receita> getLista() {
        String sql = "SELECT * FROM Receita";
        PreparedStatement stmt;
        ResultSet res;
        List<Receita> listaResReceita = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            res = stmt.executeQuery();
            while (res.next()) {
                Receita receita = new Receita();
                receita.setIdProd(res.getInt("idProd"));
                receita.setIdIng(res.getInt("idIng"));
                listaResReceita.add(receita);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResReceita;
    }
    
    //UPDATE
    public boolean atualizaReceita(Receita antigaReceita, Receita novaReceita) {
        String sql = "UPDATE Receita set idIng=? where idProd=? and idIng=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novaReceita.getIdIng());
            stmt.setInt(2, novaReceita.getIdProd());
            stmt.setInt(3, antigaReceita.getIdIng());
            resultado = stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    //DELETE
    public boolean deletaReceita(Receita receita){
        String sql = "DELETE FROM Receita where idProd=? and idIng=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, receita.getIdProd());
            stmt.setInt(2, receita.getIdIng());
            resultado = stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;       
    }
}
