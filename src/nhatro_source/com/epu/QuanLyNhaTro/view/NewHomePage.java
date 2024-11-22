package com.epu.QuanLyNhaTro.view;

import com.epu.QuanLyNhaTro.dao.PhongDAO;
import com.epu.QuanLyNhaTro.dao.PhongDAOImpl;
import com.epu.QuanLyNhaTro.model.Phong;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class NewHomePage extends JPanel {

    public NewHomePage() {
        setLayout(new GridLayout(0, 3, 10, 10)); // Hiển thị 3 cột
        setBorder(BorderFactory.createTitledBorder("Danh Sách Phòng"));

        //hiển thị thông tin phòng
        for (int i = 1; i <= 9; i++) {
            PhongDAO phongDAO = new PhongDAOImpl();
            Phong phong = phongDAO.getPhong(i + 3);
            add(createPhongPanel( i + 3, "Phòng " + (i + 3), phong.getMaNhaTro(), String.valueOf(phong.getMaKieuPhong()), phongDAO.getGiaPhong(i + 3), phong.getUrlImage()));
        }
    }

    // Hàm tạo khung hiển thị thông tin phòng
    private JPanel createPhongPanel(int maPhong, String tenPhong, int maNhaTro, String loaiPhong, double giaPhong, String anhPhong) {
        JPanel phongPanel = new JPanel();
        phongPanel.setLayout(new BorderLayout(5, 5));
        phongPanel.setBorder(BorderFactory.createTitledBorder("Mã Phòng: " + maPhong));
        phongPanel.setPreferredSize(new Dimension(200, 250));

        // Ảnh giả lập
        JLabel imageLabel = new JLabel("Ảnh");
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setBorder(new LineBorder(Color.BLACK));
        imageLabel.setPreferredSize(new Dimension(150, 120));

        phongPanel.add(imageLabel, BorderLayout.NORTH);

        // Thông tin chi tiết
        JPanel infoPanel = new JPanel(new BorderLayout(5, 5));
        JPanel detailInfoPanel = new JPanel(new GridLayout(4, 1));
        detailInfoPanel.add(new JLabel("Tên Phòng: " + tenPhong));
        detailInfoPanel.add(new JLabel("Nhà Trọ: " + maNhaTro));
        detailInfoPanel.add(new JLabel("Loại Phòng: " + loaiPhong));
        detailInfoPanel.add(new JLabel("Giá: " + giaPhong));

        // Nút "Chi Tiết"
        JButton chiTietBtn = createDetailButton("Chi Tiết");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(chiTietBtn);

        infoPanel.add(detailInfoPanel, BorderLayout.CENTER);
        infoPanel.add(buttonPanel, BorderLayout.SOUTH);

        phongPanel.add(infoPanel, BorderLayout.CENTER);

        return phongPanel;
    }

    // Hàm tạo JButton "Chi Tiết"
    private JButton createDetailButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 12));
        button.setPreferredSize(new Dimension(80, 30));
        return button;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Quản Lý Phòng - Nhà Trọ");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1346, 793);
            frame.add(new NewHomePage());
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
