package com.epu.QuanLyNhaTro.Pack_chua_code_mau_tren_gpt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.TableCellRenderer;

public class RoomListWithStyledUI extends JFrame {

    private JTable roomTable;
    private DefaultTableModel tableModel;

    public RoomListWithStyledUI() {
        setTitle("Danh Sách Phòng Trọ");
        setSize(800, 500);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo bảng và cột
        String[] columnNames = {"ID", "Tên Phòng", "Giá", "Tình Trạng", "Hình Ảnh"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 4) {
                    return ImageIcon.class;
                }
                return String.class;
            }
        };
        roomTable = new JTable(tableModel);
        roomTable.setDefaultEditor(Object.class, null); // Vô hiệu hóa việc sửa tất cả các ô


        // Tùy chỉnh giao diện bảng
        roomTable.setRowHeight(120);
        roomTable.getTableHeader().setBackground(new Color(66, 133, 244));
        roomTable.getTableHeader().setForeground(Color.WHITE);
        roomTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        roomTable.setFont(new Font("Arial", Font.PLAIN, 12));

        // Điều chỉnh chiều rộng cột
        roomTable.getColumnModel().getColumn(0).setPreferredWidth(50); // ID
        roomTable.getColumnModel().getColumn(1).setPreferredWidth(150); // Tên Phòng
        roomTable.getColumnModel().getColumn(2).setPreferredWidth(100); // Giá
        roomTable.getColumnModel().getColumn(3).setPreferredWidth(100); // Tình Trạng
        roomTable.getColumnModel().getColumn(4).setPreferredWidth(120); // Hình ảnh

        // Cuộn bảng
        JScrollPane scrollPane = new JScrollPane(roomTable);

        // Thêm bảng vào form
        add(scrollPane, BorderLayout.CENTER);

        // Thêm dữ liệu mẫu với hình ảnh
        addRoomData("1", "Phòng 101", "3,000,000 VND", "Đang trống", new ImageIcon("path/to/image1.jpg"));
        addRoomData("2", "Phòng 102", "2,500,000 VND", "Đã thuê", new ImageIcon("path/to/image2.jpg"));
        addRoomData("3", "Phòng 103", "4,000,000 VND", "Đang trống", new ImageIcon("path/to/image3.jpg"));

        // Tạo nút Reload (Cập nhật lại thông tin)
        JButton reloadButton = new JButton("Tải lại");
        reloadButton.setBackground(new Color(66, 133, 244));
        reloadButton.setForeground(Color.WHITE);
        reloadButton.setFont(new Font("Arial", Font.BOLD, 12));
        reloadButton.setFocusPainted(false);
        reloadButton.setPreferredSize(new Dimension(100, 35));
        reloadButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Dữ liệu đã được tải lại!"));

        JPanel panel = new JPanel();
        panel.add(reloadButton);
        add(panel, BorderLayout.SOUTH);
    }

    // Phương thức để thêm dữ liệu vào bảng
    public void addRoomData(String id, String name, String price, String status, ImageIcon image) {
        tableModel.addRow(new Object[]{id, name, price, status, image});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RoomListWithStyledUI form = new RoomListWithStyledUI();
            form.setVisible(true);
        });
    }
}
