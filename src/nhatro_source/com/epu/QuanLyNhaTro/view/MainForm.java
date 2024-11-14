package com.epu.QuanLyNhaTro.view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class MainForm extends JFrame {
    private JPanel mainPnl;

    public MainForm() {
        setSize(400, 300);
        setContentPane(mainPnl);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MainForm mainForm = new MainForm();
        mainForm.setVisible(true);

    }

}
