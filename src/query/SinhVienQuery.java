package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SinhVien;

public class SinhVienQuery {
    public List<SinhVien> getAllSinhViens(){
        List<SinhVien> sinhViens = new ArrayList<SinhVien>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT sv.MaSV,sv.TenSV,CASE WHEN sv.GioiTinh = 1 THEN 'Nam' WHEN sv.GioiTinh = 0 "
                + "THEN N'Nữ' END AS GioiTinh,sv.NgaySinh,sv.Email,sv.SoDT,sv.DiaChi,l.TenLop, k.Tenkhoa "
                + "FROM ((tblSinhVien sv INNER JOIN tblLop l ON sv.idLop = l.MaLop) "
                + "INNER JOIN tblKhoa k ON sv.idKhoa = k.MaKhoa)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                SinhVien sinhVien = new SinhVien();
                
                sinhVien.setMaSV(rs.getString("MaSV"));
                sinhVien.setTenSV(rs.getString("TenSV"));
                sinhVien.setGioiTinh(rs.getString("GioiTinh"));
                sinhVien.setNgaySinh(rs.getString("NgaySinh"));
                sinhVien.setEmail(rs.getString("Email"));
                sinhVien.setSoDT(rs.getString("SoDT"));
                sinhVien.setDiaChi(rs.getString("DiaChi"));
                sinhVien.setLop(rs.getString("TenLop"));
                sinhVien.setKhoa(rs.getString("TenKhoa"));
                
                sinhViens.add(sinhVien);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sinhViens;
    }
    public SinhVien getSinhVienById(String id){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT sv.MaSV,sv.TenSV,CASE WHEN sv.GioiTinh = 1 THEN 'Nam' WHEN sv.GioiTinh = 0 "
                + "THEN N'Nữ' END AS GioiTinh,sv.NgaySinh,sv.Email,sv.SoDT,sv.DiaChi,l.TenLop, k.Tenkhoa "
                + "FROM ((tblSinhVien sv INNER JOIN tblLop l ON sv.idLop = l.MaLop) "
                + "INNER JOIN tblKhoa k ON sv.idKhoa = k.MaKhoa) WHERE MaSV=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                SinhVien sinhVien = new SinhVien();
                
                sinhVien.setMaSV(rs.getString("MaSV"));
                sinhVien.setTenSV(rs.getString("TenSV"));
                sinhVien.setGioiTinh(rs.getString("GioiTinh"));
                sinhVien.setNgaySinh(rs.getString("NgaySinh"));
                sinhVien.setEmail(rs.getString("Email"));
                sinhVien.setSoDT(rs.getString("SoDT"));
                sinhVien.setDiaChi(rs.getString("DiaChi"));
                sinhVien.setLop(rs.getString("TenLop"));
                sinhVien.setKhoa(rs.getString("TenKhoa"));
                
                return sinhVien;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void addSinhVien(SinhVien sinhVien){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "INSERT INTO tblSinhVien(MaSV, TenSV, GioiTinh, NgaySinh, Email, SoDT, DiaChi, idLop, idKhoa) VALUES(?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sinhVien.getMaSV());
            preparedStatement.setString(2, sinhVien.getTenSV());
            if(sinhVien.getGioiTinh().equals("Nam")){
                preparedStatement.setBoolean(3, true);
            }else{
                preparedStatement.setBoolean(3, false);
            }
            preparedStatement.setString(4, sinhVien.getNgaySinh());
            preparedStatement.setString(5, sinhVien.getEmail());
            preparedStatement.setString(6, sinhVien.getSoDT());
            preparedStatement.setString(7, sinhVien.getDiaChi());
            preparedStatement.setString(8, sinhVien.getLop());
            preparedStatement.setString(9, sinhVien.getKhoa());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void updateSinhVien(SinhVien sinhVien){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "UPDATE tblSinhVien SET TenSV=?, GioiTinh=?, NgaySinh=?, Email=?, SoDT=?, DiaChi=?, idLop=?, idKhoa=? WHERE MaSV=?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sinhVien.getTenSV());
            if(sinhVien.getGioiTinh().equals("Nam")){
                preparedStatement.setBoolean(2, true);
            }else{
                preparedStatement.setBoolean(2, false);
            }
            preparedStatement.setString(3, sinhVien.getNgaySinh());
            preparedStatement.setString(4, sinhVien.getEmail());
            preparedStatement.setString(5, sinhVien.getSoDT());
            preparedStatement.setString(6, sinhVien.getDiaChi());
            preparedStatement.setString(7, sinhVien.getLop());
            preparedStatement.setString(8, sinhVien.getKhoa());
            preparedStatement.setString(9, sinhVien.getMaSV());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteSinhVien(String id){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "DELETE FROM tblSinhVien WHERE MaSV=?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(GiangVienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<SinhVien> searchGiangVien(String tenSV){
        List<SinhVien> sinhViens = new ArrayList<SinhVien>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT sv.MaSV,sv.TenSV,CASE WHEN sv.GioiTinh = 1 THEN 'Nam' WHEN sv.GioiTinh = 0 "
                + "THEN N'Nữ' END AS GioiTinh,sv.NgaySinh,sv.Email,sv.SoDT,sv.DiaChi,l.TenLop, k.Tenkhoa "
                + "FROM ((tblSinhVien sv INNER JOIN tblLop l ON sv.idLop = l.MaLop) "
                + "INNER JOIN tblKhoa k ON sv.idKhoa = k.MaKhoa) WHERE sv.TenSV like N'%"+tenSV+"%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                SinhVien sinhVien = new SinhVien();
                
                sinhVien.setMaSV(rs.getString("MaSV"));
                sinhVien.setTenSV(rs.getString("TenSV"));
                sinhVien.setGioiTinh(rs.getString("GioiTinh"));
                sinhVien.setNgaySinh(rs.getString("NgaySinh"));
                sinhVien.setEmail(rs.getString("Email"));
                sinhVien.setSoDT(rs.getString("SoDT"));
                sinhVien.setDiaChi(rs.getString("DiaChi"));
                sinhVien.setLop(rs.getString("TenLop"));
                sinhVien.setKhoa(rs.getString("TenKhoa"));
                
                sinhViens.add(sinhVien);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiangVienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sinhViens;
    }
}
