package service;

import java.util.List;
import model.SinhVien;
import query.SinhVienQuery;

public class SinhVienService {
    SinhVienQuery sinhVienQuery;
    
    public SinhVienService(){
        sinhVienQuery = new SinhVienQuery();
    }
    public List<SinhVien> getAllSinhViens(){
        return sinhVienQuery.getAllSinhViens();
    }
    public void addSinhVien(SinhVien sinhVien){
        sinhVienQuery.addSinhVien(sinhVien);
    }
    public void deleteSinhVien(String id){
        sinhVienQuery.deleteSinhVien(id);
    }
    public SinhVien getSinhVienById(String id){
        return sinhVienQuery.getSinhVienById(id);
    }
    public void updateSinhVien(SinhVien sinhVien){
        sinhVienQuery.updateSinhVien(sinhVien);
    }
    public List<SinhVien> searchSinhVien(String tenSV){
        return sinhVienQuery.searchGiangVien(tenSV);
    }
}
