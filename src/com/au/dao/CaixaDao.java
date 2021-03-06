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
import com.au.bean.Caixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BrunoRicardo
 */
public class CaixaDao {

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
    public int adicionaCaixa(Caixa novoCaixa) {
        String sql = "INSERT INTO sistemapastelao.Caixa(idFunc,fundoCaixa,dataAberturaCaixa,aberturaCaixa,fechamentoCaixa,datafechamentoCaixa,estaAberto,totalCaixa) values(?,?,?,?,?,?,?,?)";
        PreparedStatement stmt;
        int resultado = 0;

        try {
            stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, novoCaixa.getIdFunc());
            stmt.setDouble(2, novoCaixa.getFundoCaixa());
            stmt.setDate(3, novoCaixa.getDataAberturaCaixa());
            stmt.setTime(4, novoCaixa.getAberturaCaixa());
            stmt.setTime(5, novoCaixa.getFechamentoCaixa());
            stmt.setDate(6, novoCaixa.getDataFechamentoCaixa());
            stmt.setInt(7, novoCaixa.getEstaAberto());
            stmt.setDouble(8, novoCaixa.getTotalCaixa());
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
    public List<Caixa> getLista() {
        String sql = "SELECT * FROM sistemapastelao.Caixa";
        PreparedStatement stmt;
        ResultSet res;
        List<Caixa> listaResCaixa = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            res = stmt.executeQuery();
            while (res.next()) {
                Caixa caixa = new Caixa();
                caixa.setIdCaixa(res.getInt("idCaixa"));
                caixa.setIdFunc(res.getInt("idFunc"));                
                caixa.setFundoCaixa(res.getDouble("fundoCaixa"));
                caixa.setDataAberturaCaixa(res.getDate("dataAberturaCaixa"));
                caixa.setAberturaCaixa(res.getTime("aberturaCaixa"));
                caixa.setFechamentoCaixa(res.getTime("fechamentoCaixa"));
                caixa.setDataFechamentoCaixa(res.getDate("dataFechamentoCaixa"));
                caixa.setEstaAberto(res.getInt("estaAberto"));
                caixa.setTotalCaixa(res.getDouble("totalCaixa"));
                listaResCaixa.add(caixa);
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResCaixa;
    }

    public List<Caixa> listarCaixasDoFuncionario(int idFunc) {
        String sql = "SELECT * FROM sistemapastelao.Caixa where idFunc=? AND estaAberto=1";
        PreparedStatement stmt;
        ResultSet res;
        List<Caixa> listaResCaixa = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idFunc);
            res = stmt.executeQuery();
            while (res.next()) {
                Caixa caixa = new Caixa();
                caixa.setIdCaixa(res.getInt("idCaixa"));
                caixa.setIdFunc(res.getInt("idFunc"));
                caixa.setFundoCaixa(res.getDouble("fundoCaixa"));
                caixa.setDataAberturaCaixa(res.getDate("dataAberturaCaixa"));
                caixa.setAberturaCaixa(res.getTime("aberturaCaixa"));
                caixa.setFechamentoCaixa(res.getTime("fechamentoCaixa"));
                caixa.setDataFechamentoCaixa(res.getDate("dataFechamentoCaixa"));
                caixa.setEstaAberto(res.getInt("estaAberto"));
                caixa.setTotalCaixa(res.getDouble("totalCaixa"));
                listaResCaixa.add(caixa);
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResCaixa;
    }
    
    public Caixa listaCaixaPorId(int idCaixa) {
        String sql = "SELECT * FROM sistemapastelao.Caixa where idCaixa=?";
        PreparedStatement stmt;
        ResultSet res;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idCaixa);
            res = stmt.executeQuery();
            while (res.next()) {
                Caixa caixa = new Caixa();
                caixa.setIdCaixa(res.getInt("idCaixa"));
                caixa.setIdFunc(res.getInt("idFunc"));
                caixa.setFundoCaixa(res.getDouble("fundoCaixa"));
                caixa.setDataAberturaCaixa(res.getDate("dataAberturaCaixa"));
                caixa.setAberturaCaixa(res.getTime("aberturaCaixa"));
                caixa.setFechamentoCaixa(res.getTime("fechamentoCaixa"));
                caixa.setDataFechamentoCaixa(res.getDate("dataFechamentoCaixa"));
                caixa.setEstaAberto(res.getInt("estaAberto"));
                caixa.setTotalCaixa(res.getDouble("totalCaixa"));
                return caixa;
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Caixa> listaCaixaPersonalizado(Date dataInicio, Date dataFinal, int idFuncionario, boolean caixaAberto) {
        
        String sql;
        
        if (caixaAberto) {
            if(idFuncionario != 0) {
                sql = "SELECT * FROM sistemapastelao.Caixa where (dataAberturaCaixa BETWEEN ? AND ?) AND idFunc = ?";
            } else {
                sql = "SELECT * FROM sistemapastelao.Caixa where (dataAberturaCaixa BETWEEN ? AND ?)";
            }
        } else {
            if(idFuncionario != 0) {
                sql = "SELECT * FROM sistemapastelao.Caixa where (dataAberturaCaixa BETWEEN ? AND ?) AND idFunc = ? AND estaAberto = 0";
            } else {
                sql = "SELECT * FROM sistemapastelao.Caixa where (dataAberturaCaixa BETWEEN ? AND ?) AND estaAberto = 0";
            }
        }
                
        PreparedStatement stmt;
        ResultSet res;
        List<Caixa> listaResCaixa = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            java.sql.Date dateInicio = new java.sql.Date(dataInicio.getTime());
            java.sql.Date dateFinal = new java.sql.Date(dataFinal.getTime());
            
            stmt.setDate(1, dateInicio);
            stmt.setDate(2, dateFinal);
            if(idFuncionario != 0) {
                stmt.setInt(3, idFuncionario);            
            }
            res = stmt.executeQuery();           
            
            while (res.next()) {
                Caixa caixa = new Caixa();
                caixa.setIdCaixa(res.getInt("idCaixa"));
                caixa.setIdFunc(res.getInt("idFunc"));                
                caixa.setFundoCaixa(res.getDouble("fundoCaixa"));
                caixa.setDataAberturaCaixa(res.getDate("dataAberturaCaixa"));
                caixa.setAberturaCaixa(res.getTime("aberturaCaixa"));
                caixa.setFechamentoCaixa(res.getTime("fechamentoCaixa"));
                caixa.setDataFechamentoCaixa(res.getDate("dataFechamentoCaixa"));
                caixa.setEstaAberto(res.getInt("estaAberto"));
                caixa.setTotalCaixa(res.getDouble("totalCaixa"));
                listaResCaixa.add(caixa);
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResCaixa;
    }
    
    public Caixa listaDespesas(int idCaixa) {
        String sql = "SELECT * FROM sistemapastelao.Caixa where idCaixa=?";
        PreparedStatement stmt;
        ResultSet res;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idCaixa);
            res = stmt.executeQuery();
            while (res.next()) {
                Caixa caixa = new Caixa();
                caixa.setIdCaixa(res.getInt("idCaixa"));
                caixa.setIdFunc(res.getInt("idFunc"));
                caixa.setFundoCaixa(res.getDouble("fundoCaixa"));
                caixa.setDataAberturaCaixa(res.getDate("dataAberturaCaixa"));
                caixa.setAberturaCaixa(res.getTime("aberturaCaixa"));
                caixa.setFechamentoCaixa(res.getTime("fechamentoCaixa"));
                caixa.setDataFechamentoCaixa(res.getDate("dataFechamentoCaixa"));
                caixa.setEstaAberto(res.getInt("estaAberto"));
                caixa.setTotalCaixa(res.getDouble("totalCaixa"));
                return caixa;
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//UPDATE
    public boolean atualizaCaixa(Caixa novoCaixa) {
        String sql = "UPDATE sistemapastelao.Caixa SET idFunc=?, fundoCaixa=?, dataAberturaCaixa=?, aberturaCaixa=?, fechamentoCaixa=?, dataFechamentoCaixa=?, estaAberto=?, totalCaixa=? WHERE idCaixa=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novoCaixa.getIdFunc());
            stmt.setDouble(2, novoCaixa.getFundoCaixa());
            stmt.setDate(3, novoCaixa.getDataAberturaCaixa());
            stmt.setTime(4, novoCaixa.getAberturaCaixa());
            stmt.setTime(5, novoCaixa.getFechamentoCaixa());
            stmt.setDate(6, novoCaixa.getDataFechamentoCaixa());
            stmt.setInt(7, novoCaixa.getEstaAberto());
            stmt.setDouble(8, novoCaixa.getTotalCaixa());
            stmt.setInt(9, novoCaixa.getIdCaixa());

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
    public boolean deletaCaixa(Caixa novoCaixa) {
        String sql = "DELETE FROM sistemapastelao.Caixa WHERE idCaixa=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novoCaixa.getIdCaixa());

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
