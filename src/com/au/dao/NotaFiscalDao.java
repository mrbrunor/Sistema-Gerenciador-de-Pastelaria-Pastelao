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
import com.au.bean.NotaFiscal;
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
public class NotaFiscalDao {
    Connection conexao = null;
    
    //Construtor
    public NotaFiscalDao(){
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
    public boolean adicionaNotaFiscal(NotaFiscal novaNotaFiscal) {
        String sql = "INSERT INTO NotaFiscal(idForn, dataNota, horaNota, idDesp, subTotNota, descNota, totNota) values(?,?,?,?,?,?,?,?)";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novaNotaFiscal.getIdForn());
            stmt.setDate(2, novaNotaFiscal.getDataNota());
            stmt.setTime(3, novaNotaFiscal.getHoraNota());
            stmt.setInt(4, novaNotaFiscal.getIdDesp());
            stmt.setDouble(5, novaNotaFiscal.getSubTotNota());
            stmt.setDouble(6, novaNotaFiscal.getDescNota());
            stmt.setDouble(7, novaNotaFiscal.getTotNota());

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
    public List<NotaFiscal> getLista() {
        String sql = "SELECT * FROM NotaFiscal";
        PreparedStatement stmt;
        ResultSet res;
        List<NotaFiscal> listaResNotaFiscal = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            res = stmt.executeQuery();
            while (res.next()) {
                NotaFiscal notaFiscal = new NotaFiscal();
                notaFiscal.setIdNota(res.getInt("idNota"));
                notaFiscal.setIdForn(res.getInt("idForn"));
                notaFiscal.setDataNota(res.getDate("dataNota"));
                notaFiscal.setHoraNota(res.getTime("horaNota"));
                notaFiscal.setIdDesp(res.getInt("idDesp"));
                notaFiscal.setSubTotNota(res.getDouble("subTotNota"));
                notaFiscal.setDescNota(res.getDouble("descNota"));
                notaFiscal.setTotNota(res.getDouble("totNota"));
                listaResNotaFiscal.add(notaFiscal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResNotaFiscal;
    }
    
    //UPDATE    
    public boolean atualizaNotaFiscal(NotaFiscal novaNotaFiscal) {
        String sql = "UPDATE NotaFiscal SET idForn=?, dataNota=?, horaNota=?, idDesp=?, subTotNota=?, descNota=?, totNota=? WHERE idNota=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novaNotaFiscal.getIdForn());
            stmt.setDate(2, novaNotaFiscal.getDataNota());
            stmt.setTime(3, novaNotaFiscal.getHoraNota());
            stmt.setInt(4, novaNotaFiscal.getIdDesp());
            stmt.setDouble(5, novaNotaFiscal.getSubTotNota());
            stmt.setDouble(6, novaNotaFiscal.getDescNota());
            stmt.setDouble(7, novaNotaFiscal.getTotNota());
            stmt.setInt(8, novaNotaFiscal.getIdNota());

            stmt.execute();
            stmt.close();
            conexao.close();
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    //DELETA    
    public boolean deletaNotaFiscal(NotaFiscal novaNotaFiscal) {
        String sql = "DELETE FROM NotaFiscal WHERE idNota=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novaNotaFiscal.getIdNota());

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
