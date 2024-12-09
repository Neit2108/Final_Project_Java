package com.epu.QuanLyNhaTro.view;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Setter
@Getter
public class InforContractForm extends JFrame {
    private JTextField txtMaPhong;
    private JTextField txtMaKhach;
    private JTextField txtTienCoc;
    private JTextField txtNgayThue;
    private JTextField txtThoiHan;
    private JTextField txtSoNguoi;
    private JButton btnLuu;
    public InforContractForm() {
        setTitle("Thông tin hợp đồng");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); //
        // Thiết lập layout cho form
        this.setLayout(new GridLayout(7, 2, 10, 10)); // 7 rows, 2 columns (for labels and inputs)
        //this.setPreferredSize(new Dimension(400, 300)); // Kích thước form

        // Tạo các label và text field cho từng trường
        JLabel lblMaPhong = new JLabel("Mã phòng:");
        txtMaPhong = new JTextField();
        txtMaPhong.setEditable(false);

        JLabel lblMaKhach = new JLabel("Mã khách:");
        txtMaKhach = new JTextField();
        txtMaKhach.setEditable(false);

        JLabel lblTienCoc = new JLabel("Tiền cọc:");
        txtTienCoc = new JTextField();

        JLabel lblNgayThue = new JLabel("Ngày thuê:");
        txtNgayThue = new JTextField();
        txtNgayThue.setEditable(false);

        JLabel lblThoiHan = new JLabel("Thời hạn hợp đồng:");
        txtThoiHan = new JTextField();

        JLabel lblSoNguoi = new JLabel("Số người:");
        txtSoNguoi = new JTextField();

        // Tạo nút "Lưu"
        btnLuu = new JButton("Lưu");

        // Thêm các label và text field vào form
        this.add(lblMaPhong);
        this.add(txtMaPhong);
        this.add(lblMaKhach);
        this.add(txtMaKhach);
        this.add(lblTienCoc);
        this.add(txtTienCoc);
        this.add(lblNgayThue);
        this.add(txtNgayThue);
        this.add(lblThoiHan);
        this.add(txtThoiHan);
        this.add(lblSoNguoi);
        this.add(txtSoNguoi);
        this.add(new JLabel()); // Chỗ trống
        this.add(btnLuu);

    }

    public static void main(String[] args) {
        // Tạo frame chính để hiển thị form
        InforContractForm inforContractForm = new InforContractForm();

        inforContractForm.setVisible(true);
    }
}
