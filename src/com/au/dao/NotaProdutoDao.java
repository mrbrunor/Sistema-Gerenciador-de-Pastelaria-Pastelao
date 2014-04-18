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
import com.au.bean.NotaProduto;
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
public class NotaProdutoDao {
    Connection conexao = null;
    
    //Construtor
    public NotaProdutoDao(){
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
    public boolean adicionaNotaProduto(NotaProduto novaNotaProduto) {
        String sql = "INSERT INTO NotaProduto(idProd, idNota, qtdNota, valorNota) values(?,?,?,?)";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novaNotaProduto.getIdProd());
            stmt.setInt(2, novaNotaProduto.getIdNota());
            stmt.setInt(3, novaNotaProduto.getQtdNota());
            stmt.setDouble(4, novaNotaProduto.getValorNota());

            resultado = stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    //READ
    public List<NotaProduto> getLista() {
        String sql = "SELECT * FROM NotaProduto";
        PreparedStatement stmt;
        ResultSet res;
        List<NotaProduto> listaResNotaProduto = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            res = stmt.executeQuery();
            while (res.next()) {
                NotaProduto receita = new NotaProduto();
                receita.setIdProd(res.getInt("idProd"));
                receita.setIdNota(res.getInt("idNota"));
                receita.setQtdNota(res.getInt("qtdNota"));
                receita.setValorNota(res.getInt("valorNota"));
                listaResNotaProduto.add(receita);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResNotaProduto;
    }
    
    //UPDATE
    public boolean atualizaNotaProduto(NotaProduto antigaNotaProduto, NotaProduto novaNotaProduto) {
        String sql = "UPDATE NotaProduto SET idProd=?, qtdNota=?, valorNota=? WHERE idNota=? AND idProd=? ";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novaNotaProduto.getIdProd());
            stmt.setInt(2, novaNotaProduto.getQtdNota());
            stmt.setDouble(3, novaNotaProduto.getValorNota());
            stmt.setInt(4, antigaNotaProduto.getIdNota());
            stmt.setInt(5, antigaNotaProduto.getIdProd());

            resultado = stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    //DELETE
    public boolean deletaNotaProduto(NotaProduto novaNotaProduto) {
        String sql = "DELETE FROM NotaProduto WHERE idNota=? AND idProd=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novaNotaProduto.getIdNota());
            stmt.setInt(2, novaNotaProduto.getIdProd());

            resultado = stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
