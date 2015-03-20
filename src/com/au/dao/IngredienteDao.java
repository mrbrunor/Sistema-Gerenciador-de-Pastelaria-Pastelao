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
import com.au.bean.Ingrediente;
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
public class IngredienteDao {

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
    public boolean adicionaIngrediente(Ingrediente novoIng) {
        String sql = "INSERT INTO sistemapastelao.Ingrediente(descIng,valorIng) values(?,?)";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, novoIng.getDescIng());
            stmt.setDouble(2, novoIng.getValorIng());
            resultado = stmt.execute();
            stmt.close();
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    //READ
    public List<Ingrediente> getLista() {
        String sql = "SELECT * FROM sistemapastelao.Ingrediente";
        PreparedStatement stmt;
        ResultSet res;
        List<Ingrediente> listaResIng = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            res = stmt.executeQuery();

            while (res.next()) {
                Ingrediente novoIng = new Ingrediente();
                novoIng.setDescIng(res.getString("descIng"));
                novoIng.setIdIng(res.getInt("idIng"));
                novoIng.setValorIng(res.getDouble("valorIng"));
                listaResIng.add(novoIng);
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResIng;
    }
    
    public List<Ingrediente> pesquisarIngrediente(String pesquisa) {
        String sql = "SELECT * FROM sistemapastelao.Ingrediente WHERE descIng like ?";
        PreparedStatement stmt;
        ResultSet res;
        List<Ingrediente> listaResIng = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pesquisa);
            res = stmt.executeQuery();

            while (res.next()) {
                Ingrediente novoIng = new Ingrediente();
                novoIng.setDescIng(res.getString("descIng"));
                novoIng.setIdIng(res.getInt("idIng"));
                novoIng.setValorIng(res.getDouble("valorIng"));
                listaResIng.add(novoIng);
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResIng;
    }
    
    public List<Ingrediente> pesquisarIngredientePorProduto(int idProd) {
        String sql = "SELECT i.idIng, i.descIng, i.valorIng FROM sistemapastelao.ingrediente as i JOIN sistemapastelao.receita as r on i.idIng = r.idIng JOIN produto as p on r.idProd = p.idProd WHERE p.idProd=?";
        PreparedStatement stmt;
        ResultSet res;
        List<Ingrediente> listaResIng = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idProd);
            res = stmt.executeQuery();

            while (res.next()) {
                Ingrediente novoIng = new Ingrediente();
                novoIng.setDescIng(res.getString("descIng"));
                novoIng.setIdIng(res.getInt("idIng"));
                novoIng.setValorIng(res.getDouble("valorIng"));
                listaResIng.add(novoIng);
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResIng;
    }

    public boolean validaIngrediente(String descIng) {
        String sql = "SELECT * FROM sistemapastelao.Ingrediente where descIng = ?";
        PreparedStatement stmt;
        ResultSet res;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, descIng);
            res = stmt.executeQuery();

            if (res.next()) {
                res.close();
                stmt.close();
                return true;
            } else {
                res.close();
                stmt.close();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    //UPDATE
    public boolean atualizaIngrediente(Ingrediente novoIng) {
        String sql = "UPDATE sistemapastelao.Ingrediente SET descIng=?, valorIng=? WHERE idIng=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, novoIng.getDescIng());
            stmt.setDouble(2, novoIng.getValorIng());
            stmt.setInt(3, novoIng.getIdIng());
            resultado = stmt.execute();
            stmt.close();
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;

    }//DELETE

    public boolean deletaIngrediente(Ingrediente novoIng) {
        String sql = "DELETE FROM sistemapastelao.Ingrediente WHERE idIng=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novoIng.getIdIng());
            resultado = stmt.execute();
            stmt.close();
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
