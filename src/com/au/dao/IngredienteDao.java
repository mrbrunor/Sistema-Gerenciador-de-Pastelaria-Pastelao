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
import com.au.pojo.Ingrediente;
import com.au.util.HibernateUtil;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author BrunoRicardo
 */
public class IngredienteDao {
    Session ss = null;
    Connection conexao = null;
    
    public IngredienteDao(){
        this.ss = HibernateUtil.getSessionFactory().getCurrentSession();
        conexao = new FabricaConexao().getConexao();
    }
    
    public List<Ingrediente> listIngredientes(){
        System.out.println("Inicio do metodo");
        List<Ingrediente> listaResForn = new ArrayList<>();
        ss.beginTransaction();
        Query query = ss.createQuery("FROM Ingrediente");
        List list;
        list = query.list();
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
            listaResForn.add((Ingrediente)list.get(i));
        }
        return listaResForn;
    }
}
