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

import com.au.gui.tmodel.FornecedorTableModel;
import com.au.gui.TelaCadastrarFornecedor;
import com.au.modelo.Fornecedor;
import com.au.util.DAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author BrunoRicardo
 */
public class FornecedorActionListener implements ActionListener, ListSelectionListener {

    private final TelaCadastrarFornecedor frm;
    private FornecedorTableModel tableModel;

    public void limpaCampos() {
        frm.limpaCampos();
    }

    public FornecedorActionListener(TelaCadastrarFornecedor frm) {
        this.frm = frm;
        adicionaListener();
        inicializaTableModel();
    }

    public void inicializaTableModel() {
        tableModel = new FornecedorTableModel(new DAO<>(Fornecedor.class).listaTodos());
        frm.getTabelaFornecedores().setModel(tableModel);
        frm.getTabelaFornecedores().getSelectionModel().addListSelectionListener(this);

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
        frm.getBotaoCancelarCadastro().setEnabled(enabled);
        frm.getBotaoLimparCampos().setEnabled(enabled);
        frm.getBotaoProcurarFornecedor().setEnabled(enabled);
    }

    private void salvar() {
        new DAO<>(Fornecedor.class).adiciona(formToFornecedor());

        JOptionPane.showMessageDialog(frm, "Cadastrado Com Sucesso", "Cadastro de Funcionario", JOptionPane.INFORMATION_MESSAGE);

        desabilitaBotoesParaSalvar();

        limpaCampos();

        inicializaTableModel();
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
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Cadastrar Fornecedor":
                salvar();
                break;
            case "Alterar":
                break;
            case "Excluir":
                break;
            case "Salvar":
                break;
            case "Cancelar":
                break;
        }
        habilitaBotoesParaSalvar();
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        Fornecedor fornecedor = tableModel.getFornecedores().get(frm.getTabelaFornecedores().getSelectedRow());
        fornecedorToForm(fornecedor);
    }
}
