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
public class BDTManager {
    public List<BacDaoTao> read(){
        List<BacDaoTao> lstBDT = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tblBacDaoTao";
            Statement stt = JDBCConnection.getJDBCConnection().createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {
                BacDaoTao bdt = new BacDaoTao(rs.getString("MaBDT"), rs.getString("TenBDT"));
                lstBDT.add(bdt);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: "+ex.toString());
            ex.printStackTrace();
        }
        return lstBDT;
    }
}
