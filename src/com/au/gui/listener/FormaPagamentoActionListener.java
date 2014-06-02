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

import com.au.gui.TelaCadastrarFormasDePagamento;
import com.au.gui.tmodel.FormaPagamentoTableModel;
import com.au.modelo.FormaPagamento;
import com.au.dao.DAO;
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
public class FormaPagamentoActionListener implements ActionListener, ListSelectionListener {

    private final TelaCadastrarFormasDePagamento frm;
    private FormaPagamentoTableModel tableModel;
    private final Border vermelha = new MatteBorder(1, 1, 1, 1, Color.red);
    private Border normal;

    public void limpaCampos() {
        frm.limpaCampos();
        frm.getCaixaAtivo().setBorder(normal);
        frm.getCaixaTipo().setBorder(normal);
        frm.getCampoId().setBorder(normal);
        frm.getCampoNome().setBorder(normal);
    }

    public FormaPagamentoActionListener(TelaCadastrarFormasDePagamento frm) {
        this.frm = frm;
        normal = frm.getCampoNome().getBorder();
        adicionaListener();
        inicializaTableModel();
        habilitaBotoesParaSalvar();
    }

    public void atualizaTableModel(List<FormaPagamento> formasPagamento) {
        if (formasPagamento != null && formasPagamento.isEmpty()) {
            FormaPagamento formaPagamento = new FormaPagamento();
            formaPagamento.setNomeFormaPgto("Nenhum Registro Encontrado");
            formasPagamento.add(formaPagamento);
        }
        tableModel = new FormaPagamentoTableModel(formasPagamento);
        frm.getTabelaFormasPagamento().setModel(tableModel);
        frm.getTabelaFormasPagamento().getSelectionModel().addListSelectionListener(this);
        frm.getTabelaFormasPagamento().getColumnModel().getColumn(0).setMaxWidth(35);
        frm.getTabelaFormasPagamento().getColumnModel().getColumn(2).setMaxWidth(110);
    }

    public void inicializaTableModel() {
        atualizaTableModel(new DAO<>(FormaPagamento.class).listaTodos());
    }

    public void adicionaListener() {
        frm.getBotaoAtualizarFormaPagamento().addActionListener(this);
        frm.getBotaoCadastrarFormaPagamento().addActionListener(this);
        frm.getBotaoCancelarFormaPagamento().addActionListener(this);
        frm.getBotaoExcluirFormaPagamento().addActionListener(this);
        frm.getBotaoLimparCampos().addActionListener(this);
        frm.getBotaoProcurarFormaPagamento().addActionListener(this);

    }

    private void habilitaBotoesParaSalvar() {
        habilitaOuDesabilitaBotoesEdicao(true);
    }

    private void desabilitaBotoesParaSalvar() {
        habilitaOuDesabilitaBotoesEdicao(false);
    }

    private void habilitaOuDesabilitaBotoesEdicao(boolean enabled) {
        frm.getBotaoAtualizarFormaPagamento().setEnabled(!enabled);
        frm.getBotaoCadastrarFormaPagamento().setEnabled(enabled);
        frm.getBotaoExcluirFormaPagamento().setEnabled(!enabled);
    }

    private void cadastrarFormaPagamento() {

        FormaPagamento formaPagamento = formToFormaPagamento();

//        if(!new DAO<>(FormaPagamento.class).validaNomeTipo(formaPagamento)){
//            JOptionPane.showMessageDialog(frm, "CPF ja cadastrado!");
//            return;
//        }
        new DAO<>(FormaPagamento.class).adiciona(formaPagamento);

        JOptionPane.showMessageDialog(frm, "Forma de Pagamento Cadastrada Com Sucesso", "Cadastro de Formas de Pagamento", JOptionPane.INFORMATION_MESSAGE);

        limpaCampos();

        inicializaTableModel();
    }

    private void atualizarFormaPagamento() {
        new DAO<>(FormaPagamento.class).atualiza(formToFormaPagamento());

        JOptionPane.showMessageDialog(frm, "Forma de Pagamento Atualizada Com Sucesso", "Cadastro de Formas de Pagamento", JOptionPane.INFORMATION_MESSAGE);

        limpaCampos();

        inicializaTableModel();
    }

