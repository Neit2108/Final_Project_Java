package com.epu.QuanLyNhaTro.view;

import javax.swing.*;
import java.awt.*;

public class PaymentDetailsForm {
    public static void main(String[] args) {
        // Tạo frame chính
        JFrame frame = new JFrame("Chi tiết Thanh Toán");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        frame.setLayout(null);

        // Panel chứa hình ảnh
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.LIGHT_GRAY);
        imagePanel.setBounds(100, 70, 400, 200); // Cách trên 70px, rộng 400px, cao 200px
        frame.add(imagePanel);

        // Label giả lập hình ảnh (thay bằng hình ảnh thật nếu cần)
        JLabel imageLabel = new JLabel("Hình ảnh", SwingConstants.CENTER);
        imageLabel.setForeground(Color.DARK_GRAY);
        imageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        imagePanel.add(imageLabel);

        // Label Số tiền
        JLabel amountLabel = new JLabel("Số tiền:");
        amountLabel.setBounds(100, 300, 100, 40);
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        frame.add(amountLabel);

        JLabel amountValue = new JLabel("............................");
        amountValue.setBounds(250, 300, 250, 40);
        amountValue.setFont(new Font("Arial", Font.PLAIN, 18));
        frame.add(amountValue);

        // Label Người nhận
        JLabel recipientLabel = new JLabel("Người nhận:");
        recipientLabel.setBounds(100, 360, 120, 40);
        recipientLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        frame.add(recipientLabel);

        JLabel recipientValue = new JLabel("............................");
        recipientValue.setBounds(250, 360, 250, 40);
        recipientValue.setFont(new Font("Arial", Font.PLAIN, 18));
        frame.add(recipientValue);

        // Button Xác nhận
        JButton confirmButton = new JButton("Xác nhận") {
            @Override
            protected void paintComponent(Graphics g) {
                if (!isOpaque()) {
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(new Color(72, 165, 237)); // Màu nền xanh dương nhạt
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Bo góc 20px
                }
                super.paintComponent(g);
            }

            @Override
            public void setOpaque(boolean isOpaque) {
                super.setOpaque(false);
            }
        };
        confirmButton.setBounds(450, 600, 110, 40); // Góc dưới bên trái
        confirmButton.setFont(new Font("Arial", Font.BOLD, 16));
        confirmButton.setForeground(Color.BLACK);
        confirmButton.setContentAreaFilled(false);
        confirmButton.setBorderPainted(false);
        confirmButton.setFocusPainted(false);
        frame.add(confirmButton);

        // Hiển thị frame
        frame.setLocationRelativeTo(null); // Căn giữa màn hình
        frame.setVisible(true);
    }
}

