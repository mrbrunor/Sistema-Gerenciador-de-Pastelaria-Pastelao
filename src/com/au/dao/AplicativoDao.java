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

import com.au.bean.Aplicativo;
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
public class AplicativoDao {

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
            Logger.getLogger(AplicativoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //CRUD
    
    //CREATE
    public boolean adicionaAplicativo(Aplicativo oAplicativoaFormaPagamento) {
        String sql = "INSERT INTO sistemapastelao.Aplicativo(nomeAplicativo, estaAtivo) values(?,?)";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oAplicativoaFormaPagamento.getNomeAplicativo());            
            stmt.setInt(2, oAplicativoaFormaPagamento.getEstaAtivo());

            resultado = stmt.execute();
            stmt.close();
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    //READ
    public List<Aplicativo> getLista() {
        String sql = "SELECT * FROM sistemapastelao.Aplicativo";
        PreparedStatement stmt;
        ResultSet res;
        List<Aplicativo> listaResAplicativo = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            res = stmt.executeQuery();
            while (res.next()) {
                Aplicativo aplicativo = new Aplicativo();
                aplicativo.setIdAplicativo(res.getInt("idAplicativo"));
                aplicativo.setNomeAplicativo(res.getString("nomeAplicativo"));                
                aplicativo.setEstaAtivo(res.getInt("estaAtivo"));
                listaResAplicativo.add(aplicativo);
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResAplicativo;
    }
    
    public Aplicativo listaAplicativoPorId(int idAplicativo) {
        String sql = "SELECT * FROM sistemapastelao.Aplicativo where idAplicativo=?";
        PreparedStatement stmt;
        ResultSet res;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idAplicativo);
            res = stmt.executeQuery();
            while (res.next()) {
                Aplicativo aplicativo = new Aplicativo();
                aplicativo.setIdAplicativo(res.getInt("idAplicativo"));
                aplicativo.setNomeAplicativo(res.getString("nomeAplicativo"));                
                aplicativo.setEstaAtivo(res.getInt("estaAtivo"));
                return aplicativo;
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Aplicativo> pesquisarAplicativo(String pesquisa) {
        String sql = "SELECT * FROM sistemapastelao.Aplicativo where idAplicativo like ? OR nomeAplicativo like ?";
        PreparedStatement stmt;
        ResultSet res;
        List<Aplicativo> listaResAplicativo = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pesquisa);
            stmt.setString(2, pesquisa);
            res = stmt.executeQuery();
            while (res.next()) {
                Aplicativo aplicativo = new Aplicativo();
                aplicativo.setIdAplicativo(res.getInt("idAplicativo"));
                aplicativo.setNomeAplicativo(res.getString("nomeAplicativo"));                
                aplicativo.setEstaAtivo(res.getInt("estaAtivo"));
                listaResAplicativo.add(aplicativo);
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResAplicativo;
    }
    
    //UPDATE
    public boolean atualizaAplicativo(Aplicativo aplicativo) {
        String sql = "UPDATE sistemapastelao.Aplicativo set nomeAplicativo=?, estaAtivo=? where idAplicativo=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, aplicativo.getNomeAplicativo());            
            stmt.setInt(2, aplicativo.getEstaAtivo());
            stmt.setInt(3, aplicativo.getIdAplicativo());
            resultado = stmt.execute();
            stmt.close();
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    //DELETE
    public boolean deletaAplicativo(Aplicativo aplicativo){
        String sql = "DELETE FROM sistemapastelao.Aplicativo where idAplicativo=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, aplicativo.getIdAplicativo());
            resultado = stmt.execute();
            stmt.close();
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;       
    }
}