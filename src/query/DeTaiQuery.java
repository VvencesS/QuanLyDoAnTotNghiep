package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DeTai;

public class DeTaiQuery {
    public List<DeTai> getAllDeTais(){
        List<DeTai> deTais = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM tblDeTai";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                DeTai deTai = new DeTai();
                
                deTai.setMaDT(rs.getString("MaDT"));
                deTai.setTenDT(rs.getString("TenDT"));
                deTai.setSoSV(rs.getInt("SoSV"));
                deTai.setNam(rs.getInt("Nam"));
                
                deTais.add(deTai);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DeTaiQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deTais;
    }
    public DeTai getDeTaiByMaDT(String maDT){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM tblDeTai WHERE MaDT=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maDT);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                DeTai deTai = new DeTai();
                
                deTai.setMaDT(rs.getString("MaDT"));
                deTai.setTenDT(rs.getString("TenDT"));
                deTai.setSoSV(rs.getInt("SoSV"));
                deTai.setNam(rs.getInt("Nam"));
                
                return deTai;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DeTaiQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void addDeTai(DeTai deTai){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "INSERT INTO tblDeTai(MaDT, TenDT, SoSV, Nam) VALUES(?,?,?,?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, deTai.getMaDT());
            preparedStatement.setString(2, deTai.getTenDT());
            preparedStatement.setInt(3, deTai.getSoSV());
            preparedStatement.setInt(4, deTai.getNam());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(DeTaiQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void updateDeTai(DeTai deTai){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "UPDATE tblDeTai set TenDT=?, SoSV=?, Nam=? WHERE MaDT=?  ";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, deTai.getTenDT());
            preparedStatement.setFloat(2, deTai.getSoSV());
            preparedStatement.setFloat(3, deTai.getNam());
            preparedStatement.setString(4, deTai.getMaDT());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(DeTaiQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteDeTai(String maDt){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "DELETE FROM tblDeTai WHERE MaDT=?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maDt);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(DeTaiQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<DeTai> searchDeTai(String maDT){
        List<DeTai> deTais = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM tblDeTai WHERE MaDT like N'%"+maDT+"%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                DeTai deTai = new DeTai();
                
                deTai.setMaDT(rs.getString("MaDT"));
                deTai.setTenDT(rs.getString("TenDT"));
                deTai.setSoSV(rs.getInt("SoSV"));
                deTai.setNam(rs.getInt("Nam"));
                
                deTais.add(deTai);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DeTaiQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deTais;
    }
}
