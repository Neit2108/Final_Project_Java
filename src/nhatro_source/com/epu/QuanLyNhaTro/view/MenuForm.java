package com.epu.QuanLyNhaTro.view;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class MenuForm extends JFrame {
    private JButton homePageBtn;
    private JButton dangxuatBtn;
    private JButton quanlyBtn;
    private JButton hopdongBtn;
    private JButton nhaBtn;
    private JButton pctBtn;
    private JButton hoadonBtn;
    private JButton thongbaoBtn;
    private JPanel buttonPanel;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JLabel circularLabel;

    public MenuForm() {
        homePageBtn = createRoundedButton("Trang chủ");
        pctBtn = createRoundedButton("Quản lý phòng");
        nhaBtn = createRoundedButton("Nhà");
        hopdongBtn = createRoundedButton("Hợp Đồng");
        quanlyBtn = createRoundedButton("Quản Lý Khách Thuê");
        hoadonBtn = createRoundedButton("Hóa đơn");
        thongbaoBtn = createRoundedButton("Thông báo");
        dangxuatBtn = createRoundedButton("Đăng Xuất");

        dangxuatBtn.setPreferredSize(new Dimension(75, 30));
        dangxuatBtn.setMaximumSize(new Dimension(75, 30));

        dangxuatBtn.setFont(new Font("Arial", Font.BOLD, 10));

        JLabel menuLabel = new JLabel("Menu", SwingConstants.CENTER);
        menuLabel.setFont(new Font("Arial", Font.BOLD, 20));
        menuLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        circularLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(getBackground());
                g2d.fillOval(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        circularLabel.setPreferredSize(new Dimension(40, 40));
        circularLabel.setMaximumSize(new Dimension(40, 40));
        circularLabel.setOpaque(false);
        circularLabel.setHorizontalAlignment(SwingConstants.CENTER);
        circularLabel.setVerticalAlignment(SwingConstants.CENTER);

        ImageIcon userIcon = new ImageIcon("src/resources/user_icon.png");
        Image scaledImage = userIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        circularLabel.setIcon(new ImageIcon(scaledImage));


        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding around the panel
        buttonPanel.setBackground(new Color(240, 248, 255));

        buttonPanel.add(menuLabel);
        buttonPanel.add(Box.createVerticalStrut(25));
        buttonPanel.add(homePageBtn);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(pctBtn);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(nhaBtn);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(hopdongBtn);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(quanlyBtn);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(hoadonBtn);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(thongbaoBtn);
        buttonPanel.add(Box.createVerticalStrut(85));
        JPanel circularPanel = new JPanel();
        circularPanel.setLayout(new BoxLayout(circularPanel, BoxLayout.X_AXIS));
        circularPanel.add(Box.createHorizontalGlue());
        circularPanel.add(circularLabel);
        circularPanel.add(Box.createHorizontalGlue());
        circularPanel.setOpaque(false);

        buttonPanel.add(Box.createVerticalGlue()); // Đẩy phần tử ở trên lên
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));
        userPanel.setOpaque(false);

        circularLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        userPanel.add(circularLabel);
        userPanel.add(Box.createVerticalStrut(10)); // Khoảng cách giữa icon và nút

        dangxuatBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        userPanel.add(dangxuatBtn);

        buttonPanel.add(userPanel);


        mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);
        TenantManagement tenantManagement = new TenantManagement();
        QuanLyPhongForm qlpf = new QuanLyPhongForm();
        NewHomePage newhome = new NewHomePage();
        ContractForm contractForm = new ContractForm();
        InvoiceForm invoiceForm = new InvoiceForm();
        HouseForm houseForm = new HouseForm();
        NoticeForm noticeForm = new NoticeForm();

        mainPanel.add(newhome, "HomePage");
        mainPanel.add(tenantManagement, "QuanLyKhachThue");
        mainPanel.add(qlpf, "QuanLyPhong");
        mainPanel.add(contractForm, "HopDong");
        mainPanel.add(invoiceForm, "HoaDon");
        mainPanel.add(houseForm, "Nha");
        mainPanel.add(noticeForm, "ThongBao");
        //init controller
        new com.epu.QuanLyNhaTro.controller.MenuFormController(this).init();


        setTitle("Menu Form");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JButton createRoundedButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(135, 206, 250)); // Light sky blue color for the button background
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // Rounded corners
                super.paintComponent(g2);
                g2.dispose();
            }

            @Override
            public void setContentAreaFilled(boolean b) {
                // Override to prevent default button filling
            }
        };

        button.setFocusPainted(false); // Remove focus border on click
        button.setForeground(Color.BLACK); // Set text color to black
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setPreferredSize(new Dimension(150, 60)); // Original width with taller height
        button.setMaximumSize(new Dimension(150, 60)); // Set fixed width and height for all buttons
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Inner padding for text

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuForm form = new MenuForm();
            form.setVisible(true);
            SwingUtilities.invokeLater(() -> {
                System.out.println("MainPanel Size: " + form.mainPanel.getSize());
            });
        });
    }
}
