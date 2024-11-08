package com.epu.QuanLyNhaTro.view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signUpCode extends JDialog {
    private JPanel signUpCodePnl;
    @Getter
    private JButton okBtn;
    @Getter
    private JButton cancelBtn;
    @Getter
    private JTextField codeField;
    private JPanel codePanel;
    private JPanel btnPanel;
    private JPanel btnPanel_mini;
    private JButton resendBtn;

    public signUpCode() {

        setTitle("Xác Thực Mã");
        setContentPane(signUpCodePnl);
        setModal(true);
        getRootPane().setDefaultButton(okBtn);

        // Thiết lập màu nền cho các panel chính
        signUpCodePnl.setBackground(new Color(245, 245, 245));
        codePanel.setBackground(new Color(245, 245, 245));
        btnPanel.setBackground(new Color(245, 245, 245));
        btnPanel_mini.setBackground(new Color(245, 245, 245));

        // Tùy chỉnh nút OK
        okBtn.setBackground(new Color(76, 175, 80));
        okBtn.setForeground(Color.WHITE);
        okBtn.setFont(new Font("SansSerif", Font.BOLD, 12));
        okBtn.setFocusPainted(false);

        resendBtn.setBackground(new Color(76, 175, 80));
        resendBtn.setForeground(Color.WHITE);
        resendBtn.setFont(new Font("SansSerif", Font.BOLD, 12));
        resendBtn.setFocusPainted(false);

        // Tùy chỉnh nút Cancel
        cancelBtn.setBackground(new Color(244, 67, 54));
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.setFont(new Font("SansSerif", Font.BOLD, 12));
        cancelBtn.setFocusPainted(false);

        // Tùy chỉnh ô nhập mã xác thực
        codeField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        codeField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));


        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        signUpCodePnl.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        pack();
        setLocationRelativeTo(null);
    }

    private void onOK() {
        // add your code here
        this.setVisible(true);
        codeField.setText("");
    }

    private void onCancel() {
        // add your code here if necessary
        codeField.setText("");
        dispose();
    }

    public static void main(String[] args) {
        signUpCode dialog = new signUpCode();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
