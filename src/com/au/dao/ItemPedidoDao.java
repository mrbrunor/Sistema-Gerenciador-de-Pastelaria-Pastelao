/*
 * Copyright (C) 2014 BrunoRicardo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.au.dao;

import com.au.conexao.FabricaConexao;
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

    //Cria Conexão
    public void abreConnection() {
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
        String sql = "INSERT INTO itemPedido(idPedido, idProd, qtdProd, totProd, ordemProduto) values(?,?,?,?,?)";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novoItemPedido.getIdPedido());
            stmt.setInt(2, novoItemPedido.getIdProd());
            stmt.setInt(3, novoItemPedido.getQtdProd());
            stmt.setDouble(4, novoItemPedido.getTotProd());
            stmt.setInt(5, novoItemPedido.getOrdemProduto());

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
                itemPedido.setOrdemProduto(res.getInt("ordemProduto"));
            }
            res.close();
            stmt.close();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResItemPedido;
    }

    //UPDATE    
    public boolean atualizaItemPedido(ItemPedido novoItemPedido) {
        String sql = "UPDATE ItemPedido SET qtdProd=?, totProd=?, ordemProduto=? WHERE idPedido=? AND idProd=? ";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novoItemPedido.getQtdProd());
            stmt.setDouble(2, novoItemPedido.getTotProd());
            stmt.setInt(3, novoItemPedido.getOrdemProduto());
            stmt.setInt(4, novoItemPedido.getIdPedido());
            stmt.setInt(5, novoItemPedido.getIdProd());

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
