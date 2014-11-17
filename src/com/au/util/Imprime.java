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

import com.au.bean.Caixa;
import com.au.bean.Despesa;
import com.au.bean.Pedido;
import com.au.dao.CaixaDao;
import com.au.dao.FuncionarioDao;
import com.au.dao.PedidoDao;
import com.au.dao.DespesaDao;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author BrunoRicardo
 */
public class Imprime {

    //private final TelaFechamentoCaixa frm;
    private final CaixaDao cDao = new CaixaDao();
    private final PedidoDao pDao = new PedidoDao();
    private final FuncionarioDao fDao = new FuncionarioDao();
    private final DespesaDao dDao = new DespesaDao();
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
    double totalDesp = 0;

    public String removeAcentos(String str) {
        str = Normalizer.normalize(str, Normalizer.Form.NFD);
        str = str.replaceAll("[^\\p{ASCII}]", "");
        return str;
    }

    public void geraComandaVenda(int idPedido) throws UnsatisfiedLinkError {
        int iRetorno;
        String iComando;

        pDao.abreConnection();
        Pedido pedido = pDao.buscaPedidoPorId(idPedido);
        pedido = pDao.listaItemPedido(pedido);
        pDao.fechaConnection();

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataStr = formatador.format(pedido.getDataPedido());

        for (int i = 0; pedido.getItempedidos().size() > i; i++) {
            System.out.println("Produto: " + pedido.getItempedidos().get(i).getProduto().getDescProd() + " Código: " + pedido.getItempedidos().get(i).getProduto().getNumProd() + " Ordem: " + pedido.getItempedidos().get(i).getOrdemProduto());
        }

        BematechNFiscal cupom = BematechNFiscal.Instance;

        iRetorno = cupom.ConfiguraModeloImpressora(5);
        iRetorno = cupom.IniciaPorta("LPT1");
        iRetorno = cupom.BematechTX(BematechComandosDiretos.INICIALIZA);
        iRetorno = cupom.PrintNVBitmap(1, 0);
        iRetorno = cupom.BematechTX("\n\n" + dataStr + "                    " + pedido.getHoraPedido() + "\r\n");
        iRetorno = cupom.BematechTX("AGUARDE PELO NUMERO:   " + BematechComandosDiretos.SO + BematechComandosDiretos.NEGRITO_ON + String.format("%03d", pedido.getNumPedido()) + BematechComandosDiretos.NEGRITO_OFF + "\r\n");
        iRetorno = cupom.BematechTX("FORMA DE CONSUMO   :   " + BematechComandosDiretos.SO + BematechComandosDiretos.NEGRITO_ON + pedido.getFormaConsumo() + BematechComandosDiretos.NEGRITO_OFF + "\r\n");
        iRetorno = cupom.BematechTX("" + (char) 10);
        iRetorno = cupom.FormataTX("Codigo\t\t QTD\tUnit\t Total\r\nDescricao\r\n", 3, 0, 0, 0, 0);
        for (int i = 0; pedido.getItempedidos().size() > i; i++) {
            int valorUnitarioInt = (int) pedido.getItempedidos().get(i).getProduto().getValorProd();
            String valorUnitarioStr = Integer.toString(valorUnitarioInt);
            if (valorUnitarioStr.length() == 1) { //Valores com 1 dígito
                iRetorno = cupom.BematechTX(BematechComandosDiretos.SO + BematechComandosDiretos.NEGRITO_ON + String.format("%03d", pedido.getItempedidos().get(i).getProduto().getNumProd())
                        + BematechComandosDiretos.avanco(3) + "x " + String.format("%01d", pedido.getItempedidos().get(i).getQtdProd()) + BematechComandosDiretos.NEGRITO_OFF + BematechComandosDiretos.DC4 + BematechComandosDiretos.avanco(4)
                        + String.format("%.2f", pedido.getItempedidos().get(i).getProduto().getValorProd()) + BematechComandosDiretos.avanco(5)
                        + String.format("%.2f", pedido.getItempedidos().get(i).getTotProd()) + "\r\n");
                iRetorno = cupom.FormataTX(removeAcentos(pedido.getItempedidos().get(i).getProduto().getDescProd()) + "\r\n", 3, 0, 0, 0, 1);
            } else if (valorUnitarioStr.length() == 2) { //Valores com 2 dígitos
                iRetorno = cupom.BematechTX(BematechComandosDiretos.SO + BematechComandosDiretos.NEGRITO_ON + String.format("%03d", pedido.getItempedidos().get(i).getProduto().getNumProd())
                        + BematechComandosDiretos.avanco(3) + "x " + String.format("%01d", pedido.getItempedidos().get(i).getQtdProd()) + BematechComandosDiretos.NEGRITO_OFF + BematechComandosDiretos.DC4 + BematechComandosDiretos.avanco(4)
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
        for (int i = 0; i < 4; i++) {
            iRetorno = cupom.ComandoTX(iComando, iComando.length());
        }
        iRetorno = cupom.BematechTX(BematechComandosDiretos.SO + BematechComandosDiretos.NEGRITO_ON + "Numero do Pedido: " + String.format("%03d", pedido.getNumPedido()) + BematechComandosDiretos.NEGRITO_OFF + "\r\n");
        iComando = "" + (char) 10;
        for (int i = 0; i < 9; i++) {
            iRetorno = cupom.ComandoTX(iComando, iComando.length());
        }
        iRetorno = cupom.FechaPorta();
    }

    public void geraComandaCozinha(int idPedido) throws UnsatisfiedLinkError {
        int iRetorno;
        String iComando;
        pDao.abreConnection();
        Pedido pedido = pDao.buscaPedidoPorId(idPedido);
        pedido = pDao.listaItemPedido(pedido);
        pDao.fechaConnection();

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataStr = formatador.format(pedido.getDataPedido());

        BematechNFiscal cupom = BematechNFiscal.Instance;

        iRetorno = cupom.ConfiguraModeloImpressora(7);
        iRetorno = cupom.IniciaPorta("192.168.0.183");
        iRetorno = cupom.BematechTX(BematechComandosDiretos.INICIALIZA);
        //iRetorno = cupom.PrintNVBitmap(1, 0);
        iRetorno = cupom.BematechTX(BematechComandosDiretos.alinhamento(1));
        iRetorno = cupom.FormataTX("VIA DA COZINHA\r\n", 3, 1, 0, 0, 1);
        iRetorno = cupom.BematechTX(BematechComandosDiretos.alinhamento(0));
        iRetorno = cupom.BematechTX("\n\n" + dataStr + "                    " + pedido.getHoraPedido() + "\r\n");
        iRetorno = cupom.BematechTX("PEDIDO NUMERO:   " + BematechComandosDiretos.SO + BematechComandosDiretos.NEGRITO_ON + String.format("%03d", pedido.getNumPedido()) + BematechComandosDiretos.NEGRITO_OFF + "\r\n");
        iRetorno = cupom.BematechTX("FORMA DE CONSUMO   :   " + BematechComandosDiretos.SO + BematechComandosDiretos.NEGRITO_ON + pedido.getFormaConsumo() + BematechComandosDiretos.NEGRITO_OFF + "\r\n");
        iRetorno = cupom.BematechTX("" + (char) 10);
        iRetorno = cupom.FormataTX("Codigo\t\t QTD\tDescricao\r\n", 3, 0, 0, 0, 0);
        for (int i = 0; pedido.getItempedidos().size() > i; i++) {
            iRetorno = cupom.BematechTX(BematechComandosDiretos.SO + BematechComandosDiretos.NEGRITO_ON + String.format("%03d", pedido.getItempedidos().get(i).getProduto().getIdProd())
                    + BematechComandosDiretos.avanco(3) + "x " + String.format("%02d", pedido.getItempedidos().get(i).getQtdProd())
                    + BematechComandosDiretos.NEGRITO_OFF + BematechComandosDiretos.DC4 + "\r\n");
            iRetorno = cupom.FormataTX(removeAcentos(pedido.getItempedidos().get(i).getProduto().getDescProd()) + "\r\n", 3, 0, 0, 0, 1);
        }
        /* iComando = "" + (char) 10;
        for (int i = 0; i < 9; i++) {
            iRetorno = cupom.ComandoTX(iComando, iComando.length());
        } */
        iRetorno = cupom.AcionaGuilhotina(0);
        iRetorno = cupom.FechaPorta();
    }

    private void calculaTipoPagamento(List<Pedido> pedidos) {
        if (pedidos != null && !pedidos.isEmpty()) {
            totalDinheiro = 0;
            totalCredito = 0;
            totalDebito = 0;
            totalVale = 0;
            for (int i = 0; i < pedidos.size(); i++) {
                if ("Finalizado".equals(pedidos.get(i).getEstadoPedido())) {
                    if ("Dinheiro".equals(pedidos.get(i).getFormaPagamento().getTipoFormaPgto())) {
                        totalDinheiro = totalDinheiro + pedidos.get(i).getTotPedido();
                        qtdPedDinheiro += 1;
                    } else if ("Credito".equals(pedidos.get(i).getFormaPagamento().getTipoFormaPgto())) {
                        totalCredito = totalCredito + pedidos.get(i).getTotPedido();
                        qtdPedCred += 1;
                    } else if ("Debito".equals(pedidos.get(i).getFormaPagamento().getTipoFormaPgto())) {
                        totalDebito = totalDebito + pedidos.get(i).getTotPedido();
                        qtdPedDeb += 1;
                    } else if ("Vale".equals(pedidos.get(i).getFormaPagamento().getTipoFormaPgto())) {
                        totalVale = totalVale + pedidos.get(i).getTotPedido();
                        qtdPedVale += 1;
                    }
                    if (pedidos.get(i).getDescPedido() > 0 && "Finalizado".equals(pedidos.get(i).getEstadoPedido())) {
                        descontoTotal += pedidos.get(i).getDescPedido();
                        qtdPedDesc += 1;
                    }
                } else {
                    qtdPedCanc += 1;
                }
            }
        }
    }

    public void calculaReducoes(Caixa caixa) {
        if (caixa.getDespesas() != null && !caixa.getDespesas().isEmpty()) {
            for (Despesa despesa : caixa.getDespesas()) {
                totalDesp = totalDesp + despesa.getValorDesp();
            }
        }
    }

    public void geraRelatorioFechamento(int idCaixa) throws UnsatisfiedLinkError {
        cDao.abreConnection();
        Caixa caixa = cDao.listaCaixaPorId(idCaixa);
        cDao.fechaConnection();
        dDao.abreConnection();
        caixa.setDespesas(dDao.listaDespesasPorCaixa(caixa.getIdCaixa()));
        dDao.fechaConnection();
        pDao.abreConnection();
        caixa.setPedidos(pDao.listaPedidosPorCaixa(caixa.getIdCaixa()));
        pDao.fechaConnection();
        fDao.abreConnection();
        caixa.setFuncionario(fDao.buscaPrId(caixa.getIdFunc()));
        fDao.fechaConnection();
        calculaTipoPagamento(caixa.getPedidos());
        calculaReducoes(caixa);
        int iRetorno;
        String iComando;
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataStr = formatador.format(caixa.getDataFechamentoCaixa());
        SimpleDateFormat formataHora = new SimpleDateFormat("HH:mm");
        SimpleDateFormat mesExtenso = new SimpleDateFormat("MMMMM");
        String mes = mesExtenso.format(caixa.getDataFechamentoCaixa());
        BematechNFiscal cupom = BematechNFiscal.Instance;

        iRetorno = cupom.ConfiguraModeloImpressora(5);
        iRetorno = cupom.IniciaPorta("LPT1");
        iRetorno = cupom.BematechTX(BematechComandosDiretos.INICIALIZA);
        iRetorno = cupom.PrintNVBitmap(1, 0);
        iComando = "" + BematechComandosDiretos.ESC + BematechComandosDiretos.a + (char) 1;
        iRetorno = cupom.ComandoTX(iComando, iComando.length());
        //iRetorno = cupom.BematechTX(BematechComandosDiretos.alinhamento(1));
        iRetorno = cupom.BematechTX("\r\n------------------------------------------------\r\n");
        iRetorno = cupom.FormataTX("\r\nFECHAMENTO DE CAIXA\r\n", 3, 0, 0, 1, 1);
        iRetorno = cupom.BematechTX("\r\n------------------------------------------------\r\n");
        iRetorno = cupom.FormataTX("Informacoes Gerais\r\n\r\n", 3, 1, 0, 0, 1);
        iComando = "" + BematechComandosDiretos.ESC + BematechComandosDiretos.a + (char) 0;
        iRetorno = cupom.ComandoTX(iComando, iComando.length());
        //iRetorno = cupom.BematechTX(BematechComandosDiretos.alinhamento(0));
        iRetorno = cupom.BematechTX(dataStr + "                    " + formataHora.format(caixa.getFechamentoCaixa()) + "\r\n");
        //iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "ID do Caixa: " +BematechComandosDiretos.NEGRITO_OFF + caixa.getIdCaixa() + "\r\n");
        iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "Funcionario: " + BematechComandosDiretos.NEGRITO_OFF + caixa.getFuncionario().getNomeFunc() + "\r\n");
        iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "Fundo de Caixa: " + BematechComandosDiretos.NEGRITO_OFF + String.format("R$: %.2f", caixa.getFundoCaixa()) + "\r\n");
        iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "Quantidade de Pedidos: " + BematechComandosDiretos.NEGRITO_OFF + (qtdPedCred + qtdPedDeb + qtdPedDinheiro + qtdPedVale) + "\r\n");
        iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "\tPagos com Dinheiro: " + BematechComandosDiretos.NEGRITO_OFF + qtdPedDinheiro + "\r\n");
        iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "\tPagos com Credito: " + BematechComandosDiretos.NEGRITO_OFF + qtdPedCred + "\r\n");
        iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "\tPagos com Debito: " + BematechComandosDiretos.NEGRITO_OFF + qtdPedDeb + "\r\n");
        iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "\tPagos com Vale: " + BematechComandosDiretos.NEGRITO_OFF + qtdPedVale + "\r\n");
        iRetorno = cupom.BematechTX("\r\n------------------------------------------------\r\n");
        iComando = "" + BematechComandosDiretos.ESC + BematechComandosDiretos.a + (char) 1;
        iRetorno = cupom.ComandoTX(iComando, iComando.length());
        //iRetorno = cupom.BematechTX(BematechComandosDiretos.alinhamento(1));
        iRetorno = cupom.FormataTX("Informacoes de Faturamento\r\n\r\n", 3, 1, 0, 0, 1);
        iComando = "" + BematechComandosDiretos.ESC + BematechComandosDiretos.a + (char) 0;
        iRetorno = cupom.ComandoTX(iComando, iComando.length());
        //iRetorno = cupom.BematechTX(BematechComandosDiretos.alinhamento(0));
        iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON);
        iRetorno = cupom.BematechTX("Total Faturado: " + BematechComandosDiretos.NEGRITO_OFF + String.format("R$ %.2f", caixa.getTotalCaixa()) + "\r\n");
        iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "\tDinheiro: " + BematechComandosDiretos.NEGRITO_OFF + String.format("R$ %.2f", totalDinheiro) + "\r\n");
        iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "\tCredito: " + BematechComandosDiretos.NEGRITO_OFF + String.format("R$ %.2f", totalCredito) + "\r\n");
        iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "\tDebito: " + BematechComandosDiretos.NEGRITO_OFF + String.format("R$ %.2f", totalDebito) + "\r\n");
        iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "\tVale: " + BematechComandosDiretos.NEGRITO_OFF + String.format("R$ %.2f", totalVale) + "\r\n");
        iRetorno = cupom.BematechTX("\r\n------------------------------------------------\r\n");
        iComando = "" + BematechComandosDiretos.ESC + BematechComandosDiretos.a + (char) 1;
        iRetorno = cupom.ComandoTX(iComando, iComando.length());
        //iRetorno = cupom.BematechTX(BematechComandosDiretos.alinhamento(1));
        iRetorno = cupom.FormataTX("Informacoes de Balanco do Caixa\r\n\r\n", 3, 1, 0, 0, 1);
        iComando = "" + BematechComandosDiretos.ESC + BematechComandosDiretos.a + (char) 0;
        iRetorno = cupom.ComandoTX(iComando, iComando.length());
        //iRetorno = cupom.BematechTX(BematechComandosDiretos.alinhamento(0));
        iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "Total Faturado: " + BematechComandosDiretos.NEGRITO_OFF + String.format("R$ %.2f", caixa.getTotalCaixa()) + "\r\n");
        iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "Total Retiradas: " + BematechComandosDiretos.NEGRITO_OFF + String.format("R$ %.2f", totalDesp) + "\r\n");
        iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "Total Caixa: " + BematechComandosDiretos.NEGRITO_OFF + String.format("R$ %.2f", caixa.getTotalCaixa()) + "\r\n");
        iRetorno = cupom.BematechTX("\r\n------------------------------------------------\r\n");
        iComando = "" + BematechComandosDiretos.ESC + BematechComandosDiretos.a + (char) 1;
        iRetorno = cupom.ComandoTX(iComando, iComando.length());
        //iRetorno = cupom.BematechTX(BematechComandosDiretos.alinhamento(1));
        iRetorno = cupom.FormataTX("Informacoes de Retiradas\r\n\r\n", 3, 1, 0, 0, 1);
        iComando = "" + BematechComandosDiretos.ESC + BematechComandosDiretos.a + (char) 0;
        iRetorno = cupom.ComandoTX(iComando, iComando.length());
        //iRetorno = cupom.BematechTX(BematechComandosDiretos.alinhamento(0));

        if (caixa.getDespesas() != null && !caixa.getDespesas().isEmpty()) {
            iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "Quantidade de Retiradas: " + BematechComandosDiretos.NEGRITO_OFF + caixa.getDespesas().size() + "\r\n\r\n");
            iRetorno = cupom.FormataTX("Lista de Retiradas\r\n\r\n", 3, 1, 0, 0, 0);
            for (int i = 0; caixa.getDespesas().size() > i; i++) {
                iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "Retirada " + (i + 1) + BematechComandosDiretos.NEGRITO_OFF + "\r\n");
                iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "Motivo: " + BematechComandosDiretos.NEGRITO_OFF + removeAcentos(caixa.getDespesas().get(i).getDescDesp()) + "\r\n");
                iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "Valor: " + BematechComandosDiretos.NEGRITO_OFF + String.format("R$ %.2f", caixa.getDespesas().get(i).getValorDesp()) + "\r\n\r\n");
            }
            iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "Total de Retiradas: " + BematechComandosDiretos.NEGRITO_OFF + String.format("R$ %.2f", totalDesp) + "\r\n");
        } else {
            iRetorno = cupom.BematechTX("Sem Retiradas\r\n");
        }
        iRetorno = cupom.BematechTX("\r\n------------------------------------------------\r\n");
        iComando = "" + BematechComandosDiretos.ESC + BematechComandosDiretos.a + (char) 1;
        iRetorno = cupom.ComandoTX(iComando, iComando.length());
        //iRetorno = cupom.BematechTX(BematechComandosDiretos.alinhamento(1));
        iRetorno = cupom.FormataTX("Informacoes de Descontos\r\n\r\n", 3, 1, 0, 0, 1);
        iComando = "" + BematechComandosDiretos.ESC + BematechComandosDiretos.a + (char) 0;
        iRetorno = cupom.ComandoTX(iComando, iComando.length());
        //iRetorno = cupom.BematechTX(BematechComandosDiretos.alinhamento(0));
        if (qtdPedDesc == 0) {
            iRetorno = cupom.BematechTX("Sem Descontos\r\n");
        } else {
            iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "Quantidade de Descontos: " + BematechComandosDiretos.NEGRITO_OFF + qtdPedDesc + "\r\n\r\n");
            iRetorno = cupom.FormataTX("Lista de Descontos\r\n\r\n", 3, 1, 0, 0, 0);
            for (int i = 0; caixa.getPedidos().size() > i; i++) {
                if (caixa.getPedidos().get(i).getDescPedido() > 0 && "Finalizado".equals(caixa.getPedidos().get(i).getEstadoPedido())) {
                    iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "Numero do Pedido: " + BematechComandosDiretos.NEGRITO_OFF + caixa.getPedidos().get(i).getNumPedido() + "\r\n");
                    iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "Valor do Pedido: " + BematechComandosDiretos.NEGRITO_OFF + String.format("R$ %.2f", caixa.getPedidos().get(i).getSubTotPedido()) + "\r\n");
                    iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "Valor do Desconto: " + BematechComandosDiretos.NEGRITO_OFF + String.format("R$ %.2f", caixa.getPedidos().get(i).getDescPedido()) + "\r\n\r\n");
                }
            }
            iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "Total de Descontos: " + BematechComandosDiretos.NEGRITO_OFF + String.format("R$ %.2f", descontoTotal) + "\r\n");
        }
        iRetorno = cupom.BematechTX("\r\n------------------------------------------------\r\n");
        iComando = "" + BematechComandosDiretos.ESC + BematechComandosDiretos.a + (char) 1;
        iRetorno = cupom.ComandoTX(iComando, iComando.length());
        //iRetorno = cupom.BematechTX(BematechComandosDiretos.alinhamento(1));
        iRetorno = cupom.FormataTX("Informacoes de Cancelamentos\r\n\r\n", 3, 1, 0, 0, 1);
        iComando = "" + BematechComandosDiretos.ESC + BematechComandosDiretos.a + (char) 0;
        iRetorno = cupom.ComandoTX(iComando, iComando.length());
        //iRetorno = cupom.BematechTX(BematechComandosDiretos.alinhamento(0));
        if (qtdPedCanc == 0) {
            iRetorno = cupom.BematechTX("Sem Cancelamentos\r\n");
        } else {
            iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "Quantidade de Cancelamentos: " + BematechComandosDiretos.NEGRITO_OFF + qtdPedCanc + "\r\n\r\n");
            iRetorno = cupom.FormataTX("Lista de Cancelamentos\r\n\r\n", 3, 1, 0, 0, 0);
            double totalCanc = 0;
            for (int i = 0; caixa.getPedidos().size() > i; i++) {
                if ("Cancelado".equals(caixa.getPedidos().get(i).getEstadoPedido())) {
                    totalCanc += caixa.getPedidos().get(i).getSubTotPedido();
                    iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "Numero do Pedido: " + BematechComandosDiretos.NEGRITO_OFF + caixa.getPedidos().get(i).getNumPedido() + "\r\n");
                    iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "Valor do Pedido: " + BematechComandosDiretos.NEGRITO_OFF + String.format("R$ %.2f", caixa.getPedidos().get(i).getSubTotPedido()) + "\r\n\r\n");
                }
            }
            iRetorno = cupom.BematechTX(BematechComandosDiretos.NEGRITO_ON + "Total de Cancelamentos: " + BematechComandosDiretos.NEGRITO_OFF + String.format("R$ %.2f", totalCanc) + "\r\n");
        }
        iRetorno = cupom.BematechTX("\r\n------------------------------------------------\r\n");
        iComando = "" + BematechComandosDiretos.ESC + BematechComandosDiretos.a + (char) 1;
        iRetorno = cupom.ComandoTX(iComando, iComando.length());
        //iRetorno = cupom.BematechTX(BematechComandosDiretos.alinhamento(1));
        iRetorno = cupom.FormataTX("\r\nLi e reconheco as informacoes acima citadas\r\n", 3, 1, 0, 0, 0);
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(caixa.getDataFechamentoCaixa());
        iRetorno = cupom.BematechTX("Curitiba, " + String.format("%02d", calendario.get(Calendar.DAY_OF_MONTH)) + " de " + mes + " de " + calendario.get(Calendar.YEAR) + "\r\n");
        iComando = "" + BematechComandosDiretos.ESC + BematechComandosDiretos.a + (char) 0;
        iRetorno = cupom.ComandoTX(iComando, iComando.length());
        //iRetorno = cupom.BematechTX(BematechComandosDiretos.alinhamento(0));
        iRetorno = cupom.BematechTX("\r\n________________________________________________\r\n");
        iRetorno = cupom.FormataTX(caixa.getFuncionario().getNomeFunc(), 3, 0, 0, 1, 0);
        iComando = "" + (char) 10;
        for (int i = 0; i < 10; i++) {
            iRetorno = cupom.ComandoTX(iComando, iComando.length());
        }
        iRetorno = cupom.FechaPorta();
    }
}
