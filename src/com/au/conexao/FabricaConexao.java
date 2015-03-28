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
package com.au.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author BrunoRicardo
 */
public class FabricaConexao {
    //MySQL
    //String usuario = "java";
    //String senha = "123456";
    //String url = "jdbc:mysql://localhost:3306/sistemapastelao";
    
    //H2
    String usuario = "sa";
    String senha = "";
    String url = "jdbc:h2:libs\\banco;AUTO_SERVER=TRUE;DB_CLOSE_DELAY=-1";
    Connection ready = null;

    /**
     *
     * @return Função para criar uma conexão e retorna-la
     */
    public Connection getConexao() {
        try {
            ready = DriverManager.getConnection(url, usuario, senha);
            return ready;
        } catch (SQLException fail) {
            System.out.println("Impossivel Conectar: " + fail);
            return ready;
        }
    }
}
