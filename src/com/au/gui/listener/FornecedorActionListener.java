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

import com.au.gui.TelaCadastrarFornecedor;
import com.au.gui.tmodel.FornecedorTableModel;
import com.au.modelo.Fornecedor;
import com.au.dao.DAO;
import com.au.util.ValidaEmail;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class FornecedorActionListener implements ActionListener, ListSelectionListener {

    private final TelaCadastrarFornecedor frm;
    private FornecedorTableModel tableModel;
    private Border vermelha = new MatteBorder(1, 1, 1, 1, Color.red);
    private Border normal;

    public void limpaCampos() {
        frm.limpaCampos();
        frm.getCampoCelularFornecedor().setBorder(normal);
        frm.getCampoCnpjFornecedor().setBorder(normal);
        frm.getCampoEmailFornecedor().setBorder(normal);
        frm.getCampoNomeFornecedor().setBorder(normal);
        frm.getCampoPesquisarFornecedor().setBorder(normal);
        frm.getCampoTelefoneFornecedor().setBorder(normal);
    }

    public FornecedorActionListener(TelaCadastrarFornecedor frm) {
        this.frm = frm;
        normal = frm.getCampoNomeFornecedor().getBorder();
        adicionaListener();
        inicializaTableModel();
        habilitaBotoesParaSalvar();
    }
    
    public void atualizaTableModel(List<Fornecedor> fornecedors) {
        if(fornecedors != null && fornecedors.isEmpty()){
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setNomeForn("Nenhum Registro Encontrado");
            fornecedors.add(fornecedor);
        }
        tableModel = new FornecedorTableModel(fornecedors);
        frm.getTabelaFornecedores().setModel(tableModel);
        frm.getTabelaFornecedores().getSelectionModel().addListSelectionListener(this);
        frm.getTabelaFornecedores().getColumnModel().getColumn(0).setMaxWidth(35);
        frm.getTabelaFornecedores().getColumnModel().getColumn(2).setMaxWidth(110);
    }


    public void inicializaTableModel() {
        atualizaTableModel(new DAO<>(Fornecedor.class).listaTodos());
    }

    public void adicionaListener() {
        frm.getBotaoAtualizarFornecedor().addActionListener(this);
        frm.getBotaoCadastrarFornecedor().addActionListener(this);
        frm.getBotaoCancelarCadastro().addActionListener(this);
        frm.getBotaoExcluirFornecedor().addActionListener(this);
        frm.getBotaoLimparCampos().addActionListener(this);
        frm.getBotaoProcurarFornecedor().addActionListener(this);
    }

    private void habilitaBotoesParaSalvar() {
        habilitaOuDesabilitaBotoesEdicao(true);
    }

    private void desabilitaBotoesParaSalvar() {
        habilitaOuDesabilitaBotoesEdicao(false);
    }

    private void habilitaOuDesabilitaBotoesEdicao(boolean enabled) {
        frm.getBotaoAtualizarFornecedor().setEnabled(!enabled);
        frm.getBotaoCadastrarFornecedor().setEnabled(enabled);
        frm.getBotaoExcluirFornecedor().setEnabled(!enabled);
    }

    private void cadastrarFornecedor() {
        new DAO<>(Fornecedor.class).adiciona(formToFornecedor());

        JOptionPane.showMessageDialog(frm, "Cadastrado Com Sucesso", "Cadastro de Fornecedor", JOptionPane.INFORMATION_MESSAGE);

        limpaCampos();

        inicializaTableModel();
    }

    public void atualizarFornecedor() {
        new DAO<>(Fornecedor.class).atualiza(formToFornecedor());

        JOptionPane.showMessageDialog(frm, "Cadastro Atualizado Com Sucesso", "Cadastro de Fornecedor", JOptionPane.INFORMATION_MESSAGE);

        limpaCampos();

        inicializaTableModel();

    }

    public void excluirFornecedor() {
        new DAO<>(Fornecedor.class).remove(formToFornecedor());

        JOptionPane.showMessageDialog(frm, "Cadastro Removido Com Sucesso", "Cadastro de Fornecedor", JOptionPane.INFORMATION_MESSAGE);

        limpaCampos();

        inicializaTableModel();

    }

    public void pesquisaFornecedores() {
        String pesquisa = frm.getCampoPesquisarFornecedor().getText();
        limpaCampos();
        atualizaTableModel(new DAO<>(Fornecedor.class).buscaFornecedores(pesquisa));
    }

    private Fornecedor formToFornecedor() {
        Fornecedor fornecedor = new Fornecedor();

        if (!"".equals(frm.getCampoIdFornecedor().getText())) {
            fornecedor.setIdForn(Integer.valueOf(frm.getCampoIdFornecedor().getText()));
        }
        fornecedor.setNomeForn(frm.getCampoNomeFornecedor().getText());
        fornecedor.setCnpjForn(frm.getCampoCnpjFornecedor().getText());
        fornecedor.setMailForn(frm.getCampoEmailFornecedor().getText());
        fornecedor.setFoneForn(frm.getCampoTelefoneFornecedor().getText());
        fornecedor.setCelForn(frm.getCampoCelularFornecedor().getText());

        return fornecedor;
    }

    private void fornecedorToForm(Fornecedor fornecedor) {
        frm.getCampoIdFornecedor().setText(String.valueOf(fornecedor.getIdForn()));
        frm.getCampoNomeFornecedor().setText(fornecedor.getNomeForn());
        frm.getCampoCnpjFornecedor().setText(fornecedor.getCnpjForn());
        frm.getCampoEmailFornecedor().setText(fornecedor.getMailForn());
        frm.getCampoTelefoneFornecedor().setText(fornecedor.getFoneForn());
        frm.getCampoCelularFornecedor().setText(fornecedor.getCelForn());
        desabilitaBotoesParaSalvar();
    }

    public boolean valida() {
        boolean valida = true;
        if (!"".equals(frm.getCampoNomeFornecedor().getText()) && frm.getCampoNomeFornecedor().getText().length() > 5) {
            frm.getCampoNomeFornecedor().setBorder(normal);
        } else {
            frm.getCampoNomeFornecedor().setBorder(vermelha);
            valida = false;
        }

        if (!"".equals(frm.getCampoCnpjFornecedor().getText()) && frm.getCampoCnpjFornecedor().getText().length() > 5) {
            frm.getCampoCnpjFornecedor().setBorder(normal);
        } else {
            frm.getCampoCnpjFornecedor().setBorder(vermelha);
            valida = false;
        }

        if (new ValidaEmail().validEmail(frm.getCampoEmailFornecedor().getText())) {
            frm.getCampoEmailFornecedor().setBorder(normal);
        } else {
            frm.getCampoEmailFornecedor().setBorder(vermelha);
            valida = false;
        }

        if (!"".equals(frm.getCampoCelularFornecedor().getText()) && frm.getCampoCelularFornecedor().getText().length() > 5) {
            frm.getCampoCelularFornecedor().setBorder(normal);
        } else {
            frm.getCampoCelularFornecedor().setBorder(vermelha);
            valida = false;
        }
        return valida;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Cadastrar Fornecedor":
                if (valida()) {
                    cadastrarFornecedor();
                }
                break;
            case "Limpar Campos":
                limpaCampos();
                habilitaBotoesParaSalvar();
                break;
            case "Excluir Fornecedor":
                if (valida()) {
                    excluirFornecedor();
                    habilitaBotoesParaSalvar();
                }
                break;
            case "Atualizar Fornecedor":
                if (valida()) {
                    atualizarFornecedor();
                    habilitaBotoesParaSalvar();
                }
                break;
            case "Cancelar Cadastro":
                this.frm.dispose();
                break;
            case "Procurar":
                pesquisaFornecedores();
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (frm.getTabelaFornecedores().getSelectedRow() != -1) {
            Fornecedor fornecedor = tableModel.getFornecedores().get(frm.getTabelaFornecedores().getSelectedRow());
            if(fornecedor.getIdForn() != 0){
                fornecedorToForm(fornecedor);
            }            
        }
    }
}
