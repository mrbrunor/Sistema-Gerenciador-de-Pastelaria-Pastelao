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

import com.au.gui.tmodel.IngredienteTableModel;
import com.au.gui.TelaCadastrarIngrediente;
import com.au.modelo.Ingrediente;
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
public class IngredienteActionListener implements ActionListener, ListSelectionListener {

    private final TelaCadastrarIngrediente frm;
    private IngredienteTableModel tableModel;

    public void limpaCampos() {
        frm.limpaCampos();
    }

    public IngredienteActionListener(TelaCadastrarIngrediente frm) {
        this.frm = frm;
        adicionaListener();
        inicializaTableModel();
    }

    public void inicializaTableModel() {
        tableModel = new IngredienteTableModel(new DAO<>(Ingrediente.class).listaTodos());
        frm.getTabelaIngredientes().setModel(tableModel);
        frm.getTabelaIngredientes().getSelectionModel().addListSelectionListener(this);

    }

    public void adicionaListener() {
        frm.getBotaoAtualizarIngrediente().addActionListener(this);
        frm.getBotaoCadastrarIngrediente().addActionListener(this);
        frm.getBotaoCancelarIngrediente().addActionListener(this);
        frm.getBotaoExcluirIngrediente().addActionListener(this);
        frm.getBotaoLimparCampos().addActionListener(this);
        frm.getBotaoProcurarIngrediente().addActionListener(this);
    }

    private void habilitaBotoesParaSalvar() {
        habilitaOuDesabilitaBotoesEdicao(true);
    }

    private void desabilitaBotoesParaSalvar() {
        habilitaOuDesabilitaBotoesEdicao(false);
    }

    private void habilitaOuDesabilitaBotoesEdicao(boolean enabled) {
        frm.getBotaoAtualizarIngrediente().setEnabled(!enabled);
        frm.getBotaoCadastrarIngrediente().setEnabled(enabled);
        frm.getBotaoExcluirIngrediente().setEnabled(!enabled);
        frm.getBotaoCancelarIngrediente().setEnabled(enabled);
        frm.getBotaoLimparCampos().setEnabled(enabled);
        frm.getBotaoProcurarIngrediente().setEnabled(enabled);
    }

    private void salvar() {
        new DAO<>(Ingrediente.class).adiciona(formToIngrediente());

        JOptionPane.showMessageDialog(frm, "Cadastrado Com Sucesso", "Cadastro de Funcionario", JOptionPane.INFORMATION_MESSAGE);

        desabilitaBotoesParaSalvar();

        limpaCampos();

        inicializaTableModel();
    }

    private Ingrediente formToIngrediente() {
        Ingrediente ingrediente = new Ingrediente();
        
        if (!"".equals(frm.getCampoId().getText())) {
            ingrediente.setIdIng(Integer.valueOf(frm.getCampoId().getText()));
        }
        ingrediente.setDescIng(frm.getCampoNome().getText());
        ingrediente.setValorIng(Double.valueOf(frm.getCampoValor().getText()));
        return ingrediente;
    }

    private void ingredienteToForm(Ingrediente ingrediente) {
        frm.getCampoId().setText(String.valueOf(ingrediente.getIdIng()));
        frm.getCampoNome().setText(ingrediente.getDescIng());
        frm.getCampoValor().setText(String.valueOf(ingrediente.getValorIng()));
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Cadastrar Ingrediente":
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
        Ingrediente ingrediente = tableModel.getIngredientes().get(frm.getTabelaIngredientes().getSelectedRow());
        ingredienteToForm(ingrediente);
    }
}