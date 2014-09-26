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
    public boolean adicionaPedido(Pedido novoPedido) {
        String sql = "INSERT INTO Pedido(numPedido, dataPedido, horaPedido, idCaixa, subTotPedido, descPedido, totPedido, valorRecebido, idFormaPagto, estadoPedido, formaConsumo) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
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
            stmt.setDouble(8, novoPedido.getValorRecebido());
            stmt.setInt(9, novoPedido.getIdFormaPgto());
            stmt.setString(10, novoPedido.getEstadoPedido());
            stmt.setString(11, novoPedido.getFormaConsumo());

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
                pedido.setValorRecebido(res.getDouble("valorRecebido"));
                pedido.setIdFormaPgto(res.getInt("idFormaPgto"));
                pedido.setEstadoPedido(res.getString("estadoPedido"));
                pedido.setFormaConsumo(res.getString("formaConsumo"));
                listaResPedido.add(pedido);
            }
            res.close();
            stmt.close();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResPedido;
    }

    //UPDATE
    public boolean atualizaPedido(Pedido novoPedido) {
        String sql = "UPDATE Pedido SET numPedido=?, dataPedido=?, horaPedido=?, idCaixa=?, subTotPedido=?, descPedido=?, totPedido=?, valorRecebido=?, idFormaPagto=?, estadoPedido=?, formaConsumo=? WHERE idPedido=?";
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
            stmt.setDouble(8, novoPedido.getValorRecebido());
            stmt.setInt(9, novoPedido.getIdFormaPgto());
            stmt.setString(10, novoPedido.getEstadoPedido());
            stmt.setString(11, novoPedido.getFormaConsumo());
            stmt.setInt(12, novoPedido.getIdPedido());

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
