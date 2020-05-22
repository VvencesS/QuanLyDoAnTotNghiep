/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import query.JDBCConnection;

/**
 *
 * @author NgoTheHai
 */
public class CRUDLop {

    

    public List<LopHoc> read() {
        List<LopHoc> lstLopHoc = new ArrayList<>();
        
        try {
            String sql = "SELECT l.MaLop,l.TenLop,k.TenKhoa AS TenKhoa,hdt.TenHDT AS TenHDT,"
                    + "bdt.TenBDT AS TenBDT FROM tblLop l INNER JOIN tblKhoa k ON l.idKhoa = k.MaKhoa "
                    + "INNER JOIN tblHeDaoTao hdt ON l.idHDT = hdt.MaHDT "
                    + "INNER JOIN tblBacDaoTao bdt ON l.idBDT = bdt.MaBDT";
            Statement stt = JDBCConnection.getJDBCConnection().createStatement();
            ResultSet rs = stt.executeQuery(sql);

            while (rs.next()) {
                LopHoc lh = new LopHoc(rs.getString("MaLop"), rs.getString("TenLop"), rs.getString("TenKhoa"), rs.getString("TenHDT"), rs.getString("TenBDT"));
                lstLopHoc.add(lh);
                
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.toString());
            ex.printStackTrace();
        }
        return lstLopHoc;
    }

    public boolean insert(LopHoc lh) {
        try {
            String sql = "INSERT INTO tblLop VALUES(?,?,?,?,?)";
            PreparedStatement pStt = JDBCConnection.getJDBCConnection().prepareStatement(sql);
            pStt.setString(1, lh.getMaLop());
            pStt.setString(2, lh.getTenlop());
            pStt.setString(3, lh.getMaKhoa());
            pStt.setString(4, lh.getMaHDT());
            pStt.setString(5, lh.getMaBDT());
            int row = pStt.executeUpdate();

            return row > 0;

        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.toString());
            ex.printStackTrace();
            return false;
        }
    }

    public boolean update(LopHoc lh) {
        try {
            String sql = "UPDATE tblLop SET TenLop = ?, idKhoa = ?, idHDT = ?, idBDT = ? WHERE MaLop = ?";
            PreparedStatement pStt = JDBCConnection.getJDBCConnection().prepareStatement(sql);
            pStt.setString(1, lh.getTenlop());
            pStt.setString(2, lh.getMaKhoa());
            pStt.setString(3, lh.getMaHDT());
            pStt.setString(4, lh.getMaBDT());
            pStt.setString(5, lh.getMaLop());
            int row = pStt.executeUpdate();

            return row > 0;
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.toString());
            ex.printStackTrace();
            return false;
        }
    }

    public boolean delete(String maLop) {
        try {
            String sql = "DELETE FROM tblLop WHERE MaLop = ?";
            PreparedStatement pStt = JDBCConnection.getJDBCConnection().prepareStatement(sql);
            pStt.setString(1, maLop);
            
            int row = pStt.executeUpdate();
            
            return row > 0;
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.toString());
            ex.printStackTrace();
            return false;
        }
    }
    public LopHoc getClassById(String id){
        try {
            String sql = "SELECT l.MaLop,l.TenLop,k.TenKhoa AS TenKhoa,hdt.TenHDT AS TenHDT,"
                    + "bdt.TenBDT AS TenBDT FROM tblLop l INNER JOIN tblKhoa k ON l.idKhoa = k.MaKhoa "
                    + "INNER JOIN tblHeDaoTao hdt ON l.idHDT = hdt.MaHDT "
                    + "INNER JOIN tblBacDaoTao bdt ON l.idBDT = bdt.MaBDT WHERE MaLop = ?";
            PreparedStatement pStt = JDBCConnection.getJDBCConnection().prepareStatement(sql);
            pStt.setString(1, id);
            ResultSet rs = pStt.executeQuery();

            while (rs.next()) {
                LopHoc lh = new LopHoc(rs.getString("MaLop"), 
                        rs.getString("TenLop"), rs.getString("TenKhoa"),
                        rs.getString("TenHDT"), rs.getString("TenBDT"));
                return lh;
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.toString());
            ex.printStackTrace();
        }
        return null;
    }
}
