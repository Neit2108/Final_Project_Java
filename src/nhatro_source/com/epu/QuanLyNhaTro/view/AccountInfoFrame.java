package com.epu.QuanLyNhaTro.view;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class AccountInfoFrame extends JFrame {

    private JPanel mainPanel;
    private JPanel photoPanel;
    private JPanel infoPanel;
    private JPanel buttonPanel;
    private JLabel photoLabel;
    private JLabel nameLabel;
    private JButton editButton;
    private JButton saveButton;
    private JTextField emailTextField;
    private JTextField nameTextField;
    private JTextField cccdTextField;
    private JTextField birthTextField;
    private JTextField genderTextField;
    private JTextField phoneTextField;
    private JTextField addressTextField;


    public AccountInfoFrame() {
        // Thiết lập cơ bản
        setTitle("Thông tin tài khoản");
        setSize(400, 600);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel chính
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Phần ảnh và tên
        photoPanel = new JPanel();
        photoPanel.setLayout(new BoxLayout(photoPanel, BoxLayout.Y_AXIS));
        photoLabel = new JLabel(new ImageIcon(new ImageIcon("D:\\MyProjects\\final_QuanLyNhaTro\\src\\resources\\user_icon.png")
                .getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        photoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel = new JLabel("Tên: [Tên]");
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        photoPanel.add(photoLabel);
        photoPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Khoảng cách
        photoPanel.add(nameLabel);

        // Phần thông tin
        infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(8, 2, 10, 10));
        infoPanel.add(new JLabel("Email:"));
        infoPanel.add(emailTextField = new JTextField());
        infoPanel.add(new JLabel("Họ và tên:"));
        infoPanel.add(nameTextField = new JTextField());
        infoPanel.add(new JLabel("Căn cước:"));
        infoPanel.add(cccdTextField = new JTextField());
        infoPanel.add(new JLabel("Ngày sinh:"));
        infoPanel.add(birthTextField = new JTextField());
        infoPanel.add(new JLabel("Giới tính:"));
        infoPanel.add(genderTextField = new JTextField());
        infoPanel.add(new JLabel("Số điện thoại:"));
        infoPanel.add(phoneTextField = new JTextField());
        infoPanel.add(new JLabel("Địa chỉ:"));
        infoPanel.add(addressTextField = new JTextField());

        // Phần nút
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        editButton = new JButton("Sửa");
        saveButton = new JButton("Lưu");
        buttonPanel.add(editButton);
        buttonPanel.add(saveButton);

        // Thêm vào mainPanel
        mainPanel.add(photoPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Khoảng cách
        mainPanel.add(infoPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Khoảng cách
        mainPanel.add(buttonPanel);

        new com.epu.QuanLyNhaTro.controller.AccountInfoController(this).init();

        add(mainPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AccountInfoFrame frame = new AccountInfoFrame();
            frame.setVisible(true);
        });
    }
}
