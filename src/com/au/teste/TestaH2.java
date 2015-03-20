/*
 * Copyright (C) 2015 Atual
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
package com.au.teste;

import com.au.bean.Funcionario;
import com.au.conexao.FabricaConexao;
import com.au.dao.ProdutoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Atual
 */
public class TestaH2 {

    public static void main(String[] args) {

        Connection conexao = new FabricaConexao().getConexao();

        String sql = "SELECT * FROM SISTEMAPASTELAO.FUNCIONARIO";
        PreparedStatement stmt;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.execute();
            System.out.println("FOI o/");

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
