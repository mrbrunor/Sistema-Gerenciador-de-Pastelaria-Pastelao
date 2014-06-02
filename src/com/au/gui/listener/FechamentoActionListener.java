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

import com.au.dao.DespesaDao;
import com.au.gui.TelaFechamentoCaixa;
import com.au.modelo.Caixa;
import com.au.modelo.Despesa;
import com.au.util.Bematech;
import com.au.dao.DAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author BrunoRicardo
 */
public class FechamentoActionListener implements ActionListener, KeyListener {

    private final TelaFechamentoCaixa frm;
    private Caixa caixa;
    private double dinheiroCaixa;
    private double descontoTotal = 0;
    private int qtdPedDinheiro = 0;
    private int qtdPedCred = 0;
    private int qtdPedDeb = 0;
    private int qtdPedVale = 0;
    private int qtdPedCanc = 0;
    private int qtdPedDesc = 0;

    /**
     *
     * @param frm Construtor do ActionListener Recebe uma TelaFechamentoCaixa
     * como parametro
     */
    public FechamentoActionListener(TelaFechamentoCaixa frm) {
        this.frm = frm;
        /**
         * Pega o id do Caixa ativo e recupera todas as informações contidas no
         * Banco
         */
        caixa = new DAO<>(Caixa.class).buscaPorId(frm.getIdCaixa());
        inicializaCampos();
        adicionaListener();
    }

    /**
     * Função responsavel por inicializar os valores dos campos, e chama as
     * funções para calcular a quantidade vendida por forma de pagamento.
     */
    public void inicializaCampos() {
        frm.getTextoValorFundoDeCaixa().setText(String.format("R$: %.2f", caixa.getFundoCaixa()));
        frm.getTextoValorTotalFaturado().setText(String.format("TOTAL FATURADO: R$ %.2f", (caixa.getTotalCaixa())));
        calculaReducoes();
        calculaTipoPagamento();
    }

    /**
     * Função responsavel por caulcular o valor de cada Tipo de forma de
     * Pagamento
     */
    public void calculaTipoPagamento() {
        if (caixa.getPedidos() != null && !caixa.getPedidos().isEmpty()) {
            double totalDinheiro = 0;
            double totalCredito = 0;
            double totalDebito = 0;
            double totalVale = 0;

            for (int i = 0; i < caixa.getPedidos().size(); i++) {
                if ("Finalizado".equals(caixa.getPedidos().get(i).getEstadoPedido())) {
                    if ("Dinheiro".equals(caixa.getPedidos().get(i).getFormaPagamento().getTipoFormaPgto())) {
                        totalDinheiro = totalDinheiro + caixa.getPedidos().get(i).getTotPedido();
                        qtdPedDinheiro += 1;
                    } else if ("Credito".equals(caixa.getPedidos().get(i).getFormaPagamento().getTipoFormaPgto())) {
                        totalCredito = totalCredito + caixa.getPedidos().get(i).getTotPedido();
                        qtdPedCred += 1;
                    } else if ("Debito".equals(caixa.getPedidos().get(i).getFormaPagamento().getTipoFormaPgto())) {
                        totalDebito = totalDebito + caixa.getPedidos().get(i).getTotPedido();
                        qtdPedDeb += 1;
                    } else if ("Vale".equals(caixa.getPedidos().get(i).getFormaPagamento().getTipoFormaPgto())) {
                        totalVale = totalVale + caixa.getPedidos().get(i).getTotPedido();
                        qtdPedVale += 1;
                    }
                    if (caixa.getPedidos().get(i).getDescPedido() != 0) {
                        descontoTotal += caixa.getPedidos().get(i).getDescPedido();
                        qtdPedDesc += 1;
                    }
                } else {
                    qtdPedCanc += 1;
                }
            }
            frm.getTextoValorDinheiro().setText(String.format("R$: %.2f", totalDinheiro));
            frm.getTextoValorCartaoDeCredito().setText(String.format("R$: %.2f", totalCredito));
            frm.getTextoValorCartaoDeDebito().setText(String.format("R$: %.2f", totalDebito));
            frm.getTextoValorValeRefeicao().setText(String.format("R$: %.2f", totalVale));
        } else {
            frm.getTextoValorDinheiro().setText("R$: 0,00");
            frm.getTextoValorCartaoDeCredito().setText("R$: 0,00");
            frm.getTextoValorCartaoDeDebito().setText("R$: 0,00");
            frm.getTextoValorValeRefeicao().setText("R$: 0,00");
        }
    }

