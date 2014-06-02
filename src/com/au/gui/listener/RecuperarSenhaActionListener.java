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

import com.au.gui.TelaCriarNovaSenha;
import com.au.modelo.Funcionario;
import com.au.dao.DAO;
import com.au.util.HexSha;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

/**
 *
 * @author BrunoRicardo
 */
public class RecuperarSenhaActionListener implements ActionListener {

    private final TelaCriarNovaSenha frm;
    private Border vermelha = new MatteBorder(1, 1, 1, 1, Color.red);
    private Border normal;

    public RecuperarSenhaActionListener(TelaCriarNovaSenha frm) {
        this.frm = frm;
        normal = frm.getCampoCpfFuncionario().getBorder();
        adicionaListener();
    }

    public void adicionaListener() {
        frm.getBotaoCancelarNovaSenha().addActionListener(this);
        frm.getBotaoCriarNovaSenha().addActionListener(this);
        frm.getCampoConfirmacaoNovaSenha().addActionListener(this);
        frm.getCampoCpfFuncionario().addActionListener(this);
        frm.getCampoNovaSenha().addActionListener(this);
    }
    
    public boolean valida(){
        boolean valida = true;
        if(!"".equals(frm.getCampoCpfFuncionario().getText())){
            frm.getCampoCpfFuncionario().setBorder(normal);
        } else {
            frm.getCampoCpfFuncionario().setBorder(vermelha);
            valida = false;
        }
        
        if (!"".equals(frm.getCampoNovaSenha().getPassword()) && frm.getCampoNovaSenha().getPassword().length > 4) {
            frm.getCampoNovaSenha().setBorder(normal);
        } else {
            frm.getCampoNovaSenha().setBorder(vermelha);
            valida = false;
        }

        if (!"".equals(frm.getCampoConfirmacaoNovaSenha().getPassword()) && frm.getCampoConfirmacaoNovaSenha().getText().equals(frm.getCampoNovaSenha().getText())) {
            frm.getCampoConfirmacaoNovaSenha().setBorder(normal);
        } else {
            frm.getCampoConfirmacaoNovaSenha().setBorder(vermelha);
            valida = false;
        }
        
        return valida;
    }
    
    public Funcionario formToFuncionario(){
        Funcionario funcionario = new Funcionario();
        funcionario.setCpfFunc(frm.getCampoCpfFuncionario().getText());
        HexSha hexSha = new HexSha(String.valueOf(frm.getCampoNovaSenha().getPassword()));
        funcionario.setPassFunc(hexSha.ConvertSha());
        return funcionario;
    }
    
    public void alterarSenha(){
        if(!new DAO<>(Funcionario.class).validaCPF(formToFuncionario())){
            new DAO<>(Funcionario.class).alterarSenha(formToFuncionario());
            JOptionPane.showMessageDialog(frm, "Senha Alterada com Sucesso!", "Recuperação de Senha", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frm, "CPF não encontrado!", "Recuperação de Senha", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Criar Nova Senha":
                if(valida()){
                    alterarSenha();
                    frm.dispose();
                }
                break;
            case "Cancelar Criação de Nova Senha":
                frm.dispose();
                break;
            case "CPF":
                frm.getCampoNovaSenha().requestFocus();
                break;
            case "NovaSenha":
                frm.getCampoConfirmacaoNovaSenha().requestFocus();
                break;
            case "ConfirmacaoNovaSenha":
                frm.getBotaoCriarNovaSenha().requestFocus();
                break;
        }
    }
}
