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
import com.au.bean.Pedido;
import com.au.bean.Produto;
import com.au.bean.FormaPagamento;
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
    public int adicionaPedido(Pedido novoPedido) {
        String sql = "INSERT INTO sistemapastelao.Pedido(numPedido, dataPedido, horaPedido, idCaixa, subTotPedido, descPedido, totPedido, valorRecebido, idFormaPgto, estadoPedido, formaConsumo) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt;
        int resultado = 0;

        try {
            stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
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
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    resultado = (int) generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    //READ
    public List<Pedido> getLista() {
        String sql = "SELECT * FROM sistemapastelao.Pedido";
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
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResPedido;
    }
    
    public Pedido buscaPedidoPorId(int idPedido) {
        String sql = "SELECT * FROM sistemapastelao.pedido as p JOIN sistemapastelao.formapagamento as fp on p.idFormaPgto = fp.idFormaPgto WHERE p.idPedido=?";
        PreparedStatement stmt;
        ResultSet res;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idPedido);
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
                
                FormaPagamento fp = new FormaPagamento();
                fp.setIdFormaPgto(res.getInt("idFormaPgto"));
                fp.setNomeFormaPgto(res.getString("nomeFormaPgto"));
                fp.setTipoFormaPgto(res.getString("tipoFormaPgto"));
                fp.setEstaAtivo(res.getByte("estaAtivo"));
                
                pedido.setFormaPagamento(fp);
                
                return pedido;
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Pedido> listaPedidosPorCaixa(int idCaixa) {
        String sql = "SELECT * FROM sistemapastelao.Pedido WHERE idCaixa=?";
        PreparedStatement stmt;
        ResultSet res;
        List<Pedido> listaResPedido = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idCaixa);
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
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResPedido;
    }
    
    public Pedido listaItemPedido(Pedido pedido) {
        String sql = "SELECT * FROM sistemapastelao.itempedido as ip JOIN sistemapastelao.produto as prod on ip.idProd = prod.idProd WHERE ip.idPedido=? ORDER BY ip.ordemProduto";
        PreparedStatement stmt;
        ResultSet res;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, pedido.getIdPedido());
            res = stmt.executeQuery();
            while (res.next()) {
                ItemPedido ip = new ItemPedido();
                ip.setIdPedido(res.getInt("idPedido"));
                ip.setIdProd(res.getInt("idProd"));
                ip.setQtdProd(res.getInt("qtdProd"));
                ip.setTotProd(res.getDouble("totProd"));
                ip.setOrdemProduto(res.getInt("ordemProduto"));
                
                Produto prod = new Produto();
                prod.setIdProd(res.getInt("idProd"));
                prod.setNumProd(res.getInt("numProd"));
                prod.setDescProd(res.getString("descProd"));
                prod.setValorProd(res.getDouble("valorProd"));
                prod.setCodBarras(res.getString("codBarras"));
                prod.setEIndustrializado(res.getByte("eIndustrializado"));
                
                ip.setProduto(prod);
                pedido.getItempedidos().add(ip);
                
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedido;
    }
    
    //UPDATE
    public boolean atualizaPedido(Pedido novoPedido) {
        String sql = "UPDATE sistemapastelao.Pedido SET numPedido=?, dataPedido=?, horaPedido=?, idCaixa=?, subTotPedido=?, descPedido=?, totPedido=?, valorRecebido=?, idFormaPagto=?, estadoPedido=?, formaConsumo=? WHERE idPedido=?";
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
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    //DELETE
    public boolean deletaPedido(Pedido novoPedido) {
        String sql = "DELETE FROM sistemapastelao.Pedido WHERE idPedido=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novoPedido.getIdPedido());

            stmt.execute();
            stmt.close();
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
