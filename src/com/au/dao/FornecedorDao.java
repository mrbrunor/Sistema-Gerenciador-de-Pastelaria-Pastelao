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
import com.au.bean.Fornecedor;
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
public class FornecedorDao {

    Connection conexao = null;

    public FornecedorDao() {
        conexao = new FabricaConexao().getConexao();
    }

    public boolean addFornecedor(Fornecedor novoForn) {
        String sql = "INSERT INTO Fornecedor(nomeForn, cnpjForn, mailForn, foneForn, celForn) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement stmt;
        boolean resultado = false;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, novoForn.getNomeForn());
            stmt.setString(2, novoForn.getCnpjForn());
            stmt.setString(3, novoForn.getMailForn());
            stmt.setString(4, novoForn.getFoneForn());
            stmt.setString(5, novoForn.getCelForn());

            resultado = stmt.execute();
            stmt.close();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public List<Fornecedor> getLista() {
        String sql = "SELECT * FROM Fornecedor";
        PreparedStatement stmt;
        ResultSet res;
        List<Fornecedor> listaResForn = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement(sql);
            res = stmt.executeQuery();

            while (res.next()) {
                System.out.println("Entrou While res.next()"
                        + "");
                Fornecedor novoForn = new Fornecedor();
                novoForn.setNomeForn(res.getString("nomeForn"));
                novoForn.setIdForn(res.getInt("idForn"));
                listaResForn.add(novoForn);
            }
            res.close();
            stmt.close();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Lista Vazia " + listaResForn.isEmpty());
        System.out.println("Qtd Lista " + listaResForn.size());
        return listaResForn;
    }
}
