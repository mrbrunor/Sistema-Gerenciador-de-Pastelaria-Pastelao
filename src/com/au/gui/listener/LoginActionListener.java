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

import com.au.dao.DAO;
import com.au.gui.TelaCriarNovaSenha;
import com.au.gui.TelaLogin;
import com.au.gui.TelaVenda;
import com.au.modelo.Funcionario;
import com.au.util.HexSha;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.html.CSS;

/**
 *
 * @author BrunoRicardo
 */
public class LoginActionListener implements ActionListener, KeyListener {

    private final TelaLogin frm;

    public void limpaCampos() {
        frm.limpaCampos();
    }

    public LoginActionListener(TelaLogin frm) {
        this.frm = frm;
        adicionaListener();
        setaFonteAvisos();
    }

    public void adicionaListener() {
        frm.getBotaoEntrarNoSistema().addActionListener(this);
        frm.getBotaoEsqueciSenha().addActionListener(this);
        frm.getCampoSenha().addActionListener(this);
        frm.getCampoUsuario().addKeyListener(this);
    }

    private void setaFonteAvisos() {
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, 15)));
        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, 16)));
        //UIManager.put("Button.font", /* font of your liking */);
        //UIManager.put("ToggleButton.font", /* font of your liking */);
        //UIManager.put("RadioButton.font", /* font of your liking */);
        //UIManager.put("CheckBox.font", /* font of your liking */);
        //UIManager.put("ColorChooser.font", /* font of your liking */);
        UIManager.put("ComboBox.font", new FontUIResource(new Font("Tahoma", Font.PLAIN, 15)));
        //UIManager.put("Label.font", /* font of your liking */);
        //UIManager.put("List.font", /* font of your liking */);
        UIManager.put("MenuBar.font", new FontUIResource(new Font("Tahoma", Font.PLAIN, 18)));
        UIManager.put("MenuItem.font", new FontUIResource(new Font("Tahoma", Font.PLAIN, 16)));
        //UIManager.put("RadioButtonMenuItem.font", /* font of your liking */);
        //UIManager.put("CheckBoxMenuItem.font", /* font of your liking */);
        //UIManager.put("Menu.font", /* font of your liking */);
        //UIManager.put("PopupMenu.font", /* font of your liking */);
        //UIManager.put("OptionPane.font", /* font of your liking */);
        //UIManager.put("Panel.font", /* font of your liking */);
        //UIManager.put("ProgressBar.font", /* font of your liking */);
        //UIManager.put("ScrollPane.font", /* font of your liking */);
        //UIManager.put("Viewport.font", /* font of your liking */);
        //UIManager.put("TabbedPane.font", /* font of your liking */);
        UIManager.put("Table.font", new FontUIResource(new Font("Tahoma", Font.PLAIN, 15)));
        UIManager.put("TableHeader.font", new FontUIResource(new Font("Tahoma", Font.BOLD, 15)));
        //UIManager.put("TextField.font", /* font of your liking */);
        //UIManager.put("PasswordField.font", /* font of your liking */);
        //UIManager.put("TextArea.font", /* font of your liking */);
        //UIManager.put("TextPane.font", /* font of your liking */);
        //UIManager.put("EditorPane.font", /* font of your liking */);
        UIManager.put("TitledBorder.font", new FontUIResource(new Font("Tahoma", Font.BOLD, 15)));
        //UIManager.put("ToolBar.font", /* font of your liking */);
        //UIManager.put("ToolTip.font", /* font of your liking */); 
    }

    private void logar() throws ExceptionInInitializerError {
        Funcionario funcionario = new Funcionario();
        Funcionario login = new Funcionario();

        login.setUserFunc(frm.getCampoUsuario().getText());
        HexSha hexSha = new HexSha(String.valueOf(frm.getCampoSenha().getPassword()));
        login.setPassFunc(hexSha.ConvertSha());

        funcionario = new DAO<>(Funcionario.class).buscarLogin(login.getUserFunc(), login.getPassFunc());

        if (funcionario == null) {
            JOptionPane.showMessageDialog(frm, "Senha ou Usuario Invalidos", "Efetuar Login", JOptionPane.WARNING_MESSAGE);
        } else if (funcionario.getUserFunc().equals(login.getUserFunc()) && funcionario.getPassFunc().equals(login.getPassFunc())) {
            new TelaVenda(funcionario).setVisible(true);
            frm.dispose();
        }
    }

    private void trocarSenha() {
        new TelaCriarNovaSenha(frm, true).setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Entrar no Sistema":
                try {
                    logar();
                } catch (ExceptionInInitializerError ex) {
                    Logger.getLogger(LoginActionListener.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(frm, "Erro ao tentar conectar com o banco de dados. \n Verifique se o Banco de Dados está funcionado e tente novamente.", "Efetuar Login", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case "Esqueci a minha senha":
                trocarSenha();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            frm.getCampoSenha().requestFocus();
        }
    }
}
