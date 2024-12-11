package com.epu.QuanLyNhaTro.view;

import com.epu.QuanLyNhaTro.controller.HouseFormController;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Setter
@Getter
public class HouseForm extends JPanel {

    private JTextField maNhaField, diaChiField, soLuongPhongField;
    private JComboBox<String> trangThaiComboBox;
    private JButton chonAnhBtn, themBtn, suaBtn, xoaBtn, lamMoiBtn, chiTietBtn;
    private JPanel danhSachPanel, buttonPanel;

    public HouseForm() {
        setSize(1346, 793);
        setLayout(new BorderLayout(10, 10));

        // Panel bên trái: Form nhập liệu
        JPanel leftPanel = new JPanel(null); // Sử dụng null layout để tự định vị
        leftPanel.setPreferredSize(new Dimension(400, 793));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Thông Tin Nhà"));

        // Tọa độ và kích thước chung
        int labelWidth = 80;
        int fieldWidth = 210;
        int fieldHeight = 25;
        int startX = 10; // Khoảng cách từ bên trái
        int startY = 40; // Bắt đầu cách trên 20px so với trước
        int gapY = 40;   // Khoảng cách giữa các dòng

        // Mã Nhà
        JLabel maNhaLabel = new JLabel("Mã Nhà:");
        maNhaLabel.setBounds(startX, startY, labelWidth, fieldHeight);
        leftPanel.add(maNhaLabel);

        maNhaField = createSmallTextField();
        maNhaField.setBounds(startX + labelWidth + 10, startY, fieldWidth, fieldHeight);
        leftPanel.add(maNhaField);

        // Địa Chỉ
        JLabel diaChiLabel = new JLabel("Địa Chỉ:");
        diaChiLabel.setBounds(startX, startY + gapY, labelWidth, fieldHeight);
        leftPanel.add(diaChiLabel);

        diaChiField = createSmallTextField();
        diaChiField.setBounds(startX + labelWidth + 10, startY + gapY, fieldWidth, fieldHeight);
        leftPanel.add(diaChiField);

        // Số Lượng Phòng
        JLabel soLuongPhongLabel = new JLabel("Số Lượng Phòng:");
        soLuongPhongLabel.setBounds(startX, startY + 2 * gapY, labelWidth, fieldHeight);
        leftPanel.add(soLuongPhongLabel);

        soLuongPhongField = createSmallTextField();
        soLuongPhongField.setBounds(startX + labelWidth + 10, startY + 2 * gapY, fieldWidth, fieldHeight);
        leftPanel.add(soLuongPhongField);

        // Trạng Thái
        JLabel trangThaiLabel = new JLabel("Trạng Thái:");
        trangThaiLabel.setBounds(startX, startY + 3 * gapY, labelWidth, fieldHeight);
        leftPanel.add(trangThaiLabel);

        trangThaiComboBox = new JComboBox<>(new String[]{"Đang hoạt động", "Không hoạt động"});
        trangThaiComboBox.setFont(new Font("Arial", Font.PLAIN, 12));
        trangThaiComboBox.setBounds(startX + labelWidth + 10, startY + 3 * gapY, fieldWidth, fieldHeight);
        leftPanel.add(trangThaiComboBox);

        // Ảnh Nhà
        JLabel anhNhaLabel = new JLabel("Ảnh Nhà:");
        anhNhaLabel.setBounds(startX, startY + 4 * gapY, labelWidth, fieldHeight);
        leftPanel.add(anhNhaLabel);

        chonAnhBtn = createButton("Chọn Ảnh");
        chonAnhBtn.setBounds(startX + labelWidth + 10, startY + 4 * gapY, fieldWidth, fieldHeight);
        leftPanel.add(chonAnhBtn);

        // Panel chức năng (cách textfield cuối cùng 80px)
        int buttonStartY = startY + 4 * gapY + fieldHeight + 80;

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        buttonPanel.setBounds(startX, buttonStartY, fieldWidth + labelWidth + 10, fieldHeight + 10);

        themBtn = createBoldButton("Thêm");
        suaBtn = createBoldButton("Sửa");
        xoaBtn = createBoldButton("Xóa");
        lamMoiBtn = createBoldButton("Làm Mới");

        buttonPanel.add(themBtn);
        buttonPanel.add(suaBtn);
        buttonPanel.add(xoaBtn);
        buttonPanel.add(lamMoiBtn);

        leftPanel.add(buttonPanel);

        add(leftPanel, BorderLayout.WEST);

        // Panel danh sách nhà
        danhSachPanel = new JPanel();
        danhSachPanel.setLayout(new GridLayout(0, 3, 10, 10)); // 2 hàng x 3 cột
        danhSachPanel.setBorder(BorderFactory.createTitledBorder("Danh Sách Nhà"));

        HouseFormController controller = new HouseFormController(this);
        controller.init();

        JScrollPane danhSachScrollPane = new JScrollPane(danhSachPanel);
        add(danhSachScrollPane, BorderLayout.CENTER);
    }

    // Tạo JTextField với kích thước nhỏ
    private JTextField createSmallTextField() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 12));
        textField.setPreferredSize(new Dimension(210, 25));
        return textField;
    }

    // Tạo JButton với chữ đậm
    private JButton createBoldButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 12)); // Chữ đậm
        button.setPreferredSize(new Dimension(110,25)); // Tăng chiều rộng để hiển thị đầy đủ chữ
        return button;
    }



    // Tạo JButton mặc định
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 12)); // Chữ đậm
        button.setPreferredSize(new Dimension(110, 25)); // Tạo nút với kích thước phù hợp
        return button;
    }

    // Tạo khung hiển thị thông tin nhà
    // Tạo khung hiển thị thông tin nhà
    public JPanel createNhaPanel(int maNha, String trangThai) {
        JPanel nhaPanel = new JPanel();
        nhaPanel.setLayout(new BorderLayout(5, 5));
        nhaPanel.setBorder(BorderFactory.createTitledBorder(""));
        nhaPanel.setPreferredSize(new Dimension(200, 250));

        // Ảnh giả lập
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setBorder(new LineBorder(Color.BLACK));
        imageLabel.setPreferredSize(new Dimension(150, 120));

        ImageIcon icon = new ImageIcon("D:\\MyProjects\\final_QuanLyNhaTro\\src\\resources\\house_619153.png");
        Image img = icon.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));

        nhaPanel.add(imageLabel, BorderLayout.NORTH);

        // Thông tin chi tiết với khoảng cách 20px giữa các dòng
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS)); // Đặt layout theo chiều dọc

        infoPanel.add(new JLabel("Mã Nhà: " + maNha));
        infoPanel.add(Box.createVerticalStrut(20)); // Khoảng cách 20px
        infoPanel.add(new JLabel("Trạng Thái: " + trangThai));
        chiTietBtn = createDetailButton("Chi Tiết");
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(chiTietBtn);
        //nhaPanel.add(buttonPanel, BorderLayout.SOUTH);

        nhaPanel.add(infoPanel, BorderLayout.CENTER);

        nhaPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                HouseFormController controller = new HouseFormController(HouseForm.this);
                controller.handleClickPanel(e, maNha);
            }
        });

        return nhaPanel;
    }

    private JButton createDetailButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 12)); // Font rõ ràng hơn
        button.setPreferredSize(new Dimension(80, 30)); // Đủ rộng và cao để hiển thị chữ
        return button;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Quản Lý Nhà - Nhà Trọ");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1346, 793);
            frame.add(new HouseForm());
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
