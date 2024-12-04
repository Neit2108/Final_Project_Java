package com.epu.QuanLyNhaTro.view;

import com.epu.QuanLyNhaTro.controller.DetailRoomController;
import com.epu.QuanLyNhaTro.dao.PhongDAO;
import com.epu.QuanLyNhaTro.dao.PhongDAOImpl;
import com.epu.QuanLyNhaTro.model.Phong;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class NewHomePage extends JPanel {

    public NewHomePage() {
        setLayout(new GridLayout(0, 3, 10, 10)); // Hiển thị 3 cột
        setBorder(BorderFactory.createTitledBorder("Danh Sách Phòng"));

        //hiển thị thông tin phòng
        PhongDAO phongDAO = new PhongDAOImpl();
        List<Phong> phongs = phongDAO.getAllPhong();
        for (int i = 0; i <= 8; i++) {
            if(phongs.get(i).getTrangThai().equalsIgnoreCase("Chưa thuê")){
                Phong phong = phongs.get(i);
                add(createPhongPanel(phong.getMaPhong(), phong.getTenPhong(), phong.getMaNhaTro(), String.valueOf(phong.getMaKieuPhong()), phongDAO.getGiaPhong(phong.getMaPhong()), phong.getUrlImage()));
            }
        }
    }

    // Hàm tạo khung hiển thị thông tin phòng
    private JPanel createPhongPanel(int maPhong, String tenPhong, int maNhaTro, String loaiPhong, double giaPhong, String anhPhong) {
        JPanel phongPanel = new JPanel();
        phongPanel.setLayout(new BorderLayout(5, 5));
        phongPanel.setBorder(BorderFactory.createTitledBorder("Mã Phòng: " + maPhong));
        phongPanel.setPreferredSize(new Dimension(200, 250));

        // Ảnh giả lập
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setBorder(new LineBorder(Color.BLACK));
        imageLabel.setPreferredSize(new Dimension(150, 120));

        ImageIcon icon = new ImageIcon("D:\\MyProjects\\final_QuanLyNhaTro\\src\\resources\\house_619153.png");
        Image img = icon.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));

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
        chiTietBtn.addActionListener(e -> {
            DetailRoom detailRoom = new DetailRoom();
            DetailRoomController detailRoomController = new DetailRoomController(detailRoom);
            detailRoomController.handelDetailRoom(maPhong);
            detailRoom.setVisible(true);
        });
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
