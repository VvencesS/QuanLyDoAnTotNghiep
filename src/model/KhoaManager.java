/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import query.JDBCConnection;

/**
 *
 * @author NgoTheHai
 */
public class KhoaManager {
    public List<Khoa> read(){
        List<Khoa> lstKhoa = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tblKhoa";
            Statement stt = JDBCConnection.getJDBCConnection().createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {
                Khoa k = new Khoa(rs.getString("MaKhoa"), rs.getString("TenKhoa"));
                lstKhoa.add(k);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: "+ex.toString());
            ex.printStackTrace();
        }
        return lstKhoa;
    }
}