    /**
     * Função responsavel por calcular as retiradas de caixa
     */
    public void calculaReducoes() {
        double totalDesp = 0;
        List<Despesa> despesas = new DespesaDao().getLista(caixa.getIdCaixa());
        if (despesas != null && !despesas.isEmpty()) {
            for (Despesa despesa : despesas) {
                totalDesp = totalDesp + despesa.getValorDesp();
            }
            frm.getTextoValorTotalRetiradas().setText(String.format("R$: %.2f", totalDesp));
        } else {
            frm.getTextoValorTotalRetiradas().setText("R$: 0,00");
        }
        frm.getTextoValorTotalDeReducoes().setText(String.format("R$: %.2f", totalDesp));

        frm.getTextoValorRetiradas().setText(String.format("R$: %.2f", totalDesp));
        frm.getTextoValorFaturamentos().setText(String.format("R$: %.2f", caixa.getTotalCaixa()));
        frm.getTextoValorTotalCaixa().setText(String.format("R$: %.2f", caixa.getTotalCaixa() - totalDesp));

    }

    /**
     * Função responsavel por adicionar este action listenner aos botões e
     * campos da TelaFechamentoCaixa
     */
    public void adicionaListener() {
        frm.getBotaoCancelarFechamentoDeCaixa().addActionListener(this);
        frm.getBotaoConfirmarFechamentoDeCaixa().addActionListener(this);
        frm.getCampoCedulaCemReais().addKeyListener(this);
        frm.getCampoCedulaCincoReais().addKeyListener(this);
        frm.getCampoCedulaCinquentaReais().addKeyListener(this);
        frm.getCampoCedulaDezReais().addKeyListener(this);
        frm.getCampoCedulaDoisReais().addKeyListener(this);
        frm.getCampoCedulaVinteReais().addKeyListener(this);
        frm.getCampoMoedaCincoCentavos().addKeyListener(this);
        frm.getCampoMoedaCinquentaCentavos().addKeyListener(this);
        frm.getCampoMoedaDezCentavos().addKeyListener(this);
        frm.getCampoMoedaUmReal().addKeyListener(this);
        frm.getCampoMoedaVinteCincoCentavos().addKeyListener(this);
    }

    /**
     * Função responsavel por calcular o valor de cada tipo de Moeda ou Cedula
     * Digitada no campo correspondente da Tela.
     */
    public void calculaDinheiroEmCaixa() {
        dinheiroCaixa = 0;

        if (!"".equals(frm.getCampoMoedaCincoCentavos().getText())) {
            dinheiroCaixa += Integer.valueOf((frm.getCampoMoedaCincoCentavos().getText())) * 0.05;
        }
        if (!"".equals(frm.getCampoMoedaCinquentaCentavos().getText())) {
            dinheiroCaixa += Double.valueOf((frm.getCampoMoedaCinquentaCentavos().getText())) * 0.5;
        }
        if (!"".equals(frm.getCampoMoedaDezCentavos().getText())) {
            dinheiroCaixa += Double.valueOf((frm.getCampoMoedaDezCentavos().getText())) * 0.1;
        }
        if (!"".equals(frm.getCampoMoedaUmReal().getText())) {
            dinheiroCaixa += Double.valueOf((frm.getCampoMoedaUmReal().getText()));
        }
        if (!"".equals(frm.getCampoMoedaVinteCincoCentavos().getText())) {
            dinheiroCaixa += Double.valueOf((frm.getCampoMoedaVinteCincoCentavos().getText())) * .25;
        }
        if (!"".equals(frm.getCampoCedulaCemReais().getText())) {
            dinheiroCaixa += Double.valueOf((frm.getCampoCedulaCemReais().getText())) * 100;
        }
        if (!"".equals(frm.getCampoCedulaCincoReais().getText())) {
            dinheiroCaixa += Double.valueOf((frm.getCampoCedulaCincoReais().getText())) * 5;
        }
        if (!"".equals(frm.getCampoCedulaCinquentaReais().getText())) {
            dinheiroCaixa += Double.valueOf((frm.getCampoCedulaCinquentaReais().getText())) * 50;
        }
        if (!"".equals(frm.getCampoCedulaDezReais().getText())) {
            dinheiroCaixa += Double.valueOf((frm.getCampoCedulaDezReais().getText())) * 10;
        }
        if (!"".equals(frm.getCampoCedulaDoisReais().getText())) {
            dinheiroCaixa += Double.valueOf((frm.getCampoCedulaDoisReais().getText())) * 2;
        }
        if (!"".equals(frm.getCampoCedulaVinteReais().getText())) {
            dinheiroCaixa += Double.valueOf((frm.getCampoCedulaVinteReais().getText())) * 20;
        }

        frm.getTextoValorTotalEmCaixa().setText(String.format("R$: %.2f", dinheiroCaixa));
    }

