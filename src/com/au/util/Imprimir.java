/*
 * Copyright (C) 2017 mrbru
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
import com.au.dao.DespesaDao;
import com.au.dao.FuncionarioDao;
import com.au.dao.PedidoDao;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author mrbru
 */
public class Imprimir {
    
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
    private Properties props;
    private final String nomeProp;
    private String impCaixaName;
    private String impCozinhaName;
    
    public static PrinterJob pjCaixa = PrinterJob.getPrinterJob();
    public static PrinterJob pjCozinha = PrinterJob.getPrinterJob();    

    public Imprimir(int idPedido, boolean eReimpressaoCaixa, boolean eReimpressaoCozinha, JDialog parent) {
        
        CupomCaixa cupomCaixa = new CupomCaixa(idPedido);
        CupomCozinha cupomCozinha= new CupomCozinha(idPedido);
        
        PrintService[] services = PrinterJob.lookupPrintServices();
        
        try {
            props = ManipulaConfigs.getProp();
        } catch (IOException e) {
            System.out.println("Houve um erro ao carregar as configurações. Possíveis causas incluem arquivo de configuração danificado e/ou ausente.\n");
            e.printStackTrace();
        }
        nomeProp = "prop.impressora."; //Facilitar a procura no arquivo de propriedades;
        boolean impAtiva = false;
        
        impCaixaName = props.getProperty(nomeProp + "caixa.nome");
        impCozinhaName = props.getProperty(nomeProp + "cozinha.nome");
        
        for (PrintService service : services) {
            if (impCaixaName.equals(service.getName())) {
                try {
                    pjCaixa.setPrintService(service);
                } catch (PrinterException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            } 
            if (impCozinhaName.equals(service.getName())) {
                try {
                    pjCozinha.setPrintService(service);
                } catch (PrinterException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
        }
        System.out.println("Imprimir em Caixa?: " + eReimpressaoCaixa);
        if (eReimpressaoCaixa) {
            System.out.println("\n*********************************************\n"
                    + "Iniciando Impressora Caixa\n"
                    + "*********************************************");
            impAtiva = Boolean.parseBoolean(props.getProperty(nomeProp + "caixa.ativa"));
            System.out.println("Usar a impressora do caixa: " + impAtiva);
            if (impAtiva) {
                try {               
                    pjCaixa.setPrintable(cupomCaixa, getPageFormat(pjCaixa)); 
                    pjCaixa.print();
                } catch (UnsatisfiedLinkError | NoClassDefFoundError e) {
                    JOptionPane.showMessageDialog(parent, "Erro ao imprimir o Cupom.\nVerifique a impressora do Caixa e tente novamente.", "Erro ao Imprimir o Cupom", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Houve erro ao imprimir o cupom do caixa: " +e);
                } catch (PrinterException ex) {
                    Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.out.println("Imprimir em Cozinha?: " + eReimpressaoCozinha);
        if (eReimpressaoCozinha) {
            System.out.println("\n*********************************************\n"
                    + "Iniciando Impressora Cozinha\n"
                    + "*********************************************");
            impAtiva = Boolean.parseBoolean(props.getProperty(nomeProp + "cozinha.ativa"));
            System.out.println("Usar a impressora da cozinha: " + impAtiva);
            if (impAtiva) {
                try {
                    pjCozinha.setPrintable(cupomCozinha, getPageFormat(pjCozinha));
                    pjCozinha.print();
                } catch (UnsatisfiedLinkError | NoClassDefFoundError e) {
                    JOptionPane.showMessageDialog(parent, "Erro ao imprimir o Cupom.\nVerifique a impressora da Cozinha e tente novamente.", "Erro ao Imprimir o Cupom", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Houve erro ao imprimir o cupom da cozinha: " +e);
                } catch (PrinterException ex) {
                    Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public PageFormat getPageFormat(PrinterJob pj) {

        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();

        double middleHeight = 150;
        double headerHeight = 2.0;
        double footerHeight = 2.0;
        double width = convert_CM_To_PPI(8);
        double height = convert_CM_To_PPI(headerHeight + middleHeight + footerHeight);
        paper.setSize(width, height);
        paper.setImageableArea(
                0,
                10,
                width,
                height - convert_CM_To_PPI(1)
        );

        pf.setOrientation(PageFormat.PORTRAIT);
        pf.setPaper(paper);

        return pf;
    }

    protected static double convert_CM_To_PPI(double cm) {
        return toPPI(cm * 0.393600787);
    }

    protected static double toPPI(double inch) {
        return inch * 72d;
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
    
    private static List<String> getParts(String string, int partitionSize) {
        List<String> parts = new ArrayList<>();
        int len = string.length();
        for (int i=0; i<len; i+=partitionSize)
        {
            parts.add(string.substring(i, Math.min(len, i + partitionSize)));
        }
        return parts;
    }

    private class CupomCaixa implements Printable {
        
        private final int idPedido;

        public CupomCaixa(int idPedido) {
            this.idPedido = idPedido;
        }

        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            System.out.println("--- Iniciando a Geração da Comanda de Venda ---");
            int result = NO_SUCH_PAGE;
            if (pageIndex == 0) {
                Graphics2D g2d = (Graphics2D) graphics;
                g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());
                
                pDao.abreConnection();
                Pedido pedido = pDao.buscaPedidoPorId(idPedido);
                pedido = pDao.listaItemPedido(pedido);
                pDao.fechaConnection();
                System.out.println("Recuperou a lista de itens do pedido");

                SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                String dataStr = formatador.format(pedido.getDataPedido());

                try {
                    int y = 20;
                    int yShift = 10;
                    int headerRectHeight = 15;

                    g2d.setFont(new Font("Arial", Font.BOLD, 12));
                    g2d.drawString("--------------------------------------------", 6, y); y += yShift;
                    g2d.drawString("                   Pastelão        ", 12, y); y += yShift;
                    g2d.drawString("--------------------------------------------", 6, y); y += headerRectHeight;

                    g2d.setFont(new Font("Arial", Font.PLAIN, 10));
                    g2d.drawString(dataStr + "                            " + pedido.getHoraPedido(), 6, y); y += yShift + 4;
                    g2d.drawString("AGUARDE PELO NÚMERO:", 6, y);
                    g2d.setFont(new Font("Arial", Font.BOLD, 14));
                    g2d.drawString("                                    " + String.format("%03d", pedido.getNumPedido()), 10, y); y += yShift + 2;
                    g2d.setFont(new Font("Arial", Font.PLAIN, 10));
                    g2d.drawString("FORMA DE CONSUMO:", 6, y);
                    g2d.setFont(new Font("Arial", Font.BOLD, 14));
                    g2d.drawString("                               " + pedido.getFormaConsumo(), 10, y); y += yShift + 2;

                    y += 10;

                    g2d.setFont(new Font("Arial", Font.PLAIN, 10));
                    g2d.drawString("Código    QTD         Unit        Total", 6, y); y += yShift;
                    g2d.drawString("Descrição", 6, y); y += yShift + 10;
                    
                    for (int i = 0; pedido.getItempedidos().size() > i; i++) {
                        
                        if (pedido.getItempedidos().get(i).getProduto().getNumProd() == 0) {
                            pedido.getItempedidos().get(i).getProduto().setDescProd(pedido.getItempedidos().get(i).getNomePastel());
                            pedido.getItempedidos().get(i).getProduto().setValorProd(pedido.getItempedidos().get(i).getTotProd() / pedido.getItempedidos().get(i).getQtdProd());;
                        }                                                
                        g2d.setFont(new Font("Arial", Font.BOLD, 14));                        
                        System.out.println(pedido.getItempedidos().get(i).getProduto().getDescProd() + " Test");                       
                        g2d.drawString(String.format("%04d", pedido.getItempedidos().get(i).getProduto().getNumProd()) + " x "+ String.format("%02d", pedido.getItempedidos().get(i).getQtdProd()), 6, y);                                       
                        g2d.setFont(new Font("Arial", Font.PLAIN, 10));
                        if(pedido.getItempedidos().get(i).getProduto().getValorProd() > 9.9) {
                            g2d.drawString("                               " + String.format("%.2f", pedido.getItempedidos().get(i).getProduto().getValorProd()) + "       " + String.format("%.2f", pedido.getItempedidos().get(i).getTotProd()), 10, y); y += yShift;
                        } else {
                            g2d.drawString("                               0" + String.format("%.2f", pedido.getItempedidos().get(i).getProduto().getValorProd()) + "       " + String.format("%.2f", pedido.getItempedidos().get(i).getTotProd()), 10, y); y += yShift;
                        }                        
                        if(pedido.getItempedidos().get(i).getProduto().getDescProd().length() > 30) {
                            for (String part : getParts(pedido.getItempedidos().get(i).getProduto().getDescProd(), 30)) {
                                g2d.drawString(part, 6, y); y += yShift + 10;                        
                            }
                        } else {
                            g2d.drawString(pedido.getItempedidos().get(i).getProduto().getDescProd(), 6, y); y += yShift + 10;                        
                        }
                    }
                    
                    y += 9;

                    g2d.setFont(new Font("Arial", Font.BOLD, 9));
                    g2d.drawString("         SUBTOTAL......" + String.format("%.2f", pedido.getSubTotPedido()), 10, y); y += yShift;
                    g2d.drawString("         DESCONTO......" + String.format("%.2f", pedido.getDescPedido()), 10, y); y += yShift;
                    g2d.drawString("         TOTAL..............." + String.format("%.2f", pedido.getTotPedido()), 10, y); y += yShift;

                    y += 9;

                    g2d.drawString("         Forma de Pagamento: " + pedido.getFormaPagamento().getTipoFormaPgto(), 12, y); y += yShift;
                    g2d.drawString("              Valor Recebido ---> " + String.format("%.2f", pedido.getValorRecebido()), 10, y); y += yShift;
                    g2d.drawString("              Troco                 ---> " + String.format("%.2f", (pedido.getValorRecebido() - pedido.getTotPedido())), 10, y); y += yShift;

                    y += 9;

                    g2d.setFont(new Font("Arial", Font.PLAIN, 9));
                    g2d.drawString("ESTE CUPOM NÃO TEM VALIDADE FISCAL", 12, y); y += yShift;
                    g2d.setFont(new Font("Arial", Font.BOLD, 9));
                    g2d.drawString("            ABERTO AOS DOMINGOS", 12, y); y += yShift;
                    g2d.setFont(new Font("Arial", Font.PLAIN, 9));                    
                    g2d.drawString("              Obrigado pela Preferência", 12, y); y += yShift;
                    g2d.drawString("                      Volte Sempre!", 12, y); y += yShift+50;
                    g2d.drawString(".", 12, y); y += yShift+10;
                } catch (Exception pf) {
                    System.out.println("Erro:" + pf.getMessage());
                }

                result = PAGE_EXISTS;
            }
            return result;
        }
    }

    private class CupomCozinha implements Printable {
        
        private int idPedido;

        public CupomCozinha(int idPedido) {
            this.idPedido = idPedido;
        }

        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            System.out.println("--- Iniciando a Geração da Comanda da Cozinha ---");
            int result = NO_SUCH_PAGE;
            if (pageIndex == 0) {
                Graphics2D g2d = (Graphics2D) graphics;
                g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());
                
                pDao.abreConnection();
                Pedido pedido = pDao.buscaPedidoPorId(idPedido);
                pedido = pDao.listaItemPedido(pedido);
                pDao.fechaConnection();
                System.out.println("Recuperou a lista de itens do pedido");
                
                boolean imprimir = false;

                for (int i = 0; i < pedido.getItempedidos().size(); i++) {
                    if (pedido.getItempedidos().get(i).getProduto().getEIndustrializado() == 0) {
                        imprimir = true;
                        break;
                    }
                }
                
                if (imprimir) {

                    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                    String dataStr = formatador.format(pedido.getDataPedido());

                    try {
                        int y = 20;
                        int yShift = 10;
                        int headerRectHeight = 15;

                        g2d.setFont(new Font("Arial", Font.BOLD, 12));
                        g2d.drawString("--------------------------------------------", 6, y); y += yShift;
                        g2d.drawString("       VIA DA COZINHA      ", 12, y); y += yShift;
                        g2d.drawString("--------------------------------------------", 6, y); y += headerRectHeight;

                        g2d.setFont(new Font("Arial", Font.PLAIN, 10));
                        g2d.drawString(dataStr + "                            " + pedido.getHoraPedido(), 6, y); y += yShift + 4;
                        g2d.drawString("AGUARDE PELO NÚMERO:", 6, y);
                        g2d.setFont(new Font("Arial", Font.BOLD, 14));
                        g2d.drawString("                                    " + String.format("%03d", pedido.getNumPedido()), 10, y); y += yShift + 2;
                        g2d.setFont(new Font("Arial", Font.PLAIN, 10));
                        g2d.drawString("FORMA DE CONSUMO:", 6, y);
                        g2d.setFont(new Font("Arial", Font.BOLD, 14));
                        g2d.drawString("                               " + pedido.getFormaConsumo(), 10, y); y += yShift + 2;

                        y += 10;

                        g2d.setFont(new Font("Arial", Font.PLAIN, 10));
                        g2d.drawString("Código    QTD", 12, y); y += yShift;
                        g2d.drawString("Descrição", 12, y); y += yShift + 4;


                        for (int i = 0; pedido.getItempedidos().size() > i; i++) {
                            if (pedido.getItempedidos().get(i).getProduto().getNumProd() == 0) {
                                pedido.getItempedidos().get(i).getProduto().setDescProd(pedido.getItempedidos().get(i).getNomePastel());
                                pedido.getItempedidos().get(i).getProduto().setValorProd(pedido.getItempedidos().get(i).getTotProd() / pedido.getItempedidos().get(i).getQtdProd());;
                            }                                                
                            g2d.setFont(new Font("Arial", Font.BOLD, 14));                        
                            System.out.println(pedido.getItempedidos().get(i).getProduto().getDescProd() + " Test");
                            g2d.drawString(String.format("%04d", pedido.getItempedidos().get(i).getProduto().getNumProd()) + "  x "+ String.format("%02d", pedido.getItempedidos().get(i).getQtdProd()), 12, y); y += yShift;
                            g2d.setFont(new Font("Arial", Font.PLAIN, 10));                            
                            if(pedido.getItempedidos().get(i).getProduto().getDescProd().length() > 30) {
                                for (String part : getParts(pedido.getItempedidos().get(i).getProduto().getDescProd(), 30)) {
                                    g2d.drawString(part, 12, y); y += yShift + 10;
                                }
                            } else {
                                g2d.drawString(pedido.getItempedidos().get(i).getProduto().getDescProd(), 12, y); y += yShift + 10;                        
                            }
                        }
                        y += yShift+50;
                        g2d.drawString(".", 12, y); y += yShift+10;
                        
                    } catch (Exception pf) {
                        System.out.println("Erro:" + pf.getMessage());
                    }
                } 
                result = PAGE_EXISTS;
            }
            return result;
        }
    }
}
