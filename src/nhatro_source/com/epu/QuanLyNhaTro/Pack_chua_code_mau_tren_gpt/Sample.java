package com.epu.QuanLyNhaTro.Pack_chua_code_mau_tren_gpt;

import com.epu.QuanLyNhaTro.model.Admin;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

public class Sample {
    public void updateAdminColumns(Map<String, Object> columnValues, int maAdmin) throws SQLException {
        StringBuilder sql = new StringBuilder("UPDATE Admin SET ");

        // Tạo câu truy vấn động dựa trên các cột cần cập nhật
        for (String column : columnValues.keySet()) {
            sql.append(column).append(" = ?, ");
        }

        // Xóa dấu phẩy thừa cuối câu
        sql.delete(sql.length() - 2, sql.length());
        sql.append(" WHERE maAdmin = ?");

//        try (PreparedStatement ps = conn.prepareStatement(sql.toString())) {
//            int i = 1;
//            for (Object value : columnValues.values()) {
//                ps.setObject(i++, value); // Thiết lập giá trị tương ứng
//            }
//            ps.setInt(i, maAdmin); // Thiết lập maAdmin
//
//            ps.executeUpdate();
//            conn.commit();
//        }
    }

}

//Admin admin = new Admin("001204034041", "Lê Dũng Tiến", LocalDate.now(), "Nam", "0962004713", "Hà Nội", 1, 20);

