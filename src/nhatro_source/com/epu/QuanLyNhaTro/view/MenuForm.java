package com.epu.QuanLyNhaTro.view;

import javax.swing.*;
import java.awt.*;

public class MenuForm extends JFrame {

    private JButton phongBtn;
    private JButton dangxuatBtn;
    private JButton quanlyBtn;
    private JButton hopdongBtn;
    private JButton nhaBtn;
    private JButton pctBtn;
    private JPanel buttonPanel;
    private JPanel mainPanel;

    public MenuForm() {
        // Initialize buttons with updated labels and custom rounded styles
        phongBtn = createRoundedButton("Phòng");
        pctBtn = createRoundedButton("Phòng của tôi");
        nhaBtn = createRoundedButton("Nhà");
        hopdongBtn = createRoundedButton("Hợp Đồng");
        quanlyBtn = createRoundedButton("Quản Lý Khách Thuê");
        dangxuatBtn = createRoundedButton("Đăng Xuất");

        // set cỡ riêng cho nút Dang Xuat
        dangxuatBtn.setPreferredSize(new Dimension(75, 30));
        dangxuatBtn.setMaximumSize(new Dimension(75, 30));

        // Adjust font size for the "Đăng Xuất" button to fit the smaller size
        dangxuatBtn.setFont(new Font("Arial", Font.BOLD, 10));

        // Create label for the menu title and center it
        JLabel menuLabel = new JLabel("Menu", SwingConstants.CENTER);
        menuLabel.setFont(new Font("Arial", Font.BOLD, 20));
        menuLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Left panel with buttons
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding around the panel
        buttonPanel.setBackground(new Color(240, 248, 255)); // Light blue background for harmony

        // Add label and buttons to the panel with adjusted spacing
        buttonPanel.add(menuLabel);
        buttonPanel.add(Box.createVerticalStrut(25)); // Space below the label
        buttonPanel.add(phongBtn);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(pctBtn);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(nhaBtn);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(hopdongBtn);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(quanlyBtn);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(Box.createVerticalGlue()); // Add space before dangxuatBtn to push it to the bottom
        buttonPanel.add(dangxuatBtn);

        // Main panel to hold the empty area on the right
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);

        // Set layout for the frame
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        // Frame settings
        setTitle("Menu Form");
        setSize(800, 600); // Larger frame size for better spacing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
    }

    // Helper method to create a rounded button with color styling
    private JButton createRoundedButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(135, 206, 250)); // Light sky blue color for the button background
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // Rounded corners
                super.paintComponent(g2);
                g2.dispose();
            }

            @Override
            public void setContentAreaFilled(boolean b) {
                // Override to prevent default button filling
            }
        };

        button.setFocusPainted(false); // Remove focus border on click
        button.setForeground(Color.BLACK); // Set text color to black
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setPreferredSize(new Dimension(150, 60)); // Original width with taller height
        button.setMaximumSize(new Dimension(150, 60)); // Set fixed width and height for all buttons
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Inner padding for text

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuForm form = new MenuForm();
            form.setVisible(true);
        });
    }
}