package com.epu.QuanLyNhaTro.Pack_chua_code_mau_tren_gpt;

import com.epu.QuanLyNhaTro.util.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotificationDemo extends JFrame {
    private JButton btnNotification;
    private JPanel notificationPanel;
    private DefaultListModel<String> notificationListModel;
    private Connection connection = DatabaseConnection.getConnection();
    public NotificationDemo() {
        setTitle("Notification Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Nút thông báo
        btnNotification = new JButton("Thông báo (0)");
        btnNotification.addActionListener(e -> toggleNotificationPanel());
        add(btnNotification, BorderLayout.NORTH);

        // Panel thông báo (ẩn ban đầu)
        notificationPanel = new JPanel(new BorderLayout());
        notificationPanel.setVisible(false);

        notificationListModel = new DefaultListModel<>();
        JList<String> notificationList = new JList<>(notificationListModel);
        notificationPanel.add(new JScrollPane(notificationList), BorderLayout.CENTER);

        add(notificationPanel, BorderLayout.CENTER);

        // Giả sử có thông báo mới
        mockAddNotification("Khách thuê nhà số 101");
        mockAddNotification("Chủ đã tạo hợp đồng cho phòng 101");
    }

    private void toggleNotificationPanel() {
        notificationPanel.setVisible(!notificationPanel.isVisible());
    }

    private void mockAddNotification(String message) {
        notificationListModel.addElement(message);
        updateNotificationCount();
    }

    private void updateNotificationCount() {
        btnNotification.setText("Thông báo (" + notificationListModel.size() + ")");
    }

    public void sendNotification(int senderId, int receiverId, String message) {
        String sql = "INSERT INTO Notification (sender_id, receiver_id, message, created_at, is_read) " +
                "VALUES (?, ?, ?, NOW(), false)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, senderId);
            stmt.setInt(2, receiverId);
            stmt.setString(3, message);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<String> getNotifications(int userId) {
        String sql = "SELECT message FROM Notification WHERE receiver_id = ? AND is_read = false";
        List<String> notifications = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                notifications.add(rs.getString("message"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notifications;
    }
    public void markNotificationsAsRead(int userId) {
        String sql = "UPDATE Notification SET is_read = true WHERE receiver_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NotificationDemo demo = new NotificationDemo();
            demo.setVisible(true);
        });
    }
}
