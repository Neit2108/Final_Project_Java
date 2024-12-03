package com.epu.QuanLyNhaTro.Pack_chua_code_mau_tren_gpt;

import com.epu.QuanLyNhaTro.util.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContractFrame extends JFrame {
    private JButton btnCreate, btnEdit, btnDelete;
    private JTable contractTable;  // Giả sử đây là bảng hợp đồng của bạn
    private String userRole;  // Role của người dùng (admin/khachthue)

    public ContractFrame() {
        this.userRole = Constant.taiKhoan.getVaiTro() != null ? Constant.taiKhoan.getVaiTro() : "Admin"; // Lưu vai trò người dùng khi đăng nhập
        setTitle("Danh Sách Hợp Đồng");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo bảng hợp đồng
        contractTable = new JTable();  // Bạn có thể thay thế bằng bảng dữ liệu thật
        JScrollPane scrollPane = new JScrollPane(contractTable);

        // Tạo các nút
        btnCreate = new JButton("Tạo Hợp Đồng");
        btnEdit = new JButton("Sửa Hợp Đồng");
        btnDelete = new JButton("Xóa Hợp Đồng");

        // Đặt layout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        // Nếu là admin, hiển thị các nút tạo, sửa, xóa
        if (userRole.equals("Admin")) {
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(btnCreate);
            buttonPanel.add(btnEdit);
            buttonPanel.add(btnDelete);
            panel.add(buttonPanel, BorderLayout.SOUTH);
        }

        // Thêm các thành phần vào JFrame
        add(panel);

        // Xử lý sự kiện cho các nút (Chỉ xử lý nếu là admin)
        if (userRole.equals("Admin")) {
            btnCreate.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Mở form tạo hợp đồng
                    JOptionPane.showMessageDialog(null, "Tạo hợp đồng mới");
                }
            });
            btnEdit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Mở form chỉnh sửa hợp đồng
                    JOptionPane.showMessageDialog(null, "Chỉnh sửa hợp đồng");
                }
            });
            btnDelete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Xóa hợp đồng đã chọn
                    JOptionPane.showMessageDialog(null, "Xóa hợp đồng");
                }
            });
        } else if (userRole.equals("Khách Thuê")) {
            // Khách thuê chỉ có thể xem hợp đồng
            btnCreate.setEnabled(false);  // Tắt nút tạo
            btnEdit.setEnabled(false);    // Tắt nút sửa
            btnDelete.setEnabled(false);  // Tắt nút xóa
        }
    }

}
