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

package com.au.teste;

/**
 *
 * @author BrunoRicardo
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Testing extends JFrame
{
  Beer[] beers = {new Beer("Budweiser",1.50),new Beer("Millers",2.00), new Beer("Coors",5.00)};
  JComboBox cbo = new JComboBox(beers);
 
  public Testing()
  {
    setLocation(400,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cbo.setEditable(true);
    JPanel jp = new JPanel();
    jp.add(cbo);
    getContentPane().add(jp);
    pack();
    cbo.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
        JOptionPane.showMessageDialog(getContentPane(),"Value = "+((Beer)cbo.getSelectedItem()).value);
      }
    });
  }
  public static void main(String[] args){new Testing().setVisible(true);}
}
class Beer
{
  String name;
  double value;
  public Beer(String n, double v)
  {
    name = n; value = v;
  }
  public String toString(){return name;}
}

