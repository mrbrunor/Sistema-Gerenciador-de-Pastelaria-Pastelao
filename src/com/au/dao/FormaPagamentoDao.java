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

import com.au.bean.FormaPagamento;
import com.au.conexao.FabricaConexao;
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
public class FormaPagamentoDao {

    Connection conexao = null;
    
    //Cria Conexão
    public void abreConnection(){
        conexao = new FabricaConexao().getConexao();
    }
    
    //Finaliza Conexão
    public void fechaConnection() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(FormaPagamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //CRUD
    
    //CREATE
    public boolean adicionaFormaPagamento(FormaPagamento novaFormaPagamento) {
        String sql = "INSERT INTO FormaPagamnto(nomeFormaPgto, tipoFormaPgto, estaAtivo) values(?,?,?)";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, novaFormaPagamento.getNomeFormaPgto());
            stmt.setString(2, novaFormaPagamento.getTipoFormaPgto());
            stmt.setInt(2, novaFormaPagamento.getEstaAtivo());

            resultado = stmt.execute();
            stmt.close();
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    //READ
    public List<FormaPagamento> getLista() {
        String sql = "SELECT * FROM FormaPagamento";
        PreparedStatement stmt;
        ResultSet res;
        List<FormaPagamento> listaResFormaPagamento = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            res = stmt.executeQuery();
            while (res.next()) {
                FormaPagamento formaPagamento = new FormaPagamento();
                formaPagamento.setIdFormaPgto(res.getInt("idFormaPgto"));
                formaPagamento.setNomeFormaPgto(res.getString("nomeFormaPgto"));
                formaPagamento.setTipoFormaPgto(res.getString("tipoFormaPgto"));
                formaPagamento.setEstaAtivo(res.getInt("estaAtivo"));
                listaResFormaPagamento.add(formaPagamento);
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResFormaPagamento;
    }
    
    //UPDATE
    public boolean atualizaFormaPagamento(FormaPagamento formaPagamento) {
        String sql = "UPDATE FormaPagamento set nomeFormaPgto=?, tipoFormaPgto=?, estaAtivo=? where idFormaPgto=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, formaPagamento.getNomeFormaPgto());
            stmt.setString(2, formaPagamento.getTipoFormaPgto());
            stmt.setInt(3, formaPagamento.getEstaAtivo());
            stmt.setInt(4, formaPagamento.getIdFormaPgto());
            resultado = stmt.execute();
            stmt.close();
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    //DELETE
    public boolean deletaReceita(FormaPagamento formaPagamento){
        String sql = "DELETE FROM FormaPagamento where idFormaPgto=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, formaPagamento.getIdFormaPgto());
            resultado = stmt.execute();
            stmt.close();
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;       
    }
}