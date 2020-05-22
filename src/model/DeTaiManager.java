package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import query.JDBCConnection;

public class DeTaiManager {
    public List<DeTai> read(){
        List<DeTai> deTais = new ArrayList<>();
        try {
            String sql = "SELECT MaDT, TenDT FROM tblDeTai";
            Statement stt = JDBCConnection.getJDBCConnection().createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {
                DeTai dt = new DeTai(rs.getString("MaDT"), rs.getString("TenDT"));
                deTais.add(dt);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: "+ex.toString());
            ex.printStackTrace();
        }
        return deTais;
    }
}
