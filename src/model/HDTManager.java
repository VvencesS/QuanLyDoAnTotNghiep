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
import query.JDBCConnection;

/**
 *
 * @author NgoTheHai
 */
public class HDTManager {
    public List<HeDaoTao> read(){
        List<HeDaoTao> lstHDT = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tblHeDaoTao";
            Statement stt = JDBCConnection.getJDBCConnection().createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {
                HeDaoTao hdt = new HeDaoTao(rs.getString("MaHDT"), rs.getString("TenHDT"));
                lstHDT.add(hdt);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: "+ex.toString());
            ex.printStackTrace();
        }
        return lstHDT;
    }
}
