package com.epu.QuanLyNhaTro.view;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Setter
@Getter
public class DetailRoom extends JFrame {
    private JPanel MainPnl;
    private JPanel imagePnl;
    private JPanel detailPnl;
    private JList detailServiceList;
    private JTable table1;
    private JPanel pricePnl;
    private JPanel servicePnl;
    private JPanel serviceList;
    private JScrollPane scrollPriceTbl;
    private JPanel priceTblPnl;
    private JLabel imageLbl;
    private JLabel serviceLbl1;
    private JLabel serviceLbl2;
    private JLabel serviceLbl3;
    private JLabel serviceLbl4;
    private JLabel serviceLbl5;
    private JLabel serviceLbl6;
    private JLabel serviceLbl7;
    private JLabel serviceLbl8;
    private JScrollPane scrollServiceList;
    private DefaultTableModel tableModel;
    public DetailRoom() {
        setContentPane(MainPnl);
        setTitle("Chi tiết phòng");
        setSize(1000, 600);
        setLocationRelativeTo(null);

        // Bảng giá
        String[] column = {"", ""};
        Object[][] data = {
                {"Hợp đồng", "Đóng 1 cọc 1"},
                {"Diện tích", "25 (m2)"},
                {"Tiền phòng", "1000000 (tháng)"},
                {"Tiền điện", "4000 (số)"},
                {"Tiền nước", "100000 (người)"},
                {"Tiền vệ sinh", "10000 (người)"},
                {"Tiền thang máy", "50000 (người)"},
                {"Tiền wifi", "50000 (người)"},
                {"Tiền giữ xe", "50000 (người)"},
        };

        tableModel = new DefaultTableModel(column, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (Object[] row : data) {
            tableModel.addRow(row);
        }

        table1.setModel(tableModel);
        table1.getTableHeader().setReorderingAllowed(false);
        table1.setRowHeight(30);
        table1.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table1.getTableHeader().setBackground(new Color(70, 130, 180));
        table1.getTableHeader().setForeground(Color.WHITE);
        table1.setFont(new Font("Arial", Font.PLAIN, 12));
        scrollPriceTbl.setPreferredSize(new Dimension(300, 100));
        priceTblPnl.setPreferredSize(new Dimension(250, 100));
        // Ảnh
        imageLbl.setHorizontalAlignment(SwingConstants.CENTER);
        imageLbl.setVerticalAlignment(SwingConstants.CENTER);
        imageLbl.setBorder(BorderFactory.createLineBorder(Color.GRAY));


        imagePnl.setBackground(Color.WHITE);
        detailPnl.setBackground(new Color(240, 240, 240));
        pricePnl.setBackground(new Color(230, 230, 250));
        servicePnl.setBackground(new Color(245, 245, 245));

        TitledBorder tableBorder = BorderFactory.createTitledBorder("Thông tin phòng");
        tableBorder.setTitleFont(new Font("Arial", Font.BOLD, 14));
        scrollPriceTbl.setBorder(tableBorder);

        // Dich vu
        JLabel[] serviceLabels = {serviceLbl1, serviceLbl2, serviceLbl3, serviceLbl4, serviceLbl5, serviceLbl6, serviceLbl7, serviceLbl8};
        for (JLabel lbl : serviceLabels) {
            lbl.setFont(new Font("Arial", Font.BOLD, 14));
            lbl.setForeground(new Color(105, 105, 105));
            lbl.setHorizontalAlignment(SwingConstants.CENTER);
        }

        // Danh sách dịch vụ
        scrollServiceList.setPreferredSize(new Dimension(300, 400));
        TitledBorder border = BorderFactory.createTitledBorder("Danh sách dịch vụ");
        border.setTitleFont(new Font("Arial", Font.BOLD, 14));
        scrollServiceList.setBorder(border);

        detailServiceList.setFont(new Font("Arial", Font.PLAIN, 14));
        detailServiceList.setBackground(new Color(245, 245, 245));
        serviceList.setPreferredSize(new Dimension(600, 400));


        // Cài đặt Look and Feel
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }



    public static void main(String[] args) {
        new DetailRoom().setVisible(true);
    }
}
