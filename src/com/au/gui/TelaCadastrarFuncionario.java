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

package com.au.gui;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author BrunoRicardo
 */
public class TelaCadastrarFuncionario extends javax.swing.JFrame {
    private FuncionarioActionListener listener;

    /**
     * Creates new form TelaCadastrarFuncionario
     */
    public TelaCadastrarFuncionario() {
        initComponents();
        listener = new FuncionarioActionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelInferior = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPesquisa = new javax.swing.JTable();
        painelSuperior = new javax.swing.JPanel();
        textoIconeNovoFuncionario = new javax.swing.JLabel();
        textoAdicionarNovoFuncionario = new javax.swing.JLabel();
        textoPreencherDados = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        botaoIncluir = new javax.swing.JButton();
        botaoAlterar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        painelEsquerdo = new javax.swing.JPanel();
        textoNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        textoDtNasc = new javax.swing.JLabel();
        textoSexo = new javax.swing.JLabel();
        textoRg = new javax.swing.JLabel();
        campoRg = new javax.swing.JTextField();
        campoCpf = new javax.swing.JTextField();
        textoCpf = new javax.swing.JLabel();
        textoEmail = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        campoTelefone = new javax.swing.JTextField();
        textoTelefone = new javax.swing.JLabel();
        textoCelular = new javax.swing.JLabel();
        campoCelular = new javax.swing.JTextField();
        campoDtNasc = new com.toedter.calendar.JDateChooser();
        caixaSexo = new javax.swing.JComboBox();
        textoId = new javax.swing.JLabel();
        painelDireito = new javax.swing.JPanel();
        textoDtAdm = new javax.swing.JLabel();
        textoSalario = new javax.swing.JLabel();
        textoUser = new javax.swing.JLabel();
        textoSenha = new javax.swing.JLabel();
        textoSenha2 = new javax.swing.JLabel();
        textoNivel = new javax.swing.JLabel();
        textoAtivo = new javax.swing.JLabel();
        campoDtAdm = new com.toedter.calendar.JDateChooser();
        campoSalario = new javax.swing.JTextField();
        campoUser = new javax.swing.JTextField();
        campoSenha = new javax.swing.JTextField();
        campoSenha2 = new javax.swing.JTextField();
        caixaNivel = new javax.swing.JComboBox();
        caixaAtivo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaPesquisa);

