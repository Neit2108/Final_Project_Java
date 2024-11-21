package com.epu.QuanLyNhaTro.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BillForm extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;

    public BillForm() {
        initComponents();
    }

    private void initComponents() {
        setSize(1346, 793); // Đặt kích thước của panel chính
        setLayout(new GridBagLayout()); // Sử dụng GridBagLayout để căn giữa bảng

        // Tạo panel chứa bảng
        JPanel tablePanel = createTablePanel();

        // Thêm panel bảng vào giao diện, căn giữa
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(tablePanel, gbc);
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "Danh sách hóa đơn",
                TitledBorder.CENTER,
                TitledBorder.TOP
        ));

        // Tạo cột cho bảng
        String[] columnNames = {"Mã hóa đơn", "Mã phòng", "Mã khách", "Tổng tiền", "Ngày tạo", "Trạng thái"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa bất kỳ ô nào trong bảng
            }
        };

        // Tạo bảng
        table = new JTable(tableModel);
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.getTableHeader().setReorderingAllowed(false); // Không cho phép kéo thả tiêu đề cột

        // Thêm bảng vào JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Thiết lập kích thước cố định cho bảng
        scrollPane.setPreferredSize(new Dimension(1050, 550));

        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Quản lý Hóa đơn");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1346, 793); // Kích thước của cửa sổ
            frame.add(new BillForm()); // Thêm form vào frame
            frame.setVisible(true);
        });
    }
}
