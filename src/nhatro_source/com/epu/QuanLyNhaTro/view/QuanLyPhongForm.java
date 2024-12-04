package com.epu.QuanLyNhaTro.view;

import com.epu.QuanLyNhaTro.controller.DetailRoomController;
import com.epu.QuanLyNhaTro.controller.QuanLyPhongController;
import com.epu.QuanLyNhaTro.dao.KieuPhongDAO;
import com.epu.QuanLyNhaTro.dao.KieuPhongDAOImpl;
import com.epu.QuanLyNhaTro.dao.PhongDAO;
import com.epu.QuanLyNhaTro.dao.PhongDAOImpl;
import com.epu.QuanLyNhaTro.model.Phong;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

@Getter
@Setter
public class QuanLyPhongForm extends JPanel {

    private JTextField maPhongField, tenPhongField, giaPhongField, maNhaTroField, loaiPhongField;
    private JButton themBtn, suaBtn, xoaBtn, lamMoiBtn, chonAnhBtn;
    private JPanel danhSachPanel;

    public QuanLyPhongForm() {
        setSize(1346, 793);
        setLayout(new BorderLayout(10, 10));

        // Panel bên trái tổng hợp form và button
        JPanel leftPanel = new JPanel(new BorderLayout(10, 10));
        leftPanel.setPreferredSize(new Dimension(400, 793));

        // Form nhập liệu (formPanel)
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Thông Tin Phòng"));
        formPanel.setPreferredSize(new Dimension(400, 500));

        formPanel.add(new JLabel("Mã Phòng:"));
        maPhongField = createSmallTextField();
        maPhongField.setEditable(false);
        formPanel.add(maPhongField);

        formPanel.add(new JLabel("Tên Phòng:"));
        tenPhongField = createSmallTextField();
        formPanel.add(tenPhongField);

        formPanel.add(new JLabel("Mã Nhà Trọ:"));
        maNhaTroField = createSmallTextField();
        formPanel.add(maNhaTroField);

        formPanel.add(new JLabel("Mã Kiểu Phòng:"));
        loaiPhongField = createSmallTextField();
        formPanel.add(loaiPhongField);

        formPanel.add(new JLabel("Giá Phòng:"));
        giaPhongField = createSmallTextField();
        formPanel.add(giaPhongField);

        formPanel.add(new JLabel("Ảnh Phòng:"));
        chonAnhBtn = createButton("Chọn Ảnh");
        formPanel.add(chonAnhBtn);

        leftPanel.add(formPanel, BorderLayout.CENTER);

        // Panel chức năng (buttonPanel)
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Chức Năng"));
        buttonPanel.setPreferredSize(new Dimension(400, 80));

        themBtn = createButton("Thêm");
        suaBtn = createButton("Sửa");
        xoaBtn = createButton("Xóa");
        lamMoiBtn = createButton("Tìm kiếm");

        buttonPanel.add(themBtn);
        buttonPanel.add(suaBtn);
        buttonPanel.add(xoaBtn);
        buttonPanel.add(lamMoiBtn);

        leftPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(leftPanel, BorderLayout.WEST);

        // Panel bên phải: Danh sách phòng (khung nhỏ)
        danhSachPanel = new JPanel();
        danhSachPanel.setLayout(new GridLayout(0, 3, 10, 10)); // Hiển thị 3 cột
        danhSachPanel.setBorder(BorderFactory.createTitledBorder("Danh Sách Phòng"));

        QuanLyPhongController quanLyPhongController = new QuanLyPhongController(this);
        quanLyPhongController.init();

        JScrollPane danhSachScrollPane = new JScrollPane(danhSachPanel);
        add(danhSachScrollPane, BorderLayout.CENTER);
    }

    // Hàm tạo khung hiển thị thông tin phòng
    public JPanel createPhongPanel(int maPhong, String tenPhong, int maNhaTro, String loaiPhong, String giaPhong, String anhPhong) {
        JPanel phongPanel = new JPanel();
        phongPanel.setLayout(new BorderLayout(5, 5));
        phongPanel.setBorder(BorderFactory.createTitledBorder("Mã Phòng: " + maPhong));
        phongPanel.setPreferredSize(new Dimension(200, 250));

        // Ảnh giả lập
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setBorder(new LineBorder(Color.BLACK));
        imageLabel.setPreferredSize(new Dimension(150, 120));

        ImageIcon icon = new ImageIcon("D:\\MyProjects\\final_QuanLyNhaTro\\src\\resources\\roomImage.png");
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

        // Nút "Chi Tiết" cân đối
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

        phongPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QuanLyPhongController quanLyPhongController = new QuanLyPhongController(QuanLyPhongForm.this);
                quanLyPhongController.handleRoomClick(evt, maPhong);
            }
        });

        return phongPanel;
    }

    // Hàm tạo JTextField với chiều cao thấp hơn
    private JTextField createSmallTextField() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setPreferredSize(new Dimension(150, 20)); // Giảm chiều cao
        return textField;
    }

    // Hàm tạo JButton với kích thước ban đầu
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 12));
        button.setPreferredSize(new Dimension(100, 25));
        return button;
    }

    // Hàm tạo JButton "Chi Tiết" cân đối
    private JButton createDetailButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 12)); // Font rõ ràng hơn
        button.setPreferredSize(new Dimension(80, 30)); // Đủ rộng và cao để hiển thị chữ
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Quản Lý Phòng - Nhà Trọ");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1346, 793);
            frame.add(new QuanLyPhongForm());
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
