package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GiangVien;

public class GiangVienQuery {
    public static void testConncetion(){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        if(connection != null){
            System.out.println("Thanh cong!");
        }else{
            System.out.println("That bai");
        }
    }
    public List<GiangVien> getAllGiangViens(){
        testConncetion();
        List<GiangVien> giangViens = new ArrayList<GiangVien>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT gv.MaGV,gv.TenGV,CASE WHEN gv.GioiTinh = 1 THEN 'Nam' WHEN gv.GioiTinh = 0 "
                + "THEN N'Nữ' END AS GioiTinh,gv.NgaySinh,gv.Email,gv.SoDT,gv.DiaChi,gv.HocVi, gv.ChucVu, kh.TenKhoa AS TenKhoa\n" +
                "FROM tblGiangVien gv INNER JOIN tblKhoa kh ON gv.idKhoa = kh.MaKhoa";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                GiangVien giangVien = new GiangVien();
                
                giangVien.setMaGV(rs.getString("MaGV"));
                giangVien.setTenGV(rs.getString("TenGV"));
                giangVien.setGioiTinh(rs.getString("GioiTinh"));
                giangVien.setNgaySinh(rs.getString("NgaySinh"));
                giangVien.setEmail(rs.getString("Email"));
                giangVien.setSoDT(rs.getString("SoDT"));
                giangVien.setDiaChi(rs.getString("DiaChi"));
                giangVien.setHocVi(rs.getString("HocVi"));
                giangVien.setChucVu(rs.getString("ChucVu"));
                giangVien.setIdKhoa(rs.getString("TenKhoa"));
                
                giangViens.add(giangVien);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiangVienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return giangViens;
    }
    public GiangVien getGiangVienById(String id){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT gv.MaGV,gv.TenGV,CASE WHEN gv.GioiTinh = 1 THEN 'Nam' WHEN gv.GioiTinh = 0 "
                + "THEN N'Nữ' END AS GioiTinh,gv.NgaySinh,gv.Email,gv.SoDT,gv.DiaChi,gv.HocVi, gv.ChucVu, kh.TenKhoa AS TenKhoa\n" +
                "FROM tblGiangVien gv INNER JOIN tblKhoa kh ON gv.idKhoa = kh.MaKhoa WHERE MaGV=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                GiangVien giangVien = new GiangVien();
                
                giangVien.setMaGV(rs.getString("MaGV"));
                giangVien.setTenGV(rs.getString("TenGV"));
                giangVien.setGioiTinh(rs.getString("GioiTinh"));
                giangVien.setNgaySinh(rs.getString("NgaySinh"));
                giangVien.setEmail(rs.getString("Email"));
                giangVien.setSoDT(rs.getString("SoDT"));
                giangVien.setDiaChi(rs.getString("DiaChi"));
                giangVien.setHocVi(rs.getString("HocVi"));
                giangVien.setChucVu(rs.getString("ChucVu"));
                giangVien.setIdKhoa(rs.getString("TenKhoa"));
                
                return giangVien;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiangVienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void addGiangVien(GiangVien giangVien){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "insert into tblGiangVien(MaGV, TenGV, GioiTinh, NgaySinh, Email, SoDT, DiaChi, HocVi, ChucVu, idKhoa) values(?,?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, giangVien.getMaGV());
            preparedStatement.setString(2, giangVien.getTenGV());
            if(giangVien.getGioiTinh().equals("Nam")){
                preparedStatement.setBoolean(3, true);
            }else{
                preparedStatement.setBoolean(3, false);
            }
            preparedStatement.setString(4, giangVien.getNgaySinh());
            preparedStatement.setString(5, giangVien.getEmail());
            preparedStatement.setString(6, giangVien.getSoDT());
            preparedStatement.setString(7, giangVien.getDiaChi());
            preparedStatement.setString(8, giangVien.getHocVi());
            preparedStatement.setString(9, giangVien.getChucVu());
            preparedStatement.setString(10, giangVien.getIdKhoa());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(GiangVienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void updateGiangVien(GiangVien giangVien){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "update tblGiangVien set TenGV=?, GioiTinh=?, NgaySinh=?, Email=?, SoDT=?, DiaChi=?, HocVi=?, ChucVu=?, idKhoa=? where MaGV=?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, giangVien.getTenGV());
            if(giangVien.getGioiTinh().equals("Nam")){
                preparedStatement.setBoolean(2, true);
            }else{
                preparedStatement.setBoolean(2, false);
            }
            preparedStatement.setString(3, giangVien.getNgaySinh());
            preparedStatement.setString(4, giangVien.getEmail());
            preparedStatement.setString(5, giangVien.getSoDT());
            preparedStatement.setString(6, giangVien.getDiaChi());
            preparedStatement.setString(7, giangVien.getHocVi());
            preparedStatement.setString(8, giangVien.getChucVu());
            preparedStatement.setString(9, giangVien.getIdKhoa());
            preparedStatement.setString(10, giangVien.getMaGV());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(GiangVienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteGiangVien(String id){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "delete from tblGiangVien where MaGV=?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(GiangVienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<GiangVien> searchGiangVien(String tenGV){
        testConncetion();
        List<GiangVien> giangViens = new ArrayList<GiangVien>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT gv.MaGV,gv.TenGV,CASE WHEN gv.GioiTinh = 1 THEN 'Nam' WHEN gv.GioiTinh = 0 "
                + "THEN N'Nữ' END AS GioiTinh,gv.NgaySinh,gv.Email,gv.SoDT,gv.DiaChi,gv.HocVi, gv.ChucVu, kh.TenKhoa AS TenKhoa\n" +
                "FROM tblGiangVien gv INNER JOIN tblKhoa kh ON gv.idKhoa = kh.MaKhoa where gv.TenGV like N'%"+tenGV+"%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                GiangVien giangVien = new GiangVien();
                
                giangVien.setMaGV(rs.getString("MaGV"));
                giangVien.setTenGV(rs.getString("TenGV"));
                giangVien.setGioiTinh(rs.getString("GioiTinh"));
                giangVien.setNgaySinh(rs.getString("NgaySinh"));
                giangVien.setEmail(rs.getString("Email"));
                giangVien.setSoDT(rs.getString("SoDT"));
                giangVien.setDiaChi(rs.getString("DiaChi"));
                giangVien.setHocVi(rs.getString("HocVi"));
                giangVien.setChucVu(rs.getString("ChucVu"));
                giangVien.setIdKhoa(rs.getString("TenKhoa"));
                
                giangViens.add(giangVien);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiangVienQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return giangViens;
    }
}
