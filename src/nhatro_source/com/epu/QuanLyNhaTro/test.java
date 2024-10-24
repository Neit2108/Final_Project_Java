package com.epu.QuanLyNhaTro;

import com.epu.QuanLyNhaTro.dao.AdminDAO;
import com.epu.QuanLyNhaTro.dao.AdminDAOImpl;
import com.epu.QuanLyNhaTro.dao.TaiKhoanDAO;
import com.epu.QuanLyNhaTro.dao.TaiKhoanDAOImpl;
import com.epu.QuanLyNhaTro.model.Admin;
import com.epu.QuanLyNhaTro.model.ChuNha;
import com.epu.QuanLyNhaTro.model.TaiKhoan;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class test {
    public static void main(String[] args) throws SQLException {
        //AdminDAO ad = new AdminDAOImpl();
        //Admin admin = new Admin("001204034041", "Lê Dũng Tiến", LocalDate.now(), "Nam", "0962004713", "Hà Nội", 1, 20);
        //ad.updateAdmin("123456789030", "Lê Dũng Tiến", LocalDate.now(), "Nam", "0962004713", "Hà Nội", 19, 19);
        AdminDAO adminDAO = new AdminDAOImpl();
        Admin admin = adminDAO.getAdmin("123456789030");
        System.out.println(admin);
    }
}
