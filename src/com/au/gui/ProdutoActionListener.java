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

import com.au.modelo.Produto;
import com.au.util.DAO;
import com.au.util.HexSha;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author BrunoRicardo
 */
public class ProdutoActionListener implements ActionListener, ListSelectionListener {

    private final TelaCadastrarProduto frm;
    private ProdutoTableModel tableModel;
    
    public void limpaCampos(){
        frm.limpaCampos();
    }
    
    public ProdutoActionListener(TelaCadastrarProduto frm) {
        this.frm = frm;
        adicionaListener();
        inicializaTableModel();
    }

    public void inicializaTableModel() {
        tableModel = new ProdutoTableModel(new DAO<>(Produto.class).listaTodos());
        frm.getTabelaProdutos().setModel(tableModel);
        frm.getTabelaProdutos().getSelectionModel().addListSelectionListener(this);

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

    private void incluir() {
        habilitaBotoesParaSalvar();
    }

    private void salvar() {
        new DAO<>(Funcionario.class).adiciona(formToFuncionario());
        
        JOptionPane.showMessageDialog(frm, "Cadastrado Com Sucesso", "Cadastro de Funcionario", JOptionPane.INFORMATION_MESSAGE);
        
        desabilitaBotoesParaSalvar();
        
        limpaCampos();
        
        inicializaTableModel();
    }

    private Funcionario formToFuncionario() {
        Date data;
        Funcionario func = new Funcionario();
        if (!"".equals(frm.getTextoId().getText())) {
            func.setIdFunc(Integer.parseInt(frm.getTextoId().getText()));
        }
        func.setNomeFunc(frm.getCampoNome().getText());
        data = new java.sql.Date(frm.getCampoDtNasc().getDate().getTime());
        func.setNascFunc(data);
        if (frm.getCaixaSexo().getSelectedItem() == "Feminino") {
            func.setSexoFunc("F");
        } else {
            func.setSexoFunc("M");
        }
        func.setRgFunc(frm.getCampoRg().getText());
        func.setCpfFunc(frm.getCampoCpf().getText());
        func.setMailFunc(frm.getCampoEmail().getText());
        func.setFoneFunc(frm.getCampoTelefone().getText());
        func.setCelFunc(frm.getCampoCelular().getText());
        data = new java.sql.Date(frm.getCampoDtAdm().getDate().getTime());
        func.setDtAdmFunc(data);
        func.setSalFunc(Double.valueOf(frm.getCampoSalario().getText()));
        func.setUserFunc(frm.getCampoUser().getText());
        
        HexSha hexSha = new HexSha(String.valueOf(frm.getCampoSenha().getText()));
        func.setPassFunc(hexSha.ConvertSha());
        
        if (frm.getCaixaNivel().getSelectedItem() == "Administrador") {
            func.setNivelFunc(1);
        } else {
            func.setNivelFunc(0);
        }
        if (frm.getCaixaAtivo().getSelectedItem() == "Não") {
            func.setEstaAtivo((byte)0);
        } else {
            func.setEstaAtivo((byte)1);
        }

        return func;
    }

    private void funcionarioToForm(Funcionario funcionario) {
        frm.getTextoId().setText(String.valueOf(funcionario.getIdFunc()));
        frm.getCampoNome().setText(funcionario.getNomeFunc());
        frm.getCampoDtNasc().setDate(funcionario.getNascFunc());
        if (funcionario.getSexoFunc().equals("F")) {
            frm.getCaixaSexo().setSelectedIndex(1);
        } else {
            frm.getCaixaSexo().setSelectedIndex(2);
        }
        frm.getCampoRg().setText(funcionario.getRgFunc());
        frm.getCampoCpf().setText(funcionario.getCpfFunc());
        frm.getCampoEmail().setText(funcionario.getMailFunc());
        frm.getCampoTelefone().setText(funcionario.getFoneFunc());
        frm.getCampoCelular().setText(funcionario.getCelFunc());
        frm.getCampoDtAdm().setDate(funcionario.getDtAdmFunc());
        frm.getCampoSalario().setText(String.valueOf(funcionario.getSalFunc()));
        frm.getCampoUser().setText(funcionario.getUserFunc());
        frm.getCampoSenha().setText(funcionario.getPassFunc());
        frm.getCampoSenha2().setText(funcionario.getPassFunc());
        if (funcionario.getNivelFunc() == 1) {
            frm.getCaixaNivel().setSelectedIndex(1);
        } else {
            frm.getCaixaNivel().setSelectedIndex(2);
        }
        if ((byte)0 == funcionario.getEstaAtivo()) {
            frm.getCaixaAtivo().setSelectedIndex(1);
        } else {
            frm.getCaixaAtivo().setSelectedIndex(2);
        }

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

    @Override
    public void valueChanged(ListSelectionEvent event) {
        Funcionario funcionario = tableModel.getFuncionarios().get(frm.getTabelaPesquisa().getSelectedRow());
        funcionarioToForm(funcionario);
        
    }

}
