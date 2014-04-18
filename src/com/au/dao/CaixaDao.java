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
public class CaixaDao {

    Connection conexao = null;

    //Construtor
    public CaixaDao() {
        conexao = new FabricaConexao().getConexao();
    }

    //Inicia Conexão
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
    public boolean adicionaCaixa(Caixa novoCaixa) {
        String sql = "INSERT INTO Caixa(idFunc,fundoCaixa,dataCaixa,aberturaCaixa,fechamentoCaixa,estaAberto,totalCaixa) values(?,?,?,?,?,?,?)";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novoCaixa.getIdFunc());
            stmt.setDouble(2, novoCaixa.getFundoCaixa());
            stmt.setDate(3, novoCaixa.getDataCaixa());
            stmt.setTime(4, novoCaixa.getAberturaCaixa());
            stmt.setTime(5, novoCaixa.getFechamentoCaixa());
            stmt.setInt(6, novoCaixa.getEstaAberto());
            stmt.setDouble(7, novoCaixa.getTotalCaixa());

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
    public List<Caixa> getLista() {
        String sql = "SELECT * FROM Caixa";
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
                caixa.setDataCaixa(res.getDate("dataCaixa"));
                caixa.setAberturaCaixa(res.getTime("aberturaCaixa"));
                caixa.setFechamentoCaixa(res.getTime("fechamentoCaixa"));
                caixa.setEstaAberto(res.getInt("estaAberto"));
                caixa.setTotalCaixa(res.getDouble("totalCaixa"));
                listaResCaixa.add(caixa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResCaixa;
    }

//UPDATE
    public boolean atualizaCaixa(Caixa novoCaixa) {
        String sql = "UPDATE Caixa SET idFunc=?, fundoCaixa=?, dataCaixa=?, aberturaCaixa=?, fechamentoCaixa=?, estaAberto=?, totalCaixa=? WHERE idCaixa=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novoCaixa.getIdFunc());
            stmt.setDouble(2, novoCaixa.getFundoCaixa());
            stmt.setDate(3, novoCaixa.getDataCaixa());
            stmt.setTime(4, novoCaixa.getAberturaCaixa());
            stmt.setTime(5, novoCaixa.getFechamentoCaixa());
            stmt.setInt(6, novoCaixa.getEstaAberto());
            stmt.setDouble(7, novoCaixa.getTotalCaixa());
            stmt.setInt(8, novoCaixa.getIdCaixa());

            stmt.execute();
            stmt.close();
            conexao.close();
            resultado = true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    //DELETE
    public boolean deletaCaixa(Caixa novoCaixa) {
        String sql = "DELETE FROM Caixa WHERE idCaixa=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novoCaixa.getIdCaixa());

            stmt.execute();
            stmt.close();
            conexao.close();
            resultado = true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
