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
import com.au.bean.Funcionario;
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
public class FuncionarioDao {

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
    public boolean adicionaFuncionario(Funcionario novoFunc) {
        String sql = "INSERT INTO Funcionario(nomeFunc,cpfFunc,mailFunc,foneFunc,celFunc,userFunc,passFunc,nivelFunc,estaAtivo) values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, novoFunc.getNomeFunc());
            stmt.setString(2, novoFunc.getCpfFunc());
            stmt.setString(3, novoFunc.getMailFunc());
            stmt.setString(4, novoFunc.getFoneFunc());
            stmt.setString(5, novoFunc.getCelFunc());
            stmt.setString(6, novoFunc.getUserFunc());
            stmt.setString(7, novoFunc.getPassFunc());
            stmt.setInt(8, novoFunc.getNivelFunc());
            stmt.setBoolean(9, novoFunc.getEstaAtivo());

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
    public List<Funcionario> getLista() {
        String sql = "SELECT * FROM Funcionario";
        PreparedStatement stmt;
        ResultSet res;
        List<Funcionario> listaResFunc = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            res = stmt.executeQuery();
            while (res.next()) {
                Funcionario novoFunc = new Funcionario();
                novoFunc.setIdFunc(res.getInt("idFunc"));
                novoFunc.setNomeFunc(res.getString("nomeFunc"));
                novoFunc.setCpfFunc(res.getString("cpfFunc"));
                novoFunc.setMailFunc(res.getString("mailFunc"));
                novoFunc.setFoneFunc(res.getString("foneFunc"));
                novoFunc.setCelFunc(res.getString("celFunc"));
                novoFunc.setUserFunc(res.getString("userFunc"));
                novoFunc.setPassFunc("");
                novoFunc.setNivelFunc(res.getInt("nivelFunc"));
                novoFunc.setEstaAtivo(res.getBoolean("estaAtivo"));
                listaResFunc.add(novoFunc);
            }
            res.close();
            stmt.close();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResFunc;
    }

    //UPDATE
    public boolean atualizaFuncionario(Funcionario novoFunc) {
        String sql = "UPDATE Funcionario SET nomeFunc=?, cpfFunc=?, mailFunc=?, foneFunc=?, celFunc=?, userFunc=?, passFunc=?, nivelFunc=?, estaAtivo=? WHERE idFunc=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, novoFunc.getNomeFunc());
            stmt.setString(2, novoFunc.getCpfFunc());
            stmt.setString(3, novoFunc.getMailFunc());
            stmt.setString(4, novoFunc.getFoneFunc());
            stmt.setString(5, novoFunc.getCelFunc());
            stmt.setString(6, novoFunc.getUserFunc());
            stmt.setString(7, novoFunc.getPassFunc());
            stmt.setInt(8, novoFunc.getNivelFunc());
            stmt.setBoolean(9, novoFunc.getEstaAtivo());
            stmt.setInt(10, novoFunc.getIdFunc());

            stmt.execute();
            stmt.close();
            conexao.close();
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    //DELETE
    public boolean deletaFuncionario(Funcionario novoFunc) {
        String sql = "DELETE FROM Funcionario WHERE idFunc=?";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, novoFunc.getIdFunc());

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
