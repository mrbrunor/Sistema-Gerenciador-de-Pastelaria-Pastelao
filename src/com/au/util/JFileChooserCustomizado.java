/*
 * The MIT License
 *
 * Copyright 2014 Tiago.
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
package com.au.util;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Tiago
 */
public class JFileChooserCustomizado extends JFileChooser {

    private static final long serialVersionUID = 1L;
    private final String extension;

    public JFileChooserCustomizado(String getDiretorioAtual, String extensao) {
        super(getDiretorioAtual);
        this.extension = extensao;
    }

    @Override
    public File getSelectedFile() {
        File selectedFile = super.getSelectedFile();
        if (selectedFile != null && (getDialogType() == SAVE_DIALOG || getDialogType() == CUSTOM_DIALOG)) {
            String name = selectedFile.getName();
            if (!name.contains(".")) {
                selectedFile = new File(selectedFile.getParentFile(), name + "." + extension);
            }
        }
        return selectedFile;
    }
}
