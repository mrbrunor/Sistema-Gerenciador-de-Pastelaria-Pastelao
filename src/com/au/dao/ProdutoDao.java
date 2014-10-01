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
import com.au.bean.Produto;
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
public class ProdutoDao {

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
    public int adicionaProduto(Produto novoProd) {
        String sql = "INSERT INTO Produto(numProd,descProd,valorProd,codBarras,eIndustrializado) values(?,?,?,?,?)";
        PreparedStatement stmt;
        int resultado = 0;

        try {
            stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, novoProd.getNumProd());
            stmt.setString(2, novoProd.getDescProd());
            stmt.setDouble(3, novoProd.getValorProd());
            stmt.setString(4, novoProd.getCodBarras());
            stmt.setInt(5, novoProd.getEIndustrializado());

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
    public List<Produto> getLista() {
        String sql = "SELECT * FROM Produto";
        PreparedStatement stmt;
        ResultSet res;
        List<Produto> listaResProd = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            res = stmt.executeQuery();
            while (res.next()) {
                Produto novoProd = new Produto();
                novoProd.setIdProd(res.getInt("idProd"));
                novoProd.setNumProd(res.getInt("numProd"));
                novoProd.setDescProd(res.getString("descProd"));
                novoProd.setValorProd(res.getDouble("valorProd"));
                novoProd.setCodBarras(res.getString("codBarras"));
                novoProd.setEIndustrializado(res.getInt("eIndustrializado"));
                listaResProd.add(novoProd);
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResProd;
    }
    
    public List<Produto> pesquisarProduto(String pesquisa) {
        String sql = "SELECT * FROM Produto WHERE descProd LIKE ? OR numProd LIKE ?";
        PreparedStatement stmt;
        ResultSet res;
        List<Produto> listaResProd = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pesquisa);
            stmt.setString(2, pesquisa);
            res = stmt.executeQuery();
            while (res.next()) {
                Produto novoProd = new Produto();
                novoProd.setIdProd(res.getInt("idProd"));
                novoProd.setNumProd(res.getInt("numProd"));
                novoProd.setDescProd(res.getString("descProd"));
                novoProd.setValorProd(res.getDouble("valorProd"));
                novoProd.setCodBarras(res.getString("codBarras"));
                novoProd.setEIndustrializado(res.getInt("eIndustrializado"));
                listaResProd.add(novoProd);
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResProd;
    }

    public Produto buscaCodigo(int numProd) {
        String sql = "SELECT * FROM Produto WHERE numProd=?";
        PreparedStatement stmt;
        ResultSet res;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, numProd);
            res = stmt.executeQuery();
            if (res != null) {
                while (res.next()) {
                    Produto novoProd = new Produto();
                    novoProd.setIdProd(res.getInt("idProd"));
                    novoProd.setNumProd(res.getInt("numProd"));
                    novoProd.setDescProd(res.getString("descProd"));
                    novoProd.setValorProd(res.getDouble("valorProd"));
                    novoProd.setCodBarras(res.getString("codBarras"));
                    novoProd.setEIndustrializado(res.getInt("eIndustrializado"));
                    return novoProd;
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Produto buscaId(int idProd) {
        String sql = "SELECT * FROM Produto WHERE idProd=?";
        PreparedStatement stmt;
        ResultSet res;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idProd);
            res = stmt.executeQuery();
            if (res != null) {
                while (res.next()) {
                    Produto novoProd = new Produto();
                    novoProd.setIdProd(res.getInt("idProd"));
                    novoProd.setNumProd(res.getInt("numProd"));
                    novoProd.setDescProd(res.getString("descProd"));
                    novoProd.setValorProd(res.getDouble("valorProd"));
                    novoProd.setCodBarras(res.getString("codBarras"));
                    novoProd.setEIndustrializado(res.getInt("eIndustrializado"));
                    return novoProd;
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean validaNome(String descProd) {
        String sql = "SELECT * FROM Produto WHERE descProd=?";
        PreparedStatement stmt;
        ResultSet res;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, descProd);
            res = stmt.executeQuery();
            if (res != null) {
                while (res.next()) {
                    return true;
                }
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean validaCodigo(int numProd) {
        String sql = "SELECT * FROM Produto WHERE numProd=?";
        PreparedStatement stmt;
        ResultSet res;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, numProd);
            res = stmt.executeQuery();
            if (res != null) {
                while (res.next()) {
                    return true;
                }
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //UPDATE
    public boolean atualizaProduto(Produto produto) {
        String sql = "UPDATE Produto SET numProd=?, descProd=?, valorProd=?, codBarras=?, eIndustrializado=? WHERE idProd=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, produto.getNumProd());
            stmt.setString(2, produto.getDescProd());
            stmt.setDouble(3, produto.getValorProd());
            stmt.setString(4, produto.getCodBarras());
            stmt.setInt(5, produto.getEIndustrializado());
            stmt.setInt(6, produto.getIdProd());

            resultado = stmt.execute();
            stmt.close();
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    //DELETE
    public boolean deletaProduto(Produto produto) {
        String sql = "DELETE FROM Produto WHERE idProd=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, produto.getIdProd());

            resultado = stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
