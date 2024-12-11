package com.epu.QuanLyNhaTro.view;

import com.epu.QuanLyNhaTro.dao.*;
import com.epu.QuanLyNhaTro.model.ChuNha;
import com.epu.QuanLyNhaTro.util.Constant;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Setter
@Getter
public class PaymentDetailsForm extends JFrame {
    private JPanel imagePanel;
    private JLabel imageLabel;
    private JLabel amountLabel;
    private JLabel amountValue;
    private JLabel recipientLabel;
    private JLabel recipientValue;
    private JButton confirmButton;

    public PaymentDetailsForm(int maHoaDon) {
        // Tạo frame chính
        JFrame frame = new JFrame("Chi tiết Thanh Toán");
        frame.setSize(600, 700);

        // Thiết lập màu nền cho frame
        Color backgroundColor = new Color(240, 240, 240); // Màu xám nhạt
        frame.getContentPane().setBackground(backgroundColor); // Đặt màu nền của frame
        frame.setLayout(null);

        // Panel chứa hình ảnh
        imagePanel = new JPanel();
        imagePanel.setBackground(backgroundColor); // Đồng bộ màu nền với frame
        imagePanel.setBounds(100, 70, 400, 200); // Cách trên 70px, rộng 400px, cao 200px
        frame.add(imagePanel);

        // Label giả lập hình ảnh
        imageLabel = new JLabel("", SwingConstants.CENTER);
        imageLabel.setForeground(Color.WHITE);
        imageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        ImageIcon icon = new ImageIcon("D:\\MyProjects\\final_QuanLyNhaTro\\src\\resources\\qr_code.png");
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        imageLabel.setIcon(icon);
        imagePanel.add(imageLabel);

        // Label Số tiền
        amountLabel = new JLabel("Số tiền:");
        amountLabel.setBounds(100, 300, 100, 40);
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        frame.add(amountLabel);

        amountValue = new JLabel("............................");
        amountValue.setBounds(250, 300, 250, 40);
        amountValue.setFont(new Font("Arial", Font.PLAIN, 18));
        frame.add(amountValue);

        // Label Người nhận
        recipientLabel = new JLabel("Người nhận:");
        recipientLabel.setBounds(100, 360, 120, 40);
        recipientLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        frame.add(recipientLabel);

        recipientValue = new JLabel("............................");
        recipientValue.setBounds(250, 360, 250, 40);
        recipientValue.setFont(new Font("Arial", Font.PLAIN, 18));
        frame.add(recipientValue);

        // Button Xác nhận
        confirmButton = new JButton("Xác nhận") {
            @Override
            protected void paintComponent(Graphics g) {
                if (!isOpaque()) {
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(new Color(72, 165, 237)); // Màu nền xanh dương nhạt
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Bo góc 20px
                }
                super.paintComponent(g);
            }

            @Override
            public void setOpaque(boolean isOpaque) {
                super.setOpaque(false);
            }
        };
        confirmButton.setBounds(450, 600, 110, 40); // Góc dưới bên trái
        confirmButton.setFont(new Font("Arial", Font.BOLD, 16));
        confirmButton.setForeground(Color.BLACK);
        confirmButton.setContentAreaFilled(false);
        confirmButton.setBorderPainted(false);
        confirmButton.setFocusPainted(false);
        confirmButton.addActionListener(e -> {
            new HoaDonDAOImpl().updateTrangThai(maHoaDon);
            JOptionPane.showMessageDialog(null, "Thanh toán thành công số tiền " + amountValue.getText());
            String txt = "Hóa đơn mã " + maHoaDon + " đã được thanh toán bằng hình thức chuyển khoản";

            new ThanhToanDAOImpl().addThanhToan(maHoaDon, Double.parseDouble(amountValue.getText()), "Chuyển khoản", "Đã thanh toán");
            int maHopDong = new HoaDonDAOImpl().getHoaDon(maHoaDon).getMaHopDong();
            int maPhong = new HopDongDAOImpl().getHopDong(maHopDong).getMaPhong();
            int maChuNha = new PhongDAOImpl().getMaChuNha(maPhong);
            ChuNha chuNha = new ChuNhaDAOImpl().getChuNhaByMa(maChuNha);
            new ThongBaoDAOImpl().addThongBao(Constant.taiKhoan.getMaTaiKhoan(), chuNha.getMaTaiKhoan(), txt, "Chưa xem", maPhong, "ThanhToan");
            frame.dispose();
        });
        frame.add(confirmButton);

        // Hiển thị frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
