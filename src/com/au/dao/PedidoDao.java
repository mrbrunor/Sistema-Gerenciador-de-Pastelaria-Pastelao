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
import com.au.bean.Pedido;
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
public class PedidoDao {
    Connection conexao = null;
    
    //Construtor
    public PedidoDao(){
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
    public boolean adicionaPedido(Pedido novoPedido) {
        String sql = "INSERT INTO Pedido(numPedido, dataPedido, horaPedido, idCaixa, subTotPedido, descPedido, totPedido, formaPagtoPedido, estadoPedido) VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novoPedido.getNumPedido());
            stmt.setDate(2, novoPedido.getDataPedido());
            stmt.setTime(3, novoPedido.getHoraPedido());
            stmt.setInt(4, novoPedido.getIdCaixa());
            stmt.setDouble(5, novoPedido.getSubTotPedido());
            stmt.setDouble(6, novoPedido.getDescPedido());
            stmt.setDouble(7, novoPedido.getTotPedido());
            stmt.setString(8, novoPedido.getFormaPagtoPedido());
            stmt.setString(9, novoPedido.getEstadoPedido());

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
    public List<Pedido> getLista() {
        String sql = "SELECT * FROM Pedido";
        PreparedStatement stmt;
        ResultSet res;
        List<Pedido> listaResPedido = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            res = stmt.executeQuery();
            while (res.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(res.getInt("idPedido"));
                pedido.setNumPedido(res.getInt("numPedido"));
                pedido.setDataPedido(res.getDate("dataPedido"));
                pedido.setHoraPedido(res.getTime("horaPedido"));
                pedido.setIdCaixa(res.getInt("idCaixa"));
                pedido.setSubTotPedido(res.getDouble("subTotPedido"));
                pedido.setDescPedido(res.getDouble("descPedido"));
                pedido.setTotPedido(res.getDouble("totPedido"));
                pedido.setFormaPagtoPedido(res.getString("formaPagtoPedido"));
                pedido.setEstadoPedido(res.getString("estadoPedido"));
                listaResPedido.add(pedido);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResPedido;
    }
    
    //UPDATE
    public boolean atualizaPedido(Pedido novoPedido) {
        String sql = "UPDATE Pedido SET numPedido=?, dataPedido=?, horaPedido=?, idCaixa=?, subTotPedido=?, descPedido=?, totPedido=?, formaPagtoPedido=?, estadoPedido=? WHERE idPedido=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novoPedido.getNumPedido());
            stmt.setDate(2, novoPedido.getDataPedido());
            stmt.setTime(3, novoPedido.getHoraPedido());
            stmt.setInt(4, novoPedido.getIdCaixa());
            stmt.setDouble(5, novoPedido.getSubTotPedido());
            stmt.setDouble(6, novoPedido.getDescPedido());
            stmt.setDouble(7, novoPedido.getTotPedido());
            stmt.setString(8, novoPedido.getFormaPagtoPedido());
            stmt.setString(9, novoPedido.getEstadoPedido());
            stmt.setInt(10, novoPedido.getIdPedido());

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
    public boolean deletaPedido(Pedido novoPedido) {
        String sql = "DELETE FROM Pedido WHERE idPedido=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novoPedido.getIdPedido());

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
