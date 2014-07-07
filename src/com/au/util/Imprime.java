/*
 * Copyright (C) 2014 BrunoRicardo
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
package com.au.util;

import com.au.dao.DAO;
import com.au.dao.DespesaDao;
import com.au.gui.TelaFechamentoCaixa;
import com.au.modelo.Caixa;
import com.au.modelo.Despesa;
import com.au.modelo.Pedido;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author BrunoRicardo
 */
public class Imprime {

    //private final TelaFechamentoCaixa frm;
    private double descontoTotal = 0;
    private int qtdPedDinheiro = 0;
    private int qtdPedCred = 0;
    private int qtdPedDeb = 0;
    private int qtdPedVale = 0;
    private int qtdPedCanc = 0;
    private int qtdPedDesc = 0;
    double totalDinheiro = 0;
    double totalCredito = 0;
    double totalDebito = 0;
    double totalVale = 0;

    public String removeAcentos(String str) {
        str = Normalizer.normalize(str, Normalizer.Form.NFD);
        str = str.replaceAll("[^\\p{ASCII}]", "");
        return str;
    }

    public void geraComandaVenda(int idPedido) {
        int iRetorno;
        String iComando;

        Pedido pedido = new DAO<>(Pedido.class).buscaPorId(idPedido);

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataStr = formatador.format(pedido.getDataPedido());

        BematechNFiscal cupom = BematechNFiscal.Instance;

        iRetorno = cupom.ConfiguraModeloImpressora(5);
        iRetorno = cupom.IniciaPorta("LPT1");
        iRetorno = cupom.PrintNVBitmap(1, 0);
        iRetorno = cupom.BematechTX("\n\n" + dataStr + "                    " + pedido.getHoraPedido() + "\r\n");
        iRetorno = cupom.BematechTX("AGUARDE PELO NUMERO:   " + BematechComandosDiretos.SO + BematechComandosDiretos.NEGRITO_ON + String.format("%03d", pedido.getNumPedido()) + BematechComandosDiretos.NEGRITO_OFF + "\r\n");
        iRetorno = cupom.BematechTX("FORMA DE CONSUMO   :   " + BematechComandosDiretos.SO + BematechComandosDiretos.NEGRITO_ON + pedido.getFormaConsumo() + BematechComandosDiretos.NEGRITO_OFF + "\r\n");
        iRetorno = cupom.BematechTX("" + (char) 10);
        iRetorno = cupom.FormataTX("Codigo\t\t QTD\tUnit\t Total\r\nDescricao\r\n", 3, 0, 0, 0, 0);
        for (int i = 0; pedido.getItempedidos().size() > i; i++) {
            int valorUnitarioInt = (int) pedido.getItempedidos().get(i).getProduto().getValorProd();
            String valorUnitarioStr = Integer.toString(valorUnitarioInt);
            System.out.println(valorUnitarioStr);
            System.out.println(valorUnitarioStr.length());
            if (valorUnitarioStr.length() == 1) { //Valores com 1 dígito
                iRetorno = cupom.BematechTX(BematechComandosDiretos.SO + BematechComandosDiretos.NEGRITO_ON + String.format("%03d", pedido.getItempedidos().get(i).getProduto().getIdProd())
                        + BematechComandosDiretos.avanco(3) + "x " + String.format("%02d", pedido.getItempedidos().get(i).getQtdProd()) + BematechComandosDiretos.NEGRITO_OFF + BematechComandosDiretos.DC4 + BematechComandosDiretos.avanco(4)
                        + String.format("%.2f", pedido.getItempedidos().get(i).getProduto().getValorProd()) + BematechComandosDiretos.avanco(5)
                        + String.format("%.2f", pedido.getItempedidos().get(i).getTotProd()) + "\r\n");
                iRetorno = cupom.FormataTX(removeAcentos(pedido.getItempedidos().get(i).getProduto().getDescProd()) + "\r\n\n", 3, 0, 0, 0, 1);
            } else if (valorUnitarioStr.length() == 2) { //Valores com 2 dígitos
                iRetorno = cupom.BematechTX(BematechComandosDiretos.SO + BematechComandosDiretos.NEGRITO_ON + String.format("%03d", pedido.getItempedidos().get(i).getProduto().getIdProd())
                        + BematechComandosDiretos.avanco(3) + "x " + String.format("%02d", pedido.getItempedidos().get(i).getQtdProd()) + BematechComandosDiretos.NEGRITO_OFF + BematechComandosDiretos.DC4 + BematechComandosDiretos.avanco(4)
                        + String.format("%.2f", pedido.getItempedidos().get(i).getProduto().getValorProd()) + BematechComandosDiretos.avanco(4)
                        + String.format("%.2f", pedido.getItempedidos().get(i).getTotProd()) + "\r\n");
                iRetorno = cupom.FormataTX(removeAcentos(pedido.getItempedidos().get(i).getProduto().getDescProd()) + "\r\n", 3, 0, 0, 0, 1);
            }
        }
        iRetorno = cupom.FormataTX("\n\t\t" + BematechComandosDiretos.avanco(5) + "SUBTOTAL.......... " + String.format("%.2f", pedido.getSubTotPedido()) + "\r\n", 3, 0, 0, 0, 1);
        iRetorno = cupom.FormataTX("\t\t" + BematechComandosDiretos.avanco(5) + "DESCONTO.......... " + String.format("%.2f", pedido.getDescPedido()) + "\r\n", 3, 0, 0, 0, 1);
        iRetorno = cupom.FormataTX("\t\t" + BematechComandosDiretos.avanco(5) + "TOTAL............. " + String.format("%.2f", pedido.getTotPedido()) + "\r\n\n", 3, 0, 0, 0, 1);
        iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON);
        iRetorno = cupom.BematechTX("Forma de Pagamento: " + pedido.getFormaPagamento().getTipoFormaPgto() + "\r\n");
        iRetorno = cupom.BematechTX("\tValor Recebido ==> " + String.format("%.2f", pedido.getValorRecebido()) + "\r\n");
        iRetorno = cupom.BematechTX("\tTroco          ==> " + String.format("%.2f", (pedido.getValorRecebido() - pedido.getTotPedido())) + "\r\n\n");
        iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_OFF);

        iRetorno = cupom.BematechTX(BematechComandosDiretos.alinhamento(1));
        iRetorno = cupom.FormataTX("ESTE CUPOM NAO TEM VALIDADE FISCAL\r\n", 3, 1, 0, 0, 0);
        iRetorno = cupom.FormataTX("Obrigado pela Preferencia, Volte Sempre!\r\n", 3, 1, 0, 0, 1);
        iRetorno = cupom.BematechTX(BematechComandosDiretos.alinhamento(0));
        iComando = "" + (char) 10;
        for (int i = 0; i < 9; i++) {
            iRetorno = cupom.ComandoTX(iComando, iComando.length());
        }
        iRetorno = cupom.FechaPorta();
        /*
         iRetorno = cupom.FormataTX("TEXTO ITÁLICO\r\n", 2, 1, 0, 0, 0);
         iRetorno = cupom.FormataTX("TEXTO NEGRITO\r\n", 2, 0, 0, 0, 1);
         iRetorno = cupom.FormataTX("TEXTO SUBLINHADO\r\n", 2, 0, 1, 0, 0);
         iRetorno = cupom.FormataTX("TEXTO CONDENSADO\r\n", 1, 0, 0, 0, 0);
         iRetorno = cupom.FormataTX("TEXTO ELITE\r\n", 3, 0, 0, 0, 0);
         iRetorno = cupom.FormataTX("TEXTO NORMAL\r\n", 2, 0, 0, 0, 0);*/
    }

    public void geraComandaCozinha(int idPedido) {
        Pedido pedido = new DAO<>(Pedido.class).buscaPorId(idPedido);
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataStr = formatador.format(pedido.getDataPedido());
        Bematech bematech = new Bematech();
        bematech.detectaImpressoras("Cozinha");
        if (Bematech.impressora != null) {
            bematech.imprime("P A S T E L A O  \nV I A  D A  C O Z I N H A\n\n"
                    + dataStr + "                    " + pedido.getHoraPedido()
                    + "\n\nPEDIDO NUMERO:     " + pedido.getNumPedido()
                    + "\n\nCodigo\t\tQT");

            for (int i = 0; pedido.getItempedidos().size() > i; i++) {
                bematech.imprime("\n" + pedido.getItempedidos().get(i).getProduto().getIdProd() + "\tx\t" + pedido.getItempedidos().get(i).getQtdProd());
            }
            bematech.imprime("\n\n\n\n\n\n\n\n\n\n\n");
            Bematech.impressora = null;
        } else {
            //JOptionPane.showMessageDialog(frm, "Impressora Cozinha não foi encontrada. O cupom não será impresso.", "Impressão de Cupom", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void calculaTipoPagamento(Caixa caixa) {
        if (caixa.getPedidos() != null && !caixa.getPedidos().isEmpty()) {
            totalDinheiro = 0;
            totalCredito = 0;
            totalDebito = 0;
            totalVale = 0;

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
        }
    }

    public void geraRelatorioFechamento(int idCaixa, String totalRetirada, String totalCaixa) {

        Caixa caixa = new DAO<>(Caixa.class).buscaPorId(idCaixa);

        calculaTipoPagamento(caixa);

        //Cria e Imprime o Relatório do caixa fechado
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataStr = formatador.format(caixa.getDataFechamentoCaixa());
        Bematech bematech = new Bematech();
        bematech.detectaImpressoras("Caixa");
        if (Bematech.impressora != null) {
            bematech.imprime("\n\t\tFechamento de Caixa\n");
            bematech.imprime(dataStr + "                    " + new SimpleDateFormat("HH:mm").format(caixa.getDataFechamentoCaixa()));
            bematech.imprime("Funcionario: " + caixa.getFuncionario().getNomeFunc());
            bematech.imprime("Quantidade de Pedidos: " + (qtdPedCred + qtdPedDeb + qtdPedDinheiro + qtdPedVale));
            bematech.imprime("Dinheiro: " + qtdPedDinheiro);
            bematech.imprime("Credito: " + qtdPedCred);
            bematech.imprime("Debito: " + qtdPedDeb);
            bematech.imprime("Vale: " + qtdPedVale);
            bematech.imprime("\n--------------------------------------------------\n");
            bematech.imprime(String.format("Fundo de Caixa: R$: %.2f", caixa.getFundoCaixa()));
            bematech.imprime(String.format("Dinheiro: R$: %.2f", totalDinheiro));
            bematech.imprime(String.format("Credito: R$: %.2f", totalCredito));
            bematech.imprime(String.format("Debito: R$: %.2f", totalDebito));
            bematech.imprime(String.format("Vale: R$: %.2f", totalVale));
            bematech.imprime("\n--------------------------------------------------\n");
            bematech.imprime(String.format("Total Faturado: R$ %.2f", caixa.getTotalCaixa()));
            bematech.imprime("Total Retiradas: " + totalRetirada);
            bematech.imprime("Total Caixa: R$ " + totalCaixa);
            bematech.imprime("\n--------------------------------------------------\n");

            List<Despesa> despesas = new DespesaDao().getLista(caixa.getIdCaixa());

            if (despesas != null && !despesas.isEmpty()) {
                bematech.imprime("Quantidade de Retiradas: " + despesas.size());
                bematech.imprime("\nLista de Retiradas");
                for (int i = 0; despesas.size() > i; i++) {
                    bematech.imprime("\nRetirada " + (i + 1));
                    bematech.imprime("Motivo: " + despesas.get(i).getDescDesp());
                    bematech.imprime(String.format("Valor: R$ %.2f", despesas.get(i).getValorDesp()));
                }
            } else {
                bematech.imprime("\nSem Retiradas");
            }
            if (caixa.getPedidos() != null && caixa.getPedidos().size() > 0) {
                bematech.imprime("\n--------------------------------------------------\n");
                bematech.imprime("\nQuantidade de Descontos: " + qtdPedDesc);
                if (qtdPedDesc == 0) {
                    bematech.imprime("\nSem Descontos\n");
                } else {
                    bematech.imprime("\nLista de Descontos");

                    for (int i = 0; caixa.getPedidos().size() > i; i++) {
                        if (caixa.getPedidos().get(i).getDescPedido() > 0) {

                            bematech.imprime("\nNumero do Pedido: " + caixa.getPedidos().get(i).getNumPedido());
                            bematech.imprime(String.format("Valor do Pedido: R$ %.2f", caixa.getPedidos().get(i).getSubTotPedido()));
                            bematech.imprime(String.format("Valor do Desconto: R$ %.2f", caixa.getPedidos().get(i).getDescPedido()));
                        }
                    }

                    bematech.imprime("\n--------------------------------------------------\n");
                    bematech.imprime("Total de Descontos: " + String.format("R$: %.2f", descontoTotal));
                }
            }

            if (caixa.getPedidos() != null && caixa.getPedidos().size() > 0) {
                bematech.imprime("\n--------------------------------------------------\n");
                bematech.imprime("Quantidade de Cancelamentos: " + qtdPedCanc);
                if (qtdPedCanc == 0) {
                    bematech.imprime("\nSem Cancelamentos\n");
                } else {
                    bematech.imprime("\nLista de Cancelamentos\n");
                    double totalCanc = 0;
                    for (int i = 0; caixa.getPedidos().size() > i; i++) {
                        if ("Cancelado".equals(caixa.getPedidos().get(i).getEstadoPedido())) {
                            totalCanc += caixa.getPedidos().get(i).getSubTotPedido();
                            bematech.imprime("\nNumero do Pedido: " + caixa.getPedidos().get(i).getNumPedido());
                            bematech.imprime(String.format("\nValor do Pedido: R$ %.2f", caixa.getPedidos().get(i).getSubTotPedido()));
                        }
                    }
                    bematech.imprime("\n--------------------------------------------------\n");
                    bematech.imprime("\n\nTotal de Cancelamentos: " + String.format("R$: %.2f", totalCanc));
                }
            }
            bematech.imprime("\n________________________________________________");
            bematech.imprime("\t" + caixa.getFuncionario().getNomeFunc());
            bematech.imprime("\n\n\n\n\n\n\n\n\n\n\n");
        } else {
            //JOptionPane.showMessageDialog(frm, "Impressora Caixa não foi encontrada. O relatório de caixa não será impresso.", "Impressão de Relatório", JOptionPane.WARNING_MESSAGE);
        }
    }

}
