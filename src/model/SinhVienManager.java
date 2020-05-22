package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import query.JDBCConnection;

public class SinhVienManager {
    public List<SinhVien> read(){
        List<SinhVien> sinhViens = new ArrayList<>();
        try {
            String sql = "SELECT MaSV, TenSV FROM tblSinhVien";
            Statement stt = JDBCConnection.getJDBCConnection().createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getString("MaSV"), rs.getString("TenSV"));
                sinhViens.add(sv);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: "+ex.toString());
            ex.printStackTrace();
        }
        return sinhViens;
    }
}
