package com.epu.QuanLyNhaTro.view;

import com.epu.QuanLyNhaTro.controller.InvoiceFormController;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Getter
@Setter
public class InvoiceForm extends JPanel{
    private JPanel mainTablePnl;
    private JTable mainTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private JButton searchBtn;

    public InvoiceForm() {
        initComponents();
        new InvoiceFormController(this).init();
    }

    private void initComponents() {
        setSize(1346, 793); // Đặt kích thước form mới
        setLayout(null); // Dùng layout null để đặt các thành phần với kích thước cụ thể

        JPanel mainTablePanel = createMainTablePanel();
        mainTablePanel.setBounds(330, 10, 1000, 700); // Điều chỉnh bảng chi tiết
        add(mainTablePanel);
    }

    private JPanel createMainTablePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Thông tin chi tiết", TitledBorder.CENTER, TitledBorder.TOP));

        // Search Field Panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JLabel searchLabel = new JLabel("Tìm kiếm:");
        searchField = new JTextField(30); // Kéo dài trường tìm kiếm
        searchBtn = new JButton("Tìm");
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);
        panel.add(searchPanel, BorderLayout.NORTH);

        // Table
        String[] columnNames = {"Mã hóa đơn", "Mã Phòng", "Mã Khách", "Tổng Tiền", "Trạng thái", "Ngày Tạo", "Ngày thanh toán"};

        this.tableModel = new DefaultTableModel(columnNames, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        mainTable = new JTable(tableModel);
        mainTable.setRowHeight(30);
        mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        mainTable.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(mainTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1346, 793);
        frame.add(new InvoiceForm());
        frame.setVisible(true);
    }
}
