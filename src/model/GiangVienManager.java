package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import query.JDBCConnection;

public class GiangVienManager {
    public List<GiangVien> read(){
        List<GiangVien> giangViens = new ArrayList<>();
        try {
            String sql = "SELECT MaGV, TenGV FROM tblGiangVien";
            Statement stt = JDBCConnection.getJDBCConnection().createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {
                GiangVien gv = new GiangVien(rs.getString("MaGV"), rs.getString("TenGV"));
                giangViens.add(gv);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: "+ex.toString());
            ex.printStackTrace();
        }
        return giangViens;
    }
}
