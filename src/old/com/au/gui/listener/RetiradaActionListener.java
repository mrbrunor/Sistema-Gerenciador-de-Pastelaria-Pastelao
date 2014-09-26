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
package old.com.au.gui.listener;

import old.com.au.gui.TelaRetirada;
import com.au.modelo.Despesa;
import com.au.dao.DAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

/**
 *
 * @author BrunoRicardo
 */
public class RetiradaActionListener implements ActionListener, KeyListener {

    private final TelaRetirada frm;
    private Border vermelha = new MatteBorder(1, 1, 1, 1, Color.red);
    private Border normal;
    private int contaEnter = 0;

    public RetiradaActionListener(TelaRetirada frm) {
        this.frm = frm;
        normal = frm.getCampoValor().getBorder();
        adicionaListener();
    }

    public void adicionaListener() {
        frm.getBotaoCancelarRetirada().addActionListener(this);
        frm.getBotaoRegistrarRetirada().addActionListener(this);
        frm.getCampoMotivo().addKeyListener(this);
        frm.getCampoValor().addActionListener(this);
    }

    public void registrarRetirada() {
        Despesa despesa = new Despesa();

        despesa.setDataDesp(new Date());
        despesa.setDescDesp(frm.getCampoMotivo().getText());
        despesa.setValorDesp(Double.valueOf(frm.getCampoValor().getText()));
        despesa.setRetirada((byte) 1);
        despesa.setCaixa(frm.getCaixa());

        new DAO<>(Despesa.class).adiciona(despesa);

        JOptionPane.showMessageDialog(frm, "Retirada de caixa efetuada com sucesso!", "Retirada de Caixa", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean valida() {
        boolean valida = true;

        if (!"".equals(frm.getCampoValor().getText())) {
            frm.getCampoValor().setBorder(normal);
        } else {
            frm.getCampoValor().setBorder(vermelha);
            valida = false;
        }

        if (!"".equals(frm.getCampoMotivo().getText()) && frm.getCampoMotivo().getText().length() > 3) {
            frm.getCampoMotivo().setBorder(normal);
        } else {
            frm.getCampoMotivo().setBorder(vermelha);
            valida = false;
        }

        return valida;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Registrar Retirada":
                if (valida()) {
                    registrarRetirada();
                    System.out.println("\"" + frm.getCampoMotivo().getText() + "\"");
                    frm.dispose();
                }
                break;
            case "Cancelar Retirada":
                frm.dispose();
                break;
            case "Valor":
                frm.getCampoMotivo().requestFocus();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            frm.getBotaoRegistrarRetirada().requestFocus();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
