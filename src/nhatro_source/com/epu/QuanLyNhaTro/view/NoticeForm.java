package com.epu.QuanLyNhaTro.view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class NoticeForm extends JPanel {
    public NoticeForm() {
        // Thiết lập kích thước và layout cho panel chính
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1346, 793));

        // Tạo panel ở giữa
        JPanel centerPanel = new JPanel();
        centerPanel.setBounds(193, 60, 960, 560); // Dịch lên cách cạnh trên 60px và thay đổi kích thước
        centerPanel.setLayout(null);
        this.add(centerPanel);

        // Tạo label "Thông báo chi tiết"
        JLabel label = new JLabel("Thông báo chi tiết", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 23)); // Thiết lập chữ đậm
        label.setBounds(340, 0, 300, 30); // Đặt label ở giữa
        centerPanel.add(label);

        // Tạo bảng và model dữ liệu
        String[] columnNames = {"STT", "Nội dung", "Seen"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        // Thiết lập chiều cao hàng
        table.setRowHeight(25);

        // Thiết lập chiều rộng cột "STT"
        TableColumn column = table.getColumnModel().getColumn(0);
        column.setPreferredWidth(35);
        column.setMaxWidth(35);
        column.setMinWidth(35);

        // Căn giữa nội dung trong cột "STT"
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        column.setCellRenderer(centerRenderer);

        // Thêm dữ liệu mẫu
        tableModel.addRow(new Object[]{1, "Nội dung 1", true});
        tableModel.addRow(new Object[]{2, "Nội dung 2", false});
        tableModel.addRow(new Object[]{3, "Nội dung 3", true});

        // Thiết lập bảng trong JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 55, 960, 505); // Đặt bảng dưới label, cách 35px và thay đổi kích thước
        centerPanel.add(scrollPane);
    }

    public static void main(String[] args) {
        // Tạo frame chính để hiển thị form
        JFrame frame = new JFrame("Notice Form Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1346, 793);

        // Thêm NoticeForm vào frame
        NoticeForm noticeForm = new NoticeForm();
        frame.add(noticeForm);

        frame.setLocationRelativeTo(null); // Đặt frame ở giữa màn hình
        frame.setVisible(true);
    }
}
