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
import com.au.pojo.Fornecedor;
import com.au.util.HibernateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author BrunoRicardo
 */
public class FornecedorDao {
    Session s = null;  
    Connection conexao = null;
    
    public FornecedorDao(){
        this.s = HibernateUtil.getSessionFactory().getCurrentSession();
        conexao = new FabricaConexao().getConexao();
    }
    
    public List<Fornecedor> listFornecedores(){
        System.out.println("Inicio do metodo");
        List<Fornecedor> listaResForn = new ArrayList<>();
        s.beginTransaction();
        Query query = s.createQuery("FROM Fornecedor");
        List list;
        list = query.list();
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
            listaResForn.add((Fornecedor)list.get(i));
        }
        return listaResForn;
    }
    
    public List<Fornecedor> getLista(){
        String sql = "SELECT * FROM Fornecedor";
        PreparedStatement stmt;
        ResultSet res;
        List<Fornecedor> listaResForn = new ArrayList<>();
        
        try{
            stmt = conexao.prepareStatement(sql);
            res = stmt.executeQuery();                        
            
            while(res.next()){
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
        }    
        catch (SQLException ex){
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Lista Vazia " + listaResForn.isEmpty());
        System.out.println("Qtd Lista " + listaResForn.size());
        return listaResForn;
    }
}
