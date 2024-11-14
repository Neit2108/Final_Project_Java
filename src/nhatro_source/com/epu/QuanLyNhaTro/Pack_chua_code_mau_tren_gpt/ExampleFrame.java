package com.epu.QuanLyNhaTro.Pack_chua_code_mau_tren_gpt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExampleFrame extends JFrame {
    private JPanel leftPanel;  // Panel chứa các nút
    private JPanel rightPanel; // Panel chứa nội dung
    private CardLayout cardLayout;  // Layout để thay đổi giữa các nội dung

    public ExampleFrame() {
        setTitle("CardLayout Example");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo layout chính
        setLayout(new BorderLayout());

        // Panel bên trái chứa các nút
        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        // Các nút điều hướng
        JButton btnContract = new JButton("Hợp đồng");
        JButton btnRoom = new JButton("Phòng");

        leftPanel.add(btnContract);
        leftPanel.add(btnRoom);

        // Panel bên phải chứa các nội dung
        cardLayout = new CardLayout();
        rightPanel = new JPanel(cardLayout);

        JPanel contractPanel = new JPanel();
        contractPanel.add(new JLabel("Hợp đồng"));
        contractPanel.setBackground(Color.LIGHT_GRAY);

        JPanel roomPanel = new JPanel();
        roomPanel.add(new JLabel("Phòng"));
        roomPanel.setBackground(Color.LIGHT_GRAY);

        rightPanel.add(contractPanel, "Contract");
        rightPanel.add(roomPanel, "Room");

        // Thêm các panel vào frame
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        // Cài đặt hành động khi bấm vào nút
        btnContract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(rightPanel, "Contract"); // Hiển thị panel Hợp đồng
            }
        });

        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(rightPanel, "Room"); // Hiển thị panel Phòng
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ExampleFrame().setVisible(true);
            }
        });
    }
}
