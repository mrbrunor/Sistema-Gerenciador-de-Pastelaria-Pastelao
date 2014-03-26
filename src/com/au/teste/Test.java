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

package com.au.teste;

import com.au.pojo.Ingrediente;
import com.au.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author BrunoRicardo
 */
public class Test {
    public static void main(String[] args){
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setDescIng("Queijo");
        ingrediente.setValorIng(15);
        
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        //s.save(ingrediente); //INSERT
        
        //List<Ingrediente> lista =(List<Ingrediente>)s.createQuery("From Ingrediente").list(); //SELECT
        
        //for(Ingrediente i : lista){
        //    System.out.println("Ingrediente: " + i.getDescIng());
        //}
        
        s.getTransaction().commit();
        
        
        
    }
}
