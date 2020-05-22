package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.PhanBien;

public class PhanBienQuery {
    public List<PhanBien> getAllPhanBiens(){
        List<PhanBien> phanBiens = new ArrayList<PhanBien>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT dt.TenDT, gv.TenGV, pb.Diem, pb.NhanXet FROM "
                + "((tblPhanBien pb INNER JOIN tblGiangVien gv ON pb.idGV = gv.MaGV) "
                + "INNER JOIN tblDeTai dt ON pb.idDT = dt.MaDT)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                PhanBien phanBien = new PhanBien();
                
                phanBien.setTenDeTai(rs.getString("TenDT"));
                phanBien.setTenGiangVien(rs.getString("TenGV"));
                phanBien.setDiem(rs.getFloat("Diem"));
                phanBien.setNhanXet(rs.getString("NhanXet"));
                
                phanBiens.add(phanBien);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhanBienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return phanBiens;
    }
    public PhanBien getPhanbienByTenDT(String tenDT){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT dt.TenDT, gv.TenGV, pb.Diem, pb.NhanXet FROM "
                + "((tblPhanBien pb INNER JOIN tblGiangVien gv ON pb.idGV = gv.MaGV) "
                + "INNER JOIN tblDeTai dt ON pb.idDT = dt.MaDT) WHERE dt.TenDT=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tenDT);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                PhanBien phanBien = new PhanBien();
                
                phanBien.setTenDeTai(rs.getString("TenDT"));
                phanBien.setTenGiangVien(rs.getString("TenGV"));
                phanBien.setDiem(rs.getFloat("Diem"));
                phanBien.setNhanXet(rs.getString("NhanXet"));
                
                return phanBien;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhanBienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void addPhanBien(PhanBien phanBien){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "INSERT INTO tblPhanBien(idDT, idGV, Diem, NhanXet) VALUES(?,?,?,?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, phanBien.getTenDeTai());
            preparedStatement.setString(2, phanBien.getTenGiangVien());
            preparedStatement.setFloat(3, phanBien.getDiem());
            preparedStatement.setString(4, phanBien.getNhanXet());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(PhanBienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void updatePhanBien(PhanBien phanBien){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "UPDATE tblPhanBien set idGV=?, Diem=?, NhanXet=? WHERE idDT=? ";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, phanBien.getTenGiangVien());
            preparedStatement.setFloat(2, phanBien.getDiem());
            preparedStatement.setString(3, phanBien.getNhanXet());
            preparedStatement.setString(4, phanBien.getTenDeTai());
            
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(PhanBienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deletePhanBien(String tenDT){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "DELETE FROM tblPhanBien WHERE idDT=?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tenDT);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(PhanBienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<PhanBien> searchPhanBien(String tenDT){
        List<PhanBien> phanBiens = new ArrayList<PhanBien>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT dt.TenDT, gv.TenGV, pb.Diem, pb.NhanXet FROM "
                + "((tblPhanBien pb INNER JOIN tblGiangVien gv ON pb.idGV = gv.MaGV) "
                + "INNER JOIN tblDeTai dt ON pb.idDT = dt.MaDT) WHERE dt.TenDT like N'%"+tenDT+"%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                PhanBien phanBien = new PhanBien();
                
                phanBien.setTenDeTai(rs.getString("TenDT"));
                phanBien.setTenGiangVien(rs.getString("TenGV"));
                phanBien.setDiem(rs.getFloat("Diem"));
                phanBien.setNhanXet(rs.getString("NhanXet"));
                
                phanBiens.add(phanBien);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhanBienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return phanBiens;
    }
}
