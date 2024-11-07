package com.epu.QuanLyNhaTro.util;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;
import java.util.Random;

public class EmailVerification {
    private final String senderEmail;
    private final String senderPassword;
    private final String smtpHost;
    private final int smtpPort;

    public EmailVerification() {
        this.senderEmail = Constant.senderMail;
        this.senderPassword = Constant.senderPass;
        this.smtpHost = "smtp.gmail.com"; // Thay đổi nếu cần
        this.smtpPort = 587; // Cổng SMTP
    }

    private String generateVerificationCode() {
        // Tao ma xac thuc
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000));
    }

    public String sendVerificationEmail(String recipientEmail) {
        // Tạo mã xác thực ngẫu nhiên
        String verificationCode = generateVerificationCode();

        // thông tin  email
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);

        // Tạo một phiên làm việc
        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Tạo một đối tượng Message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Mã xác thực đăng ký");
            message.setText("Mã xác thực của bạn là: " + verificationCode);

            // Gửi email
            Transport.send(message);
            System.out.println("Email gửi thành công đến: " + recipientEmail);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Lỗi: " +e.getMessage());
        }

        return verificationCode; // Trả về mã xác thực
    }
}
