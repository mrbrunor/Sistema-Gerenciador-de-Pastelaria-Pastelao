/*
 * Copyright (C) 2014 Tiago
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.au.gui.listener;

import com.au.dao.DAO;
import com.au.gui.TelaVisualizarCaixa;
import com.au.gui.tmodel.CaixaTableModel;
import com.au.modelo.Caixa;
import com.au.modelo.Funcionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Tiago
 */
public class VisualizarCaixaActionListener implements ActionListener, ListSelectionListener {

    private final TelaVisualizarCaixa frm;
    private CaixaTableModel tableModel;
    private List<Caixa> caixas = new DAO<>(Caixa.class).listaTodos();

    public VisualizarCaixaActionListener(TelaVisualizarCaixa frm) {
        this.frm = frm;
        adicionaListener();
        inicializaTableModel();
    }

    private void atualizaTableModel(List<Caixa> caixas) {
        tableModel = new CaixaTableModel(caixas);
        frm.getTabelaCaixasEncontrados().setModel(tableModel);
        if (caixas != null && caixas.isEmpty()) {
            Caixa caixa = new Caixa();
            Funcionario funcionario = new Funcionario();
            funcionario.setNomeFunc("Nenhum Registro Encontrado");
            caixa.setFuncionario(funcionario);
            caixa.getFuncionario().getNomeFunc();
            caixas.add(caixa);
            frm.getTabelaCaixasEncontrados().getColumnModel().getColumn(1).setMaxWidth(1000);
        }
        frm.getTabelaCaixasEncontrados().getSelectionModel().addListSelectionListener(this);
        frm.getTabelaCaixasEncontrados().getColumnModel().getColumn(0).setMaxWidth(35);
        frm.getTabelaCaixasEncontrados().getColumnModel().getColumn(1).setMaxWidth(200);
    }

    private void inicializaTableModel() {
        atualizaTableModel(caixas);
    }

    private void adicionaListener() {
        frm.getBotaoProcurarCaixa().addActionListener(this);
        frm.getBotaoReimprimirRelatorio().addActionListener(this);
        frm.getBotaoVoltarTelaPrincipal().addActionListener(this);
        frm.getBotaoVisualizarDetalhesCaixa().addActionListener(this);
    }

    private void procurarCaixas() {
        /* funcionando parcialmente. É necessário acertar a mensagem de "nenhum registro encontrado" */
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        String data = sdf.format(frm.getDateChooserDataAberturaCaixa().getDate());
        boolean estaAberto = false;
        if (frm.getComboBoxCaixasAbertos().getSelectedIndex() == 0) {
            estaAberto = true;
        } else if (frm.getComboBoxCaixasAbertos().getSelectedIndex() == 1) {
            estaAberto = false;
        }
        atualizaTableModel(new DAO<>(Caixa.class).buscaCaixas(data, estaAberto));
    }

    private void caixaToFrame(Caixa caixa) {
        //Informações Gerais
        frm.getTextoValorFundoCaixa().setText(String.format("R$ %.2f", caixa.getFundoCaixa()));
        //Quantidade Total de Pedidos
        //Quantidade de Pedidos em Dinheiro
        //Quantidade de Pedidos em CC
        //Quantidade de Pedidos em CD
        //Quantidade de Pedidos em Vale

        //Faturamento
        frm.getTextoValorTotalFaturadoFaturamento().setText(String.format("R$ %.2f", caixa.getTotalCaixa()));
        //Total Faturado em Dinheiro
        //Total Faturado em CC
        //Total Faturado em CD
        //Total Faturado em Vale

        //Balanço do Caixa
        frm.getTextoValorTotalFaturadoBalanco().setText(String.format("R$ %.2f", caixa.getTotalCaixa()));
        //Total de Retiradas
        //Total do Caixa

        //Retiradas
        //lógica para verificar as retiradas
        //QTD de Retiradas
        //Total de Retiradas
        
        //Protótipo de lógica para verificar as retiradas, falta ainda a função para procurar o total de retiradas
        int retiradas = 1; // valor para testes
        if (retiradas == 0) {
            frm.getTextoQuantidadeRetiradas().setVisible(false);
            frm.getTextoValorQuantidadeRetiradas().setVisible(false);
            frm.getTextoTotalRetiradasRetiradas().setVisible(false);
            frm.getTextoValorTotalRetiradasRetiradas().setVisible(false);
            frm.getTextoSemRetiradas().setVisible(true);
        } else if (retiradas > 0) {
            //Setar QTD
            //Setar Total
            frm.getTextoQuantidadeRetiradas().setVisible(true);
            frm.getTextoValorQuantidadeRetiradas().setVisible(true);
            frm.getTextoTotalRetiradasRetiradas().setVisible(true);
            frm.getTextoValorTotalRetiradasRetiradas().setVisible(true);
            frm.getTextoSemRetiradas().setVisible(false);
        }

        //Descontos
        //Lógica para verificar os Descontos
        //QTD de Descontos
        //Total dos Descontos
        
        //Cancelamentos
        //Lógica para verificar os Cancelamentos
        //QTD de cancelamentos
        //Total de Cancelamentos
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Procurar":
                procurarCaixas();
                break;
            case "Reimprimir Relatório de Fechamento de Caixa":
                //reimprimir relatório
                break;
            case "Voltar à Tela Principal":
                this.frm.dispose();
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (frm.getTabelaCaixasEncontrados().getSelectedRow() != -1) {
            Caixa caixa = tableModel.getCaixas().get(frm.getTabelaCaixasEncontrados().getSelectedRow());
            if (caixa.getIdCaixa() != 0) {
                caixaToFrame(caixa);
            }
        }
    }
}