    /**
     * Função responsavel por Efetuar o Fechamento do caixa
     */
    public void fecharCaixa() {
        //Captura a data atual do Sistema
        Date data = new Date();
        caixa.setDataFechamentoCaixa(data);
        //captura apenas a hora da data recem capturada
        caixa.setFechamentoCaixa(new Time(data.getTime()));
        //Seta 0 para informar que o caixa esta fechado
        caixa.setEstaAberto((byte) 0);
        //Pede para o Hibernate Atualizar o Caixa
        new DAO<>(Caixa.class).atualiza(caixa);
        //Seta o atributo "fechou" como true, para que o metodo que chamouo o Fechamento de caixa possa saber que o fechamento foi efetuado com Sucesso
        TelaFechamentoCaixa.setFechou(true);

        //Cria e Imprime o Relatório do caixa fechado
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataStr = formatador.format(caixa.getDataFechamentoCaixa());
        Bematech bematech = new Bematech();
        bematech.detectaImpressoras("Caixa");
        if (Bematech.impressora != null) {
            bematech.imprime("\n\tFechamento de Caixa\n");
            bematech.imprime("\nFuncionario: " + caixa.getFuncionario().getNomeFunc());
            bematech.imprime("\n");
            bematech.imprime("\nQuantidade de Pedidos: " + qtdPedCred + qtdPedDeb + qtdPedDinheiro + qtdPedVale);
            bematech.imprime("\nDinheiro: " + qtdPedDinheiro);
            bematech.imprime("\nCredito: " + qtdPedCred);
            bematech.imprime("\nDebito: " + qtdPedDeb);
            bematech.imprime("\nVale: " + qtdPedVale);
            bematech.imprime("\n--------------------------------------------------------------\n");
            bematech.imprime("\n");
            bematech.imprime("\nFundo de Caixa: " + caixa.getFundoCaixa());
            bematech.imprime("\n");
            bematech.imprime(dataStr + "                    " + caixa.getDataFechamentoCaixa());
            bematech.imprime("\nDinheiro: " + frm.getTextoValorDinheiro().getText());
            bematech.imprime("\nCredito: " + frm.getTextoValorCartaoDeCredito().getText());
            bematech.imprime("\nDebito: " + frm.getTextoValorCartaoDeDebito().getText());
            bematech.imprime("\nVale: " + frm.getTextoValorValeRefeicao().getText());
            bematech.imprime("\n--------------------------------------------------------------\n");
            bematech.imprime("\n");
            bematech.imprime("\nTotal Faturado: " + caixa.getTotalCaixa());
            bematech.imprime("\nTotal retiradas: " + frm.getTextoValorTotalRetiradas());
            bematech.imprime("\nTotal Caixa: " + frm.getTextoValorTotalCaixa());
            bematech.imprime("\n--------------------------------------------------------------\n");
            bematech.imprime("\n");

            List<Despesa> despesas = new DespesaDao().getLista(caixa.getIdCaixa());

            if (despesas != null && !despesas.isEmpty()) {
                bematech.imprime("\nQuantidade de Retiradas: " + despesas.size());
                bematech.imprime("\n\nLista de Retiradas\n");
                for (int i = 0; despesas.size() > i; i++) {
                    bematech.imprime("\n");
                    bematech.imprime("\nDespesa " + (i + 1));
                    bematech.imprime("\nMotivo: " + despesas.get(i).getDescDesp());
                    bematech.imprime("\nValor: " + despesas.get(i).getValorDesp());
                    bematech.imprime("\n");
                    bematech.imprime("\n");
                }
            } else {
                bematech.imprime("\nSem Retiradas\n");
            }            
            if(caixa.getPedidos() != null && caixa.getPedidos().size() > 0){
                bematech.imprime("\n--------------------------------------------------------------\n");
                bematech.imprime("\nQuantidade de Descontos: " + qtdPedDesc);
                bematech.imprime("\n\nLista de Descontos\n");
                for (int i = 0; caixa.getPedidos().size() > i; i++){
                    if(caixa.getPedidos().get(i).getDescPedido() > 0){
                        bematech.imprime("\nNumero do Pedido: " + caixa.getPedidos().get(i).getNumPedido());
                        bematech.imprime("\nValor do Pedido: " + caixa.getPedidos().get(i).getSubTotPedido());
                        bematech.imprime("\nValor do Desconto: " + caixa.getPedidos().get(i).getDescPedido());
                        bematech.imprime("\n");
                        bematech.imprime("\n");
                    }
                }
                bematech.imprime("\n--------------------------------------------------------------\n");
                bematech.imprime("\n\nTotal de Descontos: " + String.format("R$: %.2f", descontoTotal));
            } else {
                bematech.imprime("\nSem Descontos\n");
            }
            
            if(caixa.getPedidos() != null && caixa.getPedidos().size() > 0){
                bematech.imprime("\n--------------------------------------------------------------\n");
                bematech.imprime("\nQuantidade de Cancelamentos: " + qtdPedCanc);
                bematech.imprime("\n\nLista de Cancelamentos\n");
                double totalCanc = 0;
                for (int i = 0; caixa.getPedidos().size() > i; i++){
                    if("Cancelado".equals(caixa.getPedidos().get(i).getEstadoPedido())){
                        totalCanc += caixa.getPedidos().get(i).getSubTotPedido();
                        bematech.imprime("\nNumero do Pedido: " + caixa.getPedidos().get(i).getNumPedido());
                        bematech.imprime("\nValor do Pedido: " + caixa.getPedidos().get(i).getSubTotPedido());
                        bematech.imprime("\n");
                        bematech.imprime("\n");
                    }
                }
                bematech.imprime("\n--------------------------------------------------------------\n");
                bematech.imprime("\n\nTotal de Cancelamentos: " + String.format("R$: %.2f", totalCanc));
            } else {
                bematech.imprime("\nSem Cancelamentos\n");
            }
            

        } else {
            JOptionPane.showMessageDialog(frm, "Impressora Caixa não foi encontrada. O relatório de caixa não será impresso.");
        }
    }

    /**
     *
     * @param event Função responsavel por pegar o ActionEvent e executar a
     * função apropriada
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Cancelar Fechamento de Caixa":
                this.frm.dispose();
                break;
            case "Confirmar Fechamento de Caixa":
                fecharCaixa();
                this.frm.dispose();
                break;
        }
    }

    /**
     *
     * @param e Implementação obrigatória, sem uso nesta classe
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     *
     * @param e Implementação obrigatória, sem uso nesta classe
     */
    @Override
    public void keyPressed(KeyEvent e) {
    }

    /**
     *
     * @param e Função responsavel por chamar a Função calculaDinheiroEmCaixa
     * toda vez que uma tecla for "Despressionada" em um dos campos da Seção
     * "Dinheiro em caixa"
     */
    @Override
    public void keyReleased(KeyEvent e) {
        calculaDinheiroEmCaixa();
    }
}
