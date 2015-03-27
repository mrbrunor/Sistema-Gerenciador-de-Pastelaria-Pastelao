/*
 * Copyright (C) 2015 Tiago
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

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JFrame;

/**
 *
 * @author Tiago
 */
public class setarIcone {
    public setarIcone (JFrame frm) {
        URL url = this.getClass().getResource("/com/au/resources/icons/main_icon.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
        frm.setIconImage(imagemTitulo); 
    }
}
