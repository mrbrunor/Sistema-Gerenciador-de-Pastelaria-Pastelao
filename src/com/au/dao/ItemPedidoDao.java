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
import com.au.bean.Caixa;
import com.au.bean.ItemPedido;
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
public class ItemPedidoDao {
    Connection conexao = null;
    
    //Construtor
    public ItemPedidoDao(){
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
    public boolean adicionaItemPedido(ItemPedido novoItemPedido) {
        String sql = "INSERT INTO itemPedido(idPedido, idProd, qtdProd, totProd) values(?,?,?,?)";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novoItemPedido.getIdPedido());
            stmt.setInt(2, novoItemPedido.getIdProd());
            stmt.setInt(3, novoItemPedido.getQtdProd());
            stmt.setDouble(4, novoItemPedido.getTotProd());

            stmt.execute();
            stmt.close();
            conexao.close();
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    //READ
    public List<ItemPedido> getLista() {
        String sql = "SELECT * FROM ItemPedido";
        PreparedStatement stmt;
        ResultSet res;
        List<ItemPedido> listaResItemPedido = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            res = stmt.executeQuery();
            while (res.next()) {
                ItemPedido itemPedido = new ItemPedido();
                itemPedido.setIdPedido(res.getInt("idPedido"));
                itemPedido.setIdProd(res.getInt("idProd"));
                itemPedido.setQtdProd(res.getInt("qtdProd"));
                itemPedido.setTotProd(res.getDouble("totProd"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResItemPedido;
    }
    
    //UPDATE    
    public boolean atualizaItemPedido(ItemPedido novoItemPedido) {
        String sql = "UPDATE ItemPedido SET qtdProd=?, totProd=? WHERE idPedido=? AND idProd=? ";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);            
            stmt.setInt(1, novoItemPedido.getQtdProd());
            stmt.setDouble(2, novoItemPedido.getTotProd());
            stmt.setInt(3, novoItemPedido.getIdPedido());
            stmt.setInt(4, novoItemPedido.getIdProd());

            stmt.execute();
            stmt.close();
            conexao.close();
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    //DELETE
    public boolean deletaItemPedido(ItemPedido novoItemPedido) {
        String sql = "DELETE FROM ItemPedido WHERE idPedido=? AND idProd=? ";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novoItemPedido.getIdPedido());
            stmt.setInt(2, novoItemPedido.getIdProd());
            
            stmt.execute();
            stmt.close();
            conexao.close();
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