    private void excluirFormaPagamento() {
        new DAO<>(FormaPagamento.class).remove(formToFormaPagamento());

        JOptionPane.showMessageDialog(frm, "Forma de Pagamento Removida Com Sucesso", "Cadastro de Formas de Pagamento", JOptionPane.INFORMATION_MESSAGE);

        limpaCampos();

        inicializaTableModel();
    }

    public void pesquisaFormaPagamento() {
        String pesquisa = frm.getCampoPesquisarFormapagamento().getText();
        limpaCampos();
        atualizaTableModel(new DAO<>(FormaPagamento.class).buscaFormasPagamento(pesquisa));
    }

    private FormaPagamento formToFormaPagamento() {
        FormaPagamento formaPagamento = new FormaPagamento();
        if (!"".equals(frm.getCampoId().getText())) {
            formaPagamento.setIdFormaPgto(Integer.parseInt(frm.getCampoId().getText()));
        }
        formaPagamento.setNomeFormaPgto(frm.getCampoNome().getText());
        formaPagamento.setTipoFormaPgto(String.valueOf(frm.getCaixaTipo().getSelectedItem()));

        if (frm.getCaixaAtivo().getSelectedItem() == "Não") {
            formaPagamento.setEstaAtivo((byte) 0);
        } else {
            formaPagamento.setEstaAtivo((byte) 1);
        }

        return formaPagamento;
    }

    private void formaPagamentoToForm(FormaPagamento formaPagamento) {
        frm.getCampoId().setText(String.valueOf(formaPagamento.getIdFormaPgto()));
        frm.getCampoNome().setText(formaPagamento.getNomeFormaPgto());
        if (formaPagamento.getTipoFormaPgto().equals("Dinheiro")) {
            frm.getCaixaTipo().setSelectedIndex(1);
        } else if (formaPagamento.getTipoFormaPgto().equals("Debito")) {
            frm.getCaixaTipo().setSelectedIndex(2);
        } else if (formaPagamento.getTipoFormaPgto().equals("Credito")) {
            frm.getCaixaTipo().setSelectedIndex(3);
        } else {
            frm.getCaixaTipo().setSelectedIndex(4);
        }
        if ((byte) 0 == formaPagamento.getEstaAtivo()) {
            frm.getCaixaAtivo().setSelectedIndex(2);
        } else {
            frm.getCaixaAtivo().setSelectedIndex(1);
        }
        desabilitaBotoesParaSalvar();
    }

    public boolean valida() {
        boolean valida = true;
        if (!"".equals(frm.getCampoNome().getText())) {
            frm.getCampoNome().setBorder(normal);
        } else {
            frm.getCampoNome().setBorder(vermelha);
            valida = false;
        }

        if (frm.getCaixaTipo().getSelectedIndex() != 0) {
            frm.getCaixaTipo().setBorder(normal);
        } else {
            frm.getCaixaTipo().setBorder(vermelha);
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
            case "Cadastrar F. Pagamento":
                if (valida()) {
                    cadastrarFormaPagamento();
                }
                break;
            case "Limpar Campos":
                limpaCampos();
                habilitaBotoesParaSalvar();
                break;
            case "Excluir F. Pagamento":
                if (valida()) {
                    excluirFormaPagamento();
                    habilitaBotoesParaSalvar();
                }
                break;
            case "Atualizar F. Pagamento":
                if (valida()) {
                    atualizarFormaPagamento();
                    habilitaBotoesParaSalvar();
                }
                break;
            case "Cancelar Cadastro":
                this.frm.dispose();
                break;
            case "Procurar":
                pesquisaFormaPagamento();
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event
    ) {
        if (frm.getTabelaFormasPagamento().getSelectedRow() != -1) {
            FormaPagamento formaPagamento = tableModel.getFormasPagamento().get(frm.getTabelaFormasPagamento().getSelectedRow());
            if (formaPagamento.getIdFormaPgto() != 0) {
                formaPagamentoToForm(formaPagamento);
            }
        }

    }
}
