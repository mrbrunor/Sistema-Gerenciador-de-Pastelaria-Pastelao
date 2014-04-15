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
public class FuncionarioDao {Connection conexao = null;
    
    public FuncionarioDao(){
        conexao = new FabricaConexao().getConexao();
    }
    
    public void abreConnection(){
        conexao = new FabricaConexao().getConexao();
    }
    
    public void fechaConnection() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReceitaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean addFuncionario(Funcionario novoFunc){
        String sql = "INSERT INTO Funcionario(nomeFunc,nascFunc,sexoFunc,rgFunc,cpfFunc,mailFunc,foneFunc,celFunc,dtAdmFunc,salFunc,userFunc,passFunc,nivelFunc,estaAtivo) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt;
        boolean resultado=false;
        
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, novoFunc.getNomeFunc());
            stmt.setDate(2, novoFunc.getNascFunc());
            stmt.setString(3, novoFunc.getSexoFunc());
            stmt.setString(4, novoFunc.getRgFunc());
            stmt.setString(5, novoFunc.getCpfFunc());
            stmt.setString(6, novoFunc.getMailFunc());
            stmt.setString(7, novoFunc.getFoneFunc());
            stmt.setString(8, novoFunc.getCelFunc());
            stmt.setDate(9, novoFunc.getDtAdmFunc());
            stmt.setDouble(10, novoFunc.getSalFunc());
            stmt.setString(11, novoFunc.getUserFunc());
            stmt.setString(12, novoFunc.getPassFunc());
            stmt.setInt(13, novoFunc.getNivelFunc());
            stmt.setInt(14, novoFunc.isEstaAtivo());
            
            stmt.execute();
            stmt.close();
            conexao.close();
            resultado = true;
        }
        catch (SQLException ex){
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public List<Funcionario> getLista(){//String pesquisa){
        String sql = "SELECT * FROM Funcionario"; //WHERE descProd LIKE ? OR idProd LIKE ?";
        PreparedStatement stmt;
        ResultSet res;
        List<Funcionario> listaResFunc = new ArrayList<>();
        
        try{
            stmt = conexao.prepareStatement(sql);
            //stmt.setString(1, pesquisa);
            //stmt.setString(2, pesquisa);
            res = stmt.executeQuery();                        
            while(res.next()){
                Funcionario novoFunc = new Funcionario();
                novoFunc.setIdFunc(res.getInt("idFunc"));
                novoFunc.setNomeFunc(res.getString("nomeFunc"));
                novoFunc.setNascFunc(res.getDate("nascFunc"));                
                novoFunc.setSexoFunc(res.getString("sexoFunc"));                
                novoFunc.setRgFunc(res.getString("rgFunc"));                
                novoFunc.setCpfFunc(res.getString("cpfFunc"));                
                novoFunc.setMailFunc(res.getString("mailFunc"));                
                novoFunc.setFoneFunc(res.getString("foneFunc"));                
                novoFunc.setCelFunc(res.getString("celFunc"));                
                novoFunc.setDtAdmFunc(res.getDate("dtAdmFunc"));                
                novoFunc.setSalFunc(res.getDouble("salFunc"));                
                novoFunc.setUserFunc(res.getString("userFunc"));                
                novoFunc.setPassFunc(res.getString("passFunc"));                
                novoFunc.setNivelFunc(res.getInt("nivelFunc"));                
                novoFunc.setEstaAtivo(res.getInt("estaAtivo"));                
                listaResFunc.add(novoFunc);
            }
            res.close();
            stmt.close();
            conexao.close();
        }    
        catch (SQLException ex){
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaResFunc;
    }    
}