        javax.swing.GroupLayout painelInferiorLayout = new javax.swing.GroupLayout(painelInferior);
        painelInferior.setLayout(painelInferiorLayout);
        painelInferiorLayout.setHorizontalGroup(
            painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        painelInferiorLayout.setVerticalGroup(
            painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelInferiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textoIconeNovoFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/add_user-64.png"))); // NOI18N

        textoAdicionarNovoFuncionario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        textoAdicionarNovoFuncionario.setText("Adicionar Novo Funcionário");

        textoPreencherDados.setText("Preencha os dados abaixo para adicionar um novo funcionário.");

        jToolBar1.setRollover(true);

        botaoIncluir.setText("Incluir");
        botaoIncluir.setFocusable(false);
        botaoIncluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoIncluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(botaoIncluir);

        botaoAlterar.setText("Alterar");
        botaoAlterar.setFocusable(false);
        botaoAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(botaoAlterar);

        botaoExcluir.setText("Excluir");
        botaoExcluir.setFocusable(false);
        botaoExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(botaoExcluir);
        jToolBar1.add(jSeparator1);

        botaoSalvar.setText("Salvar");
        botaoSalvar.setEnabled(false);
        botaoSalvar.setFocusable(false);
        botaoSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(botaoSalvar);

        botaoCancelar.setText("Cancelar");
        botaoCancelar.setEnabled(false);
        botaoCancelar.setFocusable(false);
        botaoCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(botaoCancelar);

        javax.swing.GroupLayout painelSuperiorLayout = new javax.swing.GroupLayout(painelSuperior);
        painelSuperior.setLayout(painelSuperiorLayout);
        painelSuperiorLayout.setHorizontalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoIconeNovoFuncionario)
                .addGap(18, 18, 18)
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoAdicionarNovoFuncionario)
                    .addComponent(textoPreencherDados))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painelSuperiorLayout.setVerticalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelSuperiorLayout.createSequentialGroup()
                        .addComponent(textoAdicionarNovoFuncionario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoPreencherDados))
                    .addComponent(textoIconeNovoFuncionario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelEsquerdo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados Pessoais"));

        textoNome.setText("Nome Completo:");

        textoDtNasc.setText("Data de Nascimento:");

        textoSexo.setText("Sexo:");

        textoRg.setText("RG:");

        textoCpf.setText("CPF:");

        textoEmail.setText("E-mail:");

        textoTelefone.setText("Telefone:");

        textoCelular.setText("Celular:");

        campoDtNasc.setDateFormatString("yyyy-MM-dd");

        caixaSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Feminino", "Masculino" }));

        javax.swing.GroupLayout painelEsquerdoLayout = new javax.swing.GroupLayout(painelEsquerdo);
        painelEsquerdo.setLayout(painelEsquerdoLayout);
        painelEsquerdoLayout.setHorizontalGroup(
            painelEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelEsquerdoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textoId, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelEsquerdoLayout.createSequentialGroup()
                        .addGroup(painelEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoDtNasc)
                            .addComponent(textoSexo)
                            .addComponent(textoRg)
                            .addComponent(textoCpf)
                            .addComponent(textoEmail)
                            .addComponent(textoTelefone)
                            .addComponent(textoCelular)
                            .addComponent(textoNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoNome)
                            .addComponent(caixaSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoCpf)
                            .addComponent(campoRg)
                            .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoCelular)
                            .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        painelEsquerdoLayout.setVerticalGroup(
            painelEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelEsquerdoLayout.createSequentialGroup()
                .addComponent(textoId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoNome)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoDtNasc)
                    .addComponent(campoDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoSexo)
                    .addComponent(caixaSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoRg)
                    .addComponent(campoRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoCpf)
                    .addComponent(campoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoEmail)
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoTelefone)
                    .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEsquerdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoCelular)
                    .addComponent(campoCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        painelDireito.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados \"Funcionais\""));

        textoDtAdm.setText("Data de Admissão:");

        textoSalario.setText("Salário:");

        textoUser.setText("Nome de Usuário:");

        textoSenha.setText("Senha:");

        textoSenha2.setText("Redigite a Senha:");

        textoNivel.setText("Nivel:");

        textoAtivo.setText("Ativo");

        campoDtAdm.setDateFormatString("yyyy-MM-dd");

        caixaNivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Administrador", "Funcionário" }));

        caixaAtivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Não", "Sim", " " }));

        javax.swing.GroupLayout painelDireitoLayout = new javax.swing.GroupLayout(painelDireito);
        painelDireito.setLayout(painelDireitoLayout);
        painelDireitoLayout.setHorizontalGroup(
            painelDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDireitoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelDireitoLayout.createSequentialGroup()
                        .addComponent(textoUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoUser))
                    .addGroup(painelDireitoLayout.createSequentialGroup()
                        .addGroup(painelDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoDtAdm)
                            .addComponent(textoSalario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoDtAdm, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(campoSalario)))
                    .addGroup(painelDireitoLayout.createSequentialGroup()
                        .addGroup(painelDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoSenha2)
                            .addComponent(textoNivel)
                            .addComponent(textoAtivo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(caixaAtivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(caixaNivel, 0, 121, Short.MAX_VALUE)
                            .addComponent(campoSenha2)))
                    .addGroup(painelDireitoLayout.createSequentialGroup()
                        .addComponent(textoSenha)
                        .addGap(61, 61, 61)
                        .addComponent(campoSenha)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelDireitoLayout.setVerticalGroup(
            painelDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDireitoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textoDtAdm)
                    .addComponent(campoDtAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoSalario)
                    .addComponent(campoSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoUser)
                    .addComponent(campoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoSenha)
                    .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoSenha2)
                    .addComponent(campoSenha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoNivel)
                    .addComponent(caixaNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoAtivo)
                    .addComponent(caixaAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(painelSuperior, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(painelEsquerdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelDireito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(painelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelEsquerdo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelDireito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBotaoAlterar() {
        return botaoAlterar;
    }

    public void setBotaoAlterar(JButton botaoAlterar) {
        this.botaoAlterar = botaoAlterar;
    }

    public JButton getBotaoCancelar() {
        return botaoCancelar;
    }

    public void setBotaoCancelar(JButton botaoCancelar) {
        this.botaoCancelar = botaoCancelar;
    }

    public JButton getBotaoExcluir() {
        return botaoExcluir;
    }

    public void setBotaoExcluir(JButton botaoExcluir) {
        this.botaoExcluir = botaoExcluir;
    }

    public JButton getBotaoIncluir() {
        return botaoIncluir;
    }

    public void setBotaoIncluir(JButton botaoIncluir) {
        this.botaoIncluir = botaoIncluir;
    }

    public JButton getBotaoSalvar() {
        return botaoSalvar;
    }

    public void setBotaoSalvar(JButton botaoSalvar) {
        this.botaoSalvar = botaoSalvar;
    }

    public JComboBox getCaixaAtivo() {
        return caixaAtivo;
    }

    public void setCaixaAtivo(JComboBox caixaAtivo) {
        this.caixaAtivo = caixaAtivo;
    }

    public JComboBox getCaixaNivel() {
        return caixaNivel;
    }

    public void setCaixaNivel(JComboBox caixaNivel) {
        this.caixaNivel = caixaNivel;
    }

    public JComboBox getCaixaSexo() {
        return caixaSexo;
    }

    public void setCaixaSexo(JComboBox caixaSexo) {
        this.caixaSexo = caixaSexo;
    }

    public JTextField getCampoCelular() {
        return campoCelular;
    }

    public void setCampoCelular(JTextField campoCelular) {
        this.campoCelular = campoCelular;
    }

    public JTextField getCampoCpf() {
        return campoCpf;
    }

    public void setCampoCpf(JTextField campoCpf) {
        this.campoCpf = campoCpf;
    }

    public JDateChooser getCampoDtAdm() {
        return campoDtAdm;
    }

    public void setCampoDtAdm(JDateChooser campoDtAdm) {
        this.campoDtAdm = campoDtAdm;
    }

    public JDateChooser getCampoDtNasc() {
        return campoDtNasc;
    }

    public void setCampoDtNasc(JDateChooser campoDtNasc) {
        this.campoDtNasc = campoDtNasc;
    }

    public JTextField getCampoEmail() {
        return campoEmail;
    }

    public void setCampoEmail(JTextField campoEmail) {
        this.campoEmail = campoEmail;
    }

    public JTextField getCampoNome() {
        return campoNome;
    }

    public void setCampoNome(JTextField campoNome) {
        this.campoNome = campoNome;
    }

    public JTextField getCampoRg() {
        return campoRg;
    }

    public void setCampoRg(JTextField campoRg) {
        this.campoRg = campoRg;
    }

    public JTextField getCampoSalario() {
        return campoSalario;
    }

    public void setCampoSalario(JTextField campoSalario) {
        this.campoSalario = campoSalario;
    }

    public JTextField getCampoSenha() {
        return campoSenha;
    }

    public void setCampoSenha(JTextField campoSenha) {
        this.campoSenha = campoSenha;
    }

    public JTextField getCampoSenha2() {
        return campoSenha2;
    }

    public void setCampoSenha2(JTextField campoSenha2) {
        this.campoSenha2 = campoSenha2;
    }

    public JTextField getCampoTelefone() {
        return campoTelefone;
    }

    public void setCampoTelefone(JTextField campoTelefone) {
        this.campoTelefone = campoTelefone;
    }

    public JTextField getCampoUser() {
        return campoUser;
    }

    public void setCampoUser(JTextField campoUser) {
        this.campoUser = campoUser;
    }

    public JLabel getTextoId() {
        return textoId;
    }

    public void setTextoId(JLabel textoId) {
        this.textoId = textoId;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastrarFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoIncluir;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JComboBox caixaAtivo;
    private javax.swing.JComboBox caixaNivel;
    private javax.swing.JComboBox caixaSexo;
    private javax.swing.JTextField campoCelular;
    private javax.swing.JTextField campoCpf;
    private com.toedter.calendar.JDateChooser campoDtAdm;
    private com.toedter.calendar.JDateChooser campoDtNasc;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoRg;
    private javax.swing.JTextField campoSalario;
    private javax.swing.JTextField campoSenha;
    private javax.swing.JTextField campoSenha2;
    private javax.swing.JTextField campoTelefone;
    private javax.swing.JTextField campoUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel painelDireito;
    private javax.swing.JPanel painelEsquerdo;
    private javax.swing.JPanel painelInferior;
    private javax.swing.JPanel painelSuperior;
    private javax.swing.JTable tabelaPesquisa;
    private javax.swing.JLabel textoAdicionarNovoFuncionario;
    private javax.swing.JLabel textoAtivo;
    private javax.swing.JLabel textoCelular;
    private javax.swing.JLabel textoCpf;
    private javax.swing.JLabel textoDtAdm;
    private javax.swing.JLabel textoDtNasc;
    private javax.swing.JLabel textoEmail;
    private javax.swing.JLabel textoIconeNovoFuncionario;
    private javax.swing.JLabel textoId;
    private javax.swing.JLabel textoNivel;
    private javax.swing.JLabel textoNome;
    private javax.swing.JLabel textoPreencherDados;
    private javax.swing.JLabel textoRg;
    private javax.swing.JLabel textoSalario;
    private javax.swing.JLabel textoSenha;
    private javax.swing.JLabel textoSenha2;
    private javax.swing.JLabel textoSexo;
    private javax.swing.JLabel textoTelefone;
    private javax.swing.JLabel textoUser;
    // End of variables declaration//GEN-END:variables
}
