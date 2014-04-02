/*
 * The MIT License
 *
 * Copyright 2014 tiago_000.
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

import com.au.bean.CustomComboBox;
import com.au.dao.FornecedorDao;
import com.au.pojo.Fornecedor;
import com.au.pojo.Produto;
import com.au.util.HibernateUtil;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import org.hibernate.Session;

/**
 *
 * @author tiago_000
 */
public class TelaCadastraProduto extends javax.swing.JFrame {

    List<Fornecedor> listaResForn = new ArrayList<>();
    FornecedorDao fornDao = new FornecedorDao();
    int validaForm[] = new int[]{0, 0, 0, 0, 0, 0, 0};
    Border border2 = BorderFactory.createLineBorder(Color.gray, 1);
    CustomComboBox[] fornComboBox = null;

    /**
     * Creates new form TelaCadastrarUsuario
     */
    public TelaCadastraProduto() {
        initComponents();
        campoId.setDocument(new LimitaDigitos((250), "[^0-9]"));
        campoNome.setDocument(new LimitaDigitos((250), "[^a-z|^A-Z|^0-9|^ |^~]"));
        campoValor.setDocument(new LimitaDigitos((7), "[^0-9|^.]"));
        campoQtd.setDocument(new LimitaDigitos((15), "[^0-9]"));
        campoBarras.setDocument(new LimitaDigitos((150), "[^0-9]"));
        campoQtd.setVisible(false);
        campoBarras.setVisible(false);
        textoQtd.setVisible(false);
        textoBarras.setVisible(false);
        campoId.requestFocus();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        painelSuperior = new javax.swing.JPanel();
        textoAdicionarProduto = new javax.swing.JLabel();
        textoIconeNovoUsuario = new javax.swing.JLabel();
        textoPreencherDados = new javax.swing.JLabel();
        painelDadosProduto = new javax.swing.JPanel();
        textoId = new javax.swing.JLabel();
        textoQtd = new javax.swing.JLabel();
        textoFornecedor = new javax.swing.JLabel();
        textoBarras = new javax.swing.JLabel();
        campoId = new javax.swing.JTextField();
        campoQtd = new javax.swing.JTextField();
        campoBarras = new javax.swing.JTextField();
        textoNome = new javax.swing.JLabel();
        campoValor = new javax.swing.JTextField();
        campoNome = new javax.swing.JTextField();
        textoValor = new javax.swing.JLabel();
        botaoCadastrar = new javax.swing.JButton();
        caixaSelecaoForn = new javax.swing.JComboBox(getItems());
        textoTipo = new javax.swing.JLabel();
        radioInd = new javax.swing.JRadioButton();
        radioPrep = new javax.swing.JRadioButton();
        barraMenu = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        menuEditar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textoAdicionarProduto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        textoAdicionarProduto.setText("Adicionar Novo Produto");

        textoIconeNovoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/au/resources/icons/add_user-64.png"))); // NOI18N

        textoPreencherDados.setText("Preencha os dados abaixo para adicionar um novo produto.");

        javax.swing.GroupLayout painelSuperiorLayout = new javax.swing.GroupLayout(painelSuperior);
        painelSuperior.setLayout(painelSuperiorLayout);
        painelSuperiorLayout.setHorizontalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoIconeNovoUsuario)
                .addGap(18, 18, 18)
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoAdicionarProduto)
                    .addComponent(textoPreencherDados))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelSuperiorLayout.setVerticalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoIconeNovoUsuario)
                    .addGroup(painelSuperiorLayout.createSequentialGroup()
                        .addComponent(textoAdicionarProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoPreencherDados)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelDadosProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados Produto"));

        textoId.setText("Id Produto:");

        textoQtd.setText("Quantidade:");

        textoFornecedor.setText("Fornecedor:");

        textoBarras.setText("Código de Barras:");

        campoId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoIdActionPerformed(evt);
            }
        });
        campoId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoIdFocusLost(evt);
            }
        });

        campoQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoQtdActionPerformed(evt);
            }
        });
        campoQtd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoQtdFocusLost(evt);
            }
        });

        campoBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBarrasActionPerformed(evt);
            }
        });
        campoBarras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoBarrasFocusLost(evt);
            }
        });

        textoNome.setText("Nome Produto:");

        campoValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoValorActionPerformed(evt);
            }
        });
        campoValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoValorFocusLost(evt);
            }
        });

        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });
        campoNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNomeFocusLost(evt);
            }
        });

        textoValor.setText("Valor Produto:");

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        caixaSelecaoForn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caixaSelecaoFornActionPerformed(evt);
            }
        });
        caixaSelecaoForn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                caixaSelecaoFornFocusLost(evt);
            }
        });

        textoTipo.setText("Tipo Produto:");

        buttonGroup1.add(radioInd);
        radioInd.setText("Industrializado");
        radioInd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioIndActionPerformed(evt);
            }
        });
        radioInd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                radioIndFocusLost(evt);
            }
        });

        buttonGroup1.add(radioPrep);
        radioPrep.setText("Preparado");
        radioPrep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPrepActionPerformed(evt);
            }
        });
        radioPrep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                radioPrepFocusLost(evt);
            }
        });

        javax.swing.GroupLayout painelDadosProdutoLayout = new javax.swing.GroupLayout(painelDadosProduto);
        painelDadosProduto.setLayout(painelDadosProdutoLayout);
        painelDadosProdutoLayout.setHorizontalGroup(
            painelDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosProdutoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoCadastrar)
                .addContainerGap())
            .addGroup(painelDadosProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoId, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addGroup(painelDadosProdutoLayout.createSequentialGroup()
                        .addGroup(painelDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(textoBarras, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textoFornecedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textoQtd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoTipo))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(campoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoValor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelDadosProdutoLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(radioInd)
                        .addGap(18, 18, 18)
                        .addComponent(radioPrep))
                    .addGroup(painelDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(campoQtd, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(caixaSelecaoForn, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        painelDadosProdutoLayout.setVerticalGroup(
            painelDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoId)
                    .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosProdutoLayout.createSequentialGroup()
                        .addGroup(painelDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioInd)
                            .addComponent(radioPrep))
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosProdutoLayout.createSequentialGroup()
                        .addComponent(textoTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(painelDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caixaSelecaoForn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoFornecedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoQtd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoBarras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(botaoCadastrar)
                .addContainerGap())
        );

        menuArquivo.setText("Arquivo");
        barraMenu.add(menuArquivo);

        menuEditar.setText("Editar");
        barraMenu.add(menuEditar);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelDadosProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(painelDadosProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIdActionPerformed
        campoNome.requestFocus();
    }//GEN-LAST:event_campoIdActionPerformed

    private CustomComboBox[] getItems() {
        listaResForn = fornDao.getLista();
        System.out.println("Chegou aqui");
        CustomComboBox[] oItems = new CustomComboBox[listaResForn.size()];
        System.out.println("Qtd Lista " + listaResForn.size());
        for (int i = 0; i < listaResForn.size(); i++) {
            oItems[i] = new CustomComboBox(listaResForn.get(i).getNomeForn(), listaResForn.get(i).getIdForn());
            System.out.println("ID " + oItems[i].getId());
        }

        return oItems;
    }

    private boolean validaCampos() {
        for (int i = 0; i < validaForm.length; i++) {
            if (validaForm[i] == 0) {
                return false;
            }
        }
        return true;
    }

    private void campoIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoIdFocusLost
        if (!campoId.getText().equals("")) {
            validaForm[0] = 1;
            campoId.setBorder(border2);
        } else {
            validaForm[0] = 0;
        }
    }//GEN-LAST:event_campoIdFocusLost

    private void campoQtdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoQtdFocusLost
        if (!campoQtd.getText().equals("")) {
            validaForm[3] = 1;
            campoQtd.setBorder(border2);
        } else {
            validaForm[3] = 0;
        }
    }//GEN-LAST:event_campoQtdFocusLost

    private void campoBarrasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoBarrasFocusLost
        if (!campoBarras.getText().equals("")) {
            validaForm[5] = 1;
            campoBarras.setBorder(border2);
        } else {
            validaForm[5] = 0;
        }
    }//GEN-LAST:event_campoBarrasFocusLost

    private void campoQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoQtdActionPerformed
        caixaSelecaoForn.requestFocus();
    }//GEN-LAST:event_campoQtdActionPerformed

    private void campoBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBarrasActionPerformed

    }//GEN-LAST:event_campoBarrasActionPerformed

    private void campoValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoValorActionPerformed
        campoQtd.requestFocus();
    }//GEN-LAST:event_campoValorActionPerformed

    private void campoValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoValorFocusLost
        if (!campoValor.getText().equals("")) {
            validaForm[2] = 1;
            campoValor.setBorder(border2);
        } else {
            validaForm[2] = 0;
        }
    }//GEN-LAST:event_campoValorFocusLost

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
        campoValor.requestFocus();
    }//GEN-LAST:event_campoNomeActionPerformed

    private void campoNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNomeFocusLost
        if (!campoNome.getText().equals("")) {
            validaForm[1] = 1;
            campoNome.setBorder(border2);
        } else {
            validaForm[1] = 0;
        }
    }//GEN-LAST:event_campoNomeFocusLost

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        if (true) {
            Produto produto = new Produto();
            Fornecedor fornecedor = new Fornecedor();

            produto.setIdProd(Integer.parseInt(campoId.getText()));
            produto.setDescProd(campoNome.getText());
            produto.setValorProd(Double.valueOf(campoValor.getText()));
            produto.setQtdProd(Integer.parseInt(campoQtd.getText()));
            CustomComboBox ob=(CustomComboBox) caixaSelecaoForn.getSelectedItem();
            fornecedor.setNomeForn(ob.getNome());            
            fornecedor.setIdForn(ob.getId());
            produto.setFornecedor(fornecedor);
            produto.setCodBarras(campoBarras.getText());
            if (radioInd.getSelectedObjects() == null) {
                produto.setEindustrializado(false);
            } else {
                produto.setEindustrializado(true);
            }

            Session s = HibernateUtil.getSessionFactory().getCurrentSession();
            s.beginTransaction();
            s.save(produto); //INSERT
            s.getTransaction().commit();
        } else {
            Border border = BorderFactory.createLineBorder(Color.red, 1);
            if (validaForm[0] == 0) {
                campoId.setBorder(border);
            }
            if (validaForm[1] == 0) {
                campoNome.setBorder(border);
            }
            if (validaForm[2] == 0) {
                campoValor.setBorder(border);
            }
            if (validaForm[3] == 0) {
                campoQtd.setBorder(border);
            }
            if (validaForm[4] == 0) {
                caixaSelecaoForn.setBorder(border);
            }
            if (validaForm[5] == 0) {
                campoBarras.setBorder(border);
            }
            if (validaForm[6] == 0) {
                //radioInd.
                //radioPrep.setBorder(border);
            }
        }

    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void caixaSelecaoFornFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_caixaSelecaoFornFocusLost
        if (!caixaSelecaoForn.getSelectedItem().equals("")) {
            validaForm[4] = 1;
            caixaSelecaoForn.setBorder(border2);
        } else {
            validaForm[4] = 0;
        }
    }//GEN-LAST:event_caixaSelecaoFornFocusLost

    private void caixaSelecaoFornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixaSelecaoFornActionPerformed
        campoBarras.requestFocus();
    }//GEN-LAST:event_caixaSelecaoFornActionPerformed

    private void radioIndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioIndActionPerformed
        campoQtd.setText("");
        campoBarras.setText("");
        campoQtd.setVisible(true);
        campoBarras.setVisible(true);
        textoQtd.setVisible(true);
        textoBarras.setVisible(true);
    }//GEN-LAST:event_radioIndActionPerformed

    private void radioPrepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_radioPrepFocusLost
        if (radioPrep.isSelected() || radioInd.isSelected()) {
            validaForm[6] = 1;
        } else {
            validaForm[6] = 0;
        }
    }//GEN-LAST:event_radioPrepFocusLost

    private void radioPrepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPrepActionPerformed
        campoQtd.setText("0");
        campoBarras.setText("");
        campoQtd.setVisible(false);
        campoBarras.setVisible(false);
        textoQtd.setVisible(false);
        textoBarras.setVisible(false);
    }//GEN-LAST:event_radioPrepActionPerformed

    private void radioIndFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_radioIndFocusLost
        if (radioPrep.isSelected() || radioInd.isSelected()) {
            validaForm[6] = 1;
        } else {
            validaForm[6] = 0;
        }
    }//GEN-LAST:event_radioIndFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastraProduto().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox caixaSelecaoForn;
    private javax.swing.JTextField campoBarras;
    private javax.swing.JTextField campoId;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoQtd;
    private javax.swing.JTextField campoValor;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenu menuEditar;
    private javax.swing.JPanel painelDadosProduto;
    private javax.swing.JPanel painelSuperior;
    private javax.swing.JRadioButton radioInd;
    private javax.swing.JRadioButton radioPrep;
    private javax.swing.JLabel textoAdicionarProduto;
    private javax.swing.JLabel textoBarras;
    private javax.swing.JLabel textoFornecedor;
    private javax.swing.JLabel textoIconeNovoUsuario;
    private javax.swing.JLabel textoId;
    private javax.swing.JLabel textoNome;
    private javax.swing.JLabel textoPreencherDados;
    private javax.swing.JLabel textoQtd;
    private javax.swing.JLabel textoTipo;
    private javax.swing.JLabel textoValor;
    // End of variables declaration//GEN-END:variables
}
