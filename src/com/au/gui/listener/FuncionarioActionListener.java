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

import com.au.gui.tmodel.FuncionarioTableModel;
import com.au.gui.TelaCadastrarFuncionario;
import com.au.modelo.Funcionario;
import com.au.dao.DAO;
import com.au.util.HexSha;
import com.au.util.ValidaEmail;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author BrunoRicardo
 */
public class FuncionarioActionListener implements ActionListener, ListSelectionListener {

    private final TelaCadastrarFuncionario frm;
    private FuncionarioTableModel tableModel;
    private Border vermelha = new MatteBorder(1, 1, 1, 1, Color.red);
    private Border normal;

    public void limpaCampos() {
        frm.limpaCampos();
        frm.getCaixaAtivo().setBorder(normal);
        frm.getCaixaNivel().setBorder(normal);
        frm.getCampoCelular().setBorder(normal);
        frm.getCampoCpf().setBorder(normal);
        frm.getCampoEmail().setBorder(normal);
        frm.getCampoNome().setBorder(normal);
        frm.getCampoSenha().setBorder(normal);
        frm.getCampoSenha2().setBorder(normal);
        frm.getCampoUser().setBorder(normal);
    }

    public FuncionarioActionListener(TelaCadastrarFuncionario frm) {
        this.frm = frm;
        normal = frm.getCampoNome().getBorder();
        adicionaListener();
        inicializaTableModel();
        habilitaBotoesParaSalvar();
    }
    
    public void atualizaTableModel(List<Funcionario> funcionarios) {
        if(funcionarios != null && funcionarios.isEmpty()){
            Funcionario funcionario = new Funcionario();
            funcionario.setNomeFunc("Nenhum Registro Encontrado");
            funcionarios.add(funcionario);
        }
        tableModel = new FuncionarioTableModel(funcionarios);
        frm.getTabelaFuncionarios().setModel(tableModel);
        frm.getTabelaFuncionarios().getSelectionModel().addListSelectionListener(this);
        frm.getTabelaFuncionarios().getColumnModel().getColumn(0).setMaxWidth(35);
        frm.getTabelaFuncionarios().getColumnModel().getColumn(2).setMaxWidth(250);
        frm.getTabelaFuncionarios().getColumnModel().getColumn(3).setMaxWidth(65);
    }

    public void inicializaTableModel() {
        atualizaTableModel(new DAO<>(Funcionario.class).listaTodos());
    }

    public void adicionaListener() {
        frm.getBotaoAtualizarFuncionario().addActionListener(this);
        frm.getBotaoCadastrarFuncionario().addActionListener(this);
        frm.getBotaoCancelarCadastro().addActionListener(this);
        frm.getBotaoExcluirFuncionario().addActionListener(this);
        frm.getBotaoLimparCampos().addActionListener(this);
        frm.getBotaoProcurarFuncionario().addActionListener(this);

    }

    private void habilitaBotoesParaSalvar() {
        habilitaOuDesabilitaBotoesEdicao(true);
    }

    private void desabilitaBotoesParaSalvar() {
        habilitaOuDesabilitaBotoesEdicao(false);
    }

    private void habilitaOuDesabilitaBotoesEdicao(boolean enabled) {
        frm.getBotaoAtualizarFuncionario().setEnabled(!enabled);
        frm.getBotaoCadastrarFuncionario().setEnabled(enabled);
        frm.getBotaoExcluirFuncionario().setEnabled(!enabled);
    }

