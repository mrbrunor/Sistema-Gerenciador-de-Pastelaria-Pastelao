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
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author BrunoRicardo
 */
public class IngredienteActionListener implements ActionListener, ListSelectionListener {

    private final TelaCadastrarIngrediente frm;
    private IngredienteTableModel tableModel;
    private Border vermelha = new MatteBorder(1, 1, 1, 1, Color.red);
    private Border normal;

    public void limpaCampos() {
        frm.limpaCampos();
        frm.getCampoNome().setBorder(normal);
        frm.getCampoValor().setBorder(normal);
    }

    public IngredienteActionListener(TelaCadastrarIngrediente frm) {
        this.frm = frm;
        normal = frm.getCampoNome().getBorder();
        adicionaListener();
        inicializaTableModel();
        habilitaBotoesParaSalvar();
    }

    public void inicializaTableModel() {
        tableModel = new IngredienteTableModel(new DAO<>(Ingrediente.class).listaTodos());
        frm.getTabelaIngredientes().setModel(tableModel);
        frm.getTabelaIngredientes().getSelectionModel().addListSelectionListener(this);
        frm.getTabelaIngredientes().getColumnModel().getColumn(0).setMaxWidth(35);
        frm.getTabelaIngredientes().getColumnModel().getColumn(2).setMaxWidth(75);
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
    }

    private void cadastrarIngrediente() {
        
        Ingrediente ingrediente = formToIngrediente();
        
        if(!new DAO<>(Ingrediente.class).validaIngrediente(ingrediente)){
            JOptionPane.showMessageDialog(frm, "Ingrediente ja cadastrado!");
            return;
        }
        
        new DAO<>(Ingrediente.class).adiciona(ingrediente);

        JOptionPane.showMessageDialog(frm, "Cadastrado Com Sucesso", "Cadastro de Ingrediente", JOptionPane.INFORMATION_MESSAGE);

        limpaCampos();

        inicializaTableModel();
    }

    public void atualizarIngrediente() {
        new DAO<>(Ingrediente.class).atualiza(formToIngrediente());

        JOptionPane.showMessageDialog(frm, "Cadastro Atualizado Com Sucesso", "Cadastro de Ingrediente", JOptionPane.INFORMATION_MESSAGE);

        limpaCampos();

        inicializaTableModel();

    }

    public void excluirIngrediente() {
        new DAO<>(Ingrediente.class).remove(formToIngrediente());

        JOptionPane.showMessageDialog(frm, "Cadastro Removido Com Sucesso", "Cadastro de Ingrediente", JOptionPane.INFORMATION_MESSAGE);

        limpaCampos();

        inicializaTableModel();

    }

    public void pesquisaIngredientes() {
        String pesquisa = frm.getCampoPesquisarIngrediente().getText();
        tableModel = new IngredienteTableModel(new DAO<>(Ingrediente.class).buscaIngredientes(pesquisa));
        frm.getTabelaIngredientes().setModel(tableModel);
        frm.getTabelaIngredientes().getSelectionModel().addListSelectionListener(this);
        frm.getTabelaIngredientes().getColumnModel().getColumn(0).setMaxWidth(35);
        frm.getTabelaIngredientes().getColumnModel().getColumn(2).setMaxWidth(75);
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
        desabilitaBotoesParaSalvar();
    }

    public boolean valida() {
        boolean valida = true;
        if (!"".equals(frm.getCampoNome().getText()) && frm.getCampoNome().getText().length() > 4) {
            frm.getCampoNome().setBorder(normal);
        } else {
            frm.getCampoNome().setBorder(vermelha);
            valida = false;
        }

        if (!"".equals(frm.getCampoValor().getText()) && frm.getCampoValor().getText().length() > 0) {
            frm.getCampoValor().setBorder(normal);
        } else {
            frm.getCampoValor().setBorder(vermelha);
            valida = false;
        }
        return valida;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Cadastrar Ingrediente":
                if (valida()) {
                    cadastrarIngrediente();
                }
                break;
            case "Limpar Campos":
                limpaCampos();
                habilitaBotoesParaSalvar();
                break;
            case "Excluir Ingrediente":
                if (valida()) {
                    excluirIngrediente();
                    habilitaBotoesParaSalvar();
                }
                break;
            case "Atualizar Ingrediente":
                if (valida()) {
                    atualizarIngrediente();
                    habilitaBotoesParaSalvar();
                }
                break;
            case "Cancelar Cadastro":
                this.frm.dispose();
                break;
            case "Procurar":
                pesquisaIngredientes();
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (frm.getTabelaIngredientes().getSelectedRow() != -1) {
            Ingrediente ingrediente = tableModel.getIngredientes().get(frm.getTabelaIngredientes().getSelectedRow());
            ingredienteToForm(ingrediente);
        }
    }
}
