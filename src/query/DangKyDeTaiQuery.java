package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DangKyDeTai;

public class DangKyDeTaiQuery {
    public List<DangKyDeTai> getAllDangKyDeTais(){
        List<DangKyDeTai> dangKyDeTais = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT sv.TenSV, gv.TenGV, dt.TenDT FROM (((tblDangKDeTai dkdt INNER JOIN tblDeTai dt "
                + "ON dkdt.idDT = dt.MaDT)INNER JOIN tblGiangVien gv ON dkdt.idGV = gv.MaGV)INNER JOIN tblSinhVien sv "
                + "ON dkdt.idSV = sv.MaSV)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                DangKyDeTai dangKyDeTai = new DangKyDeTai();
                
                dangKyDeTai.setTenSV(rs.getString("TenSV"));
                dangKyDeTai.setTenGV(rs.getString("TenGV"));
                dangKyDeTai.setTenDT(rs.getString("TenDT"));
                
                dangKyDeTais.add(dangKyDeTai);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DangKyDeTaiQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dangKyDeTais;
    }
    public DangKyDeTai getDKDTByTenSV(String tenSV){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT sv.TenSV, gv.TenGV, dt.TenDT FROM (((tblDangKDeTai dkdt INNER JOIN tblDeTai dt "
                + "ON dkdt.idDT = dt.MaDT)INNER JOIN tblGiangVien gv ON dkdt.idGV = gv.MaGV)INNER JOIN tblSinhVien sv "
                + "ON dkdt.idSV = sv.MaSV) WHERE sv.TenSV=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tenSV);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                DangKyDeTai dangKyDeTai = new DangKyDeTai();
                
                dangKyDeTai.setTenSV(rs.getString("TenSV"));
                dangKyDeTai.setTenGV(rs.getString("TenGV"));
                dangKyDeTai.setTenDT(rs.getString("TenDT"));
                
                return dangKyDeTai;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DangKyDeTaiQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void addDKDT(DangKyDeTai dangKyDeTai){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "INSERT INTO tblDangKDeTai(idSV, idGV, idDT) VALUES(?,?,?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dangKyDeTai.getTenSV());
            preparedStatement.setString(2, dangKyDeTai.getTenGV());
            preparedStatement.setString(3, dangKyDeTai.getTenDT());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(DangKyDeTaiQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void updateDKDT(DangKyDeTai dangKyDeTai){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "UPDATE tblDangKDeTai set idGV=?, idDT=? WHERE idSV=?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dangKyDeTai.getTenGV());
            preparedStatement.setString(2, dangKyDeTai.getTenDT());
            preparedStatement.setString(3, dangKyDeTai.getTenSV());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(DangKyDeTaiQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteDKDT(String tenSV){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "DELETE FROM tblDangKDeTai WHERE idSV=?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tenSV);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(DangKyDeTaiQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
