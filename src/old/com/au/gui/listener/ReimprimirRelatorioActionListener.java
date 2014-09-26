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
package old.com.au.gui.listener;

import com.au.dao.DAO;
import old.com.au.gui.TelaReimprimirRelatorio;
import com.au.gui.tmodel.CaixaTableModel;
import com.au.modelo.Caixa;
import com.au.util.Imprime;
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
public class ReimprimirRelatorioActionListener implements ActionListener, ListSelectionListener {

    private final TelaReimprimirRelatorio frm;
    private CaixaTableModel tableModel;
    private List<Caixa> caixas = new DAO<>(Caixa.class).listaTodos();
    private int idCaixaSelecionado = 0;

    public ReimprimirRelatorioActionListener(TelaReimprimirRelatorio frm) {
        this.frm = frm;
        adicionaListener();
        //inicializaTableModel();
    }

    private void atualizaTableModel(List<Caixa> caixas) {
        if (caixas != null && caixas.isEmpty()) {
            Caixa caixa = new Caixa();
            caixa.getFuncionario().setNomeFunc("Nenhum Registro Encontrado"); // dando erro, necessário consultar lead developer
            caixas.add(caixa);
        }
        tableModel = new CaixaTableModel(caixas);
        frm.getTabelaCaixasEncontrados().setModel(tableModel);
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

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Procurar":
                procurarCaixas();
                break;
            case "Reimprimir Relatório de Fechamento de Caixa":
                new Imprime().geraRelatorioFechamento(idCaixaSelecionado);
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
                idCaixaSelecionado = caixa.getIdCaixa();
            }
        }
    }
}