    private void cadastrarFuncionario() {
        
        Funcionario funcionario = formToFuncionario();
        
        if(!new DAO<>(Funcionario.class).validaCPF(funcionario)){
            JOptionPane.showMessageDialog(frm, "CPF ja cadastrado!", "Cadastro de Funcionários", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(!new DAO<>(Funcionario.class).validaUser(funcionario)){
            JOptionPane.showMessageDialog(frm, "Usuário já existe!", "Cadastro de Funcionários", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        new DAO<>(Funcionario.class).adiciona(funcionario);

        JOptionPane.showMessageDialog(frm, "Funcionário Cadastrado Com Sucesso", "Cadastro de Funcionarios", JOptionPane.INFORMATION_MESSAGE);

        limpaCampos();

        inicializaTableModel();
    }

    private void atualizarFuncionario() {
        new DAO<>(Funcionario.class).atualiza(formToFuncionario());

        JOptionPane.showMessageDialog(frm, "Funcionário Atualizado Com Sucesso", "Cadastro de Funcionarios", JOptionPane.INFORMATION_MESSAGE);

        limpaCampos();

        inicializaTableModel();
    }

    private void excluirFuncionario() {
        new DAO<>(Funcionario.class).remove(formToFuncionario());

        JOptionPane.showMessageDialog(frm, "Funcionário Removido Com Sucesso", "Cadastro de Funcionarios", JOptionPane.INFORMATION_MESSAGE);

        limpaCampos();

        inicializaTableModel();
    }
    
    public void pesquisaFuncionarios() {
        String pesquisa = frm.getCampoPesquisarFuncionario().getText();
        limpaCampos();
        atualizaTableModel(new DAO<>(Funcionario.class).buscaFuncionarios(pesquisa));
    }
    
    private Funcionario formToFuncionario() {
        Date data;
        Funcionario func = new Funcionario();
        if (!"".equals(frm.getCampoId().getText())) {
            func.setIdFunc(Integer.parseInt(frm.getCampoId().getText()));
        }
        func.setNomeFunc(frm.getCampoNome().getText());
        func.setCpfFunc(frm.getCampoCpf().getText());
        func.setMailFunc(frm.getCampoEmail().getText());
        func.setFoneFunc(frm.getCampoTelefone().getText());
        func.setCelFunc(frm.getCampoCelular().getText());
        func.setUserFunc(frm.getCampoUser().getText());

        HexSha hexSha = new HexSha(String.valueOf(frm.getCampoSenha().getPassword()));
        func.setPassFunc(hexSha.ConvertSha());

        if (frm.getCaixaNivel().getSelectedItem() == "Administrador") {
            func.setNivelFunc(1);
        } else {
            func.setNivelFunc(0);
        }
        if (frm.getCaixaAtivo().getSelectedItem() == "Não") {
            func.setEstaAtivo((byte) 0);
        } else {
            func.setEstaAtivo((byte) 1);
        }
        return func;
    }

    private void funcionarioToForm(Funcionario funcionario) {
        frm.getCampoId().setText(String.valueOf(funcionario.getIdFunc()));
        frm.getCampoNome().setText(funcionario.getNomeFunc());
        frm.getCampoCpf().setText(funcionario.getCpfFunc());
        frm.getCampoEmail().setText(funcionario.getMailFunc());
        frm.getCampoTelefone().setText(funcionario.getFoneFunc());
        frm.getCampoCelular().setText(funcionario.getCelFunc());
        frm.getCampoUser().setText(funcionario.getUserFunc());
        if (funcionario.getNivelFunc() == 1) {
            frm.getCaixaNivel().setSelectedIndex(1);
        } else {
            frm.getCaixaNivel().setSelectedIndex(2);
        }
        if ((byte) 0 == funcionario.getEstaAtivo()) {
            frm.getCaixaAtivo().setSelectedIndex(1);
        } else {
            frm.getCaixaAtivo().setSelectedIndex(2);
        }
        desabilitaBotoesParaSalvar();
    }

    public boolean valida() {
        boolean valida = true;
        if (!"".equals(frm.getCampoNome().getText()) && frm.getCampoNome().getText().length() > 9) {
            frm.getCampoNome().setBorder(normal);
        } else {
            frm.getCampoNome().setBorder(vermelha);
            valida = false;
        }


        if (!"".equals(frm.getCampoCpf().getText()) && frm.getCampoCpf().getText().length() > 10) {
            frm.getCampoCpf().setBorder(normal);
        } else {
            frm.getCampoCpf().setBorder(vermelha);
            valida = false;
        }

        if (new ValidaEmail().validEmail(frm.getCampoEmail().getText())) {
            frm.getCampoEmail().setBorder(normal);
        } else {
            frm.getCampoEmail().setBorder(vermelha);
            valida = false;
        }

        if (!"".equals(frm.getCampoCelular().getText()) && frm.getCampoCelular().getText().length() > 7) {
            frm.getCampoCelular().setBorder(normal);
        } else {
            frm.getCampoCelular().setBorder(vermelha);
            valida = false;
        }

        if (!"".equals(frm.getCampoUser().getText()) && frm.getCampoUser().getText().length() > 2) {
            frm.getCampoUser().setBorder(normal);
        } else {
            frm.getCampoUser().setBorder(vermelha);
            valida = false;
        }

        if (!"".equals(frm.getCampoSenha().getPassword()) && frm.getCampoSenha().getPassword().length > 4) {
            frm.getCampoSenha().setBorder(normal);
        } else {
            frm.getCampoSenha().setBorder(vermelha);
            valida = false;
        }

        if (!"".equals(frm.getCampoSenha2().getPassword()) && frm.getCampoSenha2().getText().equals(frm.getCampoSenha().getText())) {
            frm.getCampoSenha2().setBorder(normal);
        } else {
            frm.getCampoSenha2().setBorder(vermelha);
            valida = false;
        }

        if (frm.getCaixaNivel().getSelectedIndex() != 0) {
            frm.getCaixaNivel().setBorder(normal);
        } else {
            frm.getCaixaNivel().setBorder(vermelha);
            valida = false;
        }

        if (frm.getCaixaAtivo().getSelectedIndex() != 0) {
            frm.getCaixaAtivo().setBorder(normal);
        } else {
            frm.getCaixaAtivo().setBorder(vermelha);
            valida = false;
        }
        return valida;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Cadastrar Funcionário":
                if (valida()) {
                    cadastrarFuncionario();
                }
                break;
            case "Limpar Campos":
                limpaCampos();
                habilitaBotoesParaSalvar();
                break;
            case "Excluir Funcionário":
                if (valida()) {
                    excluirFuncionario();
                    habilitaBotoesParaSalvar();
                }
                break;
            case "Atualizar Funcionário":
                if (valida()) {
                    atualizarFuncionario();
                    habilitaBotoesParaSalvar();
                }
                break;
            case "Cancelar Cadastro":
                this.frm.dispose();
                break;
            case "Procurar":
                pesquisaFuncionarios();
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event
    ) {
        if (frm.getTabelaFuncionarios().getSelectedRow() != -1) {
            Funcionario funcionario = tableModel.getFuncionarios().get(frm.getTabelaFuncionarios().getSelectedRow());
            if(funcionario.getIdFunc() != 0){
                funcionarioToForm(funcionario);
            }
        }

    }
}
