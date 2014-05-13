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
package com.au.gui.listener;

import com.au.gui.TelaLogin;
import com.au.gui.TelaVenda;
import com.au.modelo.Funcionario;
import com.au.util.DAO;
import com.au.util.HexSha;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author BrunoRicardo
 */
public class LoginActionListener implements ActionListener {

    private final TelaLogin frm;

    public void limpaCampos() {
        frm.limpaCampos();
    }

    public LoginActionListener(TelaLogin frm) {
        this.frm = frm;
        adicionaListener();
    }

    public void adicionaListener() {
        frm.getBotaoEntrarNoSistema().addActionListener(this);
        frm.getBotaoEsqueciSenha().addActionListener(this);
        frm.getCampoSenha().addActionListener(this);
    }

    private void logar() {
        Funcionario funcionario = new Funcionario();
        Funcionario login = new Funcionario();
        
        login.setUserFunc(frm.getCampoUsuario().getText());
        HexSha hexSha = new HexSha(String.valueOf(frm.getCampoSenha().getPassword()));
        login.setPassFunc(hexSha.ConvertSha());
        
        funcionario = new DAO<>(Funcionario.class).buscarLogin(login.getUserFunc(), login.getPassFunc());
        
        if(funcionario == null){
            System.out.println("fuu");
        }
        else if(funcionario.getUserFunc().equals(login.getUserFunc()) && funcionario.getPassFunc().equals(login.getPassFunc())){
            new TelaVenda(funcionario).setVisible(true);
            frm.dispose();
                               
        }
    }

    private void trocarSenha() {
        System.out.println("Abrir Tela de Recuperar a Senha");
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Entrar no Sistema":
                logar();
                break;
            case "Esqueci a minha senha":
                trocarSenha();
                break;
        }
    }
}
