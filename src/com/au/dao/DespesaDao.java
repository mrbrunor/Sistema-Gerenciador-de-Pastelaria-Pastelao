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
import com.au.bean.Despesa;
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
public class DespesaDao {

    Connection conexao = null;

    //Inicia Conexão
    public void abreConnection() {
        conexao = new FabricaConexao().getConexao();
    }

    //Finaliza Conexão
    public void fechaConnection() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(CaixaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //CRUD
    //CREATE    
    public boolean adicionaDespesa(Despesa novaDesp) {
        String sql = "INSERT INTO sistemapastelao.Despesa(dataDesp,descDesp,valorDesp,idCaixa,retirada) values(?,?,?,?,?)";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setDate(1, novaDesp.getDataDesp());
            stmt.setString(2, novaDesp.getDescDesp());
            stmt.setDouble(3, novaDesp.getValorDesp());
            stmt.setInt(4, novaDesp.getIdCaixa());
            stmt.setInt(5, novaDesp.getRetirada());

            stmt.execute();
            stmt.close();
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    //READ
    public List<Despesa> getLista() {
        String sql = "SELECT * FROM sistemapastelao.Despesa";
        PreparedStatement stmt;
        ResultSet res;
        List<Despesa> listaResDesp = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            res = stmt.executeQuery();
            while (res.next()) {
                Despesa despesa = new Despesa();
                despesa.setIdDesp(res.getInt("idCaixa"));
                despesa.setDataDesp(res.getDate("dataDesp"));
                despesa.setDescDesp(res.getString("descDesp"));
                despesa.setValorDesp(res.getDouble("valorDesp"));
                despesa.setIdCaixa(res.getInt("idCaixa"));
                despesa.setRetirada(res.getInt("retirada"));
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResDesp;
    }
    
    public List<Despesa> listaDespesasPorCaixa(int idCaixa) {
        String sql = "SELECT * FROM sistemapastelao.Despesa WHERE idCaixa=?";
        PreparedStatement stmt;
        ResultSet res;
        List<Despesa> listaResDesp = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idCaixa);
            res = stmt.executeQuery();
            while (res.next()) {
                Despesa despesa = new Despesa();
                despesa.setIdDesp(res.getInt("idCaixa"));
                despesa.setDataDesp(res.getDate("dataDesp"));
                despesa.setDescDesp(res.getString("descDesp"));
                despesa.setValorDesp(res.getDouble("valorDesp"));
                despesa.setIdCaixa(res.getInt("idCaixa"));
                despesa.setRetirada(res.getInt("retirada"));
                listaResDesp.add(despesa);
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResDesp;
    }

//UPDATE
    public boolean atualizaDesp(Despesa novaDespesa) {
        String sql = "UPDATE sistemapastelao.Despesa SET dataDesp=?, descDesp=?, valorDesp=?, idCaixa=?, retirada=? WHERE idDesp=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setDate(1, novaDespesa.getDataDesp());
            stmt.setString(2, novaDespesa.getDescDesp());
            stmt.setDouble(3, novaDespesa.getValorDesp());
            stmt.setInt(4, novaDespesa.getIdCaixa());
            stmt.setInt(5, novaDespesa.getRetirada());
            stmt.setInt(6, novaDespesa.getIdDesp());

            stmt.execute();
            stmt.close();
            resultado = true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    //DELETE
    public boolean removeDespesa(Despesa novaDespesa) {
        String sql = "DELETE FROM sistemapastelao.Despesa WHERE idDesp=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novaDespesa.getIdDesp());

            stmt.execute();
            stmt.close();
            resultado = true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
