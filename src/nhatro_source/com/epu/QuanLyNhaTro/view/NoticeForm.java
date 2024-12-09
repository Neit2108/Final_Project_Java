package com.epu.QuanLyNhaTro.view;

import com.epu.QuanLyNhaTro.controller.NoticeFormController;
import com.epu.QuanLyNhaTro.dao.ThongBaoDAO;
import com.epu.QuanLyNhaTro.dao.ThongBaoDAOImpl;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

@Getter
@Setter
public class NoticeForm extends JPanel {
    private DefaultTableModel tableModel; // Biến lưu trữ model của bảng
    private JTable table;
    private JButton btnDeleteAll;
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

        // Tạo bảng và model dữ liệu với cột mới "Ngày nhận"
        String[] columnNames = {"ID", "STT", "Nội dung", "Ngày nhận", "Đã xem"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            public boolean isCellEditable(int row, int column) {
                return column == 4 && !(Boolean) getValueAt(row, column);
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 4) {
                    return Boolean.class; // Cột "Đã xem" là kiểu Boolean
                }
                return String.class; // Các cột khác là kiểu String
            }
        };

        table = new JTable(tableModel);
        table.getTableHeader().setReorderingAllowed(false);

        // **Tăng kích thước chữ trong bảng**
        table.setFont(new Font("Arial", Font.PLAIN, 16)); // Kích thước chữ trong bảng
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18)); // Kích thước chữ trong tiêu đề bảng

        // **Tăng chiều cao dòng**
        table.setRowHeight(35); // Chiều cao của từng dòng

        // Thiết lập chiều rộng cột "STT"
        TableColumn columnSTT = table.getColumnModel().getColumn(1);
        columnSTT.setPreferredWidth(50);
        columnSTT.setMaxWidth(50);
        columnSTT.setMinWidth(50);

        // Căn giữa nội dung trong cột "STT"
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        columnSTT.setCellRenderer(centerRenderer);

        // Thiết lập chiều rộng cột "Ngày nhận"
        TableColumn columnDate = table.getColumnModel().getColumn(3);
        columnDate.setPreferredWidth(150);
        columnDate.setMaxWidth(200);
        columnDate.setMinWidth(100);
        columnDate.setCellRenderer(centerRenderer);

        // Thiết lập chiều rộng cột "Đã xem"
        TableColumn columnSeen = table.getColumnModel().getColumn(4);
        columnSeen.setPreferredWidth(80);
        columnSeen.setMaxWidth(80);
        columnSeen.setMinWidth(80);

        //Cot id ẩn
        TableColumn idColumn = table.getColumnModel().getColumn(0);
        idColumn.setMinWidth(0);
        idColumn.setMaxWidth(0);
        idColumn.setPreferredWidth(0);


        // Thiết lập bảng trong JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 55, 960, 505); // Đặt bảng dưới label
        centerPanel.add(scrollPane);

        btnDeleteAll = new JButton("Xóa tất cả");
        btnDeleteAll.setBounds(830, 10, 120, 30);
        centerPanel.add(btnDeleteAll);

        NoticeFormController controller = new NoticeFormController(this);
        controller.init();
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
