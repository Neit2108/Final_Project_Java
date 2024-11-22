package com.epu.QuanLyNhaTro.Pack_chua_code_mau_tren_gpt;

import javax.swing.*;
import java.awt.*;

public class ContractDetailForm extends JFrame {

    public ContractDetailForm() {
        setTitle("Chi tiết hợp đồng thuê nhà");
        setSize(900, 1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tiêu đề hợp đồng
        JPanel headerPanel = new JPanel(new GridLayout(3, 1));
        JLabel lblTitle = new JLabel("CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM", SwingConstants.CENTER);
        JLabel lblSubtitle = new JLabel("Độc lập - Tự do - Hạnh phúc", SwingConstants.CENTER);
        JLabel lblContractType = new JLabel("HỢP ĐỒNG THUÊ NHÀ Ở", SwingConstants.CENTER);

        lblTitle.setFont(new Font("Serif", Font.BOLD, 18));
        lblSubtitle.setFont(new Font("Serif", Font.ITALIC, 14));
        lblContractType.setFont(new Font("Serif", Font.BOLD, 22));

        headerPanel.add(lblTitle);
        headerPanel.add(lblSubtitle);
        headerPanel.add(lblContractType);
        add(headerPanel, BorderLayout.NORTH);

        // Nội dung hợp đồng
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Thông tin Bên A và Bên B
        contentPanel.add(new JLabel("BÊN CHO THUÊ (Bên A):"));
        contentPanel.add(new JLabel("Họ và tên: ............................."));
        contentPanel.add(new JLabel("CCCD: .................................  Ngày cấp: ....................."));
        contentPanel.add(new JLabel("Nơi đăng ký thường trú: ................................................"));

        contentPanel.add(Box.createVerticalStrut(10)); // Thêm khoảng cách

        contentPanel.add(new JLabel("BÊN THUÊ (Bên B):"));
        contentPanel.add(new JLabel("Họ và tên: ............................."));
        contentPanel.add(new JLabel("CCCD: .................................  Ngày cấp: ....................."));
        contentPanel.add(new JLabel("Nơi đăng ký thường trú: ................................................"));

        contentPanel.add(Box.createVerticalStrut(20));

        // Điều khoản hợp đồng
        JLabel lblTermsTitle = new JLabel("Các điều khoản của hợp đồng:");
        lblTermsTitle.setFont(new Font("Serif", Font.BOLD, 16));
        contentPanel.add(lblTermsTitle);

        JTextArea txtTerms = new JTextArea(30, 70);
        txtTerms.setLineWrap(true);
        txtTerms.setWrapStyleWord(true);
        txtTerms.setText("Điều 1: Căn hộ chung cư cho thuê...\n" +
                "Điều 2: Mục đích thuê...\n" +
                "Điều 3: Thời hạn thuê...\n" +
                "Điều 4: Giá thuê và phương thức thanh toán...\n" +
                "Điều 5: Trách nhiệm và quyền lợi của các bên...\n" +
                "...");
        txtTerms.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(txtTerms);
        contentPanel.add(scrollPane);

        add(contentPanel, BorderLayout.CENTER);

        // Nút chức năng
        JPanel buttonPanel = new JPanel();
        JButton btnClose = new JButton("Đóng");
        btnClose.addActionListener(e -> dispose()); // Đóng cửa sổ
        buttonPanel.add(btnClose);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ContractDetailForm form = new ContractDetailForm();
            form.setVisible(true);
        });
    }
}
