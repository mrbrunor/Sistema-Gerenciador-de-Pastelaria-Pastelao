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
    
    //Construtor
    public DespesaDao(){
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
    public boolean adicionaDespesa(Despesa novaDesp) {
        String sql = "INSERT INTO Despesa(dataDesp,descDesp,valorDesp,idCaixa,retirada) values(?,?,?,?,?)";
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
            conexao.close();
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    //READ
    public List<Despesa> getLista() {
        String sql = "SELECT * FROM Despesa";
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
                listaResDesp.add(despesa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResDesp;
    }

    //UPDATE
    public boolean atualizaDesp(Despesa novaDespesa) {
        String sql = "UPDATE Despesa SET dataDesp=?, descDesp=?, valorDesp=?, idCaixa=?, retirada=? WHERE idDesp=?";
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
            conexao.close();
            resultado = true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    //DELETE
    public boolean deletaDespesa(Despesa novaDespesa) {
        String sql = "DELETE FROM Despesa WHERE idDesp=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novaDespesa.getIdDesp());

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
