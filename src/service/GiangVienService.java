package service;

import java.util.List;
import model.GiangVien;
import query.GiangVienQuery;

public class GiangVienService {
    private GiangVienQuery giangVienQuery;
    
    public GiangVienService(){
        giangVienQuery = new GiangVienQuery();
    }
    public List<GiangVien> getAllGiangViens(){
        return giangVienQuery.getAllGiangViens();
    }
    public void addGiangVien(GiangVien giangVien){
        giangVienQuery.addGiangVien(giangVien);
    }
    public void deleteGiangVien(String id){
        giangVienQuery.deleteGiangVien(id);
    }
    public GiangVien getGiangVienById(String id){
        return giangVienQuery.getGiangVienById(id);
    }
    public void updateGiangVien(GiangVien giangVien){
        giangVienQuery.updateGiangVien(giangVien);
    }
    public List<GiangVien> searchGiangVien(String tenGV){
        return giangVienQuery.searchGiangVien(tenGV);
    }
}
