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
package com.au.gui;

import com.au.bean.Funcionario;
import com.au.dao.FuncionarioDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author BrunoRicardo
 */
public class FuncionarioActionListener implements ActionListener {

    private TelaCadastrarFuncionario frm;

    public FuncionarioActionListener(TelaCadastrarFuncionario frm) {
        this.frm = frm;
        adicionaListener();
    }

    public void adicionaListener() {
        frm.getBotaoAlterar().addActionListener(this);
        frm.getBotaoCancelar().addActionListener(this);
        frm.getBotaoExcluir().addActionListener(this);
        frm.getBotaoIncluir().addActionListener(this);
        frm.getBotaoSalvar().addActionListener(this);

    }

    private void habilitaBotoesParaSalvar() {
        habilitaOuDesabilitaBotoesEdicao(true);
    }

    private void desabilitaBotoesParaSalvar() {
        habilitaOuDesabilitaBotoesEdicao(false);
    }

    private void habilitaOuDesabilitaBotoesEdicao(boolean enabled) {
        frm.getBotaoIncluir().setEnabled(!enabled);
        frm.getBotaoAlterar().setEnabled(!enabled);
        frm.getBotaoExcluir().setEnabled(!enabled);
        frm.getBotaoSalvar().setEnabled(enabled);
        frm.getBotaoCancelar().setEnabled(enabled);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Incluir":
                incluir();
                break;
            case "Alterar":
                break;
            case "Excluir":
                break;
            case "Salvar":
                salvar();
                break;
            case "Cancelar":
                break;
        }
        habilitaBotoesParaSalvar();
    }

    private void incluir() {
        habilitaBotoesParaSalvar();
    }

    private void salvar() {
        FuncionarioDao funcDao = new FuncionarioDao();
        if(funcDao.addFuncionario(formToFuncionario())){
            JOptionPane.showMessageDialog(frm, "Cadastrado Com Sucesso", "Cadastro de Funcionario", JOptionPane.INFORMATION_MESSAGE);
        }
        desabilitaBotoesParaSalvar();
    }

    private Funcionario formToFuncionario() {
        Date data;
        Funcionario func = new Funcionario();
        if (!"".equals(frm.getTextoId().getText())) {
            func.setIdFunc(Integer.parseInt(frm.getTextoId().getText()));
        }
        func.setNomeFunc(frm.getCampoNome().getText());
        data = new java.sql.Date (frm.getCampoDtNasc().getDate().getTime());
        func.setNascFunc(data);
        if(frm.getCaixaSexo().getSelectedItem() == "Feminino"){
            func.setSexoFunc("F");
        }
        else{
            func.setSexoFunc("M");
        }
        func.setRgFunc(frm.getCampoRg().getText());
        func.setCpfFunc(frm.getCampoCpf().getText());
        func.setMailFunc(frm.getCampoEmail().getText());
        func.setFoneFunc(frm.getCampoTelefone().getText());
        func.setCelFunc(frm.getCampoCelular().getText());
        data = new java.sql.Date (frm.getCampoDtAdm().getDate().getTime());
        func.setDtAdmFunc(data);
        func.setSalFunc(Double.valueOf(frm.getCampoSalario().getText()));
        func.setUserFunc(frm.getCampoUser().getText());
        func.setPassFunc(frm.getCampoSenha().getText());
        if(frm.getCaixaNivel().getSelectedItem() == "Administrador"){
            func.setNivelFunc(1);
        }
        else{
            func.setNivelFunc(0);
        }
        if(frm.getCaixaAtivo().getSelectedItem() == "Não"){
            func.setEstaAtivo(0);
        }
        else{
            func.setEstaAtivo(1);
        }
        
        return func;
    }
}
